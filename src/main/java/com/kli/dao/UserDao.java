package com.kli.dao;

import com.kli.annotation.MyBatisDao;
import com.kli.bean.User;
import com.kli.dao.base.CrudDao;

@MyBatisDao
public interface UserDao extends CrudDao<User>{

}
