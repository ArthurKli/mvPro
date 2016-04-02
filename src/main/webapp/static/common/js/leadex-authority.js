function grandModule(ownerType,userId){
	window.open("grandAuthority.shtml?ownerType="+ownerType+"&userId="+userId, "授权", 
			"height=450, width=500, top=0, left=0,toolbar=no, menubar=no, scrollbars=no, " +
			"resizable=no, location=n o, status=no");
}

function submitGrand(){
	var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
	var nodes = treeObj.getCheckedNodes(true);
	var ckId = "";
	for(var i = 0;i<nodes.length;i++){
		ckId = ckId + ";" + nodes[i].id;
	}
	var ownerType = $("#ownerType").val();
	var userId = $("#userId").val();
	asynDataQuery("grandAuthorityToUser.shtml","post",{"ckId":ckId,"ownerType":ownerType,"userId":userId},grandAuthorityCallBack,false);
}

function grandAuthorityCallBack(datas){
	var msg = eval("("+datas+")");
	alert(msg.msg);
	window.close();
}