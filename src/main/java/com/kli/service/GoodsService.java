package com.kli.service;

import org.springframework.stereotype.Service;
import com.kli.service.base.CrudService;
import com.kli.bean.Goods;
import com.kli.dao.GoodsDao;


/**
 * 
 * <br>
 * <b>功能：</b>GoodsService<br>
 */
 @Service
public class GoodsService extends CrudService<GoodsDao, Goods> {

}
