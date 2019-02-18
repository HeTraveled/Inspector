<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<%=basePath%>ueditor-mini1.2.2/themes/default/_css/umeditor.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
	 <link rel="stylesheet" href="<%=basePath%>jsAndcss/easyUpload/easy-upload.css">
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
	<script src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
  <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
     <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
		<script src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
						<script src="<%=basePath%>jsAndcss/easyUpload/vendor/jquery.cookie-1.4.1.min.js"></script>
				<script src="<%=basePath%>jsAndcss/easyUpload/easyUpload.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
</head>
<style>
a {font-size:16px} 
a:link {color: black; text-decoration:none;} 
a:active:{color: black; } 
a:visited {color:black;text-decoration:none;} 
a:hover {color: black; text-decoration:underline;} 
</style>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		<input type="hidden" id="id" value="${regulations.id }">
						<div style="margin-bottom:20px;">
				<input class="easyui-textbox"  id="title" iconWidth="28" value="${regulations.title }" style="width:500px;height:34px;padding:10px"  data-options="label:'标题：',required:true,missingMessage:'*必填项'">
			</div>
					<div style="margin-bottom:20px;">
					<label>类型：</label>
			<select class="easyui-combobox" style="width:150px;height:34px;padding:10px" id="type" editable="false">
					<option value="0" >请选择</option>
					<option value="1"  <c:if test="${regulations.type==1}">selected</c:if>>制度</option>
					<option value="2"  <c:if test="${regulations.type==2}">selected</c:if>>岗位职责</option>
					<option value="3"  <c:if test="${regulations.type==3}">selected</c:if>>表格</option>
					<option value="4"  <c:if test="${regulations.type==4}">selected</c:if>>其他</option>
				</select>
			</div>
				<div style="margin-bottom:20px;">
							<label>原附件：</label>
						<br>
							<c:forEach items="${files }" var="file">
					<a href="../home/download?filename=${file.attachment }">${file.attachment }</a>
					<a href="javascript:void(0)" onclick="delfile(${file.id})"><img src="<%=basePath%>images/del.png" width="15" height="15"></a>
					<br>
				</c:forEach>
				<br>
			<label>附件上传：</label>
			<br>
			<div id="easyContainer"></div>
			</div>
			<div style="margin-bottom:20px;">
				<input class="easyui-textbox" id="remarks" value="${regulations.remarks }" style="width:500px;height:160px" data-options="label:'备注：',multiline:true">
			</div>
				<div style="margin-bottom:20px;">
				<label>状态：</label>
				<input type="radio" name="state" value="1" ${regulations.state==1 ?'checked':'' }>发布&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="state" value="0" ${regulations.state==0 ?'checked':'' }>未发布
			</div>
			<div style="margin-bottom:20px;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
	var successFiles=[];
	$(function() {
		$('#easyContainer').easyUpload({
      allowFileTypes: '*',//允许上传文件类型，格式';*.doc;*.pdf'
      allowFileSize: 20480000,//允许上传文件大小(KB)
      selectText: '选择文件',//选择文件按钮文案
      multi: true,//是否允许多文件上传
      multiNum: 100,//多文件上传时允许的文件数
      showNote: true,//是否展示文件上传说明
      note: '全选',//文件上传说明
      showPreview: true,//是否显示文件预览
      url: '../home/uploadPic',//上传文件地址
      fileName: 'file',//文件filename配置参数
      timeout: 30000,//请求超时时间
      okCode: 200,//与后端返回数据code值一致时执行成功回调，不配置默认200
      successFunc: function(res) {
      var flies=[];
     for(i=0;i<res.success.length;i++){
     	flies.push(res.success[i].data);
     }
        successFiles=flies;
      },
      errorFunc: function(res) {
         $.messager.alert('系统提示','上传失败！','error');
      },
      deleteFunc: function(res) {
          var flies=[];
     for(i=0;i<res.success.length;i++){
     	flies.push(res.success[i].data);
     }
        successFiles=flies;
      }
    });
	});
	function delfile(id){
		 $.ajax({
                      type: "GET",
                      url: "../home/delfile",
                      data:"id="+id,
                      success: function (data) {
                          if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
								setTimeout("location.href='updateRegulationsPage?id="+$('#id').val()+"'",1000);
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
	}
		function submitForm(){
					if($("#title").val()==''||$("#title").val()==null)return false;
					if($("#type").val()==0)return false;
					 var state="";
		    var  radios=document.getElementsByName("state");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)state=radios[i].value;
	     	var data={
	 			    	"id":$("#id").val(),
	     				"title":$("#title").val(),
	     				"type":$("#type").val(),
                      	"remarks":$("#remarks").val(),
                      	"state":state,
                      	"files":successFiles
	     	}
						 $.ajax({
                      type: "POST",
                      url: "updateRegulations",
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