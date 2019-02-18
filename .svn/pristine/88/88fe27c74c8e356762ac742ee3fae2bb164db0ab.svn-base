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
			<style type="text/css">
		.icon-filter{
			background:url('<%=basePath%>images/filter.png') no-repeat left center;
		}
	</style>


	

	

<body>
<div style="padding:4px 5px 0px 5px;">
		
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'id',width: 10">ID</th>
					<th data-options="field:'type',width: 15" formatter="myFormatter">发布类型</th>
					<th data-options="field:'remove',width: 15" formatter="myFormatter2">展示状态</th>
						<th data-options="field:'accomplish',width: 15" formatter="myFormatter3">文件状态</th>
					<th data-options="field:'title',width:50">标题</th>
					<th data-options="field:'date',width: 25" >发布时间</th>
					<th data-options="field:'createBy',width: 20" >发布人</th>
				</tr>
			</thead>
		</table>
	</div>
	<script type="text/javascript">
		function myFormatter(value, row, index){
		
/* 		return "<a href='#'>"+value+"</a>"; */
		return "<a onclick=\"ShowInfo('详情','particulars?id="+row.id+"')\">" + row.title +"</a>";
		}
	</script>
	<script type="text/javascript">
		$(function() {
					var dg =$('#List').datagrid();
			dg.datagrid({
				width : SetGridWidthSub(10),
				height : SetGridHeightSub(45),
				fitColumns : true,
				url : 'accomplish',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				loadMsg:'数据加载中...',
				striped : false, //奇偶行是否区分
				singleSelect : true,
				multiSort:true,
				sortName:'',
				sortOrder:'',
				remoteSort:true,
				remoteFilter:true
			});
			dg.datagrid({
			onDblClickCell: function(index,field,value){
					var row = $(this).datagrid('getSelected');
					 $("#modalwindowContent").html
					 ("<iframe width='100%' height='100%' frameborder='0''  src='../Annc/AnncList?id="+row.id+"'></iframe>");
         $("#modalwindowContent").window({ title: row.source, width: 900, height: 880, iconCls: 'fa fa-file-text-o' }).window('open');
				},
				         //双击事件
         onDblClickRow: function (index, row) {
         
       ShowInfo('详情','../Annc/particulars?id='+row.id);
		//return "<a onclick=\"ShowInfo('详情','department/dept?id="+row.id"')\">" +"</a>";
		}
		});
					$(window).resize(function() {
				$('#List').datagrid('resize', {

				}).datagrid('resize', {
					width : SetGridWidthSub(10),
					height : SetGridHeightSub(45)
				});
			});
			param(dg);
		});
			

		
	</script>

	<script>
	
	
	

		
		function ShowInfo(name, url) {
			$("#modalwindowContent")
					.html(
							"<iframe width='100%' height='100%' scrolling='auto' frameborder='0''  src='"
									+ url + "'></iframe>");
			$("#modalwindowContent").window({
				title : name,
				width : 900,
				height :650,
				iconCls : 'fa fa-list'
			}).window('open');
		}
		  			function frameReturnByClose() {
			        $("#modalwindowContent").window('close');
			    }
			     function frameReturnByMes(mes) {
			        $.messageBox5s('系统提示', mes);
			         setTimeout("location.href='accomplishskip'", 1000);
			    }
			    function frameReturnByMes2(mes) {
			        $.messageBox5s('系统提示', mes);
			        setTimeout("location.href='accomplishskip'", 1000);
			    }
		
		
		
	  function myFormatter(value, row, index){
		if(row.type==1){
		return '协同文件';
		}
		if(row.type==2){
		return '金宏转办';
		}
		if(row.type==3){
		return '集团红头';
		}
		}
		
		  function myFormatter2(value, row, index){
		if(row.remove==0){
		return '进行中';
		}
		if(row.remove==1){
		return '已撤回';
		}
		}
		  function myFormatter3(value, row, index){
		if(row.accomplish==0){
		return '进行中';
		}
		if(row.accomplish==1){
		return '已完成';
		}
		}
	</script>
		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
</html>