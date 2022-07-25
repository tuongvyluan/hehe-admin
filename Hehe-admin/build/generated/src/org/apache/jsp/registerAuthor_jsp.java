package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import students.StudentError;

public final class registerAuthor_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("\r\n");
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
      out.write("\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/77d5a89f77.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <!--===============================================================================================-->\r\n");
      out.write("\r\n");
      out.write("        <title>Author Register</title>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
 StudentError error = (StudentError) request.getAttribute("ERROR");
            if (error == null) {
                error = new StudentError();
            }
      out.write("\r\n");
      out.write("\r\n");
      out.write("        <div class=\"limiter\">\r\n");
      out.write("\r\n");
      out.write("            <div class=\"container-login100\" style=\"background-image: url('images/loginBackground.jpg');\">\r\n");
      out.write("                <div class=\"wrap-login100 regis p-l-55 p-r-55 p-t-40 p-b-40\" style=\"width:1000px\">\r\n");
      out.write("                    <form name=\"Register\" method=\"POST\" action=\"MainControllerAdmin\"\r\n");
      out.write("                          class=\"login100-form validate-form\" id=\"authorRegister\" >\r\n");
      out.write("                        <input hidden=\"\" name=\"action\" value=\"RegisterAuthor\">\r\n");
      out.write("                        <input hidden=\"\" name=\"controller\" value=\"RegisterAuthor\">\r\n");
      out.write("\r\n");
      out.write("                        <span class=\"login100-form-title p-b-39\">\r\n");
      out.write("                            Author Register\r\n");
      out.write("                        </span>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"wrapper\" style=\"display: flex; justify-content: space-between;\">\r\n");
      out.write("                            <div class=\"input-wrapper\" style=\"width: 40%\">\r\n");
      out.write("                                <div class=\"wrap-input100 validate-input m-b-23\">\r\n");
      out.write("                                    <span class=\"label-input100\">Email <span style=\"color: red\">*</span></span>\r\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input100\" required=\"\" type=\"text\"\r\n");
      out.write("                                           name=\"email\" placeholder=\"Email\">\r\n");
      out.write("                                    <span class=\"focus-input100\" data-symbol=\"&#xf206;\"></span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    ");
      out.print( error.getEmail());
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"wrap-input100 validate-input m-b-23\">\r\n");
      out.write("                                    <span class=\"label-input100\">Password <span\r\n");
      out.write("                                            style=\"color: red\">*</span></span>\r\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input100\" required=\"\"\r\n");
      out.write("                                           type=\"password\" name=\"password\" placeholder=\"Password\" minlength=\"4\"\r\n");
      out.write("                                           maxlength=\"50\">\r\n");
      out.write("                                    <span class=\"focus-input100\" data-symbol=\"&#xf190;\"></span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    ");
      out.print( error.getPassword());
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"wrap-input100 validate-input\">\r\n");
      out.write("                                    <span class=\"label-input100\">Confirm <span\r\n");
      out.write("                                            style=\"color: red\">*</span></span>\r\n");
      out.write("                                    <input value=\"\" class=\"input100\" required=\"\" type=\"password\" name=\"confirm\"\r\n");
      out.write("                                           placeholder=\"Confirm password\" minlength=\"4\" maxlength=\"50\">\r\n");
      out.write("                                    <span class=\"focus-input100\" data-symbol=\"&#xf190;\"></span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                            <div class=\"input-wrapper\" style=\"width: 40%\">\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"wrap-input100 validate-input m-b-23\">\r\n");
      out.write("                                    <span class=\"label-input100\">First name</span>\r\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.firstName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input100\" type=\"text\"\r\n");
      out.write("                                           name=\"firstName\" placeholder=\"First name\" maxlength=\"20\">\r\n");
      out.write("                                    <span class=\"focus-input100\" data-symbol=\"&#xf206;\"></span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    ");
      out.print( error.getFirstName());
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"wrap-input100 validate-input m-b-23\">\r\n");
      out.write("                                    <span class=\"label-input100\">Last name</span>\r\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.lastName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input100\" type=\"text\"\r\n");
      out.write("                                           name=\"lastName\" placeholder=\"Last name\" maxlength=\"50\">\r\n");
      out.write("                                    <span class=\"focus-input100\" data-symbol=\"&#xf206;\"></span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    ");
      out.print( error.getLastName());
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("                                \r\n");
      out.write("                                <div class=\"wrap-input100 validate-input m-b-23\">\r\n");
      out.write("                                    <span class=\"label-input100\">Date of birth</span>\r\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.dob}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input100\" type=\"text\"\r\n");
      out.write("                                           name=\"dob\" placeholder=\"Date of birth\" maxlength=\"50\">\r\n");
      out.write("                                    <span class=\"focus-input100\" data-symbol=\"&#xf206;\"></span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    ");
      out.print( error.getDob());
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("\r\n");
      out.write("                                <div class=\"wrap-input100\">\r\n");
      out.write("                                    <span class=\"label-input100\">Phone number</span>\r\n");
      out.write("                                    <input value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${param.phoneNumber}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" class=\"input100\" type=\"tel\"\r\n");
      out.write("                                           name=\"phoneNumber\" pattern=\"[0-9]{10}\" placeholder=\"Phone number\">\r\n");
      out.write("                                    <span class=\"focus-input100\" data-symbol=\"&#xf190;\"></span>\r\n");
      out.write("                                </div>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    ");
      out.print( error.getPhoneNumber());
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
      out.write("\r\n");
      out.write("                        <div class=\"text-right p-t-20\">\r\n");
      out.write("                            <div class=\"container-login100-form-btn\">\r\n");
      out.write("                                <div class=\"wrap-login100-form-btn\">\r\n");
      out.write("                                    <div onclick=\"submit_form('authorRegister')\" class=\"login100-form-bgbtn\"></div>\r\n");
      out.write("                                    <button class=\"login100-form-btn\" style=\"\">\r\n");
      out.write("                                        Register\r\n");
      out.write("                                    </button>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                    </form>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <script src=\"js/validate.js\"></script>\r\n");
      out.write("        <script>\r\n");
      out.write("                                function submit_form(form_id) {\r\n");
      out.write("                                    var form = document.getElementById(form_id);\r\n");
      out.write("                                    form.submit();\r\n");
      out.write("                                }\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
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
