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
			<a href="userList.shtml?categoryId=${category.id}"> ${category.menuName }管理</a> /
			<a style="color: green;">${category.menuName }添加</a>
		</div>
<div>
<form class="form-horizontal" action="userAdd.shtml" method="post"
				enctype="multipart/form-data" id="userForm" name="userForm">
<fieldset>

<!-- Form Name -->
<legend>${category.menuName }添加</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="loginName">账户名</label>
  <div class="col-md-4">
    <input id="loginName" name="loginName" type="text" placeholder="账户名" class="form-control" >
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>

<div class="form-group">
  <label class="col-md-2 control-label" for="password">密码</label>
  <div class="col-md-4">
    <input id="password" name="password" type="password" placeholder="密码" class="form-control">
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="trueName">真实姓名</label>
  <div class="col-md-4">
    <input id="trueName" name="trueName" type="text" placeholder="真实姓名" class="form-control">
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>

<div class="form-group">
  <label class="col-md-2 control-label" for="mobile">手机号码</label>
  <div class="col-md-4">
    <input id="mobile" name="mobile" type="text" placeholder="手机号码" class="form-control">
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>
<div class="form-group">
  <label class="col-md-2 control-label" for="email">邮件地址</label>
  <div class="col-md-4">
    <input id="email" name="email" type="text" placeholder="邮件地址" class="form-control">
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>


<div class="form-group">
  <label class="col-md-2 control-label" for="roleId">角色</label>
  <div class="col-md-4">
   <select id="roleId" name="roleId" class="form-control ">
    <c:forEach var="role" items="${roleList }">
    <option value="${role.id }">${role.roleName }</option>
    </c:forEach>
    </select>
    
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
			$("#userForm").validator({
			    fields: {
			    	loginName: "账户:required;",
			    	password: "密码:required;",
			    	roleId: "角色:required;"
			    },
			    valid: function(form){
			        //表单验证通过，提交表单到服务器
			    	ajaxSubmit();
			    }
			});
			
		});

		function ajaxSubmit(){
			
			var url = 'userAdd.shtml';
			var data = $('#userForm').serialize();
			var asynCallBack = addEstateCallback;
			asynDataQuery(url,"post",data,asynCallBack,false);
			function addEstateCallback(datas){
				rtn = eval("("+datas+")");
				//alert(rtn.msg);
				if(rtn.rtnCode == 0){
	        		window.location.href="userAddOk.shtml?categoryId=${category.id}";
	        	}else{
	        		alert("添加${category.menuName}失败，请稍后再试或者联系管理员！");
	        	}
			}
		}	
	</SCRIPT>
	</body>
</html>