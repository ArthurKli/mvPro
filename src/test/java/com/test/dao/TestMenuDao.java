package com.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.admin.bean.TdMenu;
import com.admin.dao.TdMenuDao;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class TestMenuDao extends BaseJunitTest{

	@Resource
	private TdMenuDao menuDao;
	

	
	@Test
	public void testGetNextSubLevelCode(){
		TdMenu menu = menuDao.getNextSubLevelCode("001");
		System.out.println(menu.getMenuCode());
	}
	
	@Test
	public void testCalNum(){
		String numStr = "001003";
		String lastNum = "001003011";
		System.out.println(lastNum.substring(numStr.length(), lastNum.length()));
	}

}
