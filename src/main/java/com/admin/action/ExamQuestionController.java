package com.admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.admin.service.ExamQuestionService;
/**
 * 
 * <br>
 * <b>功能：</b>ExamQuestionController<br>
 *   <br>
 */ 
@Controller
public class ExamQuestionController extends BaseController{
	
	@Autowired(required=false) 
	private ExamQuestionService examQuestionService; 
	
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/ExamQuestion/list") 
	public ModelAndView  list(HttpServletRequest request, HttpServletResponse response) throws Exception{
	    ModelAndView model = new ModelAndView("/ExamQuestion/list");
		return model; 
	}
	
	

}
