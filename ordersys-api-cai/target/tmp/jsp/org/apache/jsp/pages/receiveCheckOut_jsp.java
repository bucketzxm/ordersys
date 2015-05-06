package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class receiveCheckOut_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\t<head>\n");
      out.write("\t\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\t\t<title>Insert title here</title>\n");
      out.write("\t</head>\n");
      out.write("\t<body>\n");
      out.write("\t\t<button id=\"startButton\" onclick=\"start()\">开始上班</button>\n");
      out.write("\t\t<button onclick=\"stop()\">停止接受</button>\n");
      out.write("\t\t\n");
      out.write("\t\t<button onclick=\"clearText()\">清空</button>\n");
      out.write("\t\t\n");
      out.write("\t\t<textarea id = \"displayTextArea\" readonly=\"readonly\" rows=\"30\"></textarea>\n");
      out.write("\t\t\n");
      out.write("\t\t<script>\n");
      out.write("\t\t\tvar eventSource = null;\n");
      out.write("\t\t\t\n");
      out.write("\t\t\tfunction start(){\n");
      out.write("\t\t\t\teventSource = new EventSource(\"http://192.168.100.135:8088/receiveCheckOut/serverSent\");\n");
      out.write("\t\t\t\t/* eventSource.onopen = function(){\n");
      out.write("\t\t\t\t\tdisplayTextArea.value += \"Connected... \"+ \"\\n\";\n");
      out.write("\t\t\t\t}; */\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\teventSource.onmessage = function(message)\n");
      out.write("\t\t\t\t{\n");
      out.write("\t\t\t\t\t//alert(message);\n");
      out.write("\t\t\t\t\tdisplayTextArea.value += message.data + '\\n\\n';\n");
      out.write("\t\t\t\t};\n");
      out.write("\t\t\t\t\n");
      out.write("\t\t\t\tstartButton.disabled = true;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tfunction stop(){\n");
      out.write("\t\t\t\teventSource.close();\n");
      out.write("\t\t\t\tstartButton.disabled = false;\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\tfunction clearText(){\n");
      out.write("\t\t\t\tdisplayTextArea.value = \"\";\n");
      out.write("\t\t\t}\n");
      out.write("\t\t\n");
      out.write("\t\t</script>\n");
      out.write("\t\t\t\n");
      out.write("\t</body>\n");
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
