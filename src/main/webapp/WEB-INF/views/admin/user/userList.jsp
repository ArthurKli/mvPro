<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <title></title>
	<%@include file="/WEB-INF/views/admin/include/head.jsp" %>
  </head>
  <body>
    <div class="map mapAdd">
			当前位置：
			<a href="userList.shtml">${category.menuName }管理</a> /
			<a style="color: green;">${category.menuName }列表</a>
		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a href="userList.shtml?categoryId=${category.id}">${category.menuName }列表</a></li>
			<li><a href="userAddView.shtml?categoryId=${category.id}">${category.menuName }添加</a></li>
		</ul>
		
		<nav class="navbar navbar-default" >
		<form class="navbar-form navbar-left" user="search" method="post" action="userList.shtml?categoryId=${category.id }">
  
            <div class="form-group">
                <input type="text"  class="form-control" value="${loginName }" placeholder="登录账户" id="loginName" name="loginName">
            </div>
            <div class="form-group">
                <input type="text"  class="form-control" value="${trueName }" placeholder="真实姓名" id="trueName" name="trueName">
            </div>
            
            <div class="form-group">
              <input id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit" value="查询" />  
              <c:if test="${enableToAdd }">  
              	<input id="delbutton" name="delbutton" class="btn btn-primary" type="button" value="删除" />      
              </c:if>      
            </div>
         </form>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>ID</th><th>账户</th><th>角色</th><th>真实姓名</th><th>手机号</th><th>邮箱</th><th>创建时间</th><th>更新时间</th><th>操作</th></tr></thead>
		<tbody>

		<c:forEach var="user" items="${page.list }">
		<tr>
				<td>${user.id }</td>
				<td>${user.loginName }</td>
				<td>${user.roleName }</td>
				<td>${user.trueName }</td>
				<td>${user.mobile }</td>
				<td>${user.email }</td>
				<td><t:dateTag date="${user.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"></t:dateTag></td>
				<td><t:dateTag date="${user.updateTime }"  pattern="yyyy-MM-dd HH:mm:ss"></t:dateTag></td>	
				<td>
	    			<a href="userEditView.shtml?userId=${user.id }&categoryId=${category.id}"  class="btn btn-default badge"><span class="glyphicon glyphicon-pencil"></span>修改</a>
					<a href="#" onclick="return confirmx('${category.menuName }', 'userDel.shtml?userId=${user.id }')" class="btn btn-default badge"><span class="glyphicon glyphicon-trash">删除</a>
				</td>
			</tr>
		</c:forEach>
		
		</tbody>
	</table>
   <div>
    <ul id='bp-3-element-test'></ul>
</div>
    <script type='text/javascript'>
    var options = {
            bootstrapMajorVersion:3,
            currentPage: '${page.pageNo}',
            numberOfPages: 5,
            totalPages:'${page.totalPage}',
            pageUrl: function(type, page, current){
                return "userList.shtml?categoryId=${category.id }&pageNum="+page;
            }
        }

        $('#bp-3-element-test').bootstrapPaginator(options);
    </script>
                <div id="dialog_simple" title="">
                </div>
  </body>
</html>