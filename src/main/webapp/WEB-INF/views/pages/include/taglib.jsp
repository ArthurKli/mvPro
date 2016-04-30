<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="/WEB-INF/tlds/time.tld" prefix="t" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<c:set var="pages" value="${pageContext.request.contextPath}/static/pages"/>
<c:set var="imagePath" value=""/>
<c:set var="videoPath" value="${properties['url.videoPath'] }"/>
<fmt:setLocale value="zh_CN"/>
<c:if test="${!empty sessionScope.locate && sessionScope.locate=='en'}">
<fmt:setLocale value="en_US"/>
</c:if>
<fmt:setBundle basename="main" var="main"  />