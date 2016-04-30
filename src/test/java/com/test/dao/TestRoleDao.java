package com.test.dao;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.admin.bean.TdRole;
import com.admin.bean.TdRolePerm;
import com.admin.dao.TdRoleDao;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class TestRoleDao extends BaseJunitTest{

	@Resource
	private TdRoleDao roleDao;
	

	
	@Test
	public void testInsertRolePerms(){
		TdRolePerm rolePerm = new TdRolePerm();
		rolePerm.setRoleId(11);
		rolePerm.setPermId(22);
		rolePerm.setPermType("asfrtb");
		System.out.println(roleDao.insertRolePerms(rolePerm));
	}
	
	@Test
	public void testInsertRole(){
		TdRole  role = new TdRole();
		role.setPermissions("abddf");
		role.setRoleName("allqqqqW");
		role.setStatus(1);
		role.setCreateTime(new Date());
		System.out.println(roleDao.insert(role));
		System.out.println(role.getId());
	}
	
	
}
