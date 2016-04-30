package com.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.admin.bean.CmsCategory;
import com.admin.dao.CategoryDao;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class TestCategoryDao extends BaseJunitTest{

	@Resource
	private CategoryDao dao;
	
	
	@Test
	public void testGet(){
		CmsCategory category = dao.get("2");
		System.out.println(category.getCategoryName());
	}
	
	@Test
	public void testGetList(){
		System.out.println(dao.findList(new CmsCategory()).size());
		

	}
	
	@Test
	public void testAdd(){

		
	}
	

}
