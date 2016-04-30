package com.admin.dao;


import com.admin.annotation.MyBatisDao;
import com.admin.bean.TdRole;
import com.admin.bean.TdRolePerm;
import com.admin.dao.base.CrudDao;

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
