<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<a id="ScrollToTop" class="btnimg Offscreen" type="button"></a >
  <!--网页底部开始-->
  <div class="ol-footer-wrap">
     <div class="ol-footer">
       <ul class="f-links">
       <c:forEach var="fr"  items="${friendly.pageList }">
       		<li><a href="${fr.contentPath }" target="_blank">${fr.contentTitle }</a></li>
       </c:forEach>
       </ul>
       
       <ul class="f-info">
			<li><strong>广州</strong></li>
			<li><span class="add">地址：广州市天河区黄埔大道西76号富力盈隆广场2004室</span><span>电话：(020)38917891</span></li>
			
			<li class="foot-top-li">
				<span>Copyright©2014 www.amigaus.com All Rights Reserved.</span><span>澳领集团</span><span>版权所有（C）</span><span><a href="http://www.miibeian.gov.cn/">粤ICP备14061345号</a></span>
				<font style="display:none;"><script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1253172160'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "s13.cnzz.com/z_stat.php%3Fid%3D1253172160%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script></font>
				<!--<script type="text/javascript">
var _bdhmProtocol = (("https:" == document.location.protocol) ? " https://" : " http://");
document.write(unescape("%3Cscript src='" + _bdhmProtocol + "hm.baidu.com/h.js%3Fe247605a976f02ba5822d53455b08b26' type='text/javascript'%3E%3C/script%3E"));
</script>-->
				<script type="text/javascript">var cnzz_protocol = (("https:" == document.location.protocol) ? " https://" : " http://");document.write(unescape("%3Cspan id='cnzz_stat_icon_1253423438'%3E%3C/span%3E%3Cscript src='" + cnzz_protocol + "v1.cnzz.com/z_stat.php%3Fid%3D1253423438%26show%3Dpic' type='text/javascript'%3E%3C/script%3E"));</script>
			</li>

       </ul>
       <div class="weima">
       <p><img src="${pages }/images/leadexWX.jpg" /></p>
       澳领集团官方微信<br />微信号：AMIGAU
       
       </div>
     </div>
  </div>
  <!--网页底部结束-->
    <div id="box-kefu">
    <div class="kefu-close"></div>
    <div class="kefu-open">
        <div>
        <ul>
        	<c:forEach var="cs" items="${customerService.pageList }">
        		<li><a href="http://wpa.qq.com/msgrd?v=3&uin=${cs.nickName }&site=qq&menu=yes" target="_blank" title="欢迎联系"><i class="qq"></i>${cs.userName }</a></li>
        	</c:forEach>
            <li><a href="${ctx }/getReport.shtml" target="_blank"><i class="txt"></i>咨询留言</a></li>
        </ul>
        </div>
        <a href="javascript:;" class="close">关闭</a>
    </div>
</div>
<c:forEach var="cs" items="${customerService.pageList }">
<c:set var="qqCs" value="${empty qqCs ? '' : qqCs }${cs.nickName }:"/>
</c:forEach>
<script type="text/javascript">
$(document).ready(function(){
//	dynamicLoad();
});

function dynamicLoad()
{
	$.ajax({
		   type: "POST",
		   url: "${ctx }/httpPost.shtml",
		   data: "qqs=${qqCs}",
		   success: function(data){
			   if(data==''){
				   return ; 
			   }
			   var words = data.split(";");
			   for(var i=0;i<words.length;i++){
				   if(words[i]!=''){
						online[i] = words[i].split("=")[1];
				   }
			   }
			 initKefu();
		   }
		   
		});
}
function initKefu(){
	 for (var i=0; i<online.length; i++) {
	        if (online[i]&&online[i]==1) jQuery("#box-kefu .qq").eq(i).addClass("online");
	    }
	    var _open = $("#box-kefu").find(".kefu-open"),
	        _close = $("#box-kefu").find(".kefu-close");
	    _open.find("a").hover(function(){
	        $(this).stop(true,true).animate({paddingLeft:20},200).find("i").stop(true,true).animate({left:75},200);
	    },function(){
	        $(this).stop(true,true).animate({paddingLeft:35},200).find("i").stop(true,true).animate({left:10},200);
	    });
	    _open.find(".close").click(function(){
	        _open.animate({width:148},200,function(){
	            _open.animate({width:0},200,function(){
	                _close.animate({width:34},200);

	            });
	        });
	    });
	    _close.click(function(){
	        _close.animate({width:44},200,function(){
	            _close.animate({width:0},200,function(){
	                _open.animate({width:138},200);
	            });
	        });
	    });
}
</script>
