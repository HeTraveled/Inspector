<%@ page contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>青岛高投集团行政督查信息系统</title>
    <link rel="icon"  href="<%= basePath%>images/tolo.png" type="image/x-icon">
  <link rel="stylesheet" type="text/css" href="<%=basePath%>jsAndcss/ymnets.easyui/themes/base/easyui.css">
 	 <link href="<%=basePath%>jsAndcss/ymnets.easyui/themes/skin-green.css" rel="stylesheet" />
    <script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>jsAndcss/ymnets.easyui/jquery.easyui.min.js"></script>
    <link rel="stylesheet"  href="<%=basePath%>css/flash.css" />
    <link href="<%=basePath%>jsAndcss/ymnets.easyui/content/fontawesome/css/font-awesome.min.css" rel="stylesheet" />
	<link href="<%=basePath%>jsAndcss/css/login.css" rel="stylesheet" />
    <meta name="GENERATOR" content="MSHTML 11.00.9600.17496">
</head>
<style type="text/css">

a:link {
 color: #000000;
 text-decoration: none;
}
a:visited {
 color: #000000;
 text-decoration: none;
}
a:hover {
 color: #999999;
 text-decoration: none;
}
#bgImg{
position:fixed;
  top: 0;
  left: 0;
  width:100%;
  height:100%;
  min-width: 1000px;
  z-index:-10;
  zoom: 1;
  background-color: #fff;
  background-repeat: no-repeat;
  background-size: cover;
  -webkit-background-size: cover;
  -o-background-size: cover;
  background-position: center 0;
	background-image: url("../images/bei.jpg");

}
</style>
<body>
<div id="bgImg"></div>
    <table style="width:100%;height:100%; padding:61px 0 41px 0;    box-sizing: border-box;    position: fixed;top:0;">
        <tr align="center">
            <td style="width:600px;">
                <div id="loginbody">
                    <p style="padding: 30px 0px 0px 0px;">
                    <img src="<%=basePath%>images/lo.png" style=" width:30%; max-width: 100px; min-width: 100px;">
                       <br>
                    <div style="font-size:36px;color:#3b6590;font-weight:bold;text-align: center;">高投集团行政督查系统</div>
                    <br>
                    </p>
                    <div style="padding:15px 0px 20px;">
                    <div style="width:250px; margin:0 auto;    position: relative; border: 1px solid #d3d3d3;  border-radius: 4px; box-shadow: inset 0 1px 1px rgba(0,0,0,.075);transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;display:block;overflow: hidden;">
                  	 	<span class="u_logo fa fa-user"></span>
                        <input id="username" name="username" class="ipt" type="text" placeholder="请输入用户名" value="">
                    </div>
                        
                    </div>
                    <p style="position: relative;">
                    <div style="width:250px; margin:0 auto;    position: relative; border: 1px solid #d3d3d3;  border-radius: 4px; box-shadow: inset 0 1px 1px rgba(0,0,0,.075);transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;display:block;overflow: hidden;">
                        <span class="p_logo fa fa-key"></span>
                        <input class="ipt" id="password" type="Password" placeholder="请输入密码" value="">
                        </div>
                    </p>
                    <div style="height: 63px; line-height:63px; margin-top: 40px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
                        <p style="margin: 0px 35px 20px 45px;">
                        <!--  
                          <a href="javascript:retrieve()" style="right: 25%;position: relative;">忘记密码？</a>
                          -->
                         <!--    <span style="float: right;"> -->
                                <a id="LoginSys"  style="background: #00a0e8; padding: 7px 60px; font-size:13px; border-radius: 4px; border: 1px solid #00a0e8; border-image: none; color: rgb(255, 255, 255); font-weight: bold;"
                                  href="javascript:void(0);">登&nbsp;录</a>
                        </p>
                         <div id="preloader_1" class="p2" style="width:66px;height:66px;position:absolute;top:40%;left:50%;">
          	 		<span></span>
          	 		<span></span>
					<span></span>
					<span></span>
					<span></span>
          			 </div>
                    </div>
                </div>
            </td>
            <!--  <td>&nbsp;</td>-->
        </tr>

    </table>
<div style="height: 40px; width: 100%; text-align: center; line-height: 40px;bottom: 0; position: fixed">
<p>
Copyright &copy; 2018 青岛高新区投资开发集团有限公司  All Rights Reserved.
</p>
</div>
</body>
<script type="text/javascript">
		if (top != window)top.location.href = window.location.href;
	$(function(){
	var comp="${comp}";
		if(comp!=null&&comp!='')$.messager.alert('系统提示',comp,'warning');
	$(".p2").hide();
	});
		 function login(){
		   var name = $("#username").val();
                  var psw = $("#password").val();
                  if(name==null||name==""||psw==null||psw==""){
                  $.messager.alert('系统提示','用户名或密码不能为空！','warning');
                  	 return false;
                  }
                  $.ajax({
                      type: "POST",
                      url: "login",
                      data:"username="+name+"&password="+escape(encodeURIComponent(psw)),
                      beforeSend:function(XMLHttpRequest){
			           $(".p2").show();
			        },
                      success: function (data) {
                          if (data.code == 200) {
                           setTimeout(function () {
                           		$(".p2").hide();
                                  location.href = "index";
                              }, 3000);
                          }else if(data.code==234){
                          $(".p2").hide();
                          	$.messager.alert('系统提示',data.message,'warning');
                          } else {
                          $(".p2").hide();
                             $.messager.alert('系统提示',data.message,'error');
                          }
                      },
                      error: function (request) {
                          $.messager.alert('系统提示','请求出错！','error');
                      }
                  });
                  }
          $('#LoginSys').on('click', function () {
                login();
       });
       $("body").keydown(function (event) {
             if (event.keyCode == "13")login();
            });
        
    function ShowInfo(name, url) {
        $("#modalwindowContent").html("<iframe width='100%' height='100%' scrolling='no' frameborder='0''  src='../home/retrievePwd'></iframe>");
        $("#modalwindowContent").window({ title: name, width: 600, height: 350, iconCls: 'fa fa-list' }).window('open');
    }
    function retrieve(){
    	 $.messager.alert('系统提示','请联系管理员！','warning');
    }
</script>
</html>