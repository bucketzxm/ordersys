// using jQuery
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

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}

$(function () {
    $("#mainContent tr:nth-child(1)").click(
        function () {
            $("#mainContent tr").removeClass("trFocus");
            $(this).addClass("trFocus");
            $(this).find("td:nth-child(1) img").attr("src", "icon/现金-active.png");
            $(this).find("td:nth-child(3) img").attr("src", "icon/arrowRight.png");
            //setTimeout延时500ms跳转,现金（人工）支付
            setTimeout("location='/humanPayConfirm'", 500);
        }
    );

    $("#mainContent tr:nth-child(2)").click(
        function () {
            $("#mainContent tr").removeClass("trFocus");
            $(this).addClass("trFocus");
            $(this).find("td:nth-child(1) img").attr("src", "icon/支付宝-active.png");
            $(this).find("td:nth-child(3) img").attr("src", "icon/arrowRight.png");
            //setTimeout延时500ms跳转,支付宝支付
            if ((navigator.userAgent.match(/((iPad|iPhone);.*CPU.*OS 7_\d)|Android/i))) {
                //alipaywap();
                setTimeout("location='/pay/alipaywap'+'/?out_trade_num='+getUrlParam('out_trade_num')",500);
            }
            else {
                //alipaywap();
                setTimeout("location='/pay/alipaywap'+'/?out_trade_num='+getUrlParam('out_trade_num')",500);
            }
        }
    );

    $("#mainContent tr:nth-child(3)").click(
        function () {
            $("#mainContent tr").removeClass("trFocus");
            $(this).addClass("trFocus");
            $(this).find("td:nth-child(1) img").attr("src", "icon/支付宝-active.png");
            $(this).find("td:nth-child(3) img").attr("src", "icon/arrowRight.png");
            //setTimeout延时500ms跳转,支付宝支付
            setTimeout("location='/alipaycode'", 500);
        }
    );


});


function alipaywap() {

    var out_trade_num = getUrlParam("out_trade_num");
    myData = "out_trade_num="+out_trade_num;

    $.ajax({
        type: "post",
        url: "/pay/alipaywap",
        dataType: "text",
        data: myData,
        success: function (result) {
            console.log(result);
            window.location.href = result;
        },
        error: function (error) {
            console.log(error + "addItemFalse");
        }
    });

}
