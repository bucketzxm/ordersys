<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>付款成功</title>

<script  src = "jquery.js"></script>
<link rel="stylesheet" href="owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="owl-carousel/owl.theme.css">
<link rel="stylesheet" href="myCss/home.css">

<script src="owl-carousel/owl.carousel.js"></script>
<script src="myJs/cart.js"></script>
<script src="myJs/home.js"></script>

<style type="text/css">
</style>

</head>

<script src="jqm/jquery.js" type="text/javascript">
</script>

<script language="javascript">

$(document).ready( function(){
	
	function jump(count){
		window.setTimeout(function(){
			count -- ;
			if(count >0){
				$('#num').attr("innerHTML",count);
				jump(count);
			}else{
				location.href="/";
			}
		},1000);	
	}
	jump(3);
});

</script>

<body>  

	<div></div>
   	支付成功<br/>  
    3秒后自动跳转主页。当前还剩<span id="num">3</span>秒  
	
	<a href ="/">点我直接跳转</p>
	
	<!--填充用div-->
	<div class="holdPlace"></div>
	<!--底部导航条-->
	<table class="navBar">
	  <tr>
		<th><a href="/"><img src = "icon/首页.png"></a><p>首 页</p></th>
	    <th><a href="/category"><img src = "icon/全部菜单.png"></a><p>全部菜单</p></th>
		<th><img src = "icon/我的菜-active.png"><p>我的菜</p></th>
	  </tr>
	</table>
	
</body>  



</html>