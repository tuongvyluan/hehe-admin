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
                CourseModel currentCourse = (CourseModel) request.getAttribute("CURRENT_COURSE");
                int courseId = currentCourse.getCourseId();
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
            <div class="addCourse__title">Edit course</div>
            <section class="banner">
                <div class="banner__content">
                    <!-- <h3>Name of the course</h3> -->
                    <div class="banner__content__category">
                        <form action="MainController" method="POST">
                            <input type="hidden" name="courseId" value="<%= currentCourse.getCourseId()%>">
                            <input type="hidden" name="CourseToEdit" value="<%= currentCourse.getCourseId()%>">
                            <label>Category: </label>
                            <select
                                class="banner__content__category__input"
                                name="CourseNewCategoryId"
                                id=""
                                >
                                <%
                                    AuthorDTO author = (AuthorDTO) session.getAttribute("LOGIN_AUTHOR");
                                    int authorId = author.getAuthorId();
                                    int pageNumber = 1;
                                    int rowsOfPage = 10;
                                    CategoryBUS categoryBUS = null;
                                    categoryBUS = new CategoryBUS();
                                    ArrayList<CategoryModel> categories = categoryBUS.getCategoriesChecked(pageNumber, rowsOfPage);
                                    for (CategoryModel category : categories) {
                                        if (category.getCategoryId() == currentCourse.getCategoryId()) {
                                %>
                                <option value="<%= category.getCategoryId()%>" selected="selected">
                                    <%= category.getCategoryName()%>
                                </option>
                                <%
                                    }
                                %>
                                <option value="<%= category.getCategoryId()%>">
                                    <%= category.getCategoryName()%>
                                </option>
                                <%
                                    }
                                %>
                            </select>
                            <button type="submit" name="action" value="EditCourseCategory" class="btn__deleteTopic">
                                <i class="fa fa-check" style="font-size: 25px; color: green;padding-left: 10px;cursor: pointer;"></i>
                            </button>
                        </form>
                    </div>
                    <input type="hidden" name="CourseToEdit" value="<%= currentCourse.getCourseId()%>">
                    <form action="MainController" method="POST">
                        <input type="hidden" name="action" value="EditCourseName">
                        <input type="hidden" name="courseId" value="<%= currentCourse.getCourseId()%>">
                        <input type="hidden" name="CourseToEdit" value="<%= currentCourse.getCourseId()%>">
                        <input id="input__sectionName" class="input__sectionName" name="CourseNewName" type="text" value="<%= currentCourse.getCourseName()%>" onchange="this.form.submit();" disabled style="border: none;">
                        <i id="edit-input__sectionName" class="fa fa-edit" onclick="editDes('input__sectionName')" style="font-size: 25px; padding-left: 10px; cursor: pointer;"></i>
                        <i id="save-input__sectionName" class="fa fa-check" onclick="saveDes('input__sectionName')" style="font-size: 25px;display: none; color: green;padding-left: 10px;cursor: pointer;"></i>
                    </form>
                    <form action="MainController" method="POST">
                        <input type="hidden" name="courseId" value="<%= currentCourse.getCourseId()%>">
                        <input type="hidden" name="CourseToEdit" value="<%= currentCourse.getCourseId()%>">
                        <label for="input__duration">Duration: </label>
                        <input id="h" type="number" min="0" max="24" step="0.01" name="Duration" value="<%= currentCourse.getDuration()%>"/>
                        <label for="h">hour(s)</label>
                        <button type="submit" name="action" value="EditCourseDuration" class="btn__deleteTopic">
                            <i class="fa fa-check" style="font-size: 25px; color: green;padding-left: 10px;cursor: pointer;"></i>
                        </button>
                    </form>
                    <div class="banner__content__detail">
                        <span>Created by <%= author.getFirstName() + " " + author.getLastName()%> </span>
                    </div>
                </div>
            </section>
            <section class="description">
                <form action="MainController" method="POST">
                    <input type="hidden" name="action" value="EditCourseDesc">
                    <input type="hidden" name="CourseToEdit" value="<%= currentCourse.getCourseId()%>">
                    <input type="hidden" name="courseId" value="<%= currentCourse.getCourseId()%>">
                    <h1>
                        Description 
                        <i id="edit-<%= currentCourse.getDescription()%>" class="fa fa-edit" onclick="editDes('<%= currentCourse.getDescription()%>');" style="font-size: 25px; padding-left: 10px; cursor: pointer;"></i>
                        <i id="save-<%= currentCourse.getDescription()%>" class="fa fa-check" onclick="saveDes('<%= currentCourse.getDescription()%>');" style="font-size: 25px;display: none; color: green;padding-left: 10px;cursor: pointer;"></i>
                    </h1>  
                    <p>
                        <textarea name="txtCourseNewDescription" 
                                  id="<%= currentCourse.getDescription()%>" 
                                  onchange="this.form.submit();" 
                                  Class="input__description" 
                                  cols="30" rows="10" 
                                  disabled style="border: none; ">
                            <%= currentCourse.getDescription()%>
                        </textarea>
                    </p>
                </form>
            </section>
            <section class="lessonConntent">
                <h1>Course Curriculum</h1>
                <div class="accordion" id="accordionPanelsStayOpenExample">
                    <%
                        SectionBUS sectionBUS = new SectionBUS();
                        ArrayList<SectionDTO> sectionList = sectionBUS.getByCourseChecked(courseId);
                        TopicBUS topicBUS = new TopicBUS();
                        for (SectionDTO section : sectionList) {
                            ArrayList<TopicDTO> topicList = topicBUS.getBySectionChecked(section.getSectionId());
                    %>
                    <div class="accordion-item">
                        <h2 class="accordion-header" id="panelsStayOpen-heading<%= section.getSectionId() %>">
                            <button
                                class="accordion-button"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapse<%= section.getSectionId() %>"
                                aria-expanded="true"
                                aria-controls="panelsStayOpen-collapse<%= section.getSectionId() %>"
                                >
                                <div class="section__Name" style="display: flex;">
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="action" value="EditSectionName">
                                        <input type="hidden" name="SectionToEdit" value="<%= section.getSectionId()%>">
                                        <input type="hidden" name="courseId" value="<%= section.getCourseId()%>">
                                        <input id="<%= section.getSectionName()%>" class="section__Name__input" type="text" name="txtSectionName" onchange="this.form.submit();" value="<%= section.getSectionName()%>" disabled style="border: none;">
                                        <i id="edit-<%= section.getSectionName()%>" class="fa fa-edit" onclick="editSection('<%= section.getSectionName()%>')" style="font-size: 25px; padding-left: 10px"></i>
                                        <i id="save-<%= section.getSectionName()%>" class="fa fa-check" onclick="saveSection('<%= section.getSectionName()%>')" style="font-size: 25px;display: none; color: green;padding-left: 10px"></i>
                                        <i id="delete-<%= section.getSectionName()%>"class="fa fa-trash-alt" onclick="deleteSection('deleteSection-<%= section.getSectionId() %>')" style="font-size: 25px; color: red; padding-left: 10px;"></i>
                                    </form>                                    
                                </div>
                                    <form action="MainController" method="POST" id="deleteSection-<%= section.getSectionId() %>">
                                        <input type="hidden" name="action" value="DeleteSection">
                                        <input type="hidden" name="SectionToDelete" value="<%= section.getSectionId()%>">
                                        <input type="hidden" name="courseId" value="<%= section.getCourseId()%>">
                                    </form>
                            </button>
                        </h2>
                        <div
                            id="panelsStayOpen-collapse<%= section.getSectionId() %>"
                            class="accordion-collapse collapse show"
                            aria-labelledby="panelsStayOpen-heading<%= section.getSectionId() %>"
                            >
                            <div class="accordion-body">
                                <ol>
                                    <%
                                        for (TopicDTO topic : topicList) {
                                    %>
                                    <li>
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="action" value="EditTopicName">
                                            <input type="hidden" name="TopicToEdit" value="<%= topic.getTopicId()%>">
                                            <input type="hidden" name="courseId" value="<%= topic.getCourseId()%>">
                                            <input id="<%= topic.getTopicName()%>" class="topic__Name__input" type="text" name="txtTopicName" value="<%= topic.getTopicName()%>" onchange="this.form.submit();" disabled style="border: none;width: 100%;">
                                            <i id="edit-<%= topic.getTopicName()%>" class="fa fa-edit" onclick="editTopic('<%= topic.getTopicName()%>');" style="font-size: 12px; padding-left: 10px; cursor: pointer;"> Edit</i>
                                            <i id="save-<%= topic.getTopicName()%>" class="fa fa-check" onclick="saveTopic('<%= topic.getTopicName()%>');" style="font-size: 12px;display: none; color: green;padding-left: 10px; cursor: pointer;"> Save</i>
                                            <i id="open-<%= topic.getTopicName()%>"class="fa fa-book-open" onclick="openTopic(<%= topic.getTopicId()%>);" style="font-size: 12px; color: #1877F2; padding-left: 10px; cursor: pointer;"> Open content</i>
                                        </form>
                                        <form action="MainController" method="POST">
                                            <!--<input type="hidden" name="action" value="DeleteTopic">-->
                                            <input type="hidden" name="TopicToDelete" value="<%= topic.getTopicId()%>">
                                            <input type="hidden" name="courseId" value="<%= topic.getCourseId()%>">
                                            <button type="submit" name="action" value="DeleteTopic" class="btn__deleteTopic">
                                                <i id="delete-<%= topic.getTopicName()%>"class="fa fa-trash-alt" onclick="<%--deleteTopic('<%= topic.getTopicId()%>');--%>" style="font-size: 12px; color: red; padding-left: 10px; cursor: pointer;"> Delete</i>
                                            </button>
                                        </form>
                                    </li>
                                    <%
                                        }
                                    %>
                                    <div>+ Add topic</div>
                                    <form action="MainController" method="POST">
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
                        <h2 class="accordion-header" id="panelsStayOpen-heading0">
                            <button
                                class="accordion-button"
                                type="button"
                                data-bs-toggle="collapse"
                                data-bs-target="#panelsStayOpen-collapse0"
                                aria-expanded="true"
                                aria-controls="panelsStayOpen-collapse0"
                                >
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="courseId" value="<%= currentCourse.getCourseId()%>">
                                    <input class="add__section" type="text" name="txtSectionName" placeholder="Add course's section">
                                    <button class="btn__addSection" type="submit" name="action" value="CreateSection">Add section</button>
                                </form>
                            </button>
                        </h2>
                        <div
                            id="panelsStayOpen-collapse0"
                            class="accordion-collapse collapse show"
                            aria-labelledby="panelsStayOpen-heading0"
                            >
                            <div class="accordion-body">

                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!--            <div class="btn__submit">
                            <button class="enrollBtn" type="submit" name="action" value="EditCourse" onclick="submit_form('edit')">Save change</button>
                            <a href="MainController?action=EditCourse">Meow</a>
                            <input type="submit" class="btn btn-primary" name="action" value="EditCourse">
                        </div>-->
        </div>
        <!-- Footer -->
        <!-- Footer -->
        <script>
                                                function openTopic(id) {
                                                    location.href = "editTopicContent.jsp?topicId=" + id;
                                                }
                                                function deleteSection(id) {
                                                    var form = document.getElementById(id);
                                                    form.submit();
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