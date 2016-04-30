package com.admin.dao;


import com.admin.annotation.MyBatisDao;
import com.admin.dao.base.CrudDao;
import com.admin.bean.Goods;

/**
 * 
 * <br>
 * <b>功能：</b>GoodsDao<br>
 */
 @MyBatisDao
public interface GoodsDao extends CrudDao<Goods> {
	
	
}
