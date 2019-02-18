<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html>
<html>
<head>
	<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
	<link rel="stylesheet" href="<%=basePath%>ueditor-mini1.2.2/themes/default/_css/umeditor.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
	<script src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
  	<script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
	<script src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
	<script src="<%=basePath%>js/ajaxfileupload.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
</head>
<body>
	<div style="margin:15px 0;"></div>
	<h2>修改文件</h2>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		
		<div style="margin-bottom:20px;">
				<input type="hidden" id="id" value="${annc.id}">
				<input class="easyui-textbox" value="${annc.title}" id="title" iconWidth="28" style="width:300px;height:34px;padding:10px"  data-options="label:'公&nbsp;&nbsp;告&nbsp;标&nbsp;题&nbsp;：&nbsp;',required:true,missingMessage:'*必填项'">
					&nbsp;&nbsp;&nbsp;
					<div id="oldbody" style="display: none;">${annc.text }</div>
			</div>
				<div style="margin-bottom:20px;">
				<select class="easyui-combobox" label="通&nbsp;&nbsp;知&nbsp;公&nbsp;告&nbsp;：&nbsp;" style="width:250px;height:34px;padding:10px" id="type"  editable="false">
					<option value="0" >请选择</option>
					<c:if test="${user==1}">
					<option value="1"<c:if test="${annc.type==1}">selected</c:if> >通知</option>
					<option value="2" <c:if test="${annc.type==2}">selected</c:if>>公告</option>
					</c:if>
					<option value="3"<c:if test="${annc.type==3}">selected</c:if> >普通</option>
					<option value="4"<c:if test="${annc.type==4}">selected</c:if>>其他</option>
					<c:if test="${Special1==1 }">
					<option value="5" <c:if test="${annc.type==5}">selected</c:if>>金宏转办</option>
					</c:if>
					<c:if test="${Special2==1 }">
					<option value="6" <c:if test="${annc.type==6}">selected</c:if> >集团红头</option>
					</c:if>
					
				</select>
			</div>
			
				
			<div style="margin-bottom:20px;">
				<input class="easyui-datebox" value="${annc.startTime} " id="startTime" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'开&nbsp;&nbsp;始&nbsp;时&nbsp;间&nbsp;：&nbsp;',required:true,missingMessage:'*必填项'"">
			</div>
				<div style="margin-bottom:20px;">
				<input class="easyui-datebox" value="${annc.endTime} " id="endTime" editable="false" iconWidth="28" style="width:250px;height:34px;padding:10px"  data-options="label:'截&nbsp;&nbsp;止&nbsp;时&nbsp;间&nbsp;：&nbsp;',required:true,missingMessage:'*必填项'"">
			</div>
			
			<div style="margin-bottom:20px;">
				<input class="easyui-textbox"  id="assistDept" data-options="label:'被&nbsp;通知&nbsp;人员：'" style="width:300px;height:50px;padding:10px">
				</div>
				<div style="margin-bottom:20px;">
				<input class="easyui-textbox"  id="assistUser" data-options="label:'邀请参与人员：'" style="width:300px;height:50px;padding:10px">
				</div>	
				
			<div style="margin-bottom:20px;">
			<label><h2>公告正文：</h2></label>
			<script type="text/plain" id="body" style="width:100%;height:400px;">
 		   
			</script>
			</div>
					
			
			<div style="margin-bottom:20px;">
			<c:if test="${annc.file!=null&&annc.file!=''}">
			<label>原附件：</label><a href="${annc.file}" id="oldfile"></a>
			<script type="text/javascript">
				var file="${annc.file }";
				var index = file.lastIndexOf("\/");  
				file  = file .substring(index + 1, file .length);
				   $("#oldfile").text(file);
			</script>
			</c:if>
			</br>
				 <input type="hidden" value="<%=filePath%>" id="filePath"/>
				 <label>附件上传：</label>
				<input id="uploadFile" name="file"  type="file">
				<input id="file" type="hidden">
			</div>
			
			<div style="margin-bottom:20px;margin-left: 2%;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm(2)" style="width:100px">取消</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm(1)" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
	$(function() {
	    //实例化编辑器
    var body = UM.getEditor('body');
	 body.setContent($("#oldbody").html(),false);
		$('#assistDept').combotree({
				    url: 'assistUserTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true,
				    onLoadSuccess:function(node,data){
				    //回显时，默认选中的值
			    	var root  =  $("#assistDept").combotree('tree').tree('getRoot');
			    	var childrens = $("#assistDept").combotree('tree').tree('getChildren',root.target);
			    	childrens.push(root);
			    	var range="${annc.range}";
			    	range=range.split(",");
			    	var ass=[];
			    	for(var i=0;i<range.length;i++){
			    		ass.push(range[i]);
			    	}
			    	$('#assistDept').combotree('setValue',ass);
			         $("#assistDept").combotree('tree').tree("collapseAll"); 
			         }
				});
					$('#assistUser').combotree({
				    url: 'assistUserTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true,
				     onLoadSuccess:function(node,data){
				    //回显时，默认选中的值
			    	var root  =  $("#assistUser").combotree('tree').tree('getRoot');
			    	var childrens = $("#assistUser").combotree('tree').tree('getChildren',root.target);
			    	childrens.push(root);
			    	var invitation="${annc.invitation}";
			    	invitation=invitation.split(",");
			    	var ass2=[];
			    	for(var i=0;i<invitation.length;i++){
			    		ass2.push(invitation[i]);
			    	}
			    	$('#assistUser').combotree('setValue',ass2);
			         $("#assistUser").combotree('tree').tree("collapseAll"); 
			         }
				    
				});
				 
					});
		
				  
   
		function submitForm(flag){
		if(flag==1){
		var assistDept =$("#assistDept").val(); 
		var assistUser =$("#assistUser").val(); 
	
		if($("#title").val()==''||$("#title").val()==null)return false;
		 if($("#type").val()==0){
			$.messager.alert('系统提示','请选择公告类型！','warning');
		return false;
		}
		if(assistDept==null||assistDept==''){
		$.messager.alert('系统提示','请选择被通知人员！','warning');
		return false;
		}
		if($("#startTime").val()==''||$("#startTime").val()==null)return false;
	    if($("#endTime").val()==''||$("#endTime").val()==null)return false;
		if(new Date($("#startTime").val().replace(/\-/g, "\/")) >
					new Date($("#endTime").val().replace(/\-/g, "\/"))){
					$.messager.alert('系统提示','开始时间不能大于结束时间！','warning');
						return false;
					}
				var body=(UM.getEditor('body').getContent());
						
					var file=$("#file").val();
			if(file==null||file=='')file=null;
			var data={
						"id":$("#id").val(),
	     				"title":$("#title").val(),
	     				"type":$("#type").val(),
                      	"startTime":$("#startTime").val(),
                      	"endTime":$("#endTime").val(),
                      	"range":$("#assistDept").val(),
                      	"invitation":$("#assistUser").val(),
                      	"text":body,
                      	"file":file,
            };
					 $.ajax({
                      type: "POST",
                      url: "updateAnnc",
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
		}else{
		 window.parent.frameReturnByClose();
		}
		}
			     	$(document).on('change','#uploadFile',function(){
							ajaxFileUpload();
						});
			function ajaxFileUpload() {  
			var filePath=$('#filePath').val();
		    $.ajaxFileUpload({  
		        url:'uploadAnncFile', 
		        secureuri: false, 
		        fileElementId: 'uploadFile', 
		        dataType:'text',
		        enctype:'multipart/form-data',
		        success: function (data)  {
			            $("#file").val(filePath+data);
		        },
		        error: function (data, status, e){
		         $.messager.alert('系统提示','请求出错！','error');
		       	 }
		    });
		}
	
		
	</script>
</html>