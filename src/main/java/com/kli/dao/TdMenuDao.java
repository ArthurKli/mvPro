package com.kli.dao;



import java.util.List;

import com.kli.annotation.MyBatisDao;
import com.kli.bean.TdMenu;
import com.kli.dao.base.CrudDao;

/**
 * 
 * <br>
 * <b>功能：</b>TdMenuDao<br>
 */
 @MyBatisDao
public interface TdMenuDao extends CrudDao<TdMenu> {
	
	 public TdMenu getNextSubLevelCode(String parentCode);
	 
	public List<TdMenu> getMenuListLikeLevelCode(String menuCode);
}
