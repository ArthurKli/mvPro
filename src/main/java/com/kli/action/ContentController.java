package com.kli.action;

import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.kli.bean.BaseMsg;
import com.kli.bean.CmsContent;
import com.kli.bean.Page;
import com.kli.bean.TdMenu;
import com.kli.constants.BaseConstants;
import com.kli.service.CmsContentService;
import com.kli.service.TdMenuService;
import com.kli.tools.DateTimeUtil;
import com.kli.tools.StringUtil;

/**
 * 
 * @author Kai
 * @version 2013-10-17
 */
@Controller
public class ContentController {
	private Log log = LogFactory.getLog(this.getClass());
	@Resource
	private CmsContentService contentServ;
	
	@Resource
	private TdMenuService tdMenuService;

	@RequestMapping(value = "admin/contentList")
	public ModelAndView contentList(HttpServletRequest request,
			HttpServletResponse response) throws UnsupportedEncodingException {
		ModelAndView model = new ModelAndView("admin/content/contentList");
		request.setCharacterEncoding("UTF-8");
		Long categoryId = StringUtil.longValue(
				request.getParameter("categoryId"), -1L);
		Long contentId = StringUtil.longValue(
				request.getParameter("contentId"), -1L);
		String contentTitle = StringUtil.stringValue(
				request.getParameter("contentTitle"), "");
		
		Integer pageNum = StringUtil.integerValue(request.getParameter("pageNum"), 1);
		CmsContent cmsContent = new CmsContent();
		if (contentId != -1L) {
			cmsContent.setContentId(contentId);
			model.addObject("contentId", contentId);
		}
		if (!"".equals(contentTitle)) {
			cmsContent.setContentTitle(contentTitle);
			model.addObject("contentTitle", contentTitle);
		}

		TdMenu category = tdMenuService.get(String.valueOf(categoryId));

		Page<CmsContent> page = new Page<CmsContent>(pageNum, 20);
		

		cmsContent.setCategoryId(categoryId);

		page = contentServ.findPage(page, cmsContent);
		model.addObject("page", page);
		model.addObject("category", category);

		//model.addObject("enableToAdd", this.enableToAdd(categoryId)); // 有些content不允许添加
		model.addObject("enableToAdd", true);
		return model;
	}
	
	@RequestMapping(value="admin/contentEditView")
	public ModelAndView toEditView(HttpServletRequest request){
		return getModelAndView(request, "admin/content/contentEdit");
	}
	
	@RequestMapping(value="admin/contentAddView")
	public ModelAndView toAddView(@RequestParam("categoryId") Long categoryId){
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		ModelAndView model = new ModelAndView("admin/content/contentAdd");
		model.addObject("category", category);
		return model;
	}
	@RequestMapping(value="admin/contentPublish")
	@ResponseBody
	public String contentPublish(@ModelAttribute CmsContent content,HttpServletRequest request){
//		RbacUser user = (RbacUser)request.getSession().getAttribute(LeadexConstants.SESSION_USER);
		BaseMsg msg = new BaseMsg();
		if(StringUtil.isEmpty(content.getCategoryId())){
			log.debug("##找不到栏目ID！##");
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("添加文章失败，找不到栏目ID，请联系管理员！");
			return JSON.toJSONString(msg);
		}
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String modifyTimeStr = request.getParameter("modifyTimeStr");
		if(!StringUtil.isEmpty(modifyTimeStr)){
			content.setModifyTime(DateTimeUtil.parseDateTime(modifyTimeStr));
		}

		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		log.debug("##添加"+category.getMenuName()+"开始##");
		content.setCreateUser(1007L);
		content.setContentStatus("Y");
		Integer type = contentServ.insert(content);
		if(!type.equals(0)){
			log.debug("##添加"+category.getMenuName()+"成功！##");
			msg.setRtnCode(BaseConstants.ResultCode.SUCCESS);
			msg.setMsg("添加"+category.getMenuName()+"成功！");
			return JSON.toJSONString(msg);
		}else{
			log.debug("##添加"+category.getMenuName()+"失败！##");
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("添加"+category.getMenuName()+"失败，请联系管理员！");
			return JSON.toJSONString(msg);
		}
	}
	
	@RequestMapping(value="admin/contentEdit")
	@ResponseBody
	public String contentEdit(@ModelAttribute CmsContent content,HttpServletRequest request){
//		RbacUser user = (RbacUser)request.getSession().getAttribute(LeadexConstants.SESSION_USER);
		BaseMsg msg = new BaseMsg();
		if(StringUtil.isEmpty(content.getCategoryId())){
			log.debug("##找不到栏目ID！##");
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("添加文章失败，找不到栏目ID，请联系管理员！");
			return JSON.toJSONString(msg);
		}
		String modifyTimeStr = request.getParameter("modifyTimeStr");
		if(!StringUtil.isEmpty(modifyTimeStr)){
			content.setModifyTime(DateTimeUtil.parseDateTime(modifyTimeStr));
		}
		TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
		content.setModifyUser(1007L);
		Integer type = contentServ.update(content);
		if(!type.equals(0)){
			log.debug("##修改"+category.getMenuName()+"成功！##");
			msg.setRtnCode(BaseConstants.ResultCode.SUCCESS);
			msg.setMsg("修改"+category.getMenuName()+"成功！");
			return JSON.toJSONString(msg);
		}else{
			log.debug("##修改"+category.getMenuName()+"失败！##");
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("修改"+category.getMenuName()+"失败，请联系管理员！");
			return JSON.toJSONString(msg);
		}
	}
	
	
	
	@RequestMapping(value="admin/contentAddOk")
	public ModelAndView contentAddOk(HttpServletRequest request){

		TdMenu category = tdMenuService.get(request.getParameter("categoryId"));
		ModelAndView model = new ModelAndView("admin/content/addsucess");
		model.addObject("category", category);
		return model;
	}
	
	
	
	
	
	@RequestMapping(value="admin/contentDesc")
	public ModelAndView contentDesc(HttpServletRequest request){
		return getModelAndView(request, "admin/content/contentDesc");
	}
	
	@RequestMapping(value="admin/contentDel")
	@ResponseBody
	public String contentDel(HttpServletRequest request){
		Long contentId = 0L;
		BaseMsg msg  = new BaseMsg();
		if(!StringUtil.isEmpty(request.getParameter("contentId"))){
			contentId = Long.parseLong((String) request.getParameter("contentId"));
		}else{
			log.error("++++++无法获取文章id++++++");
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("处理失败，无法获取文章ID，请查看是否传入正确的文章ID！");
//			JSONObject obj = JSONObject.fromObject(msg);
			return JSON.toJSONString(msg);
		}
		Integer type = 0;
		try {
			CmsContent content = new CmsContent();
			content.setContentId(contentId);
			
			type = contentServ.delete(content);
		} catch (Exception e) {
//			throw new GelinException(e);
		}
		if(!type.equals(0)){
			msg.setRtnCode(BaseConstants.ResultCode.SUCCESS);
			msg.setMsg("删除文章成功！");
			return JSON.toJSONString(msg);
		}else{
			log.debug("##删除文章失败！##");
			msg.setRtnCode(BaseConstants.ResultCode.FAILURE);
			msg.setMsg("删除文章失败，请联系管理员！");
			return JSON.toJSONString(msg);
		}
	}
	
	
	
	
	private ModelAndView getModelAndView(HttpServletRequest request, String resView){
		String categoryId = request.getParameter("categoryId");
		String contentId = request.getParameter("contentId");
		ModelAndView model = new ModelAndView(resView);
		TdMenu category = tdMenuService.get(String.valueOf(categoryId));
		CmsContent content = contentServ.get(String.valueOf(contentId));
		model.addObject("content", content);
		model.addObject("category", category);
		
		return model;
	}

}
