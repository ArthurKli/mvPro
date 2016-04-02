<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加项目</title>
		<%@include file="/WEB-INF/views/include/head.jsp" %>

	</head>
	<body>
		<div class="map mapAdd">
			当前位置：
			<a href="roleList.shtml?${category.id }"> ${category.menuName }</a> /
			<a style="color: green;">${category.menuName }修改</a>
		</div>
		<ul class="nav nav-tabs">
			<li><a href="roleList.shtml?categoryId=${category.id}">${category.menuName }列表</a></li>
			<li class="active"><a href="roleAdd.shtml?categoryId=${category.id}">${category.menuName }修改</a></li>
		</ul>
<div>
<form class="form-horizontal" action="roleEdit.shtml" method="post"
				enctype="multipart/form-data" id="roleForm" name="roleForm">
<fieldset>
<input id="id" name="id" value="${role.id }" type="hidden"/>
<!-- Form Name -->
<legend>${category.menuName }修改</legend>

<!-- Text input-->


<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="roleName">角色名</label>
  <div class="col-md-4">
    <input id="roleName" name="roleName" type="text" placeholder="角色名" class="form-control" value="${role.roleName }" >
    <p class="text-danger" id="role-text-danger"></p>
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="roleDesc">角色描述</label>
  <div class="col-md-4">
    <input id="roleDesc" name="roleDesc" type="text" placeholder="角色描述" class="form-control" value="${role.roleDesc }">
    <p class="text-danger" id="role-text-danger"></p>
  </div>
</div>



<div class="form-group">
  <label class="col-md-2 control-label" for="permList">权限类型</label>
  <div class="col-md-4">
  <c:forEach items="${allPermList }" var="perm">
  <c:set var="hasPerm" value=""/>
  <c:forEach items="${hasPermList }" var="has">
    <c:if test="${has.id == perm.id}">
  <c:set var="hasPerm" value="checked"/>
  </c:if>
  </c:forEach>

      <div class="checkbox">
        <label class="checkbox">
         <input name="perm_${perm.id }" type="checkbox" value="${perm.permType }" ${hasPerm }/>
         ${perm.permName }
        </label>
       </div>
  </c:forEach>  
  </div>
</div>

<!-- Button -->
<div class="form-group">
  <label class="col-md-2 control-label" for="singlebutton"></label>
  <div class="col-lg-6 col-md-4">
    <input id="singlebutton" name="singlebutton" class="btn btn-primary" type="submit" value="提交" />
  </div>
</div>
<input type="hidden" name="categoryId" id="categoryId" value="${category.id }"/>
</fieldset>
</form>
</div>
<hr>
		<SCRIPT type="text/javascript">
				$(document).ready(function(){
					$("#roleForm").validator({
					    fields: {
					    	roleName: "名称:required;",
					    	roleType:"类型:required;"
					    },
					    valid: function(form){
					        //表单验证通过，提交表单到服务器
					    	ajaxSubmit();
					    }
					});
					
					
				});

				function ajaxSubmit(){
					var len = $("input[type='checkbox']:checked").length; 
					if(len == 0){
						alert("至少需要选择一项权限");
						return false;
					}
					
					var url = 'roleEdit.shtml';
					var data = $('#roleForm').serialize();
					var asynCallBack = addEstateCallback;
					asynDataQuery(url,"post",data,asynCallBack,false);
					function addEstateCallback(datas){
						rtn = eval("("+datas+")");
						alert(rtn.msg);
						if(rtn.rtnCode == 0){
			        		window.location.href="roleList.shtml?categoryId=${category.id}";
			        	}else{
			        		alert("修改${category.menuName}失败，请稍后再试或者联系管理员！");
			        	}
					}
				}
	</SCRIPT>
	</body>
</html>