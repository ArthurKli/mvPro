package com.kli.service;

import org.springframework.stereotype.Service;
import com.kli.bean.CmsContent;
import com.kli.dao.CmsContentDao;
import com.kli.service.base.CrudService;

@Service
public class CmsContentService extends CrudService<CmsContentDao, CmsContent>{

}
