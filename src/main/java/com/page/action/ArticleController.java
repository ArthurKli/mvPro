package com.page.action;

import com.admin.bean.CmsContent;
import com.admin.bean.TdMenu;
import com.admin.service.CmsContentService;
import com.admin.service.TdMenuService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ArticleController {
	/**
	 * log
	 */
	private static final Log log = LogFactory.getLog(ArticleController.class);
	
	private static final String ACTION_NAME="ArticleController";

    @Resource
    private CmsContentService cmsContentService;
    @Resource
    public TdMenuService tdMenuService;

	
	@RequestMapping(value="/content/{cid}/{id}")
	public ModelAndView content(HttpServletRequest request,
			@PathVariable("cid") Integer cid,
			@PathVariable("id") Integer id){
		ModelAndView model = new ModelAndView("pages/content");

		model.addObject("category", tdMenuService.get(String.valueOf(cid)));
		model.addObject("content", cmsContentService.get(String.valueOf(id)));
		
		return model;
	}
	

//	public Page<CmsContent> queryContentList(Page<CmsContent> page,Map<String, Object> map,Integer type,int size){
//		page.setCurrPage(LeadexConstants.DEFAULT_PAGE_CURRENT_PAGE);
//		page.setPageSize(size);
//		page.setStartNum(LeadexConstants.DEFAULT_PAGE_START);
//		return cmsContentService.getContentPageListCache(map, page, type+ACTION_NAME);
//
//	}

}
