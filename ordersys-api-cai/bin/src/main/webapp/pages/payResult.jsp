<!doctype html>
<html>
<head>
  <%@ page contentType="text/html;charset=utf-8" %>  
  <title>eBay Login</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet"  href="jqm/jquery.mobile-1.3.2.min.css">
  <script src="jqm/jquery.js"></script>
  <script src="jqm/jquery.mobile-1.3.2.min.js"></script>
  <script type="text/javascript" src="jqm/my.js"></script>
    <script type="text/javascript">  
         $(document).ready(function() {  
             function jump(count) {  
                 window.setTimeout(function(){  
                     count--;  
                     if(count > 0) {  
                         $('#num').text(count);  
                         jump(count);  
                     } else {  
                        location.href="returnToMenu";  
                     }  
                 }, 1000);  
             }  
             jump(5);  
         }); 
    </script> 
</head> 
<body>
  <h1 style="text-align: center;">${payResult}</h1>  
  <h3 style="text-align: center;"> 正在返回首页...  <span id="num">5</span></h3>  
</body>
</html>