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
		<div class="mvctool">
				
	
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'wid',width: 50,hidden:true">ID</th>
					<th data-options="field:'uid',width: 50,hidden:true">UID</th>
					<th data-options="field:'createBy',width: 30"  >姓名</th>
					<th data-options="field:'message',width: 30" >信息</th>
					<th data-options="field:'createTime',width: 30" >提报时间</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<script type="text/javascript">
		$(function() {
			$('#List').datagrid({
				width : SetGridWidthSub(10),
				height : SetGridHeightSub(45),
				fitColumns : true,
				url : 'monthplanmessagelist',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				striped : false, //奇偶行是否区分
				singleSelect : true
			//单选模式xx	
			});
			$(window).resize(function() {
				$('#List').datagrid('resize', {

				}).datagrid('resize', {
					width : SetGridWidthSub(10),
					height : SetGridHeightSub(45)
				});
			});

		});

	</script>
		
</body>
</html>