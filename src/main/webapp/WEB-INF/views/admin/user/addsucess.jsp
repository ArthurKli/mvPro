<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'success.jsp' starting page</title>
		<%@include file="/WEB-INF/views/include/head.jsp" %>
	</head>

	<body>
	<div class="page-header">
  <h1>添加${category.menuName }成功！</h1>
</div>
<button type="button" class="btn btn-default navbar-btn" onclick="location.href='userList.shtml?categoryId=${category.id }';">返回${category.menuName }列表</button>
<button type="button" class="btn btn-default navbar-btn"  onclick="location.href='userAddView.shtml?categoryId=${category.id }';">继续添加${category.menuName }</button>
	
		
	</body>
</html>
