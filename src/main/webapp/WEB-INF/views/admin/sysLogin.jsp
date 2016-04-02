
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>登录111</title>
	<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta name="renderer" content="webkit"><meta http-equiv="X-UA-Compatible" content="IE=8,IE=9,IE=10" />
<meta http-equiv="Expires" content="0"><meta http-equiv="Cache-Control" content="no-cache"><meta http-equiv="Cache-Control" content="no-store">
<%@include file="/WEB-INF/views/include/head.jsp" %>
<script type="text/javascript">var ctx = '${ctx}', ctxStatic='${ctxStatic}';</script>
	<style type="text/css">
html, body, table {
	background-color: #f5f5f5;
	width: 100%;
	text-align: center;
}

.form-signin-heading {
	font-family: Helvetica, Georgia, Arial, sans-serif, 黑体;
	font-size: 36px;
	margin-bottom: 20px;
	color: #0663a2;
}

.form-signin {
	position: relative;
	text-align: left;
	width: 390px;
	padding: 25px 29px 29px;
	margin: 0 auto 20px;
	background-color: #fff;
	border: 1px solid #e5e5e5;
	-webkit-border-radius: 5px;
	-moz-border-radius: 5px;
	border-radius: 5px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
	box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
}

.form-signin .checkbox {
	margin-bottom: 10px;
	color: #0663a2;
}

.form-signin .input-label {
	font-size: 16px;
	line-height: 23px;
	width:300px;
	color: #999;
}

.form-signin .input-block-level {
	font-size: 16px;
	height: auto;
	padding: 7px;
	width: 300px;
	*padding-bottom: 0;
	margin-bottom:15px;
	_padding: 7px 7px 9px 7px;
}

.form-signin .btn.btn-large {
	font-size: 16px;
}

.form-signin #themeSwitch {
	position: absolute;
	right: 15px;
	bottom: 10px;
}

.form-signin div.validateCode {
	padding-bottom: 15px;
}

.mid {
	vertical-align: middle;
}

.header {
	height: 80px;
	padding-top: 20px;
}

.alert {
padding: 8px 35px 8px 14px;
	position: relative;
	width: 300px;
	margin: 0 auto;
	*padding-bottom: 0px;
}

.alert h4{
margin-top:0;
}
.alert-error {
    background-color: #f2dede;
    border-color: #eed3d7;
    color: #b94a48;
}
</style>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#loginForm").validator({
			    fields: {
			    	username: "账户:required;",
			    	password: "密码:required;"
			    }
			});
		});
		// 如果在框架或在对话框中，则弹出提示并跳转到首页
		if(self.frameElement && self.frameElement.tagName == "IFRAME" || $('#left').length > 0 || $('.jbox').length > 0){
			alert('未登录或登录超时。请重新登录，谢谢！');
			top.location = "${ctx}";
		}
/* 		function beforeLogin(){
			if($.trim($("#username").val()) == ''){
				$("#loginError").text("用户账号不能为空");
				$("#messageBox").removeClass("hide");
				return false;
			}
			if($.trim($("#password").val()) == ''){
				$("#loginError").text("用户密码不能为空");
				$("#messageBox").removeClass("hide");
				return false;
			}
		} */
		
		
		
	</script>
</head>
<body>
	<!--[if lte IE 6]><br/><div class='alert alert-block' style="text-align:left;padding-bottom:10px;"><a class="close" data-dismiss="alert">x</a><h4>温馨提示：</h4><p>你使用的浏览器版本过低。为了获得更好的浏览体验，我们强烈建议您 <a href="http://browsehappy.com" target="_blank">升级</a> 到最新版本的IE浏览器，或者使用较新版本的 Chrome、Firefox、Safari 等。</p></div><![endif]-->
	<div class="header">
		<div id="messageBox" class="alert alert-error ${empty message ? 'hide' : ''}">
		<button type="button" class="close" data-dismiss="alert">×</button>
			<span id="loginError" class="error">${message}</span>
		</div>

		
	</div>
	<h1 class="form-signin-heading">登录吧</h1>
	<form id="loginForm" class="form-signin" action="${ctx}/doLogin.shtml" method="post">
		<label class="input-label" for="username">登录名</label>
		<input type="text" id="username" name="username" class="input-block-level required" value="${username}">		
		
		<label class="input-label" for="password">密码</label>
		<input type="password" id="password" name="password" class="input-block-level required">
		<c:if test="${isValidateCodeLogin}"><div class="validateCode">
			<label class="input-label mid" for="validateCode">验证码</label>
			<sys:validateCode name="validateCode" inputCssStyle="margin-bottom:0;"  />
		</div></c:if>
		<%--
		<label for="mobile" title="手机登录"><input type="checkbox" id="mobileLogin" name="mobileLogin" ${mobileLogin ? 'checked' : ''}/></label> --%>
		<input class="btn btn-large btn-primary" type="submit" value="登 录"/>&nbsp;&nbsp;
		<label for="rememberMe" ><input type="checkbox" id="rememberMe" name="rememberMe" ${rememberMe ? 'checked' : ''}/> 记住用户名</label>

	</form>
	<div class="footer">
		Copyright &copy; 2012-2020 <a href="">盈世coremail</a> - Powered By <a href="http://jeesite.com" target="_blank">JeeSite</a> XT5
	</div>
</body>
</html>