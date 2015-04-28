package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class newMenu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" href=\"myCss/newMenu.css\">\r\n");
      out.write("<script src=\"myJs/newMenu.js\"></script>\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write(" <body>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"sideBar\">\r\n");
      out.write("    \t<!-- div>新品</div-->\r\n");
      out.write("    \t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${cgPart}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("\t<div id=\"dishPart\">\r\n");
      out.write("\t\t<!-- div>\r\n");
      out.write("\t\t  <div class=\"dish\">\r\n");
      out.write("\t\t\t<img src=\"images/样菜.png\">\r\n");
      out.write("\t\t\t<div>菜名菜名菜名</div>\r\n");
      out.write("\t\t\t<div>￥49.90</div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t  <div class=\"dish\">\r\n");
      out.write("\t\t\t<img src=\"images/样菜.png\">\r\n");
      out.write("\t\t\t<div>菜名菜名菜名</div>\r\n");
      out.write("\t\t\t<div>￥49.90</div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</div-->\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${dishPart}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\r\n");
      out.write("\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\r\n");
      out.write("\t<table class=\"navBar\">\r\n");
      out.write("\t  <tr>\r\n");
      out.write("\t\t<th><a href=\"/\"><img src = \"icons-png/home-black.png\"></a></th>\r\n");
      out.write("\t\t<th><img src = \"icons-png/bars-black.png\"></th>\r\n");
      out.write("\t\t<th><a href=\"newMyDish\"><img src = \"icons-png/user-black.png\"></a></th>\r\n");
      out.write("\t  </tr>\r\n");
      out.write("\t</table>\r\n");
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
