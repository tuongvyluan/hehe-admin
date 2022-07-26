<%-- 
    Document   : addCourseContent
    Created on : Jul 18, 2022, 8:38:15 PM
    Author     : Harry
--%>

<%@page import="sections.SectionDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="sections.SectionBUS"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
        <title>Edit Content</title>
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
        <section class="lessonConntent">
            <h1>Course Curriculum</h1>
            <%
                SectionBUS sectionBUS = null;
                sectionBUS = new SectionBUS();
                ArrayList<SectionDTO> sectionList = null;
                sectionList = sectionBUS.getByCourse(7);
                for (SectionDTO section : sectionList) {
            %>
            <div class="accordion" id="accordionPanelsStayOpenExample">
                <div class="accordion-item">
                    <h2
                        class="accordion-header"
                        id="panelsStayOpen-heading1"
                        >
                        <button
                            class="accordion-button"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#panelsStayOpen-collapse1"
                            aria-expanded="true"
                            aria-controls="panelsStayOpen-collapse1"
                            >
                            <h2><%= section.getSectionId()%>. <%= section.getSectionName()%></h2>
                        </button>
                    </h2>
                    <div
                        id="panelsStayOpen-collapse1"
                        class="accordion-collapse collapse show"
                        aria-labelledby="panelsStayOpen-heading1"
                        >
                        <div class="accordion-body">
                            <ol>
                                <li><a href="#">Introdution</a></li>
                                <li><a href="#">Definition</a></li>
                                <div>+ Add topic</div>
                                <input
                                    class="input__topic"
                                    type="text"
                                    placeholder="Input topic"
                                    />
                                <button class="btn__addTopic"
                                        type="submit" 
                                        name="action" 
                                        value="AddTopicToSection">
                                    Add topic
                                </button>
                            </ol>
                        </div>
                    </div>
                </div>

                <%
                    }
                %>
                <div class="accordion-item">
                    <h2
                        class="accordion-header"
                        id="panelsStayOpen-heading1"
                        >
                        <button
                            class="accordion-button"
                            type="button"
                            data-bs-toggle="collapse"
                            data-bs-target="#panelsStayOpen-collapse1"
                            aria-expanded="true"
                            aria-controls="panelsStayOpen-collapse1"
                            >
                            <form action="MainController" method="POST">
                                <input
                                    class="add__section"
                                    type="text"
                                    placeholder="Add course's section"
                                    />
                                <input type="text" name="txtCourseToAddSection">
                                <select name="txtSectionToAdd">
                                    <%
                                        sectionList = sectionBUS.get();
                                        for (SectionDTO section : sectionList) {
                                    %>
                                    <option value="<%= section.getSectionId()%>">
                                        <%= section.getSectionId()%> <%= section.getSectionName()%>
                                    </option>
                                    <%
                                        }
                                    %>
                                </select>
                                <button class="btn__addSection" 
                                        type="submit" 
                                        name="action" 
                                        value="AddSectionToCourse">
                                    Add section
                                </button>
                            </form>
                        </button>
                    </h2>
                    <div
                        id="panelsStayOpen-collapse1"
                        class="accordion-collapse collapse show"
                        aria-labelledby="panelsStayOpen-heading1"
                        >
                        <div class="accordion-body"></div>
                    </div>
                </div>

                <%--<div class="accordion" id="accordionPanelsStayOpenExample">
                    <div class="accordion-item">
                        <h2
                            class="accordion-header"
                            id="panelsStayOpen-heading1"
                            >
                            <button
                                class="accordion-button"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapse1"
                                aria-expanded="true"
                                aria-controls="panelsStayOpen-collapse1"
                                >
                                <h2>1. Html Introduction</h2>
                            </button>
                        </h2>
                        <div
                            id="panelsStayOpen-collapse1"
                            class="accordion-collapse collapse show"
                            aria-labelledby="panelsStayOpen-heading1"
                            >
                            <div class="accordion-body">
                                <ol>
                                    <li><a href="#">Introdution</a></li>
                                    <li><a href="#">Definition</a></li>
                                    <div>+ Add topic</div>
                                    <input
                                        class="input__topic"
                                        type="text"
                                        placeholder="Input topic"
                                        />
                                    <button class="btn__addTopic"
                                            type="submit" 
                                            name="action" 
                                            value="AddTopicToSection">
                                        Add topic
                                    </button>
                                </ol>
                            </div>
                        </div>
                    </div>
                    <div class="accordion-item">
                        <h2
                            class="accordion-header"
                            id="panelsStayOpen-heading1"
                            >
                            <button
                                class="accordion-button"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapse1"
                                aria-expanded="true"
                                aria-controls="panelsStayOpen-collapse1"
                                >
                                <form class="" action="">
                                    <input
                                        class="add__section"
                                        type="text"
                                        placeholder="Add course's section"
                                        />
                                    <button class="btn__addSection" 
                                            type="submit" 
                                            name="action" 
                                            value="AddSectionToCourse">
                                        Add section
                                    </button>
                                </form>
                            </button>
                        </h2>
                        <div
                            id="panelsStayOpen-collapse1"
                            class="accordion-collapse collapse show"
                            aria-labelledby="panelsStayOpen-heading1"
                            >
                            <div class="accordion-body"></div>
                        </div>
                    </div>
                </div>--%>
        </section>
    </body>
</html>
