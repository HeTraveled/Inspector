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
		<input id="id" type="hidden" value="${emergencyRecord.id }">
				<div style="margin-bottom:20px;">	
				<label>进展情况：</label>
		<select id="state" class="easyui-combobox" style="width:150px;height:35px;padding:10px;" editable="false">
				<option value="1" <c:if test="${emergencyRecord.state==1}">selected</c:if>>进行中</option>
				<option value="2" <c:if test="${emergencyRecord.state==2}">selected</c:if>>未完成</option>
				<option value="3" <c:if test="${emergencyRecord.state==3}">selected</c:if>>已完成</option>
				</select>
				</div>
		<div style="margin-bottom:20px;">
			<input class="easyui-textbox" id="body" value="${emergencyRecord.body }" style="width:500px;height:160px" data-options="label:'工作内容：',multiline:true,required:true,missingMessage:'*必填项'">
			</div>
			<div style="margin-bottom:20px;">
			<input class="easyui-datebox"  id="endTime" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'办结期限：',required:true,missingMessage:'*必填项'"">
			</div>
						<div style="margin-bottom:20px;">
			<input class="easyui-textbox" id="liable"  value="${emergencyRecord.liable }" style=width:265px;height:34px;" data-options="label:'责任人：',multiline:true,required:true,missingMessage:'*必填项'">
			</div>
			<div style="margin-bottom:20px;margin-left: 40%;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   	
	function parsedate(value){
    	var date = new Date(value);
	var year = date.getFullYear();
	var month = date.getMonth()+1; //月份+1   
	var day = date.getDate(); 
	var hour = date.getHours(); 
	var minutes = date.getMinutes(); 
	var second = date.getSeconds();
	return  year+"-"+month+"-"+day;
	}
	$(function() {
	$("#endTime").datebox("setValue", parsedate("${emergencyRecord.endTime}")); 
	});
		function submitForm(){
		 if($("#endTime").val()==''||$("#endTime").val()==null)return false;
	 if($("#body").val()==''||$("#body").val()==null)return false;
	  if($("#liable").val()==''||$("#liable").val()==null)return false;
		  var state="";
		   var  radios=document.getElementsByName("state");
	     for(var i=0;i<radios.length;i++)if(radios[i].checked)state=radios[i].value;
	     	var data={
	     				"body":$("#body").val(),
                      	"endTime":$("#endTime").val(),
                      	"state":state,
                      	"id":$("#id").val(),
                      	"liable":$("#liable").val()
	     	}
						 $.ajax({
                      type: "POST",
                      url: "updateBoard",
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