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
   <style type="text/css">
   *{    box-sizing: border-box;}
   ul{
   margin:0}
/* scrollDiv */
.scrollDiv {
	height: 25px;/* 必要元素 */
	line-height: 25px;
	overflow: hidden;/* 必要元素 */
}
.scrollDiv li {
	height: 25px;
	line-height: 25px;
	padding-left: 10px;
	list-style-type:none;
}
.scrollDiv a {
	font-size:18px;
	font-weight:bold;
	color: white;
}
a:link {color: white; text-decoration:none;} 
a:active:{color: white;text-decoration:none; }
a:visited {color:white;text-decoration:none;} 
a:hover {color: white; text-decoration:none;} 
</style>
    <body>

<div class="scrollDiv" id="s1" style=" width:100%;   text-align: center;margin-top:5px">
	<ul>
 <c:forEach items="${horn }" var="h">
	 <li><a href="javascript:void(0);" onclick="javascript:parent.addTab('${h.title }','../horn/hornDetails?id=${h.id }','fa fa-bullhorn')">
	${h.title }</a></li>
 </c:forEach>
  </ul>
  </div>
  </body>
  </html>
 <script type="text/javascript">
 		function AutoScroll(obj) {
			$(obj).find("ul:first").animate({
				marginTop: "-25px"
			}, 500, function() {
				$(this).css({
					marginTop: "0px"
				}).find("li:first").appendTo(this);
			});
		}
  	$(function() {
  	//var leng="${fn:length(horn)}";
		//	  	if(leng!=0&&leng!=1){
			  	setInterval('AutoScroll("#s1")', 5000);
  	//}
  });
</script>