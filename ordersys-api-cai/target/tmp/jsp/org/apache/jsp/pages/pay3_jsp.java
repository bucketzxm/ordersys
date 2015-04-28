package org.apache.jsp.pages;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class pay3_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<title>支付宝支付</title>\r\n");
      out.write("<meta charset=\"utf-8\">\r\n");
      out.write("<meta name=\"viewport\"\r\n");
      out.write("\tcontent=\"width=device-width, initial-scale=1, maximum-scale=1\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"jqm/jquery.mobile-1.3.2.min.css\">\r\n");
      out.write("<script src=\"jqm/jquery.js\"></script>\r\n");
      out.write("<script src=\"jqm/jquery.mobile-1.3.2.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\tfunction showMsg(type) {\r\n");
      out.write("\t\tif (type == \"001\")//前面都对，但申请了手机验证\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t$(\"#block1\").attr(\"style\", \"display:none\");\r\n");
      out.write("\t\t\t//$(\"#mobileValidateSet\").removeClass(\"ui-hidden-accessible\");\r\n");
      out.write("\t\t\t$(\"#mobileValidateSet\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (type == \"1\") {//密码错，宝令对\r\n");
      out.write("\t\t\t$(\"#errorBox1\").text(\"密码错误!\");\r\n");
      out.write("\t\t\t$(\"#errorBox1\").show();\r\n");
      out.write("\t\t\t$(\"#errorBox2\").hide();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (type == \"01\") {//宝令错，密码对\r\n");
      out.write("\t\t\t$(\"#errorBox2\").text(\"宝令错误！\");\r\n");
      out.write("\t\t\t$(\"#errorBox2\").show();\r\n");
      out.write("\t\t\t$(\"#errorBox1\").hide();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (type == \"11\")//两个都错\r\n");
      out.write("\t\t{\r\n");
      out.write("\t\t\t$(\"#errorBox1\").text(\"密码错误！\");\r\n");
      out.write("\t\t\t$(\"#errorBox2\").text(\"宝令错误！\");\r\n");
      out.write("\t\t\t$(\"#errorBox1\").show();\r\n");
      out.write("\t\t\t$(\"#errorBox2\").show();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (type == \"6\")\r\n");
      out.write("\t\t\t$(\".error\").text(\"\");\r\n");
      out.write("\t\tif (type == \"9\") {\r\n");
      out.write("\t\t\tlocation.href = \"SystemPrompt?type=9\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (type == \"-1\") {\r\n");
      out.write("\t\t\tlocation.href = \"SystemPrompt?type=-1\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif (type == \"08\") {\r\n");
      out.write("\t\t\tlocation.href = \"SystemPrompt?type=08\";\r\n");
      out.write("\t\t}\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction checkPay3(obj) {\r\n");
      out.write("\t\tvar payPassword = $(\"#payPassword\").val();\r\n");
      out.write("\t\tvar baoling = $(\"#baoling\").val();\r\n");
      out.write("\t\tshowMsg(6);\r\n");
      out.write("\t\tif ($(\"#payPasswordSet\").attr(\"style\").indexOf(\"display:none\") < 0\r\n");
      out.write("\t\t\t\t&& payPassword == \"\") {\r\n");
      out.write("\t\t\t$(\"#errorBox1\").text(\"支付密码不能为空\");\r\n");
      out.write("\t\t\t$(\"#errorBox1\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif ($(\"#baolingSet\").attr(\"style\").indexOf(\"display:none\") < 0\r\n");
      out.write("\t\t\t\t&& !(/\\d{6}/.test(baoling))) {\r\n");
      out.write("\t\t\t$(\"#errorBox2\").text(\"宝令必须为六位数字\");\r\n");
      out.write("\t\t\t$(\"#errorBox2\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar myData = \"payPassword=\" + payPassword + \"&baoling=\" + baoling;\r\n");
      out.write("\t\tvar temp = $(obj).attr(\"onclick\");\r\n");
      out.write("\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\tbeforeSend : function() {\r\n");
      out.write("\t\t\t\t$.mobile.loading('show', {\r\n");
      out.write("\t\t\t\t\ttext : '正在验证',\r\n");
      out.write("\t\t\t\t\ttextVisible : true,\r\n");
      out.write("\t\t\t\t\ttheme : 'b',\r\n");
      out.write("\t\t\t\t\thtml : \"\"\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(obj).attr(\"onclick\", \"\");//设置链接无效\r\n");
      out.write("\t\t\t}, //Show spinner\r\n");
      out.write("\r\n");
      out.write("\t\t\tcomplete : function() {\r\n");
      out.write("\t\t\t\t$.mobile.loading('hide');\r\n");
      out.write("\t\t\t\t$(obj).attr(\"onclick\", temp);//设置链接有效\r\n");
      out.write("\t\t\t}, //Hide spinner\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : \"checkPay3\",\r\n");
      out.write("\t\t\tdata : myData,\r\n");
      out.write("\t\t\tdataType : \"text\",\r\n");
      out.write("\t\t\tsuccess : function(type) {\r\n");
      out.write("\t\t\t\t//alert(type);\r\n");
      out.write("\t\t\t\tif (type == \"0\") {//完全正确\r\n");
      out.write("\t\t\t\t\t$(\"#payContent\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#backContent\").show();\r\n");
      out.write("\t\t\t\t\tlocation.href = \"successPay3\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\tshowMsg(type);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction checkMobileValidate(obj) {\r\n");
      out.write("\t\tvar mobileValidate = $(\"#mobileValidate\").val();\r\n");
      out.write("\t\tvar myData = \"mobileValidate=\" + mobileValidate;\r\n");
      out.write("\t\tif (!(/\\d{6}/.test(mobileValidate))) {\r\n");
      out.write("\t\t\t$(\"#errorBox3\").text(\"手机校验码必须为六位数字!\");\r\n");
      out.write("\t\t\t$(\"#errorBox3\").show();\r\n");
      out.write("\t\t\treturn false;\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tvar temp = $(obj).attr(\"onclick\");\r\n");
      out.write("\t\t$(\"#mpacSubmit\").attr(\"style\", \"display:none\");\r\n");
      out.write("\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\tbeforeSend : function() {\r\n");
      out.write("\t\t\t\t$.mobile.loading('show', {\r\n");
      out.write("\t\t\t\t\ttext : '正在验证',\r\n");
      out.write("\t\t\t\t\ttextVisible : true,\r\n");
      out.write("\t\t\t\t\ttheme : 'b',\r\n");
      out.write("\t\t\t\t\thtml : \"\"\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t\t$(obj).attr(\"onclick\", \"\");//设置链接无效\r\n");
      out.write("\t\t\t}, //Show spinner\r\n");
      out.write("\r\n");
      out.write("\t\t\tcomplete : function() {\r\n");
      out.write("\t\t\t\t$.mobile.loading('hide');\r\n");
      out.write("\t\t\t\t$(obj).attr(\"onclick\", temp);//设置链接有效\r\n");
      out.write("\t\t\t}, //Hide spinner\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : \"checkMobileValidate\",\r\n");
      out.write("\t\t\tdata : myData,\r\n");
      out.write("\t\t\tdataType : \"text\",\r\n");
      out.write("\t\t\tsuccess : function(type) {\r\n");
      out.write("\t\t\t\t//alert(type);\r\n");
      out.write("\t\t\t\tif (type == \"0\") {//手机验证码正确\r\n");
      out.write("\t\t\t\t\t$(\"#payContent\").hide();\r\n");
      out.write("\t\t\t\t\t$(\"#backContent\").show();\r\n");
      out.write("\t\t\t\t\tlocation.href = \"successPay3\";\r\n");
      out.write("\t\t\t\t} else if (type == \"9\") {\r\n");
      out.write("\t\t\t\t\tlocation.href = \"SystemPrompt?type=9\";\r\n");
      out.write("\t\t\t\t} else if (type == \"-1\") {\r\n");
      out.write("\t\t\t\t\tlocation.href = \"SystemPrompt?type=-1\";\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\t$(\"#errorBox3\").text(\"校验码错误,请重新输入！\");\r\n");
      out.write("\t\t\t\t\t$(\"#mpacSubmit\").show();\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction back() {\r\n");
      out.write("\t\t$.ajax({\r\n");
      out.write("\t\t\tbeforeSend : function() {\r\n");
      out.write("\t\t\t\t$.mobile.loading('show', {\r\n");
      out.write("\t\t\t\t\ttext : '请稍等',\r\n");
      out.write("\t\t\t\t\ttextVisible : true,\r\n");
      out.write("\t\t\t\t\ttheme : 'b',\r\n");
      out.write("\t\t\t\t\thtml : \"\"\r\n");
      out.write("\t\t\t\t});\r\n");
      out.write("\t\t\t}, //Show spinner\r\n");
      out.write("\r\n");
      out.write("\t\t\tcomplete : function() {\r\n");
      out.write("\t\t\t\t$.mobile.loading('hide');\r\n");
      out.write("\t\t\t\t$(\"#reLogin\").disabled = false;\r\n");
      out.write("\t\t\t}, //Hide spinner\r\n");
      out.write("\t\t\ttype : \"post\",\r\n");
      out.write("\t\t\turl : \"back\",\r\n");
      out.write("\t\t\tdataType : \"text\",\r\n");
      out.write("\t\t\tsuccess : function(msg) {\r\n");
      out.write("\t\t\t\t//alert(msg);\r\n");
      out.write("\t\t\t\tlocation.href = \"/\";\r\n");
      out.write("\t\t\t},\r\n");
      out.write("\t\t\terror : function(error) {\r\n");
      out.write("\t\t\t\talert(\"back fail \");\r\n");
      out.write("\t\t\t\tconsole.log(error);\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t});\r\n");
      out.write("\t}\r\n");
      out.write("\r\n");
      out.write("\tfunction reLogin() {\r\n");
      out.write("        $.ajax({\r\n");
      out.write("            beforeSend : function() {\r\n");
      out.write("                $.mobile.loading('show', {\r\n");
      out.write("                    text : '请稍等',\r\n");
      out.write("                    textVisible : true,\r\n");
      out.write("                    theme : 'b',\r\n");
      out.write("                    html : \"\"\r\n");
      out.write("                });\r\n");
      out.write("            }, //Show spinner\r\n");
      out.write("\r\n");
      out.write("            complete : function() {\r\n");
      out.write("                $.mobile.loading('hide');\r\n");
      out.write("                $(\"#reLogin\").disabled = false;\r\n");
      out.write("            }, //Hide spinner\r\n");
      out.write("            type : \"post\",\r\n");
      out.write("            url : \"reLogin\",\r\n");
      out.write("            dataType : \"text\",\r\n");
      out.write("            success : function(msg) {\r\n");
      out.write("                //alert(msg);\r\n");
      out.write("                location.href = \"login\";\r\n");
      out.write("            },\r\n");
      out.write("            error : function(error) {\r\n");
      out.write("                alert(\"relogin fail \");\r\n");
      out.write("                console.log(error);\r\n");
      out.write("            }\r\n");
      out.write("        });\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write(".error {\r\n");
      out.write("\tcolor: red;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div data-role=\"page\" id=\"pay3Page\">\r\n");
      out.write("\t\t<div data-role=\"content\" id=\"payContent\">\r\n");
      out.write("\t\t\t<div style=\"text-align:right;\">\r\n");
      out.write("\t\t\t\t<a id=\"reLogin\" onclick=\"reLogin()\">重新登录</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div id=\"block1\" style=\"display:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${payDiv}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t<fieldset data-role=\"fieldcontain\" id=\"payPasswordSet\"\r\n");
      out.write("\t\t\t\t\tstyle=\"display:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isNeedPayPswdP3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<div id=\"errorBox1\" class=\"error\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"display:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isPayPswdErrorP3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${payPswdErrorBoxP3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<label for=\"payPassword\">支付密码:</label> <input type=\"password\"\r\n");
      out.write("\t\t\t\t\t\tname=\"payPassword\" id=\"payPassword\" value=\"\" />\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t<fieldset data-role=\"fieldcontain\" id=\"baolingSet\"\r\n");
      out.write("\t\t\t\t\tstyle=\"display:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isNeedBaoCodeP3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t\t<div id=\"errorBox2\" class=\"error\"\r\n");
      out.write("\t\t\t\t\t\tstyle=\"display:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isBaoCodeErrorP3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${baoCodeErrorBoxP3}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t\t\t\t\t<label for=\"baoling\">宝令：</label> <input type=\"text\" name=\"baoling\"\r\n");
      out.write("\t\t\t\t\t\tid=\"baoling\">\r\n");
      out.write("\t\t\t\t</fieldset>\r\n");
      out.write("\t\t\t\t<input id=\"paySubmit\" type=\"button\" onclick=\"checkPay3(this)\"\r\n");
      out.write("\t\t\t\t\tvalue=\"确定\" />\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t\t<!-- <fieldset data-role=\"fieldcontain\" id=\"mobileValidateSet\"\r\n");
      out.write("\t\t\t\tclass=\"ui-hidden-accessible\"> -->\r\n");
      out.write("\t\t\t<fieldset data-role=\"fieldcontain\" id=\"mobileValidateSet\"\r\n");
      out.write("\t\t\t\tstyle=\"display:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mpacDiv}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t\t\t\t<div id=\"errorBox3\" class=\"error\" style=\"display:");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${isMpacError}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mpacErrorBox}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\r\n");
      out.write("\t\t\t\t<label for=\"mobileValidate\">请输入你收到的手机校验码：</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\tname=\"mobileValidate\" id=\"mobileValidate\"> <input\r\n");
      out.write("\t\t\t\t\ttype=\"button\" id=\"mpacSubmit\" onclick=\"checkMobileValidate(this)\"\r\n");
      out.write("\t\t\t\t\tvalue=\"确定\" />\r\n");
      out.write("\t\t\t</fieldset>\r\n");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div id=\"backContent\" data-role=\"content\" style=\"display:none\">\r\n");
      out.write("\t\t\t<div style=\"text-align:center;\">\r\n");
      out.write("\t\t\t\t<a onclick=\"location.href='/'\">回到主页</a>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
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
