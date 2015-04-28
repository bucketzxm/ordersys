 //主菜单刚显示时发出一个resize()消息
$(document).on('pageshow', '#dishPage', function () { 
	  $(window).resize();
	  setTimeout("$(window).resize();",250);
});


$(document).on('pageinit','[data-role=page]', function(){
    $('[data-position=fixed]').fixedtoolbar({ tapToggle:false});//使底部栏不会因为点击而被消隐
    $(".activity").parent().removeClass("ui-btn-up-d");//消去activity下的一条横线
});

//点击重置时执行
function showNumSlider(obj){
	$(obj).parent().hide();
	if($(obj).parents(".formHeader").first().attr("id")=="formHeader1")
	{
		$("#owl-numSlider1").show();
		isSelect1 = false;
		$("#circle1").show();
		$("#prevArrow1").hide();
    	$("#nextArrow1").hide();
	}
	else
	{
		$("#owl-numSlider2").show();
		isSelect2 = false;
		$("#circle2").show();
		$("#prevArrow2").hide();
    	$("#nextArrow2").hide();
	}
}

//myOrderPage中的增减数量
function bubbleCount2(obj,opt)
{
	var amountObj=$(obj).parent().find(".amount").first();
	var foodId = $(obj).parents("li").first().attr("foodid");
	var myData="foodId=" + foodId;
	if(opt == 1)
	{
		
    	$.ajax({  
	        type : "post",  
	        url : "addToCart", 
	        dataType:"text",  
	        data: myData,
		    success : function(result) { 
	    	   amountObj.text(parseInt(amountObj.text())+1);
	    	   
	    	   //接着改变前面显示的图片上的数字
	    	   var objs = $(".wrapper[foodid='" + foodId + "']");
	    	   var obj,i;
	    	   for(i=0; i < objs.size(); i++)
	    	   {
	    		   obj = objs.get(i);
	    		   if($(obj).find("span").length==0)
		    		{
		    			desObj=$(obj).find("div").first();
		    			desObj.append("<span class='ui-li-count ui-btn-up-c ui-btn-corner-all' style='color:yellow;background: red;'>"+amountObj.text()+"</span>");
		    		}
		      		else{
		      			spanObj=$(obj).find("span").first();
		      			spanObj.text(amountObj.text());
		      		}	
	    	   }
	    	   //更新人均和总金额
		       setTwoCost();
		    } , 
		     error:function(error){
		     	console.log(error+"selectDesk");
	 		} 
    	}); 
	}
	 
	if(opt==-1)
	{
		if(amountObj.text() == 1)//若全部删完
		{
			currentLi=$(obj).parents("li").first();
   			$("#popLink").click();
   			return;
		}
		
    	$.ajax({  
	        type : "post",  
	        url : "orderItemCut", 
	        dataType:"text",  
	        data: myData,
		    success : function(result) { 	    
		    	if(amountObj.text() > 1)
	    	    {
	   			 	amountObj.text(parseInt(amountObj.text())-1);
		   			  //接着改变前面显示的图片上的数字
		 	    	   var objs = $(".wrapper[foodid='" + foodId + "']");
		 	    	   var obj,i;
		 	    	   for(i=0; i < objs.size(); i++)
		 	    	   {
		 	    		   obj = objs.get(i);
		 	    		   if($(obj).find("span").length > 0)
		 		    		{
		 		      			spanObj=$(obj).find("span").first();
		 		      			spanObj.text(amountObj.text());
		 		      		}	
		 	    	   }   
	    	    	
	    	    }
	    	    setTwoCost();
		    } , 
		     error:function(error){
		     	console.log(error+"selectDesk");
	 		} 
    	}); 
	}
	  
}

//删除当前菜单里的那一项
function removeLi()
{
	var foodId = currentLi.attr("foodid");
	var myData="foodId=" + foodId;
	$.ajax({  
        type : "post",  
        url : "rmFromCart", 
        dataType:"text",  
        data: myData,
	    success : function(result) { 
	       if(result == "0")
	       {
	    		currentLi.remove();
	    		//接着改变前面显示的图片上的数字
		    	   var objs = $(".wrapper[foodid='" + foodId + "']");
		    	   var obj,i;
		    	   for(i=0; i < objs.size(); i++)
		    	   {
		    		   obj = objs.get(i);
		    		   if($(obj).find("span").length > 0)
			    		{
			      			spanObj=$(obj).find("span").first();
			      			spanObj.remove();
			      		}	
		    	   }   
	       }
	       setTwoCost();
	    } , 
	     error:function(error){
	     	console.log(error+"selectDesk");
 		} 
	}); 
}

function setTwoCost()
{
	$.ajax({  
        type : "post",  
        url : "getTwoCost", 
        dataType:"json",  
	    success : function(msg) { 
	    	$("#totalCost").text(msg.totalCost);
		    $("#averageCost").text(msg.averageCost);
		    $("#myOrderPage div[data-role=header] .ui-title").text("桌号："+msg.deskId+"，人数："+msg.personNum);
	    } , 
	     error:function(error){
	     	console.log(error+"selectDesk");
 		} 
	}); 
}

//点菜单显示初始化
$(document).on('pageshow', '#myOrderPage', function () { 
	$.ajax({  
        type : "post",  
        url : "getMyOrder", 
        dataType:"json",  
	    success : function(msg) { 
	       $("#myOrder").html(msg.myOrderList);   
	       $("#totalCost").text(msg.totalCost);
	       $("#averageCost").text(msg.averageCost);
	       $("#myOrderPage div[data-role=header] .ui-title").text("桌号："+msg.deskId+"，人数："+msg.personNum); 
	    } , 
	     error:function(error){
	     	console.log(error+"selectDesk");
 		} 		 
	}); 
});

//当进入praPayPage2时自动开始下载
$(document).on("pageinit","#prePayPage",function(){
	 location.href="download"; 
});

function humanPay()
{
	 $.ajax({  
	        type : "post",  
	        url : "humanPay", 
	        dataType:"text",  
		    success : function() { 
		    	alert("您的请求已发出，小二马上就来....");
		    } , 
		     error:function(error){
		     	alert("error:humanPay");
	 		} 
   	}); 
}

$(document).on("pageinit","#homePage",function(){
    //根据表头是否显示来决定滑动条和箭头的显示
    if($("#formHeader1").attr("style").indexOf("none") < 0)
    {
    	   $(".circle").hide();
		   $(".owl-numSlider").hide();
		   isSelect1=true;
		   isSelect2=true;
	       showArrows(1);
	       showArrows(2);
    }
});

