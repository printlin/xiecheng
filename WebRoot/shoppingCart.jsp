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
    
    <title>鞋程网购物车</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="stylesheet" type="text/css" href="css/shoppingCart.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	var count=0;
	function payClick(){
		if(parseFloat($("#allPrice").html())<=0){
			alert("未选择商品");
			return;
		}
		$("#priceAI").val($("#allPrice").html());
		$("#countI").val(count);
		$("#form1").submit();
	}
	function clickRow(id,price){
		var who=$("#s"+id);
		var boolean=who.attr('boolean');
		if(boolean=='false'){
			$("#I"+id).val("true-"+id);
			who.attr('boolean','true');
			who.addClass('clicked');
			var allp=parseFloat($("#allPrice").html());
			var p=parseFloat(price);
			count=count+1;
			$("#allPrice").html(allp+p);
		}else{
			$("#I"+id).val("false-"+id);
			who.attr('boolean','false');
			who.removeClass('clicked');
			var allp=parseFloat($("#allPrice").html());
			var p=parseFloat(price);
			count=count-1;
			$("#allPrice").html(allp-p);
		}
	}
</script>
</head>

<body>
<jsp:include page="head.jsp"></jsp:include>
	<form id="form1" action="${pageContext.request.contextPath }/servlet/ShoppingCartDoServlet" method="post">
		<input id="countI" type="hidden" name="count">
		<input id="priceAI" type="hidden" name="priceA">
		<div class="shoppingCart">
	    	<div>
	        	<span class="titleText">购物车</span>
	            <hr style="width:1190px;margin-bottom:10px;">
	        </div>
	        <div>
	        	<ul class="spUl">
	        		<c:forEach var="good" items="${list }">
		        		<li>
		                	<a boolean="false" id="s${good.shop_id}" onclick="clickRow('${good.shop_id}','${good.good_price }')" class="spRow" href="javascript:void(0);">
		                    	<input id="I${good.shop_id }" type="hidden" name="id-${good.shop_id }">
		                    	<img class="spRowImg" src="${good.good_pic }"/>
		                        <div class="spRowRow">
		                            <span class="spText1">名称：</span>
		                            <span class="spText2">${good.good_name }</span>
		                        </div>
		                        <div class="spRowRow">
		                            <span class="spText1">颜色：</span>
		                            <span class="spText2">${good.good_color }</span>
		                        </div>
		                        <div class="spRowRow">
		                            <span class="spText1">大小：</span>
		                            <span class="spText2">${good.good_size }</span>
		                        </div>
		                        <div class="spRowRow">
		                            <span class="spText1">数量：</span>
		                            <span class="spText2">×${good.good_count }</span>
		                        </div>
		                        <div class="spRowRow">
		                            <span class="spText1">价格：</span>
		                            <span class="spText2">${good.good_price }</span>
		                        </div>
		                        
		                    </a>
		                </li>
	        		</c:forEach>
	            </ul>
	        </div>
	        <div class="spPay">
	        	<a href="javascript:void(0);"><span id="payButtom" onclick="payClick()" class="spPayButtom">立即付款</span></a>
	        	<samp id="allPrice" class="spPayMoney">0.00</samp>
	        </div>
	    </div>
    </form>
    <jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>