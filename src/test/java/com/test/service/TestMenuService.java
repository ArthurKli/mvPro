package com.test.service;

import java.util.List;

import javax.annotation.Resource;

import com.kli.service.TdMenuService;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.Goods;
import com.kli.bean.Page;
import com.kli.dao.CategoryDao;
import com.kli.service.CategoryService;
import com.kli.service.GoodsService;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = false)
public class TestMenuService extends BaseJunitTest{
	@Resource
	private TdMenuService service;

	
	@Test
	public void queryTree(){
		System.out.println(service.queryTree(null));
        System.out.println(service.queryTree("001"));
		System.out.println(service.queryTree("001001"));
		System.out.println(service.queryTree("001001002"));
	}

}
