<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/include/taglib.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <title></title>
	<%@include file="/WEB-INF/views/include/head.jsp" %>
	<script src="${ctxStatic }/bootstrap/plugin/sco.collapse.js" type="text/javascript"></script>

  </head>
  <body>
    <div class="map mapAdd">
			当前位置：
			<a href="contentList.shtml?categoryId=${category.id }">${category.menuName }管理</a> /
			<a href="contentList.shtml?categoryId=${category.id }">${category.menuName }列表</a>  /
			<a style="color: green;">${category.menuName }详情</a>
		</div>
<div class="panel panel-primary"  width="98%">
  <!-- Default panel contents -->
  <div class="panel-heading"><strong>基本信息</strong></div>

  <!-- Table -->
  <table class="table table-condensed"  >
    <tr>
      <td width="10%"><strong>标题</strong></td>
      <td colspan="5">${content.contentTitle }</td>
    </tr>
    <tr>
      <td width="10%"><strong>发布日期</strong></td>
      <td><t:dateTag date="${content.createTime }"  pattern="yyyy-MM-dd hh:mm:ss" /></td>
      <td width="10%"><strong>作者</strong></td>
      <td colspan="3">${content.contentSubTitle }</td>
    </tr>
	<tr>
      <td colspan="6"><strong>内容</strong></td>
    </tr>
	<tr>
      <td colspan="6">${content.contentContent }</td>
    </tr>
  </table>
</div>

<hr>
<script>

$('.collapse').collapse({
  toggle: true,parent:'#accordion'
})
$('.panel-toggle').on('click', function () {
    var self = this;
    $(self).parent.nextAll().eq(0).collapse("toggle");
})
</script>
 
                <div id="dialog_simple" title="">
                </div>
  </body>
</html>