package com.admin.service;

import org.springframework.stereotype.Service;
import com.admin.service.base.CrudService;
import com.admin.bean.TdUser;
import com.admin.dao.TdUserDao;


/**
 * 
 * <br>
 * <b>功能：</b>TdUserService<br>
 */
 @Service
public class TdUserService extends CrudService<TdUserDao, TdUser> {

}
