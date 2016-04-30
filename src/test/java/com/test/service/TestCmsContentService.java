package com.test.service;

import javax.annotation.Resource;

import com.admin.tools.DateTimeUtil;
import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.admin.bean.CmsContent;
import com.admin.service.CmsContentService;
import com.test.base.BaseJunitTest;

import java.util.Date;

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = false)
public class TestCmsContentService extends BaseJunitTest{
	@Resource
	private CmsContentService service;
	
	
	@Test
	public void getContentContent(){
		System.out.println(service.get("7").getContentDescription());
	}
	@Test
         public void testDel(){
        CmsContent content = new CmsContent();
        content.setContentId(5L);
        System.out.println(service.delete(content));
    }


    @Test
    public void testAdd(){
        String dateStr = "2014-07-14";
        CmsContent content = new CmsContent();
        content.setContentId(10003L);
        content.setContentDescription("desc");
        content.setContentImage("src:test");
        content.setContentPath("src:test");
        content.setContentPriority(1L);
        content.setContentContent("values");
        content.setContentStatus("Y");
        content.setCategoryId(1L);
        Date date = new Date();
        content.setCreateTime(DateTimeUtil.parseDateTime(dateStr));
        content.setModifyTime(DateTimeUtil.parseDateTime(dateStr));


        System.out.println(service.insert(content));



    }

    @Test
    public void testUpdate(){
        String dateStr = "2014-07-14";
        CmsContent content = new CmsContent();
        content.setContentId(10003L);
        content.setContentDescription("desc");
        content.setContentContent("values");

        Date date = new Date();
        content.setCreateTime(DateTimeUtil.parseDateTime(dateStr));
        content.setModifyTime(DateTimeUtil.parseDateTime(dateStr));


        System.out.println(service.update(content));



    }

}
