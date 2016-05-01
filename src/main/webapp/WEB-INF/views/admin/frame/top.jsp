<%@page contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ include file="/WEB-INF/views/admin/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<title>澳领集团后台管理</title>
		<link href="${ctxStatic}/bootstrap/3.0.3/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
		<link href="${ctxStatic}/common/css/le_admin.css" type="text/css" rel="Stylesheet" />
		<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script src="${ctxStatic}/bootstrap/3.0.3/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
  <script src="http://apps.bdimg.com/libs/html5shiv/3.7/html5shiv.min.js"></script>
  <script src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
		<script type="text/javascript">
	
		function loginout(){
			parent.window.location.href = "${ctx}/logout.shtml";
		}
		function cleanCache(){
			$.ajax({
				  type: "POST",
				  url: "${properties['url.baseUrl']}cleanAll.shtml",
				   success: function(msg){
					     alert( "缓存清理完成！");
					   }

				});
			
		}
			</script>

	</head>
	<!-- 	<body bgcolor="#F8F8FF" topmargin="0" marginwidth="0" marginheight="0" onload="sendRequest()">
 -->
	<body  topmargin="0" marginwidth="0" marginheight="0">
	<div id="header" class="navbar navbar-fixed-top">
	<div class="navbar-inner">
	<div class="brand">
			后台管理系统
		</div>
		
		<div class="collapse navbar-collapse">
          <ul class="nav navbar-nav pull-right">
                      <li class="active">
            <a title="回到首页"
					href="welcome.shtml" target="rightFrame"><span class="glyphicon glyphicon-home"></span></a></li>
            <li class="active">
            <a title="清除缓存"
					href="javascript:void(0);" onclick="cleanCache();" target="rightFrame"><span class="glyphicon glyphicon-refresh"></span></a></li>
            <li class="dropdown">
				    <a class="dropdown-toggle"  target="rightFrame" href="modifyPwdView.shtml" title="个人信息">您好, 管理员</a>
			  	 </li>
			  	 								<li class="divider-vertical">
								</li>
            <li><a href="#" onclick="loginout();">注销</a></li>
          </ul>
        </div>
	</div> 
	</div> 
	
</body>
</html>
