package com.kli.dao;


import java.util.List;

import com.kli.annotation.MyBatisDao;
import com.kli.dao.base.CrudDao;
import com.kli.bean.TdPermissions;

/**
 * 
 * <br>
 * <b>功能：</b>TdPermissionsDao<br>
 */
 @MyBatisDao
public interface TdPermissionsDao extends CrudDao<TdPermissions> {
	
	public List<TdPermissions> findListByRoleId(int role_id);
	
	public int deleteRolePerms(int perm_id);
}
