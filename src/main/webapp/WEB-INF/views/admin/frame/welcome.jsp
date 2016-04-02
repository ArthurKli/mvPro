<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
	<base href="<%=basePath%>">

	<title>列表</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
	<script type="text/javascript" src="${ctxStatic}/common/js/Clock.js">
	<script type="text/javascript">
	$(document).ready(function() {

	} );
	</script>
	<style type="text/css">
	.pa span{
		font-size: 10pt;
	}
	.searchD {
		margin-top: 10px;
	}
	.tab td{
		font-size:10pt;
	}
	.toptr td{
		font-size:11pt;
		font-weight: bold;
		line-height:24px;
	}
	.tds{
		font-size:9pt;
		font-weight: inherit;
		background:#DCDCDC;
		text-align: left;
		cursor: pointer; 
	}
	.dataTables_length{
		display: none;
	}
	a{
		color: #2275AC;
	}
	</style>
	</head>

	<body >
		<form action="placardAjax.action?comment=postListRole" id="formA" method="post">
			<div class="map">
				当前位置：
				欢迎页
			</div>
			<div class="top_operate"
				style="margin-top: -20px; margin-right: 6px; display: inline; width: 100%">
				
			</div>

			<div align="center" style="padding: 8px;background-color: gray;">
				<object width="690" height="100%" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,19,0" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000">
					<param value="${ctxStatic}/common/swf/20101262241501.swf" name="movie">
					<param value="high" name="quality">
					<embed width="690" height="200" type="application/x-shockwave-flash" pluginspage="http://www.macromedia.com/go/getflashplayer" quality="high" src="${ctxStatic}/common/swf/20101262241501.swf">
				</object>
			</div>
		</form>		
	</body>
</html>