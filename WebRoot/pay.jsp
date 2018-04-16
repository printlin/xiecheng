<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>鞋程网支付页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<link rel="stylesheet" type="text/css" href="css/pay.css">
<link rel="stylesheet" type="text/css" href="css/head.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript">
	function pay(){
		if($("#name").val()==""  || $("#name").val()==null || $("#name").val()=="undefined"){
			alert("未填写收货人");
			return;
		}
		if($("#phone").val()==""  || $("#phone").val()==null || $("#phone").val()=="undefined"){
			alert("未填写电话");
			return;
		}
		if($("#add").val()==""  || $("#add").val()==null || $("#add").val()=="undefined"){
			alert("未填写收货地址");
			return;
		}
		$("#form1").submit();
	}
</script>
</head>

<body>
	<jsp:include page="head.jsp"></jsp:include>
    <form id="form1" action="${pageContext.request.contextPath }/servlet/PayServlet" method="post">
	    <input type="hidden" name="ord_id" value="${order.ord_id }">
	    <div class="payInfo">
	    	<div class="row">
	        	<span class="text2">收货人：</span>
	            <input id="name" class="inp1" type="text" name="ord_u_name" value="${user.u_name }"/>
	        </div>
	        <div class="row">
	        	<span class="text2">电话号码：</span>
	            <input id="phone" class="inp1" type="text" name="ord_u_phone" value="${user.u_num }"/>
	        </div>
	        <div class="row">
	        	<span class="text2">收货地址：</span>
	            <input id="add" class="inp1" type="text" name="ord_u_add" value="${user.u_address }"/>
	        </div>
	    </div>
		<div class="payAll">
	    	<div class="payAA">
	        	<span class="text1">支付密码：</span>
	        	<input class="inp" type="password" name="payPass"/>
	            <span onclick="pay()" class="pay">确认支付</span>
	        </div>
	    </div>
    </form>
    <jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>
