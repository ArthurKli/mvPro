package com.admin.dao;


import com.admin.annotation.MyBatisDao;
import com.admin.dao.base.CrudDao;
import com.admin.bean.ExamQuestion;

/**
 * 
 * <br>
 * <b>功能：</b>ExamQuestionDao<br>
 */
 @MyBatisDao
public interface ExamQuestionDao extends CrudDao<ExamQuestion> {
	
	
}
