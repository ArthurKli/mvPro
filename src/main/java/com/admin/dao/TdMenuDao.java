package com.admin.dao;



import java.util.List;

import com.admin.annotation.MyBatisDao;
import com.admin.bean.TdMenu;
import com.admin.dao.base.CrudDao;

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
