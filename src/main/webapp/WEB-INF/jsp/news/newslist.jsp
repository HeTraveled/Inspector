<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
				
	<c:if test="${user==6||uid==18 }">
			<div class="datagrid-btn-separator"></div>
			<a id="btnCreate"  class="l-btn l-btn-plain"
				onclick="ShowInfo2('添加','newscreatskip')"><span class="l-btn-left"><span
					class="l-btn-text fa fa-plus" style="font-size:14px"></span><span
					style="font-size:12px">提报</span>
			</span>
			</a>
			<%-- </c:if> --%>
			<div class="datagrid-btn-separator"></div>
			<a id="btnCreate"  class="l-btn l-btn-plain"
				onclick="delect()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-trash" style="font-size:14px"></span><span
					style="font-size:12px">删除</span>
			</span>
			</a>
		</c:if>
		</div>
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'id',width: 50,hidden:true">ID</th>
					
					<th data-options="field:'title',width: 30" >标题</th>
					<th data-options="field:'body',width: 30,hidden:true" ></th>
					
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
				url : 'newslist',
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
     
       ShowInfo('详情',row.body);
		//return "<a onclick=\"ShowInfo('详情','department/dept?id="+row.id"')\">" +"</a>";
		}
		});
			
		});
	
		

		
		function ShowInfo(name, url) {
		window.open(url);  
			/* $("#modalwindowContent")
					.html(
							"<iframe width='100%' height='100%'  frameborder='0''  src='"
									+ url + "'></iframe>");
			$("#modalwindowContent").window({
				title : name,
				width : 1000,
				height :750,
				iconCls : 'fa fa-file-text-o'
			}).window('open');  */
		}
		function ShowInfo2(name, url) {
		
			$("#modalwindowContent")
					.html(
							"<iframe width='100%' height='100%'  frameborder='0''  src='"
									+ url + "'></iframe>");
			$("#modalwindowContent").window({
				title : name,
				width : 1000,
				height :750,
				iconCls : 'fa fa-file-text-o'
			}).window('open');  
		}
		function frameReturnByClose() {
			        $("#modalwindowContent").window('close');
			    }
			     function frameReturnByMes(mes) {
			        $.messageBox5s('系统提示', mes);
			       	setTimeout("location.href='newslistskip'", 500);
			    }
		
		function delect() {
		var row = $('#List').datagrid('getSelected');
		var id = row.id;
		if(id!=null){
		
			$.messager.confirm('删除新闻', '确定要删除吗?', function(r) {
				if (r) {
				$.ajax({
						type : "POST",
						url : "delectnews",
						data : {
							id : id
						},
						success : function(data) {

							  if (data.code =200) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
					         	setTimeout("location.href='newslistskip'", 500);
                          }
						},
						error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
					});

				}
			});
		}
		}
		
	</script>
		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
</html>