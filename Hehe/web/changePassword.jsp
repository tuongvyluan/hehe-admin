<%-- 
    Document   : changePassword
    Created on : Jul 25, 2022, 6:28:37 PM
    Author     : Harry
--%>

<%@page import="authors.AuthorDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
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
        <title>Change Password</title>
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
        <div class="home">
            <%
                AuthorDTO author = (AuthorDTO) session.getAttribute("LOGIN_AUTHOR");
                String error = (String) session.getAttribute("ERROR_CHANGE_PASSWORD");
                int authorId = author.getAuthorId();
            %>
            <form action="MainController" method="POST">
                <input type="hidden" name="authorId" value="<%= authorId %>">
                <label>Current password</label>
                <input type="password" name="currentPassword">
                <label>New password</label>
                <input type="password" name="newPassword">
                <label>Confirm password</label>
                <input type="password" name="confirmPassword">
                <button type="submit" name="action" value="ChangePassword">Submit</button>
            </form>
        </div>
    </body>
</html>
