/**

 */
package com.kli.service.base;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.kli.bean.BaseEntity;
import com.kli.bean.Page;
import com.kli.dao.base.CrudDao;

/**
 * Service基类
 * @author Kai
 * @version 2014-05-16
 */
@Transactional(readOnly = false)
public abstract class CrudService<D extends CrudDao<T>, T extends BaseEntity<T>> extends BaseService {
	
	/**
	 * 持久层对象
	 */
	@Autowired
	protected D dao;
	
	/**
	 * 获取单条数据
	 * @param id
	 * @return
	 */
	public T get(String id) {
		return dao.get(id);
	}
	
	/**
	 * 获取单条数据
	 * @param entity
	 * @return
	 */
	public T get(T entity) {
		return dao.get(entity);
	}
	
	/**
	 * 查询列表数据
	 * @param entity
	 * @return
	 */
	public List<T> findList(T entity) {
		return dao.findList(entity);
	}
	
	/**
	 * 查询分页数据
	 * @param page 分页对象
	 * @param entity
	 * @return
	 */
	public Page<T> findPage(Page<T> page, T entity) {
		entity.setPage(page);
		page.setList(dao.findList(entity));
		return page;
	}
	
	
	public int queryByCount(T entity){
		return dao.getTotal(entity);
	}

	/**
	 * 保存数据（插入或更新）
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public int insert(T entity) {
		return dao.insert(entity);
	}

	
	
	@Transactional(readOnly = false)
	public int update(T entity) {
		return dao.update(entity);
	}
	
	@Transactional(readOnly = false)
	public int updateBySelective(T entity){
		return dao.updateBySelective(entity);
	}
	
	/**
	 * 删除数据
	 * @param entity
	 */
	@Transactional(readOnly = false)
	public int delete(T entity) {
		return dao.delete(entity);
	}

}
