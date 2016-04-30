//同步下拉框数据
function initSelDDLvalue(DDLParentName,DDLChildName,DmChildFile,_isAsynchronous){	   	
	if(DDLChildName!="" && DmChildFile!=""){
		document.getElementById(DDLParentName).onchange=function(){
			show(DmChildFile,DDLChildName,true,this.value,_isAsynchronous);
		}
	}
}

//创建XMLHttpRequest对象
function createXMLHttpRequest() {
	if (window.XMLHttpRequest) { // Mozilla 浏览器
		return XMLHttpReq = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE浏览器
		try {
			return XMLHttpReq = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				return XMLHttpReq = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}
}

/**
*dmmc:代码表表名；selId：下拉列表id;flag:是否需要判断父级编码true.false;_parentCode:父级编码
*_isAsynchronous 是否异步加载 true：异步；false：同步
*/
function show(_dmmc,_selId,flag,_parentCode,_isAsynchronous){
	var XMLHttp;
	var url = webContext + '/xml/' + _dmmc+'.xml';
	XMLHttp = createXMLHttpRequest();
	XMLHttp.onreadystatechange = function(){
		if(XMLHttp.readyState==4){
			if(XMLHttp.status==200){
				sel(XMLHttp.responseXML,_selId,flag,_parentCode);
			}
		}
	}; 
    XMLHttp.open("GET",url,_isAsynchronous); 
    XMLHttp.send(null); 
}

function sel(responseXml,selId,flag,parentCode){
	var _options = responseXml.documentElement.getElementsByTagName("option");
	var _length= 0;
	if(_options!=null){
		_length = responseXml.documentElement.getElementsByTagName("option").length;
	}		
	if(_length>0){
		document.getElementById(selId).options.length=0;
		var _option = new Option("---请选择---","-1");
		document.getElementById(selId).options[document.getElementById(selId).length]=_option;					
		for(var i=0;i<_length;i++){
			var _name = _options[i].selectSingleNode("mc").text;	
			var _code = _options[i].selectSingleNode("dm").text;
			if(flag){
				var _parentCode = _options[i].selectSingleNode("pc").text;
				if(_parentCode==parentCode){
					var option = new Option(_name,_code);
					document.getElementById(selId).options[document.getElementById(selId).length]=option;
				}
			}
			else{
				var option = new Option(_name,_code);
				document.getElementById(selId).options[document.getElementById(selId).length]=option;
			}
		}
	}
}

/**
 * 以XMLDOC为数据源填充select控件options
 * @param doc {String/DOM} xmlDocument字符串或者对象
 * @param config {Object} 配置对象{dataNodeName:'',codeNodeName:'',textNodeName:'',selectCtrlId:''}
 * @param callback
 */
function sSelectCtrlFillDataWithDOM(doc,config,callback){
	if(config){
		var jDoc=$.isXMLDoc(doc)?$(doc):$($.parseXML(doc)),
		datas=jDoc.find(config.dataNodeName);
		$.each(datas,function(i,e){
			var jE=$(e),
				code=jE.find(config.codeNodeName).text(),
				text=jE.find(config.textNodeName).text(),
				djxh=jE.find(config.djxhNodeName).text(),
				jSelect=$('#'+config.selectCtrlId);
			if(jSelect){
				if(callback){
					callback(jDoc,e,jSelect);
				}else{
					jSelect.append('<option id="'+ djxh +'" value="'+code+'">'+text+'</option>');
				}
			}
		});
	}
}