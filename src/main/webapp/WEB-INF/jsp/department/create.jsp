<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
	<script src="<%=basePath%>js/ajaxfileupload.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
				
				<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="departmentname" iconWidth="28" style="width:280px;height:34px;padding:10px"  data-options="label:'部门名称：&nbsp;&nbsp;',required:true,missingMessage:'*必填项'">
				</div>
			
			
				<div style="margin-bottom:20px;margin-left: 30%;">
				<select class="easyui-combobox" label="上级部门：&nbsp;&nbsp;" style="width:280px;height:34px; " id="did" editable="false">
				<c:forEach items="${dept}" var="d">
					<option value="${d.id }">${d.departmentname }</option>
				</c:forEach>
				</select>
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<select class="easyui-combobox" label="分管领导：&nbsp;&nbsp;" style="width:280px;height:34px; " id="hid" editable="false">
				<c:forEach items="${hquser}" var="h">
					<option value="${h.uid }">${h.name}</option>
				</c:forEach>
				</select>
			</div>
			
			
				<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="tel" iconWidth="28" style="width:280px;height:34px;padding:10px"  data-options="label:'办公电话：&nbsp;&nbsp;'">
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="fax" iconWidth="28" style="width:280px;height:34px;padding:10px"  data-options="label:'部门传真：&nbsp;&nbsp;'">
			</div>
			<div style="margin-bottom:20px;margin-left: 32%;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm(1)" style="width:100px">确认</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm(2)" style="width:100px">取消</a>
			</div>
			
		</form>
		</div>
</body>
	<script type="text/javascript">   
		
		function submitForm(number){
				if(number==1){		     	
	     	var data={
	     				"departmentname":$("#departmentname").val(),
                      	"topDid":$("#did").val(),
                      	"tel":$("#tel").val(),
                      	"fax":$("#fax").val(),
                      	"leadership":$("#hid").val(),
                      };
                      if(data.departmentname==""||data.departmentname==null){
                      $.messager.alert('系统提示','请填写正确部门名称！','warning');
                      return false;
					 }else{
					  $.ajax({
                      type: "POST",
                      url: "createDept",
                      contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
                          if (data.code==200) {
                          			 window.parent.frameReturnByMes(data.message);
					                 window.parent.frameReturnByClose();
					                  }
					                  setTimeout("location.href='Deptlist'",1000);
                      },
                      
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  }
		}else{
		  window.parent.frameReturnByClose();
		}
		}
	</script>
</html>