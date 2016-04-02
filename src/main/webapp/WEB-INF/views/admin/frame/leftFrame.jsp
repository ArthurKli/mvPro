<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<%@ page isELIgnored="false"%>

<html>
	<head>
		<title>menu</title>
<link href="${ctxStatic}/jquery-ztree/3.5.12/css/zTreeStyle/zTreeStyle.min.css" rel="stylesheet" type="text/css"/>		
<script src="${ctxStatic}/jquery/jquery-1.8.3.min.js" type="text/javascript"></script>
<script src="${ctxStatic}/jquery-ztree/3.5.12/js/jquery.ztree.core-3.5.min.js" type="text/javascript"></script>
		<style type="text/css">
		#leftBody{
		background-image: linear-gradient(to bottom,#fff,#f2f2f2);
background-repeat: repeat-x;
border: 1px solid #d4d4d4;
-webkit-border-radius: 4px;
-moz-border-radius: 4px;
border-radius: 4px;
filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#ffffffff',endColorstr='#fff2f2f2',GradientType=0);
-webkit-box-shadow: 0 1px 4px rgba(0,0,0,0.065);
-moz-box-shadow: 0 1px 4px rgba(0,0,0,0.065);
box-shadow: 0 1px 4px rgba(0,0,0,0.065);
		}
		
		</style>

<script type="text/javascript" >
var zTreeJson;
$.ajax({
    cache: true,
    async: false,
    type: "POST",
    url:"getMenuTree.shtml",
    error: function(request) {
        alert("无法获取功能树！");
    },
    success: function(data) {
    	zTreeJson = eval("("+data+")");
    }
});
	
var zTree;
var demoIframe;

var setting = {
	view: {
		dblClickExpand: false,
		showLine: true,
		selectedMulti: false
	},
	data: {
		simpleData: {
			enable:true,
			idKey: "id",
			pIdKey: "pId",
			rootPId: ""
		}
	},
	callback: {
		beforeClick: function(treeId, treeNode) {
			var zTree = $.fn.zTree.getZTreeObj("tree");
			if (treeNode.isParent) {
				zTree.expandNode(treeNode);
				return false;
			} else {
				demoIframe.attr("src","dddddd.html");
				return true;
			}
		}
	}
};

var zNodes = zTreeJson;


$(document).ready(function(){
	var t = $("#tree");
	t = $.fn.zTree.init(t, setting, zNodes);
	demoIframe = $("#testIframe");
	demoIframe.bind("load", loadReady);
	var zTree = $.fn.zTree.getZTreeObj("tree");
	zTree.selectNode(zTree.getNodeByParam("id", 101));

});

function loadReady() {
	var bodyH = demoIframe.contents().find("body").get(0).scrollHeight,
	htmlH = demoIframe.contents().find("html").get(0).scrollHeight,
	maxH = Math.max(bodyH, htmlH), minH = Math.min(bodyH, htmlH),
	h = demoIframe.height() >= maxH ? minH:maxH ;
	if (h < 530) h = 530;
	demoIframe.height(h);
}
	</script>
	</head>
	<body id="leftBody">
		<ul id="tree" class="ztree" style="width:260px; overflow:auto;"></ul>
	</body>
</html>