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
	<div style="float: left;">
	<select id="year" class="easyui-combobox" style="width:150px;height:25px;padding:10px;" id="type" editable="false">
			<c:forEach items="${years }" var="y">
					<option value="${y }" <c:if test="${y==year}">selected</c:if>>${y }年</option>
				</c:forEach>
	</select>
		<select id="month" class="easyui-combobox" style="width:150px;height:25px;padding:10px;" id="type" editable="false">
		<c:forEach var="i" begin="1" end="12">
			<option value="${i }" <c:if test="${i==month}">selected</c:if>>${i }月</option>
		</c:forEach>
	</select>
	</div>
	<c:if test="${rid==1 }">
		<a id="btnCreate" style="float: left;" class="l-btn l-btn-plain"
				onclick="create()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-plus" style="font-size:14px"></span><span
					style="font-size:12px">添加</span>
			</span>
			</a>
			<a id="btnCreate" style="float: left;" class="l-btn l-btn-plain"
				onclick="update()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-cog" style="font-size:14px"></span><span
					style="font-size:12px">修改</span>
			</span>
			</a>
			</c:if>
			<!--
	<div style="float: right;">
	<font style="font-weight: bold;color: #333;font-size: 1.8em;">本月有效考核：${monthscore }分</font>
	</div>
	  -->
						<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
				<th data-options="field:'id',width: 60,sortable:true,styler: function(value,row,index){return {style:'left:1px;position: relative;'};}">编号ID</th>
					<th data-options="field:'source',width: 60,formatter:source,sortable:true,styler: function(value,row,index){return {style:'left:2px;position: relative;'};}">分数来源</th>
					<th data-options="field:'addSub',width: 60,formatter:addSub,sortable:true,styler: function(value,row,index){return {style:'left:3px;position: relative;'};}">加减分</th>
					<th data-options="field:'score',width: 60,formatter:score,sortable:true,styler: function(value,row,index){return {style:'left:4px;position: relative;'};}">详情</th>
					<th data-options="field:'state',width: 60,formatter:state,sortable:true,styler: function(value,row,index){return {style:'left:5px;position: relative;'};}">状态</th>
				</tr>
			</thead>
		</table>
	</div>
	</div>
	<script type="text/javascript">
		$(function() {
		var uid="${uid}";
		var year="${year}";
		var month="${month}";
					var dg =$('#List').datagrid();
			dg.datagrid({
				width : SetGridWidthSub(10),
				height : SetGridHeightSub(45),
				fitColumns : true,
				url : 'scoreUser',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				loadMsg:'数据加载中...',
				striped : true, //奇偶行是否区分
				singleSelect : true,
				multiSort:true,
				sortName:'',
				sortOrder:'',
				remoteSort:true,
				remoteFilter:true,
				queryParams:{
					uid:uid,
					year:year,
					month:month
				}
			});
			param(dg);
					$(window).resize(function() {
				$('#List').datagrid('resize', {

				}).datagrid('resize', {
					width : SetGridWidthSub(10),
					height : SetGridHeightSub(45)
				});
			});
							$('#year').combobox({
					onSelect: function(record){
							$('#List').datagrid("load",{
								year:record.value,
								month:$('#month').val(),
								uid:uid
							 });
                  }
                 });
                 	$('#month').combobox({
					onSelect: function(record){
							$('#List').datagrid("load",{
								year:$('#year').val(),
								month:record.value,
								uid:uid
							 });
                  }
                 });
		});
					function param(dg){
			dg.datagrid('enableFilter', [{
				field:'id',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'score',
				type:'numberbox',
				options:{precision:1},
				op:['equal','lessorequal','greaterorequal']
			},{
				field:'state',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'1',text:'有效'},{value:'0',text:'无效'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'state');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'state',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					},{
				field:'source',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'1',text:'未按时提报进展'},{value:'2',text:'事项超期'},{value:'3',text:'其他'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'source');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'source',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					},{
				field:'addSub',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'1',text:'加分'},{value:'0',text:'减分'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'addSub');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'addSub',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					}]);
		}
				function source(value, row, index){
			if(row.source==1)return "未按时提报进展";
			else if(row.source==2) return "事项超期";
			else if(row.source==3) return "其他";
		}
			function addSub(value, row, index){
			if(row.addSub==1)return "加分";
			else return "减分";
		}
				function score(value, row, index){
				if(row.addSub==1)return '<span style="font-size:14px;color:#ff0000;font-weight: bold;">+'+row.score+'</span>';
				else return '<span style="font-size:14px;color:#ff0000;font-weight: bold;">-'+row.score+'</span>';
		}
		function state(value, row, index){
			if(row.state==1)return "有效";
			else return "无效";
		}
					function frameReturnByClose() {
        $("#modalwindowContent").window('close');
    }
     function frameReturnByMes(mes) {
        $.messageBox5s('系统提示', mes);
        setTimeout("location.reload()", 1000);
    }
        		function create(){
        		var uid="${uid}";
		$("#modalwindowContent").html("<iframe width='100%' height='100%' frameborder='0''  src='../score/createScorePage?uid="
		+uid+"'></iframe>");
        $("#modalwindowContent").window({ title: '添加', width: 300, height: 280, iconCls: 'fa fa-sort-numeric-asc' }).window('open');
		}
    		function update(){
		var row = $('#List').datagrid('getSelected');
		if(row.id==''||row.id==null)return false;
		$("#modalwindowContent").html("<iframe width='100%' height='100%' frameborder='0''  src='../score/updateScorePage?id="
		+row.id+"'></iframe>");
        $("#modalwindowContent").window({ title: '修改——'+row.id, width: 300, height: 280, iconCls: 'fa fa-sort-numeric-asc' }).window('open');
		}
	</script>
			<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false"></div>
</body>
</html>