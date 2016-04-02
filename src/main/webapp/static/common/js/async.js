/**
 * 异步调用封装
 * @param url 请求路径
 * @param requestType 请求类型：post，get
 * @param data 请求参数
 * @param asynCallBack 回调函数
 * @param isAsync 是否异步调用
 * @param isCache 是否缓存
 * @param returnType 返回类型  text/xml/json
 * @returns {Boolean}
 */
function asynDataQuery(url,requestType,data,asynCallBack,isAsync,returnType,isCache){
	if(!url){return false;}
	if(!requestType){requestType = 'post'; }
	if(!asynCallBack){asynCallBack = ajaxCallback; }
	if(!isAsync){ isAsync = true; }
	if(!isCache){isCache=false;}
	if(!returnType){returnType = 'text'; }
	requestType = requestType.toLowerCase();
	returnType = returnType.toLowerCase();
	
	/* $('#form1').submit(); */
	$.ajax({
        cache: isCache,
        type: requestType,
        url:url,
        data:data,
        async: isAsync,
        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
        error: function(XMLHttpRequest, textStatus, errorThrown) {
        	console.log(XMLHttpRequest.status);
        	console.log(XMLHttpRequest.readyState);
        	console.log(errorThrown);
            alert("链接处理错误，请联系管理员！");
        },
        success: function(data) {
        	asynCallBack(data);
        }
    });
}

function batchAsynDataQuery(url,requestType,data,asynCallBack,isAsync,returnType,isCache,arrayObj){
	var errorNum = 0;
	var errorReason='[系统错误]';
	var errorId='';
	if(!url){return false;}
	if(!requestType){requestType = 'post'; }
	if(!asynCallBack){asynCallBack = ajaxCallback; }
	if(!isCache){isCache=false;}
	if(!returnType){returnType = 'text'; }
	requestType = requestType.toLowerCase();
	returnType = returnType.toLowerCase();
	
	for(var i=0;i<arrayObj.length;i++){
		$.ajax({
	        cache: isCache,
	        type: requestType,
	        url:url+arrayObj[i],
	        async: false,
	        contentType:"application/x-www-form-urlencoded; charset=UTF-8",
	        error: function(XMLHttpRequest, textStatus, errorThrown) {
	        	console.log(XMLHttpRequest.status);
	        	console.log(XMLHttpRequest.readyState);
	        	errorNum++;
	        	errorId = errorId+arrayObj[i]+",";
	        },
	        success: function(data) {
	        	rtn = eval("("+data+")");
	        	if(rtn.rtnCode!=0){
	        		if(rtn.msg=='ESTATE_NOT_EMPTY'){
	        			errorReason = '[存在使用该属性的房产项目]';
	        		}
	        		errorNum++;
	        		errorId = errorId+arrayObj[i]+",";
	        	}
	        }
	    });
	}
	
	if(errorNum==0){
		alert("删除成功");
	}else{
		alert(errorNum+"条记录删除失败:"+errorId+"失败原因:"+errorReason);
	}
	window.location.reload();

}


function ajaxCallback(datas){
	rtn = eval("("+datas+")");
	if(rtn.msg=='ESTATE_NOT_EMPTY'){
		alert('删除失败，存在使用该属性的房产项目。');
	}else{
		alert(rtn.msg);
	}
	
	if(rtn.rtnCode==0){
		window.location.reload();
	}
}