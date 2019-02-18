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
		<input type="hidden" value="${score.id }" id="id">
						<div style="margin-bottom:20px;">
				<c:if test="${score.addSub==1 }">+</c:if>
				<c:if test="${score.addSub==0 }">-</c:if>
				<input class="easyui-numberbox" id="score" value="${score.score }" data-options="min:1,max:100" style="width:60px;">
				分
			</div>
				<div style="margin-bottom:20px;">
				<label>状态：</label>
				<input type="radio" name="state" value="1" ${score.state==1 ?'checked':'' }>有效&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="state" value="0" ${score.state==0 ?'checked':'' }>无效
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
					 var state="";
		    var  radios=document.getElementsByName("state");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)state=radios[i].value;
	     	var data={
	     				"id":$("#id").val(),
	     				"score":$("#score").val(),
                      	"state":state
	     	}
						 $.ajax({
                      type: "POST",
                      url: "updateScore",
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