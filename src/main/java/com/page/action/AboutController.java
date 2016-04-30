package com.page.action;

import com.admin.bean.CmsContent;
import com.admin.bean.TdMenu;
import com.admin.service.CmsContentService;
import com.admin.service.TdMenuService;
import com.admin.tools.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
public class AboutController {
	/**
	 * log
	 */
	private static final Log log = LogFactory.getLog(AboutController.class);
	
	
	private static final String ACTION_NAME="AboutController";
	
	@Resource
	private CmsContentService cmsContentService;
	@Resource
	public TdMenuService tdMenuService;

    public static final int CONTENT_ABOUT_ABOUTUS= 14; //leadex简介
	
	@RequestMapping(value="/about")
	public ModelAndView about(HttpServletRequest request){
		ModelAndView model = new ModelAndView("pages/about");
		Map<String, Object> map = new HashMap<String, Object>();
		CmsContent summary=new CmsContent();
		int cid=0;
		if(StringUtils.isEmpty(request.getParameter("cid"))){
			cid=CONTENT_ABOUT_ABOUTUS;
		}else {
			cid=Integer.parseInt(request.getParameter("cid"));
		}
		
		map.put("categoryId", cid);
        TdMenu params = new TdMenu();
        params.setId(cid);
        TdMenu menu = tdMenuService.get(params);

		model.addObject("category", menu);

        summary.setCategoryId((long) cid);

		model.addObject("summary", cmsContentService.findList(summary).get(0));


		model.addObject("tabNum", 7);
		return model;
	}


}
