package com.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.kli.bean.Goods;
import com.kli.bean.Page;
import com.kli.service.GoodsService;
import com.test.base.BaseJunitTest;

@TransactionConfiguration(transactionManager="transactionManager",defaultRollback = false)
public class TestGoodsService extends BaseJunitTest{
	@Resource
	private GoodsService goodsService;
	
	
	@Test
	public void testGetAllGoods(){
		System.out.println("------testGetAllGoods-----");
//		List<Goods> goods = goodsService.queryAll();
//		Assert.assertEquals(goods.size(), 1);
//		Assert.assertEquals(goods.get(0).getGoodsCode(), "SGDTTHHJRY");
		
		
	}
	
	@Test
	public void testGoodsList(){
		Goods goods = new Goods();
		
		goods.setGoodsName("西门吹");
		goodsService.findList(goods);
		
		List<Goods> goodsList = goodsService.findList(goods);
		System.out.println(goodsList.size());
	}
	
	@Test
	public void testGoodsListPage(){
		Goods conditions = new Goods();
        conditions.setGoodsCode("zxxxxxx");
		Page<Goods> page = goodsService.findPage(new Page<Goods>(2, 2),  conditions);
		System.out.println(page.getCount());
		System.out.println(page.getTotalPage());
		for (Goods goods : page.getList()) {
			System.out.println(goods.toString());
		}
	}
	
	
	@Test
	public void testAdd(){
		Goods goods = new Goods();
		goods.setGoodsCode("DGHJKKK");
		goods.setGoodsCount(200);
		goods.setGoodsName("叶小沫");
		
		goodsService.insert(goods);
		
	}

}
