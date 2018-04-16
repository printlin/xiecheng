<%@ page language="java" contentType="text/html; charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>修改密码页面</title>
<style type="text/css">

table{ border: 1px solid black;width: 50%}
td{ border: 1px solid black;}
input[type="password"]{
		width: 49%;
		height: 20px;
		font-size: 12px;
		line-height: 20px;
}
.tdfirst{ background-image: url("images/table_title_mid.gif");background-repeat: repeat-x;}

.password .sbmt{
	width: 80px;
    height: 30px;
    border: 0;
    display: inline-block;
    overflow: hidden;
    vertical-align: middle;
    line-height: 30px;
    font-size: 16px;
    font-weight: 700;
    color: #fff;
    background: #1d80cf;
    border-radius: 3px;
    cursor: pointer;
    zoom: 1;
    margin: 10px 10px;
</style>
<script type="text/javascript">
	function checkPwd(){
	
	console.log("测试");
	var u_pwd = document.getElementById("u_pwd");
	var new_u_pwd = document.getElementById("new_u_pwd");
	var qpassword = document.getElementById("qpassword");
	console.log(u_pwd.value);
	if(new_u_pwd.value==u_pwd.value){
		alert("不能与原密码一致");
		return;
	}
	
	if(new_u_pwd.value.length<6){
		alert("新密码长度不能小于6");
		return;
	}
	
	if(new_u_pwd.value!=qpassword.value){
		alert("密码不一致");
		return;
	}
	
	document.changePwd.submit();
	
	
	
}
</script>
</head>
<body>
    
	<div class="password">
     	<form action="ChangePwdServlet" method="post" name="changePwd">
     			<table>
	     			<tr>
	     				<td class="tdfirst" colspan="2">密码修改</td>
	     			</tr>
     				<tr>
     					<td>原密码：</td>
					  	<td><input type="password" name="u_pwd" id="u_pwd"/></td>
					</tr>
					<tr>
						<td>新密码：</td>
					  	<td><input type="password" name="new_u_pwd" id="new_u_pwd"/></td>
					</tr>
					<tr>
						<td>确认密码：</td>
					  	<td><input type="password" name="qpassword" id="qpassword"/></td>
					</tr>
					<tr>
						<td colspan="2" align="center"><input type="button" class="sbmt" value="提交" onclick="checkPwd()"/></td>
					</tr>
				</table>
     	</form>
				
     </div>

</body>


</html>