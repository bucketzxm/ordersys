<!doctype html>
<html>
<head>
  <%@ page contentType="text/html;charset=utf-8" %> 
  <title>点餐单</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet"  href="js/jquery.mobile-1.3.2.min.css">
  <script src="js/jquery.js"></script>
  <script src="js/jquery.mobile-1.3.2.min.js"></script>
</head> 
<body>
<div data-role="page" id="prePayPage">
	<div data-role="header" data-position="fixed" data-theme="b">
		<h1>桌号：${deskId}，共￥${totalCost}</h1>
	</div>
	<div data-role="content">
	<ul data-role="listview">
	  	${myOrderList}
	</ul>
	</div>
	<div data-role="footer" data-position="fixed" data-theme="b">
	      <div data-role="navbar">
		  <ul>
			<li><a href="/" data-icon="plus" rel="external">加单</a></li>
			<li><a  data-icon="star" onclick="humanPay()">叫小二/人工支付</a></li>
			<li><a href="login" data-icon="check" rel="external">支付宝支付</a></li>
		  </ul>
		</div>
	</div>
</div>  
</body>
</html>