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
<body>
	<div style="margin:15px 0;"></div>
	<a style="display: none;" id="remind"></a>
	<h2>新建督查事项</h2>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		<div style="margin-bottom:20px;">
				<input class="easyui-textbox"  id="source" iconWidth="28" style="width:300px;height:34px;padding:10px"  data-options="label:'事项来源：',required:true,missingMessage:'*必填项'">
					&nbsp;&nbsp;&nbsp;
				<select class="easyui-combobox" style="width:150px;height:34px;padding:10px" id="type" editable="false">
					<option value="0" >请选择事项类型</option>
					<option value="1" >会议</option>
					<option value="3" >专项督查</option>
					<option value="4" >其他</option>
				</select>
			</div>
			<div style="margin-bottom:20px;">
						<select class="easyui-combobox"  label="责任单位：" onchange="" style="width:260px;height:34px;padding:10px" id="responsibility" editable="false">
						<option value="0" >请选择</option>
				<c:forEach items="${dept }" var="d">
					<option value="${d.id }">${d.departmentname }</option>
				</c:forEach>
				</select>
			</div>
						<div style="margin-bottom:20px;">
						<input class="easyui-textbox" id="assistDept" data-options="label:'协助单位：'" style="width:300px;height:50px;padding:10px">
			</div>
				<label style="color: red;font-weight: bold;">* 注：分管领导自动默认为部门分管领导</label>
				<br><br>
			<div style="margin-bottom:20px;">
			<label>协管领导：</label>
			<select class="easyui-combobox" style="width:150px;height:34px;padding:10px" editable="false" id="leadership">
					<option value="0" >选填项</option>
						<c:forEach items="${leadership }" var="l">
					<option value="${l.uid }">${l.name }</option>
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
				<input class="easyui-datebox"  id="startTime" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'开始时间：',required:true,missingMessage:'*必填项'"">
			</div>
				<div style="margin-bottom:20px;">
				<input class="easyui-datebox"  id="endTime" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'完成时限：',required:true,missingMessage:'*必填项'"">
			</div>
									<div style="margin-bottom:20px;">
				<label>反馈频率：</label>
				<input type="radio" name="frequency" value="1" id="day">日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="frequency" value="2" id="week">周&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="frequency" value="3" id="month">月
			</div>
				<div style="margin-bottom:20px;">
				<label>附件上传：</label>
			<div id="easyContainer"></div>
			</div>
			<div style="margin-bottom:20px;">
				<input class="easyui-textbox" id="remarks"  style="width:500px;height:160px" data-options="label:'备注：',multiline:true">
			</div>
			<div style="margin-bottom:20px;margin-left: 2%;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm(1)" style="width:100px">保存草稿</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm(2)" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
	var successFiles=[];
	function parsedate(){
    	var date = new Date();
	var year = date.getFullYear();
	var month = date.getMonth()+1; //月份+1   
	var day = date.getDate(); 
	var hour = date.getHours(); 
	var minutes = date.getMinutes(); 
	var second = date.getSeconds();
	return  year+"-"+month+"-"+day;
	}
	$(function() {
	    //实例化编辑器
    var body = UM.getEditor('body');
    var requirements = UM.getEditor('requirements');
    	$("#startTime").datebox().datebox('calendar').calendar({ validator:function(day){
    var timestamp = Date.parse(new Date());
    var lasttime = timestamp-86400000;
    var last = new Date(lasttime);
    return day > last;
}});
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
      console.log(res)
          var flies=[];
     for(i=0;i<res.success.length;i++){
     	flies.push(res.success[i].data);
     }
        successFiles=flies;
      }
    });
    /*
    				 $.ajax({
                      type: "GET",
                      url: "selectSupervisor",
                      success: function (data) {
                      	$('#responsibility').combobox({
					onSelect: function(record){
					if(record.value!=0){
					        if(data){
				           $.each(data, function(i) {
				           			if(record.value==i){
				           			var supervisor=$("#sup1").html();
				           				supervisor=data[i]+" ";
				           				$("#sup1").html(supervisor);
				           				return;
				           			}
				           	});
				           	}
					 }else{
					 	$("#sup1").html('');
					 }
						}
				});
				    	$('#assistDept').combotree({
					onCheck: function(node,checked){
					if(node.id!=0){
					        if(data){
				           $.each(data, function(i) {
				           			if(node.id==i){
				           				if(checked){
				           					$("#sup2").append('<x class="sup" id='+i+' value='+data[i]+'>'+data[i]+' </x>');
				           				}
				           				else{
				           				$("#"+i).remove();
				           				}
				           			}
				           	});
				           	}
					 }
						}
				});
				
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  */
		$('#assistDept').combotree({
				    url: 'assistDeptTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true
				});
				$('#startTime').datebox({
	onSelect: function(date){
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
					}else if(days<27){
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
			var startTime=$('#startTime').val();
		if(startTime!=''&&startTime!=null){
				startTime=new Date(startTime.replace(/\-/g, "\/"));
					if(date <startTime){
					$.messager.alert('系统提示','开始时间不能大于完成时限！','warning');
						return false;
					}
					var days=date.getTime()-startTime.getTime();
					days=parseInt(days / (1000 * 60 * 60 * 24));
							if(days<=7){
					$('#week').attr('disabled',true);
					$('#month').attr('disabled',true);
					  var radios=document.getElementsByName("frequency");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)radios[i].checked=false;
					}else if(days<27){
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
					  var websocket=new WebSocket("ws://"+url+"websocket");
						$("#remind").click(function(){
							  var text = '4';
					        if(text == null || text == "")return false;
					        var msg = {
					            msgContent: text,
					            postsId: 1
					        };
					        if (websocket.readyState==1) {
					        websocket.send(JSON.stringify(msg));
					        }
					        
					        });
					        	$("#startTime").datebox("setValue", parsedate()); 
					});
		function submitForm(flag){
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
		 if(leadership==0)leadership=null;
		 if($("#startTime").val()==''||$("#startTime").val()==null)return false;
		 if($("#endTime").val()==''||$("#endTime").val()==null)return false;
		if(new Date($("#startTime").val().replace(/\-/g, "\/")) >
					new Date($("#endTime").val().replace(/\-/g, "\/"))){
					$.messager.alert('系统提示','开始时间不能大于完成时限！','warning');
						return false;
					}
					if(!UM.getEditor('body').hasContents()){
					$.messager.alert('系统提示','督查事项内容不能为空！','warning');
					return false;
					}
					if(!UM.getEditor('requirements').hasContents()){
					$.messager.alert('系统提示','督查要求内容不能为空！','warning');
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
                      	"files":successFiles,
                      	"remarks":$("#remarks").val(),
                      	state:flag
	     	}
						 $.ajax({
                      type: "POST",
                      url: "createInspector",
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
								if(data.code==200){
								if(flag==2){
								messages(data.data);
								}
						}
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
                      data:"state=1&mid="+mid,
                      success: function (data) {
                      	setTimeout(parent.addTab('督查事项一览表','../inspector/data','fa fa-file-text-o'),3000);
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
                      data:"iid="+iid+"&flag=1",
                      success: function (data) {
						$("#remind").trigger("click");
						wxmes(data.data);
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
		}
	</script>
</html>