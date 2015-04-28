<!doctype html>
<html>
<head>
  <%@ page contentType="text/html;charset=utf-8" %> 
  <title>支付宝登录</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet"  href="jqm/jquery.mobile-1.3.2.min.css">
  <script src="jqm/jquery.js"></script>
  <script src="jqm/jquery.mobile-1.3.2.min.js"></script>
  	<script type="text/javascript">
		function showMsg(type){
			if(type=="001")//前面都对，但申请了手机验证
			{
				$("#block1").attr("style","display:none");
				$("#mobileValidateSet").removeClass("ui-hidden-accessible");
			}
			if(type=="1")//密码错，宝令对
				$("#errorBox1").text("密码错");
			if(type=="01")//宝令错，密码对
				$("#errorBox2").text("宝令错");
			if(type=="11")//两个都错
			 {
				$("#errorBox1").text("密码错");
				$("#errorBox2").text("宝令错");
			 }
			 if(type=="6")
			   $(".error").text("");
		}

		function checkPay3(obj)
		{
			var payPassword=$("#payPassword").val();
			var baoling=$("#baoling").val();
			showMsg(6);
			if(payPassword=="")
			{
				$("#errorBox1").text("支付密码不能为空");
				return false;
			}
			if($("#baolingSet").attr("style").indexOf("display:none")<0&&!(/\d{6}/.test(baoling)))
			{
				$("#errorBox2").text("宝令必须为六位数字");
				return false;
			}
			var myData="payPassword="+payPassword+"&baoling="+baoling;
			var temp=$(obj).attr("onclick");
			$.ajax( { 
				beforeSend: function() {  		
	  				$.mobile.loading( 'show', {
	  		  			text: '正在验证',
	  		  			textVisible: true,
	  		  			theme: 'b',
	  		  			html: ""
	  		  		});
	  				$(obj).attr("onclick","");//设置链接无效
	  				}, //Show spinner
	  		  		
	  	        complete: function() { 
	  	            	$.mobile.loading( 'hide' );
	  	            	$(obj).attr("onclick",temp);//设置链接有效
	  	            }, //Hide spinner
				type : "post",  
				url : "checkPay3", 
				data: myData,
				dataType:"text",  
				success : function(type) {
					//alert(type);
					if(type=="0")//完全正确
						location.href="successPay3";
					else{
						showMsg(type);
					}
				} 		 
			});   
		}

		function checkMobileValidate(obj)
		{
			var mobileValidate=$("#mobileValidate").val();
			var myData="mobileValidate="+mobileValidate;
			if(!(/\d{6}/.test(mobileValidate)))
			{
				$("#errorBox3").text("手机校验码必须为六位数字!");
				return false;
			}
			var temp=$(obj).attr("onclick");
			$.ajax( {
				beforeSend: function() {  		
	  				$.mobile.loading( 'show', {
	  		  			text: '正在验证',
	  		  			textVisible: true,
	  		  			theme: 'b',
	  		  			html: ""
	  		  		});
	  				$(obj).attr("onclick","");//设置链接无效
	  				}, //Show spinner
	  		  		
	  	        complete: function() { 
	  	            	$.mobile.loading( 'hide' );
	  	            	$(obj).attr("onclick",temp);//设置链接有效
	  	            }, //Hide spinner
				type : "post",  
				url : "checkMobileValidate", 
				data: myData,
				dataType:"text",  
				success : function(type) {
					//alert(type);
					if(type=="0")//手机验证码正确
						location.href="successPay3";
					else{
						$("#errorBox3").text("校验码错误,请重新输入！");
					}
				} 		 
			});   
		}
	</script>
	 <style>
	 	.error{ 
			color: red; 
		}
	 </style>
</head> 
<body> 
	<div data-role="page" id="pay3Page">
		<div data-role="content">	
		  <div id="block1">
			<fieldset data-role="fieldcontain" > 
				<div id="errorBox1" class="error"></div>
				<label for="payPassword">支付密码:</label>
				<input type="password" name="payPassword" id="payPassword" value="zxw50253080" />
			</fieldset>
			<fieldset data-role="fieldcontain" id="baolingSet" style="display:${BLStyle}"> 
				<div id="errorBox2" class="error"></div>
					<label for="baoling">宝令：</label>
					<input type="text" name="baoling" id="baoling">
			</fieldset>		
			<input type="button" onclick="checkPay3(this)" value="确定" />
		 </div>

			<fieldset data-role="fieldcontain" id="mobileValidateSet" class="ui-hidden-accessible"> 
				<div id="errorBox3" class="error"></div>
				<label for="mobileValidate">请输入你收到的手机校验码：</label>
				<input type="text" name="mobileValidate" id="mobileValidate">
				<input type="button" onclick="checkMobileValidate(this)" value="确定" />
			</fieldset> 

		</div>				
	</div>
</body>
</html>