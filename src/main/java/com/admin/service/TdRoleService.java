package com.admin.service;

import org.springframework.stereotype.Service;

import com.admin.service.base.CrudService;
import com.admin.bean.TdRole;
import com.admin.bean.TdRolePerm;
import com.admin.dao.TdRoleDao;


/**
 * 
 * <br>
 * <b>功能：</b>TdRoleService<br>
 */
 @Service
public class TdRoleService extends CrudService<TdRoleDao, TdRole> {
	 
	 public int insertRolePerms(TdRolePerm rolePerm){
		 return dao.insertRolePerms(rolePerm);
	 }
	 
	 public int deleteRolePerms(int role_id){
		 return dao.deleteRolePerms(role_id);
	 }
}
