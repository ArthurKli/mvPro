package com.admin.tools.tree;

import com.admin.bean.TdMenu;
import com.admin.constants.BaseConstants;
import com.admin.tools.StringUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 建树工具类
 *
 * @author Kai
 */
public class TreeUtil {
    /**
     * 日志
     */
    public static final Logger log = Logger.getLogger(TreeUtil.class);

    public static final String LEVEL_PRO = "menuCode"; //菜单层级  比如 001001001
    public static final String ROOT_LEVEL_CODE = "001"; //根目录的levelCode


    private static TreeNode wrapTreeNode(Object data) {
        TdMenu menus = (TdMenu) data;
        TreeNode node = new TreeNode();
        node.setId((long) menus.getId());
        node.setCode(menus.getMenuCode());
        node.setEntityType("CATEGORY");
        node.setHref(menus.getMenuHref());
        node.setParent(false);
        node.setName(menus.getMenuName());
        return node;
    }

    /**
     * 查找树
     *
     * @param datas
     * @param treeNodes
     * @param parentLevelCode
     */
    public static void generateTree(List datas, List<TreeNode> treeNodes, String parentLevelCode) {
        List children = findDirectChildern(datas, parentLevelCode);
        for (Iterator it = children.iterator(); it.hasNext(); ) {
            Object data = it.next();
            TreeNode node = wrapTreeNode(data);
            String levelCode = "";
            try {
                levelCode = BeanUtils.getProperty(data, LEVEL_PRO);
            } catch (Exception e) {
                log.error("级别编码为null");
            }

            if (isHasDirectChildern(datas, levelCode)) {
                List<TreeNode> list = new ArrayList<TreeNode>();
                generateTree(datas, list, levelCode);
                node.setChildren(list);
                node.setParent(true);
            }
            treeNodes.add(node);
        }
/*		for(int i = 0;i<children.size();i++){
            Object data = children.get(i);
			
		}*/
    }

    /**
     * 获取直接子树
     *
     * @param datas
     * @param treeNodes
     * @param parentLevelCode
     */
    private static void generateDirectTree(List datas, List<TreeNode> treeNodes, String parentLevelCode) {
        List children = findDirectChildern(datas, parentLevelCode);
        for (Iterator it = children.iterator(); it.hasNext(); ) {
            Object data = it.next();
            TreeNode node = wrapTreeNode(data);
            String levelCode = "";
            try {
                levelCode = BeanUtils.getProperty(data, LEVEL_PRO);
            } catch (Exception e) {
                log.error("级别编码为null");
            }
            if (isHasDirectChildern(datas, levelCode)) {
                node.setChildren(new ArrayList<TreeNode>());
                node.setParent(true);
            }
            treeNodes.add(node);
        }
    }

    public static int getMenuId(List datas, String levelCode) {
        if (levelCode == null || ROOT_LEVEL_CODE.equals(levelCode)) {
            return 0;
        }

        for (Iterator it = datas.iterator(); it.hasNext(); ) {
            Object data = it.next();
            String code = "";
            try {
                code = BeanUtils.getProperty(data, LEVEL_PRO);
            } catch (Exception e) {
                log.error("级别编码为null");
            }
            if (code.equals(levelCode)) {
                try {
                    return Integer.parseInt(BeanUtils.getProperty(data, "id"));
                } catch (Exception e) {
                    log.error("级别编码为null");
                }
            }
        }

        return 0;
    }

    /**
     * 查找直接子节点
     *
     * @param datas
     * @param parentLevelCode
     * @return
     */
    private static List findDirectChildern(List datas, String parentLevelCode) {
        String regx = "";
        if (parentLevelCode == null) {
            regx = "\\d{3}";
        } else {
            regx = parentLevelCode + "\\d{3}";
        }
        List children = new ArrayList();

        for (Iterator it = datas.iterator(); it.hasNext(); ) {
            Object data = it.next();
            String code = "";
            try {
                code = BeanUtils.getProperty(data, LEVEL_PRO);
            } catch (Exception e) {
                log.error("级别编码为null");
            }
            if (code.matches(regx)) {
                children.add(data);
            }
        }
        return children;
    }

    /**
     * 判断是否存在直接子节点
     *
     * @param datas
     * @param parentLevelCode
     * @return
     */
    private static boolean isHasDirectChildern(List datas, String parentLevelCode) {
        String regx = "";
        if (parentLevelCode == null) {
            regx = "\\d{3}";
        } else {
            regx = parentLevelCode + "\\d{3}";
        }
        List children = new ArrayList();

        for (Iterator it = datas.iterator(); it.hasNext(); ) {
            Object data = it.next();
            String code = "";
            try {
                code = BeanUtils.getProperty(data, LEVEL_PRO);
            } catch (Exception e) {
                log.error("级别编码为null");
            }
            if (code.matches(regx)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 获取树节点json格式
     *
     * @param pid
     * @return
     */
    private static String treeNodeToZTreeJson(List<TreeNode> treeNodes, Long pid, String treeType) {
        StringBuffer json = new StringBuffer();
        for (TreeNode treeNode : treeNodes) {
            json.append("{");
            json.append("id:" + treeNode.getId());
            json.append(",pId:" + pid);
            json.append(",name:\"" + treeNode.getName() + "\"");
            if (BaseConstants.TREE_TYPE_CATEGORY.equals(treeType)) {
                if (!treeNode.isParent()) {
                    json.append(",url:\"" + treeNode.getHref() + "\"");
                }
                json.append(",target:\"rightFrame\"");
                if (treeNode.isParent()) {
                    json.append(",isParent:\"true\"");
                }
            }
            json.append("},");
            if (!StringUtil.isEmpty(treeNode.getChildren())) {
                //递归获取树节点的json
                json.append(treeNodeToZTreeJson(treeNode.getChildren(), treeNode.getId(), treeType));
            }
        }
        return json.toString();
    }

    /**
     * 获取ZTree的json
     *
     * @param pid
     * @return
     */
    public static String getZTreeJsonData(List<TreeNode> treeNodes, Long pid, String treeType) {
        String jsonData = "";
        StringBuffer json = new StringBuffer();
        json.append("[");
        jsonData = treeNodeToZTreeJson(treeNodes, pid, treeType);
        if (jsonData.length() > 0) {
            jsonData = jsonData.substring(0, jsonData.length() - 1);//去除多余逗号
        }
        json.append(jsonData);
        json.append("]");
        jsonData = json.toString();
        return jsonData;
    }
}
