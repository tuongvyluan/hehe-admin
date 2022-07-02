<%-- 
    Document   : deleteCourse
    Created on : Jul 2, 2022, 5:56:38 AM
    Author     : Harry
--%>

<%@page import="courses.CourseBUS"%>
<%@page import="courses.CourseDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Course Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td>
                        <label>Select a course to delete:</label>
                    </td>
                    <td>
                        <select name="txtCourseToDelete">
                            <%
                            int pageNumber = 1;
                            int rowsOfPage = 200;
                            CourseBUS courseBUS = new CourseBUS();
                            ArrayList<CourseDTO> courseList = courseBUS.getCourses(pageNumber, rowsOfPage);
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
                    <td>
                        <button type="submit" name="action" value="DeleteCourse">Submit</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
