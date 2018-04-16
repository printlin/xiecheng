<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'updateGoods.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
     <form action="root/UpdateGoodsServlet" method="post" name="addGoodsForm">
     <input type="hidden" name='good_id' value="${g.good_id }">
	<div>
		<table>
		<tr>
			<td colspan="4" class="tdfirst">修改商品</td>
		</tr>
		<tr>
			<td>名称</td>
			<td colspan="3"><input type="text" name="good_name" id="good_name" value="${g.good_name}"/></td>
		</tr>
		<tr>
			<td>价格</td>
			<td colspan="3"><input type="text" name="good_price" id="good_price" value="${g.good_price}"/></td>
		</tr>
		<tr>
			<td>颜色</td>
			<td colspan="3"><input type="text" name="good_color" id="good_color" value="${g.good_color}"/></td>
		</tr>
		<tr>
		<tr>
			<td>大小</td>
			<td colspan="3"><input type="text" name="good_size" id="good_size" value="${g.good_size}"/></td>
		</tr>
		<tr>
			<td>品牌</td>
			<td colspan="3"><input type="text" name="good_type" id="good_type" value="${g.good_type}"/></td>
		</tr>
		<tr>
			<td>数量</td>
			<td colspan="3"><input type="text" name="good_count" id="good_count" value="${g.good_count}"/></td>
		</tr>
		<tr>
			<td>图片</td>
			<td colspan="3"><input type="text" name="good_pic" id="good_pic" value="${g.good_pic}"/></td>
		</tr>
	
		<tr>
			<td>简介</td>
			<td colspan="3">
				<textarea name="good_desc" id="good_desc" style="width:100%;height:250px;">${g.good_desc }</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="tdlast">
				<input type="submit" value="修改"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
		</table>
		
	</div>
	</form>
  </body>
</html>
