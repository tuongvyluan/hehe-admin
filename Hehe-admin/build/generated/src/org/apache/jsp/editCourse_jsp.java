package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import categories.CategoryModel;
import categories.CategoryBUS;
import courses.CourseDTO;
import java.util.ArrayList;
import courses.CourseBUS;

public final class editCourse_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/./miniHeader.jsp");
  }

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>Edit Course Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <header>\r\n");
      out.write("            <a href=\"./createCourse.jsp\">CREATE COURSE</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./editCourse.jsp\">EDIT COURSE</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./deleteCourse.jsp\">DELETE COURSE</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./createSection.jsp\">CREATE SECTION</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./editSection.jsp\">EDIT SECTION</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./deleteSection.jsp\">DELETE SECTION</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./addSectionToCourse.jsp\">ADD SECTION TO COURSE</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./createTopic.jsp\">CREATE TOPIC</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./editTopic.jsp\">EDIT TOPIC</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"./deleteTopic.jsp\">DELETE TOPIC</a>\r\n");
      out.write("            <br>\r\n");
      out.write("            <a href=\"\">QUIZ & ANSWER</a>\r\n");
      out.write("        </header>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("        <form action=\"MainController\" method=\"POST\">\r\n");
      out.write("            <table>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><label>Select a course to edit:</label></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <select name=\"txtCourseToEdit\">\r\n");
      out.write("                            ");

                                CourseBUS courseBUS = new CourseBUS();
                                ArrayList<CourseDTO> courseList = courseBUS.getCourses(1, 200);
                                for (CourseDTO course : courseList) {
                            
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print( course.getCourseId());
      out.write("\">\r\n");
      out.write("                                ");
      out.print( course.getCourseName());
      out.write("\r\n");
      out.write("                            </option>\r\n");
      out.write("                            ");

                                }
                            
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><label>Select new category for this course:</label></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <select name=\"txtCourseNewCategoryId\">\r\n");
      out.write("                            ");

                                CategoryBUS categoryBUS = null;
                                categoryBUS = new CategoryBUS();
                                ArrayList<CategoryModel> categoryList = categoryBUS.getCategories(1, 200);
                                for (CategoryModel category : categoryList) {
                            
      out.write("\r\n");
      out.write("                            <option value=\"");
      out.print( category.getCategoryId());
      out.write("\">\r\n");
      out.write("                                ");
      out.print( category.getCategoryName());
      out.write("\r\n");
      out.write("                            </option>\r\n");
      out.write("                            ");

                                }
                            
      out.write("\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label>Enter new name for this course:</label>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input name=\"txtCourseNewName\" type=\"text\">\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label>Enter new description for this course:</label>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <textarea name=\"txtCourseNewDescription\" rows=\"10\" cols=\"50\"></textarea>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <label>Select new status for this course:</label>\r\n");
      out.write("                    </td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <select name=\"txtCourseNewStatus\">\r\n");
      out.write("                            <option value=\"Active\">\r\n");
      out.write("                                Available\r\n");
      out.write("                            </option>\r\n");
      out.write("                            <option value=\"Unactive\">\r\n");
      out.write("                                Unavailable\r\n");
      out.write("                            </option>\r\n");
      out.write("                        </select>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td><label>Enter new price for this course:</label></td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input type=\"number\" min=\"0\" max=\"1000000\" step=\"0.01\" name=\"txtCourseNewPrice\" />\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>Enter new duration for this course:</td>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <input id=\"h\" type=\"number\" min=\"0\" max=\"24\" name=\"txtNewHour\"/>\r\n");
      out.write("                        <label for=\"h\">h</label>\r\n");
      out.write("                        <input id=\"m\" type=\"number\" min=\"0\" max=\"59\" name=\"txtNewMinute\"/>\r\n");
      out.write("                        <label for=\"m\">m</label>\r\n");
      out.write("                        <input id=\"s\" type=\"number\" min=\"0\" max=\"59\" name=\"txtNewSecond\"/>\r\n");
      out.write("                        <label for=\"s\">s</label>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("                <tr>\r\n");
      out.write("                    <td>\r\n");
      out.write("                        <button type=\"submit\" value=\"EditCourse\" name=\"action\">Submit</button>\r\n");
      out.write("                    </td>\r\n");
      out.write("                </tr>\r\n");
      out.write("            </table>\r\n");
      out.write("        </form>\r\n");
      out.write("\r\n");
      out.write("    </body>\r\n");
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
