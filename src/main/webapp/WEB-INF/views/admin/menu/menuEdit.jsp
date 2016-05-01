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
			<a href="menuList.shtml?${category.id }"> ${category.menuName }</a> /
			<a style="color: green;">${category.menuName }修改</a>
		</div>
		<ul class="nav nav-tabs">
			<li><a href="menuList.shtml?categoryId=${category.id}">${category.menuName }列表</a></li>
			<li class="active"><a href="menuAdd.shtml?categoryId=${category.id}">${category.menuName }修改</a></li>
		</ul>
<div>
<form class="form-horizontal" action="menuEdit.shtml" method="post"
				enctype="multipart/form-data" id="menuForm" name="menuForm">
<fieldset>
<input id="id" name="id" value="${menu.id }" type="hidden"/>
<!-- Form Name -->
<legend>${category.menuName }修改</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="menuName">栏目名称</label>
  <div class="col-md-4">
    <input id="menuName" name="menuName" type="text" placeholder="栏目名称" class="form-control" value="${menu.menuName }" >
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>

<div class="form-group">
  <label class="col-md-2 control-label" for="menuDesc">栏目描述</label>
  <div class="col-md-4">
    <input id="menuDesc" name="menuDesc" type="text" placeholder="栏目描述" class="form-control" value="${menu.menuDesc }" >
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>

<div class="form-group">
  <label class="col-md-2 control-label" for="menuHref">栏目链接</label>
  <div class="col-md-4">
    <input id="menuHref" name="menuHref" type="text" placeholder="栏目链接" class="form-control" value="${menu.menuHref }" >
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>

<div class="form-group">
  <label class="col-md-2 control-label" for="menuPriority">栏目优先级</label>
  <div class="col-md-4">
    <input id="menuPriority" name="menuPriority" type="text" placeholder="栏目优先级" class="form-control" value="${menu.menuPriority }" >
    <p class="text-danger" id="user-text-danger"></p>
  </div>
</div>
<c:set value="${fn:length(menu.menuCode)}"  var="pCodeLen" />
<c:set value="${fn:substring(menu.menuCode, 0, pCodeLen - 3)}"  var="pCode" />
<div class="form-group">
  <label class="col-md-2 control-label" for="parentMenuCode">父级目录</label>
  <div class="col-md-4">
   <select id="parentMenuCode" name="parentMenuCode" class="form-control" ${isLeafMenu ? '':'disabled' }>
    <c:forEach var="m" items="${menuList }">
    <c:if test="${m.id != menu.id }">
        <option value="${m.menuCode }" ${m.menuCode==pCode ? 'selected':'' }>${m.menuName }</option>
    </c:if>

    </c:forEach>
    </select>
    
  </div>
</div>

 <div class="form-group">
  <label class="col-md-2 control-label" for="permList">权限类型</label>
  <div class="col-md-4">
     <select id="menuPerms" name="menuPerms" class="form-control ">
     <option value="all">完全开放</option>
    <c:forEach var="perm" items="${allPermList }">
    <option value="${perm.permType }" ${perm.permType==menu.menuPerms ? 'selected':'' }>${perm.permName }</option>
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
					$("#menuForm").validator({
					    fields: {
					    	menuName: "栏目名称:required;",
					    	menuHref: "栏目链接:required;",
					    	menuPriority: "优先级:required;integer;"
					    },
					    valid: function(form){
					        //表单验证通过，提交表单到服务器
					    	ajaxSubmit();
					    }
					});
					
					
				});

				function ajaxSubmit(){
					
					var url = 'menuEdit.shtml';
					var data = $('#menuForm').serialize();
					var asynCallBack = addEstateCallback;
					asynDataQuery(url,"post",data,asynCallBack,false);
					function addEstateCallback(datas){
						rtn = eval("("+datas+")");
						alert(rtn.msg);
						if(rtn.rtnCode == 0){
			        		window.location.href="menuList.shtml?categoryId=${category.id}";
			        	}else{
			        		alert("修改${category.menuName}失败，请稍后再试或者联系管理员！");
			        	}
					}
				}
	</SCRIPT>
	</body>
</html>