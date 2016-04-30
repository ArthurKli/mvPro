package com.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.CmsContent;
import com.kli.service.CmsContentService;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = true)
public class TestCmsContentService extends BaseJunitTest{
	@Resource
	private CmsContentService service;
	
	
	@Test
	public void getContentContent(){
		System.out.println(service.get("5").getContentDescription());
	}
	@Test
	public void testDel(){
		CmsContent content = new CmsContent();
		content.setContentId(5L);
		System.out.println(service.delete(content));
	}

}
