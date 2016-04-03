package com.kli.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.kli.bean.CmsCategory;
import com.kli.constants.BaseConstants;
import com.kli.dao.CategoryDao;
import com.kli.service.base.CrudService;
import com.kli.service.base.WrapTreeNode;
import com.kli.tools.tree.TreeNode;
import com.kli.tools.tree.TreeUtil;
@Service
public class CategoryService extends CrudService<CategoryDao, CmsCategory> {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Resource
	private WrapTreeNode wrapCategoryTreeNode;
	
	public String queryTree() {
		
		List<CmsCategory> list = dao.findList(new CmsCategory());
		List<TreeNode> treeNodes = new ArrayList<TreeNode>();
		TreeUtil.generateTree(wrapCategoryTreeNode, "tdMenuCode", list, treeNodes, "root");
		String treeJson = TreeUtil.getZTreeJsonData(treeNodes, 0L ,BaseConstants.TREE_TYPE_CATEGORY);
		
		logger.info(treeJson);
		
		return treeJson;
	}

}
