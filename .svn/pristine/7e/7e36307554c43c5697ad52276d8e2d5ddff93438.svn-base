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
	<link href='<%=basePath%>fullcalendar-3.9.0/fullcalendar.min.css' rel='stylesheet' />
<link href='<%=basePath%>fullcalendar-3.9.0/fullcalendar.print.min.css' rel='stylesheet' media='print' />
<script src='<%=basePath%>fullcalendar-3.9.0/lib/moment.min.js'></script>
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
		<script src='<%=basePath%>fullcalendar-3.9.0/fullcalendar.min.js'></script>
		<script src='<%=basePath%>fullcalendar-3.9.0/locale/zh-cn.js' charset="utf-8"></script>
			<script src="<%=basePath%>js/moment.js"></script>
			<style type="text/css">
		.icon-filter{
			background:url('<%=basePath%>images/filter.png') no-repeat left center;
		}
	</style>
<body>
<div style="padding:4px 5px 0px 5px;">
	<div style="float: left;">
	<select id="uid" class="easyui-combobox" style="width:150px;height:25px;padding:10px;" editable="false">
				<c:forEach items="${dept }" var="d">
					<option value="${d.uid }" <c:if test="${d.uid==u.uid}">selected</c:if>>${d.name }</option>
				</c:forEach>
				</select>
	</div>
			<a id="btnEdit" style="float: left;position: relative;left: 10px;height:25px;" class="easyui-linkbutton"	
				onclick="create()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-plus" style="font-size:14px; line-height: 2.4;height:26px;"></span>
			</span>
			</a>
	<div id='calendar'></div>
	</div>
	</div>
	<script type="text/javascript">
		$(function() {
						  $('#calendar').fullCalendar({
						      header: {
						      left: '',
						      right: 'month,agendaWeek,agendaDay,listMonth',
						      center:'title'
						      },
						      navLinks: true, 
						      businessHours: true,
						      editable: false,
						      height:600,
						 	 fixedWeekCount:false,
						 	 weekNumbers:true,
				dayClick: function(date, allDay, jsEvent, view) {
				if($('#uid').val()!="${u.uid}"){
				 $.messager.alert('系统提示','只能添加自己的日程！','warning');
				return false;
				}
				 date=moment(date).format("YYYY-MM-DD");
				$("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../schedule/createSchedulePage?date="+date+"'></iframe>");
      		   $("#modalwindowContent").window({ title: '新建个人日程', width: 600, height: 500, iconCls: 'fa fa-calendar-minus-o' }).window('open');
				},
				eventClick: function(event, jsEvent, view) {
								if($('#uid').val()!="${u.uid}"){
				 $.messager.alert('系统提示','只能修改自己的日程！','warning');
				return false;
				}
            $("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../schedule/updateSchedulePage?sid="+event.id+"'></iframe>");
      	   $("#modalwindowContent").window({ title: '修改个人日程', width: 600, height: 500, iconCls: 'fa fa-calendar-minus-o' }).window('open');
					}
						    });
				$('#uid').combobox({
					onSelect: function(record){
							 $.ajax({
                      type: "GET",
                      url: "scheduleData",
                      data:"uid="+record.value,
                      success: function (data) {
                     $('#calendar').fullCalendar('removeEvents');
					 $('#calendar').fullCalendar('renderEvents',data.data);
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
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
    		function create() {
		 $("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../schedule/createSchedulePage'></iframe>");
         $("#modalwindowContent").window({ title: '新建个人日程', width: 600, height: 500, iconCls: 'fa fa-calendar-minus-o' }).window('open');
		}
	</script>
	<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false"></div>
</body>
</html>