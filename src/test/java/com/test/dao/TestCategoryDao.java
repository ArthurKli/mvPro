package com.test.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.CmsCategory;
import com.kli.dao.CategoryDao;
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
		System.out.println(dao.findAllList(new CmsCategory()).size());
		

	}
	
	@Test
	public void testAdd(){

		
	}
	

}
