<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>鞋程网用户信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="css/user.css">
<link rel="stylesheet" type="text/css" href="css/head.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function changeInfo(){
		$("#form1").submit();
	}
	function changePass(){
		window.location.href="changePwd.jsp";
	}
	function changePic(){
		window.location.href="changePic.jsp";
	}
	function deleteB(id){
		window.location.href="servlet/DeleteOrderServlet?ord_id="+id;
	}
	function overB(id){
		window.location.href="servlet/OverOrderServlet?ord_id="+id;
	}
	function payB(id){
		window.location.href="servlet/PayUIServlet?ord_id="+id;
	}
</script>
</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
	<form id="form1" action="${pageContext.request.contextPath}/servlet/UserServlet" method="post">
		<div class="userInfo">
	    	<div>
	        	<span class="titleText">基本信息</span>
	            <hr style="width:1190px;margin-bottom:10px;">
	        </div>
	    	<div class="userLeft">
	        	<img class="userLeftImg" src="${user.u_pic }"/>
	        </div>
	        <div class="userRight">
	        	<div class="userRRow">
	            	<span class="userText1">账号:</span>
	                <input class="userIn" type="text" name="username" value="${user.username }">
	            </div>
	            <div class="userRRow">
	            	<span class="userText1">余额:</span>
	                <input class="userIn" type="text" value="${user.u_money }" disabled="disabled">
	            </div>
	            <div class="userRRow">
	            	<span class="userText1">姓名:</span>
	                <input class="userIn" type="text" name="u_name" value="${user.u_name }">
	            </div>
	            <div class="userRRow">
	            	<span class="userText1">电话:</span>
	                <input class="userIn" type="text" name="u_num" value="${user.u_num }">
	            </div>
	            <div class="userRRow">
	            	<span class="userText1">地址:</span>
	                <input class="userIn" type="text" name="u_address" value="${user.u_address }">
	            </div>
	            <div class="userRRow">
	            	<span onclick="changeInfo()" class="changeInfo">修改信息</span>
	            	<span onclick="changePass()" class="changePass">修改密码</span>
	            	<span onclick="changePic()" class="changePic">修改头像</span>
	            </div>
	        </div>
	    </div>
    </form>
    <div class="userInfo">
   		<div>
        	<span class="titleText">我的订单</span>
            <hr style="width:1190px;margin-bottom:10px;">
        </div>
        <div>
        	<ul class="spUl">
        		<c:forEach var="order" items="${list }">
	        		<li>
	                	<a class="spRow" href="javascript:void(0);">
	                        <div class="orderInfo">
		                        <div class="spRowRow">
		                            <span class="spText1">姓名：</span>
		                            <span class="spText2">${order.ord_u_name }</span>
		                        </div>
		                        <div class="spRowRow">
		                            <span class="spText1">电话：</span>
		                            <span class="spText2">${order.ord_u_phone }</span>
		                        </div>
		                        <div class="spRowRow">
		                            <span class="spText1">地址：</span>
		                            <span class="spText2">${order.ord_u_add }</span>
		                        </div>
		                        <div class="spRowRow">
		                            <span class="spText1">价格：</span>
		                            <span class="spText2">${order.ord_price }</span>
		                        </div>
		                        <div class="spRowRow">
		                            <span class="spText1">时间：</span>
		                            <span class="spText2">${order.ord_date }</span>
		                        </div>
	                        </div>
	                        <div class="orderBu">
	                        	<span onclick="deleteB('${order.ord_id}')" class="orderDe">删除订单</span>
	            				<c:if test="${order.ord_type=='已付款'}">
	            					<span onclick="overB('${order.ord_id}')" class="orderOv">确认收货</span>
	            				</c:if>
	            				<c:if test="${order.ord_type=='未付款'}">
	            					<span onclick="payB('${order.ord_id}')" class="orderPy">立即付款</span>
	            				</c:if>
	                        </div>
	                    </a>
	                </li>
        		</c:forEach>
            </ul>
        </div>
    </div>
    <jsp:include page="bottom.jsp"></jsp:include>
</html>
