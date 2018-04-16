var contextPath=document.location.pathname.substr(0,document.location.pathname.substr(1).indexOf("/")+1);

$(document).ready(function(){//处理事件
	$("#username").blur(function(){
		post("username");
	});
	$("#password").blur(function(){
		post("password");
	});
	$("#chackCode").blur(function(){
		post("chackCode");
	});
	$("#button").click(function(){
		$.post(contextPath+"/servlet/LoginServlet",
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
	$.post(contextPath+"/servlet/LoginServlet",
    	{
    		username:$("#username").val(),
    		password:$("#password").val(),
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
		if(json.sucess=='管理员'){
			window.location.href="root/index.jsp"; 
		}else{
			window.location.href="jumpIndex.jsp"; 
		}
		
		/*if(json.oldURL!=null){
			window.location.href="./"+json.oldURL; 
		}else{
			window.location.href="./servlet/HomeServlet?place=all&page=1"; 
		}*/
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
		
		if(who=="chackCode"){
			if(json.chackCode!=null){
				$("#chackCodeMes").text(json.chackCode);
			}else{
				$("#chackCodeMes").text("");
			}
		}
		
		if(json.addErrorMes!=null){
			$("#loginErrorMes").text(json.addErrorMes);
		}else{
			$("#loginErrorMes").text("");
		}
	}
}
