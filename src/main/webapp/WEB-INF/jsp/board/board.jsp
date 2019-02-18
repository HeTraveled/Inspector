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
<style type="text/css">
table{
	font-size: 14px;
}
th {
	padding: 10px 0;
	width:25%;
}

.aaa {
	float: right;
	font-size: 12px;
	top: 8px;
	position: relative;
}

.aaa a:link {
	color: #333;
	text-decoration: none;
}

.aaa a:active: {
	color: #333;
	text-decoration: none;
}

.aaa a:visited {
	color: #333;
	text-decoration: none;
}

.aaa a:hover {
	color: #333;
	text-decoration: none;
}
</style>
<body>
<div style="padding:4px 5px 0px 5px;">
	<div style="float: left;">
	<select id="state" class="easyui-combobox" style="width:150px;height:25px;padding:10px;" editable="false">
	<!--  
				<option value="1" <c:if test="${state==1}">selected</c:if>>督查事项</option>
				<option value="2" <c:if test="${state==2}">selected</c:if>>周工作计划</option>
				-->
				<option value="3" <c:if test="${state==3}">selected</c:if>>其他</option>
				</select>
				</div>
					<c:if test="${principal==true }">
			<c:if test="${muchdept==true }">
				<select id="muchdepts" class="easyui-combobox" style="width:150px;height:25px;padding:10px;" editable="false">
					<c:forEach items="${muchdepts }" var="m">
						<option value="${m.id }" <c:if test="${m.id==depts}">selected</c:if>>${m.departmentname }</option>
					</c:forEach>
				</select>
			</c:if>
								<a id="btnEdit" style="left: 10px;height:25px;" class="easyui-linkbutton"	
				onclick="create()"><span class="l-btn-left"><span
					class="l-btn-text fa fa-plus" style="font-size:14px; line-height: 2.4;height:26px;"></span>
			</span>
			</a>
	</c:if>
				</div>
	<table style="width: 100%;">
		<tr>
			<td style="width:50%;">
				<table style="border: 1px solid #D3D3D3;width:100%;height: 300px;'">
					<tr height="60" style="background-color: #FFF5EE;">
						<td colspan="4" align="center">
							<div
								style="width:100%;font-weight: bold;font-size: 1.5em;color:#333;padding:10px 0;">
								重要且紧急的 <span class="aaa"><a href="javascript:boards(1)">更多&nbsp;&nbsp;</a>
								</span>
							</div></td>
					</tr>
					<tr style="background-color: #ece0d8;" height="40">
						<th>工作内容</th>
						<th>办结期限</th>
						<c:if test="${state==3 }"><th>责任人</th></c:if>
						<th>进展情况</th>
					</tr>
					<c:if test="${state==1 }">
						<c:forEach items="${one }" var="o" varStatus="on">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${o.body }</td>
						<td><fmt:formatDate value="${o.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>
						<c:if test="${o.state==2}">进行中</c:if>
						<c:if	test="${o.state==4}">已过期</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
						<c:if test="${state==2 }">
						<c:forEach items="${one  }" var="o">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${o.body }</td>
						<td><fmt:formatDate value="${o.startTime }" pattern="yyyy-MM-dd" />—<fmt:formatDate value="${o.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>
						<c:if test="${o.state==0}">未进行</c:if>
						<c:if test="${o.state==1}">进行中</c:if>
						<c:if test="${o.state==2}">未完成</c:if>
						<c:if	test="${o.state==3}">已完成</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
						<c:if test="${state==3 }">
						<c:forEach items="${one  }" var="o">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${o.body }</td>
						<td><fmt:formatDate value="${o.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>${o.liable }</td>
						<td>
						<c:if test="${o.state==1}">进行中</c:if>
						<c:if test="${o.state==2}">未完成</c:if>
						<c:if	test="${o.state==3}">已完成</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
					<c:forEach begin="1" end="${5-oneLength }">
						<tr><td>&nbsp;</td></tr>
					</c:forEach>
				</table></td>
			<td>&nbsp;</td>
			<td style="width:50%;">
				<table style="border: 1px solid #D3D3D3;width:100%;height:300px;">
					<tr height="60" style="background-color: #FFF5EE;">
						<td colspan="4" align="center"><div
								style="width:100%;font-weight: bold;font-size: 1.5em;color:#333;padding:10px 0;">
								重要但不紧急的 <span class="aaa"><a href="javascript:boards(2)">更多&nbsp;&nbsp;</a>
								</span>
							</div>
						</td>
					</tr>
					<tr style="background-color: #ece0d8;" height="40">
						<th >工作内容</th>
						<th>办结期限</th>
						<c:if test="${state==3 }"><th>责任人</th></c:if>
						<th>进展情况</th>
					</tr>
					<c:if test="${state==1 }">
					<c:forEach items="${two }" var="t">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${t.body }</td>
						<td><fmt:formatDate value="${t.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>
						<c:if test="${t.state==2}">进行中</c:if>
						<c:if	test="${t.state==4}">已过期</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
								<c:if test="${state==2 }">
						<c:forEach items="${two  }" var="t">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${t.body }</td>
						<td><fmt:formatDate value="${t.startTime }" pattern="yyyy-MM-dd" />—<fmt:formatDate value="${t.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>
						<c:if test="${t.state==0}">未进行</c:if>
						<c:if test="${t.state==1}">进行中</c:if>
						<c:if test="${t.state==2}">未完成</c:if>
						<c:if	test="${t.state==3}">已完成</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
					<c:if test="${state==3 }">
						<c:forEach items="${two  }" var="t">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${t.body }</td>
						<td><fmt:formatDate value="${t.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>${t.liable }</td>
						<td>
						<c:if test="${t.state==1}">进行中</c:if>
						<c:if test="${t.state==2}">未完成</c:if>
						<c:if	test="${t.state==3}">已完成</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
						<c:forEach begin="1" end="${5-twoLength }">
						<tr><td>&nbsp;</td></tr>
					</c:forEach>
				</table></td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td style="width:50%;">
				<table style="border: 1px solid #D3D3D3;width:100%;height:300px;">
					<tr height="60" style="background-color: #FFF5EE;">
						<td colspan="4" align="center"><div
								style="width:100%;font-weight: bold;font-size: 1.5em;color:#333;padding:10px 0;">
								不重要但紧急的 <span class="aaa"><a href="javascript:boards(3)">更多&nbsp;&nbsp;</a>
								</span>
							</div>
						</td>
					</tr>
					<tr style="background-color: #ece0d8;" height="40">
						<th>工作内容</th>
						<th>办结期限</th>
						<c:if test="${state==3 }"><th>责任人</th></c:if>
						<th>进展情况</th>
					</tr>
					<c:if test="${state==1 }">
						<c:forEach items="${three  }" var="th">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${th.body }</td>
						<td><fmt:formatDate value="${th.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>
						<c:if test="${th.state==2}">进行中</c:if>
						<c:if	test="${th.state==4}">已过期</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
						<c:if test="${state==2 }">
						<c:forEach items="${three  }" var="th">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${th.body }</td>
						<td><fmt:formatDate value="${th.startTime }" pattern="yyyy-MM-dd" />—<fmt:formatDate value="${th.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>
						<c:if test="${th.state==0}">未进行</c:if>
						<c:if test="${th.state==1}">进行中</c:if>
						<c:if test="${th.state==2}">未完成</c:if>
						<c:if	test="${th.state==3}">已完成</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
							<c:if test="${state==3 }">
						<c:forEach items="${three  }" var="th">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${th.body }</td>
						<td><fmt:formatDate value="${th.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>${th.liable }</td>
						<td>
						<c:if test="${th.state==1}">进行中</c:if>
						<c:if test="${th.state==2}">未完成</c:if>
						<c:if	test="${th.state==3}">已完成</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
						<c:forEach begin="1" end="${5-threeLength }">
						<tr><td>&nbsp;</td></tr>
					</c:forEach>
				</table></td>
			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
			<td style="width:50%;">
				<table style="border: 1px solid #D3D3D3;width:100%;height:300px;">
					<tr height="60" style="background-color: #FFF5EE;">
						<td colspan="4" align="center"><div
								style="width:100%;font-weight: bold;font-size: 1.5em;color:#333;padding:10px 0;">
								不重要也不紧急的 <span class="aaa"><a href="javascript:boards(4)">更多&nbsp;&nbsp;</a>
								</span>
							</div>
						</td>
					</tr>
					<tr style="background-color: #ece0d8;" height="40">
						<th>工作内容</th>
						<th>办结期限</th>
						<c:if test="${state==3 }"><th>责任人</th></c:if>
						<th>进展情况</th>
					</tr>
					<c:if test="${state==1 }">
						<c:forEach items="${four  }" var="f">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${f.body }</td>
						<td><fmt:formatDate value="${f.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>
						<c:if test="${f.state==2}">进行中</c:if>
						<c:if	test="${f.state==4}">已过期</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
						<c:if test="${state==2 }">
						<c:forEach items="${four  }" var="f">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${f.body }</td>
						<td><fmt:formatDate value="${f.startTime }" pattern="yyyy-MM-dd" />—<fmt:formatDate value="${f.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>
						<c:if test="${f.state==0}">未进行</c:if>
						<c:if test="${f.state==1}">进行中</c:if>
						<c:if test="${f.state==2}">未完成</c:if>
						<c:if	test="${f.state==3}">已完成</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
								<c:if test="${state==3 }">
						<c:forEach items="${four  }" var="f">
						<tr align="center" style="background-color: #f7f7f7;">
						<td>${f.body }</td>
						<td><fmt:formatDate value="${f.endTime }" pattern="yyyy-MM-dd" /></td>
						<td>${f.liable }</td>
						<td>
						<c:if test="${f.state==1}">进行中</c:if>
						<c:if test="${f.state==2}">未完成</c:if>
						<c:if	test="${f.state==3}">已完成</c:if>
						</td>
					</tr>
					</c:forEach>
					</c:if>
					<c:forEach begin="1" end="${5-fourLength }">
						<tr><td>&nbsp;</td></tr>
					</c:forEach>
				</table></td>
		</tr>
	</table>
	<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false"></div>
</body>
<script type="text/javascript">	
var flag=1;
$(function() {
		      $('#modalwindowContent').window({
                onBeforeClose: function () { //当面板关闭之前触发的事件
                  if("${depts}"!=null){
                  location.href='boardPage?state='+flag+'&depts='+"${depts}";
                  }else{
                  	location.href='boardPage?state='+flag;
                  }
                }
            });
            var i=1;
            var j=1;
          		$('#state').combobox({
					onSelect: function(record){
					var depts="${depts}";
					if(i==0){
					if(depts!=null)location.href='boardPage?state='+record.value+'&depts='+depts;
					else location.href='boardPage?state='+record.value;
					}
						 i=0;
                  }
                 });
                 $('#muchdepts').combobox({
					onSelect: function(record){
					if(j==0)location.href='boardPage?state='+$('#state').val()+'&depts='+record.value;
					j=0;
                  }
                 });
            });
            			function frameReturnByClose() {
        $("#modalwindowContent").window('close');
    }
     function frameReturnByMes(mes) {
        $.messageBox5s('系统提示', mes);
        var depts="${depts}";
        if(depts==null)setTimeout("location.href='boardPage?state="+flag+"'", 1000);
		else setTimeout("location.href='boardPage?state="+flag+"&depts="+depts+"'", 1000);
    }
                		function create() {
		 $("#modalwindowContent").html("<iframe width='100%' height='100%' frameborder='0''  src='../board/createBoardPage'></iframe>");
         $("#modalwindowContent").window({ title: '添加工作', width: 600, height: 600, iconCls: 'fa fa-television' }).window('open');
         flag=3;
		}
	function boards(f){
	var state="${state}";
	var depts="${depts}";
	if(depts==null){
		 $("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../board/boardsPage?state="+state+
		 "&flag="+f+"'></iframe>");
		 }else{
		 	$("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../board/boardsPage?state="+state+
		 "&flag="+f+"&depts="+depts+"'></iframe>");
		 }
         $("#modalwindowContent").window({ title: '更多...', width: 800, height: 600, iconCls: 'fa fa-television' }).window('open');
         flag=state;
	}
</script>
</html>