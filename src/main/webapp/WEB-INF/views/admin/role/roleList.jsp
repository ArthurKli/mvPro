<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <title></title>
	<%@include file="/WEB-INF/views/include/head.jsp" %>
  </head>
  <body>
    <div class="map mapAdd">
			当前位置：
			<a href="roleList.shtml">${category.menuName }管理</a> /
			<a style="color: green;">${category.menuName }列表</a>
		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a href="roleList.shtml?categoryId=${category.id}">${category.menuName }列表</a></li>
			<li><a href="roleAddView.shtml?categoryId=${category.id}">${category.menuName }添加</a></li>
		</ul>
		
		<nav class="navbar navbar-default" >
		<form class="navbar-form navbar-left" role="search" method="post" action="roleList.shtml?categoryId=${category.id }">
  
            <div class="form-group">
                <input type="text"  class="form-control" value="${roleId }" placeholder="ID" id="roleId" name="roleId">
            </div>
            <div class="form-group">
                <input type="text"  class="form-control" value="${roleName }" placeholder="角色名" id="roleName" name="roleName">
            </div>
			 <div class="form-group">
                <input type="text"  class="form-control" value="${permissions }" placeholder="角色类型" id="permissions" name="permissions">
            </div>
            
            <div class="form-group">
              <input id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit" value="查询" />  
              <c:if test="${enableToAdd }">  
              	<input id="delbutton" name="delbutton" class="btn btn-primary" type="button" value="删除" />      
              </c:if>      
            </div>
         </form>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>ID</th><th>角色名</th><th>权限</th><th>描述</th><th>创建时间</th><th>更新时间</th><th>操作</th></tr></thead>
		<tbody>

		<c:forEach var="role" items="${page.list }">
		<tr>
				<td>${role.id }</td>
				<td>${role.roleName }</td>
				<td>${role.permissions }</td>
				<td>${role.roleDesc }</td>
				<td><t:dateTag date="${role.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"></t:dateTag></td>
				<td><t:dateTag date="${role.updateTime }"  pattern="yyyy-MM-dd HH:mm:ss"></t:dateTag></td>	
				<td>
	    			<a href="roleEditView.shtml?roleId=${role.id }&categoryId=${category.id}"  class="btn btn-default badge"><span class="glyphicon glyphicon-pencil"></span>修改</a>
					<a href="#" onclick="return confirmx('${category.menuName }', 'roleDel.shtml?roleId=${role.id }')" class="btn btn-default badge"><span class="glyphicon glyphicon-trash">删除</a>
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
                return "roleList.shtml?categoryId=${category.id }&pageNum="+page;
            }
        }

        $('#bp-3-element-test').bootstrapPaginator(options);
    </script>
                <div id="dialog_simple" title="">
                </div>
  </body>
</html>