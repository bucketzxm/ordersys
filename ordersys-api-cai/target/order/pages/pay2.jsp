<!doctype html>
<html>
<head>
<%@ page contentType="text/html;charset=utf-8"%>
<title>支付宝支付</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="jqm/jquery.mobile-1.3.2.min.css">
<script src="jqm/jquery.js"></script>
<script src="jqm/jquery.mobile-1.3.2.min.js"></script>
<script type="text/javascript">
	function showQuery(no) {
		if (no == "01")//验证码正确，询问余额宝
		{
			$("#yuebao").attr("style", "display:inline");
			hideValidate();
		}
		if (no == "001")//验证码正确，询问手机支付
		{
			$("#zhengshu").attr("style", "display:inline");
			hideValidate();
		}
		if (no == "011")//验证码正确，两个都需要询问
		{
			$("#yuebao").attr("style", "display:inline");//若两个都要先问余额宝，通过了再显示问手机支付
			$("#yuebao").attr("type", "1");//type为1表示两个都要询问
			hideValidate();
		}
		if (no == "1")//验证码错误
		{
			$("#errorBox1").text("验证码错误，请重新输入！");
			$("#errorBox1").show();
		}
		if (no == "6")
			$(".error").text("");
		if (no == "9") {
			location.href = "SystemPrompt?type=9";
		}
		if (no == "-1") {
			location.href = "SystemPrompt?type=-1";
		}
		if (no == "3") {
			$("#zhengshu").attr("style", "display:inline");
			hideValidate();
		}
		// 使用app支付
		if (no == "10") {
			location.href = "AskApp";
		}
		if (no == "08") {
			location.href = "SystemPrompt?type=08";
		}

	}

	function hideValidate()//隐藏验证码控件
	{
		$("#validateSet").attr("style", "display:none");
	}

	function checkPay2(obj) {
		var validate = $("#validate").val();
		var temp = $(obj).attr("onclick");
		if (!(/\w{4}/.test(validate))) {
			$("#errorBox1").text("验证码必须为四位字符！");
			$("#errorBox1").show();
		} else {
			var myData = "validate=" + validate;
			$.ajax({
				beforeSend : function() {
					$.mobile.loading('show', {
						text : '正在验证',
						textVisible : true,
						theme : 'b',
						html : ""
					});
					$(obj).attr("onclick", "");//设置链接无效
				}, //Show spinner

				complete : function() {
					$.mobile.loading('hide');
					$(obj).attr("onclick", temp);//设置链接有效
				}, //Hide spinner
				type : "post",
				url : "checkPay2",
				data : myData,
				dataType : "text",
				success : function(msg) {
					var jsonObj = eval(msg);
					var type = jsonObj.type;
					var imgString = jsonObj.imgString;
					//alert(type);
					if (type == 0) {
						$("#acContent").hide();
						$("#reLoginContent").show();
						location.href = "successPay2";
					} else {
						showQuery(6);
						showQuery(type);
						if (type == 1)//可以不要，出错验证码。不会被更换
						{
							$("#validateImg").attr("src", imgString);
						}
					}
				},
				error : function(error) {
					alert("ac error");
					console.log(error);
				}
			});
		}
	}

	function refreAC() {
		$("#ensureBtn").disabled = true; // 不能点击
		$.ajax({
			beforeSend : function() {
				$.mobile.loading('show', {
					text : '正在刷新',
					textVisible : true,
					theme : 'b',
					html : ""
				});
			}, //Show spinner

			complete : function() {
				$.mobile.loading('hide');
				$("#ensureBtn").disabled = false;
			}, //Hide spinner
			type : "post",
			url : "refreAC",
			dataType : "text",
			success : function(msg) {
				var jsonObj = eval(msg);
				var type = jsonObj.type;
				var imgString = jsonObj.imgString;//这里指接收登录验证码
				if (type == 0) { // 0 刷新失败
					// location.href="successPay1";
					alert("refresh wrong");
					//而successLogin的contonller只需要返回页面2就可以了。
				} else {

					$("#validateImg").attr("src", imgString);
				}
			},
			error : function(error) {
				alert("RefreshAC fail ");
				console.log(error);
			}
		});
	}

	function yueBaoYes() {
		$("#yuebao").attr("style", "display:none");
		if ($("#yuebao").attr("type") == 1) {
			$("#zhengshu").attr("style", "display:inline");
		} else {
			$("#acContent").hide();
			$("#reLoginContent").show();
			location.href = "successPay2";
		}
	}

	function reLogin() {
		$.ajax({
			beforeSend : function() {
				$.mobile.loading('show', {
					text : '请稍等',
					textVisible : true,
					theme : 'b',
					html : ""
				});
			}, //Show spinner

			complete : function() {
				$.mobile.loading('hide');
				$("#reLogin").disabled = false;
			}, //Hide spinner
			type : "post",
			url : "reLogin",
			dataType : "text",
			success : function(msg) {
				//alert(msg);
				location.href = "login";
			},
			error : function(error) {
				alert("relogin fail ");
				console.log(error);
			}
		});
	}
</script>
<style>
.error {
	color: red;
}
</style>
</head>
<body>
	<div data-role="page" id="loginPage">

		<div data-role="content" id="acContent">
		      <div style="text-align:right;">
                <a onclick="reLogin()">重新登录</a>
            </div>
			<h2 style="text-align: center;">共需付款：￥${cost}</h2>
			<fieldset data-role="fieldcontain" id="validateSet">
				<div id="errorBox1" class="error" style="display:${isACError}">${ACErrorBox
					}</div>
				<label for="validate">验证码：<img id="validateImg"
					onclick="refreAC()" src=${validateImg } />
				</label> <input type="text" name="validate" id="validate"> <input
					type="button" id="acSubmit" onclick="checkPay2(this)" value="确定" />
			</fieldset>
			<div id="yuebao" style="display:none">
				您当前活动金额不够，是否使用余额宝支付？
				<p>
					<a onclick="yueBaoYes()" data-role="button">是</a>
				</p>
				<p>
					<a href="#confirm1" data-role="button" data-rel="dialog">否</a>
				</p>
			</div>
			<div id="zhengshu" style="display:none">
				<p style="text-align: center;">由于您申请了数字证书，支付无法完成，请选择人工支付</p>
				<p>
					<a href="prePay?mode=1" rel="external" data-role="button"
						data-transition="slidedown">确定</a>
				</p>
			</div>
		</div>

		<div id="reLoginContent" data-role="content" style="display:none">
			<div style="text-align:center;">
				<a onclick="reLogin()">重新登录</a>
			</div>
		</div>
	</div>

	<div data-role="page" id="confirm1">
		<div data-role="header">
			<h1>确认</h1>
		</div>
		<div data-role="content">
			<h1 style="text-align: center;">确定不使用余额宝？</h1>
			<p style="text-align: center;">若选择"是"则付款失败，将会跳转到首页</p>
			<p>
				<a href="exitPay2" data-ajax="false" data-role="button"
					data-transition="slidedown">是</a>
			</p>
			<p>
				<a href="#" data-role="button" data-rel="back">否</a>
			</p>
		</div>
	</div>

	<div data-role="page" id="confirm2">
		<div data-role="header">
			<h1>确认</h1>
		</div>
		<div data-role="content">
			<h1 style="text-align: center;">确定不使用手机支付？</h1>
			<p style="text-align: center;">若选择"是"则付款失败，将会跳转到首页</p>
			<p>
				<a href="exitPay2" data-role="button" data-transition="slidedown">是</a>
			</p>
			<p>
				<a href="#" data-role="button" data-rel="back">否</a>
			</p>
		</div>
	</div>

	<div data-role="page" id="message">
		<div data-role="header">
			<h1>提示</h1>
		</div>
		<div data-role="content">
			<h2 style="text-align: center;">您已选择手机支付，接下去请在您的手机上完成剩余付款操作，点击主页右上角的链接可查看手机支付是否成功</h2>
			<p>
				<a href="mobilePay" data-role="button">确定</a>
			</p>
		</div>
	</div>

</body>
</html>