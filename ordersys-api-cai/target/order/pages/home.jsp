<html>
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>优惠首页</title>
<script  src = "jquery.js"></script>
<link rel="stylesheet" href="owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="owl-carousel/owl.theme.css">
<link rel="stylesheet" href="myCss/home.css">

<script src="owl-carousel/owl.carousel.js"></script>
<script src="myJs/cart.js"></script>
<script src="myJs/home.js"></script>

<style type="text/css">
</style>

<script>
   $(function(){
	   
   });
</script>
</head>

<body>
<div class="mask"></div>
<div class="popWindow" align="center">
		<img src="icon/realLogo2.png">
		<div>welcome</div>
		<div>欢迎使用松鼠点餐系统</div>
		<hr/>

		请选择您的桌号
		<div class="sliderWrapper">
			<div id="deskSlider" class="owl-carousel owl-theme markSlider">
			  <div class="sliderBegin"></div>
			  <!--button>1</button>
			  <button>2</button>
			  <button>3</button-->
			  ${deskButtons}
			  <div class="sliderEnd"></div>
			</div> 
			<hr />
			<button class="focusCircle">
				1
			</button>
		</div>

		<div>
			请选择用餐人数
			<div class="sliderWrapper">
				<div id="personSlider" class="owl-carousel owl-theme markSlider">
				  <div class="sliderBegin"></div>
				  <button>1</button>
				  <button>2</button>
				  <button>3</button>
				  <button>4</button>
				  <button>5</button>
				  <button>6</button>
				  <button>7</button>
				  <button>8</button>
				  <button>9</button>
				  <button>10</button>
				  <button>11</button>
				  <button>12</button>
				  <button>13</button>
				  <button>14</button>
				  <button>15</button>
				  <div class="End"></div>
				</div> 
				<hr />
				<button class="focusCircle">
					1
				</button>
			</div>
		</div>

		<div id="startButton">
			开始点餐
		</div>
</div>

<div id="allWrapper">
<div class="wrapper">
	<!--单张的旋转木马-->
	<div id="owl-demo" class="owl-carouse1 owl-theme markCarousel">
	  <!--div class="item  beChoiced">
		<img src="newImages/big.png">
		<div class="description">
			<div>菜名菜名菜名1<span class="likeMark"><img src="icon/like-white.png">4.7</span></div>
			<div>抢购价  <spcialPrice>￥49.00</spcialPrice></div>	
		</div>
		<div class="addDish">
		   <button>1</button>
		   <button class="addButton">抢 购</button>
		</div>
	  </div-->
      ${aFavor}
	</div>
			
	<!--圆点导航条-->
	<div class='owl-theme' id="pointNavHolder"></div>
	<div class="demoMark">超低价抢购中</div>
</div>

<div class="wrapper">
	<!--第二排的旋转木马-->
	<div id="owl-recommend" class="markCarousel">
	  <!--div class="item beChoiced">
		<img src="newImages/炒年糕.jpg" />
		<div>
			<div>菜品1菜品1菜品1菜品1</div>
			<del>原价：99.00</del><br />
			现价：<strong>49.00</strong>
			<span class="likeMark"><img src="icon/like.png">4.7</span>
		</div>
		<button>1</button>
	  </div-->
	  ${bFavor}
	</div>
	
	<!--左右两个箭头-->
	<div id="leftArrowHolder">
		&lt;
	</div>
	<div id="rightArrowHolder">
		&gt;
	</div>
	<div class="recommendMark">优惠进行中</div>
</div>

<!--优惠信息-->
<div id = "discountInfo">
	<img src="icon/realLogo.png">
	<div>
		<strong>近期优惠</strong><br />
		<div>
		优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息
		</div>
	</div>
</div>

<!--底部导航条-->
<table class="navBar">
  <tr>
    <th><img src = "icon/首页-active.png"><p>首 页</p></th>
    <th><a href="/category"><img src = "icon/全部菜单.png"></a><p>全部菜单</p></th>
	<th><a href="/myDish"><img src = "icon/我的菜.png"></a><p>我的菜</p></th>
  </tr>
</table>
</div>
</body>
</html>
