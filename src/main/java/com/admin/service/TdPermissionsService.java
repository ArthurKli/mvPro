package com.admin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.admin.service.base.CrudService;
import com.admin.bean.TdPermissions;
import com.admin.dao.TdPermissionsDao;


/**
 * 
 * <br>
 * <b>功能：</b>TdPermissionsService<br>
 */
 @Service
public class TdPermissionsService extends CrudService<TdPermissionsDao, TdPermissions> {
	 
	 public List<TdPermissions> findListByRoleId(int role_id){
		 return dao.findListByRoleId(role_id);
	 }
	 
	 public int deleteRolePerms(int perm_id){
		 return dao.deleteRolePerms(perm_id);
	 }

}
