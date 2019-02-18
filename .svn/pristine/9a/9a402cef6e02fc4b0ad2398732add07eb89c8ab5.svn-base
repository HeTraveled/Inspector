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
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
	<script src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
  <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
     <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
		<script src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
</head>
<body>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
						<div style="margin-bottom:20px;">
				<input class="easyui-textbox"  id="title" iconWidth="28" style="width:500px;height:34px;padding:10px"  data-options="label:'标题：',required:true,missingMessage:'*必填项'">
			</div>
					<div style="margin-bottom:20px;">
			<label><h2>内容：</h2></label>
			<script type="text/plain" id="body" style="width:100%;height:400px;">
 		   
				</script>
			</div>
				<div style="margin-bottom:20px;">
				<label>状态：</label>
				<input type="radio" name="state" value="1" checked="checked">发布&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<input type="radio" name="state" value="0">未发布
			</div>
			<div style="margin-bottom:20px;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
	$(function() {
	    //实例化编辑器
   	 UM.getEditor('body');
    });
		function submitForm(){
					if($("#title").val()==''||$("#title").val()==null)return false;
										if(!UM.getEditor('body').hasContents()){
					$.messager.alert('系统提示','内容不能为空！','warning');
					return false;
					}
					var body=(UM.getEditor('body').getContent());
					 var state="";
		    var  radios=document.getElementsByName("state");
	     	for(var i=0;i<radios.length;i++)if(radios[i].checked)state=radios[i].value;
	     	var data={
	     				"title":$("#title").val(),
                      	"body":body,
                      	"state":state
	     	}
						 $.ajax({
                      type: "POST",
                      url: "createHorn",
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