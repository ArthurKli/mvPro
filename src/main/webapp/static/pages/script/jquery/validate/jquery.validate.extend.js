/**
 * @author 麦沛添 maipeitian@foreseee.com.cn 
 * Includes jQuery.js
 * Includes jquery.validate.js
 * Includes ascyncontrol.js 
 */

/**
 * 添加正则验证方法 regex :传入一个正则表达式
 */
jQuery.validator.addMethod("regex", // addMethod第1个参数:方法名称
		function(value, element, regex) { // addMethod第2个参数:验证方法，参数（被验证元素的值，被验证元素，参数）
			var exp = new RegExp(regex); // 实例化正则对象，参数为传入的正则表达式
			if (value != "")
				return exp.test(value); // 测试是否匹配
			else
				return true;
		}, "格式错误！"); // addMethod第3个参数:默认错误信息

/**
 * 添加选择表单验证 params：传入布尔值，标志是否是必选
 */
jQuery.validator.addMethod("selectCheck", // addMethod第1个参数:方法名称
		function(value, element, params) { // addMethod第2个参数:验证方法，参数（被验证元素的值，被验证元素，参数）
			if (params&&element!=null) {
				if (value != "") {
					return true;
				} else {
					return false;
				}
			}
		}, "请选择！"); // addMethod第3个参数:默认错误信息

/**
 * 添加radio验证 clazz 需要验证标签的class值
 */
jQuery.validator.addMethod("checkedCheck", // addMethod第1个参数:方法名称
		function(value, element, clazz) { // addMethod第2个参数:验证方法，参数（被验证元素的值，被验证元素，参数）
			var status = false;
			$("." + clazz).each(function(i) {
						if (this.checked) {
							status = true;
						}
					});
			return status;

		}, "请选择！"); // addMethod第3个参数:默认错误信息

/**
 * 添加input验证 该验证是需要前提条件情况下验证
 */
jQuery.validator.addMethod("checkedInput", // addMethod第1个参数:方法名称
		function(value, element, fun) { // addMethod第2个参数:验证方法，参数（被验证元素的值，被验证元素，参数）
			if(eval("("+fun+")")&&value!="")
				{
				return true;
				}else{
					return false;
				}

		}, "请输入！"); // addMethod第3个参数:默认错误信息

/**
 * 添加ajax验证 params:访问后台的URL 第一次访问需要返回一个等待时间（数字类型）,时间的单位是毫秒
 * 第二次访问需要返回一个布尔值，true为验证通过，false为验证失败
 * 
 * modify by Tim 2012-02-02该校验规则已被删除，请直接使用"remote"校验规则，"remote"校验规则使用了异步框架进行异步校验，详情请参考jquery.validate.js的remote方法定义
 */

//jQuery.validator.addMethod("ajax", // addMethod第1个参数:方法名称
//		function(value, element, params) { // addMethod第2个参数:验证方法，参数（被验证元素的值，被验证元素，参数）
//			if (value == '') {
//				return true;
//			}
//			var isFinish = false;//异步校验是否已返回结果
//			var returnFlag = false;//校验结果
//			function callback(status,msg,qdt,responseData){
//				isFinish = true;
//				var datas = $.parseJSON($(responseData).find("result > responseContent").text());
//				returnFlag = datas.returnFlag;
//			}
//			fsAsynDataLoader.asynRequestData(params,{
//				value: value
//			},"xml",10000,callback,params,"xml");
//			
////			while(!isFinish){
////				//等待异步校验返回结果
////			}
//			//结果已返回
//			return true;
//		}, "异步验证中！"); // addMethod第3个参数:默认错误信息