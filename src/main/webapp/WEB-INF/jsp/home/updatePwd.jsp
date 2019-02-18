<%@ page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
</head>
<body>
	<h2>修改个人密码</h2>
	<div style="margin:40px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		<input type="hidden" value="${user.uid }" id="uid">
						<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-passwordbox"  id="oldpwd" iconWidth="28" style="width:350px;height:34px;padding:10px"  data-options="label:'原&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：',required:true,missingMessage:'*必填项'">
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<input id="pass"  class="easyui-passwordbox"  iconWidth="28" style="width:350px;height:34px;padding:10px" data-options="label:'新&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：',required:true,missingMessage:'*必填项'">
			</div>
				<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-passwordbox" id="pass2"  iconWidth="28" validType="confirmPass['#pass']" style="width:350px;height:34px;padding:10px" data-options="label:'确认新密码：',required:true,missingMessage:'*必填项'">
			</div>
			<div style="margin-bottom:20px;margin-left: 36%;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()" style="width:100px">重置</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
		$.extend($.fn.validatebox.defaults.rules, {
			confirmPass: {
				validator: function(value, param){
					var pass = $(param[0]).passwordbox('getValue');
					return value == pass;
				},
				message: '两次输入的密码不一致.'
			}
		});
		function submitForm(){
			if($("#oldpwd").val()==''||$("#oldpwd").val()==null
			||$("#pass").val()==''||$("#pass").val()==null
			||$("#pass2").val()==''||$("#pass2").val()==null)return false;
			
			if($("#pass").val()!=$("#pass2").val())return false;
						 $.ajax({
                      type: "POST",
                      url: "updatepwd",
                      data:"oldpwd="+escape(encodeURIComponent($("#oldpwd").val()))+"&newpwd="+
                      escape(encodeURIComponent($("#pass").val()))+"&uid="+$("#uid").val(),
                      success: function (data) {
                          if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
		}
		
		function clearForm(){
			$('#frm').form('clear');
		}
	</script>
</html>