<html>
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>我的菜</title>
<script src="jquery.js"></script>
<link rel="stylesheet" href="myCss/myDish.css">
<link rel="stylesheet" href="owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="owl-carousel/owl.theme.css">
<script src="myJs/myDish.js"></script>
<script src="owl-carousel/owl.carousel.js"></script>
<script>
</script>

<style>
</style>
</head>

 <body>
    <div class="mask"></div>
	
	<div class="popQuery">
		<img src="icon/realLogo.png" class="logo">
		<div>
			确认下单，不需要再点些优惠菜了吗？
		</div>
		<table>			
			<tr>
				<th>
					<img src="icon/首页-white.png">
					首页
					<div class="thFocuseMark"></div>
					<div class="middleLine"></div>
				</th>
				<th>
					<img src="icon/确认.png">
					确定
					<div class="thFocuseMark"></div>
				</th>					
			</tr>
		</table>
	</div>

	<div class="popQuery">
		<img src="icon/realLogo.png" class="logo">
		<div>
			等服务员确定后，您可以将我保存在桌面就餐后再结账
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
	
	<div id="popSetting" align="center">

		<div>请选择您的桌号</div>
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

		<div>请选择用餐人数</div>
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
			  <div class="sliderEnd"></div>
			 </div> 
			<hr />
			<button class="focusCircle">
				1
			</button>
		</div>

		<span id="confirmButton">
			<img src="icon/确认.png" />
			确定
		</span>
	</div>
	
	

	<table class="headBar">
	  <tr>
		<th>我的菜</th>
	  </tr>
	</table>

	<div id="mainContent">
		<div id="orderInfo">
			<img src="icon/user-active.png">
			<div>
				<div id="circleMark"></div>
				<span><personNum>${personNum}</personNum>人 <deskId>${deskId}</deskId>号桌 <setting>[设置]</setting></span>
				<div> 
					<font>人均 ￥<avg>${avg}</avg></font> | 2冷菜 3热菜 1汤 2甜点
				</div>
			</div>
		</div>
        
		<table id="dishList">
			<tr>
				<th> 菜 单 <font>|</font></th>
				<th> 数 量 <font>|</font></th>
				<th> 单价(RMB) </th>
			</tr>
			<!-- tr>
				<td>
					<div></div>
					翡翠白玉汤
				</td>
				<td>
					<img src = "icon/plus-black.png"> 
					2 
					<img src = "icon/minus-black.png">
				</td>
				<td>￥7.50</td>
			</tr-->
			${myOrderList}
		</table>
		<hr />
	</div>
    
	<table id="sumBar">
		<tr>
			<th>合计：￥<sum>${sum}</sum></th>
			<th>
				<span class="iconBtn">
					<img src="icon/加菜.png" />
					加菜
				</span>
				<span class="iconBtn">
					<img src="icon/下单.png" />
					下单
				</span>
			</th>
		</tr>
	</table>
	
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
