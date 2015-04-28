<html>
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
<title>服务员操作测试</title>
<script  src = "jquery.js"></script>
<style>
</style>

<script>
	$.ajax({  
	    type : "post",  
	    url : "deskAlreadySentOrder", 
	    dataType:"text",  
	    success : function( ret ) 
	    {
	    	$("#deskAlreadySentOrder").text( "已下单桌号：" + ret );
	    } , 
	});	
	
	$.ajax({  
	    type : "post",  
	    url : "deskAlreadyConfirm", 
	    dataType:"text",  
	    success : function( ret ) 
	    {
	    	$("#deskAlreadyConfirm").text( "服务员已确认的桌号：" + ret );
	    } , 
	});
	
	$.ajax({  
	    type : "post",  
	    url : "deskSendHumanPay", 
	    dataType:"text",  
	    success : function( ret ) 
	    {
	    	$("#deskSendHumanPay").text( "呼叫人工支付的桌号：" + ret );
	    } , 
	});
	
	var myData;
	myData = "deskId=1";
	$.ajax({  
	    type : "post",  
	    url : "orderOfDesk", 
	    dataType:"text",  
	    data:myData,
	    success : function( ret ) 
	    {
	    	$("#orderOfDesk").text( "1号桌所点菜[订单项编号,菜名,数量]：" + ret );
	    } , 
	});
	
	$.ajax({  
	    type : "post",  
	    url : "sumOfDesk", 
	    dataType:"text",  
	    data:myData,
	    success : function( ret ) 
	    {
	    	$("#sumOfDesk").text( "1号桌应付金额：" + ret );
	    } , 
	});
	
	$(function(){
	 	 $( "#addOrderitem" ).click(
			 function(){
				 $.ajax({  
				    type : "post",  
				    url : "addOrderitem", 
				    dataType:"text",  
				    data:"orderitemId=30",
				    success : function( ret ) 
				    {
				    	location.reload();   
				    } , 
				});
			 }
		 );
	 	 
	 	$( "#cutOrderitem" ).click(
			 function(){
				$.ajax({  
				    type : "post",  
				    url : "cutOrderitem", 
				    dataType:"text",  
				    data:"orderitemId=30",
				    success : function() 
				    {
				    	location.reload();   
				    } , 
				});
			 }
		 );
	 	
	 	$( "#deleteOrderitem" ).click(
			 function(){
				$.ajax({  
				    type : "post",  
				    url : "deleteOrderitem", 
				    dataType:"text",  
				    data:"orderitemId=32",
				    success : function() 
				    {
				    	location.reload();   
				    } , 
				});
			 }
		);
	 	
	 	$( "#doWaiterConfirm" ).click(
			 function(){
				$.ajax({  
				    type : "post",  
				    url : "doWaiterConfirm", 
				    dataType:"text",  
				    data:"deskId=1",
				    success : function() 
				    {
				    	alert("已确认！");
				    } , 
				});
			 }
		);
	 	
	 	$( "#deleteOrder" ).click(
			 function(){
				$.ajax({  
				    type : "post",  
				    url : "deleteOrder", 
				    dataType:"text",  
				    data:"deskId=7",
				    success : function() 
				    {
				    	alert("已删除！");
				    } , 
				});
			 }
		);
	 });
</script>
</head>
<body>
	<h3>deskAlreadySentOrder</h3>
	<div id="deskAlreadySentOrder"></div>
	<h3>deskAlreadyConfirm</h3>
	<div id="deskAlreadyConfirm"></div>
	<h3>deskSendHumanPay</h3>
	<div id="deskSendHumanPay"></div>	
	<h3>orderOfDesk</h3>
	<div id="orderOfDesk"></div>
	<h3>sumOfDesk</h3>
	<div id="sumOfDesk"></div>
	
	<h3>addOrderitem</h3>
	<button id="addOrderitem">30号订单项数量+1</button>
	<h3>cutOrderitem</h3>
	<button id="cutOrderitem">30号订单项数量-1</button>
	<h3>deleteOrderitem</h3>
	<button id="deleteOrderitem">删除32号订单项</button>
	<h3>doWaiterConfirm</h3>
	<button id="doWaiterConfirm">确认1号桌的订单</button>
	<h3>deleteOrder</h3>
	<button id="deleteOrder">删除7号桌的订单</button>
</body>
</html>

