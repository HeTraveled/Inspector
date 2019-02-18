<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    	<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=basePath%>ueditor-mini1.2.2/themes/default/_css/umeditor.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/content/Site.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
    <link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
    <script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/jquery.easyui.plus.js"></script>
    <link rel="stylesheet" href="<%=basePath%>ueditor/themes/default/css/umeditor.css" type="text/css"></link>
    <script type="text/javascript" src="<%=basePath%>ueditor/third-party/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.config.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
    <script src="<%=basePath%>js/ajaxfileupload.js"></script>
	<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<style>
td{border:solid #CCCCCC; border-width:0px 1px 1px 0px; padding:10px 20px;}
table{border:solid #CCCCCC; border-width:1px 0px 0px 1px;font-size: 1.2em;}
</style>
<body>

	<div style="padding:5px 5px 0px 20px;">
		<div class="mvctool">
		<table style="width: 100%;line-height: 200%;">
			<thead>
			
			<font style="font-weight:bold;width: 100%;">时间：</font>${thismonth.years}年${thismonth.months}月</td></tr>
				<tr id="tr1"><td colspan="2"><font style="font-weight: bold;size">${thismonth.months}月计划详情：</font>
				<c:forEach items="${nextmonth}" var="lm" varStatus="status">
				</br>
				${ status.index+1}.
				
				期限：<fmt:formatDate value="${lm.startTime}"  pattern="yyyy-MM-dd"/>至
				<fmt:formatDate value="${lm.endTime}"  pattern="yyyy-MM-dd"/>
			
			
				<c:if test="${lm.state==1}">[ 进行中 ]</c:if>
				<c:if test="${lm.state==2}">[ 未完成 ]</c:if>
				<c:if test="${lm.state==3}">[ 已完成 ]</c:if>
				<%-- ${u.startTime}${u.endTime} --%> <br>${lm.body}
				</c:forEach>
				</td>
				</tr>
				
				
				<%-- <tr ><td colspan="2"><font ">评分：</font>
			
				<input class="easyui-textbox"  id="myScore" iconWidth="28" style="width:60px;height:40px;padding:10px" value="${thismonth.myScore}">
				
				
				</td> --%>
				</tr>
				
				
				</tr>
				
			
				<br>	
			<tr><td>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="updatemessage(1)" style="width:100px;float: right">审核</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="updatemessage(2)" style="width:100px;float: right">取消</a>
			
			
			</td>	
				</tr>
			</thead>
		</table>
		
		
						
	</div>
	<script type="text/javascript">
	$(function() {
	    //实例化编辑器
    var body = UM.getEditor('body');
    var requirements = UM.getEditor('requirements');
		$('#assistDept').combotree({
				    url: 'assistUserTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true,
				});
					$('#assistUser').combotree({
				    url: 'assistUserTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true	
				});
					});
	
	
	
	
	
		
		function ShowInfo(name, url) {
			$("#modalwindowContent")
					.html(
							"<iframe width='100%' height='100%' scrolling='auto' frameborder='0''  src='"
									+ url + "'></iframe>");
			$("#modalwindowContent").window({
				title : name,
				width : 960,
				height :650,
				iconCls : 'fa fa-list'
			}).window('open');
		}
		
		function updatemessage(number){
		if(number==1){	
		if($("#myScore").val()==""||$("#myScore").val()==""){
				/* 	$.messager.alert('系统提示','自评分不能为空！','warning');
					return false; */
					}
					if(Math.round($("#myScore").val()===$("#myScore").val())==false){
					$.messager.alert('系统提示','自评分为整数！','warning');
					return false;
					}
					if($("#myScore").val()>100||$("#myScore").val()<0){
					$.messager.alert('系统提示','自评分数取值在0-100之间！','warning');
					return false;
					}
		 var mid="${thismonth.mid}";
		
     	 $.ajax({
						type :"POST",
						url:"updatemyScore",
						data:{
							 mid:"${thismonth.mid}",
	     				/* 	 myScore:$("#myScore").val(), */
						},
						success:function(data){
							  if (data.code==200) {
                          			 window.parent.frameReturnByMes(data.message);
					                 window.parent.frameReturnByClose();
                          };
							},
						error:function(request){
                          $.messager.alert('系统提示','请求出错！','error');
                          }
						});
		}else{
		  window.parent.frameReturnByClose();
		}
		}
		function delect(id){
		 var id=id;
		
     	 $.ajax({
						type :"POST",
						url:"updatemyScore",
						data:{
							id:id
						},
					
						success:function(data){
							  if (data.code==200) {
                          			 window.parent.frameReturnByMes(data.message);
					                 window.parent.frameReturnByClose();
                          };

						},
						error:function(request){
                          $.messager.alert('系统提示','请求出错！','error');
                          }
						});
		};
	</script>
	<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
</html>