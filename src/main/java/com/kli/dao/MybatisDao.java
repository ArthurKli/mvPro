package com.kli.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.kli.annotation.MyBatisDao;
import com.kli.bean.User;

@MyBatisDao
public interface MybatisDao {
	
	@Select("select count(*) from user;")
	public int countALL();

	@Select ("SELECT id AS userId, true_name AS trueName, email FROM user WHERE id =#{id}")
	public List<User> findAllUser(int id);
	
	public List<User> queryList(int id);
	
	public int insert(User user);
	

}
