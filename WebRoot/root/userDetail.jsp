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
			<td colspan="4" class="tdfirst">用户详情</td>
		</tr>
		<tr>
			<td>用户名</td>
			<td colspan="3">
				${username}
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td colspan="3">
				${u_gender}
			</td>
		</tr>
		<tr>
			<td>电话</td>
			<td colspan="3">
				${u_num}
			</td>
		</tr>
		<tr>
			<td>出生日期</td>
			<td colspan="3">
				${u_birth}
			</td>
		</tr>
		<tr>
			<td>收货人</td>
			<td colspan="3">
				${u_name}
			</td>
		</tr>
		<tr>
			<td>收货地址</td>
			<td colspan="3">
				${u_address}
			</td>
		</tr>
		<tr>
			<td>类型</td>
			<td colspan="3">
				${type}
			</td>
		</tr>
		<tr>
			<td>余额</td>
			<td colspan="3">
				${u_money}
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<a href="root/QueryUserServlet">返回</a>
			</td>
		</tr>
		
	</table>
	</div>
  </body>
</html>
