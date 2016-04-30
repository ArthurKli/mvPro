package com.admin.service;

import com.admin.bean.TdMenu;
import com.admin.constants.BaseConstants;
import com.admin.dao.TdMenuDao;
import com.admin.service.base.CrudService;
import com.admin.tools.tree.TreeNode;
import com.admin.tools.tree.TreeUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 
 * <br>
 * <b>功能：</b>TdMenuService<br>
 */
 @Service
public class TdMenuService extends CrudService<TdMenuDao, TdMenu> {
		
		public String queryTree(String parentLevel) {

			List<TdMenu> allList = dao.findList(new TdMenu());
			List<TdMenu> menuList = new ArrayList<TdMenu>();
			Subject subject = SecurityUtils.getSubject();
			for(TdMenu m : allList){
				if (m.getMenuPerms().equals("all") || subject.isPermitted(m.getMenuPerms())) {
					menuList.add(m);
				}
			}
			
			List<TreeNode> treeNodes = new ArrayList<TreeNode>();
			TreeUtil.generateTree(allList, treeNodes, parentLevel);
            long pid = TreeUtil.getMenuId(allList, parentLevel);

			String treeJson = TreeUtil.getZTreeJsonData(treeNodes, pid ,BaseConstants.TREE_TYPE_CATEGORY);
			
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
