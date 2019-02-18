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
			<div class="datagrid-btn-separator"></div>
			<a id="btnCreate" style="float: left;" class="l-btn l-btn-plain"
				onclick="create()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-user-plus" style="font-size:14px"></span><span
					style="font-size:12px">创建账号</span>
			</span>
			</a>
			<div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"	
				onclick="update()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-pencil" style="font-size:14px"></span><span
					style="font-size:12px">修改账号</span>
			</span>
			</a>
			<!--  
			<div class="datagrid-btn-separator"></div>
			<a id="btnDelete" style="float: left;" class="l-btn l-btn-plain"
				onclick="del()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-trash" style="font-size:14px"></span><span
					style="font-size:12px">删除账号</span>
			</span>
			</a>
			-->
						<div class="datagrid-btn-separator"></div>
			<a id="btnDelete" style="float: left;" class="l-btn l-btn-plain"
				onclick="operation()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-user-times" style="font-size:14px"></span><span
					style="font-size:12px">禁(启)用账号</span>
			</span>
			</a>
					<div class="datagrid-btn-separator"></div>
			<a id="btnDelete" style="float: left;" class="l-btn l-btn-plain"
				onclick="verify()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-clock-o" style="font-size:14px"></span><span
					style="font-size:12px">账号审核</span>
			</span>
			</a>
			<a id="btnDelete" style="float: right;" class="l-btn l-btn-plain"
				onclick="specialtwo()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-diamond" style="font-size:14px"></span><span
					style="font-size:12px">集团红头权限&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
			</span>
			</a>
						<a id="btnDelete" style="float: right;" class="l-btn l-btn-plain"
				onclick="specialone()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-diamond" style="font-size:14px"></span><span
					style="font-size:12px">办理文件权限</span>
			</span>
			</a>
		</div>
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'uid',width: 120,sortable:true,styler: function(value,row,index){return {style:'left:1px;position: relative;'};}" >系统ID</th>
					<th data-options="field:'employeeNo',width: 120,sortable:true,styler: function(value,row,index){return {style:'left:2px;position: relative;'};}" >员工编号</th>
					<th data-options="field:'phone',width: 140,sortable:true,styler: function(value,row,index){return {style:'left:3px;position: relative;'};}" >手机号</th>
				 <th data-options="field:'wechat',width: 140,formatter:wechat,align:'center',sortable:true,styler: function(value,row,index){return {style:'left:4px;position: relative;'};}" >微信绑定</th>
					<th data-options="field:'name',width: 200,sortable:true,styler: function(value,row,index){return {style:'left:5px;position: relative;'};}" >姓名</th>
					<th data-options="field:'sex',width: 100,sortable:true,formatter:sex,styler: function(value,row,index){return {style:'left:6px;position: relative;'};}" >性别</th>
					<th data-options="field:'birth',width: 160,sortable:true,align:'center',formatter:birth,styler: function(value,row,index){return {style:'left:7px;position: relative;'};}" >出生日期</th>
					<th data-options="field:'rname',width: 120,sortable:true,styler: function(value,row,index){return {style:'left:8px;position: relative;'};}" >权限</th>
					<th data-options="field:'departmentname',width: 200,sortable:true,styler: function(value,row,index){return {style:'left:9px;position: relative;'};}" >所属部门</th>
					<th data-options="field:'workState',width: 120,sortable:true,formatter:workState,styler: function(value,row,index){return {style:'left:10px;position: relative;'};}" >
					<span class="l-btn-text fa fa-child" style="font-size:14px"></span>工作状态</th>
					<!-- <th data-options="field:'score',width: 100,sortable:true,styler: function(value,row,index){return {style:'left:9px;position: relative;'};}" >现月考核分</th> -->
					<th data-options="field:'createTime',width: 160,sortable:true,styler: function(value,row,index){return {style:'left:11px;position: relative;'};}" >创建日期</th>
					<th data-options="field:'state',width:100,align:'center',formatter:state,sortable:true,styler: function(value,row,index){return {style:'left:12px;position: relative;'};}">账号状态</th>
					<th data-options="field:'special1',width:100,align:'center',formatter:special1,sortable:true,styler: function(value,row,index){return {style:'left:13px;position: relative;'};}">办理文件权限</th>
					<th data-options="field:'special2',width:100,align:'center',formatter:special2,sortable:true,styler: function(value,row,index){return {style:'left:14px;position: relative;'};}">集团红头权限</th>
				</tr>
			</thead>
		</table>
	</div>
	
	<script type="text/javascript">
		$(function() {
					var dg =$('#List').datagrid();
			dg.datagrid({
				width : SetGridWidthSub(10),
				height : SetGridHeightSub(45),
				url : 'userList',
				pageSize : 20,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				loadMsg:'数据加载中...',
				striped : true, //奇偶行是否区分
				singleSelect : false,
				multiSort:true,
				sortName:'',
				sortOrder:'',
				remoteSort:true,
				remoteFilter:true
			});
			param(dg);
			$(window).resize(function() {
				$('#List').datagrid('resize', {

				}).datagrid('resize', {
					width : SetGridWidthSub(10),
					height : SetGridHeightSub(45)
				});
			});

		});
			function param(dg){
			dg.datagrid('enableFilter', [{
				field:'uid',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'phone',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'name',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'employeeNo',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'rname',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'departmentname',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'createTime',
				type:'datebox',
				options:{precision:1},
				op:['equal']
			},{
				field:'birth',
				type:'datebox',
				options:{precision:1},
				op:['equal']
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
					data:[{value:'',text:'全部'},{value:'1',text:'启用'},{value:'0',text:'禁用'},{value:'2',text:'待审核'}],
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
				field:'sex',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'0',text:'男'},{value:'1',text:'女'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'sex');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'sex',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					},{
				field:'workState',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'1',text:'在岗中'},{value:'2',text:'请假中'},
					{value:'3',text:'出差中'},{value:'4',text:'会议中'},{value:'5',text:'外出中'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'workState');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'workState',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					}]);
		}
			function frameReturnByClose() {
        $("#modalwindowContent").window('close');
    }
     function frameReturnByMes(mes) {
        $.messageBox5s('系统提示', mes);
        setTimeout("location.href='data'", 1000);
    }
		function create() {
		 $("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../user/createUserPage'></iframe>");
         $("#modalwindowContent").window({ title: '创建账号', width: 600, height: 820, iconCls: 'fa fa-list' }).window('open');
		}
		function update(){
		 var rows = $('#List').datagrid('getSelections');
			if(rows.length>1){
			$.messager.alert('系统提示','多账号不能同时操作！','warning');
			return false;
			}
		var row = $('#List').datagrid('getSelected');
		if(row.uid==''||row.uid==null)return false;
		$("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../user/updateUserPage?uid="
		+row.uid+"'></iframe>");
        $("#modalwindowContent").window({ title: '修改账号——'+row.phone, width: 600, height: 800, iconCls: 'fa fa-list' }).window('open');
		}
				function verify() {
			 var rows = $('#List').datagrid('getSelections');
			if(rows.length==0)return false;
	//	var row = $('#List').datagrid('getSelected');
//		if(row.uid==''||row.uid==null)return false;
//		if(row.state!=2)return false;
var uid=[];
	for(var i=0;i<rows.length;i++){
		if(rows[i].state!=2)return false;
		else uid.push(rows[i].uid);
	}
	 $("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../user/verifyPage?uid="+uid+"'></iframe>");
      $("#modalwindowContent").window({ title: '账号审核', width: 280, height: 220, iconCls: 'fa fa-clock-o' }).window('open');
		}
					function del() {
							 var rows = $('#List').datagrid('getSelections');
			if(rows.length>1){
			$.messager.alert('系统提示','多账号不能同时操作！','warning');
			return false;
			}
			var row = $('#List').datagrid('getSelected');
			if(row.uid==''||row.uid==null)return false;
			$.messager.confirm('系统提示', '确定要删除该账号吗？', function(r) {
				if (r) {
							$.ajax({
						type : "GET",
						url : "delUser",
						data : "uid="+row.uid,
						success : function(data) {
						                    if(data.code==202){
					                     $.messager.alert('系统提示',data.message,'warning');
					                     return false;
					                     }
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
			function operation() {
					 var rows = $('#List').datagrid('getSelections');
			if(rows.length>1){
			$.messager.alert('系统提示','多账号不能同时操作！','warning');
			return false;
			}
			var row = $('#List').datagrid('getSelected');
			if(row.uid==''||row.uid==null)return false;
			if(row.state==2){
			$.messager.alert('系统提示','该账号当前状态为待审核，请先审核！','warning');
			return false;
			}
			var str='';
			if(row.state==0)str='启';
			else str='禁';
			$.messager.confirm('系统提示', '确定要'+str+'用该账号吗？', function(r) {
				if (r) {
							$.ajax({
						type : "GET",
						url : "closeUser",
						data : "uid="+row.uid+"&state="+row.state,
						success : function(data) {
						            if(data.code==202){
					                     $.messager.alert('系统提示',data.message,'warning');
					                     return false;
					                     }
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
		   function sex(value, row, index){
			   if(row.sex==0){
			   return "男";
			   }else{
			   return "女";
	        	}};
	        			   function birth(value, row, index){
			   if(row.birth!=null&&row.birth!=''){
			    return row.birth;
			   }else{
			   return "<font style='color:black;font-weight: bold;'>/</font>";
	        	}};
	        	function wechat(value, row, index){
	        		 if(row.wechat!=null&&row.wechat!=''){
			   return '<span class="l-btn-text fa fa-check" style="font-size:14px;color:#71C671;"></span>';
			   } else{
			   return '<span class="l-btn-text fa fa-close" style="font-size:14px;color:#ff0000;"></span>';
	        	}
	        	}
			   function state(value, row, index){
			   if(row.state==1){
			   return '<span class="l-btn-text fa fa-check" style="font-size:14px;color:#71C671;"></span>';
			   } else if(row.state==2){
			   	return '<span class="l-btn-text fa fa-clock-o" style="font-size:14px;color:#FF7256;"></span>';
			   }else{
			   return '<span class="l-btn-text fa fa-close" style="font-size:14px;color:#ff0000;"></span>';
	        	}};
	         function special1(value, row, index){
			   if(row.special1==1){
			  return '<span class="l-btn-text fa fa-check" style="font-size:14px;color:#71C671;"></span>';
			   }else{
			   return '<span class="l-btn-text fa fa-close" style="font-size:14px;color:#ff0000;"></span>';
	        	}};
	        	 function special2(value, row, index){
			   if(row.special2==1){
			  return '<span class="l-btn-text fa fa-check" style="font-size:14px;color:#71C671;"></span>';
			   }else{
			   return '<span class="l-btn-text fa fa-close" style="font-size:14px;color:#ff0000;"></span>';
	        	}};
	        	  function workState(value, row, index){
			   if(row.workState==1){
			   return "在岗中";
			   }else if(row.workState==2){
			   return "请假中";
	        	}else if(row.workState==3){
			   return "出差中";
	        	}
	        	else if(row.workState==4){
			   return "会议中";
	        	}
	        	else if(row.workState==5){
			   return "外出中";
	        	}};
	        function specialone() {
	        		 var rows = $('#List').datagrid('getSelections');
			if(rows.length>1){
			$.messager.alert('系统提示','多账号不能同时操作！','warning');
			return false;
			}
			var row = $('#List').datagrid('getSelected');
			var str='';
			if(row.special1==0||row.special1==null)str='启';
			else str='禁';
			$.messager.confirm('系统提示', '确定要'+str+'用该账号办理文件权限吗？', function(r) {
				if (r) {
							$.ajax({
						type : "GET",
						url : "updateSpecial1",
						data : "uid="+row.uid+"&special1="+row.special1,
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
					function specialtwo() {
							 var rows = $('#List').datagrid('getSelections');
			if(rows.length>1){
			$.messager.alert('系统提示','多账号不能同时操作！','warning');
			return false;
			}
			var row = $('#List').datagrid('getSelected');
			var str='';
			if(row.special2==0||row.special2==null)str='启';
			else str='禁';
			$.messager.confirm('系统提示', '确定要'+str+'用该账号集团红头权限吗？', function(r) {
				if (r) {
							$.ajax({
						type : "GET",
						url : "updateSpecial2",
						data : "uid="+row.uid+"&special2="+row.special2,
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
			data-options="modal:true,closed:true,minimizable:false,shadow:false"></div>
</body>
</html>