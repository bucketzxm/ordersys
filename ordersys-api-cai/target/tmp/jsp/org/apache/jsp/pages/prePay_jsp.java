package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class prePay_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<html><!-- 下单后的非法请求拦截后跳转到这个页面 -->\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<script src=\"jquery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"myCss/prePay.css\">\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("$(function() {\r\n");
      out.write("\t$(\"#payButton\").click(\r\n");
      out.write("\t\tfunction()\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\tlocation.href = \"/choicePay\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t);\r\n");
      out.write("});\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write(" <body>\r\n");
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
      out.write("\t\t\t\t<img src = \"icon/point.png\">\r\n");
      out.write("\t\t\t\t<span>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${personNum}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('人');
      out.write(' ');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${deskId}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("号桌</span>\r\n");
      out.write("\t\t\t\t<div> \r\n");
      out.write("\t\t\t\t\t<font>人均 ￥");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${avg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</font> | 2冷菜 3热菜 1汤 2甜点\r\n");
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
      out.write("\t\t\t<!--tr>\r\n");
      out.write("\t\t\t\t<td>翡翠白玉汤</td>\r\n");
      out.write("\t\t\t\t<td>2</td>\r\n");
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
      out.write("\t\t\t<th>合计：￥");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sum}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</th>\r\n");
      out.write("\t\t\t<th>\r\n");
      out.write("\t\t\t\t<span id=\"payButton\">\r\n");
      out.write("\t\t\t\t\t<img src=\"icon/支付.png\" />\r\n");
      out.write("\t\t\t\t\t支付\r\n");
      out.write("\t\t\t\t</span>\r\n");
      out.write("\t\t\t</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--填充用div-->\r\n");
      out.write("\t<div class=\"holdPlace\"></div>\r\n");
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
