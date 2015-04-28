<html>
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>菜品种类</title>
<script  src = "jquery.js"></script>
<link rel="stylesheet" href="myCss/category.css">

<link rel="stylesheet" href="wookmark/reset.css">
<link rel="stylesheet" href="wookmark/main.css">
<script src="wookmark/jquery.imagesloaded.js"></script>
<script src="wookmark/jquery.wookmark.js"></script>
<script src="myJs/category.js"></script>
<style>	 
</style>

<script>
</script>
</head>

<body>
<table class="headBar">
	  <tr>
		<th>菜单</th>
	  </tr>
</table>

<div id="mainContent">
	  <ul id="tiles">
		<!-- li>
			<img src="newImages/1.jpg">
			<div>
				新品推荐
			</div>
		</li-->
		${cgPart}
	  </ul>
</div>


<!--填充用div-->
<div class="holdPlace"></div>

<!--底部导航条-->
<table class="navBar">
  <tr>
   	<th><a href="/"><img src = "icon/首页.png"></a><p>首 页</p></th>
    <th><img src = "icon/全部菜单-active.png"><p>全部菜单</p></th>
	<th><a href="/myDish"><img src = "icon/我的菜.png"></a><p>我的菜</p></th>
  </tr>
</table>

</body>
</html>
