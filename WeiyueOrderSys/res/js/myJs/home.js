$(document).ready(function() {
    initCarousel();//对首页的两个旋转木马初始化
    //setMask();//设置选桌界面是否显示
    
    $(".markSlider button").click(
    		function () { 
    			silderClick( this );
    		}
	);
    
	$("#startButton").click( 
		function () { 
			selectDeskAndPerson();
		}
	);
    
	$("#owl-recommend .item").click( 
		function () { 
			addToCart( this );
		}
	);
	
	$("#owl-demo .item .addDish").click( 
		function () { 
			addToCart( $(this).parents(".item") );
		}
	);
	
});



function silderClick( obj )
{
	//点击数字使滑动条滑动的代码
	var owlObj = $(obj).parents(".markSlider").first();
	var owl = owlObj.data('owlCarousel');
	var clickIdx = parseInt( $(obj).text() );
	owl.goTo( clickIdx - 1 );
}

function initCarousel()
{
  $("#owl-demo").owlCarousel({
      navigation : true, // Show next and prev buttons
      slideSpeed : 300,
      paginationSpeed : 400,
      singleItem:true,
	  navigation:false,
	  afterInit : function(elem){
		  var that = this;
		  that.owlControls.prependTo($("#pointNavHolder"));
    }
  });

  $("#owl-recommend").owlCarousel({
	  	items : 2,
		itemsDesktop:[600,2],
	    itemsMobile:[130,1],
	    pagination:false,
	    addClassActive:true,
	    afterMove:function(){
			showArrows();
	   	}
  });

  var owl = $("#deskSlider");
  owl.owlCarousel({     
      itemsCustom : [
        [0, 3],
        [1600, 3]
      ],
      pagination:false,
	  addClassActive:true,
	  afterMove:function(){
		  updateFocus(0);
      }
  }); 
  owl.data('owlCarousel').goTo(1);
  
  owl = $("#personSlider");
  owl.owlCarousel({     
      itemsCustom : [
        [0, 3],
        [1600, 3]
      ],
      pagination:false,
	  addClassActive:true,
	  afterMove:function(){
		  updateFocus(1);
      }
  });
  owl.data('owlCarousel').goTo(1);
}

//显示和隐藏箭头
function showArrows()
{
	if($("#owl-recommend .owl-item").first().attr("class").indexOf("active") < 0)
	{
		$("#leftArrowHolder").show();
	}
	else{
		$("#leftArrowHolder").hide();
	}
	if( $("#owl-recommend .owl-item").last().attr("class").indexOf("active") < 0)
	{
		$("#rightArrowHolder").show();
	}
	else{
		$("#rightArrowHolder").hide();
	}
}

function updateFocus( flag ){
   var focusNum = $( $(".focusCircle")[flag] );
   if( flag == 0)
	 focusNum.text($($("#deskSlider .active")[1]).text());
   else if( flag == 1)
	 focusNum.text($($("#personSlider .active")[1]).text());
}