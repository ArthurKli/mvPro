package com.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.CmsContent;
import com.kli.bean.Goods;
import com.kli.bean.Page;
import com.kli.dao.CategoryDao;
import com.kli.service.CategoryService;
import com.kli.service.CmsContentService;
import com.kli.service.GoodsService;
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
