package com.admin.dao;


import com.admin.annotation.MyBatisDao;
import com.admin.dao.base.CrudDao;
import com.admin.bean.TdUser;

/**
 * 
 * <br>
 * <b>功能：</b>TdUserDao<br>
 */
 @MyBatisDao
public interface TdUserDao extends CrudDao<TdUser> {
	
	
}
