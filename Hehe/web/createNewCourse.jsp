<%-- 
    Document   : createNewCourse
    Created on : Jul 17, 2022, 1:00:28 AM
    Author     : Harry
--%>

<%@page import="authors.AuthorDTO"%>
<%@page import="sections.SectionDTO"%>
<%@page import="sections.SectionBUS"%>
<%@page import="categories.CategoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="categories.CategoryBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/createNewCourse.css" />
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
        <link rel="stylesheet" href="css/addCourse.css">

        <!----===== Boxicons CSS ===== -->
        <link
            href="https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css"
            rel="stylesheet"
            />
        <title>Create Course</title>
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
                    <li class="search-box">
                        <i class="bx bx-search icon"></i>
                        <input type="text" placeholder="Search..." />
                    </li>

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

                        <li class="nav-link">
                            <a href="#">
                                <i class="bx bx-bell icon"></i>
                                <span class="text nav-text"></span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <i class="bx bx-pie-chart-alt icon"></i>
                                <span class="text nav-text"></span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <i class="bx bx-heart icon"></i>
                                <span class="text nav-text"></span>
                            </a>
                        </li>

                        <li class="nav-link">
                            <a href="#">
                                <i class="bx bx-wallet icon"></i>
                                <span class="text nav-text"></span>
                            </a>
                        </li>
                    </ul>
                </div>

                <div class="bottom-content">
                    <li class="">
                        <a href="#">
                            <i class="bx bx-log-out icon"></i>
                            <span class="text nav-text">Logout</span>
                        </a>
                    </li>
                </div>
            </div>
        </nav>
        <form action="MainController" method="POST">
            <section class="banner">
                <div class="banner__content">
                    <!-- <h3>Name of the course</h3> -->
                    <div class="banner__content__category">
                        <select
                            class="banner__content__category__input"
                            name="txtCourseCategoryId"
                            id=""
                            >
                            <%
                                AuthorDTO author = (AuthorDTO) session.getAttribute("LOGIN_AUTHOR");
                                int authorId = author.getAuthorId();
//                                int authorId = 1;
                                int pageNumber = 1;
                                int rowsOfPage = 10;
                                CategoryBUS categoryBUS = null;
                                categoryBUS = new CategoryBUS();
                                ArrayList<CategoryModel> categories = categoryBUS.getCategories(pageNumber, rowsOfPage);
                                for (CategoryModel category : categories) {
                            %>
                            <option value="<%= category.getCategoryId()%>">
                                <%= category.getCategoryName()%>
                            </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <input type="hidden" name="txtCourseAuthorId" value="<%= author.getAuthorId()%>">
                    <%--<input type="hidden" name="txtCourseAuthorId" value="<%= authorId %>">--%>
                    <input
                        class="input__sectionName"
                        type="text" name="txtCourseName"
                        placeholder="Input course's name"
                        />
                    <label for="input__duration">Duration: </label>
                    <input id="h" type="number" min="0" max="24" name="txtHour"/>
                    <label for="h">hour(s)</label>
                    <input id="m" type="number" min="0" max="59" name="txtMinute"/>
                    <label for="m">minute(s)</label>
                    <input id="s" type="number" min="0" max="59" name="txtSecond"/>
                    <label for="s">second(s)</label>
                    <div class="banner__content__detail">
                        <span>Created by <%= author.getFirstName() + " " + author.getLastName()%> </span>
                    </div>
                </div>
            </section>
            <section class="description">
                <h1>Description</h1>
                <p>
                    <textarea
                        class="input__description"
                        name=""
                        id=""
                        cols="30"
                        rows="10"
                        name="txtCourseDescription"
                        placeholder="Input course's description"
                        ></textarea
                    >
                </p>
            </section>

            <div class="btn__submit">
                <button class="enrollBtn" type="submit" value="CreateCourse" name="action">Create course</button>
            </div>
        </form>
        <!-- Footer -->

        <!-- Footer -->
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

