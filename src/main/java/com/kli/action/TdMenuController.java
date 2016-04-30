package com.kli.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.kli.action.BaseController;
import com.kli.bean.BaseMsg;
import com.kli.bean.Page;
import com.kli.bean.TdMenu;
import com.kli.bean.TdPermissions;
import com.kli.bean.TdRole;
import com.kli.bean.TdUser;
import com.kli.constants.BaseConstants;
import com.kli.service.CategoryService;
import com.kli.service.TdMenuService;
import com.kli.service.TdPermissionsService;
import com.kli.tools.MD5Util;
import com.kli.tools.StringUtil;
/**
 * 
 * <br>
 * <b>功能：</b>TdMenuController<br>
 *   <br>
 */ 
@Controller
public class TdMenuController extends BaseController{
	
	@Autowired(required=false) 
	private TdMenuService tdMenuService; 
	
	@Resource
	private TdPermissionsService tdPermissionsService; 

		
		@RequestMapping(value="admin/getMenuTree")
		@ResponseBody
        @Cacheable(value="sysCache",key="#root.methodName")
        public String getMenuTree(HttpServletRequest request){
			String treeJson = tdMenuService.queryTree(null);
            log.info("getMenuTree in db:" + treeJson);
			return treeJson;
		}
	
		
		/**
		 * 
		 * @param request
		 * @param response
		 * @return
		 * @throws Exception
		 */
		@RequestMapping("/admin/menuList") 
		public ModelAndView  list(HttpServletRequest request, HttpServletResponse response) throws Exception{
			Long categoryId = StringUtil.longValue(
					request.getParameter("categoryId"), -1L);
			int menuId = StringUtil.integerValue(request.getParameter("menuId"), -1);
			String menuName = StringUtil.stringValue(
					request.getParameter("menuName"), "");		
	
			
			Integer pageNum = StringUtil.integerValue(request.getParameter("pageNum"), 1);
			Page<TdMenu> page = new Page<TdMenu>(pageNum, 5);
			ModelAndView model = new ModelAndView("admin/menu/menuList");
			
			TdMenu category = tdMenuService.get(String.valueOf(categoryId));
			model.addObject("category", category);
			
			TdMenu menu = new TdMenu();
			if(menuId > -1){
				menu.setId(menuId);
				model.addObject("menuId", menuId);
			}
			
			if(!StringUtil.isBlank(menuName)){
				menu.setMenuName(menuName);
				model.addObject("menuName", menuName);
			}	

			
			model.addObject("page", tdMenuService.findPage(page, menu));
			return model; 
		}
		
		@RequestMapping(value="admin/menuAddView")
		public ModelAndView toAddView(@RequestParam("categoryId") Long categoryId){
			TdMenu category = tdMenuService.get(String.valueOf(categoryId));
			
			List<TdPermissions> allPermList = tdPermissionsService.findList(new TdPermissions());
			List<TdMenu> menuList = tdMenuService.findList(new TdMenu());
			
			
			ModelAndView model = new ModelAndView("admin/menu/menuAdd");
			model.addObject("category", category);
			model.addObject("allPermList", allPermList);
			model.addObject("menuList", menuList);
			return model;
		}
		
		
		@RequestMapping(value="admin/menuAdd")
		@ResponseBody
		public String menuPublish(@ModelAttribute TdMenu menu,HttpServletRequest request){
			BaseMsg msg = new BaseMsg();

			int categoryId = Integer.parseInt(request.getParameter("categoryId"));
			TdMenu category = tdMenuService.get(String.valueOf(categoryId));
			
			String parentMenuCode = request.getParameter("parentMenuCode");
			if(StringUtil.isBlank(parentMenuCode)){
				msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
				msg.setMsg("添加"+category.getMenuName()+"失败，parentCode不能为空");
				return JSON.toJSONString(msg);
			}
			
			java.util.Date date =new java.util.Date();
			menu.setCreateTime(date);
			menu.setModifyTime(date);
			menu.setMenuEnable("Y");
			menu.setMenuStatus("Y");
			menu.setMenuDelete("N");
			menu.setMenuCode(tdMenuService.getNextSubLevelCode(parentMenuCode));
			
			
			Integer type = tdMenuService.insert(menu);
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
		
		@RequestMapping(value="admin/menuAddOk")
		public ModelAndView menuAddOk(HttpServletRequest request){

			TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
			ModelAndView model = new ModelAndView("admin/menu/addsucess");
			model.addObject("category", category);
			return model;
		}
		
		@RequestMapping(value="admin/menuEditView")
		public ModelAndView toEditView(HttpServletRequest request){
			String categoryId = request.getParameter("categoryId");
			String menuId = request.getParameter("menuId");
			ModelAndView model = new ModelAndView("admin/menu/menuEdit");
			
			TdMenu menu = tdMenuService.get(menuId);
			
			List<TdMenu> menus = tdMenuService.getMenuListLikeLevelCode(menu.getMenuCode());
			
			model.addObject("category", tdMenuService.get(categoryId));
			model.addObject("allPermList", tdPermissionsService.findList(new TdPermissions()));
			model.addObject("menuList", tdMenuService.findList(new TdMenu()));
			model.addObject("menu", menu);
			model.addObject("isLeafMenu", menus.size()==1);
			return model;
		}
	
		@RequestMapping(value="admin/menuEdit")
		@ResponseBody
		public String menuEdit(@ModelAttribute TdMenu menu,HttpServletRequest request){
			BaseMsg msg = new BaseMsg();
			
			TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
			
			String parentMenuCode = request.getParameter("parentMenuCode");

			
			java.util.Date date =new java.util.Date();
			menu.setModifyTime(date);
			menu.setMenuEnable("Y");
			menu.setMenuStatus("Y");
			menu.setMenuDelete("N");
			if(!StringUtil.isBlank(parentMenuCode)){
				menu.setMenuCode(tdMenuService.getNextSubLevelCode(parentMenuCode));
			}

			
			Integer type = tdMenuService.updateBySelective(menu);
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
		
		@RequestMapping(value="admin/menuDel")
		@ResponseBody
		public String userDel(HttpServletRequest request) {
			String menuId;
			BaseMsg msg = new BaseMsg();
			if (!StringUtil.isEmpty(request.getParameter("menuId"))) {
				menuId = request.getParameter("menuId");
			} else {
				msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
				msg.setMsg("处理失败，无法获取ID，请查看是否传入正确的ID！");
				return JSON.toJSONString(msg);
			}
			TdMenu menu = tdMenuService.get(menuId);
			List<TdMenu> menus = tdMenuService.getMenuListLikeLevelCode(menu.getMenuCode());
			if(menus.size()>1){
				msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
				msg.setMsg("处理失败，请检查该栏目是否为叶子节点！");
				return JSON.toJSONString(msg);
			}
			
			Integer type = 0;
			try {
				menu = new TdMenu();
				menu.setId(Integer.parseInt(menuId));
				type = tdMenuService.delete(menu);
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
