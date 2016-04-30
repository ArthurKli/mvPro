package com.admin.service;

import org.springframework.stereotype.Service;
import com.admin.service.base.CrudService;
import com.admin.bean.ExamQuestion;
import com.admin.dao.ExamQuestionDao;


/**
 * 
 * <br>
 * <b>功能：</b>ExamQuestionService<br>
 */
 @Service
public class ExamQuestionService extends CrudService<ExamQuestionDao, ExamQuestion> {

}
