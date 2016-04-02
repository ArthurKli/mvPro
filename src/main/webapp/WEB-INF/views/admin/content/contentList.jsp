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
			<a href="contentAdd.shtml?categoryId=${category.id}">${category.menuName }管理</a> /
			<a style="color: green;">${category.menuName }列表</a>
		</div>
		 <ul class="nav nav-tabs">
			<li class="active"><a href="contentList.shtml?categoryId=${category.id}">${category.menuName }列表</a></li>
			<c:if test="${enableToAdd }">
			<li><a href="contentAddView.shtml?categoryId=${category.id}">${category.menuName }添加</a></li>
			</c:if>
		</ul>
					
		<nav class="navbar navbar-default" >
		<form class="navbar-form navbar-left" role="search" method="post" action="contentList.shtml?categoryId=${category.id }">
  
            <div class="form-group">
                <input type="text"  class="form-control" value="${contentId }" placeholder="ID" id="contentId" name="contentId">
            </div>
            <div class="form-group">
                <input type="text"  class="form-control" value="${contentTitle }" placeholder="标题" id="contentTitle" name="contentTitle">
            </div>
            <div class="form-group">
              <input id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit" value="查询" />  
              <c:if test="${enableToAdd }">  
              	<input id="delbutton" name="delbutton" class="btn btn-primary" type="button" value="删除" />      
              </c:if>      
            </div>
         </form>
			

<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
			<c:if test="${enableToAdd }"><th width="4%">删除</th>
			</c:if>
				<th width="8%">ID</th>
				<th width="29%">标题</th>
				<th width="10%">作者</th>
				<th width="5%">优先级</th>
				<th width="13%">创建时间</th>
				<th width="13%">更新时间</th>
				<th width="20%">操作</th>
			</tr>
		</thead>
		<tbody>

		<c:forEach var="content" items="${page.list }">
		<tr>
		<c:if test="${enableToAdd }"><td class="del-checkbox"><input  id="del-checkbox-${content.contentId }" type="checkbox"></td></c:if>
				<td>${content.contentId }</td>
				<td><a href="${basePath }content/${category.id}/${content.contentId }.shtml" target="_brank" title="${content.contentTitle }">${fn:substring(content.contentTitle, 0, 20)}<c:if test="${fn:length(content.contentTitle) > 20}">...</c:if></a></td>
				<td>${content.contentSubTitle }</td>
				<td>${content.contentPriority }</td>
				<td><t:dateTag date="${content.createTime }"  pattern="yyyy-MM-dd HH:mm:ss"></t:dateTag></td>
				<td><t:dateTag date="${content.modifyTime }"  pattern="yyyy-MM-dd HH:mm:ss"></t:dateTag></td>
				
				<td>
					<a href="contentDesc.shtml?contentId=${content.contentId }&categoryId=${category.id}"  class="btn btn-default badge"><span class="glyphicon glyphicon-eye-open"></span>查看</a>
	    			<a href="contentEditView.shtml?contentId=${content.contentId }&categoryId=${category.id}"  class="btn btn-default badge"><span class="glyphicon glyphicon-pencil"></span>修改</a>
					<c:if test="${enableToAdd }"><a href="#" onclick="return confirmx('${category.menuName }', 'contentDel.shtml?contentId=${content.contentId }')" class="btn btn-default badge"><span class="glyphicon glyphicon-trash">删除</a>
					</c:if>
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
                return "contentList.shtml?categoryId=${category.id}&contentId=${conentId}&contentTitle="+encodeURIComponent('${contentTitle}')+"&pageNum="+page;
            }
        }

        $('#bp-3-element-test').bootstrapPaginator(options);
    $(function(){
    	$("#delbutton").click(function(){
    		var obj=$(".del-checkbox input[type=checkbox]:checked");
    		if(obj.size()==0){
    			alert("请选择要删除的选项！");
    			return false;
    		}
    		
    		
    		var arrayObj = new Array();//创建一个数组
    		obj.each(function(i){
    			var delId=this.id.substring(13);
    			arrayObj.push(delId);
    		 });
    		batchDel("contentDel.shtml?contentId=",arrayObj);
    		
    	});
    	});
    </script>
                <div id="dialog_simple" title="">
                </div>
  </body>
</html>