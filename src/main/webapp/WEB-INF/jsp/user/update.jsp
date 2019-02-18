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
		<input type="hidden" id="uid" value="${use.uid }">
				<div style="margin-bottom:20px;margin-left: 45%;">
			 <input type="hidden" value="<%=imgPath%>" id="addimgPath"/>
				<img src="${use.headimg }" id="img"  style="width:100px;height:100px;border-radius:100px;" onclick="uploadFile.click()"/>
				<input type="hidden" id="headimg" value="${use.headimg }">
				<input id="uploadFile" name="file" type="file" onchange="chooseImg()" style="display:none">
			</div>
						<div style="margin-bottom:20px;margin-left: 30%;">
				<select class="easyui-combobox" label="所属部门：" style="width:60%" id="did" editable="false">
				<c:forEach items="${dept }" var="d">
					<option value="${d.id }" <c:if test="${d.id==use.did}">selected</c:if>>${d.departmentname }</option>
				</c:forEach>
				</select>
			</div>
				<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="phone" value="${use.phone }" iconWidth="28" style="width:60%;height:34px;padding:10px"  data-options="label:'手机号：',required:true,missingMessage:'*必填项'">
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="employeeNo" value="${use.employeeNo }" iconWidth="28" style="width:60%;height:34px;padding:10px"  data-options="label:'员工编号：',required:true,missingMessage:'*必填项'">
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<input id="password" type="hidden" value="${use.password }">
				<label>密&nbsp;&nbsp;&nbsp;&nbsp;码：</label>
				<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="chong()" style="width:45%">重置初始密码</a>
			</div>
			<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="name" value="${use.name }" iconWidth="28" style="width:60%;height:34px;padding:10px"  data-options="label:'姓&nbsp;&nbsp;&nbsp;&nbsp;名：'">
			</div>
							<div style="margin-bottom:20px;margin-left: 30%;">
				<label>性&nbsp;&nbsp;&nbsp;别：</label>
				<input type="radio" name="sex" value="0" ${use.sex==0 ?'checked':'' } />男
				<input type="radio" name="sex" value="1" / ${use.sex==1 ?'checked':'' } >女
			</div>
				<div style="margin-bottom:20px;margin-left: 30%;">
				<select class="easyui-combobox" label="权&nbsp;&nbsp;&nbsp;&nbsp;限：" style="width:60%" id="rid" editable="false">
				<c:forEach items="${role }" var="r">
					<option value="${r.rid }" <c:if test="${r.rid==use.rid}">selected</c:if>>${r.name }</option>
				</c:forEach>
				</select>
			</div>
				<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="job" value="${use.job }" iconWidth="28" style="width:60%;height:34px;padding:10px"  data-options="label:'职&nbsp;&nbsp;&nbsp;&nbsp;务：'">
			</div>
				<div style="margin-bottom:20px;margin-left: 30%;">
				<input class="easyui-textbox"  id="tel" iconWidth="28" value="${use.tel }" style="width:60%;height:34px;padding:10px"  data-options="label:'办公电话：'">
			</div>
					<div style="margin-bottom:20px;margin-left: 30%;">
						<label style="color: red;font-weight: bold;">* 注：员工、主管、主任、主要领导为普通操作权限
						<br>督查员相当于系统管理员权限</label>
						</div>
			<div style="margin-bottom:20px;margin-left: 45%;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:100px;">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
	function chong(){
	$.messager.confirm('系统提示', '确定要重置吗？', function(r) {
				if (r) {
		$("#password").val('888888');
		 $.messager.alert('系统提示','<font style="font-weight: bold;color:red;">密码重置成功！<br><br>请点击页面确认保存更改，否则本次重置无效。</font><br><br><font style="font-weight: bold;">请及时联系相关账号更换新密码，防止被他人盗用！<br><br>初始密码：888888</font>');
	}
	});
	}
			function chooseImg(){
					  if (!/\.(gif|jpg|jpeg|png|JPG|PNG)$/.test($("#uploadFile").val())) {  
				           $.messager.alert('系统提示','请上传正确图片格式！','warning');
				            this.value = ""; 
				            return false;  
				        }
				     var imgPath=$('#addimgPath').val();
	   $.ajaxFileUpload({  
		        url: 'headImg', 
		        secureuri: false, 
		        fileElementId: 'uploadFile', 
		        enctype:'multipart/form-data',
		        dataType:'text',
		        success: function (data)  {
		     	   $("#img").attr("src",imgPath+data);
			       $("#headimg").val(imgPath+data);
		        },
		        error: function (data, status, e){
		           $.messager.alert('系统提示','请求出错！','error');
		       	 }
		    });
			}
		function submitForm(){
					if($("#phone").val()==''||$("#phone").val()==null
					||$("#password").val()==''||$("#password").val()==null||$("#employeeNo").val()==''||$("#employeeNo").val()==null)return false;
					var telReg = !!$("#phone").val().match(/^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$/);
					if(!telReg){
						 $.messager.alert('系统提示','请填写正确手机号码！','warning');
						 return false;
					}
			 var sex="";
		     var  radios=document.getElementsByName("sex");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)sex=radios[i].value;
	     	var data={
	  			   		"uid":$("#uid").val(),
	     				"phone":$("#phone").val(),
	     				"did":$("#did").val(),
	     				"wechat":$("#wechat").val(),
                      	"password":escape(encodeURIComponent($("#password").val())),
                      	"name":$("#name").val(),
                      	"tel":$("#tel").val(),
                      	"rid":$("#rid").val(),
                      	"job":$("#job").val(),
                      	"headimg":$("#headimg").val(),
                      	"sex":sex,
                      	 "employeeNo":$("#employeeNo").val()
	     	}
						 $.ajax({
                      type: "POST",
                      url: "updateUser",
                      contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
                                   if(data.code==202){
					                     $.messager.alert('系统提示',data.message,'warning');
					                     return false;
					                     }
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