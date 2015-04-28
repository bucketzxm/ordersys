package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class return_005furl_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("<title>付款成功</title>\n");
      out.write("\n");
      out.write("<script  src = \"jquery.js\"></script>\n");
      out.write("<link rel=\"stylesheet\" href=\"owl-carousel/owl.carousel.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"owl-carousel/owl.theme.css\">\n");
      out.write("<link rel=\"stylesheet\" href=\"myCss/home.css\">\n");
      out.write("\n");
      out.write("<script src=\"owl-carousel/owl.carousel.js\"></script>\n");
      out.write("<script src=\"myJs/cart.js\"></script>\n");
      out.write("<script src=\"myJs/home.js\"></script>\n");
      out.write("\n");
      out.write("<style type=\"text/css\">\n");
      out.write("</style>\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<script src=\"jqm/jquery.js\" type=\"text/javascript\">\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<script language=\"javascript\">\n");
      out.write("\n");
      out.write("$(document).ready( function(){\n");
      out.write("\t\n");
      out.write("\tfunction jump(count){\n");
      out.write("\t\twindow.setTimeout(function(){\n");
      out.write("\t\t\tcount -- ;\n");
      out.write("\t\t\tif(count >0){\n");
      out.write("\t\t\t\t$('#num').attr(\"innerHTML\",count);\n");
      out.write("\t\t\t\tjump(count);\n");
      out.write("\t\t\t}else{\n");
      out.write("\t\t\t\tlocation.href=\"/\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t},1000);\t\n");
      out.write("\t}\n");
      out.write("\tjump(3);\n");
      out.write("});\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("\n");
      out.write("<body>  \n");
      out.write("\n");
      out.write("\t<div></div>\n");
      out.write("   \t支付成功<br/>  \n");
      out.write("    3秒后自动跳转主页。当前还剩<span id=\"num\">3</span>秒  \n");
      out.write("\t\n");
      out.write("\t<a href =\"/\">点我直接跳转</p>\n");
      out.write("\t\n");
      out.write("\t<!--填充用div-->\n");
      out.write("\t<div class=\"holdPlace\"></div>\n");
      out.write("\t<!--底部导航条-->\n");
      out.write("\t<table class=\"navBar\">\n");
      out.write("\t  <tr>\n");
      out.write("\t\t<th><a href=\"/\"><img src = \"icon/首页.png\"></a><p>首 页</p></th>\n");
      out.write("\t    <th><a href=\"/category\"><img src = \"icon/全部菜单.png\"></a><p>全部菜单</p></th>\n");
      out.write("\t\t<th><img src = \"icon/我的菜-active.png\"><p>我的菜</p></th>\n");
      out.write("\t  </tr>\n");
      out.write("\t</table>\n");
      out.write("\t\n");
      out.write("</body>  \n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
