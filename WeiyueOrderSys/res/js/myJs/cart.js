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

function addToCart(obj) {
    //if( $(obj).hasClass( "soldOut" ) )
    //	return;
    var foodId = $(obj).attr("foodid");
    //var myData = "foodId=" + foodId;

    $.ajax({
        type: "post",
        url: "addToCart",
        dataType: "text",
        data: {
            foodId: foodId
        },

        success: function (result) {

            //if (!($(obj).hasClass("beChoiced")))
            //    $(obj).addClass("beChoiced");
            //else {
            //    var numObj = $($(obj).find("button")[0]);
            //    var num = parseInt(numObj.text());
            //    numObj.text(num + 1);
            //}
            location.reload()
        },
        error: function (error) {
            console.log(error.message);
        }
    });
}