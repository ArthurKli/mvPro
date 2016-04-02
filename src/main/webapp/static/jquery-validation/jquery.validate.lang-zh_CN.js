/**
 * @author heguiqing heguiqing@foreseee.com.cn 表单校验控件提示信息的中文翻译
 */
$.extend($.validator, {
			messages : {
				required : "&nbsp;输入框不能为空。",
				remote : "&nbsp;请修改该输入框数据。",
				email : "&nbsp;请输入有效的电子邮箱地址。",
				url : "&nbsp;请输入正确的URL地址。",
				date : "&nbsp;请输入正确的日期。",
				dateISO : "&nbsp;请输入正确的日期 (ISO)。",
				number : "&nbsp;请输入一个有效的数字。",
				digits : "&nbsp;该输入框只能输入数字。",
				creditcard : "&nbsp;请输入一个有效的的信用卡号码。",
				equalTo : "&nbsp;请再次输入相同的值。",
				accept : "&nbsp;请输入一个有效的扩展的价值。",
				maxlength : $.validator.format("&nbsp;请输入不超过{0}个字符。"),
				minlength : $.validator.format("&nbsp;请输入至少{0}个字符。"),
				rangelength : $.validator.format("&nbsp;请输入值之间的{0}和{1}个字符长。"),
				range : $.validator.format("&nbsp;请输入{0}和{1}之间的值。"),
				max : $.validator.format("&nbsp;请输入一个值小于或等于{0}。"),
				min : $.validator.format("&nbsp;请输入一个值大于或等于{0}。")
			}
		});