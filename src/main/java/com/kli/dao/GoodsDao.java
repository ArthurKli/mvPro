package com.kli.dao;

import com.kli.annotation.MyBatisDao;
import com.kli.bean.Goods;
import com.kli.dao.base.CrudDao;
@MyBatisDao
public interface GoodsDao extends CrudDao<Goods>{
	
	public Goods doSpeciQuery();
	
}
