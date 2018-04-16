<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		a{/*去掉超链接下划线*/text-decoration:none;}
		ul,li,ol{list-style:none;}
		.nev{height:20px;line-height:20px;width:800px;margin-left:400px;color: orange;}
		.nev1{height:100px;background-image:url("images/nav_bg.png");}
		.time{width:250px;float:right;margin-top:80px;margin-right:-44px;color:gray;}
		.logout{width:50px;float:right;margin-right:30px;margin-top:60px;}
		.nev-wz{width:700px;font-size:30px; color:brown;margin-left:300px; margin-top:-120px;}
	</style>
  <script type="text/javascript" src="js/header.js"></script>
  <link rel="stylesheet" href="css/font-awesome.css" type="text/css"></link>
  </head>
  
  
  <body>
  		<marquee scrollamount="6" onmouseout="this.start()" onmouseover="this.stop()" behavior="alternate"  class="nev">欢迎${user.username}来到本网站</marquee>
  <div class="nev1">
  		<!--退出登录--> 	
  		<a href="root/LogoutServlet" class="logout" target="_top"><i class="fa fa-reply-all" ></i>退出</a>
  		<!--退出登录 end--> 
  		
  		<!--显示时间-->
    	<div id="showtime" class="time"></div>
    	<!--显示时间 end-->
    	
    	<!--字体小图标-->
  		<span class="fa fa-home" style="font-size:110px;margin-left:200px; color:orange;"></span>
  		<!--字体小图标 end-->
  		
  		<div class="nev-wz">	
  			<ul>
  				<li>鞋程</li>
  				<li style="margin-left:120px;">一个神奇的网站</li>
  				<li style="margin-left:300px;margin-top:-70px;font-size:26px;">新奇、新鲜、新颖</li>
  			</ul>
  		</div>
  	</div>
  </body>
</html>
