package com.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.admin.bean.TdPermissions;
import com.admin.dao.TdPermissionsDao;
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
