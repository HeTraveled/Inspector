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
</style>
<body>
	<div style="padding:5px 5px 0px 20px;">
		<div class="mvctool">
			<table style="width: 100%;line-height: 200%;">
				<thead>
					<tr>
						<td><font style="font-weight: bold;">标题：</font>${official.title}</td>
					<tr>
						<td><font style="font-weight: bold;">内容：</font>${official.body }</td>
					</tr>
					<tr>
					<td><font style="font-weight: bold;">发布人：</font>${official.createBy}</td>
					</tr>
					<tr>
						<td><font style="font-weight: bold;">发布时间：</font>
								<fmt:formatDate value="${official.createTime }"
									pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
					</tr>
					<tr>
					<td><font style="font-weight: bold;">状态：</font>
					<c:if test="${official.state==1 }">已读</c:if>
					<c:if test="${official.state==0 }">未读</c:if>
					</td>
					</tr>
					<tr>
						<td>
							<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">已阅文</a>
							<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:150px">阅文并发送督查事项</a>
						</td>
					</tr>
				</thead>
			</table>
		</div>
		</div>
</body>
</html>