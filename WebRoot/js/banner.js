$(document).ready(function(e) {
    lunbo("#tupian_show");
});
function lunbo(obj){
	if($(obj).length<=0){ return null;}
	var lis =$(obj+">ul>li");
	var num =lis.length;
	var nowp = 0;
	var ps = document.createElement("p");
	var myset = null;
	var mytimeout = null;
	$(obj).append(ps);
	var k = 0 ;
	for(k=0; k<num ; k++){
			var spans = document.createElement("span");
			$(obj+">p").append(spans);
		}
	$(obj+">p>span").eq(nowp).addClass("on");
	lis.eq(nowp).css({zIndex:2}).fadeIn();
	
	myset=setInterval(function(){
			nowp++;
			(nowp>=num)&&(nowp = 0);
			moveBanner();
		},4000);
	
	function moveBanner(){
			$(obj+">p>span").removeClass("on").eq(nowp).addClass("on");
			lis.eq(nowp).siblings("li").fadeOut();
			lis.eq(nowp).fadeIn();
	}
	
	$(obj).hover(function(){
		 clearInterval(myset);
		},function(){
			myset=setInterval(function(){
				nowp++;
				(nowp>=num)&&(nowp = 0);
				moveBanner()
			},4000);
		});
	
	$(obj+">p>span").click(function(){
		   var nowp_t = $(this).index();
		   clearTimeout(mytimeout);
		   mytimeout = setTimeout(function(){ 
		   					 nowp = nowp_t ;
							 moveBanner()
			   },300);
		});
	$("#banner_left").on("click",function(){
		nowp--;
		(nowp<0)&&(nowp = num-1);
		moveBanner();
	});
	$("#banner_right").on("click",function(){
		nowp++;
		(nowp>=num)&&(nowp = 0);
		moveBanner();
	});
 }