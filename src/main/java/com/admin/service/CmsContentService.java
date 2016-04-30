package com.admin.service;

import org.springframework.stereotype.Service;
import com.admin.bean.CmsContent;
import com.admin.dao.CmsContentDao;
import com.admin.service.base.CrudService;

@Service
public class CmsContentService extends CrudService<CmsContentDao, CmsContent>{

}
