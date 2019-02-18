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
		<c:if test="${muchdept==true }">
			<div style="margin-bottom:20px;">	
				<label>部门：</label>
				<select id="did" class="easyui-combobox" style="width:150px;height:35px;padding:10px;" editable="false">
				<c:forEach items="${muchdepts }" var="m">
						<option value="${m.id }" <c:if test="${m.id==depts}">selected</c:if>>${m.departmentname }</option>
					</c:forEach>
				</select>
				</div>
		</c:if>
		<c:if test="${muchdept!=true }">
		<input id="did" type="hidden">
		</c:if>
				<div style="margin-bottom:20px;">	
				<label>紧急情况：</label>
		<select id="emergency" class="easyui-combobox" style="width:150px;height:35px;padding:10px;" editable="false">
				<option value="1">重要且紧急的</option>
				<option value="2">重要但不紧急的</option>
				<option value="3">不重要但紧急的</option>
				<option value="4" selected>不重要也不紧急的</option>
				</select>
				</div>
		<div style="margin-bottom:20px;">
			<input class="easyui-textbox" id="body"  style="width:500px;height:160px" data-options="label:'工作内容：',multiline:true,required:true,missingMessage:'*必填项'">
			</div>
			<div style="margin-bottom:20px;">
			<input class="easyui-datebox"  id="endTime" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'办结期限：',required:true,missingMessage:'*必填项'"">
			</div>
							<div style="margin-bottom:20px;">
			<input class="easyui-textbox" id="liable"  style=width:265px;height:34px;" data-options="label:'责任人：',multiline:true,required:true,missingMessage:'*必填项'">
			</div>
			<div style="margin-bottom:20px;margin-left: 40%;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   	
	$(function() {
	$("#endTime").datebox().datebox('calendar').calendar({ validator:function(day){
    var timestamp = Date.parse(new Date());
    var lasttime = timestamp-86400000;
    var last = new Date(lasttime);
    return day > last;
} });
	});
		function submitForm(){
		 if($("#endTime").val()==''||$("#endTime").val()==null)return false;
	 if($("#body").val()==''||$("#body").val()==null)return false;
	 if($("#liable").val()==''||$("#liable").val()==null)return false;
	     	var data={
	     				"body":$("#body").val(),
                      	"endTime":$("#endTime").val(),
                      	"emergency":$("#emergency").val(),
                      	"did":$("#did").val(),
                      	"liable":$("#liable").val()
	     	}
						 $.ajax({
                      type: "POST",
                      url: "createBoard",
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