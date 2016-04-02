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
			<a href="permList.shtml">${category.menuName }管理</a> /
			<a style="color: green;">${category.menuName }列表</a>
		</div>
		<ul class="nav nav-tabs">
			<li class="active"><a href="permList.shtml?categoryId=${category.id}">${category.menuName }列表</a></li>
			<li><a href="permAddView.shtml?categoryId=${category.id}">${category.menuName }添加</a></li>
		</ul>
		
		<nav class="navbar navbar-default" >
		<form class="navbar-form navbar-left" role="search" method="post" action="permList.shtml?categoryId=${category.id }">
  
            <div class="form-group">
                <input type="text"  class="form-control" value="${permId }" placeholder="ID" id="permId" name="permId">
            </div>
            <div class="form-group">
                <input type="text"  class="form-control" value="${permName }" placeholder="权限名" id="permName" name="permName">
            </div>
            <div class="form-group">
                <input type="text"  class="form-control" value="${permType }" placeholder="权限类型" id="permType" name="permType">
            </div>
            
            <div class="form-group">
              <input id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit" value="查询" />  
              <c:if test="${enableToAdd }">  
              	<input id="delbutton" name="delbutton" class="btn btn-primary" type="button" value="删除" />      
              </c:if>      
            </div>
         </form>
<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>ID</th><th>权限名</th><th>权限类型</th><th>描述</th><th>创建时间</th><th>更新时间</th><th>操作</th></tr></thead>
		<tbody>

		<c:forEach var="perm" items="${page.list }">
		<tr>
				<td>${perm.id }</td>
				<td>${perm.permName }</td>
				<td>${perm.permType }</td>
				<td>${perm.permDesc }</td>
				<td><t:dateTag date="${perm.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"></t:dateTag></td>
				<td><t:dateTag date="${perm.updateTime }"  pattern="yyyy-MM-dd HH:mm:ss"></t:dateTag></td>	
				<td>
	    			<a href="permEditView.shtml?permId=${perm.id }&categoryId=${category.id}"  class="btn btn-default badge"><span class="glyphicon glyphicon-pencil"></span>修改</a>
					<a href="#" onclick="return confirmx('${category.menuName }', 'permDel.shtml?permId=${perm.id }')" class="btn btn-default badge"><span class="glyphicon glyphicon-trash">删除</a>
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
                return "permList.shtml?categoryId=${category.id }&pageNum="+page;
            }
        }

        $('#bp-3-element-test').bootstrapPaginator(options);
    </script>
                <div id="dialog_simple" title="">
                </div>
  </body>
</html>