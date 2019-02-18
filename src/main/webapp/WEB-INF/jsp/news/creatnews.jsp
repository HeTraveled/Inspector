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
	<h2>新建新闻简讯</h2>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
		
			<div style="margin-bottom:20px;">
		
			<div style="width:60%;height:100%;padding-top:13px;padding-bottom:13px;">
						
				<div style="width:100%;padding-top:5px;padding-bottom:13px;">
				标题：<input class="easyui-textbox"  id="title" iconWidth="28" style="width:500px;height:40px;padding:10px"  >
				</div>
				<div style="width:100%;padding-top:5px;padding-bottom:13px;">
				链接：<input class="easyui-textbox"  id="body" iconWidth="28" style="width:500px;height:40px;padding:10px"  >
				</div>
						
				</div>
			<br>
			<div style="margin-bottom:20px;margin-left: 2%;">
			
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creat(1)" style="width:100px">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creat(2)" style="width:100px">取消</a>
			</div>
		</form>
		</div>
		
		<script type="text/javascript">
		
		
			function creat(number){
			if(number==1){
			
				if($("#title").val()==null||$("#title").val()==""){
					$.messager.alert('系统提示','标题不能为空！','warning');
					return false;
				}else{
					if($("#body").val()==""||$("#body").val()==""){
					 $.messager.alert('系统提示','链接不能为空！','warning');
					return false;
					}
					}
					
				var news={
					
					"title":$("#title").val(),
					"body":$("#body").val(),
					
					};
				
					$.ajax({
						  type:"POST",
						  url:"creatnews",
						  contentType:"application/json",
	                      data:JSON.stringify(news),
	                      success: function (data){
	                          if (data.code ==200) {
	                          		
	                          		  window.parent.frameReturnByClose(); 
	                          		  
									setTimeout("location.href='newslistskip'", 500);
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
		
			

			</script>
</body>
	
</html>