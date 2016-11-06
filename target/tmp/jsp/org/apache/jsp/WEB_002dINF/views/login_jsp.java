package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\r');
      out.write('\n');

	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path;

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta charset=\"utf-8\" />\r\n");
      out.write("\t<title>login</title>\r\n");
      out.write("\t<link   rel=\"icon\" href=\"http://img.wenyifan.net/images/favicon.ico\" type=\"image/x-icon\" />\r\n");
      out.write("\t<meta content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" name=\"viewport\" />\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("/libs/bootstrap-3.3.0/css/bootstrap.min.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<link href=\"");
      out.print(basePath);
      out.write("/css/login.css\" rel=\"stylesheet\" />\r\n");
      out.write("\t<script src=\"");
      out.print(basePath);
      out.write("/libs/jquery-3.1.1.min.js\"></script>\r\n");
      out.write("\t<script src=\"");
      out.print(basePath);
      out.write("/libs/bootstrap-3.3.0/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t<script type=\"text/javascript\">\r\n");
      out.write("\t\tvar basePath=\"");
      out.print(basePath);
      out.write("\";\r\n");
      out.write("\t\t$(function() {\r\n");
      out.write("\t\t\t$(\"#txtSubmit\").click(function() {\r\n");
      out.write("\t\t\t\tlogin();\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t});\r\n");
      out.write("\t\r\n");
      out.write("\t\tfunction login() {\r\n");
      out.write("\t\t\t$.post(basePath + \"/login\", {\r\n");
      out.write("\t\t\t\tuserName : $(\"#txtUserName\").val(),\r\n");
      out.write("\t\t\t\tpassword : $(\"#txtPassword\").val()\r\n");
      out.write("\t\t\t}, function(result) {\r\n");
      out.write("\t\t\t\tif (result.status == \"200\") {\r\n");
      out.write("\t\t\t\t\twindow.location.href = result.back_url;\r\n");
      out.write("\t\t\t\t} else {\r\n");
      out.write("\t\t\t\t\talert(result.message);\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t});\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<div class=\"panel panel-primary login-box\">\r\n");
      out.write("\t\t<div class=\"panel-heading\">登录</div>\r\n");
      out.write("\t\t<div class=\"panel-body\">\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"txtUserName\">登录名：</label> <input type=\"text\"\r\n");
      out.write("\t\t\t\t\tclass=\"form-control\" id=\"txtUserName\" placeholder=\"请输入登录名\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"form-group\">\r\n");
      out.write("\t\t\t\t<label for=\"txtPassword\">密码：</label> <input type=\"password\"\r\n");
      out.write("\t\t\t\t\tclass=\"form-control\" id=\"txtPassword\" placeholder=\"请输入密码\">\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<div class=\"checkbox\">\r\n");
      out.write("\t\t\t\t<label> <input type=\"checkbox\"> 记住我\r\n");
      out.write("\t\t\t\t</label>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<button type=\"submit\" class=\"btn btn-primary\" id=\"txtSubmit\">登录</button>\r\n");
      out.write("\t\t\t<div id=\"loginResult\"></div>\r\n");
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
