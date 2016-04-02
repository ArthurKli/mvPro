package com.kli.service;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.kli.bean.CmsContent;
import com.kli.bean.User;
import com.kli.dao.CmsContentDao;
import com.kli.dao.MybatisDao;
import com.kli.dao.UserDao;
import com.kli.service.base.CrudService;
import com.kli.tools.CacheUtils;

@Service(value="userService")
public class UserService extends CrudService<UserDao, User> {
	@Resource
	private MybatisDao mybatisDao;
	
	private static final Log log = LogFactory.getLog(UserService.class);

	public int queryAll() {
		// TODO Auto-generated method stub
		return mybatisDao.countALL();
	}

	public List<User> findAllUser(int id) {
		// TODO Auto-generated method stub
		return mybatisDao.findAllUser(id);
	}

	public List<User> queryList(int id) {
		User user = new User();
		user.setUserId(id);
		return dao.findList(user);
	}


	@Cacheable(value="userCache",key="#root.methodName + #id") 
	public List<User> findAllUserCache(int id) {
		log.info("findAllUser----read DB ");
		return this.queryList(id);
	}
	
	public List<User> findAllUserCache2(int id) {
		List<User> list = (List<User>) CacheUtils.get("findAllUserCache2_" + id);
		if(list == null){
			list = this.findAllUser(id);
			CacheUtils.put("findAllUserCache2_" + id, list);
			log.info("findAllUserCache2--" + "--read DB ");
		}else{
			log.info("findAllUserCache2--" + "--read cache ");
		}
		
		return list;
	}
}
