package com.kli.dao;

import com.kli.annotation.MyBatisDao;
import com.kli.bean.CmsCategory;
import com.kli.dao.base.CrudDao;
@MyBatisDao
public interface CategoryDao extends CrudDao<CmsCategory>{
	
}
