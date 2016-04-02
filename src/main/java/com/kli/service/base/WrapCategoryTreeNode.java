package com.kli.service.base;

import org.springframework.stereotype.Service;

import com.kli.bean.CmsCategory;
import com.kli.bean.TdMenu;
import com.kli.tools.tree.TreeNode;
/**
 * 构建栏目树节点
 * @author linrchang
 *
 */
@Service
public class WrapCategoryTreeNode implements WrapTreeNode {

	@Override
	public TreeNode wrapTreeNode(Object data) {
		TdMenu menus = (TdMenu) data;
		TreeNode node = new TreeNode();
		node.setId((long)menus.getId());
		node.setCode(menus.getMenuCode());
		node.setEntityType("CATEGORY");
		node.setHref(menus.getMenuHref());
		node.setParent(false);
		node.setName(menus.getMenuName());
		return node;
	}
}
