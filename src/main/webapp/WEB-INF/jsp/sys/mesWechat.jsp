<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css"
	rel="stylesheet" />

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
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
<body>
<a id="websocket"  style="display: none;"/>
<div style="padding:4px 5px 0px 5px;">
		<div class="mvctool">
							<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="create()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-paper-plane-o" style="font-size:14px"></span><span
					style="font-size:12px">发送</span>
			</span>
			</a>
							<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="del()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-trash" style="font-size:14px"></span><span
					style="font-size:12px">删除</span>
			</span>
			</a>
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'id',width: 20,hidden:true">编号ID</th>
					<th data-options="field:'type',width: 80" >事件类型</th>
					<th data-options="field:'body',width: 80" >事件内容</th>
					<th data-options="field:'time',width: 40">推送时间</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<script type="text/javascript">
		$(function() {
					var dg =$('#List').datagrid();
			dg.datagrid({
				width : SetGridWidthSub(10),
				height : SetGridHeightSub(45),
				fitColumns : true,
				url : 'mesList',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				loadMsg:'数据加载中...',
				striped : true, //奇偶行是否区分
				singleSelect : false
			});
						dg.datagrid({
			onDblClickRow: function(index, row){
					 $("#modalwindowContent").html
					 ("<iframe width='100%' height='100%' frameborder='0''  src='../mesWechat/mesDetails?id="+row.id+"'></iframe>");
         $("#modalwindowContent").window({ title: row.type, width: 900, height: 880, iconCls: 'fa fa-envelope-open-o' }).window('open');
				}
		});
					$(window).resize(function() {
				$('#List').datagrid('resize', {

				}).datagrid('resize', {
					width : SetGridWidthSub(10),
					height : SetGridHeightSub(45)
				});
			});
		});
					function frameReturnByClose() {
        $("#modalwindowContent").window('close');
    }
     function frameReturnByMes(mes) {
        $.messageBox5s('系统提示', mes);
        setTimeout("location.href='data'", 1000);
    }
    				function create() {
		 $("#modalwindowContent").html("<iframe width='100%' height='100%' frameborder='0''  src='../mesWechat/createMesWechatPage'></iframe>");
         $("#modalwindowContent").window({ title: '新建消息推送', width: 600, height: 620, iconCls: 'fa fa-envelope-open-o' }).window('open');
		}
	        function del() {
	        var rows = $('#List').datagrid('getSelections');
			if(rows.length==0)return false;
			$.messager.confirm('系统提示', '确定要删除吗？', function(r) {
				if (r) {
				var id=[];
					for(var i=0;i<rows.length;i++)id.push(rows[i].id);
							$.ajax({
						type : "POST",
						url : "deletes",
					 contentType:"application/json",
                      data:JSON.stringify(id),
						success : function(data) {
						        if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
								setTimeout("location.href='data'", 1000);
                          }
						},
						   error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
					});
				}
			});
		}
	</script>
		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
</html>