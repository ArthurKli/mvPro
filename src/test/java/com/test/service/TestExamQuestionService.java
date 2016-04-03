package com.test.service;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.ExamQuestion;
import com.kli.service.ExamQuestionService;
import com.test.base.BaseJunitTest;
@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = false)
public class TestExamQuestionService extends BaseJunitTest{
	@Resource
	private ExamQuestionService service;
	
	
	@Test
	public void testFindList(){
		ExamQuestion question = new ExamQuestion();
		question.setId(100L);
		System.out.println(service.findList(question).size());
	}
	
	
	@Test
	public void testQueryByCount(){
		ExamQuestion question = new ExamQuestion();
		question.setId(100L);
		
		System.out.println(service.getTotal(question));
	}
	
	@Test
	public void testUpdate(){
		ExamQuestion question = new ExamQuestion();
		question.setId(100L);
		question.setQuestionInfo("@@@@");
		question.setQuestionDesc("hahahaha");
		question.setType(1);
		
		System.out.println(service.update(question));
	}
	
	
	
}
