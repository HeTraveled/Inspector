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
	<script src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
			<style type="text/css">
		.icon-filter{
			background:url('<%=basePath%>images/filter.png') no-repeat left center;
		}
	</style>
<body>
<div style="padding:4px 5px 0px 5px;">
<!--
	<div style="float: left;">
	<select id="did" class="easyui-combobox" style="width:150px;height:25px;padding:10px;" id="type" editable="false">
				<c:forEach items="${dept }" var="d">
					<option value="${d.id }" <c:if test="${d.id==user.did}">selected</c:if>>${d.departmentname }</option>
				</c:forEach>
				</select>
	</div>
	  -->
						<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'principal',width: 20,hidden:true">编号ID</th>
					<th align="center" data-options="field:'departmentname',width: 60">部门名称</th>
					<th align="center" data-options="field:'principalname',width: 60">部门责任人</th>
					<th align="center" data-options="field:'score',width: 60">当前考核分</th>
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
				url : 'scoreList',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				loadMsg:'数据加载中...',
				striped : true, //奇偶行是否区分
				singleSelect : true
			});
			dg.datagrid({
			onDblClickRow: function(index,row){
					 $("#modalwindowContent").html
					 ("<iframe width='100%' height='100%' frameborder='0''  src='../score/scoreDetails?uid="+row.principal+"'></iframe>");
         $("#modalwindowContent").window({ title: row.principalname+"——"+row.departmentname, width: 900, height: 880, iconCls: 'fa fa-sort-numeric-asc' }).window('open');
				}
		});	
					$(window).resize(function() {
				$('#List').datagrid('resize', {

				}).datagrid('resize', {
					width : SetGridWidthSub(10),
					height : SetGridHeightSub(45)
				});
			});
							$('#did').combobox({
					onSelect: function(record){
							$('#List').datagrid("load",{
								did:record.value
							 });
                  }
                 });
                     $('#modalwindowContent').window({
                onBeforeClose: function () { //当面板关闭之前触发的事件
                   location.href='data';
                }
            });
		});
			function frameReturnByClose() {
        $("#modalwindowContent").window('close');
    }
     function frameReturnByMes(mes) {
        $.messageBox5s('系统提示', mes);
        setTimeout("location.href='data'", 1000);
    }
	</script>
		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
</html>