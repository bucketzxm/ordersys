function getCookie(name) {
    var cookieValue = null;
    if (document.cookie && document.cookie != '') {
        var cookies = document.cookie.split(';');
        for (var i = 0; i < cookies.length; i++) {
            var cookie = jQuery.trim(cookies[i]);
            // Does this cookie string begin with the name we want?
            if (cookie.substring(0, name.length + 1) == (name + '=')) {
                cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                break;
            }
        }
    }
    return cookieValue;
}
var csrftoken = getCookie('csrftoken');
$.ajaxSetup({
     beforeSend: function(xhr, settings) {
         function getCookie(name) {
             var cookieValue = null;
             if (document.cookie && document.cookie != '') {
                 var cookies = document.cookie.split(';');
                 for (var i = 0; i < cookies.length; i++) {
                     var cookie = jQuery.trim(cookies[i]);
                     // Does this cookie string begin with the name we want?
                 if (cookie.substring(0, name.length + 1) == (name + '=')) {
                     cookieValue = decodeURIComponent(cookie.substring(name.length + 1));
                     break;
                 }
             }
         }
         return cookieValue;
         }
         xhr.setRequestHeader("X-CSRFToken", getCookie('csrftoken'));
     }
});
function sendOrder()
{
	$.ajax({
        type : "post",
        url : "sendOrder",
        dataType:"text",
	    success : function( msg )
	    {
	    	if( msg == "alreadySentOrder")
	    	{
	    		alert( "你已下单，请先去支付。");
	    		location.href = "/prePay" ;
	    		return;
	    	}
	    	setTimeout(
    			"$('.popQuery:nth-child(2)').hide();$('.popQuery:nth-child(3)').show();",
    			300
    		);
	    } ,
	    error:function(error)
	    {
	     	console.log(error+"selectDesk");
 		}
	});
}

function homeClick( obj )
{
	$(obj).css( "background", "white" );
	$(obj).css( "color", "#D31C64" );
	$(obj).find("img").attr( "src", "/images/icon/首页-active.png" );
	$(".popQuery:nth-child(2) .middleLine").hide();
	$(obj).find( "div:nth-child(2)" ).show();
	setTimeout(
		"location = '/'",
		500
	);
}

function confrimClick( obj )
{
	$(obj).css( "background", "white" );
	$(obj).css( "color", "#D31C64" );
	$(obj).find("img").attr( "src", "/images/icon/确认-active.png" );
	$(".popQuery:nth-child(2) .middleLine").hide();
	$(obj).find( "div:nth-child(2)" ).show();
	sendOrder();

	/*发送信息，下单和打印小票
	 $.ajax({
	        type : "post",
	        url : "InvoiceAndOrderDone",
	        dataType:"text",
		    success : function(result) {
		    	if(result== -1){
		    		location.href="SystemPrompt?type=-1";
		    	}
		    } ,
		     error:function(error){
		     	alert("error: InvoiceAndOrderDone");
	 		}
	});*/
}

function noClick( obj )
{
	$(obj).css( "background", "white" );
	$(obj).css( "color", "#D31C64" );
	$(".popQuery:nth-child(3) .middleLine").hide();
	$(obj).find( "div:nth-child(1)" ).show();
	setTimeout(
		"location.href = '/choicePay';",
		500
	);
}

$(function(){
	//initCarousel();
	$("#sumBar span:nth-child(1)").click(//点击加菜
			function()
			{
				location.href = "/";
			}
	);
	$("#sumBar span:nth-child(2)").click(//点击下单
		function()
		{
			$(".mask").show();
			$(".popQuery:nth-child(2)").show();
		}
	);
    $("#sumBar span:nth-child(3)").click(
        function()
        {
            location.href="/clearCart"
        }
    );


	$("#dishList td img").click(
			function()
			{
				$("#dishList tr").removeClass( "trFocus" );
				$(this).parents("tr").addClass( "trFocus" );
			}
	);

	$("#dishList td img:nth-child(1)").click(//点击+
			function()
			{
				addToCart( this );
			}
	);

	$("#dishList td img:nth-child(3)").click(//点击-
			function()
			{
				orderItemCut( this );
			}
	);

	$(".popQuery:nth-child(3) th:nth-child(1)").click(//点击是否保存app的"是"时
			function()
			{
				var ua = navigator.userAgent;
			    if ( ua.indexOf("iPad") > -1 || ua.indexOf("iPone") > -1 ) {
			    	location.href = "download?deviceType=ios";
			    } else if (ua.indexOf("Android") > 0) {
			    	location.href = "download?deviceType=android";
			    } else {
			        alert("抱歉，app暂不支持你所用的终端设备。");
			        return;
			    }
		    	alert( "下载安装完成后，点击app即可进行加单和支付！" );
		    	$(".popQuery:nth-child(3)").hide();
		    	$(".mask").hide();
			}
	);

	$(".popQuery:nth-child(3) th:nth-child(2)").click(//点击是否保存app的"否"时
			function()
			{
				noClick( this );
			}
	);

	$("#confirmButton").click(
		function () {
			selectDeskAndPerson();
		}
	);

	$(".markSlider button").click(
		function()
		{
			//点击数字使滑动条滑动的代码
			var owlObj = $(this).parents(".markSlider").first();
			var owl = owlObj.data('owlCarousel');
			var clickIdx = parseInt( $(this).text() );
			owl.goTo( clickIdx - 1 );
		}
   );

   	$("setting").click(//点击"设置"
		function()
		{
			settingClick();
		}
	);
});


function updateFocus( flag ){
   var focusNum = $( $(".focusCircle")[flag] );
   if( flag == 0)
	 focusNum.text($($("#deskSlider .active")[1]).text());
   else if( flag == 1)
	 focusNum.text($($("#personSlider .active")[1]).text());
}

function addToCart( obj )
{
	var foodId = $(obj).parents("tr").attr("foodId");
	var myData="foodId=" + foodId;

	$.ajax({
        type : "post",
        url : "addToCart",
        dataType:"text",
        data: myData,
	    success : function( result )
	    {
    		var numObj = $( $(obj).next("amount")[0] );
    		var num = parseInt( numObj.text() );
    		numObj.text( num + 1 );
            console.log(num+1);
    		var strArray = result.split(" ");
    		$("avg").text( strArray[0] );
    		$("sum").text( strArray[1] );
	    } ,
	    error:function(error)
	    {
	     	console.log(error+"addItemFalse");
 		}
	});
}

function orderItemCut( obj )
{
	var foodId = $(obj).parents("tr").attr("foodid");
	var myData="foodId=" + foodId;

	var numObj = $( $(obj).prev("amount")[0] );
	if( numObj.text() == 1)//若全部删完
	{
		$.ajax({
	        type : "post",
	        url : "cutFromCart",
	        dataType:"text",
	        data: myData,
		    success : function(result)
		    {
		    	currentTr = $(obj).parents("tr").first();
		    	currentTr.remove();
		    	var strArray = result.split(" ");
		    	$("avg").text( strArray[0] );
	    		$("sum").text( strArray[1] );
	    		return result;
		    }
		});
	}
	else
	{
		$.ajax({
	        type : "post",
	        url : "cutFromCart",
	        dataType:"text",
	        data: myData,
		    success : function( result )
		    {
	    		var num = parseInt( numObj.text() );
	    		numObj.text( num - 1 );
	    		var strArray = result.split(" ");
	    		$("avg").text( strArray[0] );
	    		$("sum").text( strArray[1] );
		    }
		});
	}
}

function settingClick()
{
	$(".mask").show();
	$("#popSetting").show();
	var deskId = $("deskId").text();
	var personNum = $("personNum").text();
	$("#deskSlider").data('owlCarousel').goTo( parseInt( deskId ) - 1 );
	$("#personSlider").data('owlCarousel').goTo( parseInt( personNum ) - 1 );
}