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
input.text{text-align:center;padding:10px 20px;width:300px;}
table{font-size: 1.4em;}
</style>
<body>
 
	<div style="margin:15px 0;"></div>
	<h2>新建月计划</h2>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		
			<div style="margin-bottom:20px;">
			<div id="optionValue"></div>
				<!-- <select class="easyui-combobox" label="日&nbsp;&nbsp;期&nbsp;选&nbsp;择&nbsp;：&nbsp;" style="width:340px;height:34px;padding:10px" id="type" editable="false">
					<option value="date" ></option>
					
				</select> -->
			</div>
				
			
			 <table id="tab">
			
			 <div style="margin-bottom:20px;">
			
			</table>
			<div id="demoThisTears">
					<div style="display:flex">
						<h2 style="margin:10px 0;">下月工作计划：</h2>
					</div>
					<div  class="thisYears demos" style="display:flex;width:100%">
						<div style="width:100%">
							<div style="width:100%;padding-top:5px;padding-bottom:13px;">
							1&nbsp;.&nbsp;<input class="easyui-textbox"  id="body1" iconWidth="28" style="width:500px;height:40px;padding:10px"  >
							<a href="#" class="easyui-linkbutton" id="add2" style="margin-left:3px;width:45px;height:30px">添加</a>
							</div>
							<div style="display:flex;width:100%;padding-top:13px;padding-bottom:13px;">
								<div style="padding-right:13px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" id="startTime1" style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;"></div>
								<div ><input type="date" id="endTime1" style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;"></div>
							</div>
						</div>
					</div>
				</div>
				<div style="width:60%;height:100%;padding-top:13px;padding-bottom:13px;">
						<div style="width:60%;height:100%;padding-bottom:13px;">
						<font>备注：</font>
						</div>
						<div style="width:60%;height:100%;padding-top:13px;padding-bottom:13px;">
						<input class="easyui-textbox"  id="remarks" data-options="multiline:true" iconWidth="28" style="width:500px;height:80px;padding:10px">
						</div>
						<%-- <font size="4" style="font-weight: bold;">本月计划完成情况与自评：</font>
					    <c:if test="${thismonth!=null }">
					    <br>
						<c:forEach items="${thismonth}" var="lwn" varStatus="status">
						</br>
						<font size="4">${ status.index+1}.
						期限：<fmt:formatDate value="${lwn.startTime}"  pattern="yyyy-MM-dd"/>至
						
						<fmt:formatDate value="${lwn.endTime}"  pattern="yyyy-MM-dd"/>
						&nbsp;&nbsp;&nbsp;&nbsp;
						<c:if test="${lwn.state==1}"> [ 进行中 ]</c:if>
						<c:if test="${lwn.state==2}"> [ 未完成 ]</c:if>
						<c:if test="${lwn.state==3}"> [ 已完成 ]</c:if>
						 <br>${lwn.body}
						 <c:if test="${lwn.state==3}"><br>
						<c:if test="${lwn.remarks!=null}"><font>完成情况：${lwn.remarks }</font></c:if></c:if>
						</c:forEach>
						</c:if> 
						<c:if test="${thismonth==null }"><br><font size="4" style="font-weight: bold;">本月暂无工作</font></c:if>
						</font><br>
						<div style="width:60%;height:100%;padding-bottom:6px;padding-top:15px;">
						
	        			</div>
						<div style="width:60%;height:100%;padding-top:6px;padding-bottom:13px;">
						<font>自评分：</font><input class="easyui-textbox" type="number" id="myScore" iconWidth="28" style="width:60px;height:40px;padding:10px"  >
						</div> --%>
					</div>
			<br>
			<div style="margin-bottom:20px;margin-left: 2%;">
			
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creatmonthsplan(1)" style="width:100px">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creatmonthsplan(2)" style="width:100px">取消</a>
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
		var dayTime=new Date();
		
		var months=dayTime.getMonth()+2;
		var years=dayTime.getFullYear();
		 years=(months<=12?years:years+1);
		months=(months<=12?months:1);
	
		 	
		var lastDay = new Date(years, months,0);
		var  startTime=years+"-"+(months<10?"0"+months:months)+"-01";
		var  endTime=years+"-"+(months<10?"0"+months:months)+"-"+lastDay.getDate();
	
		
	    $("#endTime1").val(endTime);
		$("#startTime1").val(startTime);
		$("#endTime1").attr("max",endTime).attr("min",startTime);
		$("#startTime1").attr("max",endTime).attr("min",startTime);
				$("#add2").click(function(){
		j++;
	 var newRow = '<div  class="thisYears'+j+' demos" style="display:flex;width:100%">'
					+'<div style="width:100%">'
					+'<div style="width:100%;padding-top:5px;padding-bottom:13px;">'
					+j+'&nbsp;.&nbsp;<input class="easyui-textbox"  id="body'+j+'" iconWidth="28" style="width:500px;height:40px;padding:10px"  >'
					+'<a href="#" class="easyui-linkbutton"  style="margin-left:3px;width:45px;height:30px" onclick=delRow2('+j+')>删除</a>'
					+'</div>'
					+'<div style="display:flex;width:100%;padding-top:13px;padding-bottom:13px;">'
					+'<div style="padding-right:13px;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="date" id="startTime'+j+'" min='+formatDate(startTime)+' max='+formatDate(endTime)+' style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;" value="'+startTime+'"></div>'
					+'<div padding:13px;><input type="date" id="endTime'+j+'" min='+formatDate(startTime)+' max='+formatDate(endTime)+' style="width:130px;padding:10px;border-radius: 5px;border: 1px solid #d3d3d3;" value="'+endTime+'"></div>'
					
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
					var months=date.getMonth()+2;
					 year=(months<=12?year:year+1);
					months=(months<=12?months:1);
		
			datevalue= year+"年 " + months + " 月";
			document.getElementById("optionValue").innerHTML=datevalue;
		
			function creatmonthsplan(number){
			if(number==1){
				var numbers=$("body").find(".demos").length;
				for(k=1;k<=numbers;k++){
				
				if($("#body"+k).val()==null||$("#body"+k).val()==""){
					$.messager.alert('系统提示','内容不能为空！','warning');
					return false;
				}else{
					if($("#myScore").val()==""||$("#myScore").val()==""){
					/* $.messager.alert('系统提示','自评分不能为空！','warning');
					return false; */
					}else{
					if(Math.round($("#myScore").val()===$("#myScore").val())==false){
					/* $.messager.alert('系统提示','自评分为整数！','warning');
					return false; */
					}else{
					if($("#myScore").val()>100||$("#myScore").val()<0){
					/* $.messager.alert('系统提示','自评分数取值在0-100之间！','warning');
					return false; */
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
					}
					}
					}
					
				var monthPlan={
					
					"remarks":$("#remarks").val(),
				/* 	"myScore":$("#myScore").val(), */
					"years":year,
					"months":months,
					"monthPlanNext":[]
					};
				for(l=1;l<=numbers;l++){
				
					var monthPlanNexts={
					"body":$("#body"+l).val(),
					"startTime":$("#startTime"+l).val(),
					"endTime":$("#endTime"+l).val(),
					};
					
					monthPlan.monthPlanNext.push(monthPlanNexts);
				};
					$.ajax({
						  type:"POST",
						  url:"creatmonthsplan",
						  contentType:"application/json",
	                      data:JSON.stringify(monthPlan),
	                      success: function (data){
	                          if (data.code ==200) {
	                          		
	                          		  window.parent.frameReturnByClose(); 
	                          		  
									setTimeout("location.href='monthplanlist'", 500);
										 window.parent.frameReturnByMes(data.message);
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
			 var a =$("body").find(".demos").length;
			 
			alert(a);
			
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