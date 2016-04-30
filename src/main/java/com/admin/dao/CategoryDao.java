package com.admin.dao;

import com.admin.annotation.MyBatisDao;
import com.admin.bean.CmsCategory;
import com.admin.dao.base.CrudDao;
@MyBatisDao
public interface CategoryDao extends CrudDao<CmsCategory>{
	
}
