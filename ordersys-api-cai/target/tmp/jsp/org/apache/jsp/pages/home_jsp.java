package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<title>优惠首页</title>\r\n");
      out.write("<script  src = \"jquery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"owl-carousel/owl.carousel.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"owl-carousel/owl.theme.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"myCss/home.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"owl-carousel/owl.carousel.js\"></script>\r\n");
      out.write("<script src=\"myJs/cart.js\"></script>\r\n");
      out.write("<script src=\"myJs/home.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("   $(function(){\r\n");
      out.write("\t   \r\n");
      out.write("   });\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"mask\"></div>\r\n");
      out.write("<div class=\"popWindow\" align=\"center\">\r\n");
      out.write("\t\t<img src=\"icon/realLogo2.png\">\r\n");
      out.write("\t\t<div>welcome</div>\r\n");
      out.write("\t\t<div>欢迎使用松鼠点餐系统</div>\r\n");
      out.write("\t\t<hr/>\r\n");
      out.write("\r\n");
      out.write("\t\t请选择您的桌号\r\n");
      out.write("\t\t<div class=\"sliderWrapper\">\r\n");
      out.write("\t\t\t<div id=\"deskSlider\" class=\"owl-carousel owl-theme markSlider\">\r\n");
      out.write("\t\t\t  <div class=\"sliderBegin\"></div>\r\n");
      out.write("\t\t\t  <!--button>1</button>\r\n");
      out.write("\t\t\t  <button>2</button>\r\n");
      out.write("\t\t\t  <button>3</button-->\r\n");
      out.write("\t\t\t  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${deskButtons}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t\t  <div class=\"sliderEnd\"></div>\r\n");
      out.write("\t\t\t</div> \r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<button class=\"focusCircle\">\r\n");
      out.write("\t\t\t\t1\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t请选择用餐人数\r\n");
      out.write("\t\t\t<div class=\"sliderWrapper\">\r\n");
      out.write("\t\t\t\t<div id=\"personSlider\" class=\"owl-carousel owl-theme markSlider\">\r\n");
      out.write("\t\t\t\t  <div class=\"sliderBegin\"></div>\r\n");
      out.write("\t\t\t\t  <button>1</button>\r\n");
      out.write("\t\t\t\t  <button>2</button>\r\n");
      out.write("\t\t\t\t  <button>3</button>\r\n");
      out.write("\t\t\t\t  <button>4</button>\r\n");
      out.write("\t\t\t\t  <button>5</button>\r\n");
      out.write("\t\t\t\t  <button>6</button>\r\n");
      out.write("\t\t\t\t  <button>7</button>\r\n");
      out.write("\t\t\t\t  <button>8</button>\r\n");
      out.write("\t\t\t\t  <button>9</button>\r\n");
      out.write("\t\t\t\t  <button>10</button>\r\n");
      out.write("\t\t\t\t  <button>11</button>\r\n");
      out.write("\t\t\t\t  <button>12</button>\r\n");
      out.write("\t\t\t\t  <button>13</button>\r\n");
      out.write("\t\t\t\t  <button>14</button>\r\n");
      out.write("\t\t\t\t  <button>15</button>\r\n");
      out.write("\t\t\t\t  <div class=\"End\"></div>\r\n");
      out.write("\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t<button class=\"focusCircle\">\r\n");
      out.write("\t\t\t\t\t1\r\n");
      out.write("\t\t\t\t</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"startButton\">\r\n");
      out.write("\t\t\t开始点餐\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"allWrapper\">\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\t<!--单张的旋转木马-->\r\n");
      out.write("\t<div id=\"owl-demo\" class=\"owl-carouse1 owl-theme markCarousel\">\r\n");
      out.write("\t  <!--div class=\"item  beChoiced\">\r\n");
      out.write("\t\t<img src=\"newImages/big.png\">\r\n");
      out.write("\t\t<div class=\"description\">\r\n");
      out.write("\t\t\t<div>菜名菜名菜名1<span class=\"likeMark\"><img src=\"icon/like-white.png\">4.7</span></div>\r\n");
      out.write("\t\t\t<div>抢购价  <spcialPrice>￥49.00</spcialPrice></div>\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"addDish\">\r\n");
      out.write("\t\t   <button>1</button>\r\n");
      out.write("\t\t   <button class=\"addButton\">抢 购</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t  </div-->\r\n");
      out.write("      ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aFavor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t<!--圆点导航条-->\r\n");
      out.write("\t<div class='owl-theme' id=\"pointNavHolder\"></div>\r\n");
      out.write("\t<div class=\"demoMark\">超低价抢购中</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\t<!--第二排的旋转木马-->\r\n");
      out.write("\t<div id=\"owl-recommend\" class=\"markCarousel\">\r\n");
      out.write("\t  <!--div class=\"item beChoiced\">\r\n");
      out.write("\t\t<img src=\"newImages/炒年糕.jpg\" />\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<div>菜品1菜品1菜品1菜品1</div>\r\n");
      out.write("\t\t\t<del>原价：99.00</del><br />\r\n");
      out.write("\t\t\t现价：<strong>49.00</strong>\r\n");
      out.write("\t\t\t<span class=\"likeMark\"><img src=\"icon/like.png\">4.7</span>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<button>1</button>\r\n");
      out.write("\t  </div-->\r\n");
      out.write("\t  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bFavor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--左右两个箭头-->\r\n");
      out.write("\t<div id=\"leftArrowHolder\">\r\n");
      out.write("\t\t&lt;\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"rightArrowHolder\">\r\n");
      out.write("\t\t&gt;\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div class=\"recommendMark\">优惠进行中</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--优惠信息-->\r\n");
      out.write("<div id = \"discountInfo\">\r\n");
      out.write("\t<img src=\"icon/realLogo.png\">\r\n");
      out.write("\t<div>\r\n");
      out.write("\t\t<strong>近期优惠</strong><br />\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--底部导航条-->\r\n");
      out.write("<table class=\"navBar\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th><img src = \"icon/首页-active.png\"><p>首 页</p></th>\r\n");
      out.write("    <th><a href=\"/category\"><img src = \"icon/全部菜单.png\"></a><p>全部菜单</p></th>\r\n");
      out.write("\t<th><a href=\"/myDish\"><img src = \"icon/我的菜.png\"></a><p>我的菜</p></th>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
