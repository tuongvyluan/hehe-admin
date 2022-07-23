<%@page import="topics.TopicDTO"%>
<%@page import="topics.TopicBUS"%>
<%@page import="sections.SectionDTO"%>
<%@page import="sections.SectionBUS"%>
<%@page import="courses.CourseDAO"%>
<%@page import="categories.CategoryModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="categories.CategoryBUS"%>
<%@page import="authors.AuthorDTO"%>
<%@page import="courses.CourseModel"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" href="css/editCourseContent.css" />
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
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
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
        <title>Document</title>
    </head>
    <body>
        <div>
            <form name="EditCourse" action="MainController" method="POST" id="edit">
                <input type="hidden" name="action" value="EditCourse"/>
            </form>
            <%
                //            CourseModel currentCourse = (CourseModel) session.getAttribute("CURRENT_COURSE");
                int courseId = Integer.parseInt(request.getParameter("courseId"));
                CourseModel currentCourse = CourseDAO.getCurrentCourse(courseId);
            %>
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
                        </ul>
                    </div>

                    <div class="bottom-content">
                        <li class="">
                            <a href="MainController?action=Logout">
                                <i class="bx bx-log-out icon"></i>
                                <span class="text nav-text">Logout</span>
                            </a>
                        </li>
                    </div>
                </div>
            </nav>
            <div class="addCourse__title">Edit course</div>
            <form action="MainController" method="POST">
                <section class="banner">
                    <div class="banner__content">
                        <!-- <h3>Name of the course</h3> -->
                        <div class="banner__content__category">
                            <select
                                class="banner__content__category__input"
                                name="txtCourseNewCategoryId"
                                id=""
                                >
                                <%
                                    AuthorDTO author = (AuthorDTO) session.getAttribute("LOGIN_AUTHOR");
                                    int authorId = author.getAuthorId();
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
                        <input type="hidden" name="txtCourseToEdit" value="<%= currentCourse.getCourseId()%>">
                        <input id="input__sectionName" class="input__sectionName" name="txtCourseNewName" type="text" value="<%= currentCourse.getCourseName()%>" disabled style="border: none;">
                        <i id="edit-input__sectionName" class="fa fa-edit" onclick="editDes('input__sectionName')" style="font-size: 25px; padding-left: 10px; cursor: pointer;"></i>
                        <i id="save-input__sectionName" class="fa fa-check" onclick="saveDes('input__sectionName')" style="font-size: 25px;display: none; color: green;padding-left: 10px;cursor: pointer;"></i>
                        <label for="input__duration">Duration: </label>
                        <input id="h" type="number" min="0" max="24" name="txtNewHour"/>
                        <label for="h">hour(s)</label>
                        <input id="m" type="number" min="0" max="59" name="txtNewMinute"/>
                        <label for="m">minute(s)</label>
                        <input id="s" type="number" min="0" max="59" name="txtNewSecond"/>
                        <label for="s">second(s)</label>
                        <div class="banner__content__detail">
                            <span>Created by <%= author.getFirstName() + " " + author.getLastName()%> </span>
                        </div>
                    </div>
                </section>
                <section class="description">
                    <form id="form-<%= currentCourse.getCourseId()%>" action="MainController" method="POST">
                        <input type="hidden" name="action" value="EditCourseDesc">
                        <input type="hidden" name="CourseToEdit" value="<%= currentCourse.getCourseId() %>">
                        <input type="hidden" name="courseId" value="<%= currentCourse.getCourseId() %>">
                        <h1>Description <i id="edit-input__description" class="fa fa-edit" onclick="editDes('input__description')" style="font-size: 25px; padding-left: 10px; cursor: pointer;"></i>
                            <i id="save-input__description" class="fa fa-check" onclick="saveDes('input__description')" style="font-size: 25px;display: none; color: green;padding-left: 10px;cursor: pointer;"></i></h1>
                        <p></p>
                        <p>
                            <textarea name="txtCourseNewDescription" id="input__description" onchange="submitCourseDescChange('<%= currentCourse.getCourseId()%>')" Class="input__description" name="" id="" cols="30" rows="10" disabled style="border: none; "><%= currentCourse.getDescription()%></textarea>
                        </p>
                    </form>

                </section>
                <section class="lessonConntent">
                    <h1>Course Curriculum</h1>

                    <div class="accordion" id="accordionPanelsStayOpenExample">
                        <%
                            SectionBUS sectionBUS = new SectionBUS();
                            ArrayList<SectionDTO> sectionList = sectionBUS.getByCourse(courseId);
                            TopicBUS topicBUS = new TopicBUS();
                            for (SectionDTO section : sectionList) {
                                ArrayList<TopicDTO> topicList = topicBUS.getBySection(section.getSectionId());
                        %>
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="panelsStayOpen-heading2">
                                <button
                                    class="accordion-button"
                                    type="button"
                                    data-bs-toggle="collapse"
                                    data-bs-target="#panelsStayOpen-collapse2"
                                    aria-expanded="true"
                                    aria-controls="panelsStayOpen-collapse2"
                                    >
                                    <div class="section__Name" style="display: flex;">
                                        <form id="form-<%= section.getSectionId()%>" action="MainController" method="POST">
                                            <input type="hidden" name="action" value="EditSectionName">
                                            <input type="hidden" name="SectionToEdit" value="<%= section.getSectionId()%>">
                                            <input type="hidden" name="courseId" value="<%= section.getCourseId()%>">
                                            <input id="<%= section.getSectionName()%>" class="section__Name__input" type="text" name="txtSectionName" onchange="submitSectionChange(<%= section.getSectionId()%>);" value="<%= section.getSectionName()%>" disabled style="border: none;">
                                            <i id="edit-<%= section.getSectionName()%>" class="fa fa-edit" onclick="editSection('<%= section.getSectionName()%>')" style="font-size: 25px; padding-left: 10px"></i>
                                            <i id="save-<%= section.getSectionName()%>" class="fa fa-check" onclick="saveSection('<%= section.getSectionName()%>')" style="font-size: 25px;display: none; color: green;padding-left: 10px"></i>
                                            <i id="delete-<%= section.getSectionName()%>"class="fa fa-trash-alt" onclick="deleteField('<%= section.getSectionId()%>')" style="font-size: 25px; color: red; padding-left: 10px;"></i>
                                        </form>
                                    </div>
                                </button>
                            </h2>
                            <div
                                id="panelsStayOpen-collapse2"
                                class="accordion-collapse collapse show"
                                aria-labelledby="panelsStayOpen-heading2"
                                >
                                <div class="accordion-body">
                                    <ol>
                                        <%
                                            for (TopicDTO topic : topicList) {
                                        %>
                                        <li>
                                            <form id="form-<%= topic.getTopicId()%>" action="MainController" method="POST">
                                                <input type="hidden" name="action" value="EditTopicName">
                                                <input type="hidden" name="TopicToEdit" value="<%= topic.getTopicId()%>">
                                                <input type="hidden" name="courseId" value="<%= topic.getCourseId()%>">
                                                <input id="<%= topic.getTopicName()%>" class="topic__Name__input" type="text" name="txtTopicName" value="<%= topic.getTopicName()%>" onchange="submitTopicChange(<%= topic.getTopicId()%>);" disabled style="border: none;width: 100%;">
                                                <i id="edit-<%= topic.getTopicName()%>" class="fa fa-edit" onclick="editTopic('<%= topic.getTopicName()%>');" style="font-size: 12px; padding-left: 10px; cursor: pointer;"> Edit</i>
                                                <i id="save-<%= topic.getTopicName()%>" class="fa fa-check" onclick="saveTopic('<%= topic.getTopicName()%>');" style="font-size: 12px;display: none; color: green;padding-left: 10px; cursor: pointer;"> Save</i>
                                                <i id="delete-<%= topic.getTopicName()%>"class="fa fa-trash-alt" onclick="deleteTopic('<%= topic.getTopicName()%>');" style="font-size: 12px; color: red; padding-left: 10px; cursor: pointer;"> Delete</i>
                                                <i id="open-<%= topic.getTopicName()%>"class="fa fa-book-open" onclick="openTopic(<%= topic.getTopicId()%>);" style="font-size: 12px; color: #1877F2; padding-left: 10px; cursor: pointer;"> Open content</i>
                                            </form>
                                        </li>
                                        <%
                                            }
                                        %>
                                        <div>+ Add topic</div>
                                        <form>
                                            <input type="hidden" name="courseId" value="<%= section.getCourseId()%>">
                                            <input type="hidden" name="txtTopicCourseId" value="<%= section.getCourseId()%>">
                                            <input type="hidden" name="txtTopicSectionId" value="<%= section.getSectionId()%>">
                                            <input class="input__topic" type="text" name="txtTopicName" placeholder="Input topic's name">
                                            <button class="btn__addTopic" type="submit" name="action" value="CreateTopic">Add topic</button>
                                        </form>
                                    </ol>
                                </div>
                            </div>
                        </div>
                        <%
                            }
                        %>
                        <div class="accordion-item">
                            <h2 class="accordion-header" id="panelsStayOpen-heading1">
                                <button
                                    class="accordion-button"
                                    type="button"
                                    data-bs-toggle="collapse"
                                    data-bs-target="#panelsStayOpen-collapse1"
                                    aria-expanded="true"
                                    aria-controls="panelsStayOpen-collapse1"
                                    >
                                    <form class="MainController" action="POST">
                                        <input type="hidden" name="courseId" value="<%= currentCourse.getCourseId()%>">
                                        <input type="hidden" name="txtSectionCourseId" value="<%= currentCourse.getCourseId()%>">
                                        <input class="add__section" type="text" name="txtSectionName" placeholder="Add course's section">
                                        <button class="btn__addSection" type="submit" name="action" value="CreateSection">Add section</button>
                                    </form>
                                </button>
                            </h2>
                            <div
                                id="panelsStayOpen-collapse1"
                                class="accordion-collapse collapse show"
                                aria-labelledby="panelsStayOpen-heading1"
                                >
                                <div class="accordion-body">

                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <div class="btn__submit">
                    <button class="enrollBtn" type="submit" name="action" value="EditCourse" onclick="submit_form('edit')">Save change</button>
                    <!--<a href="MainController?action=EditCourse">Meow</a>-->
                    <!--<input type="submit" class="btn btn-primary" name="action" value="EditCourse">-->
                </div>
            </form>
        </div>
        <!-- Footer -->
        <!-- Footer -->
        <script>
            function openTopic(id) {
                location.href = "editTopicContent.jsp?topicId=" + id;
            }
            function editSection(id) {
                document.getElementById(id).disabled = false;
                document.getElementById(id).style.border = "1px solid grey";
                document.getElementById("edit-" + id).style.display = "none";
                document.getElementById("save-" + id).style.display = "block";
                document.getElementById("delete-" + id).style.display = "none";
            }
            function saveSection(id) {
                document.getElementById(id).disabled = true;
                document.getElementById(id).style.border = "none";
                document.getElementById(id).style.backgroundColor = "inherit";
                document.getElementById("edit-" + id).style.display = "block";
                document.getElementById("save-" + id).style.display = "none";
                document.getElementById("delete-" + id).style.display = "block";
            }
            function editTopic(id) {
                document.getElementById(id).disabled = false;
                document.getElementById(id).style.border = "1px solid grey";
                document.getElementById("edit-" + id).style.display = "none";
                document.getElementById("save-" + id).style.display = "inline-block";
                document.getElementById("delete-" + id).style.display = "none";
                document.getElementById("open-" + id).style.display = "none";
            }
            function saveTopic(id) {
                document.getElementById(id).disabled = true;
                document.getElementById(id).style.border = "none";
                document.getElementById(id).style.backgroundColor = "inherit";
                document.getElementById("edit-" + id).style.display = "inline-block";
                document.getElementById("save-" + id).style.display = "none";
                document.getElementById("delete-" + id).style.display = "inline-block";
                document.getElementById("open-" + id).style.display = "inline-block";
            }
            function submitCourseDescChange(id) {
                var form = document.getElementById("form-" + id);
                form.submit();
            }
            function submitSectionChange(id) {
                var form = document.getElementById("form-" + id);
                form.submit();
            }
            function submitTopicChange(id) {
                var form = document.getElementById("form-" + id);
                form.submit();
            }
            function editDes(id) {
                document.getElementById(id).disabled = false;
                document.getElementById(id).style.border = "1px solid grey";
                document.getElementById("edit-" + id).style.display = "none";
                document.getElementById("save-" + id).style.display = "inline-block";
            }
            function saveDes(id) {
                document.getElementById(id).disabled = true;
                document.getElementById(id).style.border = "none";
                document.getElementById("edit-" + id).style.display = "inline-block";
                document.getElementById("save-" + id).style.display = "none";
            }
        </script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    </script>
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
    <script>
            function submit_form(form_id) {
                var form = document.getElementById(form_id);
                form.submit();
            }
    </script>
</body>
</html>
