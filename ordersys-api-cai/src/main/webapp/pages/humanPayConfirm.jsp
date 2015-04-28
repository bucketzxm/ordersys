<html>
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>现金支付确认</title>
<script src="jquery.js"></script>
<title>支付提醒</title>
<style>

</style>

<script>
    function fun()
	{
		window.opener = null;
		window.open('','_self');
		window.close();
	}
</script>

</head>
 <body>
	<div style="text-align:center;margin-top:40px;color:#CF0A59;">
		您的请求已发出，小二马上就来。待付完钱后点击“已付款”可退出当前页面。
	</div>
	<div style="background:#CF0A59;color:white;padding:7px;text-align:center;width:90px;margin:20px auto 0 auto;cursor:pointer;" onclick="fun()">
			已付款
	</div>
 </body>
</html>