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
	
	$.ajax({  
	    type : "post",  
	    url : "showOrderitem1", 
	    dataType:"text",  
	    success : function( ret ) 
	    {
	    	$("#showOrderitem1").text( "已下单的订单项：" + ret );
	    } , 
	});	
	
	$.ajax({  
	    type : "post",  
	    url : "showOrderitem2", 
	    dataType:"text",  
	    success : function( ret ) 
	    {
	    	$("#showOrderitem2").text( "已下单的订单项：" + ret );
	    } , 
	});
	
	$.ajax({  
	    type : "post",  
	    url : "showOrderitem3", 
	    dataType:"text",  
	    success : function( ret ) 
	    {
	    	$("#showOrderitem3").text( "已下单的订单项：" + ret );
	    } , 
	});
	
	$(function(){
		$( "#addOrderitem" ).click(
				 function(){
					 var a = "orderitemId=";
					 var tmp = prompt("请输入食物订单项编号");
					 var itemid = a + tmp;
					 $.ajax({  
					    type : "post",  
					    url : "addOrderitem", 
					    dataType:"text",  
					    data:itemid,
					    success : function( ret ) 
					    {
					    	location.reload();   
					    } , 
					});
				 }
			 );
	 	 
	 	$( "#cutOrderitem" ).click(
				 function(){
					 var a = "orderitemId=";
					 var tmp = prompt("请输入食物订单项编号");
					 var itemid = a + tmp;
					$.ajax({  
					    type : "post",  
					    url : "cutOrderitem", 
					    dataType:"text",  
					    data:itemid,
					    success : function() 
					    {
					    	location.reload();   
					    } , 
					});
				 }
			 );
	 	
	 	$( "#deleteOrderitem" ).click(
				 function(){
					 var a = "orderitemId=";
					 var tmp = prompt("请输入食物订单项编号");
					 var itemid = a + tmp;
					$.ajax({  
					    type : "post",  
					    url : "deleteOrderitem", 
					    dataType:"text",  
					    data:itemid,
					    success : function() 
					    {
					    	location.reload();   
					    } , 
					});
				 }
			);
	 	
		$.ajax({  
		    type : "post",  
		    url : "needConfirm", 
		    dataType:"text",  
		    success : function( ret ) 
		    {
		    	$("#needConfirm").text( "需确认的订单编号：" + ret );
		    } , 
		});
	 	
		$( "#doWaiterConfirm" ).click(
				 function(){
					 	var a = "deskId=";
						var tmp = prompt("请输入桌号","7");
						var deskid = a + tmp;
					$.ajax({  
					    type : "post",  
					    url : "doWaiterConfirm", 
					    dataType:"text",  
					    data:deskid,
					    success : function() 
					    {
					    	alert("已确认！");
					    } , 
					});
				 }
			);
	 	
		$.ajax({  
		    type : "post",  
		    url : "showOrder", 
		    dataType:"text",  
		    success : function( ret ) 
		    {
		    	$("#showOrder").text( "已下单的订单编号：" + ret );
		    } , 
		});
	 	
	 	$( "#deleteOrder" ).click(
				 function(){
					var a = "deskId=";
					var tmp = prompt("请输入桌号","7");
					var deskid = a + tmp;
					$.ajax({ 
					    type : "post",  
					    url : "deleteOrder", 
					    dataType:"text",  
					    data:deskid,
					    success : function() 
					    {
					    	alert("已删除！");
					    	location.reload();
					    } , 
					});
				 }
			);
	 	
	 	$( "#choosedesk" ).click(
				 function(){
					var a = "deskId=";
					var tmp = prompt("请输入桌号","7");
					var deskid = a + tmp;
					$.ajax({  
					    type : "post",  
					    url : "orderOfDesk", 
					    dataType:"text",  
					    data:deskid,
					    success : function( ret ) 
					    {
					    	$("#orderOfDesk").text( tmp+"号桌所点菜[订单项编号,菜名,数量]：" + ret );
					    } , 
					});
					$.ajax({  
					    type : "post",  
					    url : "sumOfDesk", 
					    dataType:"text",  
					    data:deskid,
					    success : function( ret ) 
					    {
					    	$("#sumOfDesk").text( tmp+"号桌应付金额：" + ret );
					    } , 
					});
				 }
			);
	 
	 });
</script>
</head>
<body>
	<h3>已下单桌号</h3>
	<div id="deskAlreadySentOrder"></div>
	<h3>已确认订单的桌号</h3>
	<div id="deskAlreadyConfirm"></div>
	<h3>要求人工支付的桌号</h3>
	<div id="deskSendHumanPay"></div>	
	
	<h3>指定桌号的订单内容</h3>
	<button id="choosedesk">显示指定卓详细</button>
	<div id="orderOfDesk"></div>
	
	<h3>指定桌号的总消费</h3>
	<div id="sumOfDesk"></div>
	
	<h3>项目数量加1</h3>
	<div id="showOrderitem1"></div>
	<button id="addOrderitem">订单项数量+1</button>
	
	<h3>项目数量减1</h3>
	<div id="showOrderitem2"></div>
	<button id="cutOrderitem">订单项数量-1</button>
	
	<h3>删除项目</h3>
    <div id="showOrderitem3"></div>
	<button id="deleteOrderitem">删除该订单项</button>
	
	<h3>需确认的订单</h3>
    <div id="needConfirm"></div>
	<button id="doWaiterConfirm">确认订单</button>
	
	<h3>删除订单</h3>
	<div id="showOrder"></div>
	<button id="deleteOrder">删除订单</button>
</body>
</html>

