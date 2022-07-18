<%-- 
    Document   : createNewCourse
    Created on : Jul 17, 2022, 1:00:28 AM
    Author     : Harry
--%>

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
        <title>Create Course</title>
    </head>
    <body>
        <form action="">
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
                        <span>Created by James Potter </span>
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
                        >Input description</textarea
                    >
                </p>
            </section>
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
                                <h2><%= section.getSectionId() %>. <%= section.getSectionName() %></h2>
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
                                <%--data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapse1"
                                aria-expanded="true"
                                aria-controls="panelsStayOpen-collapse1"--%>
                                >
                                <form action="MainController" method="POST">
                                    <%--<input
                                        class="add__section"
                                        type="text"
                                        placeholder="Add course's section"
                                        />--%>
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

