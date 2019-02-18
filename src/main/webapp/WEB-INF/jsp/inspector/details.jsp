<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
<link rel="stylesheet"
	href="<%=basePath%>ueditor-mini1.2.2/themes/default/_css/umeditor.css"
	type="text/css"></link>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
<link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css"
	rel="stylesheet" />
<link href="<%=basePath%>css/tab.css" rel="stylesheet" />
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
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
<script type="text/javascript"
	src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
	<script src="<%=basePath%>js/url.js"></script>
<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<style>	
table {
	border: solid #CCCCCC;
	border-width: 1px 0px 0px 1px;
	font-size: 1.4em;
}
table th{
	width:33.33%; 	
}
		.icon-filter{
			background:url('<%=basePath%>images/filter.png') no-repeat left center;
		}
		a {font-size:16px} 
a:link {color: black; text-decoration:none;} 
a:active:{color: black; } 
a:visited {color:black;text-decoration:none;} 
a:hover {color: black; text-decoration:underline;} 
</style>
<body>
	<a style="display: none;" id="remind"></a>
	<div style="padding:5px 5px 0px 20px;">
		<div class="mvctool">
			<table style="width: 100%;line-height: 200%;" id="table-4">
				<thead>
					<tr>
						<td><font style="font-weight: bold;">事项来源：</font>${ins.source
							}</td>
						<td style="width: 50%;"><font style="font-weight: bold;">事项类型：</font>
							<c:if test="${ins.type==1}">会议</c:if> <c:if test="${ins.type==2}">金宏网</c:if>
							<c:if test="${ins.type==3}">专项督查</c:if> <c:if
								test="${ins.type==4}">其他</c:if></td>
					</tr>
					<tr>
						<td><font style="font-weight: bold;">责任单位：</font>
						<c:if test="${ins.state==5||ins.state==3 }">${resname}</c:if>
						<c:if test="${ins.state!=5&&ins.state!=3 }">${ins.responsibilityname}(${responsibilityPrincipal })</c:if>
						</td>
						<td><font style="font-weight: bold;">协助单位：</font>
						<c:if test="${ins.state==5||ins.state==3 }">${assname}</c:if>
						<c:if test="${ins.state!=5&&ins.state!=3 }"><c:if
								test="${assistdept==''||assistdept==null }">无</c:if> <c:if
								test="${assistdept!=''&&assistdept!=null }">${assistdept }</c:if>
								</c:if>
						</td>
					</tr>
					<tr>
						<td><font style="font-weight: bold;">分管领导：</font>
						<c:if test="${ins.state==5||ins.state==3 }">${chaname}</c:if>
						<c:if test="${ins.state!=5&&ins.state!=3 }"><c:if
								test="${leadership!=null}">${leadership}</c:if>
								</c:if>
						</td>
						<td><font style="font-weight: bold;">协办领导：</font> 
						<c:if test="${ins.state==5||ins.state==3 }">${leaname}</c:if>
						<c:if test="${ins.state!=5&&ins.state!=3 }">
						<c:if
								test="${ins.leadershipname==null}">无</c:if> <c:if
								test="${ins.leadershipname!=null}">${ins.leadershipname}</c:if>
								</c:if>
						</td>
					</tr>
					<tr>
						<td><font style="font-weight: bold;">开始时间：</font> <fmt:formatDate
								value="${ins.startTime }" pattern="yyyy-MM-dd" />
						</td>
						<td><font style="font-weight: bold;">完成时限：</font> <fmt:formatDate
								value="${ins.endTime }" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<td colspan="2"><font style="font-weight: bold;">督查要求：</font>${ins.body }</td>
					</tr>
						<tr>
						<td colspan="2"><font style="font-weight: bold;">任务描述：</font>${ins.requirements
							}</td>
					</tr>
					<tr>
						<td><font style="font-weight: bold;">反馈频率：</font> <c:if
								test="${ins.frequency==1}">日</c:if> <c:if
								test="${ins.frequency==2}">周</c:if> <c:if
								test="${ins.frequency==3}">月</c:if></td>
								<td><font style="font-weight: bold;">完成时间：</font>
							<c:if test="${ins.completeTime==null }">未完成</c:if> <c:if
								test="${ins.completeTime!=null }">
								<fmt:formatDate value="${ins.completeTime }"
									pattern="yyyy-MM-dd" />
							</c:if></td>
					</tr>
					<tr>
						<td><font style="font-weight: bold;">状态：</font> <c:if
								test="${ins.state==1}">未启动</c:if> <c:if test="${ins.state==2}">进行中</c:if>
							<c:if test="${ins.state==3}">已取消</c:if> <c:if
								test="${ins.state==4}">已超期</c:if> <c:if test="${ins.state==5}">已完成</c:if>
						</td>
					<td><font style="font-weight: bold;">备注：</font>${ins.remarks}</td>
					</tr>
						<tr>
						<td colspan="2"><font style="font-weight: bold;">附件：</font>
						<c:if test="${fn:length(files) == 0 }">暂无附件</c:if>
							<c:forEach items="${files }" var="file">
					<a href="../home/download?filename=${file.attachment }">${file.attachment }</a>
					&nbsp;&nbsp;&nbsp;
				</c:forEach>
						</td>
					</tr>
				</thead>
			</table>
			<br><br>
			<c:if test="${fn:length(ins.progress) == 0 }">
			<x style="font-weight: bold;font-size: 2em;">暂无事项进展</x>
							<c:if test="${progress==true&&ins.state!=3&&ins.state!=5  }">
					<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="createProgress()"
				style="width:80px;height:30px;position: relative;left: 10px;bottom:  5px;">填报进展</a>
				<c:if test="${delay==true }">
				<c:if test="${ins.applyCause==null }">
					<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="delay()"
				style="width:80px;height:30px;position: relative;left: 10px;bottom:  5px;">
				申请延期</a>
					</c:if>
					</c:if>
				</c:if>
				<c:if test="${ins.applyCause!=null }">
				<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="delayDetails()"
				style="width:80px;height:30px;position: relative;left: 10px;bottom:  5px;">延期详情</a>
				</c:if>
			</c:if>
			<c:if test="${fn:length(ins.progress) != 0 }">
				<x style="font-weight: bold;font-size: 2em;">事项进展</x>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="progress()"
				style="width:60px;height:30px;position: relative;left: 10px;bottom:  5px;">更多...</a>
				<c:if test="${progress==true&&ins.state!=3&&ins.state!=5  }">
					<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="createProgress()"
				style="width:80px;height:30px;position: relative;left: 10px;bottom:  5px;">填报进展</a>
					<c:if test="${delay==true }">
					<c:if test="${ins.applyCause==null }">
							<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="delay()"
				style="width:80px;height:30px;position: relative;left: 10px;bottom:  5px;">申请延期</a>
					</c:if>
					</c:if>
				</c:if>
				<c:if test="${ins.applyCause!=null }">
				<a href="javascript:void(0)" class="easyui-linkbutton"
				onclick="delayDetails()"
				style="width:80px;height:30px;position: relative;left: 10px;bottom:  5px;">延期详情</a>
				</c:if>
			<br>
			<br>
			<table style="width: 100%;height: 200px;" id="table-4">
					<c:forEach items="${ins.progress }" var="pro">
						<tr>
							<td>${pro.description}</td>
							<td width="222" align="right">${pro.createBy }<br><fmt:formatDate value="${pro.createTime }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</table>
				</c:if>
				<br><br>
			<x style="font-weight: bold;font-size: 2em;">
			<c:if test="${fn:length(ins.opinion) == 0 }">暂无督办意见<c:if
					test="${role==1&&ins.state!=1&&ins.state!=3&&ins.state!=4&&ins.state!=5 }">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="createOpinion()"
						style="width:100px;height:30px;position: relative;left: 10px;bottom:5px;">更新督办意见</a>
				</c:if>
			</c:if></x>
			<c:if test="${fn:length(ins.opinion) != 0 }">
				<x style="font-weight: bold;font-size: 2em;">督办意见</x>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="opinions()"
					style="width:60px;height:30px;position: relative;left: 10px;bottom:  5px;">更多...</a>
				<c:if test="${role==1&&ins.state!=3&&ins.state!=4&&ins.state!=5 }">
					<a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="createOpinion()"
						style="width:100px;height:30px;position: relative;left: 10px;bottom:  5px;">更新督办意见</a>
				</c:if>
				<br>
				<br>
				<table style="width: 100%;height: 200px;" id="table-4">
					<c:forEach items="${ins.opinion }" var="o">
						<tr>
							<td>${o.description}</td>
							<td align="right" width="222">${o.createBy }<br><fmt:formatDate value="${o.createTime }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<br><br>
			<x style="font-weight: bold;font-size: 2em;"> <c:if
				test="${fn:length(ins.record) == 0 }">暂无</c:if>修改记录</x>
			<c:if test="${fn:length(ins.record) != 0 }">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="record()"
					style="width:60px;height:30px;position: relative;left: 10px;bottom:  5px;">更多...</a>
				<br>
				<br>
				<table style="width: 100%;height: 200px;" id="table-4">
					<c:forEach items="${ins.record }" var="r">
						<tr>
							<td width="222" style="border-right:1px solid #CCCCCC;">${r.updateBy }<br><fmt:formatDate value="${r.updateTime }"
									pattern="yyyy-MM-dd HH:mm:ss" />
							</td>
							<td>${r.updateBody}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
			<br><br>
			<x style="font-weight: bold;font-size: 2em;">留言讨论区</x>
			<a href="javascript:void(0)" class="easyui-linkbutton"
					onclick="message()"
					style="width:60px;height:30px;position: relative;left: 10px;bottom:  5px;">更多...</a>
			<br>
			<br>
						<table style="width: 100%;" id="table-4">
					<c:forEach items="${ins.message }" var="mes">
						<tr>
							<td width="222" style="border-right:1px solid #CCCCCC;">${mes.createBy }<br><fmt:formatDate value="${mes.createTime }"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${mes.message}</td>
						</tr>
					</c:forEach>
				<tr>
					<td colspan="3"><script type="text/plain" id="message"
							style="width:100%;height:350px;">
				</script> <br> <a href="javascript:void(0)" class="easyui-linkbutton"
						onclick="submitmessage()" style="width:150px;float: left;">发&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;送</a> <br>
					</td>
				</tr>
			</table>
		</div>
		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
</body>
<script type="text/javascript">
	$(function() {
		var message = UM.getEditor('message');
		var flag="${flag}";
		if(flag==1)window.scrollTo(0, document.documentElement.clientHeight);
								 var websocket=new WebSocket("ws://"+url+"websocket");
						$("#remind").click(function(){
							  var text = '4';
					        if(text == null || text == "")return false;
					        var msg = {
					            msgContent: text,
					            postsId: 1
					        };
					        if (websocket.readyState==1) {
					        websocket.send(JSON.stringify(msg));
					        }
					        });
	});
	var iid = "${ins.iid}";
	function record() {
	window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../inspector/recordDetails?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '修改记录',
			width : 800,
			height : 580,
			iconCls : 'fa fa-file-text-o'
		}).window('open');
	}
		function createOpinion() {
		window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' frameborder='0''  src='../inspector/createOpinionPage?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '更新督办意见',
			width : 550,
			height : 380,
			iconCls : 'fa fa-pencil'
		}).window('open');
	}
			function createProgress() {
		window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' frameborder='0''  src='../inspector/createProgressPage?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '填报进展',
			width : 550,
			height : 380,
			iconCls : 'fa fa-pencil'
		}).window('open');
	}
		function opinions() {
		window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../inspector/opinions?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '督办意见',
			width : 800,
			height : 580,
			iconCls : 'fa fa-file-text-o'
		}).window('open');
	}
		function message() {
	window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../inspector/messages?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '留言讨论',
			width : 800,
			height : 580,
			iconCls : 'fa fa-file-text-o'
		}).window('open');
	}
	function submitmessage(){
					if(!UM.getEditor('message').hasContents()){
					$.messager.alert('系统提示','内容不能为空！','warning');
					return false;
					}
	var message=(UM.getEditor('message').getContent());
	var data={
	     				"iid":iid,
                      	"message":message
	     	}
							 $.ajax({
                      type: "POST",
                      url: "createMessage",
                      contentType:"application/json",
                      data:JSON.stringify(data),
                      success: function (data) {
                          if (data.code > 0) {
                          			$.messager.show({
									title:'系统提示',
									msg:data.message,
									timeout:5000,
									showType:'slide'
								});
								if(data.code==200){
								messages(iid);
						}
					 setTimeout("location.href='inspectorDetails?flag=1&iid="+iid+"'",1000);
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
	}
			function wxmes(mid){
		if(mid!=null){
			 $.ajax({
                      type: "GET",
                      url: "http://gt.qdgxtz.com/inspectors-prod/WebSocketController/WebSocket/send",
                      data:"state=4&mid="+mid,
                      success: function (data) {
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  }
		}
					function messages(iid){
						 $.ajax({
                      type: "GET",
                      url: "InspectorMes",
                      data:"iid="+iid+"&flag=3",
                      success: function (data) {
                      wxmes(data.data);
						$("#remind").trigger("click");
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
		}
			function createProgress() {
		window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' frameborder='0''  src='../inspector/createProgressPage?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '填报进展',
			width : 550,
			height : 380,
			iconCls : 'fa fa-pencil'
		}).window('open');
	}
			function progress() {
		window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../inspector/progress?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '督查事项进展',
			width : 800,
			height : 580,
			iconCls : 'fa fa-file-text-o'
		}).window('open');
	}
				function delay() {
		window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' frameborder='0''  src='../inspector/delayPage?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '申请延期',
			width : 650,
			height : 450,
			iconCls : 'fa fa-file-text-o'
		}).window('open');
	}
					function delayDetails() {
		window.scrollTo(0,0);
		$("#modalwindowContent")
				.html(
						"<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../inspector/delayDetails?iid="
								+ iid + "'></iframe>");
		$("#modalwindowContent").window({
			title : '延期详情',
			width : 600,
			height : 280,
			iconCls : 'fa fa-file-text-o'
		}).window('open');
	}
				function frameReturnByClose() {
        $("#modalwindowContent").window('close');
    }
     function frameReturnByMes(mes) {
        $.messageBox5s('系统提示', mes);
        setTimeout("location.href='inspectorDetails?iid="+iid+"'",1000);
    }
</script>
</html>