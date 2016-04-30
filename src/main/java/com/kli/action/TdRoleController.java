package com.kli.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.kli.bean.BaseMsg;
import com.kli.bean.TdMenu;
import com.kli.bean.Page;
import com.kli.bean.TdPermissions;
import com.kli.bean.TdRole;
import com.kli.bean.TdRolePerm;
import com.kli.constants.BaseConstants;
import com.kli.service.TdMenuService;
import com.kli.service.TdPermissionsService;
import com.kli.service.TdRoleService;
import com.kli.tools.StringUtil;
/**
 * 
 * <br>
 * <b>功能：</b>TdRoleController<br>
 *   <br>
 */ 
@Controller
public class TdRoleController extends BaseController{
	
	@Autowired(required=false) 
	private TdRoleService tdRoleService; 
	
	@Resource
	private TdMenuService tdMenuService;
	
	@Resource
	private TdPermissionsService tdPermissionsService; 
	
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/admin/roleList") 
	public ModelAndView  list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Long categoryId = StringUtil.longValue(
				request.getParameter("categoryId"), -1L);
		int roleId = StringUtil.intValue(request.getParameter("roleId"), -1);
		String roleName = StringUtil.stringValue(
				request.getParameter("roleName"), "");
		String permissions = StringUtil.stringValue(
				request.getParameter("permissions"), "");
		
		
		
		Integer pageNum = StringUtil.integerValue(request.getParameter("pageNum"), 1);
		Page<TdRole> page = new Page<TdRole>(pageNum, 5);
		ModelAndView model = new ModelAndView("admin/role/roleList");
		
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		model.addObject("category", category);
		
		TdRole role = new TdRole();
		if(roleId > -1){
			role.setId(roleId);
			model.addObject("roleId", roleId);
		}
		
		if(!StringUtil.isBlank(roleName)){
			role.setRoleName(roleName);
			model.addObject("roleName", roleName);
		}
		if(!StringUtil.isBlank(permissions)){
			role.setPermissions(permissions);
			model.addObject("permissions", permissions);
		}		
		
		model.addObject("page", tdRoleService.findPage(page, role));
		return model; 
	}
	
	@RequestMapping(value="admin/roleAddView")
	public ModelAndView toAddView(@RequestParam("categoryId") Long categoryId){
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		
		List<TdPermissions> permList = tdPermissionsService.findList(new TdPermissions());
		
		ModelAndView model = new ModelAndView("admin/role/roleAdd");
		model.addObject("category", category);
		model.addObject("permList", permList);
		return model;
	}
	
	@RequestMapping(value="admin/roleEditView")
	public ModelAndView toEditView(HttpServletRequest request){
		return getModelAndView(request, "admin/role/roleEdit");
	}
	
	
	@RequestMapping(value="admin/roleAdd")
	@ResponseBody
	public String rolePublish(@ModelAttribute TdRole role,HttpServletRequest request){
		BaseMsg msg = new BaseMsg();

		Long categoryId = Long.parseLong(request.getParameter("categoryId"));
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		
		java.util.Date date =new java.util.Date();
		role.setCreateTime(date);
		role.setUpdateTime(date);
		Integer type = tdRoleService.insert(role);
		if(!type.equals(0)){
			this.addPermsToRole(request, role.getId());
			msg.setRtnCode(BaseConstants.ResultCode.SUCCESS);
			msg.setMsg("添加"+category.getMenuName()+"成功！");
			return JSON.toJSONString(msg);
		}else{
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("添加"+category.getMenuName()+"失败，请联系管理员！");
			return JSON.toJSONString(msg);
		}
	}
	
	@RequestMapping(value="admin/roleEdit")
	@ResponseBody
	public String permEdit(@ModelAttribute TdRole role,HttpServletRequest request){
		BaseMsg msg = new BaseMsg();
		
		TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
		role.setUpdateTime(new java.util.Date());
		Integer type = tdRoleService.updateBySelective(role);
		if(!type.equals(0)){
			this.addPermsToRole(request, role.getId());
			msg.setRtnCode(BaseConstants.ResultCode.SUCCESS);
			msg.setMsg("修改"+category.getMenuName()+"成功！");
			return JSON.toJSONString(msg);
		}else{
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("修改"+category.getMenuName()+"失败，请联系管理员！");
			return JSON.toJSONString(msg);
		}
	}
	
	@RequestMapping(value="admin/roleAddOk")
	public ModelAndView permAddOk(HttpServletRequest request){

		TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
		ModelAndView model = new ModelAndView("admin/role/addsucess");
		model.addObject("category", category);
		return model;
	}
	
	
	@RequestMapping(value="admin/roleDel")
	@ResponseBody
	public String roleDel(HttpServletRequest request) {
		int roleId;
		BaseMsg msg = new BaseMsg();
		if (!StringUtil.isEmpty(request.getParameter("roleId"))) {
			roleId = Integer.parseInt(request.getParameter("roleId"));
		} else {
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("处理失败，无法获取ID，请查看是否传入正确的ID！");
			return JSON.toJSONString(msg);
		}
		Integer type = 0;
		try {
			TdRole role = new TdRole();
			role.setId(roleId);
			type = tdRoleService.delete(role);
		} catch (Exception e) {
			// throw new GelinException(e);
		}
		if (!type.equals(0)) {
			tdRoleService.deleteRolePerms(roleId);
			msg.setRtnCode(BaseConstants.ResultCode.SUCCESS);
			msg.setMsg("删除成功！");
			return JSON.toJSONString(msg);
		} else {
			log.debug("##删除失败！##");
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("删除失败，请联系管理员！");
			return JSON.toJSONString(msg);
		}
	}
	
	private ModelAndView getModelAndView(HttpServletRequest request, String resView){
		String categoryId = request.getParameter("categoryId");
		String roleId = request.getParameter("roleId");
		ModelAndView model = new ModelAndView(resView);
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		
		List<TdPermissions> allPermList = tdPermissionsService.findList(new TdPermissions());
		List<TdPermissions> hasPermList = tdPermissionsService.findListByRoleId(Integer.parseInt(roleId));
		
		TdRole r = new TdRole();
		r.setId(Integer.parseInt(roleId));

		model.addObject("category", category);
		model.addObject("role", tdRoleService.get(r));
		model.addObject("allPermList", allPermList);
		model.addObject("hasPermList", hasPermList);
		return model;
	}
	
	public void addPermsToRole(HttpServletRequest request, int roleId){
		List<TdPermissions> permList = tdPermissionsService.findList(new TdPermissions());
		tdRoleService.deleteRolePerms(roleId);
		TdRolePerm rp = null;
		for(TdPermissions permissions : permList){
			String enable = request.getParameter("perm_" + permissions.getId());
			if(enable!=null && !"".equals(enable)){
				rp = new TdRolePerm();
				rp.setRoleId(roleId);
				rp.setPermId(permissions.getId());
				rp.setPermType(permissions.getPermType());
				tdRoleService.insertRolePerms(rp);
			}
			
		}
		
		
	}
}
