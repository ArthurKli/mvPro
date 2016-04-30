package com.admin.service;

import com.admin.bean.CmsCategory;
import com.admin.constants.BaseConstants;
import com.admin.dao.CategoryDao;
import com.admin.service.base.CrudService;
import com.admin.tools.tree.TreeNode;
import com.admin.tools.tree.TreeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService extends CrudService<CategoryDao, CmsCategory> {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public String queryTree() {
		
		List<CmsCategory> list = dao.findList(new CmsCategory());
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		TreeUtil.generateTree(list, treeNodes, null);
		String treeJson = TreeUtil.getZTreeJsonData(treeNodes, 0L ,BaseConstants.TREE_TYPE_CATEGORY);
		
		logger.info(treeJson);
		
		return treeJson;
	}

}
