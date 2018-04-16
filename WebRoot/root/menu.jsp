<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
<script type="text/javascript">
	
</script>
</head>
<body>
	<ul>
		<li><a href="changePwd.jsp" target="content">密码修改</a></li>
		<li>
			<span>商品管理</span>
			<ul>
				<li><a href="addGoods.jsp" target="content">添加商品</a></li>
				<li><a href="QueryGoodsServlet" target="content">商品查询</a></li>
			</ul>
		</li>
			<li>
				<span>用户管理</span>
				<ul>
					<li><a href="addUser.jsp" target="content">新增用户</a></li>
					<li><a href="QueryUserServlet" target="content">用户查询</a></li>
				</ul>
			</li>
			</li>
			<li>
				<span>订单管理</span>
				<ul>
					<li><a href="QueryOrderServlet" target="content">订单查询</a></li>
				</ul>
			</li>
	</ul>
</body>


</html>