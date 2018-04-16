<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户查询页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

<style type="text/css">
	table{ border: 1px solid black;width: 99%}
	td{ border: 1px solid black;}
	
	.tdlast{text-align: center;padding: 10px 0}
	.tdfirst{ background-image: url("img/table_title_mid.gif");background-repeat: repeat-x;}
</style>
<script type="text/javascript">
	function del(){
		var msg="你真的要删除吗？\n\n请确认！"
		if(true==confirm(msg)){
		return true;
		}else{
		return false;
		}
}
</script>
  </head>
  
  <body>
  	<div>
	<table>
		<tr>
			<td colspan="4" class="tdfirst">查询用户</td>
		</tr>
		<tr>
			<td>
				<form name="conditionForm" action="root/QueryUserServlet" method="post">
					用户名：<input type="text" name="username"/>
					性别：
					<select name="u_gender">
						<option value=""></option>
						<option value="男">男</option>
						<option value="女">女</option>
					</select>
					<input type="submit" value="搜索">
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td>用户Id</td>
						<td>用户名</td>
						<td>性别</td>
						<td>电话</td>
						<td>余额</td>
						<td>操作</td>
					</tr>
					
					<c:forEach items="${goodsList }" var="user">
					<tr>
						<td>${user.u_id }</td>
						<td>${user.username }</td>
						<td>${user.u_gender }</td>
						<td>${user.u_num }</td>
						<td>${user.u_money }</td>
						<td>
							<a href="root/UserDetailServlet?u_id=${user.u_id }">查看</a>
							<a href="root/DeleteUserServlet?u_id=${user.u_id } "onclick="return del()">删除</a>
						</td>
					</tr>
					</c:forEach>
				</table>
				共${pageCount}页,当前第${page}页
				<c:choose>
					<c:when test="${page==1||page==0}">
						首页
					</c:when>
					<c:otherwise>
						<a href="root/QueryUserServlet?page=1&&username=${username}&&u_gender=${u_gender}">首页</a>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${page-1==0||page==0 }">
						上一页
					</c:when>
					<c:otherwise>
						<a href="root/QueryUserServlet?page=${page-1}&&username=${username}&&u_gender=${u_gender}">上一页</a>
					</c:otherwise>
				</c:choose>
				
				<c:choose>
					<c:when test="${page+1>pageCount}">
						下一页
					</c:when>
					<c:otherwise>
						<a href="root/QueryUserServlet?page=${page+1}&&username=${username}&&u_gender=${u_gender}">下一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page==pageCount }">
						尾页
					</c:when>
					<c:otherwise>
						<a href="root/QueryUserServlet?page=${pageCount}&&username=${useranme}&&u_gender=${u_gender}">尾页</a>
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
	</table>
	</div>
  </body>
</html>

