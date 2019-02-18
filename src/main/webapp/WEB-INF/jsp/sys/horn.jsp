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
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/datagrid-filter.js"></script>
	<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
	  	<script src="<%=basePath%>js/url.js"></script>
			<style type="text/css">
		.icon-filter{
			background:url('<%=basePath%>images/filter.png') no-repeat left center;
		}
	</style>
<body>
<div style="padding:4px 5px 0px 5px;">
		<div class="mvctool">
		<a style="display: none;" id="horn"></a>
		<c:if test="${role==1 }">
					<div class="datagrid-btn-separator"></div>
			<a id="btnCreate" style="float: left;" class="l-btn l-btn-plain"
				onclick="create()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-plus" style="font-size:14px"></span><span
					style="font-size:12px">发布</span>
			</span>
			</a>
					<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="update()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-pencil" style="font-size:14px"></span><span
					style="font-size:12px">修改</span>
			</span>
			</a>
			<div class="datagrid-btn-separator"></div>
			<a id="btnDelete" style="float: left;" class="l-btn l-btn-plain"
				onclick="dels()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-trash" style="font-size:14px"></span><span
					style="font-size:12px">删除</span>
			</span>
			</a>
			</c:if>
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'id',width: 20,hidden:true" >编号ID</th>
					<th data-options="field:'title',width: 40" >标题</th>	
					<th data-options="field:'createBy',width: 40" >发布人</th>
					<th data-options="field:'createTime',width: 30" >发布时间</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<script type="text/javascript">
		$(function() {
		var websocket;
        websocket = new WebSocket("ws://"+url+"websocket");
	   $("#horn").click(function(){
		  var text = '1';
        if(text == null || text == "")return false;
        var msg = {
            msgContent: text,
            postsId: 1
        };
        websocket.send(JSON.stringify(msg));
        });
        
					var dg =$('#List').datagrid();
			dg.datagrid({
				width : SetGridWidthSub(10),
				height : SetGridHeightSub(45),
				fitColumns : true,
				url : 'hornList',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				loadMsg:'数据加载中...',
				striped : false, //奇偶行是否区分
				singleSelect : false,
			});
			dg.datagrid({
			onDblClickRow: function(index,row){
					 $("#modalwindowContent").html
					 ("<iframe width='100%' height='100%' frameborder='0''  src='../horn/hornDetails?id="+row.id+"'></iframe>");
         $("#modalwindowContent").window({ title: row.title, width: 900, height: 880, iconCls: 'fa fa-bullhorn' }).window('open');
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
		$("#horn").trigger("click");
        $("#modalwindowContent").window('close');
    }
     function frameReturnByMes(mes) {
        $.messageBox5s('系统提示', mes);
        setTimeout("location.href='data'", 1000);
    }
		function update(){
		var row = $('#List').datagrid('getSelected');
		if(row.id==''||row.id==null)return false;
		$("#modalwindowContent").html("<iframe width='100%' height='100%' frameborder='0''  src='../horn/updateHornPage?id="
		+row.id+"'></iframe>");
        $("#modalwindowContent").window({ title: '修改——'+row.title, width: 800, height: 800, iconCls: 'fa fa-bullhorn' }).window('open');
		}
				function create() {
		 $("#modalwindowContent").html("<iframe width='100%' height='100%' frameborder='0''  src='../horn/createHornPage'></iframe>");
         $("#modalwindowContent").window({ title: '发布小喇叭', width: 800, height: 800, iconCls: 'fa fa-bullhorn' }).window('open');
		}
	        		function dels() {
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
								$("#horn").trigger("click");
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