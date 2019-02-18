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
						<div style="margin-bottom:20px;">
			<input class="easyui-datetimebox"  id="startTime" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'开始时间：',required:true,missingMessage:'*必填项'"">
			</div>
				<div style="margin-bottom:20px;">
			<input class="easyui-datetimebox"  id="endTime" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'结束时间：',required:true,missingMessage:'*必填项'"">
			</div>
		<div style="margin-bottom:20px;">
			<input class="easyui-textbox" id="body"  style="width:500px;height:160px" data-options="label:'内容：',multiline:true,required:true,missingMessage:'*必填项',validType:'length[1,200]'">
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
	/*
	$("#startTime").datebox().datebox('calendar').calendar({ validator:function(day){
    var timestamp = Date.parse(new Date());
    var lasttime = timestamp-86400000;
    var last = new Date(lasttime);
    return day > last;
} });
	$("#endTime").datebox().datebox('calendar').calendar({ validator:function(day){
    var timestamp = Date.parse(new Date());
    var lasttime = timestamp-86400000;
    var last = new Date(lasttime);
    return day > last;
} });
*/
	var date="${startTime}";
	if(date!=null){
	$("#startTime").datetimebox("setValue", parsedate(date)+" 00:00:00"); 
	$("#endTime").datetimebox("setValue", parsedate(date)+" 23:59:59"); 
	}
	});
		function submitForm(){
		 if($("#startTime").val()==''||$("#startTime").val()==null)return false;
		 if($("#endTime").val()==''||$("#endTime").val()==null)return false;
		if(new Date($("#startTime").val().replace(/\-/g, "\/")) >
					new Date($("#endTime").val().replace(/\-/g, "\/"))){
					$.messager.alert('系统提示','开始时间不能大于结束时间！','warning');
						return false;
					}
	 if($("#body").val()==''||$("#body").val()==null)return false;
	 if($("#body").val().length>200)return false;
	     	var data={
	     				"body":$("#body").val(),
                      	"startTime":$("#startTime").val(),
                      	"endTime":$("#endTime").val()
	     	}
						 $.ajax({
                      type: "POST",
                      url: "createSchedule",
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