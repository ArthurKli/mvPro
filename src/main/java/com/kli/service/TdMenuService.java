package com.kli.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.kli.service.base.CrudService;
import com.kli.service.base.WrapTreeNode;
import com.kli.tools.tree.TreeNode;
import com.kli.tools.tree.TreeUtil;
import com.kli.bean.CmsCategory;
import com.kli.bean.TdMenu;
import com.kli.constants.BaseConstants;
import com.kli.dao.TdMenuDao;


/**
 * 
 * <br>
 * <b>功能：</b>TdMenuService<br>
 */
 @Service
public class TdMenuService extends CrudService<TdMenuDao, TdMenu> {
		@Resource
		private WrapTreeNode wrapCategoryTreeNode;
		
		public String queryTree() {
			
			List<TdMenu> allList = dao.findAllList(new TdMenu());
			List<TdMenu> menuList = new ArrayList<TdMenu>();
			Subject subject = SecurityUtils.getSubject();
			for(TdMenu m : allList){
				if (m.getMenuPerms().equals("all") || subject.isPermitted(m.getMenuPerms())) {
					menuList.add(m);
				}
			}
			
			List<TreeNode> treeNodes = new ArrayList<TreeNode>();
			TreeUtil.generateTree(wrapCategoryTreeNode, "menuCode", menuList, treeNodes, "root");
			String treeJson = TreeUtil.getZTreeJsonData(treeNodes, 0L ,BaseConstants.TREE_TYPE_CATEGORY);
			
			logger.info(treeJson);
			
			return treeJson;
		}
		
		
		public String getNextSubLevelCode(String parentCode){
			
			TdMenu lastMenu = dao.getNextSubLevelCode(parentCode);
			if(lastMenu.getMenuCode().equals(parentCode)){
				return parentCode + "001";
			}
			String lastCode = lastMenu.getMenuCode();
			
			lastCode = lastCode.substring(0, parentCode.length() + 3);
			
			logger.info("---parentCode---" + parentCode);		
			logger.info("---lastCode---" + lastCode);

			
			int subNum = Integer.parseInt(lastCode.substring(parentCode.length(), lastCode.length()));
			subNum++;
			
			if(subNum < 10){
				return parentCode + "00" + subNum;
			}
			if(subNum < 100){
				return parentCode + "0" + subNum;
			}
			
			return parentCode + subNum;
		}
		
		public List<TdMenu> getMenuListLikeLevelCode(String menuCode){
			
			return dao.getMenuListLikeLevelCode(menuCode);
		}
}
