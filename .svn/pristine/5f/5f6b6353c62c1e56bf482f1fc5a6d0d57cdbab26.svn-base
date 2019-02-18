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
<c:if test="${monthplan==1 }">
		<div class="mvctool">
		<div class="datagrid-btn-separator"></div>
			<a id="btnCreate" style="float: left;" class="l-btn l-btn-plain"
				onclick="ShowInfo('添加','../month/creatmonthplan')"><span class="l-btn-left"><span
					class="l-btn-text fa fa-plus" style="font-size:14px"></span><span
					style="font-size:12px">提交新计划</span>
			</span>
			</a>
			</c:if>
			<c:if test="${auditrole!=null }">
			
			<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"
				onclick="ShowInfo('审核','../month/monthplanaudit')"><span class="l-btn-left"><span
					class="l-btn-text fa fa-pencil" style="font-size:14px"></span><span
					style="font-size:12px">审核</span>
			</span>
			</a>
			<div class="datagrid-btn-separator"></div>
		</c:if>
		<c:if test="${monthPlan2!=null}">
	
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"
				onclick="d_exportall()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-bar-chart" style="font-size:14px"></span><span
					style="font-size:12px">导出月计划</span>
			</span>
			</a>
			</c:if></div>
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'id',width: 50,hidden:true">编号ID</th>
					<th data-options="field:'departmentname',width: 50"formatter="myFormatter">部门名称</th>
					<th data-options="field:'principalname',width: 15" >部门负责人</th>
					<th data-options="field:'leadershipname',width: 15 " >分管领导</th>
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
				url : 'DeptlistPage',
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

	<script>
	
	$(function(){ 
	
		 $("#List").datagrid({
         //双击事件
         onDblClickRow: function (index, row) {
      /*  console.log(row) */
    
       ShowInfo('详情','../month/deptmonthplanPage?did='+row.id);
		//return "<a onclick=\"ShowInfo('详情','department/dept?id="+row.id"')\">" +"</a>";
		}
		});
		});
	
		

		
		function ShowInfo(name, url) {
			$("#modalwindowContent")
					.html(
							"<iframe width='100%' height='100%' scrolling='auto' frameborder='0''  src='"
									+ url + "'></iframe>");
			$("#modalwindowContent").window({
				title : name,
				width : 1000,
				height :750,
				iconCls : 'fa fa-list'
			}).window('open');
		}
		  			function frameReturnByClose() {
			        $("#modalwindowContent").window('close');
			    }
			     function frameReturnByMes(mes) {
			        $.messageBox5s('系统提示', mes);
			        setTimeout("location.href='monthplanlist'", 1000);
			    }
			    function frameReturnByMes2(mes) {
			        $.messageBox5s('系统提示', mes);
			        setTimeout("location.href='skip'", 1000);
			    }
		
			function update(){
		var row = $('#List').datagrid('getSelected');
		if(row.id==''||row.id==null)return false;
		$("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../Annc/updateAnncPage?id="
		+row.id+"'></iframe>");
        $("#modalwindowContent").window({ title: '修改通知/公告信息——'+row.title,width: 900, height: 1080, iconCls: 'fa fa-file-text-o' }).window('open');
		}
		
	  function myFormatter(value, row, index){
		var principalname='双击查看'+'"'+row.departmentname+'"'+'工作计划';
		return principalname;
		
		}
		function d_exportall(){
				$.messager.confirm('系统提示', '确定要导出本月个人计划吗吗？', function(r) {
				if (r) {
				window.open("../month/downExcel");
				}
			});
		}
		
	</script>
		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
</html>