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
		<c:if test="${principal==true }">
					<c:if test="${state==3 }">
					<div class="datagrid-btn-separator"></div>
				<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="up()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-pencil" style="font-size:14px"></span><span
					style="font-size:12px">修改</span>
			</span>
			</a>
			</c:if>
			<div class="datagrid-btn-separator"></div>
							<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="del()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-trash" style="font-size:14px"></span><span
					style="font-size:12px">删除</span>
			</span>
			</a>
			<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="update(1)"><span class="l-btn-left"><span
					class="l-btn-text fa fa-pencil" style="font-size:14px"></span><span
					style="font-size:12px">设置为&nbsp;&nbsp;&nbsp;重要且紧急的</span>
			</span>
			</a>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="update(2)"><span class="l-btn-left"><span
					style="font-size:12px">重要但不紧急的</span>
			</span>
			</a>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="update(3)"><span class="l-btn-left"><span
					style="font-size:12px">不重要但紧急的</span>
			</span>
			</a>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="update(4)"><span class="l-btn-left"><span
					style="font-size:12px">不重要也不紧急的</span>
			</span>
			</a>
		</c:if>
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
				<c:if test="${state==1 }">
					<th data-options="field:'iid',width: 20,hidden:true">编号ID</th>
					<th data-options="field:'body',width: 60" >工作内容</th>
					<th data-options="field:'endTime',width: 40" >办结期限</th>
					<th data-options="field:'state',width: 30,formatter:state1" >进展情况</th>
				</c:if>
					<c:if test="${state==2 }">
					<th data-options="field:'id',width: 20,hidden:true">编号ID</th>
					<th data-options="field:'body',width: 60" >工作内容</th>
					<th data-options="field:'startTime',width: 40" >开始日期</th>
					<th data-options="field:'endTime',width: 40" >办结期限</th>
					<th data-options="field:'state',width: 30,formatter:state2" >进展情况</th>
				</c:if>
							<c:if test="${state==3 }">
					<th data-options="field:'id',width: 20,hidden:true">编号ID</th>
					<th data-options="field:'body',width: 60" >工作内容</th>
					<th data-options="field:'endTime',width: 40" >办结期限</th>
					<th data-options="field:'liable',width: 40" >责任人</th>
					<th data-options="field:'state',width: 30,formatter:state3" >进展情况</th>
				</c:if>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<script type="text/javascript">
		$(function() {
		var flag="${flag}";
		var state="${state}";
		var depts="${depts}";
					var dg =$('#List').datagrid();
			dg.datagrid({
				width : SetGridWidthSub(10),
				height : SetGridHeightSub(45),
				fitColumns : true,
				url : 'boardsList',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				loadMsg:'数据加载中...',
				striped : false, //奇偶行是否区分
				singleSelect : true,
					queryParams:{
					flag:flag,
					state:state,
					depts:depts
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
		function update(flag){
		var f="${flag}";
		var state="${state}";
		var depts="${depts}";
		var row = $('#List').datagrid('getSelected');
		var id;
		if(state==1){
		if(row.iid==''||row.iid==null)return false;
			id=row.iid;
		}else if(state==2){
			if(row.id==''||row.id==null)return false;
			id=row.id;
		}
		else if(state==3){
			if(row.id==''||row.id==null)return false;
			id=row.id;
		}
		var str='';
			if(flag==1)str='重要且紧急的';
			else if(flag==2)str='重要但不紧急的';
			else if(flag==3)str='不重要但紧急的';
			else str='不重要也不紧急的';
					$.messager.confirm('系统提示', '确定要设置为'+str+'吗？', function(r) {
				if (r) {
							$.ajax({
						type : "GET",
						url : "update",
						data : "id="+id+"&flag="+flag+"&state="+state+"&depts="+depts,
						success : function(data) {
						        if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
								if(depts==null)setTimeout("location.href='boardsPage?state="+state+"&flag="+f+"'", 1000);
								else setTimeout("location.href='boardsPage?state="+state+"&flag="+f+"&depts="+depts+"'", 1000);
                          }
						},
						   error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
					});
				}
			});
		}
				   function state1(value, row, index){
				if(row.state==1){
				return "未启动";
				}else if(row.state==2){
					return "进行中";
				}else if(row.state==3){
					return "已取消";
				}else if(row.state==4){
					return "已过期";
				}else if(row.state==5){
					return "已完成";
				}
	        	}
		   function state2(value, row, index){
				if(row.state==0){
				return "未开始";
				}else if(row.state==1){
					return "进行中";
				}else if(row.state==2){
					return "未完成";
				}else if(row.state==3){
					return "已完成";
				}
	        	}
	        		   function state3(value, row, index){
				 if(row.state==1){
					return "进行中";
				}else if(row.state==2){
					return "未完成";
				}else if(row.state==3){
					return "已完成";
				}
	        	}
	        function del() {
	        var f="${flag}";
			var state="${state}";
			var depts="${depts}";
		var row = $('#List').datagrid('getSelected');
		var id;
		if(state==1){
		if(row.iid==''||row.iid==null)return false;
			id=row.iid;
		}else if(state==2){
			if(row.id==''||row.id==null)return false;
			id=row.id;
		}
		else if(state==3){
			if(row.id==''||row.id==null)return false;
			id=row.id;
		}
			$.messager.confirm('系统提示', '确定要删除吗？', function(r) {
				if (r) {
							$.ajax({
						type : "GET",
						url : "delete",
						data : "id="+id+"&state="+state+"&depts="+depts,
						success : function(data) {
						        if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
								if(depts==null)setTimeout("location.href='boardsPage?state="+state+"&flag="+f+"'", 1000);
								else setTimeout("location.href='boardsPage?state="+state+"&flag="+f+"&depts="+depts+"'", 1000);
                          }
						},
						   error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
					});
				}
			});
		}
		function up(){
			var row = $('#List').datagrid('getSelected');
			if(row.id==''||row.id==null)return false; 
			 $("#modalwindowContent").html("<iframe width='100%' height='100%' frameborder='0''  src='../board/updateBoardPage?id="+row.id+"'></iframe>");
         $("#modalwindowContent").window({ title: '修改工作', width: 600, height: 550, iconCls: 'fa fa-pencil' }).window('open');
		}
		            			function frameReturnByClose() {
        $("#modalwindowContent").window('close');
    }
     function frameReturnByMes(mes) {
        $.messageBox5s('系统提示', mes);
         var f="${flag}";
			var state="${state}";
			var depts="${depts}";
	if(depts==null)setTimeout("location.href='boardsPage?state="+state+"&flag="+f+"'", 1000);
	else setTimeout("location.href='boardsPage?state="+state+"&flag="+f+"&depts="+depts+"'", 1000);
    }
	</script>
	<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false"></div>
</body>
</html>