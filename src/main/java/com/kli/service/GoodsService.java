package com.kli.service;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kli.bean.Goods;
import com.kli.dao.GoodsDao;
import com.kli.dao.MybatisDao;
import com.kli.service.base.CrudService;
@Service
public class GoodsService extends CrudService<GoodsDao, Goods> {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Resource
	MybatisDao myDao;
	
	public List<Goods> queryAll(){
		return dao.findList(null);
	}

	public Goods speciQuery() {
		logger.error("------speciQuery-----");
		
		System.err.println("-------myDao-------");
		
		
		return dao.doSpeciQuery();

	}
	
	public void queryUserInGoods() {
		System.out.println("------queryUserInGoods-----");
		
		System.out.println(myDao.findAllUser(2).toString());
		
	}

}
