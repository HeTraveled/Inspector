<%@ page contentType="text/html;charset=utf-8" pageEncoding="UTF-8"	%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";	
%>
<!DOCTYPE HTML>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="renderer" content="webkit">
         <script src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
        <script type="text/javascript" src="https://cdn.bootcss.com/sockjs-client/1.1.4/sockjs.min.js" ></script>
    </head>
 <style>
td{
border-bottom:2px solid #FFC1C1;
}
a:link {color: black; text-decoration:none;} 
a:active:{color: black;text-decoration:none; }
a:visited {color:black;text-decoration:none;} 
a:hover {color: black; text-decoration:none;} 
</style>
    <body>
<table style="border-collapse:separate; border-spacing:0px 10px;width: 100%;height: 100%;">
<c:forEach items="${dialog }" var="d">
	<tr>
		<td style="font-size: 8px;">
		<a href="javascript:parent.addTab('${d.messages.title }','../messageRemind/messageRemindDetails?id=${d.id }','fa fa-envelope-o')">
		[
		<c:if test="${d.messages.type==1 }">
			督查事项
		</c:if>
		<c:if test="${d.messages.type==2 }">
			周计划
		</c:if>
		<c:if test="${d.messages.type==3 }">
			其他
		</c:if>
		<c:if test="${d.messages.type==4 }">
			协同文件
		</c:if>
		<c:if test="${d.messages.type==5 }">
			月计划
		</c:if>
		]
		${d.messages.title }</a></td>
		<td width="50" style="font-size: 8px;" align="right">
			<fmt:formatDate value="${d.readingTime }" pattern="MM-dd HH:mm:ss" />
		</td>
	</tr>
</c:forEach>
</table>
  </body>
  </html>