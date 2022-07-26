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
        <%@include file="./miniHeader.jsp" %>
        <form action="MainController" method="POST">
            <table>
                <%--<tr>
                    <td>
                        <label>Choose a course to start:</label>
                    </td>
                    <td>
                        <select name="txtCourseToAddSection" onchange="location.href='addSectionToCourse.jsp?courseId=' + this.value;">
                            <option>Select course</option> 
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
                    <td>This course already contains these sections:</td>
                    <td>
                            <%
                            SectionBUS sectionBUS = null;
                            sectionBUS = new SectionBUS();
                            ArrayList<SectionDTO> sectionList = null;
                            if (request.getParameter("courseId") != null) {
                                int courseId = Integer.parseInt(request.getParameter("courseId"));
                                sectionList = sectionBUS.get(courseId);
                            } else {
                                sectionList = sectionBUS.get(0);
                            }
                            for (SectionDTO section : sectionList) {
                            %>
                            <p><%= section.getSectionId() %> <%= section.getSectionName() %></p>
                            <%        
                            }
                            %>
                    </td>
                </tr>--%>
                <tr>
                        <th>Course:</th>
                            <%
                                int pageNumber = 1;
                                int rowsOfPage = 100;
                                CourseBUS courseBUS = null;
                                courseBUS = new CourseBUS();
                                CourseDTO courseDTO = new CourseDTO();
                                ArrayList<CourseDTO> courseList = courseBUS.getCourses(pageNumber, rowsOfPage);
                            %>
                        <td>
                            <select style="width: 175px" name="txtCourseToAddSection" onchange="location.href = 'addSectionToCourse.jsp?courseId=' + this.value;">
                                <option value = 0>Select Course</option>
                                <%
                                    for (CourseDTO course : courseList) {
                                        if (request.getParameter("courseId") != null && course.getCourseId() == Integer.parseInt(request.getParameter("courseId"))) {
                                %>
                                <option selected="selected" value="<%= course.getCourseId()%>">
                                    <%= course.getCourseName()%>
                                </option>
                                <%
                                } else {
                                %>
                                <option value="<%= course.getCourseId()%>">
                                    <%= course.getCourseName()%>
                                </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Section in this course:</th>
                            <%
                                SectionBUS sectionBUS = null;
                                sectionBUS = new SectionBUS();
                                ArrayList<SectionDTO> sectionList = null;
                                if (request.getParameter("courseId") != null) {
                                    int courseId = Integer.parseInt(request.getParameter("courseId"));
                                    sectionList = sectionBUS.getByCourse(courseId);
                                } else {
                                    sectionList = sectionBUS.getByCourse(0);
                                }
                            %>
                        <td>
                            <select style="width: 175px" onchange="location.href = 'addSectionToCourse.jsp?courseId=' +${param.courseId} + '&sectionId=' + this.value">
                                <option value = 0>Select section</option>
                                <%
                                    for (SectionDTO section : sectionList) {
                                        if (request.getParameter("sectionId") != null && section.getSectionId() == Integer.parseInt(request.getParameter("sectionId"))) {
                                %>
                                <option selected="selected" value="<%= section.getSectionId()%>">
                                    <%= section.getSectionId()%> <%= section.getSectionName()%>
                                </option>
                                <%
                                } else {
                                %>
                                <option value="<%= section.getSectionId()%>">
                                    <%= section.getSectionId()%> <%= section.getSectionName()%>
                                </option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                        </td>
                    </tr>
                <tr>
                    <td><label>Add section:</label></td>
                    <td>
                        <select name="txtSectionToAdd">
                            <% 
                            sectionList = sectionBUS.get();
                            for (SectionDTO section : sectionList) {
                            %>
                            <option value="<%= section.getSectionId() %>">
                                <%= section.getSectionId() %> <%= section.getSectionName() %>
                            </option>
                            <%        
                            }
                            %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>
                       <button type="submit" name="action" value="AddSectionToCourse" >Add</button> 
                    </td>
                </tr>
            </table>
        </form>
    </body>
</html>
