<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品查询页面</title>
<style type="text/css">
	table{ border: 1px solid black;width: 99%}
	td{ border: 1px solid black;}
	
	.tdlast{text-align: center;padding: 10px 0}
	.tdfirst{ background-image: url("images/table_title_mid.gif");background-repeat: repeat-x;}
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
			<td colspan="4" class="tdfirst">查看商品</td>
		</tr>
		<tr>
			<td>
				<form name="conditionForm" action="QueryGoodsServlet" method="post">
					商品名称:<input type="text" name="good_name"/>
					商品品牌:<input type="text" name="good_type"/>
					<input type="submit" value="提交">
				</form>
			</td>
		</tr>
		<tr>
			<td>
				<table>
					<tr>
						<td>商品标号</td>
						<td>商品名称</td>
						<td>商品品牌</td>
						<td>商品数量</td>
						<td>操作</td>
					</tr>
					<c:forEach items="${goodsList}" var="g">
					<tr>
						<td>${g.good_id }</td>
						<td >${g.good_name }</td>
						<td>${g.good_type }</td>
						<td>${g.good_count}</td>
						<td>
							<a href="GoodsDetailServlet?good_id=${g.good_id }">查看</a>	
							<a href="UpdateGoodsServlet?good_id=${g.good_id}&type=show">修改</a>
							<a href="DeleteGoodsServlet?good_id=${g.good_id }">删除</a>	
						</td>
					</tr>
					</c:forEach>
				</table>
				共${pageCount}页,当前第${page}页
				<c:choose>
					<c:when test="${page==1}">
						首页
					</c:when>
					<c:otherwise>
						<a href="QueryGoodsServlet?page=1&&good_name=${good_name}&&good_type=${good_type}">首页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page-1==0 }">
						上一页
					</c:when>
					<c:otherwise>
						<a href="QueryGoodsServlet?page=${page-1}&&good_name=${good_name}&&good_type=${good_type}">上一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page+1>pageCount}">
						下一页
					</c:when>
					<c:otherwise>
						<a href="QueryGoodsServlet?page=${page+1}&&good_name=${good_name}&&good_type=${good_type}">下一页</a>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${page==pageCount }">
						尾页
					</c:when>
					<c:otherwise>
						<a href="QueryGoodsServlet?page=${pageCount}&&good_name=${good_name}&&good_type=${good_type}">尾页</a>
					</c:otherwise>
				</c:choose>
				
			</td>
		</tr>
	</table>
	</div>
</body>


</html>