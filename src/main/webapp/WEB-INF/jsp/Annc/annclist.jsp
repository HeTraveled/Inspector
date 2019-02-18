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
				onclick="ShowInfo('添加','skip2')"><span class="l-btn-left"><span
					class="l-btn-text fa fa-plus" style="font-size:14px"></span><span
					style="font-size:12px">发布</span>

			</span>
			</a>
			<!-- <div class="datagrid-btn-separator"></div>
			<a id="btnEdit" style="float: left;" class="l-btn l-btn-plain"
				onclick="update()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-pencil" style="font-size:14px"></span><span
					style="font-size:12px">修改公告</span>
			</span>
			</a> -->
			<div class="datagrid-btn-separator"></div>
			<a id="btnDelete" style="float: left;" class="l-btn l-btn-plain"
				onclick="confirm1();"><span class="l-btn-left"><span
					class="l-btn-text fa fa-trash" style="font-size:14px"></span><span
					style="font-size:12px">撤回文件</span>
			</span>
			</a>
			
			<input value="${user}" id="user" type="hidden"> 
			<div class="datagrid-btn-separator"></div>
		</div>
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'id',width: 10">ID</th>
					<th data-options="field:'type',width: 15" formatter="myFormatter">发布类型</th>
					<th data-options="field:'remove',width: 15" formatter="myFormatter2">展示状态</th>
					<!-- <th data-options="field:'astate',width: 15" formatter="myFormatter1">展示状态</th> -->
						<th data-options="field:'accomplish',width: 15" formatter="myFormatter3">文件状态</th>
					<th data-options="field:'title',width:50">标题</th>
					<th data-options="field:'date',width: 25" >发布时间</th>
					<th data-options="field:'createBy',width: 20" >发布人</th>
					<th data-options="field:'sendtype',width: 20" >文件类型</th>
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
				url : 'AnncList',
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
			function param(dg){
			dg.datagrid('enableFilter', [	
			{
				field:'type',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'1',text:'协同文件'},{value:'2',text:'办理文件'},{value:'3',text:'集团红头'}
					],
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
				field:'remove',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'0',text:'公示中'},{value:'1',text:'已撤回'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'remove');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'remove',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					},{
				field:'accomplish',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'0',text:'进行中'},{value:'1',text:'已完成'},{value:'2',text:'仅阅件'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'accomplish');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'accomplish',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					},{
				field:'sendtype',
				type:'combobox',
				options:{
					panelHeight:'auto',
					data:[{value:'',text:'全部'},{value:'0',text:'已发布'},{value:'1',text:'已接收'}],
					onChange:function(value){
						if (value == ''){
							dg.datagrid('removeFilterRule', 'sendtype');
						} else {
							dg.datagrid('addFilterRule', {
								field: 'sendtype',
								op: 'equal',
								value: value
							});
						}
						dg.datagrid('doFilter');
					}
					}
					},{
				field:'title',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'createBy',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'date',
				type:'datebox',
				options:{precision:1},
				op:['equal']
			},{
				field:'id',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'remove',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'accomplish',
				type:'text',
				options:{precision:1},
				op:['contains']
			},{
				field:'sendtype',
				type:'text',
				options:{precision:1},
				op:['contains']
			}
					
					]);
		}

		
	</script>

	<script>
	
	
		function confirm1() {
		var row = $('#List').datagrid('getSelected');
		var id = row.id;
		
		var remove=row.remove;
		if(remove==1){
		return
		}
		var createBy=row.createBy;
		var user=$("#user").val();
		if(user!=createBy)return;
		if(id!=null){
			$.messager.prompt('系统提示', '请提交撤回理由', function(r) {
				if (r) {
					/* var row = $('#datagrid').datagrid('getData').rows[index];
						  alert('confirmed: '+row.id); */
					/*   alert(r); */
					var invitation=r;
					
				
					
					/* alert($('#dataGrid').datagrid('getRows')[rowIndex].Product); */
					$.ajax({
						type : "POST",
						url : "Anncdelect",
						data : {
							id : id,invitation:r
						},
						success : function(data) {

						 if (data.code ==200) {
                          $.messageBox5s('系统提示', data.message);
			        	setTimeout("location.href='skip'", 1000);
					        /* window.parent.frameReturnByClose(); */
                          }else{
                            $.messageBox5s('系统提示', data.message);
                          }
						},
						error:function(request){
                          $.messager.alert('系统提示','请求出错！','error');
                          }
					});
				}
			});
		}
		}

		
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
			         setTimeout("location.href='skip'", 1000);
			    }
			    function frameReturnByMes2(mes) {
			        $.messageBox5s('系统提示', mes);
			        setTimeout("location.href='skip'", 1000);
			    }
		
			function update(){
		var row = $('#List').datagrid('getSelected');
		if(row.id==''||row.id==null)return false;
		$("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='auto' frameborder='0''  src='../Annc/updateAnncPage?id="
		+row.id+"'></iframe>");
        $("#modalwindowContent").window({ title: '修改通知/公告信息——'+row.title,width: 900, height: 1080, iconCls: 'fa fa-file-text-o' }).window('open');
		}
		
	  function myFormatter(value, row, index){
		if(row.type==1){
		return '协同文件';
		}
		if(row.type==2){
		return '办理文件';
		}
		if(row.type==3){
		return '集团红头';
		}
		}
		
		  function myFormatter2(value, row, index){
		if(row.remove==0){
		return '公示中';
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
		if(row.accomplish==2){
		return '仅阅件';
		}
		}
		 function myFormatter1(value, row, index){
		 var aid="${aid}";
		if(row.astate==0&&aid==row.uid){
		return '已阅';
		}else if(row.astate==0&&aid!=row.uid){
		return '未阅';
		}
		if(row.astate==1){
		return '已阅';
		}
		}
	</script>
		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
</html>