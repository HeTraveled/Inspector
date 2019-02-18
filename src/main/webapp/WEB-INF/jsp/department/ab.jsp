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
	<div style="padding:4px 5px 0px 5px;">
		<table id="List" style="height:auto;border:1px solid #ccc;">
			<thead>
				<tr>
					<th data-options="field:'uid',width: 50,hidden:true">系统ID</th>
					<th data-options="field:'employeeNo',width: 50" align="center">员工编号</th>
					<th data-options="field:'name',width: 50" align="center">姓名</th>
					<th data-options="field:'sex',width: 50" align="center" formatter="myFormatter">性别</th>
					<th data-options="field:'tel',width: 50" align="center" formatter="tel">办公电话</th>
					<th data-options="field:'phone',width: 50" align="center">手机号码</th>
					<th data-options="field:'address',width: 50" align="center" formatter="address">联系地址</th>
					<th data-options="field:'e_mail',width: 50" align="center" formatter="eMail">电子邮箱</th>
					
				</tr>
			</thead>
		</table>
	</div>
	<script type="text/javascript">
		
	</script>
	<script type="text/javascript">
	
		$(function() {
		var did="${did }";
			$('#List').datagrid({
		queryParams: {
			
			did: did
	}, 
				width : SetGridWidthSub(10),
				height : SetGridHeightSub(45),
				fitColumns : true,
				url : 'ABlistPage',
				pageSize : 10,
				pageList : [ 10, 20, 30, 40, 50 ],
				pagination : true,
				pagePosition:'top',
				striped : true, //奇偶行是否区分
				singleSelect : true
			//单选模式
			});
			$(window).resize(function() {
				$('#List').datagrid('resize', {

				}).datagrid('resize', {
					width : SetGridWidthSub(10),
					height : SetGridHeightSub(45)
				});
			});

		});

		function myFormatter(value, row, index){
		if(row.sex==0){
		return '男';
		}else{
		return '女';
		}
		}
					        	   function tel(value, row, index){
			   if(row.tel!=null&&row.tel!=''){
			    return row.tel;
			   }else{
			   return "<font style='color:black;font-weight: bold;'>/</font>";
	        	}};
	        				        	   function address(value, row, index){
			   if(row.address!=null&&row.address!=''){
			    return row.address;
			   }else{
			   return "<font style='color:black;font-weight: bold;'>/</font>";
	        	}};
	        				        	   function eMail(value, row, index){
			   if(row.e_mail!=null&&row.e_mail!=''){
			    return row.e_mail;
			   }else{
			   return "<font style='color:black;font-weight: bold;'>/</font>";
	        	}};
	</script>

</body>
</html>