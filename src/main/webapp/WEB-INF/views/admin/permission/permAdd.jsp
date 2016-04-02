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
			<a href="permList.shtml?categoryId=${category.id}"> ${category.menuName }管理</a> /
			<a style="color: green;">${category.menuName }添加</a>
		</div>
<div>
<form class="form-horizontal" action="permAdd.shtml" method="post"
				enctype="multipart/form-data" id="permForm" name="permForm">
<fieldset>

<!-- Form Name -->
<legend>${category.menuName }添加</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="permName">权限名</label>
  <div class="col-md-4">
    <input id="permName" name="permName" type="text" placeholder="权限名" class="form-control" >
    <p class="text-danger" id="perm-text-danger"></p>
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="permDesc">权限描述</label>
  <div class="col-md-4">
    <input id="permDesc" name="permDesc" type="text" placeholder="权限描述" class="form-control">
    <p class="text-danger" id="perm-text-danger"></p>
  </div>
</div>

<div class="form-group">
  <label class="col-md-2 control-label" for="permType">权限类型</label>
  <div class="col-md-4">
    <input id="permType" name="permType" type="text" placeholder="权限类型" class="form-control" >
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
			var url = 'permAdd.shtml';
			var data = $('#permForm').serialize();
			var asynCallBack = addEstateCallback;
			asynDataQuery(url,"post",data,asynCallBack,false);
			function addEstateCallback(datas){
				rtn = eval("("+datas+")");
				//alert(rtn.msg);
				if(rtn.rtnCode == 0){
	        		window.location.href="permAddOk.shtml?categoryId=${category.id}";
	        	}else{
	        		alert("添加${category.menuName}失败，请稍后再试或者联系管理员！");
	        	}
			}
		}	
	</SCRIPT>
	</body>
</html>