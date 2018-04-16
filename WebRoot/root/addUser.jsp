<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>增加用户页面</title>
<style type="text/css">
	div{ margin: 100px auto 0; width: 550px}
	table,td{ border: 1px solid black}
	input[type='text'],select,textarea{width: 99%}
	.tdlast{text-align: center;padding: 10px 0}
	.tdfirst{ background-image: url("img/table_title_mid.gif");background-repeat: repeat-x;}
</style>
<script type="text/javascript">
	function checkReg(){
	
	//console.log("测试");
	var username = document.getElementById("username");
	var u_pwd = document.getElementById("u_pwd");
	var repassword = document.getElementById("repassword");
	
	if(username.value==null||username.value==""){
		alert("用户名不能为空");
		return;
	}
	
	if(u_pwd.value.length<6){
		alert("密码长度不能小于6");
		return;
	}
	
	if(u_pwd.value!=repassword.value){
		alert("密码不一致");
		return;
	}
	
	document.addUserForm.submit();
	
	
	
}
</script>


</head>
<body>
<form action="AddUserServlet" method="post" name="addUserForm">
	<div>
	<table>
		<tr>
			<td colspan="4" class="tdfirst">添加新用户</td>
		</tr>
		<tr>
			<td>用户名</td>
			<td colspan="3"><input type="text" name="username" id="username"/></td>
		</tr>
		<tr>
			<td>密码</td>
			<td><input type="password" name="u_pwd" id="u_pwd"/></td>
			<td>确认密码</td>
			<td><input type="password" name="repassword" id="repassword"/></td>
		</tr>
		<tr>
			<td>性别</td>
			<td>
				<input type="radio" name="u_gender" value="男" checked/>男
				<input type="radio" name="u_gender" value="女"/>女
			</td>
		<tr>
			<td colspan="4" class="tdlast">
				<input type="button" value="提交" onclick="checkReg()"/>
				<input type="reset" value="重置"/>
			</td>
		</tr>
	</table>
	</div>
	</form>
</body>


</html>
