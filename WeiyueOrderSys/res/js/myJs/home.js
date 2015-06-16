$(document).ready(function () {
    initCarousel();//对首页的两个旋转木马初始化
    //setMask();//设置选桌界面是否显示

    $(".markSlider button").click(
        function () {
            silderClick(this);
        }
    );

    $("#startButton").click(
        function () {
            selectDeskAndPerson();
        }
    );

    //$("#owl-recommend .item").click(
    //    function () {
    //        addToCart(this);
    //    }
    //);
    //
    //$("#owl-demo .item .addDish").click(
    //    function () {
    //        addToCart($(this).parents(".item"));
    //    }
    //);

});

function silderClick(obj) {
    //点击数字使滑动条滑动的代码
    var owlObj = $(obj).parents(".markSlider").first();
    var owl = owlObj.data('owlCarousel');
    var clickIdx = parseInt($(obj).text());
    owl.goTo(clickIdx - 1);
}

function initCarousel() {
    $("#owl-demo").owlCarousel({
        navigation: false, // Show next and prev buttons
        slideSpeed: 300,
        paginationSpeed: 400,
        singleItem: true,
        afterInit: function (elem) {
            var that = this;
            that.owlControls.prependTo($("#pointNavHolder"));
        }
    });

    $("#owl-recommend").owlCarousel({
        items: 2,
        itemsDesktop: [600, 2],
        itemsMobile: [130, 1],
        pagination: false,
        addClassActive: true,
        afterMove: function () {
            showArrows();
        }
    });

    var owl = $("#deskSlider");
    owl.owlCarousel({
        itemsCustom: [
            [0, 3],
            [1600, 3]
        ],
        pagination: false,
        addClassActive: true,
        afterMove: function () {
            updateFocus(0);
        }
    });
    //owl.data('owlCarousel').goTo(1);

    owl = $("#personSlider");
    owl.owlCarousel({
        itemsCustom: [
            [0, 3],
            [1600, 3]
        ],
        pagination: false,
        addClassActive: true,
        afterMove: function () {
            updateFocus(1);
        }
    });
    //owl.data('owlCarousel').goTo(1);
}

//显示和隐藏箭头
function showArrows() {
    if ($("#owl-recommend .owl-item").first().attr("class").indexOf("active") < 0) {
        $("#leftArrowHolder").show();
    }
    else {
        $("#leftArrowHolder").hide();
    }
    if ($("#owl-recommend .owl-item").last().attr("class").indexOf("active") < 0) {
        $("#rightArrowHolder").show();
    }
    else {
        $("#rightArrowHolder").hide();
    }
}

function updateFocus(flag) {
    var focusNum = $($(".focusCircle")[flag]);
    if (flag == 0)
        focusNum.text($($("#deskSlider .active")[1]).text());
    else if (flag == 1)
        focusNum.text($($("#personSlider .active")[1]).text());
}


function addToCart(obj) {
    var foodId = $(obj).attr("foodId");
    var myData = "foodId=" + foodId;
    var numObj = $($(obj).children()[2]);
    $.ajax({
        type: "post",
        url: "addToCart",
        dataType: "text",
        data: myData,
        success: function (result) {

            //numObj = $(numObj.children()[0]);
            numObj = $(obj).find("button")[0];
            var num = parseInt(numObj.textContent);
            // amount add one
            numObj.textContent = num + 1;

            num = parseInt(numObj.textContent);
            if (num > 0) {
                $(obj).attr("class", 'item beChoiced');
            }
        },
        error: function (error) {
            console.log(error + "addItemFalse");
        }
    });
}

//press buy button on index , add item to cart
$(function ($) {
    $(window).resize();

    var items = document.getElementsByClassName("item");

    var it;
    for(var i=0 ;i<items.length;i++){
        it = items[i];
        //var num = parseInt( it.children[2].children[0].textContent );
        var num = parseInt( $(it).find("button")[0].textContent);
        if( num >0){
            it.className = "item beChoiced";
        }
    }

    ////$("#addBtn").click(
    //$("div.addDish").click(
    //
    //    function () {
    //        li_obj = this.parentElement;
    //        console.log(this);
    //        addToCart(li_obj);
    //    }
    //);



    $("div.item").click(
        function(){
            li_obj = this;
            console.log("ok");
            addToCart(li_obj);
        }
    );

    $("#addDish").click(
        function () {
            li_obj = this.parentElement;
            //console.log(li_obj);
            addToCart(li_obj);
        }
    );
});







