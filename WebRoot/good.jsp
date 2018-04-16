<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>商品详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="css/good.css">
	<script src="js/jquery-2.1.4.min.js"></script>
	
	<script type="text/javascript">
		function sizeC(size){
			$("#sizeI").val(size);
			$("#sizeS").html(size);
		}
		function colorC(color){
			$("#colorI").val(color);
			$("#colorS").html(color);
		}
		function orderBuyC(){
			if($("#sizeI").val()=='null'){
				alert("未选择尺码");
				return;
			}
			if($("#colorI").val()=='null'){
				alert("未选择颜色");
				return;
			}
			$("#typeI").val("buy");
			$("#orderForm").submit();
		}
		function orderJoinC(){
			if($("#sizeI").val()=='null'){
				alert("未选择尺码");
				return;
			}
			if($("#colorI").val()=='null'){
				alert("未选择颜色");
				return;
			}
			$("#typeI").val("join");
			$("#orderForm").submit();
		}
	</script>
	
  </head>
  
  <body>
  	<div class="all">
        <div class="orderTitle">请填写订单信息</div>
        <form id="orderForm" action="servlet/OrderServlet" method="post">
        	<input id="colorI" type="hidden" name="color" value="null">
        	<input id="sizeI" type="hidden" name="size"  value="null">
        	<input id="typeI" type="hidden" name="type">
        	<input id="countI" type="hidden" name="count" value='1'>
        	<input id="nameI" type="hidden" name="name" value='${good.good_name }'>
        	<input id="picI" type="hidden" name="pic" value='${good.good_pic }'>
        	<input id="idI" type="hidden" name="good_id" value='${good.good_id }'>
        	<input id="priceI" type="hidden" name="price" value='${good.good_price }'>
	        <div class="orderInfo">
	        	<div class="orderRow">
	            	<span class="orderText1">颜色：</span>
	                <ul class="floatLeftUl">
	                	<c:if test="${fn:indexOf(good.good_color,'白色')>-1}">
	                		<li><span id="白色" onclick="colorC('白色')" class='orderText2 '>白色</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_color,'黑色')>-1}">
	                		<li><span id="黑色" onclick="colorC('黑色')" class='orderText2 '>黑色</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_color,'红色')>-1}">
	                		<li><span id="红色" onclick="colorC('红色')" class='orderText2 '>红色</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_color,'黄色')>-1}">
	                		<li><span id="黄色" onclick="colorC('黄色')" class='orderText2 '>黄色</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_color,'绿色')>-1}">
	                		<li><span id="绿色" onclick="colorC('绿色')" class='orderText2 '>绿色</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_color,'蓝色')>-1}">
	                		<li><span id="蓝色" onclick="colorC('蓝色')" class='orderText2 '>蓝色</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_color,'粉色')>-1}">
	                		<li><span id="粉色" onclick="colorC('粉色')" class='orderText2 '>粉色</span></li>
	                	</c:if>
	                </ul>
	            </div>
	            <div class="orderRow">
	            	<span class="orderText1">尺寸：</span>
	                <ul class="floatLeftUl">
	                	<c:if test="${fn:indexOf(good.good_size,'37')>-1}">
	                		<li><span id="s37" onclick="sizeC('37')" class='orderText2 '>37</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_size,'38')>-1}">
	                		<li><span id="s38" onclick="sizeC('38')" class='orderText2 '>38</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_size,'39')>-1}">
	                		<li><span id="s39" onclick="sizeC('39')" class='orderText2 '>39</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_size,'40')>-1}">
	                		<li><span id="s40" onclick="sizeC('40')" class='orderText2 '>40</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_size,'41')>-1}">
	                		<li><span id="s41" onclick="sizeC('41')" class='orderText2 '>41</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_size,'42')>-1}">
	                		<li><span id="s42" onclick="sizeC('42')" class='orderText2 '>42</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_size,'43')>-1}">
	                		<li><span id="s43" onclick="sizeC('43')" class='orderText2 '>43</span></li>
	                	</c:if>
	                	<c:if test="${fn:indexOf(good.good_size,'44')>-1}">
	                		<li><span id="s44" onclick="sizeC('44')" class='orderText2 '>44</span></li>
	                	</c:if>
	                </ul>
	            </div>
	            <div class="orderRow">
	            	<span class="orderText1">已选：</span>
	                <ul class="floatLeftUl">
	                	<li><span id="colorS" class='orderText5 '></span></li>
	                	<li><span id="sizeS" class='orderText5 '></span></li>
	                </ul>
	            </div>
	            <div class="orderRow">
	            	<span class="orderText1">售价:</span>
	                <span class="orderPrace">${good.good_price }</span>
	                <a href="javascript:void(0);"><span onclick="orderJoinC()" class="orderJoin">加入购物车</span></a>
	                <a href="javascript:void(0);"><span onclick="orderBuyC()" class="orderBuy">立即购买</span></a>
	            </div>
	            <div class="clear"></div>
	        </div>
        </form>
        <div>
        	<div class="floatLeft"><img class="orderImg" src="${good.good_pic }"></div>
            <div class="floatLeft orderInfoStatic">
                <div class="orderRow">
                    <span class="orderText1">品名：</span>
                    <span class="orderText3">${good.good_name }</span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">品牌：</span>
                    <span class="orderText3">${good.good_type }</span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">销量：</span>
                    <span class="orderText3">${good.good_count }</span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">简介：</span>
                    <span class="orderText4">${good.good_desc }</span>
                </div>
            </div>
            <div class="clear"></div>
        </div>
	</div>
  </body>
</html>
