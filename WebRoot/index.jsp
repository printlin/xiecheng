<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>首页</title>
<link rel="stylesheet" type="text/css" href="css/website_base.css">
<link rel="stylesheet" type="text/css" href="css/banner.css">
<link rel="stylesheet" type="text/css" href="css/index.css">
<link rel="stylesheet" type="text/css" href="css/reveal.css">
<link rel="stylesheet" type="text/css" href="css/head.css">
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/banner.js"></script>
<script src="js/jquery.reveal.js"></script>
<script type="text/javascript">
var allPage=${allPage};
	function searchC(){
		$("#pageI").val('1');
		indexForm.submit();
	}
	function sizeC(size){
		$("#pageI").val('1');
		$("#sizeI").val(size);
		indexForm.submit();
	}
	function pageC(page){
		if(page>0 && page<=allPage){
			$("#pageI").val(page);
			indexForm.submit();
		}
	}
	function colorC(color){
		$("#pageI").val('1');
		$("#colorI").val(color);
		indexForm.submit();
	}
	function good_typeC(good_type){
		$("#pageI").val('1');
		$("#good_typeI").val(good_type);
		indexForm.submit();
	}
</script>

</head>

<body>
	
    <jsp:include page="head.jsp"></jsp:include>
    
	<div class="banner_big" id="banner_big">
        <div class="banner tupian_show" id="tupian_show">
            <a id="banner_left" href="javascript:void(0)" class="banner_left"><img src="images/banner_left.png" width="80" height="84" alt=""></a>
            <a id="banner_right" href="javascript:void(0)" class="banner_right"><img src="images/banner_right.png"  width="80" height="84" alt=""></a>
            <ul>
                <li><a href="javascript:void(0);" style="background-image:url(images/banner1.jpg);"></a></li>
                <li><a href="javascript:void(0);" style="background-image:url(images/banner2.jpg);"></a></li>
                <li><a href="javascript:void(0);" style="background-image:url(images/banner3.jpg);"></a></li>
                <li><a href="javascript:void(0);" style="background-image:url(images/banner4.jpg);"></a></li>
            </ul>
        </div>
    </div>
    
    <form name="indexForm" action="servlet/IndexServlet" method="post">
    	<input id="colorI" type="hidden" name="color" value="${color }">
    	<input id="pageI" type="hidden" name="page" value="${page }">
    	<input id="sizeI" type="hidden" name="size" value="${size }">
    	<input id="good_typeI" type="hidden" name="good_type" value="${good_type }">
	    <div class="search">
	    	<div class="searchBack">
		        <input class="searchIn" type="text" name="good_name" placeholder="请输入搜索内容"/>
		        <img onclick="searchC()" class="searchImg" src="images/static/ss_2.png"/>
	        </div>
	    </div>
	    
	
	    <div class="screen">
	        <div class="screenRow">
	            <span>品牌：</span>
	            <ul class="floatLeftUl">
	            	<li>
	                    <span onclick="good_typeC('')" class="screenText1">全部</span>
	                </li>
	                <li>
	                    <span onclick="good_typeC('耐克')" class="screenText1">耐克</span>
	                </li>
	                <li>
	                    <span onclick="good_typeC('阿迪达斯')" class="screenText1">阿迪达斯</span>
	                </li>
	                <li>
	                    <span onclick="good_typeC('安踏')" class="screenText1">安踏</span>
	                </li>
	                <li>
	                    <span onclick="good_typeC('乔丹')" class="screenText1">乔丹</span>
	                </li>
	            </ul>
	        </div>
	        <div class="screenRow">
	            <span>颜色：</span>
	            <ul class="floatLeftUl">
	            	<li>
	                    <span onclick="colorC('')" class="screenText1">全部</span>
	                </li>
	                <li>
	                    <span onclick="colorC('白色')" class="screenText1">白色</span>
	                </li>
	                <li>
	                    <span onclick="colorC('黑色')" class="screenText1">黑色</span>
	                </li>
	                <li>
	                    <span onclick="colorC('红色')" class="screenText1">红色</span>
	                </li>
	                <li>
	                    <span onclick="colorC('黄色')" class="screenText1">黄色</span>
	                </li>
	                <li>
	                    <span onclick="colorC('绿色')" class="screenText1">绿色</span>
	                </li>
	                <li>
	                    <span onclick="colorC('蓝色')" class="screenText1">蓝色</span>
	                </li>
	                <li>
	                    <span onclick="colorC('粉色')" class="screenText1">粉色</span>
	                </li>
	            </ul>
	        </div>
	        <div class="screenRow">
	            <span>尺寸：</span>
	            <ul class="floatLeftUl">
	            	<li>
	                    <span onclick="sizeC('')" class="screenText1">全部</span>
	                </li>
	                <li>
	                    <span onclick="sizeC('37')" class="screenText1">37</span>
	                </li>
	                <li>
	                    <span onclick="sizeC('38')" class="screenText1">38</span>
	                </li>
	                <li>
	                    <span onclick="sizeC('39')" class="screenText1">39</span>
	                </li>
	                <li>
	                    <span onclick="sizeC('40')" class="screenText1">40</span>
	                </li>
	                <li>
	                    <span onclick="sizeC('41')" class="screenText1">41</span>
	                </li>
	                <li>
	                    <span onclick="sizeC('42')" class="screenText1">42</span>
	                </li>
	                <li>
	                    <span onclick="sizeC('43')" class="screenText1">43</span>
	                </li>
	                <li>
	                    <span onclick="sizeC('44')" class="screenText1">44</span>
	                </li>
	            </ul>
	        </div>
	        <div class="screenRow">
	            <span>筛选：</span>
	            <ul class="floatLeftUl">
	            	<c:if test="${type!=null }">
	            		<li><span class="screenText2">${type }</span></li>
	            	</c:if>
	            	<c:if test="${color!=null }">
	            		<li><span class="screenText2">${color }</span></li>
	            	</c:if>
	            	<c:if test="${size!=null }">
	            		<li><span class="screenText2">${size }</span></li>
	            	</c:if>
	            </ul>
	        </div>
	        <div class="clears"></div>
	    </div>
	
	    
	    <div class="content">
	    	<div>
	        	<span class="titleText">商品列表</span>
	            <hr style="width:1190px;margin-bottom:10px;">
	        </div>
	    	<ul>
	    		<c:forEach var="good" items="${goods}">
	        	<li class="cntLi">
	            	<!--  a class="cntA" href="javascript:void(0);" good_id="${good.good_id}" data-reveal-id="myModal"-->
	                <a class="cntA" href="servlet/GoodServlet?good_id=${good.good_id }">
	                	<img class="cntImg" src="${good.good_pic }" width="290" height="300" alt="商品图片"/>
	                    <div class="cntBack"></div>
	                    <div class="cntText1"><span>${good.good_name }</span></div>
	                    <div class="cntText2"><span>${good.good_price }</span></div>
	                    <div class="cntText3"><span>To Buy</span></div>
	                </a>
	            </li>
	            </c:forEach>
	        </ul>
	        <div class="clear"></div>
	    </div>
	    
	    <div class="page">
	    	<div class="pageAll">
	        	<div class="pageBlock">
	            	<a class="pageA pageDivA" onclick="pageC(${page-1})" href="javascript:void(0);">上一页</a>
	            </div>
	            <div class="pageBlock">
	            	<a class="pageA pageDivA" onclick="pageC(${page+1})" href="javascript:void(0);">下一页</a>
	            </div>
	            <div class="clear"></div>
	        </div>
	    </div>
    </form>

    
    <div id="myModal" class="reveal-modal" style="top: 100px; opacity: 1; visibility: hidden;">
        <div class="orderTitle">请填写订单信息</div>
        <div class="orderInfo">
        	<div class="orderRow">
            	<span class="orderText1">颜色：</span>
                <ul class="floatLeftUl">
                	<li><span id="bais" class="orderText2 noShow">白色</span></li>
                    <li><span id="heis" class="orderText2 noShow">黑色</span></li>
                    <li><span id="hongs" class="orderText2 noShow">红色</span></li>
                    <li><span id="huangs" class="orderText2 noShow">黄色</span></li>
                    <li><span id="lvs" class="orderText2 noShow">绿色</span></li>
                    <li><span id="lans" class="orderText2 noShow">蓝色</span></li>
                    <li><span id="fengs" class="orderText2 noShow">粉色</span></li>
                </ul>
            </div>
            <div class="orderRow">
            	<span class="orderText1">尺寸：</span>
                <ul class="floatLeftUl">
                	<li><span id="s37" class="orderText2 noShow">37</span></li>
                    <li><span id="s38" class="orderText2 noShow">38</span></li>
                    <li><span id="s39" class="orderText2 noShow">39</span></li>
                    <li><span id="s40" class="orderText2 noShow">40</span></li>
                    <li><span id="s41" class="orderText2 noShow">41</span></li>
                    <li><span id="s42" class="orderText2 noShow">42</span></li>
                    <li><span id="s43" class="orderText2 noShow">43</span></li>
                    <li><span id="s44" class="orderText2 noShow">44</span></li>
                </ul>
            </div>
            <div class="orderRow">
            	<span class="orderText1">售价:</span>
                <span id="good_prace" class="orderPrace"></span>
                <a href="shoppingCart.jsp"><span class="orderJoin">加入购物车</span></a>
                <a href="pay.jsp"><span class="orderBuy">立即购买</span></a>
            </div>
            <div class="clear"></div>
        </div>
        <div>
        	<div class="floatLeft"><img class="orderImg" src="images/static/lizi1.jpg"></div>
            <div class="floatLeft orderInfoStatic">
                <div class="orderRow">
                    <span class="orderText1">品名：</span>
                    <span id="good_name" class="orderText3"></span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">品牌：</span>
                    <span id="good_type" class="orderText3"></span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">销量：</span>
                    <span id="good_count" class="orderText3"></span>
                </div>
                <div class="orderRow">
                    <span class="orderText1">简介：</span>
                    <span id="good_desc" class="orderText4"></span>
                </div>
            </div>
            <div class="clear"></div>
        </div>
        
        <a class="close-reveal-modal">×</a>
	</div>
    
    
    <jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>