<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>添加项目</title>
		<%@include file="/WEB-INF/views/admin/include/head.jsp" %>

	</head>
	<body>
		<div class="map mapAdd">
			当前位置：
			<a href="permList.shtml?${category.id }"> ${category.menuName }</a> /
			<a style="color: green;">${category.menuName }修改</a>
		</div>
		<ul class="nav nav-tabs">
			<li><a href="permList.shtml?categoryId=${category.id}">${category.menuName }列表</a></li>
			<li class="active"><a href="permAdd.shtml?categoryId=${category.id}">${category.menuName }修改</a></li>
		</ul>
<div>
<form class="form-horizontal" action="permEdit.shtml" method="post"
				enctype="multipart/form-data" id="permForm" name="permForm">
<fieldset>
<input id="id" name="id" value="${perm.id }" type="hidden"/>
<!-- Form Name -->
<legend>${category.menuName }修改</legend>

<!-- Text input-->


<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="permName">权限名</label>
  <div class="col-md-4">
    <input id="permName" name="permName" type="text" placeholder="权限名" class="form-control" value="${perm.permName }" >
    <p class="text-danger" id="perm-text-danger"></p>
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="permDesc">权限描述</label>
  <div class="col-md-4">
    <input id="permDesc" name="permDesc" type="text" placeholder="权限描述" class="form-control" value="${perm.permDesc }" >
    <p class="text-danger" id="perm-text-danger"></p>
  </div>
</div>

<div class="form-group">
  <label class="col-md-2 control-label" for="permType">权限类型</label>
  <div class="col-md-4">
    <input id="permType" name="permType" type="text" placeholder="权限类型" class="form-control" value="${perm.permType }"  >
    <p class="text-danger" id="perm-text-danger"></p>
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
					$("#permForm").validator({
					    fields: {
					    	permName: "名称:required;",
					    	permType:"类型:required;"
					    },
					    valid: function(form){
					        //表单验证通过，提交表单到服务器
					    	ajaxSubmit();
					    }
					});
					
					
				});

				function ajaxSubmit(){
					var url = 'permEdit.shtml';
					var data = $('#permForm').serialize();
					var asynCallBack = addEstateCallback;
					asynDataQuery(url,"post",data,asynCallBack,false);
					function addEstateCallback(datas){
						rtn = eval("("+datas+")");
						alert(rtn.msg);
						if(rtn.rtnCode == 0){
			        		window.location.href="permList.shtml?categoryId=${category.id}";
			        	}else{
			        		alert("修改${category.menuName}失败，请稍后再试或者联系管理员！");
			        	}
					}
				}
	</SCRIPT>
	</body>
</html>