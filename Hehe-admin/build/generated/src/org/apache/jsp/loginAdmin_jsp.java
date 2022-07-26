package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Login admin</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/mycss.css\" type=\"text/css\"/>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" href=\"images/icons/favicon.ico\" />\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/bootstrap/css/bootstrap.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/font-awesome-4.7.0/css/font-awesome.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"fonts/iconic/css/material-design-iconic-font.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animate/animate.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/css-hamburgers/hamburgers.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/animsition/css/animsition.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/select2/select2.min.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"vendor/daterangepicker/daterangepicker.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/util.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/main.css\">\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"limiter\">\r\n");
      out.write("            <div class=\"container-login100\" style=\"background-image: url('images/loginBackground.jpg');\">\r\n");
      out.write("                <div class=\"wrap-login100 p-l-55 p-r-55 p-t-40 p-b-40\">\r\n");
      out.write("                    <form name=\"Login\" method=\"POST\" action=\"MainControllerAdmin\" class=\"login100-form validate-form\">\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                        <input hidden=\"\" name=\"controller\" value=\"Admin\"> \r\n");
      out.write("                        <input hidden=\"\" name=\"action\" value=\"LoginAdmin\">\r\n");
      out.write("                        <span class=\"login100-form-title p-b-39\">\r\n");
      out.write("                            Login\r\n");
      out.write("                        </span>\r\n");
      out.write("\r\n");
      out.write("                        <!-- pattern=\"^([^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff]+|\\x22([^\\x0d\\x22\\x5c\\x80-\\xff]|\\x5c[\\x00-\\x7f])*\\x22)(\\x2e([^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff]+|\\x22([^\\x0d\\x22\\x5c\\x80-\\xff]|\\x5c[\\x00-\\x7f])*\\x22))*\\x40([^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff]+|\\x5b([^\\x0d\\x5b-\\x5d\\x80-\\xff]|\\x5c[\\x00-\\x7f])*\\x5d)(\\x2e([^\\x00-\\x20\\x22\\x28\\x29\\x2c\\x2e\\x3a-\\x3c\\x3e\\x40\\x5b-\\x5d\\x7f-\\xff]+|\\x5b([^\\x0d\\x5b-\\x5d\\x80-\\xff]|\\x5c[\\x00-\\x7f])*\\x5d))*(\\.\\w{2,})+$\"\r\n");
      out.write("                        -->\r\n");
      out.write("                        <font style=\"color: red\">");
      out.print( (request.getAttribute("WARNING") == null) ? "" : (String) request.getAttribute("WARNING"));
      out.write("</font>\r\n");
      out.write("                        <div class=\"wrap-input100 validate-input m-b-23\" data-validate=\"Email is required\">\r\n");
      out.write("                            <span class=\"label-input100\">Email</span>\r\n");
      out.write("                            <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"email\" class=\"input100\" type=\"text\" name=\"email\"\r\n");
      out.write("                                   placeholder=\"Type your email\"\r\n");
      out.write("                                   title=\"The domain portion of the email address is invalid (the portion after the @).\">\r\n");
      out.write("                            <span class=\"focus-input100\" data-symbol=\"&#xf206;\"></span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"wrap-input100 validate-input\" data-validate=\"Password is required\">\r\n");
      out.write("                            <span class=\"label-input100\">Password</span>\r\n");
      out.write("                            <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" id=\"password\" class=\"input100\" type=\"password\"\r\n");
      out.write("                                   name=\"password\" placeholder=\"Type your password\">\r\n");
      out.write("                            <span class=\"focus-input100\" data-symbol=\"&#xf190;\"></span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <br>\r\n");
      out.write("                        ");

                            String login_msg = (String) request.getAttribute("error");
                            if (login_msg != null) {
                                out.println("<font color=red size=4px>" + login_msg + "</font>");
                            }
                        
      out.write("\r\n");
      out.write("                        <div class=\"container-login100-form-btn\">\r\n");
      out.write("                            <div class=\"wrap-login100-form-btn\">\r\n");
      out.write("                                <div class=\"login100-form-bgbtn\"></div>\r\n");
      out.write("\r\n");
      out.write("                                <button type=\"submit\" class=\"login100-form-btn\">\r\n");
      out.write("                                    Login\r\n");
      out.write("                                </button>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"txt1 text-center p-t-30 p-b-20\">\r\n");
      out.write("                            <span>\r\n");
      out.write("                                Or Login Using\r\n");
      out.write("                            </span>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"flex-c-m\">\r\n");
      out.write("                            <a href=\"https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/Hehe-admin/login-google-admin&response_type=code\r\n");
      out.write("                               &client_id=894467286073-gu13he3q90ma2on3nfjigafidbtvpgur.apps.googleusercontent.com&approval_prompt=force\" class=\"login100-social-item bg3\">\r\n");
      out.write("                                <i class=\"fa fa-google\"></i>\r\n");
      out.write("                            </a>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"js/validate.js\"></script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
