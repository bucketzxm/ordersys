package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class evaluate_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>菜品评价</title>\r\n");
      out.write("<script src = \"jquery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"myCss/evaluate.css\">\r\n");
      out.write("<script src = \"myJs/evaluate.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"mask\"></div>\r\n");
      out.write("\t<div class=\"popQuery\">\r\n");
      out.write("\t\t<img src=\"icon/realLogo.png\" class=\"logo\">\r\n");
      out.write("\t\t<div>\r\n");
      out.write("\t\t\t是否对用餐内容进行评价？\r\n");
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
      out.write("\r\n");
      out.write("\t<table class=\"headBar\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t\t<th>口味评价</th>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"mainContent\">\r\n");
      out.write("\t\t<table>\r\n");
      out.write("\t\t  <tr>\r\n");
      out.write("\t\t\t<th>菜单<font>|</font></th>\r\n");
      out.write("\t\t\t<th>评分</th>\r\n");
      out.write("\t\t  </tr>\r\n");
      out.write("\r\n");
      out.write("\t\t  <!--tr>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t翡翠白玉汤\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t\t<td>\r\n");
      out.write("\t\t\t\t<img src=\"icon/heart-white.png\">\r\n");
      out.write("\t\t\t\t<img src=\"icon/heart-white.png\">\r\n");
      out.write("\t\t\t\t<img src=\"icon/heart-white.png\">\r\n");
      out.write("\t\t\t\t<img src=\"icon/heart-white.png\">\r\n");
      out.write("\t\t\t\t<img src=\"icon/heart-white.png\">\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t  </tr-->\r\n");
      out.write("\r\n");
      out.write("\t\t  ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${myOrderList}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\t</table>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div class=\"promotion\">\r\n");
      out.write("\t\t<img src=\"icon/微信.jpg\">\r\n");
      out.write("\t\t<img src=\"icon/新浪微博.jpg\">\r\n");
      out.write("\t\t<img src=\"icon/腾讯微博.jpg\">\r\n");
      out.write("\t\t<img src=\"icon/人人.jpg\">\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\t<div class=\"popWeixin\">\r\n");
      out.write("\t\t<img src=\"images/微信演示.png\">\r\n");
      out.write("\t\t<div>确定</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<!--填充用div-->\r\n");
      out.write("\t<div class=\"holdPlace\"></div>\r\n");
      out.write("\r\n");
      out.write("\t<!--底部导航条-->\r\n");
      out.write("\t<table class=\"navBar\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t\t<th>\r\n");
      out.write("\t\t\t<span class=\"iconBtn\">\r\n");
      out.write("\t\t\t\t<img src=\"icon/确认.png\" />\r\n");
      out.write("\t\t\t\t发表评价\r\n");
      out.write("\t\t\t</span>\r\n");
      out.write("\t\t</th>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
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
