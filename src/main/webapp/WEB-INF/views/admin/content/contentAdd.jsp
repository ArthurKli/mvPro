<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/admin/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
	<head>
		<title>添加项目</title>
		<%@include file="/WEB-INF/views/admin/include/head.jsp" %>
		<script type="text/javascript" src="${ctxStatic }/ckeditor/ckeditor.js"></script>
		<script type="text/javascript" src="${ctxStatic }/ckfinder/ckfinder.js"></script>
	</head>
	<body>
		<div class="map mapAdd">
			当前位置：
			<a href="contentAdd.shtml"> ${category.menuName }</a> /
			<a style="color: green;">${category.menuName }发布</a>
		</div>
		<ul class="nav nav-tabs">
			<li><a href="contentList.shtml?categoryId=${category.id}">${category.menuName }列表</a></li>
			<li class="active"><a href="contentAddView.shtml?categoryId=${category.id}">${category.menuName }添加</a></li>
		</ul>
<div>
<form class="form-horizontal" action="contentPublish.shtml" method="post"
				enctype="multipart/form-data" id="contentForm" name="contentForm">
<fieldset>

<!-- Form Name -->
<legend>${category.menuName }发布</legend>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="contentTitle">标题</label>
  <div class="col-md-4">
    <input id="contentTitle" name="contentTitle" type="text" placeholder="标题" class="form-control" >
    <p class="text-danger" id="content-text-danger"></p>
  </div>
</div>
<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="contentSubTitle">作者</label>
  <div class="col-md-4">
    <input id="contentSubTitle" name="contentSubTitle" type="text" placeholder="作者" class="form-control">
    <p class="text-danger" id="content-text-danger"></p>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="contentSource">来源</label>
  <div class="col-md-4">
    <input id="contentSource" name="contentSource" type="text" placeholder="来源" class="form-control">
    <p class="text-danger" id="content-text-danger"></p>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="modifyTimeStr">更新时间</label>
  <div class="col-md-4">
    <input id="modifyTimeStr" name="modifyTimeStr" type="text" placeholder="更新时间" onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" class="form-control ">
    <p class="text-danger" id="address-text-danger"></p>
  </div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="contentPriority">优先级</label>
  <div class="col-md-4">
    <input id="contentPriority" name="contentPriority" type="text" placeholder="优先级" class="form-control" 
    data-required="true"  data-describedby="content-text-danger" data-description="contentPriority" value="${content.contentPriority }">
    <p class="text-danger" id="content-text-danger"></p>
  </div>
</div>
<!-- File Button -->
<div class="form-group">
  <label class="col-md-2 control-label" for="images">图片上传
  <c:choose>
  <c:when test="${category.id > 23 and category.id <27 }">(118 x 99)</c:when>
  <c:otherwise>(320 x 122)</c:otherwise>
  </c:choose>
  </label>
			<div class="col-md-4">
				<input type="hidden" id="contentImage" name="contentImage" class="input-xlarge"/>
				<sys:ckfinder input="contentImage" type="images" uploadPath="content" selectMultiple="false"/>
			</div>
</div>

<!-- Text input-->
<div class="form-group">
  <label class="col-md-2 control-label" for="contentDescription">摘要</label>
  <div class="col-md-4">
    <textarea id="contentDescription" name="contentDescription"  class="form-control" >${content.contentDescription }
    </textarea>
  </div>
</div>
<!-- Textarea -->
<div class="form-group">
  <label class="col-md-2 control-label" for="contentContent">文章</label>
  <div class="col-md-8">
    <textarea id="contentContent" name="contentContent" rows="10" cols="80">
                请编辑。
            </textarea>
            <script>
                // Replace the <textarea id="editor1"> with a CKEditor
                // instance, using default configuration.
                CKEDITOR.replace( 'contentContent' );
            </script>
    <p class="text-danger" id="edit-text-danger"></p>
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
			$("#contentForm").validator({
			    fields: {
			    	contentTitle: "标题:required;",
			    	contentPriority:"优先级:required;integer;"
			    },
			    valid: function(form){
			        //表单验证通过，提交表单到服务器
			    	ajaxSubmit();
			    }
			});
			var time = new Date();
	        $("#modifyTimeStr").val(time.toJSON().substring(0, 10));
			
		});

				function ajaxSubmit(){
					var url = 'contentPublish.shtml';
					$("#contentContent").val(CKEDITOR.instances['contentContent'].getData());
					var data = $('#contentForm').serialize();
					var asynCallBack = addEstateCallback;
					asynDataQuery(url,"post",data,asynCallBack,false);
					function addEstateCallback(datas){
						rtn = eval("("+datas+")");
						//alert(rtn.msg);
						if(rtn.rtnCode == 0){
			        		window.location.href="contentAddOk.shtml?categoryId=${category.id}";
			        	}else{
			        		alert("添加${category.menuName}失败，请稍后再试或者联系管理员！");
			        	}
					}
				}	
	</SCRIPT>
	</body>
</html>