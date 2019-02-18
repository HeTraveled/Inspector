<%@ page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<title>找回密码</title>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
</head>
<body>
	<div style="margin:40px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post" action="updateinfo">
						<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox" name="name" style="width:65%" data-options="label:'用户名：'">
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox" name="name" style="width:35%" data-options="label:'验证码：'">
				<a href="#" class="easyui-linkbutton" style="width:30%">获取验证码</a>
			</div>
		<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox" name="name" style="width:65%" data-options="label:'新密码：'">
			</div>
			<div style="text-align:center;padding:5px 0">
			<a href="#" class="easyui-linkbutton" style="width:30%">确认</a>
			</div>
		</form>
		</div>
</body>
</html>