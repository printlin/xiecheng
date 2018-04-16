/*新闻网菜单栏js代码*/
function changeCon(){
	document.getElementById("password").style.display="block";
	document.getElementById("newsmanage").style.display="none";
	document.getElementById("usermanage").style.display="none";
	document.getElementById("querynews").style.display="none";
	document.getElementById("pwenzi").style.color="red";
	document.getElementById("fwenzi").style.color="black";
	document.getElementById("uwenzi").style.color="black";
	document.getElementById("qwenzi").style.color="black";
}
function changeCon1(){
	document.getElementById("password").style.display="none";
	document.getElementById("newsmanage").style.display="block";
	document.getElementById("usermanage").style.display="none";
	document.getElementById("querynews").style.display="none";
	document.getElementById("fwenzi").style.color="red";
	document.getElementById("pwenzi").style.color="black";
	document.getElementById("uwenzi").style.color="black";
	document.getElementById("qwenzi").style.color="black";
}
function changeCon2(){
	document.getElementById("password").style.display="none";
	document.getElementById("newsmanage").style.display="none";
	document.getElementById("usermanage").style.display="block";
	document.getElementById("querynews").style.display="none";
	document.getElementById("uwenzi").style.color="red";
	document.getElementById("pwenzi").style.color="black";
	document.getElementById("fwenzi").style.color="black";
	document.getElementById("qwenzi").style.color="black";
}
function changeCon3(){
	document.getElementById("password").style.display="none";
	document.getElementById("newsmanage").style.display="none";
	document.getElementById("usermanage").style.display="none";
	document.getElementById("querynews").style.display="block";
	document.getElementById("qwenzi").style.color="red";
	document.getElementById("pwenzi").style.color="black";
	document.getElementById("fwenzi").style.color="black";
	document.getElementById("uwenzi").style.color="black";
}
/*新闻网菜单栏js代码end*/
/*登录*/
function changeBg(){
	document.getElementById("logincontent").style.display="block";
	document.getElementById("rcontent").style.display="none";
	document.getElementById("login").style.color="red";
	document.getElementById("register").style.color="silver";

}
function changeBg1(){
	document.getElementById("rcontent").style.display="block";
	document.getElementById("logincontent").style.display="none";
	document.getElementById("register").style.color="red";
	document.getElementById("login").style.color="silver";
}
/*登录end*/
/*验证*/
function checkReg(){
	
	//console.log("测试");
	
	var username = document.getElementById("username");
	var password = document.getElementById("password");
	var repassword = document.getElementById("repassword");
	
	if(username.value==null||username.value==""){
		alert("用户名不能为空");
		return;
	}
	
	if(password.value.length<6){
		alert("密码长度不能小于6");
		return;
	}
	
	if(password.value!=repassword.value){
		alert("密码不一致");
		return;
	}
	
	document.registerForm.submit();

}
/*验证 end*/