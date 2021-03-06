<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>青岛高投集团行政督查信息系统</title>
    <meta name="renderer" content="webkit" />
    <meta name="viewport" content="width=device-width" />
    <link rel="icon"  href="<%= basePath%>images/tolo.png" type="image/x-icon">
    <script src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
    <script src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
    <link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css" rel="stylesheet" />
    <link id="CurrentSkin" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-redlight.css" rel="stylesheet" />
    <link href="<%=basePath%>jsAndcss/ymnets.easyui/content/Site.css" rel="stylesheet" />
    <link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
    <script src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/common.js"></script>
  	<script src="<%=basePath%>jsAndcss/ymnets.easyui/content/js/home.js"></script>
  	<script src="<%=basePath%>js/url.js"></script>
     <style>  *{    box-sizing: border-box;}</style>
</head>
<body class="easyui-layout" id="easyLayout">
<a style="display: none;" id="num"></a>
<a style="display: none;" id="session"></a>
    <div id="modalwindow" class="easyui-window" data-options="closed:true,minimizable:false,shadow:false,collapsible:true">
    </div>
    		<div id="modalwindowContent" class="easyui-window"
			data-options="modal:true,closed:true,minimizable:false,shadow:false,maximized:true"></div>
    <div id="north" data-options="region:'north',border:false,split:false" style="height: 50px; padding: 0; margin: 0">
        <table class="banner" style="border-spacing: 0px;">
            <tr>
                <td class="webname">
                      <img style="position: relative;top: 3px;" src="<%=basePath%>images/balo.png" width="45" height="45"><span style="position: relative;bottom:  10px;">青岛高投集团行政督查信息系统</span>
                </td>
               <td align="center">
               <iframe id="iframe" src="../home/horn" style="height: 35px;width: 100%;"  frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="no" allowtransparency="yes"></iframe>
				</td>
				  <td style="width: 40px;">
				 <a  id="bug" class="l-btn-text fa fa-bug fa-lg bannerbtn" title="BUG反馈" href="javascript:void(0);" 
                     onclick="createBug()"></a>
				  </td>
                <td style="width: 40px;">
			                <style>
								#newMes::after{
									width: 6px;
								    height: 6px;
								    content: '';
								    background: #fff;
								    border-radius: 100%;
								    position: absolute;
								    top: 18px;
								}
			</style>
                	<a style="display: none;"  id="newMes" title="新消息(${message})" class="l-btn-text fa fa-envelope-o  fa-lg bannerbtn" href="javascript:void(0);" 
                     onclick="javascript:addTab('系统消息','../messageRemind/data?state=0','fa fa-envelope-o')"></a>
                    <a  style="display: none;" id="Mes"  title="消息" class="l-btn-text fa fa-envelope-o  fa-lg bannerbtn" href="javascript:void(0);" 
                     onclick="javascript:addTab('系统消息','../messageRemind/data','fa fa-envelope-o')"></a>
                </td>
                <td style="width: 180px; overflow: hidden;">
                    <a id="showUserInfo" style="display: inline-block;" class="fa bannerbtn" href="javascript:Profile();">
                        <img src="${u.headimg }" class="user-image" alt="User Image">
                        <input type="hidden" id="userImg" value="${u.headimg }">
                        <span class="user-name">${u.name }</span>
                    </a>
                </td>
            </tr>
        </table>

    </div>

			<div id="noticeDialog" class="easyui-dialog" style="padding:10px;width:80%;">
			<iframe id="diaframe" src="dialog" style="height: 100%;width: 100%;"  frameborder="no" border="0" marginwidth="0" marginheight="0" scrolling="auto" allowtransparency="yes"></iframe>
		</div>
    <div id="west" data-options="region:'west',title:'MAIN NAVIGATION',split:true,collapsible:false" style="width: 180px; height: 100%;border-bottom: 0px;">
        <div id="RightAccordion" class="easyui-accordion" data-options="fit:true,border:false">
            <div class="easyui-accordion" style="width: 500px; height: 300px;" >
            <div title="菜单导航" data-options="iconCls:'fa fa-home'" style=" overflow: auto;overflow-x:hidden;">
            <br>
            <ul id="tree" class="easyui-tree" data-options="animate:true">
            <li class="tree">
            <div style="float: left;font-weight: bold;" class="num">当前在线人数</div>
                    			<div style="width:500%;height:200%;right: 150%;position: relative;" onclick="javascript:addTab('工作台','../home/desktop','fa fa-tachometer')"></div>
                    			</li>
                    			      <li data-options="iconCls:'fa fa-television'" class="tree">
            <div style="float: left;">部门看板</div>
                    			<div style="width:500%;height:200%;right: 150%;position: relative;" onclick="javascript:addTab('部门看板','../board/boardPage?state=3','fa fa-television')"></div>
                    			</li>
                    			    <li data-options="iconCls:'fa fa-address-book-o'" class="tree">
            <div style="float: left;">部门通讯录</div>
                    			<div style="width:500%;height:200%;right: 150%;position: relative;" onclick="javascript:addTab('部门通讯录','../Dept/Deptlist','fa fa-address-book-o')"></div>
                    			</li>
                    		  <li data-options="iconCls:'fa fa-list-alt'" class="tree">
            <div style="float: left;">制度表格</div>
                    			<div style="width:500%;height:200%;right: 150%;position: relative;" onclick="javascript:addTab('制度表格','../regulations/data','fa fa-list-alt')"></div>
                    			</li>
            <c:forEach items="${menu }" var="m" varStatus="menuName">
                             		<c:if test="${menuName.index==0 }"><li data-options="iconCls:'${m.icon }'"></c:if>
                             		<c:if test="${menuName.index!=0 }"><li data-options="state:'closed'" iconCls="${m.icon }"></c:if>
                                 <span>${m.name }</span>
                                    <ul>
                                   	<c:forEach items="${m.menu }" var="ms">
                                        <li data-options="iconCls:'${ms.icon }'">
                                        <div style="float: left;">${ms.name }</div>
                                        <div style="width:500%;height:200%;right: 150%;position: relative;" onclick="javascript:addTab('${ms.name }','${ms.url }','${ms.icon }')"></div>
                                       </li>
                                      </c:forEach>
                                    </ul>
                                </li>
                 </c:forEach>
                 </ul>
            </div>
        </div>
        </div>
        <div id="RightTree" class="easyui-tree"></div>
    </div>
    <div id="center" data-options="region:'center',border:false">
        <div id="mainTab" class="easyui-tabs" data-options="fit:true">
            <div title="工作台" data-options="closable:false,iconCls:'fa fa-tachometer'">
                <iframe scrolling="auto" frameborder="0" src="desktop" style="width: 100%; height: 100%;"></iframe>
            </div>
        </div>
    </div>
</body>
 <script type="text/javascript">
 if (top != window)top.location.href = window.location.href;
		function AutoScroll(obj) {
			$(obj).find("ul:first").animate({
				marginTop: "-25px"
			}, 500, function() {
				$(this).css({
					marginTop: "0px"
				}).find("li:first").appendTo(this);
			});
		}
				    function sessionFlag(){
    					 $.ajax({
                      type: "GET",
                      url: "sessionFlag",
                      success: function (data) {
                      },
                  });
    }
		  	$(function() {
		  	var message="${message }";
		  	if(parseInt(message)!=0){
		  	$("#newMes").show();
		  	$("#Mes").hide();
		  	}
		  	else {
		  	$("#Mes").show();
		  	$("#newMes").hide();
		  	}
		  	var prompt="${u.prompt}";
		 $(".tree-icon,.tree-file").removeClass("tree-icon tree-file");
  		  $(".tree-icon,.tree-folder").removeClass("tree-icon tree-folder tree-folder-open tree-folder-closed");
  		  $('#tree').tree({
	onExpand: function(node){
		$('.tree-title').prev().removeClass("tree-folder-open");
 $('.tree-checkbox,.tree-checkbox0').prev().removeClass("tree-folder-open");
	},
	        onSelect: function (node) {
	        
            if (node.state == "closed"){
         	   $(this).tree('collapseAll');
                $(this).tree('expand', node.target);
                }
            else{
                $(this).tree('collapse', node.target);
                }
        }
});
opendialog("${dialogNum}",prompt);
 	var websocket;
 	websocket=new WebSocket("ws://"+url+"websocket");
    // 打开时
    websocket.onopen = function(evnt) {
        console.log("  websocket.onopen  ");
    };
        websocket.onerror = function(evnt) {
        console.log("  websocket.onerror  ");
    };
    websocket.onclose = function(evnt) {
        console.log("  websocket.onclose  ");
    };
    // 处理消息时
    websocket.onmessage = function(evnt) {
    if(evnt.data=='1'){
     //1.处理小喇叭
  				$("#iframe").attr('src','../home/horn');
  				}
  	if(evnt.data=='2'){
  		//更新当前在线人数
  							 $.ajax({
                      type: "GET",
                      url: "peopleNum",
                      success: function (data) {
                          if (data.code > 0) {
                    		  $(".num").html('当前在线人数：'+data.data);
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
  	}
  		if(evnt.data=='4'){
  		if(prompt!=0){
  		//右下角消息
  		 $.ajax({
                      type: "GET",
                      url: "dialogNum",
                      success: function (data) {
                          if (data.code > 0) {
                    		  if(data.data!=0){
                    		  	$('#diaframe').attr('src','dialog');
								$('#noticeDialog').dialog('open');
								  $('#newMes').show();
								  $('#Mes').hide();
                    		  }else{
                    		  	$('#noticeDialog').dialog('close');
                    		  	$('#newMes').hide();
								  $('#Mes').show();
                    		  }
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
  	}
  	}
    };
    		 $("#session").click(function(){
     			 $.ajax({
                      type: "GET",
                      url: "session",
                      success: function (data) {
                             if (data.code!=200) {
								location.href='index';
                          }
                      }
                  });
     });
        $("#num").click(function(){
           var websocket;
    // 首先判断是否 支持 WebSocket
        websocket = new WebSocket("ws://"+url+"websocket");
		  var text = '2';
        if(text == null || text == "")return false;
        var msg = {
            msgContent: text,
            postsId: 1
        };
         websocket.addEventListener('open', function () {
         	        websocket.send(JSON.stringify(msg));
         });
        });
        setInterval('clic()', 30000);
        setInterval('sess()', 1000);
         $("#num").trigger("click");
          $("#session").trigger("click");
		});
		function clic(){
		 $("#num").trigger("click");	
		}
		function sess(){
		 $("#session").trigger("click");	
		}
				function opendialog(flag,prompt){
			// 弹出公告框
	var dialogWidth = 333;		// dialog的宽度
	var dialogHeight = 250;		// dialog的高度
	var topPosition = $(window).height() - dialogHeight;
	var leftPosition = $(window).width() - dialogWidth;
	$('#noticeDialog').dialog({
	    width: dialogWidth,
	    height: dialogHeight,
	    top : topPosition,
	    left : leftPosition,
	    title:'系统消息',
	    resizable:false,
	    closed:true,
	    iconCls:'fa fa-bell-o',
	    	buttons:[{
				text:' <span class="fa fa-bell-slash-o">',
				handler:function(){
						$.messager.confirm('系统提示', '确定要关闭系统消息提醒吗？<br><font style="color:red;">(关闭后仍可进入个人资料重新开启)</font>', function(r) {
						if(r){
							  		 $.ajax({
                      type: "GET",
                      url: "../user/updatePrompt",
                      data:"uid=${u.uid}",
                      success: function (data) {
                             if (data.code > 0) {
								location.href='index';
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  		}
						});
				}
			},{
				text:'更多...',
				handler:function(){
					parent.addTab('系统消息','../messageRemind/data','fa fa-envelope-o');
				}
			}]
	}); 
	if(flag!=0&&prompt!=0){
		$('#noticeDialog').dialog('open');
	}
	}
	function createBug(){
		 $("#modalwindowContent").html
					 ("<iframe width='100%' height='100%' frameborder='0''  src='../bug/createBugPage'></iframe>");
         $("#modalwindowContent").window({ title: 'BUG反馈', width: 500, height: 500, iconCls: 'fa fa-bug' }).window('open');
	}
</script>
</html>