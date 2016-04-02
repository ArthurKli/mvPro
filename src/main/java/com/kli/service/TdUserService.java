package com.kli.service;

import org.springframework.stereotype.Service;
import com.kli.service.base.CrudService;
import com.kli.bean.TdUser;
import com.kli.dao.TdUserDao;


/**
 * 
 * <br>
 * <b>功能：</b>TdUserService<br>
 */
 @Service
public class TdUserService extends CrudService<TdUserDao, TdUser> {

}
