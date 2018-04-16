var contextPath=document.location.pathname.substr(0,document.location.pathname.substr(1).indexOf("/")+1);

$(document).ready(function(){//处理事件
	$("#username").blur(function(){
		post("username");
	});
	$("#password").blur(function(){
		post("password");
	});
	$("#repassword").blur(function(){
		if(!($("#password").val()==$("#repassword").val())){
			$("#repassword").val("");
			$("#repasswordMes").text("两次输入密码不一致");
		}
	});
	$("#chackCode").blur(function(){
		post("chackCode");
	});
	$("#button").click(function(){
		$.post(contextPath+"/servlet/RegisterServlet",
	    	{
	    		username:$("#username").val(),
	    		password:$("#password").val(),
	    		chackCode:$("#chackCode").val(),
	    		type:"submit"
	    	},
	    	function(data,status){
	    		showMes(data);
	    	}
	    );
	});
	$("#chackImg").click(function(){
		var time=new Date();
		$("#chackImg").attr("src",contextPath+"/servlet/ChackCode?time="+time.getTime());
	});
});
function post(who){//发送请求
	$.post(contextPath+"/servlet/RegisterServlet",
    	{
    		username:$("#username").val(),
    		password:$("#password").val(),
    		repassword:$("#repassword").val(),
    		chackCode:$("#chackCode").val()
    	},
    	function(data,status){
    		showMes(data,who);
    	}
    );
}
function showMes(data,who){//展示获得的数据
	var json=JSON.parse(data);
	if(json.sucess!=null){
		window.location.href="./login.jsp"; 
	}else{
		if(who=="username"){
			if(json.username!=null){
				$("#usernameMes").text(json.username);
			}else{
				$("#usernameMes").text("");
			}
		}
		
		
		if(who=="password"){
			if(json.password!=null){
				$("#passwordMes").text(json.password);
			}else{
				$("#passwordMes").text("");
			}
		}
		
		if(json.repassword!=null){
			$("#repasswordMes").text(json.repassword);
		}else{
			$("#repasswordMes").text("");
		}
		
		if(who=="chackCode"){
			if(json.chackCode!=null){
				$("#chackCodeMes").text(json.chackCode);
			}else{
				$("#chackCodeMes").text("");
			}
		}
		
		if(json.addErrorMes!=null){
			$("#addErrorMes").text(json.addErrorMes);
		}else{
			$("#addErrorMes").text("");
		}
	}
}
