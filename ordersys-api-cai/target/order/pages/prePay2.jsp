<!doctype html>
<html>
<head>
  <%@ page contentType="text/html;charset=utf-8" %> 
  <title>点餐单</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet"  href="jqm/jquery.mobile-1.3.2.min.css">
  <script src="jqm/jquery.js"></script>
  <script src="jqm/jquery.mobile-1.3.2.min.js"></script>
  <script src="js/other.js"></script>
</head> 
<body>
<div data-role="page" id="prePayPage">
	<div data-role="header" data-position="fixed" data-theme="b">
		<h1>桌号：${deskId}，人数：${personNum}</h1>
	</div>
	<div data-role="content">
		<ul data-role="listview">
		 	  ${myOrderList}
		</ul>
		
		<div align = "center" style='font-size:25px;font-weight:700;margin-top:20px;margin-bottom:35px;'>
			 	<p>共： ￥<font id = "totalCost">${totalCost}</font></p>
			 	<p>人均： ￥<font id = "averageCost">${averageCost}</font></p>
		</div>
	</div>
	<div data-role="footer" data-position="fixed" data-theme="b">
	      <div data-role="navbar">
		  <ul>
			<li><a href="/" data-icon="plus" rel="external">加单</a></li>
			<li><a onclick="prePay('z')" data-icon="star" rel="external">支付宝支付</a></li>
			<li><a onclick="prePay('r')" data-icon="check">叫小二/人工支付</a></li>
		  </ul>
		</div>
	</div>
</div>  
</body>
</html>