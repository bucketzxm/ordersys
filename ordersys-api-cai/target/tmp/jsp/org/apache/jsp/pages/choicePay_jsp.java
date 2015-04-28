package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class choicePay_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>选择支付方式</title>\r\n");
      out.write(" <script src=\"jquery.js\"></script>\r\n");
      out.write("<link rel=\"stylesheet\" href=\"myCss/choicePay.css\">\r\n");
      out.write(" <script src=\"myJs/choicePay.js\"></script>\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\t<table class=\"headBar\">\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>选择支付方式</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("\t<table id=\"mainContent\">\r\n");
      out.write("\t\t<tr>\t\t   \r\n");
      out.write("\t\t   <td>\r\n");
      out.write("\t\t\t\t<div></div> <!-- 选中时左端的一竖-->\r\n");
      out.write("\t\t\t\t<img src=\"icon/现金.png\">\r\n");
      out.write("\t\t   </td>\r\n");
      out.write("\t\t   <td>现金支付</td>\r\n");
      out.write("\t\t   <td><img src=\"icon/arrowRight-gray.png\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t   <td>\r\n");
      out.write("\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t<img src=\"icon/支付宝.png\">\r\n");
      out.write("\t\t   </td>\r\n");
      out.write("\t\t   <td>在线支付</td>\r\n");
      out.write("\t\t   <td><img src=\"icon/arrowRight-gray.png\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t   <td>\r\n");
      out.write("\t\t\t\t<div></div>\r\n");
      out.write("\t\t\t\t<img src=\"icon/支付宝.png\">\r\n");
      out.write("\t\t   </td>\r\n");
      out.write("\t\t   <td>客户端支付</td>\r\n");
      out.write("\t\t   <td><img src=\"icon/arrowRight-gray.png\"></td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("    </table>\t\r\n");
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
