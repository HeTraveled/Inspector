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
				<input class="easyui-textbox"  id="type" iconWidth="28" style="width:350px;height:34px;padding:10px"  data-options="label:'标题：',required:true,missingMessage:'*必填项'">
			</div>
						<div style="margin-bottom:20px;">
				<input class="easyui-textbox" id="names" data-options="label:'收件人：'" style="width:200px;height:50px;padding:10px">
				</div>
					<div style="margin-bottom:20px;">
				<input class="easyui-textbox" id="body"  style="width:500px;height:160px" data-options="label:'内容：',multiline:true,validType:'length[1,80]'">
			</div>
						<div style="margin-bottom:20px;">
				<input class="easyui-textbox" id="reks"  style="width:500px;height:80px" data-options="label:'备注：',multiline:true,validType:'length[1,15]'">
			</div>
			<label style="color: red;font-weight: bold;">* 注：消息推送功能只能发送给已绑定微信且已关注集团公众号的用户。</label>
			<div style="margin-bottom:20px;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
	$(function() {
   	 		$('#names').combotree({
				    url: '../Annc/assistUserTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true,
				    onlyLeafCheck:true
				});
    });
		function submitForm(){
					if($("#names").val()==''||$("#names").val()==null)return false;
					if($("#type").val()==''||$("#type").val()==null)return false;
					if($("#body").val()==''||$("#body").val()==null)return false;
					if($("#body").val().length>80){
					$.messager.alert('系统提示','内容不能超过80字！','warning');
					return false;
					}
					if($("#reks").val().length>15){
					$.messager.alert('系统提示','备注不能超过15字！','warning');
					return false;
					}
	     	var data={
	     				"type":$("#type").val(),
                      	"body":$("#body").val(),
                      	"reks":$("#reks").val(),
                      	"names":$("#names").val()
	     	}
						 $.ajax({
                      type: "POST",
                      url: "createMesWechat",
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