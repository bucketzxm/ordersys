package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class SystemError_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!doctype html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("  \r\n");
      out.write("  <title>eBay Login</title>\r\n");
      out.write("  <meta charset=\"utf-8\">\r\n");
      out.write("  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("  <link rel=\"stylesheet\"  href=\"jqm/jquery.mobile-1.3.2.min.css\">\r\n");
      out.write("  <script src=\"jqm/jquery.js\"></script>\r\n");
      out.write("  <script src=\"jqm/jquery.mobile-1.3.2.min.js\"></script>\r\n");
      out.write("  <script type=\"text/javascript\" src=\"jqm/my.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("         $(document).ready(function() {\r\n");
      out.write("             function jump(count) {\r\n");
      out.write("                 window.setTimeout(function(){\r\n");
      out.write("                     count--;\r\n");
      out.write("                     if(count > 0) {\r\n");
      out.write("                         $('#num').text(count);\r\n");
      out.write("                         jump(count);\r\n");
      out.write("                     } else {\r\n");
      out.write("                        location.href=\"login\";\r\n");
      out.write("                     }\r\n");
      out.write("                 }, 1000);\r\n");
      out.write("             }\r\n");
      out.write("             jump(5);\r\n");
      out.write("         });\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  <h1 style=\"text-align: center;\">系统出现错误</h1>\r\n");
      out.write("  <h3 style=\"text-align: center;\"> 请稍后重试..  <span id=\"num\">5</span></h3>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
