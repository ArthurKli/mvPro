
package com.kli.action;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.kli.tools.StringUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kli.bean.TdUser;
import com.kli.service.TdMenuService;
import com.kli.tools.MD5Util;
import com.kli.tools.StringUtils;

/**
 * 
 * @author Kai
 * @version 2013-10-17
 */
@Controller
public class LoginController {
	
	private Logger log = LoggerFactory.getLogger(getClass());
	
@Resource
private TdMenuService tdMenuService;


	@RequestMapping("/login")
    public String login(HttpServletRequest request) {
		System.out.println("Login page");

        return "admin/sysLogin";
    }
	
	@RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
		System.out.println("Logout");
		SecurityUtils.getSubject().logout();
        return "admin/sysLogin";
    }
	
	@RequestMapping("/doLogin")
    public String doLogin(HttpServletRequest request, RedirectAttributes redirectAttributes, Model model) {
		String username = request.getParameter("username");
		log.info("doLogin:" + username);
		
		if(isValidateCodeLogin(username, false, false)){
			String sessionCode = (String) request.getSession().getAttribute("validateCode");
			String validateCode = request.getParameter("validateCode");
			//model.addAttribute("isValidateCodeLogin", isValidateCodeLogin(username, true, false));
            if (StringUtil.isBlank(validateCode)) {
                redirectAttributes.addFlashAttribute("username",username);
                redirectAttributes.addFlashAttribute("message","请输入验证码");
                redirectAttributes.addFlashAttribute("isValidateCodeLogin",true);
                return "redirect:/login.shtml";
            }
			if (!validateCode.toUpperCase().equals(sessionCode)) {
				redirectAttributes.addFlashAttribute("username",username); 
				redirectAttributes.addFlashAttribute("message","验证码错误"); 
				redirectAttributes.addFlashAttribute("isValidateCodeLogin",isValidateCodeLogin(username, true, false));  
				return "redirect:/login.shtml"; 	
			}

		}

		TdUser user = new TdUser();
        user.setLoginName(username);
		user.setPassword(MD5Util.toMD5(request.getParameter("password")));
		Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getLoginName(), user.getPassword());
        try {
            //使用权限工具进行用户登录，登录成功后跳到shiro配置的successUrl中，与下面的return没什么关系！
        	subject.login(token);
        } catch (AuthenticationException e) {  
        	redirectAttributes.addFlashAttribute("username",username); 
            redirectAttributes.addFlashAttribute("message","用户名或密码错误"); 
			redirectAttributes.addFlashAttribute("isValidateCodeLogin",isValidateCodeLogin(username, true, false));  
            return "redirect:/login.shtml";  
        }  
        
        
        log.info("登录成功！");
        log.info("角色admin：" + subject.hasRole("admin"));
		// 登录成功后，验证码计算器清零
		isValidateCodeLogin(username, false, true);
        
        return "redirect:/admin/home.shtml";
    }
	
	/**
	 * 是否是验证码登录
	 * @param useruame 用户名
	 * @param isFail 计数加1
	 * @param clean 计数清零
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static boolean isValidateCodeLogin(String useruame, boolean isFail, boolean clean){
		Map<String, Integer> loginFailMap = (Map<String, Integer>)com.kli.tools.CacheUtils.get("loginFailMap");
		if (loginFailMap==null){
			loginFailMap = new HashMap();
			com.kli.tools.CacheUtils.put("loginFailMap", loginFailMap);
		}
		Integer loginFailNum = loginFailMap.get(useruame);
		if (loginFailNum==null){
			loginFailNum = 0;
		}
		if (isFail){
			loginFailNum++;
			loginFailMap.put(useruame, loginFailNum);
		}
		if (clean){
			loginFailMap.remove(useruame);
		}
		return loginFailNum >= 3;
	}
	
	
	
	@RequiresRoles("admin")  
	@RequestMapping(value="admin/home")
	public String home(){
		return "admin/home";
	}
	
	
	
	
	
	
	@RequestMapping(value="admin/index")
	public String index(){
		return "admin/main";
	}
	
	@RequestMapping(value="admin/top")
	public String head(){
		return "admin/frame/top";
	}
	
	@RequestMapping(value="admin/leftFrame")
	public String left(){
		
		return "admin/frame/leftFrame";
	}
	
	@RequestMapping(value="admin/mid")
	public String mid(){
		return "admin/frame/mid";
	}
	
	@RequestMapping(value="admin/welcome")
	public String welcome(){
		return "admin/frame/welcome";
	}
	
	/**
	 * 授权登录异常
	 */
	@RequestMapping(value="error/403")
    public String authenticationException() {  
        return "error/403";
    }
	
	
	
	

}
