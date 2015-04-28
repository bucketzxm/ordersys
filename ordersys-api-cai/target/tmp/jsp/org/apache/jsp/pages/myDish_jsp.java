package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class myDish_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>我的菜</title>\r\n");
      out.write("<script src=\"jquery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"myCss/myDish.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"owl-carousel/owl.carousel.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"owl-carousel/owl.theme.css\">\r\n");
      out.write("<script src=\"myJs/myDish.js\"></script>\r\n");
      out.write("<script src=\"owl-carousel/owl.carousel.js\"></script>\r\n");
      out.write("<script>\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write(" <body>\r\n");
      out.write("    <div class=\"mask\"></div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"popQuery\">\r\n");
      out.write("\t\t<img src=\"icon/realLogo.png\" class=\"logo\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t确认下单，不需要再点些优惠菜了吗？\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<table>\t\t\t\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t<img src=\"icon/首页-white.png\">\r\n");
      out.write("\t\t\t\t\t首页\r\n");
      out.write("\t\t\t\t\t<div class=\"thFocuseMark\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"middleLine\"></div>\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t<img src=\"icon/确认.png\">\r\n");
      out.write("\t\t\t\t\t确定\r\n");
      out.write("\t\t\t\t\t<div class=\"thFocuseMark\"></div>\r\n");
      out.write("\t\t\t\t</th>\t\t\t\t\t\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"popQuery\">\r\n");
      out.write("\t\t<img src=\"icon/realLogo.png\" class=\"logo\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t等服务员确定后，您可以将我保存在桌面就餐后再结账\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t是\r\n");
      out.write("\t\t\t\t\t<div class=\"thFocuseMark\"></div>\r\n");
      out.write("\t\t\t\t\t<div class=\"middleLine\"></div>\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t\t<th>\r\n");
      out.write("\t\t\t\t\t否\r\n");
      out.write("\t\t\t\t\t<div class=\"thFocuseMark\"></div>\r\n");
      out.write("\t\t\t\t</th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"popSetting\" align=\"center\">\r\n");
      out.write("\r\n");
      out.write("\t\t<div>请选择您的桌号</div>\r\n");
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
      out.write("\t\t<div>请选择用餐人数</div>\r\n");
      out.write("\t\t<div class=\"sliderWrapper\">\r\n");
      out.write("\t\t\t<div id=\"personSlider\" class=\"owl-carousel owl-theme markSlider\">\r\n");
      out.write("\t\t\t  <div class=\"sliderBegin\"></div>\r\n");
      out.write("\t\t\t  <button>1</button>\r\n");
      out.write("\t\t\t  <button>2</button>\r\n");
      out.write("\t\t\t  <button>3</button>\r\n");
      out.write("\t\t\t  <button>4</button>\r\n");
      out.write("\t\t\t  <button>5</button>\r\n");
      out.write("\t\t\t  <button>6</button>\r\n");
      out.write("\t\t\t  <button>7</button>\r\n");
      out.write("\t\t\t  <button>8</button>\r\n");
      out.write("\t\t\t  <button>9</button>\r\n");
      out.write("\t\t\t  <button>10</button>\r\n");
      out.write("\t\t\t  <button>11</button>\r\n");
      out.write("\t\t\t  <button>12</button>\r\n");
      out.write("\t\t\t  <button>13</button>\r\n");
      out.write("\t\t\t  <button>14</button>\r\n");
      out.write("\t\t\t  <button>15</button>\r\n");
      out.write("\t\t\t  <div class=\"sliderEnd\"></div>\r\n");
      out.write("\t\t\t </div> \r\n");
      out.write("\t\t\t<hr />\r\n");
      out.write("\t\t\t<button class=\"focusCircle\">\r\n");
      out.write("\t\t\t\t1\r\n");
      out.write("\t\t\t</button>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<span id=\"confirmButton\">\r\n");
      out.write("\t\t\t<img src=\"icon/确认.png\" />\r\n");
      out.write("\t\t\t确定\r\n");
      out.write("\t\t</span>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t<table class=\"headBar\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t\t<th>我的菜</th>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\t<div id=\"mainContent\">\r\n");
      out.write("\t\t<div id=\"orderInfo\">\r\n");
      out.write("\t\t\t<img src=\"icon/user-active.png\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t<div id=\"circleMark\"></div>\r\n");
      out.write("\t\t\t\t<span><personNum>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${personNum}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</personNum>人 <deskId>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${deskId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</deskId>号桌 <setting>[设置]</setting></span>\r\n");
      out.write("\t\t\t\t<div> \r\n");
      out.write("\t\t\t\t\t<font>人均 ￥<avg>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</avg></font> | 2冷菜 3热菜 1汤 2甜点\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("        \r\n");
      out.write("\t\t<table id=\"dishList\">\r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<th> 菜 单 <font>|</font></th>\r\n");
      out.write("\t\t\t\t<th> 数 量 <font>|</font></th>\r\n");
      out.write("\t\t\t\t<th> 单价(RMB) </th>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t\t<!-- tr>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t\t翡翠白玉汤\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t<img src = \"icon/plus-black.png\"> \r\n");
      out.write("\t\t\t\t\t2 \r\n");
      out.write("\t\t\t\t\t<img src = \"icon/minus-black.png\">\r\n");
      out.write("\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t<td>￥7.50</td>\r\n");
      out.write("\t\t\t</tr-->\r\n");
      out.write("\t\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myOrderList}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t\t<hr />\r\n");
      out.write("\t</div>\r\n");
      out.write("    \r\n");
      out.write("\t<table id=\"sumBar\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>合计：￥<sum>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sum}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</sum></th>\r\n");
      out.write("\t\t\t<th>\r\n");
      out.write("\t\t\t\t<span class=\"iconBtn\">\r\n");
      out.write("\t\t\t\t\t<img src=\"icon/加菜.png\" />\r\n");
      out.write("\t\t\t\t\t加菜\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t<span class=\"iconBtn\">\r\n");
      out.write("\t\t\t\t\t<img src=\"icon/下单.png\" />\r\n");
      out.write("\t\t\t\t\t下单\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--填充用div-->\r\n");
      out.write("\t<div class=\"holdPlace\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<!--底部导航条-->\r\n");
      out.write("\t<table class=\"navBar\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t\t<th><a href=\"/\"><img src = \"icon/首页.png\"></a><p>首 页</p></th>\r\n");
      out.write("\t    <th><a href=\"/category\"><img src = \"icon/全部菜单.png\"></a><p>全部菜单</p></th>\r\n");
      out.write("\t\t<th><img src = \"icon/我的菜-active.png\"><p>我的菜</p></th>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write(" </body>\r\n");
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
