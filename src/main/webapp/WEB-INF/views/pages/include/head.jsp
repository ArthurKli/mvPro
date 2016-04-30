<%@ page contentType="text/html;charset=UTF-8" %>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
<link rel="shortcut icon" href="${pages }/css/images/favicon.ico" type="image/x-icon" />
<link href="${pages }/css/style.css" rel="stylesheet" type="text/css" />
<link href="${pages }/css/style_ex.css" rel="stylesheet" type="text/css" />
<link href="${pages }/script/common/jQuery_qq/css/kefu.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${pages }/script/leadex/jquery-v1.9.0.min.js"></script>
<script type="text/javascript" src="${pages }/script/leadex/global.js"></script>
<script type="text/javascript" src="${pages }/script/leadex/Carousel.js"></script>
<script type="text/javascript" src="${pages }/script/leadex/validate.js"></script>
<script>var online= new Array();</script>
<script type="text/javascript">

 $(document).ready(function() {

     ScrollToTop.setup(); //回到顶部
     //英文版会比中文字体长导致导航菜单换行
     <c:if test="${!empty sessionScope.locate && sessionScope.locate=='en'}">
     $(".ol-mainnav li span").css("font-size", "14px");
     </c:if>

     //禁止拷贝
     document.oncontextmenu = function (e) {
         return false;
     }
     document.onselectstart = function (e) {
         return false;
     }

 });

 var ScrollToTop = ScrollToTop || {
     setup: function () {

         var a = $(window).height() / 2;

         $(window).scroll(function () {
             (window.innerWidth ? window.pageYOffset : document.documentElement.scrollTop) >= a ? $("#ScrollToTop").removeClass("Offscreen") : $("#ScrollToTop").addClass("Offscreen")
         });
         $("#ScrollToTop").click(function () {
             $("html, body").animate({scrollTop: "0px"}, 400);
             return false
         })
     }
 };
	
 
</script>

<c:set value='${requestScope.requestURI }?' var="localURL"></c:set>

<c:set value="${requestScope['javax.servlet.forward.query_string']}" var="queryParam" />
<c:if test="${fn:contains(queryParam, '&locate=')}">
<c:set var="queryParam" value="${fn:substringBefore(queryParam, '&locate=')}" />
</c:if>
<c:if test="${fn:contains(queryParam, 'locate=')}">
<c:set var="queryParam" value="${fn:substringBefore(queryParam, 'locate=')}" />
</c:if>
<div class="ol-wrapper">
  <!--网页头部开始-->
  <div class="ol-big-header">
  <div class="ol-header">
    <div class="logo1"><a href="${ctx }/"><img  src="${pages }/images/logo-02.png" alt="logo" /></a></div>

    <div class="top-contact">
      <div><span>
      <a class="reserve lang-toggle" href="${ctx }/" title="<fmt:message key="index.chinese" bundle="${main }" />">| 中文版 |</a>
      <a  class="reserve lang-toggle" href="#" title="<fmt:message key="index.english" bundle="${main }" />">English |</a>
      
      </span>
      <span class="tel"></span></div>
    </div>
    
           <div class="top-weixin">
       	
  <%--     		<a href="${ctx }/style/images/leadexWX.jpg" class="weixin" id="weixin-linked" target="_blank">
       		<div class="weixin-inner-div"></div>
        			<img style="width:72px;height:72px;" src="${ctx }/style/images/leadexWX.jpg" />
      		</a>--%>
     	
     </div>
   
  </div>
  
  <div class="ol-header-right" style="display: none;">
  
  </div>

 </div>
  <!--网页头部结束-->
   <!--网页菜单开始-->
 <div class="ol-mainnav">
    <div class="mainnav-inner">
    <ul>
      <li><a class="a1 <c:if test="${tabNum==1}">currents</c:if>" href="${ctx }/"><span><fmt:message key="index.headbar.home" bundle="${main }" /></span></a></li>
      <li><a class="a1 <c:if test="${tabNum==2}">currents</c:if>" href="${ctx }/estateList.shtml"><span><fmt:message key="index.headbar.estate" bundle="${main }" /></span></a></li>
      <li><a class="a1 <c:if test="${tabNum==4}">currents</c:if>" href="${ctx }/info.shtml"><span><fmt:message key="index.headbar.info" bundle="${main }" /></span></a></li>
      <li><a class="a1 <c:if test="${tabNum==6}">currents</c:if>" href="${ctx }/exhibit.shtml"><span><fmt:message key="index.headbar.exhibition" bundle="${main }" /></span></a></li>
      <!--<li><a class="a1 <c:if test="${tabNum==9}">currents</c:if>" href="${ctx }/migrate.shtml"><span><fmt:message key="index.headbar.migrate" bundle="${main }" /></span></a></li>-->
	  <li><a class="a1 <c:if test="${tabNum==10}">currents</c:if>" href="${ctx }/list.shtml?cid=58"><span><fmt:message key="index.headbar.study" bundle="${main }" /></span></a></li>
      <li><a class="a1 <c:if test="${tabNum==9}">currents</c:if>" href="${ctx }/list.shtml?cid=59"><span><fmt:message key="index.headbar.migrate" bundle="${main }" /></span></a></li>
      <li><a class="a1 <c:if test="${tabNum==8}">currents</c:if>" href="${ctx }/develop.shtml"><span><fmt:message key="index.headbar.develop" bundle="${main }" /></span></a></li>
      
      <li><a class="a1 <c:if test="${tabNum==5}">currents</c:if>" href="${ctx }/summary.shtml"><span><fmt:message key="index.headbar.summary" bundle="${main }" /></span></a></li>
      <li><a class="a1 <c:if test="${tabNum==7}">currents</c:if>" href="${ctx }/about.shtml"><span><fmt:message key="index.headbar.about" bundle="${main }" /></span></a></li>

    </ul>
    </div>
  </div>
  <!--网页菜单结束-->
  

 