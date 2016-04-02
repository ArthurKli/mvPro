
package com.kli.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 控制器支持类
 * @author kai
 * @version 2013-3-23
 */

public abstract class BaseController {

	/**
	 * 日志对象
	 */
	protected Logger log = LoggerFactory.getLogger(getClass());


	
}
