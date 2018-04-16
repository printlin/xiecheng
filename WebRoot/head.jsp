<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="css/head.css">
<div class="head">
    	<div class="headAll">
        	<div class="headLogo">
            	<a href="${pageContext.request.contextPath }/jumpIndex.jsp"><img  class="headLogoImg" src="images/logo.png"></a>
            </div>
            
            <div class="headDo">
            	<c:if test="${user!=null }">
            		<a class="ac" href="${pageContext.request.contextPath }/servlet/UserUIServlet"><img class="userHead" src="${user.u_pic }"><span class="headText">用户名</span></a>
	                <a class="ac" href="${pageContext.request.contextPath }/servlet/LogoutServlet"><span class="headText">注销</span></a>
	                <a class="ac" href="${pageContext.request.contextPath }/servlet/ShoppingCartServlet"><span class="headText">购物车</span></a>
            	</c:if>
            	<c:if test="${user==null }">
            	<a class="ac" href="${pageContext.request.contextPath }/login.jsp"><span class="headText">登录</span></a>
                <a class="ac" href="${pageContext.request.contextPath }/register.jsp"><span class="headText">注册</span></a>
                <a class="ac" href="${pageContext.request.contextPath }/servlet/ShoppingCartServlet"><span class="headText">购物车</span></a>
                </c:if>
                
            </div>
            <div class="clear"></div>
        </div>
    </div>
