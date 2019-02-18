<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String imgPath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
		<script src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
	<script src="<%=basePath%>js/ajaxfileupload.js"></script>
<body>
	<h2>个人资料设置</h2>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post" action="updateinfo">
		<input type="hidden" value="${use.uid }" id="uid">
		<div style="margin-bottom:20px;margin-left: 45%;">
			 <input type="hidden" value="<%=imgPath%>" id="addimgPath"/>
             <input type="hidden" id="addImg" value="${use.headimg }"/>
				<img src="${use.headimg }" id="img"  style="width:100px;height:100px;border-radius:100px;" onclick="uploadFile.click()"/>
				<input id="uploadFile" name="file" type="file" onchange="chooseImg()" style="display:none">
			</div>
						<div style="margin-bottom:20px;margin-left: 40%;">
				<input type="radio" name="workState" value="1" ${use.workState==1?'checked':'' }/><span class="fa fa-child" style="font-size:20px"></span>&nbsp;<font style="font-weight:bold;">在岗中</font>
				<input type="radio" name="workState" value="2" ${use.workState==2?'checked':'' }/><span class="fa fa-clock-o" style="font-size:20px"></span>&nbsp;<font style="font-weight:bold;">请假中</font>
			</div>
			<div style="margin-bottom:20px;margin-left: 40%;">
			<input type="radio" name="workState" value="3" ${use.workState==3?'checked':'' }/><span class="fa fa-plane" style="font-size:20px"></span>&nbsp;<font style="font-weight:bold;">出差中</font>
				<input type="radio" name="workState" value="4" ${use.workState==4?'checked':'' }/><span class="fa fa-handshake-o" style="font-size:20px"></span>&nbsp;<font style="font-weight:bold;">会议中</font>
				<input type="radio" name="workState" value="5" ${use.workState==5?'checked':'' }/><span class="fa fa-male" style="font-size:20px"></span>&nbsp;<font style="font-weight:bold;">外出中</font>
			</div>
			<br>
			<!-- 
					<div style="margin-bottom:20px;margin-left: 40%;">
				<label>职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;务：${use.job }</label>
			</div>
			 -->
			  	<div style="margin-bottom:20px;margin-left: 40%;">
				<label>员工编号：${use.employeeNo }</label>
			</div>
					<div style="margin-bottom:20px;margin-left: 40%;">
				<label>所属部门：${deptname }</label>
			</div>
			<div style="margin-bottom:20px;margin-left: 40%;">
				<label>手&nbsp;机&nbsp;号：${use.phone }</label>
			</div>
						<div style="margin-bottom:20px;margin-left: 40%;'">
				<input class="easyui-textbox" id="name" name="name" style="width:222px" value="${use.name }" data-options="label:'姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：',required:true">
			</div>
			<div style="margin-bottom:20px;margin-left: 40%;">
			<label>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</label>
				<input type="radio" name="sex" value="0" ${use.sex==0?'checked':'' }/>男
				<input type="radio" name="sex" value="1" ${use.sex==1?'checked':'' }/>女
			</div>
				<div style="margin-bottom:20px;margin-left: 40%;">
			<label>出生日期：</label>
				<input class="easyui-datebox" value="${birth }"  id="birth" editable="false" style="width:140px;">
			</div>
			<div style="margin-bottom:20px;margin-left: 40%;">
				<input class="easyui-textbox" id="tel" name="tel" style="width:222px" value="${use.tel }" data-options="label:'办公电话：'">
			</div>
			<!-- 
			<div style="margin-bottom:20px;margin-left: 40%;">
				<select class="easyui-combobox" name="language" label="所属部门：" style="width:222px" id="did" editable="false">
				<c:forEach items="${dept }" var="d">
					<option value="${d.id }" <c:if test="${d.id==use.dept.id}">selected</c:if>>${d.departmentname }</option>
				</c:forEach>
				</select>
			</div>
			 -->
			<!--
						<div style="margin-bottom:20px;margin-left: 40%;">
				<input class="easyui-textbox" id="address" name="address" style="width:222px" value="${use.address }" data-options="label:'联系地址：'">
			</div>
			  -->
						<div style="margin-bottom:20px;margin-left: 40%;">
				<input class="easyui-textbox" id="e_mail" name="e_mail" style="width:222px" value="${use.e_mail }" data-options="label:'电子邮箱：'">
			</div>
			<div style="margin-bottom:20px;margin-left: 40%;">
			<label>系统消息：</label>
				<input type="radio" name="prompt" value="1" ${use.prompt==1?'checked':'' }/>开启
				<input type="radio" name="prompt" value="0" ${use.prompt==0?'checked':'' }/>关闭
			</div>
			<!-- 
			<c:if test="${use.rid==1 }">
					<div style="margin-bottom:20px;margin-left: 40%;">
					<input class="easyui-timespinner" label="日程推送：" id="protime"  editable="false" labelPosition="top" value="${propelling }" style="width:140px;">
			</div>
			</c:if>
			 -->
		</form>
		<div style="margin-bottom:20px;margin-left: 43%;">
			<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()" style="width:120px">保存</a>
		</div>
	</div>
	<script>
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
			       $("#addImg").val(imgPath+data);
                          			$.messager.show({
									title:'系统提示',
									msg:'上传成功！',
									timeout:5000,
									showType:'slide'
								});
		        },
		        error: function (data, status, e){
		           $.messager.alert('系统提示','请求出错！','error');
		       	 }
		    });
			}
		function submitForm(){
		if($("#name").val()=='')return false;
			 var workState="";
	     	 var  radios=document.getElementsByName("workState");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)workState=radios[i].value;
	     	var sex="";
	     	 var  radios1=document.getElementsByName("sex");
	     	for(var i=0;i<radios1.length;i++)if(radios1[i].checked)sex=radios1[i].value;
	     	var prompt="";
	     	 var  radios2=document.getElementsByName("prompt");
	     	for(var i=0;i<radios2.length;i++)if(radios2[i].checked)prompt=radios2[i].value;
	     	var data={
	     				"uid":$("#uid").val(),
                      	"name":$("#name").val(),
                      	"tel":$("#tel").val(),
                      	"address":$("#address").val(),
                      	"e_mail":$("#e_mail").val(),
                 	  	 "headimg":$("#addImg").val(),
                 	  	 "birth":$("#birth").val(),
                      	"sex":sex,
                      	"workState":workState,
                      	"prompt":prompt
	     	}
					 $.ajax({
                      type: "POST",
                      url: "updateInfo",
                      contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
                          if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
								setTimeout("location.href='index'", 1000);
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  /*
                  if("${use.rid}"==1){
                  		 $.ajax({
                      type: "GET",
                      url: "updatePropelling",
                      data:"protime="+$("#protime").val(),
                      success: function (data) {
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  }
                  */
		}
	</script>
</body>
</html>