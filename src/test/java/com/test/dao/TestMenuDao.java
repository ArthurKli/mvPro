package com.test.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.TdMenu;
import com.kli.bean.TdRole;
import com.kli.bean.TdRolePerm;
import com.kli.dao.TdMenuDao;
import com.kli.dao.TdRoleDao;
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
