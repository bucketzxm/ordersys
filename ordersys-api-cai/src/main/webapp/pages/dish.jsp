<html>
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>${cgName}</title>
<script src = "jquery.js"></script>
<link rel="stylesheet" href="myCss/dish.css">
<script src="myJs/cart.js"></script>
<script src="myJs/dish.js"></script>

<head>
<style>
</style>

<script>
</script>
</head>
<body>
	<table class="headBar">
	  <tr>
		<th>${cgName}</th>
	  </tr>
	</table>
	
	<div id="mainContent">
		<ul>
			<!-- li class="beChoiced">
				<img src="newImages/11.jpg">
				<h3>黄金鲍鱼</h3>
				<p>￥49.90<span class="likeMark"><img src="icon/like.png">4.7</span></p>
				<button>1</button>
				<div class="liMask"></div>
				<div class="soldOutMark">
					<h3><span>Sold Out</span>  售罄</h3>
				</div>
			</li -->
			${dishPart}
	     </ul>
	</div>

	<!--填充用div-->
	<div class="holdPlace">
	</div>

	<!--底部导航条-->
	<table class="navBar">
	  <tr>
		<th><a href="/"><img src = "icon/首页.png"></a><p>首 页</p></th>
	    <th><a href="/category"><img src = "icon/全部菜单.png"></a><p>全部菜单</p></th>
		<th><a href="/myDish"><img src = "icon/我的菜.png"></a><p>我的菜</p></th>
	  </tr>
	</table>
</body>
</html>
