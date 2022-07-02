<%-- 
    Document   : editCourse
    Created on : Jun 30, 2022, 10:55:22 AM
    Author     : Harry
--%>

<%@page import="categories.CategoryModel"%>
<%@page import="categories.CategoryBUS"%>
<%@page import="courses.CourseDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="courses.CourseBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Course Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <table>
                <tr>
                    <td><label>Select a course to edit:</label></td>
                    <td>
                        <select name="txtCourseToEdit">
                            <%
                                CourseBUS courseBUS = new CourseBUS();
                                ArrayList<CourseDTO> courseList = courseBUS.getCourses(1, 200);
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
                    <td><label>Select new category for this course:</label></td>
                    <td>
                        <select name="txtCourseNewCategoryId">
                            <%
                                CategoryBUS categoryBUS = null;
                                categoryBUS = new CategoryBUS();
                                ArrayList<CategoryModel> categoryList = categoryBUS.getCategories(1, 200);
                                for (CategoryModel category : categoryList) {
                            %>
                            <option value="<%= category.getCategoryId()%>">
                                <%= category.getCategoryName()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter new name for this course:</label>
                    </td>
                    <td>
                        <input name="txtCourseNewName" type="text">
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Enter new description for this course:</label>
                    </td>
                    <td>
                        <textarea name="txtCourseNewDescription" rows="10" cols="50"></textarea>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Select new status for this course:</label>
                    </td>
                    <td>
                        <select name="txtCourseNewStatus">
                            <option value="Active">
                                Available
                            </option>
                            <option value="Unactive">
                                Unavailable
                            </option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td><label>Enter new price for this course:</label></td>
                    <td>
                        <input type="number" min="0" max="1000000" step="0.01" name="txtCourseNewPrice" />
                    </td>
                </tr>
                <tr>
                    <td>Enter new duration for this course:</td>
                    <td>
                        <input id="h" type="number" min="0" max="24" name="txtNewHour"/>
                        <label for="h">h</label>
                        <input id="m" type="number" min="0" max="59" name="txtNewMinute"/>
                        <label for="m">m</label>
                        <input id="s" type="number" min="0" max="59" name="txtNewSecond"/>
                        <label for="s">s</label>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" value="EditCourse" name="action">Submit</button>
                    </td>
                </tr>
            </table>
        </form>

    </body>
</html>
