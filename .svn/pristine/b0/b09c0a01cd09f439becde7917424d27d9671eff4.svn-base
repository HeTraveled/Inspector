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
<style>
table{font-size: 1.4em;}
</style>
<body>
 
	<div style="margin:15px 0;"></div>
	<h2>更新下周计划</h2>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		
			<div style="margin-bottom:20px;">
			<div id="optionValue"></div>
				<!-- <select class="easyui-combobox" label="日&nbsp;&nbsp;期&nbsp;选&nbsp;择&nbsp;：&nbsp;" style="width:340px;height:34px;padding:10px" id="type" editable="false">
					<option value="date" ></option>
					
				</select> -->
			</div>
				
			
			 <table id="tab">
			<tr ><td >
			<div >
			<div styele="padding-bottom:13px"
			<font style="font-weight: bold;size=40px">下周工作计划：</font></div>
				<c:forEach items="${lastweeknext}" var="lwn" varStatus="status">
				</br>
				${ status.index+1}.
				
				期限：<fmt:formatDate value="${lwn.start_time}"  pattern="yyyy-MM-dd"/>至
				
				<fmt:formatDate value="${lwn.end_time}"  pattern="yyyy-MM-dd"/>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<c:if test="${lwn.state==1}"> [ 进行中 ]</c:if>
				<c:if test="${lwn.state==2}"> [ 未完成 ]</c:if>
				<c:if test="${lwn.state==3}"> [ 已完成 ]</c:if>	
				<br> ${lwn.body}
					
				</c:forEach>
				</div>
				</td>
				</tr>
 		<input id="wid" value="${weeknext[0].wid}" type="hidden">
			</table>
			<div id="demoThisTears"style="padding-top:13px;padding-bottom:13px;">
					<div style="display:flex;">
						<h2 style="margin:10px 0;">添加工作计划：</h2>
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
							</div>
						</div>
					</div>
				</div>
				
			<div style="margin-bottom:20px;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creatweekplan(1)" style="width:100px;margin-left:15px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creatweekplan(2)" style="width:100px">取消</a>
			</div>
		</form>
		</div>
		
		<script type="text/javascript">
		
			var j=1;
		function delRow2(id) {
	             $("body").find(".thisYears"+id).remove();
	            j--;
	        }
	   
	$(document).ready(function(){
			var today = date.getDay();
		  var stepSunDay = -today + 1;
		  if (today == 0) {  
  		 stepSunDay = -7;  
    } 
    var stepMonday = 7 - today;  
  	var time = date.getTime();
  	var monday = new Date(time + stepSunDay * 24 * 3600 * 1000);  
    var sunday = new Date(time + stepMonday * 24 * 3600 * 1000); 
    monday.setDate(monday.getDate()+7);
    sunday.setDate(sunday.getDate()+7);
    var startTime=formatDate(monday);
     var endTime=formatDate(sunday);
      $("#endTime1").val(endTime);
		$("#startTime1").val(startTime);
		
		$("#endTime1").attr("max",formatDate(sunday)).attr("min",formatDate(monday));
		$("#startTime1").attr("max",formatDate(sunday)).attr("min",formatDate(monday));
				$("#add2").click(function(){
		j++;
	 var newRow = '<div  class="thisYears'+j+' demos" style="display:flex;width:100%">'
					+'<div style="width:100%">'
					+'<div style="width:100%;padding-top:5px;padding-bottom:13px;">'
					+'<input class="easyui-textbox"  id="nextbody'+j+'" iconWidth="28" style="width:500px;height:40px;padding:10px"  >'
					+'<a href="#" class="easyui-linkbutton"  style="margin-left:3px;width:45px;height:30px" onclick=delRow2('+j+')>删除</a>'
					+'</div>'
					+'<div style="display:flex;width:100%;padding-top:13px;padding-bottom:13px;">'
					+'<div style="padding-right:13px;"><input type="date" id="startTime'+j+'" min='+formatDate(monday)+' max='+formatDate(sunday)+' style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;" value="'+startTime+'"></div>'
					+'<div padding:13px;><input type="date" id="endTime'+j+'" min='+formatDate(monday)+' max='+formatDate(sunday)+' style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;" value="'+endTime+'"></div>'
					
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
		
			datevalue= year+"年第 " + week + " 周";
			document.getElementById("optionValue").innerHTML=datevalue;
		
			function creatweekplan(number){
			if(number==1){
					var numbers=$("body").find(".demos").length;
				for(k=1;k<=numbers;k++){
				
				if($("#nextbody"+k).val()==null||$("#nextbody"+k).val()==""){
					$.messager.alert('系统提示','内容不能为空！','warning');
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
				 var plan=[];
				
				for(l=1;l<=numbers;l++){
					
					var weeks={
					"wid":$("#wid").val(),
					"body":$("#nextbody"+l).val(),
					"startTime":$("#startTime"+l).val(),
					"endTime":$("#endTime"+l).val(),
					"state":1
					};
					plan.push(weeks);
				}
					$.ajax({
						  type:"POST",
						  url:"updateweekplannext",
						  contentType:"application/json",
	                      data:JSON.stringify(plan),
	                      success: function (data){
	                          if (data.code =200) {
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
			 
			alert($("#tab tr").size());
			
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