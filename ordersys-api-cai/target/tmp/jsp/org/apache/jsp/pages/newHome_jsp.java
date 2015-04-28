package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write(" \r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<script  src = \"jqm/jquery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"owl-carousel/owl.carousel.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"owl-carousel/owl.theme.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"myCss/newHome.css\">\r\n");
      out.write("\r\n");
      out.write("<script src=\"owl-carousel/owl.carousel.js\"></script>\r\n");
      out.write("<script src=\"myJs/newHome.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<div class=\"mask\"></div>\r\n");
      out.write("<div class=\"popWindow\" align=\"center\">\r\n");
      out.write("\t\t<div class=\"wrapper\" align=\"center\">\r\n");
      out.write("\t\t\t<img src=\"images/pop.jpg\" class=\"welcomeImg\">\r\n");
      out.write("\t\t\t<img id = \"popLogo\" src=\"images/圆形logo.png\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div align=\"center\">\r\n");
      out.write("\t\t\t<div class=\"welcomeText\">welcome</div>\r\n");
      out.write("\t\t\t<div class=\"welcomeText2\">欢迎使用松鼠点餐系统</div>\r\n");
      out.write("\t\t\t<hr class=\"welcomeHr\" />\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t请选择您的桌号\r\n");
      out.write("\t\t\t<div style=\"margin-top:30px\" class=\"wrapper\">\r\n");
      out.write("\t\t\t\t<div id=\"deskSlider\" class=\"owl-carousel owl-theme markSlider\">\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">1</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">2</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">3</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">4</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">5</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">6</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">7</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">8</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">9</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">10</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">11</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">12</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">13</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">14</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">15</div>\r\n");
      out.write("\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t<div id=\"focusDeskId\"  class=\"focusCircle\">\r\n");
      out.write("\t\t\t\t\t2\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div style=\"margin-top:50px;margin-bottom:30px\">\r\n");
      out.write("\t\t\t请选择用餐人数\r\n");
      out.write("\t\t\t<div style=\"margin-top:30px\" class=\"wrapper\">\r\n");
      out.write("\t\t\t\t<div id=\"personSlider\" class=\"owl-carousel owl-theme markSlider\">\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">1</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">2</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">3</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">4</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">5</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">6</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">7</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">8</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">9</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">10</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">11</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">12</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">13</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">14</div>\r\n");
      out.write("\t\t\t\t  <div class=\"smallCircle\">15</div>\r\n");
      out.write("\t\t\t\t</div> \r\n");
      out.write("\t\t\t\t<hr />\r\n");
      out.write("\t\t\t\t<div id=\"focusPersonNum\" class=\"focusCircle\">\r\n");
      out.write("\t\t\t\t\t2\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"startButton\">\r\n");
      out.write("\t\t\t开始点餐\r\n");
      out.write("\t\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
 //检查session中是否已有值，检查mac表置session 
      out.write("\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\t<!--单张的旋转木马-->\r\n");
      out.write("\t<div id=\"owl-demo\" class=\"owl-carouse1 owl-theme markCarousel\">\r\n");
      out.write("\t  <!--div class=\"item\">\r\n");
      out.write("\t\t<img src=\"images/big.png\" alt=\"The Last of us\">\r\n");
      out.write("\t\t<div class=\"description\">\r\n");
      out.write("\t\t\t菜名菜名菜名1<br />\r\n");
      out.write("\t\t\t原价 ￥99.00  松鼠优惠价 ￥49.00\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t  </div-->\r\n");
      out.write("\t  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${aFavor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--加菜的按钮-->\r\n");
      out.write("\t<div id=\"addDish\"><!--这里干脆就只放一张图片-->\r\n");
      out.write("\t   <img src=\"images/加菜按钮.png\" width=\"100%\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--圆点导航条-->\r\n");
      out.write("\t<div class='owl-theme' id=\"pointNavHolder\"></div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div class=\"wrapper\">\r\n");
      out.write("\t<!--第二排的旋转木马-->\r\n");
      out.write("\t<div id=\"owl-recommend\" class=\"markCarousel\">\r\n");
      out.write("\t  <!--div class=\"item\">\r\n");
      out.write("\t\t<img src=\"images/small2.png\" />\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t<div>菜品1菜品1菜品1菜品1</div>\r\n");
      out.write("\t\t\t<s>原价：99.00</s><br />\r\n");
      out.write("\t\t\t现价：<strong>49.00</strong>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t  </div-->\r\n");
      out.write("\t  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${bFavor}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--左右两个箭头-->\r\n");
      out.write("\t<div id=\"leftArrowHolder\">\r\n");
      out.write("\t\t<img src = \"images/arrowLeft.png\" height = \"15px\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<div id=\"rightArrowHolder\">\r\n");
      out.write("\t\t<img src = \"images/arrowRight.png\" height = \"15px\">\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--优惠信息-->\r\n");
      out.write("<div id = \"discountInfo\">\r\n");
      out.write("\t<img src=\"images/logo.jpg\">\r\n");
      out.write("\t<div style=\"margin-left:60px;\">\r\n");
      out.write("\t\t<strong>近期优惠</strong><br />\r\n");
      out.write("\t\t<div style=\"margin-top:5px\">\r\n");
      out.write("\t\t优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息优惠信息\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<!--底部导航条-->\r\n");
      out.write("<table class=\"navBar\">\r\n");
      out.write("  <tr>\r\n");
      out.write("    <th><img src = \"icons-png/home-black.png\"></th>\r\n");
      out.write("    <th><a href=\"newMenu\"><img src = \"icons-png/bars-black.png\"></a></th>\r\n");
      out.write("\t<th><a href=\"newMyDish\"><img src = \"icons-png/user-black.png\"></a></th>\r\n");
      out.write("  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
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
