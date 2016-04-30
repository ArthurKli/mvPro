package com.test.service;

import javax.annotation.Resource;

import com.kli.service.TdMenuService;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

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
