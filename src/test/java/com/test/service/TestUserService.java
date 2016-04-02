package com.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.User;
import com.kli.service.UserService;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager")
public class TestUserService extends BaseJunitTest{
	@Resource
	private UserService userService;
	
	@Test
	public void testQueryAll(){
		System.out.println(userService.queryAll());
	}
	
	
	@Test
	public void testGetAllUser(){
		System.out.println("------testGetAllUser-----");
		List<User> users = userService.findAllUser(2);
		Assert.assertEquals(users.size(), 1);
		Assert.assertEquals(users.get(0).getEmail(), "fdsdf@asd.comm");
		
	}
	@Test
	public void testQueryList(){
		System.out.println("------testQueryList-----");
		List<User> users = userService.queryList(1);
		System.out.println(users.size());
		System.out.println(users.get(0).getEmail());
		
	}
	
	@Test
	public void testQueryListCache1(){
		System.out.println("------testQueryListCache1-----");
		List<User> users = userService.findAllUserCache(1);
		System.out.println("-------");
		users = userService.findAllUserCache(1);
		System.out.println("-------");
		users = userService.findAllUserCache(2);
		System.out.println("-------");
		System.out.println(users.size());
		
	}
	
	@Test
	public void testQueryListCache2(){
		System.out.println("------testQueryListCache2-----");
		List<User> users = userService.findAllUserCache2(3);
		System.out.println("-------");
		
		users = userService.findAllUserCache2(3);
		System.out.println("-------");
		users = userService.findAllUserCache2(4);
		System.out.println("-------");
		System.out.println(users.size());
		
	}
	
	@Test
	public void testQueryOne(){
        User user = new User();
        user.setTrueName("admin");
        user = userService.findList(user).get(0);
        System.out.println(user.getPassword());
	}
	
	

}
