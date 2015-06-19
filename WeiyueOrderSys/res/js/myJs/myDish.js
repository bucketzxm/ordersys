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
    beforeSend: function (xhr, settings) {
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
function sendOrder() {
    $.ajax({
        type: "post",
        url: "sendOrder",
        dataType: "text",
        success: function (msg) {
            if (msg == "alreadySentOrder") {
                alert("你已下单，请先去支付。");
                location.href = "/prePay";
                return;
            }
            setTimeout(
                "$('.popQuery:nth-child(2)').hide();$('.popQuery:nth-child(3)').show();",
                300
            );
        },
        error: function (error) {
            console.log(error + "selectDesk");
        }
    });
}

function homeClick(obj) {
    $(obj).css("background", "white");
    $(obj).css("color", "#D31C64");
    $(obj).find("img").attr("src", "/images/icon/首页-active.png");
    $(".popQuery:nth-child(2) .middleLine").hide();
    $(obj).find("div:nth-child(2)").show();
    setTimeout(
        "location = '/'",
        500
    );
}

function confrimClick(obj) {
    $(obj).css("background", "white");
    $(obj).css("color", "#D31C64");
    $(obj).find("img").attr("src", "/images/icon/确认-active.png");
    $(".popQuery:nth-child(2) .middleLine").hide();
    $(obj).find("div:nth-child(2)").show();
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

function noClick(obj) {
    $(obj).css("background", "white");
    $(obj).css("color", "#D31C64");
    $(".popQuery:nth-child(3) .middleLine").hide();
    $(obj).find("div:nth-child(1)").show();
    setTimeout(
        "location.href = '/choicePay';",
        500
    );
}

$(function () {
    //initCarousel();
    $("#sumBar span:eq(0)").click(//点击加菜
        function () {
            location.href = "/";
        }
    );
    $("#sumBar span:eq(1)").click(//点击下单
        function () {
            $.ajax({
                type: 'GET',
                url: 'makeOrder/',
                success: function(result){
                    $(".popQuery strong").text(result);
                    $(".mask").show();
			        $(".popQuery").show();
                },
                error: function(e){
                    console.log("Get Order Number Error " + e);
                    location.href('/myDish');
                }

            });
            //$(".mask").show();
            //$(".popQuery").show();
        }
    );
    $("#sumBar span:eq(2)").click(
        function () {
            location.href = "/clearCart"
        }
    );

    $(".popQuery th:eq(0)").click(
        // 弹出框 现金支付按钮
        function(){
            location.href = '/'
        }
    );

    $(".popQuery th:eq(1)").click(
        //弹出框下单按钮
        function(){
            location.href = '/choosePayMethods'
        }
    );


    $("#dishList td img").click(
        function () {
            $("#dishList tr").removeClass("trFocus");
            $(this).parents("tr").addClass("trFocus");
        }
    );

    $("#dishList td img:nth-child(1)").click(//点击+
        function () {
            addToCart(this);
        }
    );

    $("#dishList td img:nth-child(3)").click(//点击-
        function () {
            orderItemCut(this);
        }
    );



    $("#confirmButton").click(
        function () {
            selectDeskAndPerson();
        }
    );

    $(".markSlider button").click(
        function () {
            //点击数字使滑动条滑动的代码
            var owlObj = $(this).parents(".markSlider").first();
            var owl = owlObj.data('owlCarousel');
            var clickIdx = parseInt($(this).text());
            owl.goTo(clickIdx - 1);
        }
    );

    $("setting").click(//点击"设置"
        function () {
            settingClick();
        }
    );
});


function updateFocus(flag) {
    var focusNum = $($(".focusCircle")[flag]);
    if (flag == 0)
        focusNum.text($($("#deskSlider .active")[1]).text());
    else if (flag == 1)
        focusNum.text($($("#personSlider .active")[1]).text());
}

function addToCart(obj) {
    var foodId = $(obj).parents("tr").attr("foodId");
    var myData = "foodId=" + foodId;

    $.ajax({
        type: "post",
        url: "addToCart",
        dataType: "text",
        data: myData,
        success: function (result) {

            var numObj = $($(obj).next("amount")[0]);
            var num = parseInt(numObj.text());
            // amount add one
            numObj.text(num + 1);


            var unitePrice_str = $(obj).parents("tr").children()[2].textContent;
            unitePrice_str = unitePrice_str.replace("￥", "");
            var unitePrice = parseFloat(unitePrice_str);


            var priceObj = document.getElementById("sumBar").getElementsByTagName("sum")[0];
            var totalPrice = parseFloat(priceObj.textContent);

            $(priceObj).text(String(totalPrice + unitePrice));


            console.log(result);
            //$("avg").text(strArray[0]);
            $("sum").text(result);
        },
        error: function (error) {
            console.log(error + "addItemFalse");
        }
    });
}


function orderItemCut(obj) {
    var foodId = $(obj).parents("tr").attr("foodId");
    var myData = "foodId=" + foodId;

    var numObj = $($(obj).prev("amount")[0]);
    if (numObj.text() == 1)//若全部删完
    {
        $.ajax({
            type: "post",
            url: "cutFromCart",
            dataType: "text",
            data: myData,
            success: function (result) {

                var unitePrice_str = $(obj).parents("tr").children()[2].textContent;
                unitePrice_str = unitePrice_str.replace("￥", "");
                var unitePrice = parseFloat(unitePrice_str);
                var priceObj = document.getElementById("sumBar").getElementsByTagName("sum")[0];
                var totalPrice = parseFloat(priceObj.textContent);

                $(priceObj).text(String(totalPrice - unitePrice));

                currentTr = $(obj).parents("tr").first();
                currentTr.remove();
                console.log(result);
                //$("avg").text(strArray[0]);
                $("sum").text(result);
            }
        });
    }
    else {
        $.ajax({
            type: "post",
            url: "cutFromCart",
            dataType: "text",
            data: myData,
            success: function (result) {
                var num = parseInt(numObj.text());
                numObj.text(num - 1);


                var unitePrice_str = $(obj).parents("tr").children()[2].textContent;
                unitePrice_str = unitePrice_str.replace("￥", "");
                var unitePrice = parseFloat(unitePrice_str);


                var priceObj = document.getElementById("sumBar").getElementsByTagName("sum")[0];
                var totalPrice = parseFloat(priceObj.textContent);

                $(priceObj).text(String(totalPrice - unitePrice));


                console.log(result);
                //$("avg").text(strArray[0]);
                $("sum").text(result);
            }
        });
    }
}

function settingClick() {
    $(".mask").show();
    $("#popSetting").show();
    var deskId = $("deskId").text();
    var personNum = $("personNum").text();
    $("#deskSlider").data('owlCarousel').goTo(parseInt(deskId) - 1);
    $("#personSlider").data('owlCarousel').goTo(parseInt(personNum) - 1);
}