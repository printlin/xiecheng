function timeGo(){  //获取，并显示时间
	var  myDate = new  Date(); //时间对象
	var  nian  =  myDate.getFullYear();
	var  yue = myDate.getMonth()+1 ; //月份+1
	var  rq = myDate.getDate();
	var  xq = myDate.getDay();   // 0 - 6	
	var  xqArr = ["日","一","二","三","四","五","六"];	 
	   //  xq      0     1    2    3   4   5   6 
				  
	var  shi = myDate.getHours();
	     if(shi<10){
			    shi = "0" + shi; 
			} 
	var  fen = myDate.getMinutes();
	     fen<10 ? fen="0"+fen : fen ;
	
	var  miao = myDate.getSeconds();
	     ( miao<10 )&&( miao="0"+miao );
	
	var  result = nian+"年"
	             +yue+"月"
				 +rq+"日"
				 +"&nbsp;星期"+  xqArr[xq] +"&nbsp;"
				 +shi+":"+fen+":"+miao;
	//显示时间
	document.getElementById("showtime").innerHTML = result;
  }
  //时间走动
  var  mySet = setInterval(function(){
	      timeGo();
	  },1000);
