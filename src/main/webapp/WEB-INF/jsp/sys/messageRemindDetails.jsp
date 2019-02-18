<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css"
	rel="stylesheet" />

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/content/Site.css">
<script type="text/javascript"
	src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/jquery.easyui.plus.js"></script>
<link
	href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css"
	rel="stylesheet" />
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
		<script src="<%=basePath%>js/url.js"></script>
</head>
<style>
td {
	border: solid #CCCCCC;
	border-width: 0px 0px 1px 0px;
	padding: 10px 20px;
}
table {
	border: 0;
	font-size: 1.5em;
}
</style>
<body>
	<div style="padding:50px 5px 0px 20px;">
		<div class="mvctool">
		<a style="display: none;" id="remind"></a>
		<input id="id" value="${message.id }" type="hidden">
			<table style="width: 100%;line-height: 200%;">
				<thead>
					<tr align="center">
						<td><font style="font-weight: bold;font-size: 1.6em;">${message.messages.title}</font></td>
						</tr>
						<tr align="center">
						<td>
							<c:if test="${message.messages.type==1}">督查事项</c:if> <c:if test="${message.messages.type==2}">周计划</c:if>
							<c:if test="${message.messages.type==4}">协同文件</c:if> <c:if
								test="${message.messages.type==3}">其他</c:if>
								 <c:if test="${message.messages.type==5}">月计划</c:if>
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<fmt:formatDate
								value="${message.readingTime }" pattern="yyyy-MM-dd HH:mm:ss" />
								</td>
							</tr>
							<tr align="center">
								<td>${message.messages.body }</td>
					</tr>
				</thead>
			</table>
		</div>
		</div>
</body>
<script type="text/javascript">
	$(function() {
					      var websocket;
					        websocket = new WebSocket("ws://"+url+"websocket");
						$("#remind").click(function(){
							  var text = '4';
					        if(text == null || text == "")return false;
					        var msg = {
					            msgContent: text,
					            postsId: 1
					        };
					        if (websocket.readyState==1) {
					        websocket.send(JSON.stringify(msg));
					        }
					        var type="${message.messages.type}";
					        var url="${message.messages.url}";
					        if(type==1){
					        	location.href='../inspector/inspectorDetails?iid='+url;
					        }else if(type==2){
					        	setTimeout("location.href='../weeks/weeksplanparticulars?wid="+url+"'", 1000);
					        }else if(type==4){
					        	setTimeout("location.href='../Annc/particulars?id="+url+"'", 1000);
					        }else if(type==5){
					        	setTimeout("location.href='../month/monthplanauditparticularPage?mid="+url+"'", 1000);
					        }else{
					        location.href='../home/index';
					        }
					        });
			var data={
				"state":1,
				"id":$("#id").val()
			}
					$.ajax({
                      type: "POST",
                      url: "updateMessageRemind",
                      contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
					        $("#remind").trigger("click");
                      }, 
                  });
	});
</script>
</html>