<html><!-- 下单后的非法请求拦截后跳转到这个页面 -->
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<script src="jquery.js"></script>
<link rel="stylesheet" href="myCss/prePay.css">
<style>
</style>

<script>
$(function() {
	$("#payButton").click(
		function()
		{
			location.href = "/choicePay";
		}
	);
});
</script>

</head>
 <body>
	<table class="headBar">
	  <tr>
		<th>我的菜</th>
	  </tr>
	</table>

	<div id="mainContent">
		<div id="orderInfo">
			<img src="icon/user-active.png">
			<div>
				<img src = "icon/point.png">
				<span>${personNum}人 ${deskId}号桌</span>
				<div> 
					<font>人均 ￥${avg}</font> | 2冷菜 3热菜 1汤 2甜点
				</div>
			</div>
		</div>
        
		<table id="dishList">
			<tr>
				<th> 菜 单 <font>|</font></th>
				<th> 数 量 <font>|</font></th>
				<th> 单价(RMB) </th>
			</tr>
			<!--tr>
				<td>翡翠白玉汤</td>
				<td>2</td>
				<td>￥7.50</td>
			</tr-->
			${myOrderList}
		</table>
		<hr />
	</div>
    
	<table id="sumBar">
		<tr>
			<th>合计：￥${sum}</th>
			<th>
				<span id="payButton">
					<img src="icon/支付.png" />
					支付
				</span>
			</th>
		</tr>
	</table>
	
	<!--填充用div-->
	<div class="holdPlace"></div>
 </body>
</html>
