package com.admin.constants;

/**
 * leadex工程的常量文件
 * @author linrchang
 *
 */
public class BaseConstants {
	
	/**
	 * 日期格式。
	 */
	public static final String DATETIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
	/**
	 * 日期格式。
	 */
	public static final String DATE_FORMAT_STR = "yyyy-MM-dd";
	/**
	 * 时间格式。
	 */
	public static final String TIME_FORMAT_STR = "HH:mm:ss";
	
	/**
	 * 公司名称	 */
	public static final String COMPANY_NAME = "Leadex";
	
	
	/**
	 * page类的默认
	 */
	public static final int DEFAULT_PAGE_SIZE = 5;
	
	public static final int DEFAULT_PAGE_START = 0;
	
	public static final int DEFAULT_PAGE_CURRENT_PAGE = 1;
	
	
	/**
	 * mybatis类型
	 */
	public static final String POSTFIX_QUERY_ONE = ".queryOne";
	public static final String POSTFIX_QUERY_ALL = ".queryAll";
	public static final String POSTFIX_QUERY_LIST = ".queryList";
	public static final String POSTFIX_QUERY_PAGE_LIST = ".queryPageList";
	public static final String POSTFIX_QUERY_PRIMARYKEY = ".queryByPrimaryKey";
	public static final String POSTFIX_INSERT = ".insert";
	public static final String POSTFIX_UPDATE = ".update";
	public static final String POSTFIX_DELETE_PRIMARYKEY = ".deleteByPrimaryKey";
	public static final String POSTFIX_DELETE = ".delete";
	public static final String POSTFIX_COUNT = ".count";
	public static final String POSTFIX_GENERATEPOSITION = ".generatePosition";
	
	
	public static final String POSTFIX_ORDER_ASC = "asc";
	public static final String POSTFIX_ORDER_DESC = "desc";
	
	/**
	 * session user
	 */
	public static final String SESSION_USER="USER";
	
	/**
	 * 控制器返回类型
	 */
	public static final String CONTROLLER_SUCCESS = "success";
	public static final String CONTROLLER_FAIL = "fail";
	
	/**
	 * 状态类型
	 */
	public class StatusType{
		public  static final int STATUS_0 = 0;
		public  static final int STATUS_1 = 1;
	}
	
	
	/**
	 * 附件类型
	 */
	public static final String FILE_TYPE_VIDEO="VIDEO";
	public static final String FILE_TYPE_PIC="PIC";
	public static final String FILE_TYPE_ZIP="ZIP";
	public static final String FILE_TYPE_DOC="DOC";
	
	/**
	 * 评论类型
	 */
	public static final String CRITICISM_TYPE_CONTENT="CRI_CONTENT";
	public static final String CRITICISM_TYPE_FAVO="CRI_FAVO";
	
	public static final String RESOURCE_TYPE_CATEGORY = "CATEGORY";
	
	public static final String TREE_TYPE_CATEGORY = "TREE_CATEGORY";
	public static final String TREE_TYPE_CHECKBOX = "TREE_CHECKBOX";
	
	/**
	 * 返回值类型
	 * @author user
	 *
	 */
	public class ResultCode{
		public static final int SUCCESS = 0;
		
		public static final int FAILURE = 1;
		
		public static final int UNKNOW_ERROR = 2;
		
		public static final int PARAM_ERROR = 3;
		
		public static final int USER_NOT_FOUNT = 4;
		
		public static final int DUPLICATE_KEY = 5;
		
	}
	
	public class ControllerContants{
		public static final int CONTROLLER_ADD = 1;
		
		public static final int CONTROLLER_EDIT = 2;
	}
	
}
