package com.test.dao;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.admin.bean.Goods;
import com.admin.dao.GoodsDao;
import com.admin.dao.MybatisDao;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager", defaultRollback = true)
public class TestGoodsDao extends BaseJunitTest{

	@Resource
	private GoodsDao goodsDao;
	
	@Resource
	private MybatisDao myDao;

	
	@Test
	public void testGet(){
        String gid = "1";
		Goods goods1 = goodsDao.get("1");
        Goods goods2 = new Goods();
        goods2.setGoodsId(Integer.parseInt(gid));
        org.junit.Assert.assertTrue(goods1.getGoodsName().equals(goodsDao.get(goods2).getGoodsName()));
	}
	
	@Test
	public void testGetList(){
		Goods goods = new Goods();
		List<Goods> goodsList = goodsDao.findList(goods);
		System.out.println(goodsList.size());
		
//		goods.setGoodsName("西门吹雪");
		goods.setGoodsCount(2334);

		goodsList = goodsDao.findList(goods);
		System.out.println(goodsList.size());
	}

    @Test
    public void testGetTotal(){
        System.out.println(goodsDao.getTotal(new Goods()));
        Goods goods = new Goods();
        goods.setGoodsCount(2334);
        System.out.println(goodsDao.getTotal(goods));
    }
	
	@Test
	public void testAdd(){
		Goods goods = new Goods();
		goods.setGoodsCode("zxxxxxx");
		goods.setGoodsCount(200);
		goods.setGoodsName("逗比");
        org.junit.Assert.assertTrue(goodsDao.insert(goods) > 0);
        System.out.println(goods.getGoodsId());
    }

    @Test
    public void testUpdate(){
        Goods goods = new Goods();
        goods.setGoodsId(10);
        goods.setGoodsCode("zxxxxxx");
        goods.setGoodsCount(200);
        goods.setGoodsName("逗比");
        org.junit.Assert.assertTrue(goodsDao.update(goods) > 0);
        org.junit.Assert.assertTrue(goodsDao.updateBySelective(goods) > 0);
    }

    @Test
    public void testDelete(){
        Goods goods = new Goods();
        goods.setGoodsId(10);
        org.junit.Assert.assertTrue(goodsDao.delete(goods) > 0);
        goods = new Goods();
        goods.setGoodsCode("DGHJKKK");
        org.junit.Assert.assertTrue(goodsDao.delete(goods) == 0);
    }
	
	@Test
	public void testMy(){
		myDao.queryList(1);
	}
}
