package com.kli.tools.tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.kli.constants.BaseConstants;
import com.kli.service.base.WrapTreeNode;
import com.kli.tools.StringUtil;
/**
 * 建树工具类
 * @author linrchang
 *
 */
public class TreeUtil {
	/**
	 * 日志
	 */
	public static final Logger log = Logger.getLogger(TreeUtil.class);
	
	/**
	 * 查找树
	 * @param wrapTreeNode
	 * @param levelProperty
	 * @param datas
	 * @param treeNodes
	 * @param parentLevelCode
	 */
	public static void generateTree(WrapTreeNode wrapTreeNode,String levelProperty,List datas,List<TreeNode> treeNodes, String parentLevelCode){
		List children = findDirectChildern(levelProperty, datas, parentLevelCode);
		for(Iterator it = children.iterator();it.hasNext();){
			Object data = it.next();
			TreeNode node = wrapTreeNode.wrapTreeNode(data);
			String levelCode = "";
			try {
				levelCode = BeanUtils.getProperty(data, levelProperty);
			} catch (Exception e) {
				log.error("级别编码为null");
			}
			
			if(isHasDirectChildern(levelProperty, datas, levelCode)){
				List<TreeNode> list = new ArrayList<TreeNode>();
				generateTree(wrapTreeNode, levelProperty, datas, list, levelCode);
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
	 * @param wrapTreeNode
	 * @param levelProperty
	 * @param datas
	 * @param treeNodes
	 * @param parentLevelCode
	 */
	private static void generateDirectTree(WrapTreeNode wrapTreeNode,String levelProperty,List datas,List<TreeNode> treeNodes, String parentLevelCode){
		List children = findDirectChildern(levelProperty, datas, parentLevelCode);
		for(Iterator it = children.iterator();it.hasNext();){
			Object data = it.next();
			TreeNode node = wrapTreeNode.wrapTreeNode(data);
			String levelCode = "";
			try {
				levelCode = BeanUtils.getProperty(data, levelProperty);
			} catch (Exception e) {
				log.error("级别编码为null");
			}
			if(isHasDirectChildern(levelProperty, datas, levelCode)){
				node.setChildren(new ArrayList<TreeNode>());
				node.setParent(true);
			}
			treeNodes.add(node);
		}
	}
	
	/**
	 * 查找直接子节点
	 * @param levelProperty
	 * @param datas
	 * @param parentLevelCode
	 * @return
	 */
	private static List findDirectChildern(String levelProperty,List datas,String parentLevelCode){
		String regx = "";
		if(parentLevelCode.equals("root")){
			regx = "\\d{3}";
		}else{
			regx = parentLevelCode + "\\d{3}";
		}
		List children = new ArrayList();
		
		for(Iterator it = datas.iterator();it.hasNext();){
			Object data = it.next();
			String code = "";
			try {
				code = BeanUtils.getProperty(data, levelProperty);
			} catch (Exception e) {
				log.error("级别编码为null");
			}
			if(code.matches(regx)){
				children.add(data);
			}
		}
		return children;
	}
	
	/**
	 * 判断是否存在直接子节点
	 * @param levelProperty
	 * @param datas
	 * @param parentLevelCode
	 * @return
	 */
	private static boolean isHasDirectChildern(String levelProperty,List datas,String parentLevelCode){
		String regx = "";
		if(parentLevelCode.equals("root")){
			regx = "\\d{3}";
		}else{
			regx = parentLevelCode+"\\d{3}";
		}
		List children = new ArrayList();

		for(Iterator it = datas.iterator();it.hasNext();){
			Object data = it.next();
			String code = "";
			try {
				code = BeanUtils.getProperty(data, levelProperty);
			} catch (Exception e) {
				log.error("级别编码为null");
			}
			if(code.matches(regx)){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取树节点json格式
	 * @param treeNodeList
	 * @param pid
	 * @return
	 */
	private static String treeNodeToZTreeJson(List<TreeNode> treeNodes,Long pid ,String treeType){
		StringBuffer json = new StringBuffer();
		for (TreeNode treeNode : treeNodes) {
			json.append("{");
			json.append("id:"+treeNode.getId());
			json.append(",pId:"+pid);
			json.append(",name:\""+treeNode.getName()+"\"");
			if(BaseConstants.TREE_TYPE_CATEGORY.equals(treeType)){
				if(!treeNode.isParent()){
					json.append(",url:\""+treeNode.getHref()+"\"");
				}
				json.append(",target:\"rightFrame\"");
				if(treeNode.isParent()){
					json.append(",isParent:\"true\"");
				}
			}
			json.append("},");
			if(!StringUtil.isEmpty(treeNode.getChildren())){
				//递归获取树节点的json
				json.append(treeNodeToZTreeJson(treeNode.getChildren(), treeNode.getId() ,treeType));
			}
		}
		return json.toString();
	}
	/**
	 * 获取ZTree的json
	 * @param treeNode
	 * @param pid
	 * @return
	 */
	public static String getZTreeJsonData(List<TreeNode> treeNodes,Long pid ,String treeType){
		String jsonData = "";
		StringBuffer json = new StringBuffer();
		json.append("[");
		jsonData = treeNodeToZTreeJson(treeNodes, pid ,treeType);
		jsonData = jsonData.substring(0, jsonData.length()-1);//去除多余逗号
		json.append(jsonData);
		json.append("]");
		jsonData = json.toString();
		return jsonData;
	}
}
