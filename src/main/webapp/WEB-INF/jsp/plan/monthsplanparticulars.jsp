<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <title></title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    	<link href="<%=basePath%>jsAndcss/css/editor.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css" type="text/css"></link>
	<link rel="stylesheet" href="<%=basePath%>ueditor-mini1.2.2/themes/default/_css/umeditor.css" type="text/css"></link>
	<link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
	<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jsAndcss/ymnets.easyui/content/Site.css">
	<link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" /></head>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
    <link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
    <script
	src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/jquery.easyui.plus.js"></script>
    <link rel="stylesheet" href="<%=basePath%>ueditor/themes/default/css/umeditor.css" type="text/css"></link>
    <script type="text/javascript" src="<%=basePath%>ueditor/third-party/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.config.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/umeditor.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor/lang/zh-cn/zh-cn.js"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/umeditor.config.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/editor_api.js" charset="utf-8"></script>
    <script type="text/javascript" src="<%=basePath%>ueditor-mini1.2.2/lang/zh-cn/zh-cn.js"></script>
    <script src="<%=basePath%>js/ajaxfileupload.js"></script>
    <script src="<%=basePath%>js/url.js"></script>
	<script
	src="<%=basePath%>jsAndcss/ymnets.easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<style>
td{border:solid #CCCCCC; border-width:0px 1px 1px 0px; padding:10px 20px;}
table{border:solid #CCCCCC; border-width:1px 0px 0px 1px;font-size: 1.2em;}
</style>
<body>
<a style="display: none;" id="remind"></a>
	<div style="padding:5px 5px 0px 20px;">
		<div class="mvctool">
		<table style="width: 100%;line-height: 200%;">
			<thead>
			
			<font style="font-weight:bold;width: 100%;">时间：</font>${thismonth.years}年${thismonth.months}月</td></tr>
				<tr id="tr1"><td colspan="2"><font style="font-weight: bold;size">本月计划详情：</font>
				<c:forEach items="${nextmonth}" var="lm" varStatus="status">
				</br>
				${ status.index+1}.
				
				期限：<fmt:formatDate value="${lm.startTime}"  pattern="yyyy-MM-dd"/>至
				<fmt:formatDate value="${lm.endTime}"  pattern="yyyy-MM-dd"/>
				<c:if test="${userid==thismonth.uid}"><c:if test="${lm.state==1}"><a href="javascript:void(0)"  class="easyui-linkbutton"  onclick="update('${lm.id}')" style="width:80px; height:27px;">填报进展</a></c:if></c:if>
				
				<%-- ${u.startTime}${u.endTime} --%> <br>${lm.body}
				<c:if test="${lm.state==3}"><c:if test="${lm.remarks!=null}"><br><font>完成情况：${lm.remarks }</font></c:if></c:if>
				
				</c:forEach>
				</td>
				</tr>
			
				<tr ><td colspan="2"><font ">本月计划备注：</font>
				${thismonth.remarks }
				</td>
				</tr>
				<%-- <tr ><td colspan="2"><font ">自评分：</font>
				${lastmonth.myScore}
				<c:if test="${power!=1}">${lastmonth.myScore}</c:if>
				<c:if test="${power==1}"><c:if test="${lastmonth.state!=0}">${lastmonth.myScore}</c:if></c:if>
				<c:if test="${power==1}"><c:if test="${lastmonth.state==0}"><input class="easyui-textbox"  id="myScore" iconWidth="28" style="width:60px;height:40px;padding:10px" value="${lastmonth.myScore}">
				<a href="javascript:void(0)"  class="easyui-linkbutton"  onclick="updatemessage()" style="width:60px; height:27px">确定</a></c:if></c:if>
				</td>
				</tr> --%>
				<tr >
				<c:if test="${lastmonthnext!=null}">
				<td colspan="2"><font style="font-weight: bold;">下月计划详情：</font>
				<c:if test="${userid==thismonth.uid}"><c:if test="${lastmonth.state==0}"><a href="javascript:void(0)"  class="easyui-linkbutton"  onclick="skip('${lastmonth.mid}')" style="width:50px; height:27px">添加</a></c:if></c:if></c:if>
				<c:forEach items="${lastmonthnext}" var="mn" varStatus="status"> 
				</br>
				${ status.index+1}.
				
				期限：<fmt:formatDate value="${mn.startTime}"  pattern="yyyy-MM-dd"/>至
				<fmt:formatDate value="${mn.endTime}"  pattern="yyyy-MM-dd"/>
				<c:if test="${lastmonthnext!=null}"><c:if test="${userid==thismonth.uid}"><c:if test="${lastmonth.state==0}"><a href="javascript:void(0)"  class="easyui-linkbutton"  onclick="confirm('${mn.id}')" style="width:50px; height:27px">删除</a></c:if></c:if></c:if>
				<%-- ${u.startTime}${u.endTime} --%>
				<br>${mn.body}
				</c:forEach>
				</td>
				</tr>
				
				</tr>
				<tr ><td colspan="2"><font style="font-weight: bold;">讨论区：</font>
				<a href="javascript:void(0)"  class="easyui-linkbutton"  onclick="skipmessage('${thismonth.mid}')" style="width:50px; height:27px">更多</a>
				<br>
				<c:if test="${message!=null}">
				 <c:forEach items="${message}" var="mes" varStatus="status">
						${status.index+1}.
						${mes.createBy}
						<fmt:formatDate value="${mes.createTime }"
									pattern="yyyy-MM-dd HH:mm:ss" />
									<br>
						${mes.message}
							
									<br>
					</c:forEach> 
					
					</c:if>
				</td>
				</tr>
			<script type="text/plain" id="body" style="width:100%;height:400px;">
 		    </script>
				<br>	
			<tr><td>
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creatmessage(2)" style="width:100px;float: right">取消</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="javascript:void(0)" class="easyui-linkbutton"  onclick="creatmessage(1)" style="width:100px;float: right"">确认</a>
			</td>
				</tr>
			</thead>
		</table>
		
		
						
	</div>
	<script type="text/javascript">
	$(function() {
	    //实例化编辑器
    var body = UM.getEditor('body');
    var requirements = UM.getEditor('requirements');
		$('#assistDept').combotree({
				    url: 'assistUserTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true,
				});
					$('#assistUser').combotree({
				    url: 'assistUserTree',
				    labelPosition:'top',
				    multiple:true,
				    animate:true,
				    lines:true	
				});
				 var websocket=new WebSocket("ws://"+url+"websocket");
						 var wxwebsocket=new WebSocket("ws://"+wxurl+"websocket");
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
					            if (wxwebsocket.readyState==1) {
					            
					         wxwebsocket.send("2");
					        }
					        });
					});
	
	
	
	
	function update(id){
	 
	if(id!=null){
	var mid="${thismonth.mid}";
	
				$.messager.prompt('系统提示', '请输入完成情况描述', function(r) {
				if (r) {
			
					$.ajax({
						type : "POST",
						url : "monthplannextupdate",
						data : {
							id : id,remarks:r
						},
						success : function(data) {
									if (data.code == 200) {
									setTimeout("location.href='deptmonthplanparticular?mid="+mid+"'", 500);
								};
					   },
						error: function (request) {	
                          $.messager.alert('系统提示','请求出错！','error');
                      }
					});
				}
			});
		}
		}
		
		function skip(wid) {
	var wid=wid;
		if(wid!=null){
		
		 ShowInfo('更新下周计划','../weeks/weeksplannextskip?wid='+wid);
		}
		}
		function skipmessage(mid){
		var mid=mid;
		if(mid!=null){
		ShowInfo('全部留言','../month/monthplanmessageskip?mid='+mid);
		}
		}
		function ShowInfo(name, url) {
			$("#modalwindowContent")
					.html(
							"<iframe width='100%' height='100%' scrolling='auto' frameborder='0''  src='"
									+ url + "'></iframe>");
			$("#modalwindowContent").window({
				title : name,
				width : 970,
				height :700,
				iconCls : 'fa fa-list'
			}).window('open');
		}
		function frameReturnByClose() {
			        $("#modalwindowContent").window('close');
			    }
			     function frameReturnByMes(mes) {
			     var mid="${thismonth.mid}";
				var uid="${thismonth.uid}";
			        $.messageBox5s('系统提示', mes);
			        setTimeout("location.href='deptmonthplanparticular?mid="+mid+"'", 500);
			    }
			 $(document).on('change','#uploadFile',function(){
							ajaxFileUpload();
						});
		function ajaxFileUpload() {  
			var filePath=$('#filePath').val();
		    $.ajaxFileUpload({  
		        url: 'uploadAnncFile', 
		        secureuri: false, 
		        fileElementId: 'uploadFile', 
		        dataType:'text',
		        enctype:'multipart/form-data',
		        success: function (data)  {
			            $("#file").val(filePath+data);
		        },
		        error: function (data, status, e){
		         $.messager.alert('系统提示','请求出错！','error');
		       	 }
		    });
		}

		
		function creatmessage(number){
		if(number==1){
		if(!UM.getEditor('body').hasContents()){
					$.messager.alert('系统提示','留言内容不能为空！','warning');
					return false;
					}
		var a=UM.getEditor('body').getContent();
     	 var mid="${thismonth.mid}";
     	 
		  $.ajax({
						type :"POST",
						url:"creatmonthplanmessage",
						data:{
							message:a,
							mid:mid,
							
							
						},
					success:function(data){
							  if (data.code==200) {
								creatleaveamessage();
                          				setTimeout("location.href='deptmonthplanparticular?mid="+mid+"'", 500);
                          };

						},
						error:function(request){
                          $.messager.alert('系统提示','请求出错！','error');
                          }
						});
						}else{
						   window.parent.frameReturnByClose();
						}
		};
		function updatemessage(){
		var  mid="${lastmonth.mid}";
					if($("#myScore").val()==""||$("#myScore").val()==""){
					$.messager.alert('系统提示','自评分不能为空！','warning');
					return false;
					}
					if(Math.round($("#myScore").val()===$("#myScore").val())==false){
					$.messager.alert('系统提示','自评分为整数！','warning');
					return false;
					}
					if($("#myScore").val()>100||$("#myScore").val()<0){
					$.messager.alert('系统提示','自评分数取值在0-100之间！','warning');
					return false;
					}
     	 $.ajax({
						type :"POST",
						url:"updatemyScore",
						data:{
							 mid:mid,
	     					 myScore:$("#myScore").val(),
						},
					
						success:function(data){
							  if (data.code==200) {
							 
                          				setTimeout("location.href='deptmonthplanparticular?mid="+mid+"'", 500);
                          };

						},
						error:function(request){
                          $.messager.alert('系统提示','请求出错！','error');
                          }
						});
		}
		function creatleaveamessage(){
		var  mid="${thismonth.mid}";
     	 $.ajax({
						type :"POST",
						url:"creatleaveamessage",
						  data:"mid="+mid+"&flag=3",
					
						success:function(data){
							$("#remind").trigger("click");

						},
						error:function(request){
                          $.messager.alert('系统提示','请求出错！','error');
                          }
						});
		}
		function skip(mid) {
	var mid=mid;
		if(mid!=null){
		
		 ShowInfo('更新下月计划','../month/monthplannextskip?mid='+mid);
		}
		}
		
		function confirm(id) {
	
		if(id!=null){
			$.messager.confirm('删除', '确定要删除吗?', function(r) {
				if (r) {
					$.ajax({
						type : "POST",
						url : "monthplandelect",
						data : {
							id : id
						},
						success : function(data) {
									if (data.code == 200) {
									var mid="${thismonth.mid}";
									
                          			setTimeout("location.href='deptmonthplanparticular?mid="+mid+"'", 500);
								};
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