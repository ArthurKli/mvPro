package ${bussPackage}.action#if($!controllerEntityPackage).${controllerEntityPackage}#end;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kli.action.BaseController;
import ${bussPackage}.bean#if($!entityPackage).${entityPackage}#end.${className};
 import ${bussPackage}.service#if($!entityPackage).${entityPackage}#end.${className}Service;
/**
 * 
 * <br>
 * <b>功能：</b>${className}Controller<br>
 *   <br>
 */ 
@Controller
public class ${className}Controller extends BaseController{
	
	@Autowired(required=false) 
	private ${className}Service ${lowerName}Service; 
	
	
	
	/**
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/${className}/list") 
	public ModelAndView  list(HttpServletRequest request, HttpServletResponse response) throws Exception{
	    ModelAndView model = new ModelAndView("/${className}/list");
		return model; 
	}
	
	

}
