<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
<link rel="stylesheet"
	href="<%=basePath%>ueditor-mini1.2.2/themes/default/_css/umeditor.css"
	type="text/css"></link>
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
	<link href="<%=basePath%>css/tab.css" rel="stylesheet" />
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<style>
td {
	border: solid #CCCCCC;
	border-width: 0px 1px 1px 0px;
	padding: 10px 20px;
}

table {
	font-size: 1.4em;
}
a {font-size:16px} 
a:link {color: black; text-decoration:none;} 
a:active:{color: black; } 
a:visited {color:black;text-decoration:none;} 
a:hover {color: black; text-decoration:underline;} 
</style>
<body>
	<div style="padding:20px 5px 0px 20px;">
		<div class="mvctool">
			<table style="width: 100%;line-height: 200%;" id="table-4">
				<thead>
					<tr align="center">
						<td><font style="font-weight: bold;font-size: 22px;">${regulations.title}</font>
					<!-- 	&nbsp;&nbsp;
						<c:if test="${regulations.type==1}">制度</c:if>
						<c:if test="${regulations.type==2}">岗位职责</c:if>
						<c:if test="${regulations.type==3}">表格</c:if>
						 -->
						</td>
					</tr>
						<tr align="center">
					<td>${regulations.createBy}&nbsp;&nbsp;<fmt:formatDate value="${regulations.createTime }"
									pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
					</tr>
					<c:if test="${fn:length(files) != 0 }">
							<tr>
				<td>
				<div style="margin-bottom:20px;">
				<c:forEach items="${files }" var="file">
					<a href="../home/download?filename=${file.attachment }">${file.attachment }</a>
					<br>
				</c:forEach>
			</div>
						</td>
					</tr>
					</c:if>
				</thead>
			</table>
		</div>
		</div>
</body>
</html>