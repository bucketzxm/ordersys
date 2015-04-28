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
	function showError(errorNo) {
		if (errorNo == "1") {
			$("#errorBox1").text("账户出错");
			$("#errorBox1").show();
			$("#submitBtn").show();
		} else if (errorNo == "2") {
			$("#errorBox1").text("账户或密码出错");
			$("#errorBox1").show();
			$("#submitBtn").show();
		} else if (errorNo == "3") {
			$("#lvcset").removeClass("ui-hidden-accessible");
			$("#errorBox3").text("需要输入登录验证码");
			$("#errorBox3").show();
			$("#submitBtn").show();
		} else if (errorNo == "4") {
			$("#errorBox3").text("登录验证码错误，请重新输入！");
			$("#errorBox3").show();
			$("#submitBtn").show();
		} else if (errorNo == "5") {
			$("#errorBox4").text("您的账户内余额不够，将返回点菜单！。。。");
			jump(3);
		} else if (errorNo == "6") {
			$("#errorBox3").text("");
		} else if (errorNo == "7") {
			location.href = "SystemPrompt?type=7";
		} else if (errorNo == "8") {
			location.href = "SystemPrompt?type=8";
		} else if (errorNo == "9") {
			location.href = "SystemPrompt?type=9";
		} else if (errorNo == "-1") {
			location.href = "SystemPrompt?type=-1";
		} else if (errorNo == "08") {
			location.href = "SystemPrompt?type=08";
		} else if (errorNo == "01") {
			// 询问是否使用余额宝
			$("#submitDiv").hide();
			$("#askYueBaoDiv").show();
		} else if (errorNo = "12345")
			location = "successPay2";

	}

	function showYueBaoType(type) {
		if (type == "02") {
			// 要求支付密码
			$("#errorBox1").text("");
			$("#errorBox3").text("");
			$("#errorBox4").text("");
			//location.href = "#useYueBao";
			location.href = "login";
		} else if (type == "04") {
			// 要求支付密码和宝令
			$("#errorBox1").text("");
			$("#errorBox3").text("");
			$("#errorBox4").text("");
			$("#baoCodeField").show();
			//location.href = "#useYueBao";
			location.href = "login";
		} else if (type == "07") {
			// 没有证书没有宝令，无法转出
			location.href = "SystemPrompt?type=07";
		} else if (type == "9") {
			location.href = "SystemPrompt?type=9";
		} else if (errorNo == "-1") {
			location.href = "SystemPrompt?type=-1";
		} else if (errorNo == "08") {
			location.href = "SystemPrompt?type=08";
		}

	}
	function showPayPswd(type) {
		if (type == "0"){
			$("#submitContent").hide();
            $("#reLoginContent").show();
			location.href = "successPay1";
			}
		else if (type == "03") {
			// 支付密码错误
			$("#errorBoxPayPswd").text("支付密码错误！");
			$("#errorBoxPayPswd").show();
			$("#errorBoxBaoCode").text("");
		} else if (type == "05") {
			// 宝令错误
			$("#errorBoxBaoCode").text("宝令错误！");
			$("#errorBoxBaoCode").show();
			$("#errorBoxPayPswd").text("");
		} else if (type == "06") {
			// 宝令和支付密码错误
			$("#errorBoxPayPswd").text("支付密码错误！");
			$("#errorBoxPayPswd").show();
			$("#errorBoxBaoCode").text("宝令错误！");
			$("#errorBoxBaoCode").show();
		} else if (type == "9") {
			location.href = "SystemPrompt?type=9";
		} else if (type == "-1") {
			location.href = "SystemPrompt?type=-1";
		} else if (type == "08") {
			location.href = "SystemPrompt?type=08";
		}
	}

	function CheckMail(mail) {
		var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
		if (filter.test(mail))
			return true;
		else {
			return false;
		}
	}

	function CheckPhone(phone) {
		var filter = /^(13[0-9]{9})|(18[0-9]{9})|(15[0-9]{9})$/;
		if (filter.test(phone))
			return true;
		else {
			return false;
		}
	}

	function checkPay1(obj) {
		var username = $("#username").val();
		var password = $("#password").val();
		var loginValidateCode = $("#loginValidateCode").val();
		showError(6);//清空所有错误信息

		if (!CheckMail(username) && !CheckPhone(username)) {
			$("#errorBox1").text("账户格式不正确！");
			$("#errorBox1").show();
			return false;
		}

		else if (password == "") {
			$("#errorBox2").text("密码不能为空！");
			$("#errorBox2").show();
			return false;
		} else if ($("#lvcset").attr("class").indexOf("ui-hidden-accessible") < 0
				&& !(/\w{4}/.test(loginValidateCode))) {
			$("#errorBox3").text("验证码必须为4为字符！");
			$("#errorBox3").show();
			return false;
		}

		else {
			//alert("填写符合要求，可以发送ajax请求");
			var myData = "username=" + username + "&password=" + password
					+ "&loginValidateCode=" + loginValidateCode;
			var temp = $(obj).attr("onclick");
			$("#submitBtn").attr("style", "display:none");
			$.ajax({
				beforeSend : function() {
					$.mobile.loading('show', {
						text : '正在登录',
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
				url : "checkPay1",
				data : myData,
				dataType : "text",
				success : function(msg) {
					var jsonObj = eval(msg);
					var type = jsonObj.type;
					var imgString = jsonObj.imgString;//这里只接收登录验证码
					//alert(type);
					if (type == 0){
						$("#submitContent").hide();
                        $("#reLoginContent").show();
						location.href = "successPay1"; //在checkLogin的controller中需要对用户名密码进行验证，获取下一个验证码的图片
                    }//而successLogin的contonller只需要返回页面2就可以了。
					else {
						showError(type);
						$("#oginValidateCode").text("");//清空验证码输入框
						if(type!=4){
						$("#loginValidate").attr("src", imgString);
						}
					}
				},
				error : function(error) {
					alert("checkLogin fail ");
					console.log(error);
				}
			});
		}
	}

	function refreLogAC() {
		$("#loginBtn").disabled = true; // 不能点击
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
				$("#loginBtn").disabled = false;
			}, //Hide spinner
			type : "post",
			url : "refreLogAC",
			dataType : "text",
			success : function(msg) {
				var jsonObj = eval(msg);
				var type = jsonObj.type;
				var imgString = jsonObj.imgString;//这里只接收登录验证码
				if (type == 0) { // 0 刷新失败
					// location.href="successPay1";
					alert("refresh wrong");
					//而successLogin的contonller只需要返回页面2就可以了。
				} else {

					$("#loginValidate").attr("src", imgString);
				}
			},
			error : function(error) {
				alert("RefreshAC fail ");
				console.log(error);
			}
		});
	}

	function jump(count) {
		window.setTimeout(function() {
			count--;
			if (count > 0) {
				//$('#num').text(count);
				jump(count);
			} else {
				location.href = "prePay?mode=1";
			}
		}, 1000);
	}

	function checkSession() {
		$.ajax({
			type : "post",
			url : "checkSession",
			dataType : "text",
			success : function(msg) {
				alert("该用户session中的编号为" + msg);
			},
			error : function(error) {
				alert("selectDesk fail");
				console.log(error + "selectDesk");
			}
		});
	}

	function errorJump(count) {
		window.setTimeout(function() {
			count--;
			if (count > 0) {
				$('#num').text(count);
				jump(count);
			} else {
				location.href = "returnToMenu";
			}
		}, 1000);
	}

	function yueBaoYes() {
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
			}, //Hide spinner
			type : "post",
			url : "useYueBaoYes",
			dataType : "text",
			success : function(type) {
				showYueBaoType(type);
			},
			error : function(error) {
				alert("program fail ");
				console.log(error);
			}
		});
	}

	function checkPaypswd(obj) {
		var payPassword = $("#payPassword").val();
		var baoCode = $("#baoCode").val();
		if (payPassword == "") {
			$("#errorBoxpayPswd").text("支付密码不能为空");
			$("#errorBoxpayPswd").show();
			return false;
		}
		if ($("#baoCodeField").attr("style").indexOf("display:none") < 0
				&& !(/\d{6}/.test(baoCode))) {
			$("#errorBoxBaoCode").text("宝令必须为六位数字");
			$("#errorBoxBaoCode").show();
			return false;
		}
		var myData = "payPassword=" + payPassword + "&baoCode=" + baoCode;
		var temp = $(obj).attr("onclick");
		$.ajax({
			beforeSend : function() {
				$.mobile.loading('show', {
					text : '正在验证',
					textVisible : true,
					theme : 'b',
					html : ""
				});
				$(obj).attr("onclick", "");//设置链接无效
			},
			complete : function() {
				$.mobile.loading('hide');
				$(obj).attr("onclick", temp);//设置链接有效
			}, //Hide spinner
			type : "post",
			url : "yueBaoPayPswd",
			data : myData,
			dataType : "text",
			success : function(type) {
				showPayPswd(type);
			},
			error : function(error) {
				alert("checkpaypswd error");
				console.log(error);
			}
		});

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
		<div id="submitContent" data-role="content"
			style="display:${submitContent}">

			<div id="submitDiv" style="display:${submitDiv}">
				<h2 style="text-align: center;">支付宝登录</h2>
				<h3 id="errorBox4" class="error" style="text-align: center;"></h3>

				<div id="errorBox1" class="error"
					style="display:${isUserOrPswdError}">${userErrorBox}</div>
				<fieldset data-role="fieldcontain" id="userField">
					<label for="username">账号:</label>
					<!-- <input type="text" name="username" id="username" value="@qq.com">   -->
					<input type="text" name="username" id="username"
						value="18516146492">
				</fieldset>

				<div id="errorBox2" class="error"></div>
				<fieldset data-role="fieldcontain" id="passwordField">
					<label for="password">密码:</label> <input type="password"
						name="password" id="password" value="zxw13764023982">
				</fieldset>

				<div id="errorBox3" class="error" style="display:${isLoginACError}">${loginACErrorBox}</div>
				<fieldset data-role="fieldcontain" class="ui-hidden-accessible"
					id="lvcset">
					<label for="loginValidateCode">登录验证码:<img
						id="loginValidate" onclick="refreLogAC()" src="" /> </label> <input
						type="text" name="loginValidateCode" id="loginValidateCode">
				</fieldset>

				<fieldset id="submitBtn">
					<input type="button" onclick="checkPay1(this)" value="登录" />
				</fieldset>
			</div>


			<div id="askYueBaoDiv" style="display:${askYueBaoDiv}">
			     <div style="text-align:right;">
                <a onclick="reLogin()">重新登录</a>
                </div>
				支付宝内余额不够，是否使用余额宝(您也可以选择否后转人工支付)？
				<p>
					<a id="yuebaoYesBtn" onclick="yueBaoYes()" data-role="button">是</a>
				</p>
				<p>
					<a id="yuebaoNoBtn" href="useYueBaoNo" data-role="button" rel="external" data-ajax="false"
						data-rel="dialog">否</a>
				</p>
			</div>


			<div style="display:${useYueBaoDiv}">
			<div style="text-align:right;">
                <a onclick="reLogin()">重新登录</a>
            </div>
				<fieldset data-role="fieldcontain" style="display:${isNeedPayPswd}">
					<div id="errorBoxPayPswd" class="error"
						style="display:${isPayPswdError}">{payPswdErrorBox}</div>
					<label for="payPassword">支付密码:</label> <input type="password"
						name="payPassword" id="payPassword" value="" />
				</fieldset>
				<fieldset data-role="fieldcontain" id=baoCodeField
					style="display:${isNeedPayPswdAndBaoCode}">
					<div id="errorBoxBaoCode" class="error"
						style="display:${isBaoCodeError}">{baoCodeErrorBox}</div>
					<label for="payBaoCode">宝令:</label> <input type="password"
						name="baoCode" id="baoCode" value="" />
				</fieldset>
				<fieldset id="ybSubmit">
					<input type="button" onclick="checkPaypswd(this)" value="确定" />
				</fieldset>
			</div>

		</div>

		<div id="reLoginContent" data-role="content"
			style="display:none">
			<div style="text-align:center;">
				<a onclick="reLogin()">重新登录</a>
			</div>
		</div>
	</div>


</body>
</html>