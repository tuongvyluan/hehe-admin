<%-- 
    Document   : landing
    Created on : Jul 19, 2022, 5:20:36 PM
    Author     : Harry
--%>

<%@page import="categories.CategoryModel"%>
<%@page import="categories.CategoryDTO"%>
<%@page import="categories.CategoryBUS"%>
<%@page import="authors.AuthorDTO"%>
<%@page import="sections.SectionDTO"%>
<%@page import="sections.SectionBUS"%>
<%@page import="courses.CourseDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="courses.CourseBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Coding by CodingLab | www.codinglabweb.com -->
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />

        <!----======== CSS ======== -->
        <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
            />
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
            crossorigin="anonymous"
            />
        <link rel="stylesheet" href="css/navbar.css" />
        <!--<link rel="stylesheet" href="css/addCourse.css">--> 
        <link rel="stylesheet" href="css/card.css" />

        <!----===== Boxicons CSS ===== -->
        <link
            href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
            rel="stylesheet"
            />

        <title>Author Home Page</title>
    </head>
    <body>
        <nav class="sidebar">
            <header>
                <div class="image-text">
                    <span class="image">
                        <img src="images/logo-removebg-preview.png" alt="" />
                    </span>

                    <div class="text logo-text">
                        <span class="name">HEHE CODE</span>
                    </div>
                </div>
            </header>

            <div class="menu-bar">
                <div class="menu">
                    

                    <ul class="menu-links">
                        <li class="nav-link">
                            <a href="./landing.jsp">
                                <i class="bx bx-home-alt icon"></i>
                                <span class="text nav-text">View all courses</span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="./createNewCourse.jsp">
                                <i class="bx bx-bar-chart-alt-2 icon"></i>
                                <span class="text nav-text">Create course</span>
                            </a>
                        </li>
                    </ul>
                </div>

                <div class="bottom-content">
                    <li class="">
                        <a href="changePassword.jsp">
                            <i class="bx bx-lock icon"></i>
                            <span class="text nav-text">Change password</span>
                        </a>
                    </li>
                    <li class="">
                        <a href="MainController?action=Logout">
                            <i class="bx bx-log-out icon"></i>
                            <span class="text nav-text">Logout</span>
                        </a>
                    </li>
                </div>
            </div>
        </nav>

        <section class="home">
            <div class="viewAllCourse" style="font-size: 40px; padding-left: 0.5%">
                All course
            </div>
            <%
                AuthorDTO author = (AuthorDTO) session.getAttribute("LOGIN_AUTHOR");
                int authorId = author.getAuthorId();
//                int authorId = 1;
                CategoryBUS categoryBUS = new CategoryBUS();
                CourseBUS courseBUS = new CourseBUS();
                ArrayList<CategoryModel> categoryList = categoryBUS.getCategories();
                for (CategoryModel category : categoryList) {
            %>
            <div class="CategoryName">
                <h2 style="font-size: 39px; padding-left: 1%"><%= category.getCategoryName()%></h2>
                <div class="row card-container">
                    <%
                        ArrayList<CourseDTO> courseList = courseBUS.getCoursesByAuthorCate(authorId, category.getCategoryId());
                        for (CourseDTO course : courseList) {
                    %>
                    <div class="col-sm-6 col-md-6 col-lg-4 col-xl-3">
                        <div class="card">
                            <div class="image-content">
                                <span class="overlay"></span>
                            </div>
                            <div class="card-content">
                                <h2 class="name">
                                    <%= course.getCourseName()%>
                                </h2>
                                <div class="description">
                                    <p>Author: <%= author.getFirstName() + " " + author.getLastName() %></p>
                                    <p>Time to complete: <%= course.getDuration() %> hours</p>
                                </div>
                                <div class="card-content-detail">
                                    <a href="editCourseContent.jsp?courseId=<%= course.getCourseId() %>"><button class="buttonCourse" type="button">Edit</button></a>
                                    <a href="CourseController?action=DeleteCourse&CourseToDelete=<%= course.getCourseId() %>"><button class="buttonDeleteCourse" type="button">Delete</button></a>
                                </div>
                            </div>
                        </div>
                    </div> 
                    <%
                        }
                    %>
                </div>
            </div>
            <%
                }
            %>
        </section>
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
            integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
            crossorigin="anonymous"
        ></script>
        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"
            integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"
            crossorigin="anonymous"
        ></script>
    </body>
</html>

<%--<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Landing Page</title>
    </head>
    <body>
        <table>
            <%
                AuthorDTO author = (AuthorDTO)session.getAttribute("AUTHOR_ID");
                int authorId = author.getAuthorId();
                CourseBUS courseBUS = new CourseBUS();
                ArrayList<CourseDTO> courseList = courseBUS.getCoursesByAuthor(authorId);
                SectionBUS sectionBUS = new SectionBUS();
                for (CourseDTO course : courseList) {
                    ArrayList<SectionDTO> sectionList = sectionBUS.getByCourse(course.getCourseId());
            %>
            <tr>
                <td><%= course.getCourseName() %></td>
                <td>
                    <select>
                        <%
                        for (SectionDTO section : sectionList) {
                        %>
                        <option><%= section.getSectionName() %></option>
                        <%  
                        }
                        %>
                    </select>
                </td>
            </tr>
            <%            
                }
            %>
        </table>
    </body>
</html>--%>
