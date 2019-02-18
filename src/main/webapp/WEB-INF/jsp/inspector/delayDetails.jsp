<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
			<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
	<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
	  	<script src="<%=basePath%>js/url.js"></script>
			<style type="text/css">
		.icon-filter{
			background:url('<%=basePath%>images/filter.png') no-repeat left center;
		}
		label{
			font-size: 1.5em;
		}
	</style>
</head>
<body>
	<div style="margin:15px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
					<div style="margin-bottom:20px;">
			<label>延期天数：${ins.delayDay }</label>
			</div>
			<div style="margin-bottom:20px;">
				<label>延期原因：${ins.cause }</label>
			</div>
					<div style="margin-bottom:20px;">
					<label>状态：
					<c:if test="${ins.applyCause==0 }">未通过</c:if>
					<c:if test="${ins.applyCause==1 }">已通过</c:if>
					<c:if test="${ins.applyCause==2 }">审核中</c:if>
					<c:if test="${ins.applyCause==3 }">已延期</c:if>
				</label>
						</div>
						<c:if test="${user.uid==leadership&&ins.applyCause==2 }">
					<div style="margin-bottom:20px;">
					<x style="position: relative;left: 35%;">
						<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="sub(0)" style="width:100px">不通过</a>
						<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="sub(1)" style="width:100px">通过</a>
						</x>
						</div>
					</c:if>
					<c:if test="${user.rid==1&&ins.applyCause==1 }">
					<x style="position: relative;left: 35%;">
						<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="subform()" style="width:100px">确认</a>
					</c:if>
			</div>
		</div>
		<script type="text/javascript">   
		function sub(flag){
		var iid="${ins.iid}";
		var delayDay="${ins.delayDay}";
							$.ajax({
						type : "GET",
						url : "updateDelay",
						data : "iid="+iid+"&applyCause="+flag,
						success : function(data) {
						         if (data.code > 0) {
                          			 window.parent.frameReturnByMes(data.message);
					                 window.parent.frameReturnByClose();
                          }
						},
						   error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
					});
		}
				function subform(){
		var iid="${ins.iid}";
		var delayDay="${ins.delayDay}";
							$.ajax({
						type : "GET",
						url : "insupdateDelay",
						data : "iid="+iid+"&delayDay="+delayDay,
						success : function(data) {
						         if (data.code > 0) {
                          			 window.parent.frameReturnByMes(data.message);
					                 window.parent.frameReturnByClose();
                          }
						},
						   error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
					});
		}
	</script>
</body>
</html>