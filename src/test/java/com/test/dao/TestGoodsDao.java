package com.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.Goods;
import com.kli.dao.GoodsDao;
import com.kli.dao.MybatisDao;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class TestGoodsDao extends BaseJunitTest{

	@Resource
	private GoodsDao goodsDao;
	
	@Resource
	private MybatisDao myDao;
	
	@Test
	public void testSpeciQuery(){
		Goods goods = goodsDao.doSpeciQuery();
		System.out.println(goods.toString());
	}
	
	@Test
	public void testGet(){
		Goods goods = goodsDao.get("1");
		System.out.println(goods.toString());
	}
	
	@Test
	public void testGetList(){
		Goods goods = new Goods();
		List<Goods> goodsList = goodsDao.findAllList(goods);
		System.out.println(goodsList.size());
		
		goods.setGoodsName("西门吹X");
		
		goodsList = goodsDao.findList(goods);
		System.out.println(goodsList.size());
	}
	
	@Test
	public void testAdd(){
		Goods goods = new Goods();
		goods.setGoodsCode("zxxxxxx");
		goods.setGoodsCount(200);
		goods.setGoodsName("逗比");
		
		goodsDao.insert(goods);
		
	}
	
	@Test
	public void testMy(){
		myDao.queryList(1);
	}
}
