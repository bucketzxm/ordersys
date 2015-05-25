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
            // amount add one
    		numObj.text( num + 1 );

            //TODO
            var priceObj = document.getElemetById("sumBar").getElementsByTagName("sum");
            priceObj.text();

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
