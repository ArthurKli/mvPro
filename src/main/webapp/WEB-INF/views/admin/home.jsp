<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	String linkpage = request.getParameter("linkpage");
	String tel=(String)request.getAttribute("tel");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>后台管理系统</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">



	</head>

		<frameset rows="50,*" framespacing="0" frameBorder=no>
			<frame src="admin/top.shtml" name="topFrame" noresize scrolling="no" MARGINHEIGHT="0" MARGINWIDTH="0" >
			<frameset border=0 frameSpacing=0 frameBorder=no id ="frameset" cols="200,10,*" rows ="*"  >
				<frame src="admin/leftFrame.shtml" name="leftFrame" scrolling="auto" marginheight="0" marginwidth="0"  noresize="noresize" id="leftFrame">
				<frame src="admin/mid.shtml" name="midFrame"   marginheight="0" marginwidth="0" scrolling="No" noresize="noresize" id="midFrame" />
				<frame src="admin/welcome.shtml" name="rightFrame" id="mainFrame" marginheight="0" marginwidth="0">
			</frameset>
		</frameset>
	
	<body>
		
	
	</body>
</html>
