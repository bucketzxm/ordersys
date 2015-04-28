<!doctype html>
<html>
<head>
  <%@ page contentType="text/html;charset=utf-8" %> 
  <title>主菜单</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet"  href="jqm/jquery.mobile-1.3.2.min.css">
  <script src="jqm/jquery.js"></script>
  <script src="jqm/my.js"></script>
  <script src="jqm/jquery.mobile-1.3.2.min.js"></script>
	
  <link rel="stylesheet" href="wookmark/reset.css">
  <link rel="stylesheet" href="wookmark/main.css">
 
  <script src="wookmark/jquery.imagesloaded.js"></script>
  <script src="wookmark/jquery.wookmark.js"></script>
  <!-- link rel="stylesheet" href="wookmark/style.css"--><!-- 动画效果，但是会导致种类取消后无法完全显示 -->

  <link rel="stylesheet" href="owl-carousel/owl.carousel.css">
  <link rel="stylesheet" href="owl-carousel/owl.theme.css">
  <script src="owl-carousel/owl.carousel.js"></script>
  
  <script src="qtip/jquery.qtip.js"></script>
  <link rel="stylesheet" href="qtip/jquery.qtip.css">
   
  <link rel="stylesheet" href="css/homePage.css">
  <link rel="stylesheet" href="css/dishPage.css">
  <link rel="stylesheet" href="css/other.css">
  
  <script src="js/global.js"></script>
  <script src="js/numSlider.js"></script>
  <script src="js/recommend.js"></script>
  <script src="js/tips.js"></script>
  <script src="js/other.js"></script>
</head>

<body>
	<a class="tipAnchor" id="tipAnchor1"></a>	
	<a class="tipAnchor" id="tipAnchor2"></a>	
	<a class="tipAnchor" id="tipAnchor3"></a>
		   	  
<div data-role="page" id="homePage" data-theme="d">
	<div data-role="content">
	  <ul data-role="listview"  data-divider-theme="b">   
		<li data-role="list-divider">手机优惠
		    <div class="formHeader" id="formHeader1"  style="opacity: 1;${fomerDisplay}">
		    <font>${fomerDesk}</font>
		    <a  data-role="button" data-icon="bars" data-iconpos="notext" data-iconshadow="false" data-inline="true" onclick="showNumSlider(this)"></a>
		    </div>		
		</li>
	    <li>
			<div class="owl-recommend" id="owl-recommend1">
				${aFavor}	
			</div>		
		 
			<div class="jcarousel-control" id="prevArrow1" style="left:1%;display:none;">&lsaquo;</div>
            <div class="jcarousel-control" id="nextArrow1" style="right:1%;display:none;">&rsaquo;</div>
            
			<div class="circle" id="circle1">1</div>
			<div id="owl-numSlider1" class="owl-carousel owl-theme owl-numSlider floatSlider">
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>				
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1 align="right">选择</h1></div>
				<div class="item"><h1 align="left">桌号</h1></div>
				
		     	<div class="item"><h1>&nbsp;</h1></div>
		     	<div class="item realItem"><h1>1</h1></div><!--index=7  -->
				<div class="item realItem"><h1>2</h1></div>
				<div class="item realItem"><h1>3</h1></div>
				<div class="item realItem"><h1>4</h1></div>
				<div class="item realItem"><h1>5</h1></div>
				<div class="item realItem"><h1>6</h1></div>
				<div class="item realItem"><h1>7</h1></div>
				<div class="item realItem"><h1>8</h1></div>
				<div class="item realItem"><h1>9</h1></div>
				<div class="item realItem"><h1>10</h1></div>
				<div class="item realItem"><h1>11</h1></div>
				<div class="item realItem"><h1>12</h1></div>
				<div class="item realItem"><h1>13</h1></div>
				<div class="item realItem"><h1>14</h1></div>
				<div class="item realItem"><h1>15</h1></div><!--index=21 -->
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
		    </div>
	    </li>

	   		

	   <li data-role="list-divider">商家推荐
	   <div class="formHeader owl-theme" id="formHeader2"  style="opacity: 1; ${fomerDisplay}">
	   <font>${fomerPerson}</font>
	    <a href="" data-role="button" data-icon="bars" data-iconpos="notext" data-iconshadow="false" data-inline="true" onclick="showNumSlider(this)"></a>
	   </div>
	   </li>
	    <li>
		    <div class="owl-recommend" id="owl-recommend2">
		    	${bFavor}
		    </div>
		    
			<div class="jcarousel-control" id="prevArrow2" style="left:1%;display:none;">&lsaquo;</div>
            <div class="jcarousel-control" id="nextArrow2" style="right:1%;display:none;">&rsaquo;</div>
            
			<div class="circle" id="circle2">1</div>
	   		<div id="owl-numSlider2" class="owl-carousel owl-theme owl-numSlider  floatSlider">
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>				
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1 align="right">选择</h1></div>
				<div class="item"><h1 align="left">人数</h1></div>
				
		     	<div class="item"><h1>&nbsp;</h1></div>
		     	<div class="item realItem"><h1>1</h1></div><!--index=7  -->
				<div class="item realItem"><h1>2</h1></div>
				<div class="item realItem"><h1>3</h1></div>
				<div class="item realItem"><h1>4</h1></div>
				<div class="item realItem"><h1>5</h1></div>
				<div class="item realItem"><h1>6</h1></div>
				<div class="item realItem"><h1>7</h1></div>
				<div class="item realItem"><h1>8</h1></div>
				<div class="item realItem"><h1>9</h1></div>
				<div class="item realItem"><h1>10</h1></div>
				<div class="item realItem"><h1>11</h1></div>
				<div class="item realItem"><h1>12</h1></div>
				<div class="item realItem"><h1>13</h1></div>
				<div class="item realItem"><h1>14</h1></div>
				<div class="item realItem"><h1>15</h1></div><!--index=21 -->
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
				<div class="item"><h1>&nbsp;</h1></div>
		    </div>
	    </li>
	    <li data-role="list-divider">活动版块</li>
	    <li>
	    	<p class="activity">
	    		<br/><strong>星期一</strong>
	    		<br/>
	    		超级至尊披萨 普通装400克 正价59元 半价34.5元<br/>
	    		超级至尊披萨750克 正价99元 半价49.5元<br/>
	    		香草凤尾虾 75克 正价24元 半价12元
	    	</p>
	    </li>
	  </ul>
	</div>
    		  
	 <div data-role="footer" data-theme="b" data-position="fixed">
		  <img class="mascot" src="images2/松鼠.png" />
		  <div class="sayPoint" id="sayPoint1"></div>
		  <div data-role="navbar">
				  <ul>
					<li><a href="#dishPage">主菜单</a></li>
					<li><a href="#myOrderPage">我的菜</a></li>
				  </ul>
		 </div>
	 </div>
</div>

	<div data-role="page" id="dishPage"><!--小样-->
		<table style="border:0;height:100%;width=100%;">
		  <tr>
			<td  height="100%">
			  <ul data-role="listview" id="filters">
				  ${cgPart}
			  </ul>
			</td>
			<td style="width: 100%">
			<div id="container">
			<div id="main"  style="margin:0">
			  <ul id="tiles">
		        ${dishPart}   
		      </ul>
			</div>
		  </div>
		 </td>
		</tr>
		</table>
		 <div data-role="footer" data-theme="c" data-position="fixed">
		 <img class="mascot" src="images2/松鼠.png" />
          <div class="sayPoint" id="sayPoint2"></div>
		  <div data-role="navbar">
				  <ul>
					<li><a href="#homePage">首页</a></li>
					<li><a href="#myOrderPage">我的菜</a></li>
				  </ul>
		 </div>
	 </div>
	</div>
	<script>
    //这段原本放下面
    (function ($){
      $('#tiles').imagesLoaded(function() {
        // Prepare layout options.
        var options = {
          itemWidth: 85, // Optional min width of a grid item
          autoResize: true, // This will auto-update the layout when the browser window is resized.
          container: $('#tiles'), // Optional, used for some extra CSS styling
          offset: 2, // Optional, the distance between grid items
          outerOffset: 2, // Optional the distance from grid to parent
          flexibleWidth: 150,  // Optional, the maximum width of a grid item
        };

        // Get a reference to your grid items.
        var handler = $('#tiles li'),
		filters = $('#filters li[data-filter]');
        // Call the layout function.
        handler.wookmark(options);

        var onClickFilter = function(event) {
          var item = $(event.currentTarget),
              activeFilters = [];

          if (!item.hasClass('active')) {
            filters.removeClass('active');
          }
          item.toggleClass('active');

          // Filter by the currently selected filter
          if (item.hasClass('active')) {
            activeFilters.push(item.data('filter'));
          }

          handler.wookmarkInstance.filter(activeFilters);
        };

        // Capture filter click events.
        filters.click(onClickFilter);
      });
    })(jQuery);
	</script>
		  <div  data-role="page" id="myOrderPage">
		<div data-role="header" data-theme = "b">
	      <h1>点菜单</h1>
	    </div>
	
	   <div data-role="content">
	     <ul id="myOrder" data-role="listview" data-split-icon="minus" data-split-theme="d" data-count-theme="e">
	     
		 </ul>
		 <div align = "center" style='font-size:25px;font-weight:700;margin-top:20px;margin-bottom:35px;'>
		 	<p>共： ￥<font id = "totalCost"></font></p>
		 	<p>人均： ￥<font id = "averageCost"></font></p>
		 </div>
	   </div>
		<a href="#purchase" id="popLink" data-rel="popup" data-position-to="window" data-transition="pop"></a>
        <div data-role="popup" id="purchase" data-theme="d" data-overlay-theme="b" class="ui-content" style="max-width:340px; padding-bottom:2em;">
			<h3>确定要删除这个菜?</h3>
			<a onclick="removeLi()" data-mini="true" data-role="button" data-role="button" data-rel="back">确定</a>
			<a data-mini="true" data-rel="back" data-role="button" data-role="button" data-theme="b">取消</a>
		</div>

	    <div data-role="footer" data-position="fixed" data-theme = "b">
		  <img class="mascot" src="images2/松鼠.png" />
          <div class="sayPoint" id="sayPoint3"></div>
	       <div data-role="navbar">
			  <ul>
				<li><a href="#homePage">加菜</a></li>
				<li><a href="#askDownLoad" data-role="button" data-rel="dialog">选好了</a></li>
			  </ul>
			</div>
	    </div>  
	</div>
	  
	 <div data-role="page" id="askDownLoad">
			<div data-role="header">
			  <h1>确认</h1>
			</div>
			<div data-role="content"> 
			  <h1 style="text-align: center;">是否要就记住这家店?</h1>
			  <p><a href="prePay?mode=2" data-role="button" data-transition="slidedown">是</a></p>    
			  <p><a href="prePay?mode=1" data-role="button">否</a></p>    
			</div>
	  </div>  
</body>
</html>
