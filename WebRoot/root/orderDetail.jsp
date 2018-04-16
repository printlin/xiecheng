<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'userDetail.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
<style type="text/css">
	table,td{ border: 1px solid black}
	input[type='text'],select,textarea{width: 99%}
	.tdlast{text-align: center;padding: 10px 0}
	.tdfirst{ background-image: url("img/table_title_mid.gif");background-repeat: repeat-x;}
</style>
  </head>
  
  <body>
	<div>
	<table>
		<tr>
			<td colspan="4" class="tdfirst">订单详情</td>
		</tr>
		<tr>
			<td>订单ID</td>
			<td colspan="3">
				${ord_id}
			</td>
		</tr>
	
		<tr>
			<td>收货人姓名</td>
			<td colspan="3">
				${ord_u_name}
			</td>
		</tr>
		<tr>
			<td>收货地址</td>
			<td colspan="3">
				${ord_u_add}
			</td>
		</tr>
		<tr>
			<td>订单价格</td>
			<td colspan="3">
				${ord_price}
			</td>
		</tr>
			<tr>
			<td>订单类别</td>
			<td colspan="3">
				${ord_type}
			</td>
		</tr>
		</tr>
			<tr>
			<td>订单日期</td>
			<td colspan="3">
				${ord_date}
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="root/QueryOrderServlet">返回</a>
			</td>
		</tr>
		
	</table>
	</div>
  </body>
</html>
