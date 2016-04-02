package com.kli.service;

import org.springframework.stereotype.Service;
import com.kli.service.base.CrudService;
import com.kli.bean.ExamQuestion;
import com.kli.dao.ExamQuestionDao;


/**
 * 
 * <br>
 * <b>功能：</b>ExamQuestionService<br>
 */
 @Service
public class ExamQuestionService extends CrudService<ExamQuestionDao, ExamQuestion> {

}
