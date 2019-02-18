<%@ page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
<link rel="stylesheet"
	href="<%=basePath%>ueditor-mini1.2.2/themes/default/_css/umeditor.css"
	type="text/css"></link>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css"
	rel="stylesheet" />
<link href="<%=basePath%>css/tab.css" rel="stylesheet" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/content/Site.css">
<script type="text/javascript"
	src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/jquery.easyui.plus.js"></script>
<link
	href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css"
	rel="stylesheet" />
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
	<script src="<%=basePath%>js/url.js"></script>
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<a style="display: none;" id="remind"></a>
	<div style="margin:15px 0;"></div>
	<div class="easyui-panel" style="width:100%;max-width:100%;padding:30px 60px;">
		<form id="frm" method="post">
			<div style="margin-bottom:20px;">
				
				<script type="text/plain" id="description"
							style="width:100%;height:350px;">
				</script>
				<!--  <input class="easyui-textbox" id="description"  style="width:500px;height:160px" data-options="label:'进展内容描述：',multiline:true">-->
			</div>
			<div style="margin-bottom:20px;margin-left: 2%;">
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="submitForm()" style="width:100px">确认</a>
			</div>
		</form>
		</div>
</body>
	<script type="text/javascript">   
		$(function() {
		var description = UM.getEditor('description');
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
		});
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
                      url: "progressMes",
                      data:"iid="+iid+"&flag=1",
                      success: function (data) {
                      	wxmes(data.data);
						$("#remind").trigger("click");
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
		}
		function submitForm(){
		var iid="${iid}";
					if(!UM.getEditor('description').hasContents()){
					$.messager.alert('系统提示','内容不能为空！','warning');
					return false;
					}
	var description=(UM.getEditor('description').getContent());
		var data={
			"iid":iid,
			"description":description
		}
						 $.ajax({
                      type: "POST",
                      url: "createProgress",
                       contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
                              if (data.code > 0) {
                              if(data.code==200){
								messages(data.data);
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
	</script>
</html>