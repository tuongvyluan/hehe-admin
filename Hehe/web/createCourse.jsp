<%-- 
    Document   : createCourse.jsp
    Created on : Jun 30, 2022, 10:24:34 AM
    Author     : Harry
--%>

<%@page import="courses.CourseDTO"%>
<%@page import="courses.CourseBUS"%>
<%@page import="sections.SectionDTO"%>
<%@page import="sections.SectionBUS"%>
<%@page import="categories.CategoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="categories.CategoryBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <form action="MainController" method="POST">
            <table>
                <tr>
                    <td><label>Enter course name:</label></td>
                    <td><input type="text" name="txtCourseName" /></td>
                </tr>
                <tr>
                    <td><label>Enter course description:</label></td>
                    <td><input type="text" name="txtCourseDescription" /></td>
                </tr>
                <tr>
                    <td><label>Enter course author:</label></td>
                    <td><input type="number" name="txtCourseAuthorId" /></td>
                </tr>
                <tr>
                    <td><label>Select course categories:</label></td>
                    <%  
                        int pageNumber = 1;
                        int rowsOfPage = 10;
                        CategoryBUS categoryBUS = null;
                        categoryBUS = new CategoryBUS();
                        ArrayList<CategoryModel> categories = categoryBUS.getCategories(pageNumber, rowsOfPage);
                    %>
                    <td>
                        <select name="txtCourseCategoryId">
                            <%
                                for (CategoryModel category : categories) {
                            %>
                            <option value="<%= category.getCategoryId() %>">
                                <%= category.getCategoryName() %>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <label>Choose course status:</label>
                    </td>
                    <td>
                        <select name="txtCourseStatus">
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
                    <td><label>Enter course price:</label></td>
                    <td>
                        <input type="number" min="0" max="1000000" step="0.01" name="txtPrice" />
                    </td>
                </tr>
                <tr>
                    <td>Enter course duration:</td>
                    <td>
                        <input id="h" type="number" min="0" max="24" name="txtHour"/>
                        <label for="h">h</label>
                        <input id="m" type="number" min="0" max="59" name="txtMinute"/>
                        <label for="m">m</label>
                        <input id="s" type="number" min="0" max="59" name="txtSecond"/>
                        <label for="s">s</label>
                    </td>
                </tr>
                <tr>
                    <td><label>Add section:</label></td>
                    <td>
                        <select name="txtSectionId">
                            <%
//                            CourseBUS courseBUS = new CourseBUS();
                            SectionBUS sectionBUS = new SectionBUS();
//                            ArrayList<CourseDTO> courseList;
//                            courseList = courseBUS.getCourses(pageNumber, rowsOfPage)
                            ArrayList<SectionDTO> sectionList = sectionBUS.get();
                            for (SectionDTO section : sectionList) {
                            %>
                            <option value="<%= section.getSectionId() %>">
                                <%= section.getSectionName()%>
                            </option>
                            <%        
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                        <button type="submit" value="CreateCourse" name="action">Submit</button>
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
