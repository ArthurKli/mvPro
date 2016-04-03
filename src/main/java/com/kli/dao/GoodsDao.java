package com.kli.dao;


import com.kli.annotation.MyBatisDao;
import com.kli.dao.base.CrudDao;
import com.kli.bean.Goods;

/**
 * 
 * <br>
 * <b>功能：</b>GoodsDao<br>
 */
 @MyBatisDao
public interface GoodsDao extends CrudDao<Goods> {
	
	
}
