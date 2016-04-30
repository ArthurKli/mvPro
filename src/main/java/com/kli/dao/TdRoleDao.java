package com.kli.dao;


import com.kli.annotation.MyBatisDao;
import com.kli.bean.TdRole;
import com.kli.bean.TdRolePerm;
import com.kli.dao.base.CrudDao;

/**
 * 
 * <br>
 * <b>功能：</b>TdRoleDao<br>
 */
 @MyBatisDao
public interface TdRoleDao extends CrudDao<TdRole> {
	
	 public int insertRolePerms(TdRolePerm rolePerm);
	 
	 public int deleteRolePerms(int role_id);
	
}
