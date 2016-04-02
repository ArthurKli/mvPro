
function windowOpen(url, name, width, height){
	var top=parseInt((window.screen.height-height)/2,10),left=parseInt((window.screen.width-width)/2,10),
		options="location=no,menubar=no,toolbar=no,dependent=yes,minimizable=no,modal=yes,alwaysRaised=yes,"+
		"resizable=yes,scrollbars=yes,"+"width="+width+",height="+height+",top="+top+",left="+left;
	window.open(url ,name , options);
}
// 确认对话框
function confirmx(info,url){
	$('#dialog_simple').attr("title","温馨提示");
	$('#dialog_simple').html("<p>确定要删除该"+info+"吗？</p>");
    $('#dialog_simple').dialog({
	    autoOpen: false,
	    width: 400,
	    buttons: {
	        "Ok": function () {
	        	var asynCallBack = null;
	        	asynDataQuery(url,"post",{},asynCallBack,false,'json');
	            $(this).dialog("close");
	        },
	        "Cancel": function () {
	            $(this).dialog("close");
	        }
	    }
	}).dialog('open');
    return false;
}

//批量删除
function batchDel(url,arrayObj){
	$('#dialog_simple').attr("title","温馨提示");
	$('#dialog_simple').html("<p>确定要进行删除操作吗？</p>");
    $('#dialog_simple').dialog({
	    autoOpen: false,
	    width: 400,
	    buttons: {
	        "Ok": function () {
	        	var asynCallBack = function(datas){
    			};
	        	for(var i=0;i<arrayObj.length;i++){
	        		if(i==arrayObj.length-1){
	        			asynCallBack = function(datas){
	        				alert("删除成功！！");
	        				window.location.reload();
	        			};
	        		}
		        	asynDataQuery(url+arrayObj[i],"post",{},asynCallBack,false,'json');
	        	}
	            $(this).dialog("close");

	        },
	        "Cancel": function () {
	            $(this).dialog("close");
	        }
	    }
	}).dialog('open');
    return false;
}


//批量删除2号  --目前只支持城市、方位、类型
function batchDel2(url,arrayObj){
	$('#dialog_simple').attr("title","温馨提示");
	$('#dialog_simple').html("<p>确定要进行删除操作吗？</p>");
    $('#dialog_simple').dialog({
	    autoOpen: false,
	    width: 400,
	    buttons: {
	        "Ok": function () {
	        	$(this).dialog("close");
	        	batchAsynDataQuery(url,"post",{},null,false,'json',false,arrayObj);
	        },
	        "Cancel": function () {
	            $(this).dialog("close");
	        }
	    }
	}).dialog('open');
    return false;
}

function modifiedx(cid,cname,pro,url,type){
	var mainName='';
	if(type=='city'){
		mainName="城市";
	}else if(type=='position'){
		mainName="方位";
	}else{
		mainName="类型";
	}

	$('#dialog_simple').attr("title","修改"+mainName);
	var htmls="<fieldset>" +
			"<div class='form-group'><label for='name'>"+mainName+"名: </label> " +
			"<input type='text' name='name' id='name' value='"+cname+"' class='text ui-widget-content ui-corner-all'></div>" +
			"<div class='form-group'><label for='pro'>优先级: </label> " +
			"<input type='text' name='pro' id='pro' value='"+pro+"' class='text ui-widget-content ui-corner-all'></div>" +
			"</fieldset>";
	$('#dialog_simple').html(htmls);
    $('#dialog_simple').dialog({
	    autoOpen: false,
	    width: 400,
	    buttons: {
	        "Ok": function () {
	        	var typeId = type+"Id";
	        	var typeName = type+"Name";
	        	var typePriority = type +"Priority";
	        	var name = $("#name").val();
	        	var pro = $("#pro").val();
	        	var dataStr = "{'"+typeId+"':'"+cid+"','"+typeName+"':'"+name+"','"+typePriority+"':'"+pro+"'}";
	        	var data =  eval("("+dataStr+")");
	        	var asynCallBack = updateCallback;
	        	asynDataQuery(url,"post",data,asynCallBack,false,'json');
	        	function updateCallback(datas){
	        		rtn = eval("("+datas+")");
	        		alert(rtn.msg);
	        		if(rtn.rtnCode=="success"){
	        			window.location.reload();
	        		}
	        		$(this).dialog("close");
	        	}
	        },
	        "Cancel": function () {
	            $(this).dialog("close");
	        }
	    }
	}).dialog('open');
    return false;
}
//$(document).ready(function() {
//	// Dialog Simple
//	$('#dialog_simple').dialog({
//	    autoOpen: false,
//	    width: 600,
//	    buttons: {
//	        "Ok": function () {
//	            alert("你妈");
//	            $(this).dialog("close");
//	        },
//	        "Cancel": function () {
//	            $(this).dialog("close");
//	        }
//	    }
//	});
//  });   

