<html>
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>菜品评价</title>
<script src = "jquery.js"></script>
<link rel="stylesheet" href="myCss/evaluate.css">
<script src = "myJs/evaluate.js"></script>
<style>
</style>

<script>
</script>
</head>

<body>
	<div class="mask"></div>
	<div class="popQuery">
		<img src="icon/realLogo.png" class="logo">
		<div>
			是否对用餐内容进行评价？
		</div>
		<table>
			<tr>
				<th>
					是
					<div class="thFocuseMark"></div>
					<div class="middleLine"></div>
				</th>
				<th>
					否
					<div class="thFocuseMark"></div>
				</th>
			</tr>
		</table>
	</div>

	<table class="headBar">
	  <tr>
		<th>口味评价</th>
	  </tr>
	</table>
	
	
	<div id="mainContent">
		<table>
		  <tr>
			<th>菜单<font>|</font></th>
			<th>评分</th>
		  </tr>

		  <!--tr>
			<td>
				<div></div>
				翡翠白玉汤
			</td>
			<td>
				<img src="icon/heart-white.png">
				<img src="icon/heart-white.png">
				<img src="icon/heart-white.png">
				<img src="icon/heart-white.png">
				<img src="icon/heart-white.png">
			</td>
		  </tr-->

		  ${myOrderList}
		</table>
	</div>
	
	<div class="promotion">
		<img src="icon/微信.jpg">
		<img src="icon/新浪微博.jpg">
		<img src="icon/腾讯微博.jpg">
		<img src="icon/人人.jpg">
	</div>

	<div class="popWeixin">
		<img src="images/微信演示.png">
		<div>确定</div>
	</div>
	
	<!--填充用div-->
	<div class="holdPlace"></div>

	<!--底部导航条-->
	<table class="navBar">
	  <tr>
		<th>
			<span class="iconBtn">
				<img src="icon/确认.png" />
				发表评价
			</span>
		</th>
	  </tr>
	</table>
</body>
</html>
