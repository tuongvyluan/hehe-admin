<%-- 
    Document   : addSectionToCourse
    Created on : Jul 6, 2022, 2:33:22 PM
    Author     : Harry
--%>

<%@page import="courses.CourseDTO"%>
<%@page import="courses.CourseBUS"%>
<%@page import="sections.SectionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sections.SectionBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Section Page</title>
    </head>
    <body>
        <form>
            <table>
                <tr>
                    <td>
                        <label>Choose a course to start:</label>
                    </td>
                    <td>
                        <select name="txtCourseToAddSection">
                            <%
                            int pageNumber = 1;
                            int rowsOfPage = 200;
                            CourseBUS courseBUS = new CourseBUS();
                            ArrayList<CourseDTO> courseList;
                            courseList = courseBUS.getCourses(pageNumber, rowsOfPage);
                            for (CourseDTO course : courseList) {
                            %>
                            <option value="<%= course.getCourseId() %>">
                                <%= course.getCourseName() %>
                            </option>
                            <%        
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>This course already contains these sections:</label></td>
                    <td>
                        <table>
                            <%
                            SectionBUS sectionBUS = new SectionBUS();
                            ArrayList<SectionDTO> sectionList = sectionBUS.get();
                            for (SectionDTO section : sectionList) {
                            %>
                            <tr>
                                <td>
                                    <%--<%= section.getSectionName() %>--%>${param.txtCourseToAddSection}
                                </td>
                            </tr>
                            <%        
                            }
                            %>
                        </table>
                    </td>
                </tr>
                <tr>
                    <td><label>Add section:</label></td>
                    <td>
                        <select name="txtSectionToAdd">
                            <%
                            for (SectionDTO section : sectionList) {
                            %>
                            <option value="<%= section.getSectionId() %>">
                                <%= section.getSectionName() %>
                            </option>
                            <%        
                            }
                            %>
                        </select>
                        <button type="submit" value="AddSectionToCourse" name="action">Add</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
