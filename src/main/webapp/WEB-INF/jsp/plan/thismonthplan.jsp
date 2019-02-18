<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    	<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=basePath%>ueditor-mini1.2.2/themes/default/_css/umeditor.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/content/Site.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
    <link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
    <script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/jquery.easyui.plus.js"></script>
    <link rel="stylesheet" href="<%=basePath%>ueditor/themes/default/css/umeditor.css" type="text/css"></link>
    <script type="text/javascript" src="<%=basePath%>ueditor/third-party/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.config.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
    <script src="<%=basePath%>js/ajaxfileupload.js"></script>
	<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<style>
td{border:solid #CCCCCC; border-width:0px 1px 1px 0px; padding:10px 20px;}
table{border:solid #CCCCCC; border-width:1px 0px 0px 1px;font-size: 1.5em;}
</style>
<body>

	<div style="padding:5px 5px 0px 20px;">
		<div class="mvctool">
		<table style="width: 100%;line-height: 200%;">
			<thead>
			
		<c:if test="${lastmonthnext!=null }">
				<tr id="tr1"><td colspan="2"><font style="font-weight: bold;size">本月工作详情：</font>
				<c:forEach items="${lastmonthnext}" var="lwn" varStatus="status">
				</br>
				<tr><td colspan="2">${ status.index+1}.
				
				期限：<fmt:formatDate value="${lwn.startTime}"  pattern="yyyy-MM-dd"/>至
				<fmt:formatDate value="${lwn.endTime}"  pattern="yyyy-MM-dd"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${lwn.state==1}">[ 进行中 ]</c:if>
				<c:if test="${lwn.state==2}">[ 未完成 ]</c:if>
				<c:if test="${lwn.state==3}">[ 已完成 ]</c:if>
				<%-- ${u.startTime}${u.endTime} --%> <br>${lwn.body}</td></tr>
				</c:forEach>
				</td>
				</tr>
				<tr ><td colspan="2"><font ">本月工作备注：</font>
				${lastmonth.remarks }
				</td>
				</tr>
				</c:if>
				<c:if test="${lastmonthnext==null }">
					<tr id="tr1"><td colspan="2"><font style="font-weight: bold;size">本月暂无工作</font>
				</c:if>
				<br>	
			
			</thead>
		</table>
		
		
						
	</div>
	
</body>
</html>