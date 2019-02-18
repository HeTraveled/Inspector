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
				<input class="easyui-textbox"  id="id" value="${dep.id}" type="hidden">
				</div>
				<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="departmentname" value="${dep.departmentname }" iconWidth="28" style="width:280px;height:34px;padding:10px"  data-options="label:'部&nbsp;门&nbsp;名&nbsp;称：&nbsp;&nbsp;',required:true,missingMessage:'*必填项'">
			</div>
			<c:if test="${dep.topDid!=0}">
				<div id="div1" style="margin-bottom:20px;margin-left: 30%;">
				<select class="easyui-combobox" label="上&nbsp;级&nbsp;部&nbsp;门&nbsp;：&nbsp;" style="width:280px;height:34px;" id="topDid" editable="false">
				<c:forEach items="${dept }" var="d">
					<option value="${d.id }" <c:if test="${d.id==dep.topDid}">selected</c:if>>${d.departmentname }</option>
				</c:forEach>
				</select>
			</div>
			</c:if>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<select class="easyui-combobox" label="部门责任人：&nbsp;&nbsp;" style="width:280px;height:34px;" id="uid" editable="false">
				<c:forEach items="${user}" var="u">
					<option value="${u.uid }" <c:if test="${u.uid==dep.principal}">selected</c:if>>${u.name}</option>
				</c:forEach>
				</select>
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">

				<select class="easyui-combobox" label="分&nbsp;管&nbsp;领&nbsp;导：&nbsp;&nbsp;" editable="false" style="width:280px;height:34px; "id="hid" editable="false">

				<c:forEach items="${hquser}" var="h">
					<option value="${h.uid }" <c:if test="${h.uid==dep.leadership}">selected</c:if>>${h.name}</option>
				</c:forEach>
				</select>
			</div>
				<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="tel" value="${dep.tel }" iconWidth="28" style="width:280px;height:34px;padding:10px"  data-options="label:'办&nbsp;公&nbsp;电&nbsp;话：&nbsp;&nbsp;'">
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="fax" value="${dep.fax }" iconWidth="28" style="width:280px;height:34px;padding:10px"  data-options="label:'部&nbsp;门&nbsp;传&nbsp;真：&nbsp;&nbsp;',">
			</div>
			
				
				

				
			<div style="margin-bottom:20px;margin-left:32%;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm(1)" style="width:100px;">确认</a>
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
	     				"id":$("#id").val(),
	  			   		"departmentname":$("#departmentname").val(),
	     				"topDid":$("#topDid").val(),
	     				"principal":$("#uid").val(),
	     				"tel":$("#tel").val(),
	     				"fax":$("#fax").val(),
	     				"leadership":$("#hid").val(),
	     	}
	     
					  $.ajax({
                      type: "POST",
                      url: "Deptupdate",
                      contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
                                   
                          if (data.code==200) {
                          			 window.parent.frameReturnByMes(data.message);
					                 window.parent.frameReturnByClose();
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  }else{
                     window.parent.frameReturnByClose();
                  }
		}
	</script>
</html>