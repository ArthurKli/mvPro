package com.test.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.TdPermissions;
import com.kli.bean.TdRole;
import com.kli.bean.TdRolePerm;
import com.kli.dao.TdPermissionsDao;
import com.kli.dao.TdRoleDao;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class TestPermissionDao extends BaseJunitTest{

	@Resource
	private TdPermissionsDao dao;
	

	
	@Test
	public void testFindListByRoleId(){
		List<TdPermissions> list = dao.findListByRoleId(1);
		System.out.println(list.size());
	}
	

	
	
}
