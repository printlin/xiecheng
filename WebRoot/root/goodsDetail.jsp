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
			<td colspan="4" class="tdfirst">商品详情</td>
		</tr>
		<tr>
			<td>商品名</td>
			<td colspan="3">
				${good_name}
			</td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td colspan="3">
				${good_price}
			</td>
		</tr>
		<tr>
			<td>商品数量</td>
			<td colspan="3">
				${good_count}
			</td>
		</tr>
		<tr>
			<td>商品大小</td>
			<td colspan="3">
				${good_size}
			</td>
		</tr>
		<tr>
			<td>商品颜色</td>
			<td colspan="3">
				${good_color}
			</td>
		</tr>
		<tr>
			<td>品牌</td>
			<td colspan="3">
				${good_type}
			</td>
		</tr>
		<tr>
			<td>商品简介</td>
			<td colspan="3">
				${good_desc}
			</td>
		</tr>
		<tr>
			<td>商品图片</td>
			<td colspan="3">
				<img width="300px" height="300px" src="${good_pic}">
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="root/QueryGoodsServlet">返回</a>
			</td>
		</tr>
		
	</table>
	</div>
  </body>
</html>
