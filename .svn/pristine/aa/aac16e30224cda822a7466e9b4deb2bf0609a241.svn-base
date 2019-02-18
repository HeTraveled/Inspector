<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
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
		<script src="<%=basePath%>js/url.js"></script>
					<script src="<%=basePath%>jsAndcss/easyUpload/vendor/jquery.cookie-1.4.1.min.js"></script>
				<script src="<%=basePath%>jsAndcss/easyUpload/easyUpload.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
</head>
<style>
a {font-size:16px} 
a:link {color: black; text-decoration:none;} 
a:active:{color: black; } 
a:visited {color:black;text-decoration:none;} 
a:hover {color: black; text-decoration:underline;} 
</style>
<body>
	<div style="margin:15px 0;"></div>
	<h2>修改督查事项</h2>
	<a style="display: none;" id="remind"></a>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		<input type="hidden" id="iid" value="${inspector.iid }">
		<div id="oldbody" style="display: none;">${inspector.body }</div>
		<div id="oldrequirements" style="display: none;">${inspector.requirements }</div>
		<div style="margin-bottom:20px;">
				<input class="easyui-textbox"  id="source" value="${inspector.source }" iconWidth="28" style="width:300px;height:34px;padding:10px"  data-options="label:'事项来源：',required:true,missingMessage:'*必填项'">
					&nbsp;&nbsp;&nbsp;
				<select class="easyui-combobox" style="width:150px;height:34px;padding:10px" id="type" editable="false">
					<option value="0" >请选择事项类型</option>
					<option value="1"  <c:if test="${inspector.type==1}">selected</c:if>>会议</option>
				<!--  	<option value="2"  <c:if test="${inspector.type==2}">selected</c:if>>金宏网</option>-->
					<option value="3"  <c:if test="${inspector.type==3}">selected</c:if>>专项督查</option>
					<option value="4" <c:if test="${inspector.type==4}">selected</c:if> >其他</option>
				</select>
			</div>
			<div style="margin-bottom:20px;">
						<select class="easyui-combobox"  label="责任单位：" onchange="" style="width:260px;height:34px;padding:10px" id="responsibility" editable="false">
						<option value="0" >请选择</option>
				<c:forEach items="${dept }" var="d">
					<option value="${d.id }" <c:if test="${d.id==inspector.responsibility}">selected</c:if>>${d.departmentname }</option>
				</c:forEach>
				</select>
			</div>
						<div style="margin-bottom:20px;">
						<input class="easyui-textbox" id="assistDept" data-options="label:'协助单位：'" style="width:300px;height:50px;padding:10px">
			</div>
			<label style="color: red;font-weight: bold;">* 注：分管领导自动默认为部门分管领导</label>
				<br><br>
			<!--  
			<div style="margin-bottom:20px;">
				<label>主管领导：</label>
					<x id="sup1"></x>
					<x id="sup2"></x>
			</div>
			-->
			<div style="margin-bottom:20px;">
			<label>协管领导：</label>
			<select class="easyui-combobox" style="width:150px;height:34px;padding:10px" editable="false" id="leadership">
					<option value="0" >选填项</option>
						<c:forEach items="${leadership }" var="l">
					<option value="${l.uid }" <c:if test="${l.uid==inspector.leadership}">selected</c:if>>${l.name }</option>
				</c:forEach>
				</select>
			</div>
						<div style="margin-bottom:20px;">
			<label><h2>任务描述：</h2></label>
			<script type="text/plain" id="requirements" style="width:100%;height:350px;">
 		   
				</script>
			</div>
						<div style="margin-bottom:20px;">
			<label><h2>督查要求：</h2></label>
			<script type="text/plain" id="body" style="width:100%;height:400px;">
 		  
				</script>
			</div>
						<div style="margin-bottom:20px;">
				<input class="easyui-datebox"  id="startTime" value="${startTime }" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'开始时间：',required:true,missingMessage:'*必填项'"">
			</div>
				<div style="margin-bottom:20px;">
				<input class="easyui-datebox"  id="endTime" value="${endTime }" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'完成时限：',required:true,missingMessage:'*必填项'"">
			</div>
									<div id="fankui" style="margin-bottom:20px;display: none;">
				<label>反馈频率：</label>
				<input type="radio" name="frequency" value="1" ${inspector.frequency==1 ?'checked':'' } id="day">日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="frequency" value="2" ${inspector.frequency==2 ?'checked':'' } id="week">周&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="frequency" value="3" ${inspector.frequency==3 ?'checked':'' } id="month">月
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
				<input class="easyui-textbox" id="remarks" value="${inspector.remarks }"  style="width:500px;height:160px" data-options="label:'备注：',multiline:true">
			</div>
			<div style="margin-bottom:20px;margin-left: 2%;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
	     var i=0;
	     var successFiles=[];
	$(function() {
	    //实例化编辑器
    var body = UM.getEditor('body');
	 body.setContent($("#oldbody").html(),false);
    var requirements = UM.getEditor('requirements');
     requirements.setContent($("#oldrequirements").html(),false);
     var flag=0;
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
}});
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
		$('#assistDept').combotree({
				    url: 'assistDeptTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true,
			 onLoadSuccess:function(node,data){
				   if(flag==0){
					 //回显时，默认选中的值
			    	var root  =  $("#assistDept").combotree('tree').tree('getRoot');
			    	var childrens = $("#assistDept").combotree('tree').tree('getChildren',root.target);
			    	childrens.push(root);
			    	var assistDept="${inspector.assistDept}";
			    	assistDept=assistDept.split(",");
			    	var ass=[];
			    	for(var i=0;i<assistDept.length;i++)ass.push(assistDept[i]);
			    	$('#assistDept').combotree('setValue',ass);
			    	}
			    	flag++;
   }
				});
				$('#responsibility').combobox({
					onSelect: function(record){
					if(record.value!=0){
						 $.ajax({
                      type: "GET",
                      url: "selectSupervisor",
                      data:"leadership="+record.value,
                      success: function (data) {
                          			$("#supervisor").html(data);
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  }
						}
				});
					$('#startTime').datebox({
	onSelect: function(date){
	$('#fankui').show();
		var endTime=$('#endTime').val();
		if(endTime!=''&&endTime!=null){
		endTime=new Date(endTime.replace(/\-/g, "\/"));
					if(date >endTime){
					$.messager.alert('系统提示','开始时间不能大于完成时限！','warning');
					return false;
					}
					var days=endTime.getTime()-date.getTime();
					days=parseInt(days / (1000 * 60 * 60 * 24));
					if(days<7){
					$('#week').attr('disabled',true);
					$('#month').attr('disabled',true);
			    var radios=document.getElementsByName("frequency");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)radios[i].checked=false;
					}else if(days<30){
					$('#week').attr('disabled',false);
						$('#month').attr('disabled',true);
						  var radios=document.getElementsByName("frequency");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)radios[i].checked=false;
					}else{
						$('#week').attr('disabled',false);
						$('#month').attr('disabled',false);
					}
		}
	}
});
			$('#endTime').datebox({
	onSelect: function(date){
					$('#fankui').show();
			var startTime=$('#startTime').val();
		if(startTime!=''&&startTime!=null){
				startTime=new Date(startTime.replace(/\-/g, "\/"));
					if(date <startTime){
					$.messager.alert('系统提示','开始时间不能大于完成时限！','warning');
						return false;
					}
					var days=date.getTime()-startTime.getTime();
					days=parseInt(days / (1000 * 60 * 60 * 24));
							if(days<7){
					$('#week').attr('disabled',true);
					$('#month').attr('disabled',true);
					  var radios=document.getElementsByName("frequency");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)radios[i].checked=false;
					}else if(days<30){
					$('#week').attr('disabled',false);
						$('#month').attr('disabled',true);
						  var radios=document.getElementsByName("frequency");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)radios[i].checked=false;
					}else{
						$('#week').attr('disabled',false);
						$('#month').attr('disabled',false);
					}
		}
	}
});
							  var websocket;
					        websocket = new WebSocket("ws://"+url+"websocket");
						$("#remind").click(function(){
							  var text = '4';
					        if(text == null || text == "")return false;
					        var msg = {
					            msgContent: text,
					            postsId: 1
					        };
					        if (websocket.readyState===1) {
					        websocket.send(JSON.stringify(msg));
					        }
					        });
					});
					
		function submitForm(){
		var responsibility=$("#responsibility").val();
		var assistDept=$("#assistDept").val();
		var leadership=$("#leadership").val();
		if($("#source").val()==''||$("#source").val()==null)return false;
		else if($("#type").val()==0){
			$.messager.alert('系统提示','请选择事项类型！','warning');
		return false;
		}
		else if($("#condition").val()==0){
		$.messager.alert('系统提示','请选择紧急程度！','warning');
		return false;
		}
		else if(responsibility==0){
		$.messager.alert('系统提示','请选择责任单位！','warning');
		return false;
		}
		else if(assistDept!=null){
			var ass=assistDept.split(',');
			for(i=0;i<ass.length;i++){
				if(responsibility==ass[i]){
			$.messager.alert('系统提示','责任单位与协助单位有重复项！','warning');
				return false;
				}
			}
		}
							if(!UM.getEditor('body').hasContents()){
					$.messager.alert('系统提示','督查事项内容不能为空！','warning');
					return false;
					}
					if(!UM.getEditor('requirements').hasContents()){
					$.messager.alert('系统提示','督查要求内容不能为空！','warning');
					return false;
					}
		 if($("#startTime").val()==''||$("#startTime").val()==null)return false;
		 if($("#endTime").val()==''||$("#endTime").val()==null)return false;
		if(new Date($("#startTime").val().replace(/\-/g, "\/")) >
					new Date($("#endTime").val().replace(/\-/g, "\/"))){
					$.messager.alert('系统提示','开始时间不能大于完成时限！','warning');
						return false;
					}
				var body=(UM.getEditor('body').getContent());
				var requirements=(UM.getEditor('requirements').getContent());
			 var frequency="";
		    var  radios=document.getElementsByName("frequency");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)frequency=radios[i].value;
	     		     	if(frequency==''||frequency==null){
	     	$.messager.alert('系统提示','至少选择一个反馈频率！','warning');
	     	return false;
	     	}
	     	var data={
	     				"iid":$("#iid").val(),
	     				"source":$("#source").val(),
	     				"type":$("#type").val(),
                      	"responsibility":responsibility,
                      	"assistDept":assistDept,
                      	"leadership":leadership,
                      	"interest":$("#interest").val(),
                      	"body":body,
                      	"requirements":requirements,
                      	"frequency":frequency,
                      	"startTime":$("#startTime").val(),
                      	"endTime":$("#endTime").val(),
                      	"remarks":$("#remarks").val(),
                      	"files":successFiles
	     	}
						 $.ajax({
                      type: "POST",
                      url: "updateInspector",
                      contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
                                if (data.code > 0) {
                                	if(data.code==200){
								messages($("#iid").val());
						}
                          			 window.parent.frameReturnByMes(data.message);
					                 window.parent.frameReturnByClose();
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
		}
				function wxmes(mid){
		if(mid!=null){
			 $.ajax({
                      type: "GET",
                      url: "http://gt.qdgxtz.com/inspectors-prod/WebSocketController/WebSocket/send",
                      data:"state=4&mid="+mid,
                      success: function (data) {
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  }
		}
				function messages(iid){
						 $.ajax({
                      type: "GET",
                      url: "InspectorMes",
                      data:"iid="+iid+"&flag=2",
                      success: function (data) {
						$("#remind").trigger("click");
						wxmes(data.data);
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
		}
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
								setTimeout("location.href='updateInspectorPage?iid="+$('#iid').val()+"'",1000);
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
	}
	</script>
</html>