package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class humanPayConfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<title>现金支付确认</title>\r\n");
      out.write("<script src=\"jquery.js\"></script>\r\n");
      out.write("<title>支付提醒</title>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("    function fun()\r\n");
      out.write("\t{\r\n");
      out.write("\t\twindow.opener = null;\r\n");
      out.write("\t\twindow.open('','_self');\r\n");
      out.write("\t\twindow.close();\r\n");
      out.write("\t}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write(" <body>\r\n");
      out.write("\t<div style=\"text-align:center;margin-top:40px;color:#CF0A59;\">\r\n");
      out.write("\t\t您的请求已发出，小二马上就来。待付完钱后点击“已付款”可退出当前页面。\r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id = \"out_trade_no\">\r\n");
      out.write("\t\t<p>订单号: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${out_trade_no }", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" </p>\t\r\n");
      out.write("\t</div>\r\n");
      out.write("\t<button onClick=\"paid()\" id=\"paid\" style=\"background:#CF0A59;color:white;padding:7px;text-align:center;width:90px;margin:20px auto 0 auto;cursor:pointer;\"\">\r\n");
      out.write("\t\t\t已付款\r\n");
      out.write("\t</button>\r\n");
      out.write("\t\r\n");
      out.write("\t<script>\r\n");
      out.write("\tfunction paid(){\r\n");
      out.write("\t\tvar out_trade_no = ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${out_trade_no}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("; \r\n");
      out.write("\t\tvar myData = \"out_trade_no=\"+out_trade_no;\r\n");
      out.write("\t\t$.ajax({ \r\n");
      out.write("\t\t\t\t\ttype : \"post\",  \r\n");
      out.write("\t\t\t        url : \"checkOrderFinished\", \r\n");
      out.write("\t\t\t        dataType:\"text\",  \r\n");
      out.write("\t\t\t        data: myData,\r\n");
      out.write("\t\t\t\t    success : function(msg1) \r\n");
      out.write("\t\t\t\t    { \r\n");
      out.write("\t\t\t\t    \t\r\n");
      out.write("\t\t\t\t    \tif( msg1 == \"true\")\r\n");
      out.write("\t\t\t\t    \t{\r\n");
      out.write("\t\t\t\t    \t\talert( \"完成支付。\");\r\n");
      out.write("\t\t\t\t    \t\tlocation.href = \"/\" ; \r\n");
      out.write("\t\t\t\t    \t\treturn true;\r\n");
      out.write("\t\t\t\t    \t}\r\n");
      out.write("\t\t\t\t    \telse if(msg1 == \"false\")\r\n");
      out.write("\t\t\t\t\t\t{\r\n");
      out.write("\t\t\t\t\t\t\talert( \"订单尚未支付，请与服务员确认\");\r\n");
      out.write("\t\t\t\t\t\t\treturn false;\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t \r\n");
      out.write("\t\t\t\t    \t//console.log( \"选桌成功！\" );\r\n");
      out.write("\t\t\t\t    } , \r\n");
      out.write("\t\t\t\t    error:function(error)\r\n");
      out.write("\t\t\t\t    {\r\n");
      out.write("\t\t\t\t     \tconsole.log(error+\"orderPay\");\r\n");
      out.write("\t\t\t \t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\t\r\n");
      out.write("\t</script>\r\n");
      out.write(" </body>\r\n");
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
