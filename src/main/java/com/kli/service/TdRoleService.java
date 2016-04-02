package com.kli.service;

import org.springframework.stereotype.Service;

import com.kli.service.base.CrudService;
import com.kli.bean.TdRole;
import com.kli.bean.TdRolePerm;
import com.kli.dao.TdRoleDao;


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
