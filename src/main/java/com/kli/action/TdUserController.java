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
import com.kli.bean.Page;
import com.kli.bean.TdMenu;
import com.kli.bean.TdRole;
import com.kli.bean.TdUser;
import com.kli.constants.BaseConstants;
import com.kli.service.TdMenuService;
import com.kli.service.TdPermissionsService;
import com.kli.service.TdRoleService;
import com.kli.service.TdUserService;
import com.kli.tools.MD5Util;
import com.kli.tools.StringUtil;
/**
 * 
 * <br>
 * <b>功能：</b>TdUserController<br>
 *   <br>
 */ 
@Controller
public class TdUserController extends BaseController{
	
	@Autowired(required=false) 
	private TdUserService tdUserService; 
	
	@Resource
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
	@RequestMapping("/admin/userList") 
	public ModelAndView  list(HttpServletRequest request, HttpServletResponse response) throws Exception{
		Long categoryId = StringUtil.longValue(
				request.getParameter("categoryId"), -1L);
		int userId = StringUtil.intValue(request.getParameter("userId"), -1);
		String loginName = StringUtil.stringValue(
				request.getParameter("loginName"), "");		
		String trueName = StringUtil.stringValue(
				request.getParameter("trueName"), "");		
		
		Integer pageNum = StringUtil.integerValue(request.getParameter("pageNum"), 1);
		Page<TdUser> page = new Page<TdUser>(pageNum, 5);
		ModelAndView model = new ModelAndView("admin/user/userList");
		
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		model.addObject("category", category);
		
		TdUser user = new TdUser();
		if(userId > -1){
			user.setId(userId);
			model.addObject("userId", userId);
		}
		
		if(!StringUtil.isBlank(loginName)){
			user.setLoginName(loginName);
			model.addObject("loginName", loginName);
		}	
		if(!StringUtil.isBlank(trueName)){
			user.setTrueName(trueName);
			model.addObject("trueName", trueName);
		}	
		
		model.addObject("page", tdUserService.findPage(page, user));
		return model; 
	}
	
	@RequestMapping(value="admin/userAddView")
	public ModelAndView toAddView(@RequestParam("categoryId") Long categoryId){
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		
		List<TdRole> roleList = tdRoleService.findAllList(new TdRole());
		
		ModelAndView model = new ModelAndView("admin/user/userAdd");
		model.addObject("category", category);
		model.addObject("roleList", roleList);
		return model;
	}
	@RequestMapping(value="admin/userAdd")
	@ResponseBody
	public String userPublish(@ModelAttribute TdUser user,HttpServletRequest request){
		BaseMsg msg = new BaseMsg();

		Long categoryId = Long.parseLong(request.getParameter("categoryId"));
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		
		java.util.Date date =new java.util.Date();
		user.setCreateTime(date);
		user.setUpdateTime(date);
		user.setPassword(MD5Util.getMD5String(user.getPassword()));
		Integer type = tdUserService.insert(user);
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

	
	@RequestMapping(value="admin/userAddOk")
	public ModelAndView userAddOk(HttpServletRequest request){

		TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
		ModelAndView model = new ModelAndView("admin/user/addsucess");
		model.addObject("category", category);
		return model;
	}
	
	@RequestMapping(value="admin/userEditView")
	public ModelAndView toEditView(HttpServletRequest request){
		String categoryId = request.getParameter("categoryId");
		String userId = request.getParameter("userId");
		ModelAndView model = new ModelAndView("admin/user/userEdit");
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		TdUser user = new TdUser();
		user.setId(Integer.parseInt(userId));
		model.addObject("category", category);
		model.addObject("roleList", tdRoleService.findAllList(new TdRole()));
		model.addObject("user", tdUserService.get(user));
		return model;
	}
	
	@RequestMapping(value="admin/userEdit")
	@ResponseBody
	public String permEdit(@ModelAttribute TdUser user,HttpServletRequest request){
		BaseMsg msg = new BaseMsg();
		
		TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
		user.setUpdateTime(new java.util.Date());
		user.setPassword(MD5Util.getMD5String(user.getPassword()));
		
		Integer type = tdUserService.updateBySelective(user);
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

	@RequestMapping(value="admin/userDel")
	@ResponseBody
	public String userDel(HttpServletRequest request) {
		int userId;
		BaseMsg msg = new BaseMsg();
		if (!StringUtil.isEmpty(request.getParameter("userId"))) {
			userId = Integer.parseInt(request.getParameter("userId"));
		} else {
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("处理失败，无法获取ID，请查看是否传入正确的ID！");
			return JSON.toJSONString(msg);
		}
		Integer type = 0;
		try {
			TdUser user = new TdUser();
			user.setId(userId);
			type = tdUserService.delete(user);
		} catch (Exception e) {
			// throw new GelinException(e);
		}
		if (!type.equals(0)) {
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

}
