package com.kli.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kli.service.base.CrudService;
import com.kli.bean.TdPermissions;
import com.kli.dao.TdPermissionsDao;


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
