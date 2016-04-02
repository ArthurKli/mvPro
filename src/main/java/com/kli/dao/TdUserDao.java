package com.kli.dao;


import com.kli.annotation.MyBatisDao;
import com.kli.dao.base.CrudDao;
import com.kli.bean.TdUser;

/**
 * 
 * <br>
 * <b>功能：</b>TdUserDao<br>
 */
 @MyBatisDao
public interface TdUserDao extends CrudDao<TdUser> {
	
	
}
