package com.admin.dao;

import com.admin.annotation.MyBatisDao;
import com.admin.bean.User;
import com.admin.dao.base.CrudDao;

@MyBatisDao
public interface UserDao extends CrudDao<User>{

}
