<%-- 
    Document   : createSection
    Created on : Jun 30, 2022, 9:47:36 PM
    Author     : Harry
--%>

<%@page import="courses.CourseDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="courses.CourseBUS"%>
<%@page import="courses.CourseModel"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Section Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <%--<%
                CourseModel course = (CourseModel)request.getAttribute("CURRENT_COURSE");
            %>
            <input type="hidden" name="txtSectionCourseId" value="<%= course.getCourseId() %>">--%>
            <table>
                <tr>
                    <td><label>Select course:</label></td>
                    <%  
                        int pageNumber = 1;
                        int rowsOfPage = 100;
                        CourseBUS courseBUS = null;
                        courseBUS = new CourseBUS();
                        ArrayList<CourseDTO> courseList = courseBUS.getCourses(pageNumber, rowsOfPage);
                    %>
                    <td>
                        <select name="txtSectionCourseId">
                            <%
                                for (CourseDTO course : courseList) {
                            %>
                            <option value="<%= course.getCourseId()%>">
                                <%= course.getCourseName()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Enter section name:</label></td>
                    <td><input type="text" name="txtSectionName"></td>
                </tr>
                <tr>
                    <td><label>Enter section description:</label></td>
                    <td><textarea name="txtSectionDescription" rows="10" cols="21"></textarea></td>
                </tr>
                <tr>
                    <td><label>Enter section display index:</label></td>
                    <td><input type="number" name="txtSectionDisplayIndex"></td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" name="action" value="CreateSection">Submit</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
