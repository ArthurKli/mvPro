/**

 */
package com.kli.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kli.bean.Goods;
import com.kli.bean.User;
import com.kli.service.GoodsService;
import com.kli.service.UserService;
import com.kli.tools.SpringContextHolder;

/**
 * 
 * @author Kai
 * @version 2013-10-17
 */
@Controller
public class TestController {
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;

	@RequestMapping("/test/{username}")
    public String index(HttpServletRequest request, @PathVariable("username") String username, @RequestParam("uid") String uid) {
		request.setAttribute("user", "kaiiii");
		request.setAttribute("name", username);
		request.setAttribute("uid", uid);
        return "hello";
    }
	
	@RequestMapping("/test")
    public String test(HttpServletRequest request) {
		System.out.println("index index index");

        return "hello";
    }
	

	
	@RequestMapping("/model")
    public ModelAndView model(HttpServletRequest request) {

		 ModelAndView mv = new ModelAndView();
	       //添加模型数据 可以是任意的POJO对象
	       mv.addObject("message", "Hello World!");
	       mv.addObject("user", "99998887776");
	       //设置逻辑视图名，视图解析器会根据该名字解析到具体的视图页面
	       mv.setViewName("hello");

        return mv;
    }
	
	@RequestMapping("/query")
    public String query(HttpServletRequest request) {
		
		List<User> list = userService.queryList(1); 
		System.out.println(list.get(0).getEmail());
		System.out.println(list.get(0).getTrueName());
		
		request.setAttribute("user", userService.queryAll()	);
        return "hello";
    }
	
//	@RequestMapping("/allGoods")
//    public String queryAllGoods(HttpServletRequest request) {
//
//		Goods goods = goodsService.speciQuery();
//		System.out.println(goods.toString());
//
//		request.setAttribute("user", "speciQuery");
//        return "hello";
//    }
	
	
	/**
	 * 基于注解（auto）的缓存
	 * @param request
	 * @return
	 */
	@RequestMapping("/cache")
    public String cache(HttpServletRequest request) {
		
		List<User> list = userService.findAllUserCache(1); 
		System.out.println(list.get(0).getEmail());
		System.out.println(list.get(0).getTrueName());
		
		request.setAttribute("user", userService.queryAll()	);
        return "hello";
    }
	
	/**
	 * 基于key-value的缓存（手动）
	 * @param request
	 * @return
	 */
	@RequestMapping("/cache2")
    public String cache2(HttpServletRequest request) {
		
		List<User> list = userService.findAllUserCache2(1); 
		System.out.println(list.get(0).getEmail());
		System.out.println(list.get(0).getTrueName());
		
		request.setAttribute("user", userService.queryAll()	);
        return "hello";
    }
	@RequestMapping("/app")
    public String app(HttpServletRequest request) {
		
		UserService userService2 = (UserService) SpringContextHolder.getBean("userService");
		System.out.println("----" + userService2);
		request.setAttribute("user", userService2.queryAll()	);
        return "hello";
    }
	
	
	@RequestMapping("/add")
    public String add(HttpServletRequest request) {
		
		User user = new User();
		user.setEmail("fdsdf@asd.comm");
		user.setTrueName("阿萨德");
		userService.insert(user);
		
		request.setAttribute("user", userService.queryAll()	);
        return "hello";
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping("/ajax")  
	@ResponseBody  
	public Object ajax(HttpServletRequest request){  
	    List<String> list=new ArrayList<String>();  
	    list.add("电视");  
        list.add("洗衣机");  
	    list.add("冰箱");  
	    list.add("电脑");  
	    list.add("汽车");  
	    list.add("空调");  
	    list.add("自行车");  
	    list.add("饮水机");  
	    list.add("热水器");  
	    return list;  
	}  
    
    
	

	

	


}
