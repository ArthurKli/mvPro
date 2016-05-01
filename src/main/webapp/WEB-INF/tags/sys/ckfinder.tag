<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/admin/include/taglib.jsp"%>
<%@ attribute name="input" type="java.lang.String" required="true" description="输入框"%>
<%@ attribute name="type" type="java.lang.String" required="true" description="files、images、flash、thumb"%>
<%@ attribute name="uploadPath" type="java.lang.String" required="true" description="打开文件管理的上传路径"%>
<%@ attribute name="selectMultiple" type="java.lang.Boolean" required="false" description="是否允许多选"%>
<ol id="${input}Preview"></ol><button onclick="${input}FinderOpen();" type="button" class="btn btn-info">${selectMultiple?'添加':'选择'}</button>&nbsp;<button  onclick="${input}DelAll();" type="button" class="btn btn-info">清除</button>
<script type="text/javascript" src="${ctxStatic }/ckfinder/ckfinder.js"></script>
<script type="text/javascript">
var ckfinderAPI;
	function ${input}FinderOpen(){
		var date = new Date(), year = date.getFullYear(), month = (date.getMonth()+1)>9?date.getMonth()+1:"0"+(date.getMonth()+1);
		var url = "${ctxStatic }/ckfinder/ckfinder.html?type=${ctype}&start=${ctype}:${uploadPath}/"+year+"/"+month+
			"/&action=js&func=${input}SelectAction&thumbFunc=${input}ThumbSelectAction&cb=${input}Callback&dts=${type eq 'thumb'?'1':'0'}&sm=${selectMultiple?1:0}";
		windowOpen(url,"文件管理",1000,700);
		//var finder = new CKFinder();
		//finder.basePath = 'script/common/ckfinder/';	// The path for the installation of CKFinder (default = "/ckfinder/").
		//finder.selectActionFunction = ${input}SelectAction;
		//finder.popup();
		//top.$.jBox("iframe:"+url+"&pwMf=1", {title: "文件管理", width: 1000, height: 500, buttons:{'关闭': true}});
	}
	function ${input}SelectAction(fileUrl, data){
		<c:if test="${selectMultiple}">
		$("#${input}").val($("#${input}").val()+($("#${input}").val(fileUrl)==""?fileUrl:"|"+fileUrl));
		</c:if><c:if test="${!selectMultiple}">
		$("#${input}").val(fileUrl);
		</c:if>
		${input}Preview();
		//top.$.jBox.close();
	}
	function ${input}ThumbSelectAction(fileUrl, data, allFiles){
		alert(2);
		var url="", files=ckfinderAPI.getSelectedFiles();
		for(var i=0; i<files.length; i++){
			url += files[i].getThumbnailUrl();
			if (i<files.length-1) url+="|";
		}
		<c:if test="${selectMultiple}">
		$("#${input}").val($("#${input}").val()+($("#${input}").val(url)==""?url:"|"+url));
		</c:if><c:if test="${!selectMultiple}">
		$("#${input}").val(url);</c:if>
		${input}Preview();
		//top.$.jBox.close();
	}
	function ${input}Callback(api){
		alert(3);
		ckfinderAPI = api;
	}
	function ${input}Del(obj){
		var url = $(obj).prev().attr("url");
		$("#${input}").val($("#${input}").val().replace("|"+url,"","").replace(url+"|","","").replace(url,"",""));
		${input}Preview();
	}
	function ${input}DelAll(){
		$("#${input}").val("");
		${input}Preview();
	}
	function ${input}Preview(){
		var li, urls = $("#${input}").val().split("|");
		$("#${input}Preview").children().remove();
		for (var i=0; i<urls.length; i++){
			if (urls[i]!=""){//<c:if test="${type eq 'thumb' || type eq 'images'}">
				li = "<li><img src=\""+urls[i]+"\" url=\""+urls[i]+"\" style=\"max-width:200px;max-height:200px;_height:200px;border:0;padding:3px;\">";//</c:if><c:if test="${type ne 'thumb' && type ne 'images'}">
				li = "<li><a href=\""+urls[i]+"\" url=\""+urls[i]+"\" target=\"_blank\">"+decodeURIComponent(urls[i].substring(urls[i].lastIndexOf("/")+1))+"</a>";//</c:if>
				li += "&nbsp;&nbsp;<a href=\"javascript:\" onclick=\"${input}Del(this);\">×</a></li>";
				$("#${input}Preview").append(li);
			}
		}
	}
	${input}Preview();
</script>