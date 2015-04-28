package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class category_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>菜品种类</title>\r\n");
      out.write("<script  src = \"jquery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"myCss/category.css\">\r\n");
      out.write("\r\n");
      out.write("<link rel=\"stylesheet\" href=\"wookmark/reset.css\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"wookmark/main.css\">\r\n");
      out.write("<script src=\"wookmark/jquery.imagesloaded.js\"></script>\r\n");
      out.write("<script src=\"wookmark/jquery.wookmark.js\"></script>\r\n");
      out.write("<script src=\"myJs/category.js\"></script>\r\n");
      out.write("<style>\t \r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("<table class=\"headBar\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t\t<th>菜单</th>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("</table>\r\n");
      out.write("\r\n");
      out.write("<div id=\"mainContent\">\r\n");
      out.write("\t  <ul id=\"tiles\">\r\n");
      out.write("\t\t<!-- li>\r\n");
      out.write("\t\t\t<img src=\"newImages/1.jpg\">\r\n");
      out.write("\t\t\t<div>\r\n");
      out.write("\t\t\t\t新品推荐\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</li-->\r\n");
      out.write("\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cgPart}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t  </ul>\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!--填充用div-->\r\n");
      out.write("<div class=\"holdPlace\"></div>\r\n");
      out.write("\r\n");
      out.write("<!--底部导航条-->\r\n");
      out.write("<table class=\"navBar\">\r\n");
      out.write("  <tr>\r\n");
      out.write("   \t<th><a href=\"/\"><img src = \"icon/首页.png\"></a><p>首 页</p></th>\r\n");
      out.write("    <th><img src = \"icon/全部菜单-active.png\"><p>全部菜单</p></th>\r\n");
      out.write("\t<th><a href=\"/myDish\"><img src = \"icon/我的菜.png\"></a><p>我的菜</p></th>\r\n");
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
