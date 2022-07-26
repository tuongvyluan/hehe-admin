package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class authorManagement_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_forEach_var_items;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_url_var_value;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_out_value_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_param_value_name_nobody;
  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_forEach_var_items = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_url_var_value = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_out_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_param_value_name_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_forEach_var_items.release();
    _jspx_tagPool_c_url_var_value.release();
    _jspx_tagPool_c_out_value_nobody.release();
    _jspx_tagPool_c_param_value_name_nobody.release();
    _jspx_tagPool_c_if_test.release();
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

      out.write("\n");
      out.write("     \n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html lang=\"en\">\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width,initial-scale=1\">\n");
      out.write("        <title>Admin</title>\n");
      out.write("        <!-- Favicon icon -->\n");
      out.write("        <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"images/favicon.png\">\n");
      out.write("        <!-- Pignose Calender -->\n");
      out.write("        <link href=\"./plugins/pg-calendar/css/pignose.calendar.min.css\" rel=\"stylesheet\">\n");
      out.write("        <!-- Chartist -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"./plugins/chartist/css/chartist.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css\">\n");
      out.write("        <!-- Custom Stylesheet -->\n");
      out.write("        <link href=\"css/style_admin.css\" rel=\"stylesheet\">\n");
      out.write("        <script src=\"https://kit.fontawesome.com/77d5a89f77.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        <!--*******************\n");
      out.write("            Preloader start\n");
      out.write("        ********************-->\n");
      out.write("        <div id=\"preloader\">\n");
      out.write("            <div class=\"loader\">\n");
      out.write("                <svg class=\"circular\" viewBox=\"25 25 50 50\">\n");
      out.write("                <circle class=\"path\" cx=\"50\" cy=\"50\" r=\"20\" fill=\"none\" stroke-width=\"3\" stroke-miterlimit=\"10\" />\n");
      out.write("                </svg>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!--*******************\n");
      out.write("            Preloader end\n");
      out.write("        ********************-->\n");
      out.write("\n");
      out.write("\n");
      out.write("        <!--**********************************\n");
      out.write("            Main wrapper start\n");
      out.write("        ***********************************-->\n");
      out.write("        <div id=\"main-wrapper\">\n");
      out.write("\n");
      out.write("            <!--**********************************\n");
      out.write("                Nav header start\n");
      out.write("            ***********************************-->\n");
      out.write("            <div class=\"nav-header\">\n");
      out.write("                <div class=\"brand-logo\">\n");
      out.write("                    <a href=\"admin.jsp\">\n");
      out.write("\n");
      out.write("                        <span class=\"logo-compact\"><img src=\"./images/logowhite-removebg-preview.png\" alt=\"\"></span>\n");
      out.write("                        <span class=\"brand-title\">\n");
      out.write("                            <img\n");
      out.write("                                src=\"images/logowhite-removebg-preview.png\"\n");
      out.write("                                alt=\"\"\n");
      out.write("                                class=\"img-fluid\"\n");
      out.write("                                height=\"10rem\"\n");
      out.write("                                />\n");
      out.write("                        </span>\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--**********************************\n");
      out.write("                Nav header end\n");
      out.write("            ***********************************-->\n");
      out.write("\n");
      out.write("            <!--**********************************\n");
      out.write("                Header start\n");
      out.write("            ***********************************-->\n");
      out.write("            <div class=\"header\">    \n");
      out.write("                <div class=\"header-content clearfix\">\n");
      out.write("\n");
      out.write("                    <div class=\"nav-control\">\n");
      out.write("                        <div class=\"hamburger\">\n");
      out.write("                            <span class=\"toggle-icon\"><i class=\"icon-menu\"></i></span>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"header-left\">\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"header-right\">\n");
      out.write("                        <ul class=\"clearfix\">\n");
      out.write("                            <li class=\"icons dropdown\"><a href=\"javascript:void(0)\" data-toggle=\"dropdown\">\n");
      out.write("                                    <i class=\"mdi mdi-email-outline\"></i>\n");
      out.write("                                    <span class=\"badge badge-pill gradient-1\">3</span>\n");
      out.write("                                </a>\n");
      out.write("                                <div class=\"drop-down animated fadeIn dropdown-menu\">\n");
      out.write("                                    <div class=\"dropdown-content-heading d-flex justify-content-between\">\n");
      out.write("                                        <span class=\"\">3 New Messages</span>  \n");
      out.write("                                        <a href=\"javascript:void()\" class=\"d-inline-block\">\n");
      out.write("                                            <span class=\"badge badge-pill gradient-1\">3</span>\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"dropdown-content-body\">\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li class=\"notification-unread\">\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <img class=\"float-left mr-3 avatar-img\" src=\"images/avatar/1.jpg\" alt=\"\">\n");
      out.write("                                                    <div class=\"notification-content\">\n");
      out.write("                                                        <div class=\"notification-heading\">Saiful Islam</div>\n");
      out.write("                                                        <div class=\"notification-timestamp\">08 Hours ago</div>\n");
      out.write("                                                        <div class=\"notification-text\">Hi Teddy, Just wanted to let you ...</div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li class=\"notification-unread\">\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <img class=\"float-left mr-3 avatar-img\" src=\"images/avatar/2.jpg\" alt=\"\">\n");
      out.write("                                                    <div class=\"notification-content\">\n");
      out.write("                                                        <div class=\"notification-heading\">Adam Smith</div>\n");
      out.write("                                                        <div class=\"notification-timestamp\">08 Hours ago</div>\n");
      out.write("                                                        <div class=\"notification-text\">Can you do me a favour?</div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <img class=\"float-left mr-3 avatar-img\" src=\"images/avatar/3.jpg\" alt=\"\">\n");
      out.write("                                                    <div class=\"notification-content\">\n");
      out.write("                                                        <div class=\"notification-heading\">Barak Obama</div>\n");
      out.write("                                                        <div class=\"notification-timestamp\">08 Hours ago</div>\n");
      out.write("                                                        <div class=\"notification-text\">Hi Teddy, Just wanted to let you ...</div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <img class=\"float-left mr-3 avatar-img\" src=\"images/avatar/4.jpg\" alt=\"\">\n");
      out.write("                                                    <div class=\"notification-content\">\n");
      out.write("                                                        <div class=\"notification-heading\">Hilari Clinton</div>\n");
      out.write("                                                        <div class=\"notification-timestamp\">08 Hours ago</div>\n");
      out.write("                                                        <div class=\"notification-text\">Hello</div>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"icons dropdown\"><a href=\"javascript:void(0)\" data-toggle=\"dropdown\">\n");
      out.write("                                    <i class=\"mdi mdi-bell-outline\"></i>\n");
      out.write("                                    <span class=\"badge badge-pill gradient-2\">3</span>\n");
      out.write("                                </a>\n");
      out.write("                                <div class=\"drop-down animated fadeIn dropdown-menu dropdown-notfication\">\n");
      out.write("                                    <div class=\"dropdown-content-heading d-flex justify-content-between\">\n");
      out.write("                                        <span class=\"\">2 New Notifications</span>  \n");
      out.write("                                        <a href=\"javascript:void()\" class=\"d-inline-block\">\n");
      out.write("                                            <span class=\"badge badge-pill gradient-2\">5</span>\n");
      out.write("                                        </a>\n");
      out.write("                                    </div>\n");
      out.write("                                    <div class=\"dropdown-content-body\">\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <span class=\"mr-3 avatar-icon bg-success-lighten-2\"><i class=\"icon-present\"></i></span>\n");
      out.write("                                                    <div class=\"notification-content\">\n");
      out.write("                                                        <h6 class=\"notification-heading\">Events near you</h6>\n");
      out.write("                                                        <span class=\"notification-text\">Within next 5 days</span> \n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <span class=\"mr-3 avatar-icon bg-danger-lighten-2\"><i class=\"icon-present\"></i></span>\n");
      out.write("                                                    <div class=\"notification-content\">\n");
      out.write("                                                        <h6 class=\"notification-heading\">Event Started</h6>\n");
      out.write("                                                        <span class=\"notification-text\">One hour ago</span> \n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <span class=\"mr-3 avatar-icon bg-success-lighten-2\"><i class=\"icon-present\"></i></span>\n");
      out.write("                                                    <div class=\"notification-content\">\n");
      out.write("                                                        <h6 class=\"notification-heading\">Event Ended Successfully</h6>\n");
      out.write("                                                        <span class=\"notification-text\">One hour ago</span>\n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <span class=\"mr-3 avatar-icon bg-danger-lighten-2\"><i class=\"icon-present\"></i></span>\n");
      out.write("                                                    <div class=\"notification-content\">\n");
      out.write("                                                        <h6 class=\"notification-heading\">Events to Join</h6>\n");
      out.write("                                                        <span class=\"notification-text\">After two days</span> \n");
      out.write("                                                    </div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("                                        </ul>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"icons dropdown d-none d-md-flex\">\n");
      out.write("                                <a href=\"javascript:void(0)\" class=\"log-user\"  data-toggle=\"dropdown\">\n");
      out.write("                                    <span>English</span>  <i class=\"fa fa-angle-down f-s-14\" aria-hidden=\"true\"></i>\n");
      out.write("                                </a>\n");
      out.write("                                <div class=\"drop-down dropdown-language animated fadeIn  dropdown-menu\">\n");
      out.write("                                    <div class=\"dropdown-content-body\">\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li><a href=\"javascript:void()\">English</a></li>\n");
      out.write("                                            <li><a href=\"javascript:void()\">Dutch</a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"icons dropdown\">\n");
      out.write("                                <div class=\"user-img c-pointer position-relative\"   data-toggle=\"dropdown\">\n");
      out.write("                                    <span class=\"activity active\"></span>\n");
      out.write("                                    <img src=\"images/hehe.png\" height=\"40\" width=\"40\" alt=\"\">\n");
      out.write("                                </div>\n");
      out.write("                                <div class=\"drop-down dropdown-profile animated fadeIn dropdown-menu\">\n");
      out.write("                                    <div class=\"dropdown-content-body\">\n");
      out.write("                                        <ul>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"app-profile.html\"><i class=\"icon-user\"></i> <span>Profile</span></a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"javascript:void()\">\n");
      out.write("                                                    <i class=\"icon-envelope-open\"></i> <span>Inbox</span> <div class=\"badge gradient-3 badge-pill gradient-1\">3</div>\n");
      out.write("                                                </a>\n");
      out.write("                                            </li>\n");
      out.write("\n");
      out.write("                                            <hr class=\"my-2\">\n");
      out.write("                                            <li>\n");
      out.write("                                                <a href=\"page-lock.html\"><i class=\"icon-lock\"></i> <span>Lock Screen</span></a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li><a href=\"AdminController?action=LogOut\"><i class=\"icon-key\"></i> <span>Logout</span></a></li>\n");
      out.write("                                        </ul>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </li>\n");
      out.write("                        </ul>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--**********************************\n");
      out.write("                Header end ti-comment-alt\n");
      out.write("            ***********************************-->\n");
      out.write("\n");
      out.write("            <!--**********************************\n");
      out.write("                Sidebar start\n");
      out.write("            ***********************************-->\n");
      out.write("            <div class=\"nk-sidebar\">           \n");
      out.write("                <div class=\"nk-nav-scroll\">\n");
      out.write("                    <ul class=\"metismenu\" id=\"menu\">\n");
      out.write("                        <li class=\"nav-label\">Dashboard</li>\n");
      out.write("                        <li>\n");
      out.write("                            <a href=\"admin.jsp\" aria-expanded=\"false\" >\n");
      out.write("                                <i class=\"icon-home menu-icon\"></i><span>Home</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li >\n");
      out.write("                            <form  name=\"ViewStudent\"  action=\"MainControllerAdmin\" method=\"POST\" id=\"duong\" aria-expanded=\"false\" >\n");
      out.write("                                <input type=\"hidden\" name=\"action\" value=\"ViewStudent\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"controller\" value=\"Student\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.search}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"pageNumber\" value=\"1\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"rowsOfPage\" value=\"15\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <a onClick=\"submit_form('duong')\"  aria-expanded=\"false\">\n");
      out.write("                                <i class=\"icon-user menu-icon\"></i><span class=\"nav-text\">Student management</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <form  name=\"ViewAuthor\"  action=\"MainControllerAdmin\" method=\"POST\" id=\"author\" aria-expanded=\"false\" >\n");
      out.write("                                <input type=\"hidden\" name=\"action\" value=\"ViewAuthor\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"controller\" value=\"Author\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.search}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"pageNumber\" value=\"1\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"rowsOfPage\" value=\"15\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <a onClick=\"submit_form('author')\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"icon-user menu-icon\"></i><span class=\"nav-text\">Author management</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <form  name=\"ViewCourse\"  action=\"MainControllerAdmin\" method=\"POST\" id=\"course\" aria-expanded=\"false\"  >\n");
      out.write("                                <input type=\"hidden\" name=\"action\" value=\"ViewCourse\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"controller\" value=\"Course\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"search\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.search}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"pageNumber\" value=\"1\"/>\n");
      out.write("                                <input type=\"hidden\" name=\"rowsOfPage\" value=\"15\"/>\n");
      out.write("                            </form>\n");
      out.write("                            <a onClick=\"submit_form('course')\" aria-expanded=\"false\">\n");
      out.write("                                <i class=\"icon-user menu-icon\"></i><span class=\"nav-text\">Course management</span>\n");
      out.write("                            </a>\n");
      out.write("                        </li>\n");
      out.write("                        \n");
      out.write("                    </ul>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--**********************************\n");
      out.write("                Sidebar end\n");
      out.write("            ***********************************-->\n");
      out.write("\n");
      out.write("            <!--**********************************\n");
      out.write("                Content body start\n");
      out.write("            ***********************************-->\n");
      out.write("            <div class=\"content-body\">\n");
      out.write("\n");
      out.write("                <div class=\"container-fluid mt-3\">\n");
      out.write("      <h1>Author management</h1>\n");
      out.write("                    <form action=\"AuthorController\" method=\"post\">\n");
      out.write("                        <div class=\"input-group icons\">\n");
      out.write("                            \n");
      out.write("                            <input type=\"search\" class=\"form-control\" placeholder=\"Search author\" aria-label=\"Search Dashboard\" name=\"txtSearch\">\n");
      out.write("                            <div class=\"drop-down animated flipInX d-md-none\">\n");
      out.write("                                \n");
      out.write("                                \n");
      out.write("                            </div>\n");
      out.write("                             <input class=\"btn btn-primary m-1\" type=\"submit\" name=\"action\" value=\"Search\"><br/>\n");
      out.write("                        </div>\n");
      out.write("                        ");

                                    String login_msg = (String) request.getAttribute("errorNotFound");
                                    if (login_msg != null) {
                                        out.println("<font color=red size=4px>" + login_msg + "</font>");
                                    }
                                
      out.write("\n");
      out.write("                    </form>\n");
      out.write("                    <h1></h1>\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-12\">\n");
      out.write("                            <div class=\"row\">\n");
      out.write("                                <div class=\"col-12\">\n");
      out.write("\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-lg-12\">\n");
      out.write("                            <div class=\"card\">\n");
      out.write("                                <div class=\"card-body\">\n");
      out.write("                                    <div class=\"active-member\">\n");
      out.write("                                        <div class=\"table-responsive\">\n");
      out.write("                                            <table class=\"table table-xs mb-0\">\n");
      out.write("                                                <thead>\n");
      out.write("                                                    <tr>\n");
      out.write("                                                        <th>User</th>\n");
      out.write("\n");
      out.write("                                                        <th>First name</th>\n");
      out.write("                                                        <th>Last name</th>\n");
      out.write("                                                        <th>Email</th>\n");
      out.write("                                                        <th>Status</th>\n");
      out.write("                                                        <th>Phone</th>\n");
      out.write("\n");
      out.write("                                                        <th>Action</th>\n");
      out.write("\n");
      out.write("                                                    </tr>\n");
      out.write("                                                </thead>\n");
      out.write("                                                <tbody>\n");
      out.write("                                                    ");
      if (_jspx_meth_c_forEach_0(_jspx_page_context))
        return;
      out.write("\n");
      out.write("                                                </tbody>\n");
      out.write("                                            </table>\n");
      out.write("                                        </div>\n");
      out.write("                                    </div>\n");
      out.write("                                </div>\n");
      out.write("                            </div>                        \n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    \n");
      out.write("                </div>\n");
      out.write("                <!-- #/ container -->\n");
      out.write("            </div>\n");
      out.write("            <!--**********************************\n");
      out.write("                Content body end\n");
      out.write("            ***********************************-->\n");
      out.write("\n");
      out.write("\n");
      out.write("            <!--**********************************\n");
      out.write("                Footer start\n");
      out.write("            ***********************************-->\n");
      out.write("            <div class=\"footer\">\n");
      out.write("                <div class=\"copyright\">\n");
      out.write("                    <p>Copyright &copy; Designed & Developed by <a href=\"https://themeforest.net/user/quixlab\">Quixlab</a> 2018</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            <!--**********************************\n");
      out.write("                Footer end\n");
      out.write("            ***********************************-->\n");
      out.write("        </div>\n");
      out.write("        <!--**********************************\n");
      out.write("            Main wrapper end\n");
      out.write("        ***********************************-->\n");
      out.write("\n");
      out.write("        <!--**********************************\n");
      out.write("            Scripts\n");
      out.write("        ***********************************-->\n");
      out.write("        <script src=\"plugins/common/common.min.js\"></script>\n");
      out.write("        <script src=\"js/custom.min.js\"></script>\n");
      out.write("        <script src=\"js/settings.js\"></script>\n");
      out.write("        <script src=\"js/gleek.js\"></script>\n");
      out.write("        <script src=\"js/styleSwitcher.js\"></script>\n");
      out.write("\n");
      out.write("        <!-- Chartjs -->\n");
      out.write("        <script src=\"./plugins/chart.js/Chart.bundle.min.js\"></script>\n");
      out.write("        <!-- Circle progress -->\n");
      out.write("        <script src=\"./plugins/circle-progress/circle-progress.min.js\"></script>\n");
      out.write("        <!-- Datamap -->\n");
      out.write("        <script src=\"./plugins/d3v3/index.js\"></script>\n");
      out.write("        <script src=\"./plugins/topojson/topojson.min.js\"></script>\n");
      out.write("        <script src=\"./plugins/datamaps/datamaps.world.min.js\"></script>\n");
      out.write("        <!-- Morrisjs -->\n");
      out.write("        <script src=\"./plugins/raphael/raphael.min.js\"></script>\n");
      out.write("        <script src=\"./plugins/morris/morris.min.js\"></script>\n");
      out.write("        <!-- Pignose Calender -->\n");
      out.write("        <script src=\"./plugins/moment/moment.min.js\"></script>\n");
      out.write("        <script src=\"./plugins/pg-calendar/js/pignose.calendar.min.js\"></script>\n");
      out.write("        <!-- ChartistJS -->\n");
      out.write("        <script src=\"./plugins/chartist/js/chartist.min.js\"></script>\n");
      out.write("        <script src=\"./plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js\"></script>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script src=\"./js/dashboard/dashboard-1.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            function submit_form(form_id) {\n");
      out.write("                var form = document.getElementById(form_id);\n");
      out.write("                form.submit();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
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

  private boolean _jspx_meth_c_forEach_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_forEach_0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _jspx_tagPool_c_forEach_var_items.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    _jspx_th_c_forEach_0.setPageContext(_jspx_page_context);
    _jspx_th_c_forEach_0.setParent(null);
    _jspx_th_c_forEach_0.setVar("auth");
    _jspx_th_c_forEach_0.setItems((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${requestScope.AUTHOR_LIST}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int[] _jspx_push_body_count_c_forEach_0 = new int[] { 0 };
    try {
      int _jspx_eval_c_forEach_0 = _jspx_th_c_forEach_0.doStartTag();
      if (_jspx_eval_c_forEach_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\n");
          out.write("                                                        <tr>\n");
          out.write("                                                            <td>");
          if (_jspx_meth_c_out_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                                            <td>");
          if (_jspx_meth_c_out_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                                            <td>");
          if (_jspx_meth_c_out_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                                            <td>");
          if (_jspx_meth_c_out_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                                            <td>");
          if (_jspx_meth_c_out_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("                                                            <td>");
          if (_jspx_meth_c_out_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("</td>\n");
          out.write("\n");
          out.write("\n");
          out.write("                                                                <td>\n");
          out.write("                                                                ");
          if (_jspx_meth_c_if_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                                                    ");
          if (_jspx_meth_c_if_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_forEach_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
            return true;
          out.write("\n");
          out.write("                                                            </td>\n");
          out.write("\n");
          out.write("\n");
          out.write("                                                        </tr>\n");
          out.write("                                                    ");
          int evalDoAfterBody = _jspx_th_c_forEach_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_c_forEach_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
        return true;
      }
    } catch (Throwable _jspx_exception) {
      while (_jspx_push_body_count_c_forEach_0[0]-- > 0)
        out = _jspx_page_context.popBody();
      _jspx_th_c_forEach_0.doCatch(_jspx_exception);
    } finally {
      _jspx_th_c_forEach_0.doFinally();
      _jspx_tagPool_c_forEach_var_items.reuse(_jspx_th_c_forEach_0);
    }
    return false;
  }

  private boolean _jspx_meth_c_out_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_0 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_0.setPageContext(_jspx_page_context);
    _jspx_th_c_out_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getAuthorId()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_0 = _jspx_th_c_out_0.doStartTag();
    if (_jspx_th_c_out_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_0);
    return false;
  }

  private boolean _jspx_meth_c_out_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_1 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_1.setPageContext(_jspx_page_context);
    _jspx_th_c_out_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_1.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getFirstName()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_1 = _jspx_th_c_out_1.doStartTag();
    if (_jspx_th_c_out_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_1);
    return false;
  }

  private boolean _jspx_meth_c_out_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_2 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_2.setPageContext(_jspx_page_context);
    _jspx_th_c_out_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_2.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getLastName()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_2 = _jspx_th_c_out_2.doStartTag();
    if (_jspx_th_c_out_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_2);
    return false;
  }

  private boolean _jspx_meth_c_out_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_3 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_3.setPageContext(_jspx_page_context);
    _jspx_th_c_out_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_3.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getEmail()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_3 = _jspx_th_c_out_3.doStartTag();
    if (_jspx_th_c_out_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_3);
    return false;
  }

  private boolean _jspx_meth_c_out_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_4 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_4.setPageContext(_jspx_page_context);
    _jspx_th_c_out_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_4.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getStatus()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_4 = _jspx_th_c_out_4.doStartTag();
    if (_jspx_th_c_out_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_4);
    return false;
  }

  private boolean _jspx_meth_c_out_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:out
    org.apache.taglibs.standard.tag.rt.core.OutTag _jspx_th_c_out_5 = (org.apache.taglibs.standard.tag.rt.core.OutTag) _jspx_tagPool_c_out_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.OutTag.class);
    _jspx_th_c_out_5.setPageContext(_jspx_page_context);
    _jspx_th_c_out_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_out_5.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getPhoneNumber()}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_out_5 = _jspx_th_c_out_5.doStartTag();
    if (_jspx_th_c_out_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
      return true;
    }
    _jspx_tagPool_c_out_value_nobody.reuse(_jspx_th_c_out_5);
    return false;
  }

  private boolean _jspx_meth_c_if_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getStatus() == 'Active'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                                    ");
        if (_jspx_meth_c_url_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                                                    <a class=\"btn btn-primary\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mylink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">Block</a>\n");
        out.write("                                                                ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_url_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_0 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_0.setPageContext(_jspx_page_context);
    _jspx_th_c_url_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_0);
    _jspx_th_c_url_0.setVar("mylink");
    _jspx_th_c_url_0.setValue("AuthorController");
    int _jspx_eval_c_url_0 = _jspx_th_c_url_0.doStartTag();
    if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_push_body_count_c_forEach_0[0]++;
        _jspx_th_c_url_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_0.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                                                        ");
        if (_jspx_meth_c_param_0((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                                                        ");
        if (_jspx_meth_c_param_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                                                        ");
        if (_jspx_meth_c_param_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_0, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                                                    ");
        int evalDoAfterBody = _jspx_th_c_url_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
        _jspx_push_body_count_c_forEach_0[0]--;
    }
    if (_jspx_th_c_url_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_0);
    return false;
  }

  private boolean _jspx_meth_c_param_0(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_0 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_0.setPageContext(_jspx_page_context);
    _jspx_th_c_param_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_0.setName("id");
    _jspx_th_c_param_0.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getAuthorId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_0 = _jspx_th_c_param_0.doStartTag();
    if (_jspx_th_c_param_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_0);
    return false;
  }

  private boolean _jspx_meth_c_param_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_1 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_1.setPageContext(_jspx_page_context);
    _jspx_th_c_param_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_1.setName("status");
    _jspx_th_c_param_1.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getStatus()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_1 = _jspx_th_c_param_1.doStartTag();
    if (_jspx_th_c_param_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_1);
    return false;
  }

  private boolean _jspx_meth_c_param_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_2 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_2.setPageContext(_jspx_page_context);
    _jspx_th_c_param_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_0);
    _jspx_th_c_param_2.setName("action");
    _jspx_th_c_param_2.setValue("updateStatusAccount");
    int _jspx_eval_c_param_2 = _jspx_th_c_param_2.doStartTag();
    if (_jspx_th_c_param_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_2);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_2);
    return false;
  }

  private boolean _jspx_meth_c_if_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_forEach_0, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_forEach_0);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getStatus() == 'Inactive'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\n");
        out.write("                                                                    ");
        if (_jspx_meth_c_url_1((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                                                    <a class=\"btn btn-primary\" href=\"");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${mylink}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("\">Un-Block</a>\n");
        out.write("                                                                ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_url_1(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:url
    org.apache.taglibs.standard.tag.rt.core.UrlTag _jspx_th_c_url_1 = (org.apache.taglibs.standard.tag.rt.core.UrlTag) _jspx_tagPool_c_url_var_value.get(org.apache.taglibs.standard.tag.rt.core.UrlTag.class);
    _jspx_th_c_url_1.setPageContext(_jspx_page_context);
    _jspx_th_c_url_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_url_1.setVar("mylink");
    _jspx_th_c_url_1.setValue("AuthorController");
    int _jspx_eval_c_url_1 = _jspx_th_c_url_1.doStartTag();
    if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
        out = _jspx_page_context.pushBody();
        _jspx_push_body_count_c_forEach_0[0]++;
        _jspx_th_c_url_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
        _jspx_th_c_url_1.doInitBody();
      }
      do {
        out.write("\n");
        out.write("                                                                        ");
        if (_jspx_meth_c_param_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_1, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                                                        ");
        if (_jspx_meth_c_param_4((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_1, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                                                        ");
        if (_jspx_meth_c_param_5((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_url_1, _jspx_page_context, _jspx_push_body_count_c_forEach_0))
          return true;
        out.write("\n");
        out.write("                                                                    ");
        int evalDoAfterBody = _jspx_th_c_url_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
      if (_jspx_eval_c_url_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
        out = _jspx_page_context.popBody();
        _jspx_push_body_count_c_forEach_0[0]--;
    }
    if (_jspx_th_c_url_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_1);
      return true;
    }
    _jspx_tagPool_c_url_var_value.reuse(_jspx_th_c_url_1);
    return false;
  }

  private boolean _jspx_meth_c_param_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_3 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_3.setPageContext(_jspx_page_context);
    _jspx_th_c_param_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_1);
    _jspx_th_c_param_3.setName("id");
    _jspx_th_c_param_3.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getAuthorId()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_3 = _jspx_th_c_param_3.doStartTag();
    if (_jspx_th_c_param_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_3);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_3);
    return false;
  }

  private boolean _jspx_meth_c_param_4(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_4 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_4.setPageContext(_jspx_page_context);
    _jspx_th_c_param_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_1);
    _jspx_th_c_param_4.setName("status");
    _jspx_th_c_param_4.setValue((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${auth.getStatus()}", java.lang.String.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_param_4 = _jspx_th_c_param_4.doStartTag();
    if (_jspx_th_c_param_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_4);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_4);
    return false;
  }

  private boolean _jspx_meth_c_param_5(javax.servlet.jsp.tagext.JspTag _jspx_th_c_url_1, PageContext _jspx_page_context, int[] _jspx_push_body_count_c_forEach_0)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:param
    org.apache.taglibs.standard.tag.rt.core.ParamTag _jspx_th_c_param_5 = (org.apache.taglibs.standard.tag.rt.core.ParamTag) _jspx_tagPool_c_param_value_name_nobody.get(org.apache.taglibs.standard.tag.rt.core.ParamTag.class);
    _jspx_th_c_param_5.setPageContext(_jspx_page_context);
    _jspx_th_c_param_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_url_1);
    _jspx_th_c_param_5.setName("action");
    _jspx_th_c_param_5.setValue("updateStatusAccount");
    int _jspx_eval_c_param_5 = _jspx_th_c_param_5.doStartTag();
    if (_jspx_th_c_param_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_5);
      return true;
    }
    _jspx_tagPool_c_param_value_name_nobody.reuse(_jspx_th_c_param_5);
    return false;
  }
}
