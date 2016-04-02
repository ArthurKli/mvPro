package com.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.Goods;
import com.kli.bean.Page;
import com.kli.dao.CategoryDao;
import com.kli.service.CategoryService;
import com.kli.service.GoodsService;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = false)
public class TestCategoryService extends BaseJunitTest{
	@Resource
	private CategoryService service;
	
	
	@Test
	public void queryTree(){
		System.out.println(service.queryTree());
	}

}
