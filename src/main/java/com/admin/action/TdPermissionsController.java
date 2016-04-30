package com.admin.action;

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
import com.admin.bean.BaseMsg;
import com.admin.bean.Page;
import com.admin.bean.TdMenu;
import com.admin.bean.TdPermissions;
import com.admin.constants.BaseConstants;
import com.admin.service.TdMenuService;
import com.admin.service.TdPermissionsService;
import com.admin.tools.StringUtil;
/**
 * 
 * <br>
 * <b>功能：</b>TdPermissionsController<br>
 *   <br>
 */ 
@Controller
public class TdPermissionsController extends BaseController{
	
	@Autowired(required=false) 
	private TdPermissionsService tdPermissionsService; 
	
	@Resource
	private TdMenuService tdMenuService;
	
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/admin/permList") 
	public ModelAndView  list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Long categoryId = StringUtil.longValue(
				request.getParameter("categoryId"), -1L);
		int permId = StringUtil.intValue(request.getParameter("permId"), -1);
		String permName = StringUtil.stringValue(
				request.getParameter("permName"), "");
		String permType = StringUtil.stringValue(
				request.getParameter("permType"), "");
		
		
		
		Integer pageNum = StringUtil.integerValue(request.getParameter("pageNum"), 1);
		Page<TdPermissions> page = new Page<TdPermissions>(pageNum, 10);
		ModelAndView model = new ModelAndView("admin/permission/permList");
		
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		model.addObject("category", category);
		
		TdPermissions perm = new TdPermissions();
		if(permId > -1){
			perm.setId(permId);
			model.addObject("permId", permId);
		}
		
		if(!StringUtil.isBlank(permName)){
			perm.setPermName(permName);
			model.addObject("permName", permName);
		}
		if(!StringUtil.isBlank(permType)){
			perm.setPermType(permType);
			model.addObject("permType", permType);
		}		
		
		model.addObject("page", tdPermissionsService.findPage(page, perm));
		return model; 
	}
	
	@RequestMapping(value="admin/permAddView")
	public ModelAndView toAddView(@RequestParam("categoryId") Long categoryId){
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		ModelAndView model = new ModelAndView("admin/permission/permAdd");
		model.addObject("category", category);
		return model;
	}
	
	@RequestMapping(value="admin/permEditView")
	public ModelAndView toEditView(HttpServletRequest request){
		return getModelAndView(request, "admin/permission/permEdit");
	}
	
	
	@RequestMapping(value="admin/permAdd")
	@ResponseBody
	public String permPublish(@ModelAttribute TdPermissions permission,HttpServletRequest request){
		BaseMsg msg = new BaseMsg();

		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		
		java.util.Date date =new java.util.Date();
		permission.setCreateTime(date);
		permission.setUpdateTime(date);
		Integer type = tdPermissionsService.insert(permission);
		if(!type.equals(0)){

			msg.setRtnCode(BaseConstants.ResultCode.SUCCESS);
			msg.setMsg("添加"+category.getMenuName()+"成功！");
			return JSON.toJSONString(msg);
		}else{
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("添加"+category.getMenuName()+"失败，请联系管理员！");
			return JSON.toJSONString(msg);
		}
	}
	
	@RequestMapping(value="admin/permEdit")
	@ResponseBody
	public String permEdit(@ModelAttribute TdPermissions permission,HttpServletRequest request){
		BaseMsg msg = new BaseMsg();
		
		TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
		log.debug("##修改"+category.getMenuName()+"开始##");
		
		permission.setUpdateTime(new java.util.Date());
		Integer type = tdPermissionsService.updateBySelective(permission);
		if(!type.equals(0)){
			msg.setRtnCode(BaseConstants.ResultCode.SUCCESS);
			msg.setMsg("修改"+category.getMenuName()+"成功！");
			return JSON.toJSONString(msg);
		}else{
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("修改"+category.getMenuName()+"失败，请联系管理员！");
			return JSON.toJSONString(msg);
		}
	}
	
	@RequestMapping(value="admin/permAddOk")
	public ModelAndView permAddOk(HttpServletRequest request){

		TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
		ModelAndView model = new ModelAndView("admin/permission/addsucess");
		model.addObject("category", category);
		return model;
	}
	
	
	@RequestMapping(value="admin/permDel")
	@ResponseBody
	public String permDel(HttpServletRequest request) {
		int permId;
		BaseMsg msg = new BaseMsg();
		if (!StringUtil.isEmpty(request.getParameter("permId"))) {
			permId = Integer.parseInt(request.getParameter("permId"));
		} else {
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("处理失败，无法获取ID，请查看是否传入正确的ID！");
			return JSON.toJSONString(msg);
		}
		Integer type = 0;
		TdPermissions permission = new TdPermissions();
		permission.setId(permId);
		try {

			type = tdPermissionsService.delete(permission);
		} catch (Exception e) {
			// throw new GelinException(e);
		}
		if (!type.equals(0)) {
			tdPermissionsService.deleteRolePerms(permId);
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
		String permId = request.getParameter("permId");
		ModelAndView model = new ModelAndView(resView);
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		TdPermissions permission = new TdPermissions();
		permission.setId(Integer.valueOf(permId));
		model.addObject("perm", tdPermissionsService.get(permission));
		model.addObject("category", category);
		
		return model;
	}
	

}
