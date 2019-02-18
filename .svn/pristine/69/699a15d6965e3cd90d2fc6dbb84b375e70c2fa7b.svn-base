<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
		<script src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		<input type="hidden" id="uid" value="${uid }">
				<div style="margin-bottom:20px;">
				<input type="radio" name="addSub" value="1" checked="checked">加分&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="addSub" value="0" >减分
			</div>
			<div style="margin-bottom:20px;">
				<input class="easyui-numberbox" id="score" value="1" data-options="min:1,max:100" style="width:60px;">
				分
			</div>
			<div style="margin-bottom:20px;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
		function submitForm(){
					if($("#score").val()==''||$("#score").val()==null)return false;
					 var addSub="";
		    var  radios=document.getElementsByName("addSub");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)addSub=radios[i].value;
	     	var data={
	     				"uid":$("#uid").val(),
	     				"score":$("#score").val(),
                      	"addSub":addSub
	     	}
						 $.ajax({
                      type: "POST",
                      url: "createScore",
                      contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
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
</html>