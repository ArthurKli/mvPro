<%@ page language="java" pageEncoding="UTF-8"%>
<%@include file="include/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title><fmt:message key="about.title" bundle="${main }" /></title>
<meta name="keywords" content="海外房产投资,澳洲留学移民,关于澳领"/>
<meta name="description" content="广东澳领投资管理有限公司【关于澳领】专项为您提供海外房产投资,澳洲留学移民等信息,广东澳领投资管理有限公司是市场上唯一在业务上涵盖市场研究,澳大利亚住宅物业销售代理,投资后期跟踪服务,商业投资移民咨询,留学生以房养学服务平台. - www.amigaus.com"/>
<%@include file="include/head.jsp" %>
<script src="${ctx }/static/common/js/jquery.scroll.js" type="text/javascript"></script>

</head>

<body id="listpage">
 

<!--网页主体结束-->

<div class="list-container">
	<div class="listbox">
    	<div class="listads"><a href="${ctx }/getReport.shtml" target="_blank"><img src="${pages }/images/listads.jpg" /></a></div>
    	<div class="li_sider">
        	<h3 class="title"><span><fmt:message key="about.head" bundle="${main }" /></span></h3>
                     
            <ul class="aboutlist">
                <li <c:if test="${category.id==14}">class="on"</c:if> ><a href="${ctx }/about/14.shtml" >澳领简介<span>PROFILE</span></a></li>
                <li <c:if test="${category.id==15}">class="on"</c:if> ><a href="${ctx }/about/15.shtml" >企业文化<span>ENTERPRISE</span></a></li>
                <li <c:if test="${category.id==16}">class="on"</c:if> ><a href="${ctx }/about/16.shtml" >管理团队<span>QUALIFICATION</span></a></li>
                <li <c:if test="${category.id==17}">class="on"</c:if> ><a href="${ctx }/about/17.shtml" >合作伙伴<span>PARTNERS</span></a></li>
                <li <c:if test="${category.id==18}">class="on"</c:if> ><a href="${ctx }/about/18.shtml" >联系我们<span>CONTACT US</span></a></li>
                <li <c:if test="${category.id==39}">class="on"</c:if> ><a href="${ctx }/about/39.shtml" >招聘专栏<span>RECRUITMENT</span></a></li>
            </ul>
             <h3 class="title"><a href="${ctx }/exhibit.shtml" class="more">more</a><span><fmt:message key="common.dynamic.exbition" bundle="${main }" /></span></h3>
            <div class="li_news li_news2">
            	
                  <div id="newsaos">
                      <div id="scrollvarea" style="overflow: hidden; color: rgb(255, 255, 255); height: 229px;">
                          <div id="scrollvarea" style="OVERFLOW: hidden; COLOR: #ffffff;"><ul id="uu">

                              <li><a href="http://www.amigaus.com/exhibit/45.shtml"><img src="http://218.244.132.209:8190/leadex/userfiles/files/1461205518449.jpg" alt="正佳万豪酒店深海之恋婚庆秀" title="正佳万豪酒店深海之恋婚庆秀" style=" width:205px; height:123px; border:solid 1px #ececec; padding:1px;"></a>
                                  <samp> <a href="" target="_blank"> 时间：<span>2016-04-17
至2016-04-17
</span></a></samp>
                                  <samp> <a href="" target="_blank"> 地址：<span>广州正佳广场万豪酒店三楼大宴会厅（靠近广州正佳广场西/西北门,地铁一号线体育中心站D3出口）</span></a></samp>
                              </li>

                          </ul><ul id="uu">

                              <li><a href="http://www.amigaus.com/exhibit/45.shtml"><img src="http://218.244.132.209:8190/leadex/userfiles/files/1461205518449.jpg" alt="正佳万豪酒店深海之恋婚庆秀" title="正佳万豪酒店深海之恋婚庆秀" style=" width:205px; height:123px; border:solid 1px #ececec; padding:1px;"></a>
                                  <samp> <a href="" target="_blank"> 时间：<span>2016-04-17
至2016-04-17
</span></a></samp>
                                  <samp> <a href="" target="_blank"> 地址：<span>广州正佳广场万豪酒店三楼大宴会厅（靠近广州正佳广场西/西北门,地铁一号线体育中心站D3出口）</span></a></samp>
                              </li>

                          </ul></div>
                          <ul id="uu">

                              <li><a href="http://www.amigaus.com/exhibit/45.shtml"><img src="http://218.244.132.209:8190/leadex/userfiles/files/1461205518449.jpg" alt="正佳万豪酒店深海之恋婚庆秀" title="正佳万豪酒店深海之恋婚庆秀" style=" width:205px; height:123px; border:solid 1px #ececec; padding:1px;"></a>
                                  <samp> <a href="" target="_blank"> 时间：<span>2016-04-17
至2016-04-17
</span></a></samp>
                                  <samp> <a href="" target="_blank"> 地址：<span>广州正佳广场万豪酒店三楼大宴会厅（靠近广州正佳广场西/西北门,地铁一号线体育中心站D3出口）</span></a></samp>
                              </li>


                          </ul>
                      </div>

                  </div>
            
            
            </div>
        
        </div>
        <!--li_main-->
    	<div class="li_main">
        	<h2 class="title"><span class="ti">${category.menuName}</span>
            	<span class="position"><fmt:message key="common.local.position" bundle="${main }" />：<a href="${ctx }/" ><fmt:message key="index.headbar.home" bundle="${main }" /></a> > ${category.menuName} </a></span>
            </h2>
            <div class="ab_content">
            <c:choose>
            	<c:when test="${category.id==17 }">
            		<ul>
			          <c:forEach var="link"  items="${frLinks.pageList }">
			          	<li style="width:117px;float:left;margin:5px;"><a href="${link.contentPath }"><img width="117"  height="47" src="${imagePath }${link.contentImage }" /></a></li>
			          </c:forEach>
			        </ul>
            	</c:when>
            	<c:otherwise>
            		${summary.contentContent }
            	</c:otherwise>
            </c:choose>
            
            </div>
            
                       
        </div>
        <!--li_main end-->
    </div>

	<!--网页底部开始-->
   <%@include file="include/foot.jsp" %>
  <!--网页底部结束-->


</div>

<script type="text/javascript">
	$(function(){
	$("#uu").scrollVertical(35);     
	//滚动	    
	});
</script>



</body>
</html>
