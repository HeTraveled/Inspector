<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String filePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/";
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="<%=basePath%>jsAndcss/easyUpload/easy-upload.css">
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
	<script
	src="<%=basePath%>jsAndcss/easyUpload/vendor/jquery.cookie-1.4.1.min.js"></script>
<script src="<%=basePath%>jsAndcss/easyUpload/easyUpload.js"></script>
<script src="<%=basePath%>js/url.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
</head>
<style>
table{font-size: 1.4em;}
</style>
<body>
 
	<div style="margin:15px 0;"></div>
	<h2>新建年计划</h2>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		
			<div style="margin-bottom:20px;">
			<div id="optionValue" style="width:200px;"></div>
				<!-- <select class="easyui-combobox" label="日&nbsp;&nbsp;期&nbsp;选&nbsp;择&nbsp;：&nbsp;" style="width:340px;height:34px;padding:10px" id="type" editable="false">
					<option value="date" ></option>
				</select> -->
			</div>
			<div >
				<div id="demoThisTears">
					<div style="display:flex">
						<h2 style="margin:10px 0;">今年工作计划：</h2>
					</div>
					<div  class="thisYears demos" style="display:flex;width:100%">
						<div style="width:100%">
							<div style="width:100%;padding-top:5px;padding-bottom:13px;">
							<input class="easyui-textbox"  id="nextbody1" iconWidth="28" style="width:500px;height:40px;padding:10px"  >
							<a href="#" class="easyui-linkbutton" id="add2" style="margin-left:3px;width:45px;height:30px">添加</a>
							</div>
							<div style="display:flex;width:100%;padding-top:13px;padding-bottom:13px;">
								<div style="padding-right:13px;"><input type="date" id="startTime1" style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;"></div>
								<div ><input type="date" id="endTime1" style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;"></div>
								<div style="padding-left:13px;">
								<font>部门：</font><select style="width:130px;height:100%;border-radius:5px;border:1px solid #d3d3d3"; id="did1"  editable="false">
							<c:forEach items="${dept}" var="d">
								<option value="${d.id }">${d.departmentname }</option>
							</c:forEach>
								</select></div>
							</div>
						</div>
						
					</div>
					
				</div>
				
					<div style="width:60%;height:100%;padding-top:13px;padding-bottom:13px;">
						<div style="width:60%;height:100%;padding-bottom:13px;">
						<font>备注：</font>
						</div>
						<div style="width:60%;height:100%;padding-top:13px;padding-bottom:13px;">
						<input class="easyui-textbox"  id="remarks" iconWidth="28" data-options="multiline:true" style="width:500px;height:80px;padding:10px">
						</div>
					</div>
			<div style="margin-bottom:20px;">
				<label>附件上传：</label>
				<div id="easyContainer"></div>
			 <!-- <table id="tab">
 			<tr>
			 <td>
			  <font>今年工作计划：</font>
			 <div style="margin-bottom:20px;">
			<input class="easyui-textbox"  id="nextbody1" iconWidth="28" style="width:600px;height:40px;padding:10px"  >
			</div>
			</td>
			<div style="display:flex;width:100%">
			<td>
			<input type="date" id="startTime1" style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;">
			</td>
			<td>
			<input type="date" id="endTime1" style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;">
			</td>
			</div>
		 </tr>
			<td><a href="#" class="easyui-linkbutton" id="add2">添加</a></td>
			 <tbody id="tbody2">
			 </tbody>
			
			 <tr>
			 <td>
			 <div style="margin-bottom:20px;">
			 <p>&nbsp;备&nbsp;&nbsp;&nbsp;注&nbsp;&nbsp;：</p>
				<input class="easyui-textbox"  id="remarks" iconWidth="28" style="width:400px;height:40px;padding:10px"  >
			</div>
			</td>
			</tr>
			</table> -->
			<div style="margin-bottom:20px;padding-top:13px;padding-bottom:13px;">
			
			
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creatweekplan(1)" style="width:100px;margin-left:5px;">提交</a>
			&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creatweekplan(2)" style="width:100px;margin-left:5px;">取消</a>
			</div>
		</form>
		</div>
		
		<script type="text/javascript">
		var j=1;
		var successFiles = [];
		$(function(){
			 $('#uid'+j).combobox({ 
				required:true, 
				multiple:false, 
				editable:false ,
				}); 
				
				$('#easyContainer').easyUpload({
			allowFileTypes : '*',//允许上传文件类型，格式';*.doc;*.pdf'
			allowFileSize : 20480000,//允许上传文件大小(KB)
			selectText : '选择文件',//选择文件按钮文案
			multi : true,//是否允许多文件上传
			multiNum : 100,//多文件上传时允许的文件数
			showNote : true,//是否展示文件上传说明
			note : '全选',//文件上传说明
			showPreview : true,//是否显示文件预览
			url : '../home/uploadPic',//上传文件地址
			fileName : 'file',//文件filename配置参数
			timeout : 30000,//请求超时时间
			okCode : 200,//与后端返回数据code值一致时执行成功回调，不配置默认200
			successFunc : function(res) {
				var flies = [];
				for (i = 0; i < res.success.length; i++) {
					flies.push(res.success[i].data);
				}
				successFiles = flies;
			},
			errorFunc : function(res) {
				$.messager.alert('系统提示', '上传失败！', 'error');
			},
			deleteFunc : function(res) {
				console.log(res)
				var flies = [];
				for (i = 0; i < res.success.length; i++) {
					flies.push(res.success[i].data);
				}
				successFiles = flies;
			}
		});
			});
		function delRow2(id) {
	           $("body").find(".thisYears"+id).remove();
	            j--;
	        }
	   
	$(document).ready(function(){
		var numbers=$("body").find(".demos").length;
		var dayTime=new Date();
		var years=dayTime.getFullYear();
		
		
		 startTime=(years)+"-01"+"-01";
		 endTime=(years)+"-12"+"-31";
		 $("#endTime1").val(endTime);
		$("#startTime1").val(startTime);
		
		$("#endTime1").attr("max",endTime).attr("min",startTime);
		$("#startTime1").attr("max",endTime).attr("min",startTime);
		
					$("#add2").click(function(){
		j++;
	 	var newRow = '<div  class="thisYears'+j+' demos" style="display:flex;width:100%">'
					+'<div style="width:100%">'
					+'<div style="width:100%;padding-top:5px;padding-bottom:13px;">'
					+'<input class="easyui-textbox"  id="nextbody'+j+'" iconWidth="28" style="width:500px;height:40px;padding:10px"  >'
					+'<a href="#" class="easyui-linkbutton"  style="margin-left:3px;width:45px;height:30px" onclick=delRow2('+j+')>删除</a>'
					+'</div>'
					+'<div style="display:flex;width:100%;padding-top:13px;padding-bottom:13px;">'
					+'<div style="padding-right:13px;"><input type="date" id="startTime'+j+'" min='+formatDate(startTime)+' max='+formatDate(endTime)+' style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;" value="'+startTime+'"></div>'
					+'<div padding:13px;><input type="date" id="endTime'+j+'" min='+formatDate(startTime)+' max='+formatDate(endTime)+' style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;" value="'+endTime+'"></div>'
					+'<div style="padding-left:13px;">'
					+'<font>部门：</font><select style="width:130px;height:100%;border-radius:5px;border:1px solid #d3d3d3"; id="did'+j+'" editable="false">'
					+'<c:forEach items="${dept}" var="d">'
					+'<option value="${d.id }">${d.departmentname }</option>'
					+'</c:forEach>'
					+'</select></div>'
					+'</div>'
					+'</div>'
					+'</div>';
			$("#demoThisTears").append(newRow);
			$.parser.parse();
		});
		});
		
					//当前周数
				   var time,week,checkDate = new Date(new Date());
                   checkDate.setDate(checkDate.getDate() + 4 - (checkDate.getDay() || 7));
                   time = checkDate.getTime();
                   checkDate.setMonth(0);
                   checkDate.setDate(1);
                   week=Math.floor(Math.round((time - checkDate) / 86400000) / 7) + 1;
 				   //年
 				    var date=new Date;
 				   var year=date.getFullYear();
					var month=date.getMonth()+1;
		
			datevalue= year+"年";
			document.getElementById("optionValue").innerHTML=datevalue;
		
			function creatweekplan(number){
			if(number==1){
			var numbers=$("body").find(".demos").length;
				for(k=1;k<=numbers;k++){
				
				if($("#nextbody"+k).val()==null||$("#nextbody"+k).val()==""){
					$.messager.alert('系统提示','计划内容不能为空！','warning');
					return false;
					
				}else{
					if($("#startTime"+k).val()==""||$("#endTime"+k).val()==""){
					$.messager.alert('系统提示','请选择时间！','warning');
					return false;
					}else{
					if(new Date($("#startTime"+k).val().replace(/\-/g, "\/")) > new Date($("#endTime"+k).val().replace(/\-/g, "\/"))){
						$.messager.alert('系统提示','开始时间不能大于结束时间！','warning');
						return false;
					}
					}
					}
					}
				var date=new Date;
				 var year=date.getFullYear();
				var yearplan={
					"remarks":$("#remarks").val(),
					"year":year,
					"yearPlanNext":[],
					"files" : successFiles
					};
				for(l=1;l<=numbers;l++){

					var yearnext={
					"body":$("#nextbody"+l).val(),
					"startTime":$("#startTime"+l).val(),
					"endTime":$("#endTime"+l).val(),
					"state":$("#did"+l).val()
					};
					yearplan.yearPlanNext.push(yearnext);
				}
					$.ajax({
						  type:"POST",
						  url:"creatyearplan",
						  contentType:"application/json",
	                      data:JSON.stringify(yearplan),
	                      success: function (data){
	                          if (data.code ==200) {
	                          		 window.parent.frameReturnByMes(data.message);
					                 window.parent.frameReturnByClose(); 
						                  };
						   },	
	                      error: function (request) {
	                          $.messager.alert('系统提示','请求出错！','error');
	                      }
					}); 
			
			}else{
			  window.parent.frameReturnByClose(); 
			}
			
			}
			function aaaweekplan(){
			var numbers=$("body").find(".demos").length;
			alert(numbers);
			
			}
					function formatDate(date) {
  var d = new Date(date),
    month = '' + (d.getMonth() + 1),
    day = '' + d.getDate(),
    year = d.getFullYear();
 
  if (month.length < 2) month = '0' + month;
  if (day.length < 2) day = '0' + day;
 
  return [year, month, day].join('-');
}
			</script>
</body>
	
</html>