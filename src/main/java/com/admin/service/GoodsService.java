package com.admin.service;

import org.springframework.stereotype.Service;
import com.admin.service.base.CrudService;
import com.admin.bean.Goods;
import com.admin.dao.GoodsDao;


/**
 * 
 * <br>
 * <b>功能：</b>GoodsService<br>
 */
 @Service
public class GoodsService extends CrudService<GoodsDao, Goods> {

}
