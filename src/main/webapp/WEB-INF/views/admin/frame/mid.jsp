<%@page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
    <title>thfhfhfh</title>
     <script>

    function shleft()
    {
       if (parent.frameset.cols=="0,10,*"){
              parent.frameset.cols="200,10,*"
              document.getElementById("img").src="${ctxStatic}/images/arrow_left.gif"
           }
        else{
              parent.frameset.cols="0,10,*"
              document.getElementById("img").src="${ctxStatic}/images/arrow_right.gif"
          }
    }
  
</script>
<style type=text/css>
.navpoint {color: 5e95c3; cursor: hand; font-family: webdings; font-size: 9pt}
</style>

</head>
<body leftMargin=0 topMargin=0>
<TABLE height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
<TBODY>
<TR>
    <TD width="10px" height="50%">&nbsp;</TD>
</TR>
<TR>
    <TD style="BORDER-RIGHT: 0px; BORDER-TOP: 0px; BORDER-LEFT: 0px; BORDER-BOTTOM: 0px; " width="10px">
    
    <span class="navpoint" id=switchpoint title="rhfhffhf"><img id="img" src="${ctxStatic}/images/arrow_left.gif" onclick="shleft()"></span>
    </TD>
</TR>
<TR>
    <TD width="10px" height="50%">&nbsp;</TD>
</TR>
    </TBODY>
</TABLE>

</body>
</html>

