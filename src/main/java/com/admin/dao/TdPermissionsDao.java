package com.admin.dao;


import java.util.List;

import com.admin.annotation.MyBatisDao;
import com.admin.dao.base.CrudDao;
import com.admin.bean.TdPermissions;

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
