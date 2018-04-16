<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品添加页面</title>
<style type="text/css">
table{ border: 1px solid black;width: 100%}
td{ border: 1px solid black}
input[type='text'],select,textarea{width: 99%}
.tdlast{text-align: center;padding: 10px 0}
.tdfirst{ background-image: url("images/table_title_mid.gif");background-repeat: repeat-x;}
</style>

</head>
<body>
<form action="AddGoodsServlet" method="post" name="addGoodsForm">
	<div>
		<table>
		<tr>
			<td colspan="4" class="tdfirst">发布商品</td>
		</tr>
		<tr>
			<td>商品名</td>
			<td colspan="3"><input type="text" name="good_name" id="good_name"/></td>
		</tr>
		<tr>
			<td>商品价格</td>
			<td colspan="3"><input type="text" name="good_price" id="good_price"/></td>
		</tr>
		<tr>
			<td>商品颜色</td>
			<td colspan="3"><input type="text" name="good_color" id="good_color"/></td>
		</tr>
		<tr>
		<tr>
			<td>商品大小</td>
			<td colspan="3"><input type="text" name="good_size" id="good_size"/></td>
		</tr>
		<tr>
			<td>商品品牌</td>
			<td colspan="3"><input type="text" name="good_type" id="good_type"/></td>
		</tr>
		<tr>
			<td>商品数量</td>
			<td colspan="3"><input type="text" name="good_count" id="good_count"/></td>
		</tr>
	
		<tr>
			<td>商品简介</td>
			<td colspan="3">
				<textarea name="good_desc" id="good_desc" style="width:100%;height:250px;"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" class="tdlast">
				<input type="submit" value="提交"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
		</table>
		
	</div>
	</form>
</body>


</html>