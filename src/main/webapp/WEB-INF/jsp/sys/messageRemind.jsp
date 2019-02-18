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
<a id="websocket"  style="display: none;"/>
<div style="padding:4px 5px 0px 5px;">
		<div class="mvctool">
							<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="empty()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-eraser" style="font-size:14px"></span><span
					style="font-size:12px">清空</span>
			</span>
			</a>
							<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="del()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-trash" style="font-size:14px"></span><span
					style="font-size:12px">删除</span>
			</span>
			</a>
			<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="batchflag()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-check-square-o" style="font-size:14px"></span><span
					style="font-size:12px">标记已读</span>
			</span>
			</a>
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'mrId',width: 20,sortable:true,styler: function(value,row,index){return {style:'left:1px;position: relative;'};}">系统编号ID</th>
					<th data-options="field:'type',width: 80,formatter:type,sortable:true,styler: function(value,row,index){return {style:'left:2px;position: relative;'};}" >消息来自</th>
					<th data-options="field:'title',width: 80,sortable:true,styler: function(value,row,index){return {style:'left:3px;position: relative;'};}" >标题</th>
					<th data-options="field:'createTime',width: 40,sortable:true,styler: function(value,row,index){return {style:'left:4px;position: relative;'};}" >推送时间</th>
					<th data-options="field:'state',width: 40,formatter:state,sortable:true,styler: function(value,row,index){return {style:'left:5px;position: relative;'};}" >当前</th>
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
				url : 'messageRemindList',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				loadMsg:'数据加载中...',
				striped : false, //奇偶行是否区分
				singleSelect : false,
				multiSort:true,
				sortName:'',
				sortOrder:'',
				remoteSort:true,
				remoteFilter:true
			});
						dg.datagrid({
			onDblClickRow: function(index, row){
					 $("#modalwindowContent").html
					 ("<iframe width='100%' height='100%' frameborder='0''  src='../messageRemind/messageRemindDetails?id="+row.mrId+"'></iframe>");
         $("#modalwindowContent").window({ title: row.title, width: 900, height: 880, iconCls: 'fa fa-envelope-o' }).window('open');
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
				      $('#modalwindowContent').window({
                onBeforeClose: function () { //当面板关闭之前触发的事件
                   location.href='data';
                }
            });
              var websocket;
					        websocket = new WebSocket("ws://"+url+"websocket");
						$("#websocket").click(function(){
							  var text = '4';
					        if(text == null || text == "")return false;
					        var msg = {
					            msgContent: text,
					            postsId: 1
					        };
					        if (websocket.readyState===1) {
					        websocket.send(JSON.stringify(msg));
					        }
					        });
		});
		function param(dg){
			dg.datagrid('enableFilter', [{
				field:'mrId',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'title',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'createTime',
				type:'datebox',
				options:{precision:1},
				op:['equal']
			},{
				field:'type',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'1',text:'督查事项'},{value:'2',text:'周计划'},{value:'5',text:'月计划'},{value:'4',text:'协同文件'},{value:'3',text:'其他'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'type');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'type',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					},{
				field:'state',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'1',text:'已读'},{value:'0',text:'未读'}],
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
					}]);
				var state="${state}";
					if(state!=''&&state!=null){
					dg.datagrid('addFilterRule', {
					field: 'state',
					op: 'equal',
					value: state
				});
					}
					}
				   function state(value, row, index){
			   if(row.state==1){
			   return "已读";
			   }else{
			   return "<font style='color:red;'>未读</font>";
	        	}
	        };
	         function type(value, row, index){
			   if(row.type==1){
			   return "督查事项";
			   }else if(row.type==2){
			   return "工作计划";
	        	}else if(row.type==3){
			   return "其他";
	        	}else if(row.type==4){
			   return "协同文件";
	        	}
	        };
	        function del() {
	        var rows = $('#List').datagrid('getSelections');
			if(rows.length==0)return false;
			$.messager.confirm('系统提示', '确定要删除吗？', function(r) {
				if (r) {
				var mrId=[];
					for(var i=0;i<rows.length;i++)mrId.push(rows[i].mrId);
							$.ajax({
						type : "POST",
						url : "delete",
					 contentType:"application/json",
                      data:JSON.stringify(mrId),
						success : function(data) {
						        if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
								$("#websocket").trigger("click");
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
			        function empty() {
			$.messager.confirm('系统提示', '确定要清空吗？', function(r) {
				if (r) {
				var uid="${uid}";
							$.ajax({
						type : "GET",
						url : "empty",
                      data:"uid="+uid,
						success : function(data) {
						        if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
								$("#websocket").trigger("click");
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
			        function batchflag() {
	        var rows = $('#List').datagrid('getSelections');
			if(rows.length==0)return false;
				var mrId=[];
					for(var i=0;i<rows.length;i++)mrId.push(rows[i].mrId);
							$.ajax({
						type : "POST",
						url : "batchflag",
					 contentType:"application/json",
                      data:JSON.stringify(mrId),
						success : function(data) {
						        if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
							$("#websocket").trigger("click");
								setTimeout("location.href='data'", 1000);
                          }
						},
						   error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
					});
		}
	</script>
		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
</html>