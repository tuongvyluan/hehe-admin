<%@page import="courses.CourseDAO"%>
<%@page import="courses.CourseModel"%>
<%@page import="answers.AnswerBUS"%>
<%@page import="quizzes.QuizDTO"%>
<%@page import="quizzes.QuizBUS"%>
<%@page import="topics.TopicModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="topics.TopicBUS"%>
<%@page import="students.StudentDTO"%>
<%@page import="sections.SectionDTO"%>
<%@page import="topics.TopicDTO"%>
<%@page import="answers.AnswerDTO"%>
<%--<%@page import="quizzes.QuizDTO"%>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <%
            int courseId = Integer.parseInt(request.getParameter("courseId"));
            CourseModel currentCourse = CourseDAO.getCurrentCourse(courseId);
            request.setAttribute("CURRENT_COURSE", currentCourse);
            TopicModel topicModel = null;
            TopicBUS topicBUS = null;
            topicBUS = new TopicBUS();
            int topicId = Integer.parseInt(request.getParameter("topicId"));
            topicModel = topicBUS.get(topicId);
        %>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" type="image/png" href="images/icons/read_book_study_icon.ico"/>
        <link rel="stylesheet" href="css/editTopicContent.css">
        <link rel="stylesheet" href="http://code.jquery.com/ui/1.9.2/themes/base/jquery-ui.css" />
        <link rel="stylesheet" href="css/nicepage.css" media="screen">
        <link rel="stylesheet" href="css/About.css" media="screen">
        <link id="u-theme-google-font" rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Roboto:100,100i,300,300i,400,400i,500,500i,700,700i,900,900i|Open+Sans:300,300i,400,400i,500,500i,600,600i,700,700i,800,800i">
        <link id="u-page-google-font" rel="stylesheet"
              href="https://fonts.googleapis.com/css?family=Advent+Pro:100,200,300,400,500,600,700|Cambay:400,400i,700,700i">
        <script src="js/studyScript.js" defer></script>
        <script src="js/studyAnswerScript.js" defer></script>
        <script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
        <script type="text/javascript" src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
        <script src="https://kit.fontawesome.com/709397a81f.js" crossorigin="anonymous"></script>
        <script type="text/javascript" src="http://www.pureexample.com/js/lib/jquery.ui.touch-punch.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script class="u-script" type="text/javascript" src="js/jquery.js" defer=""></script>
        <script class="u-script" type="text/javascript" src="js/nicepage.js" defer=""></script>
        <meta name="generator" content="Nicepage 4.12.5, nicepage.com">
        <!----======== CSS ======== -->
        <link rel="stylesheet" href="css/styleSideNavBar.css">

        <!----===== Boxicons CSS ===== -->
        <link href='https://unpkg.com/boxicons@2.1.1/css/boxicons.min.css' rel='stylesheet'>
        <title><%= topicModel.getTopicName()%></title>
    </head>

    <body data-home-page="Home.html" data-home-page-title="Home" class="u-body u-xl-mode">
        <nav class="sidebar close">
            <header>
                <div class="image-text">
                    <span class="image">
                        <a href="landing.jsp"><img src="images/logo-removebg-preview.png" alt=""></a>
                    </span>

                    <div class="text logo-text">
                        <span class="name">Hehe Code</span>

                    </div>
                </div>

            </header>
            <div class="menu-bar">

                <div class="bottom-content">
                    <li class="">
                        <form action="MainController" method="POST">
                            <input type="hidden" name="action" value="backToEditCourse">
                            <input type="hidden" name="courseId" value="<%= courseId%>">
                            <button style="background: none ; border: none; cursor: pointer;">
                                <i  class='bx bx-log-out icon' onclick="this.form.submit();"></i>
                                <span class="text nav-text">Back to course</span>
                            </button>
                        </form>

                    </li>


                </div>
            </div>
        </nav>
        <main>
            <div class="container">
                <div class="container__left">
                    <div class="lesson">
                        <div class="lesson_content">
                            <h3 style="text-align: justify;">
                                <strong>
                                    Lý Thuyết
                                </strong>
                            </h3>
                            <ul style="text-align: justify;">
                                <li>
                                    <h4>
                                        <strong>Khái niệm</strong>
                                    </h4>
                                </li>
                            </ul>
                            <%if (topicModel.getDescription().trim() != null) {%>
                            <form action="MainController" method="POST">
                                <input type="hidden" name="courseId" value="<%= courseId%>">
                                <input type="hidden" name="topicId" value="<%=topicModel.getTopicId()%>"/>
                                <input type="hidden" name="TopicToEditDescription" value="<%=topicModel.getTopicId()%>"/>
                                <textarea id="" name="txtDescriptionToEdit" rows="25" cols="80"><%= topicModel.getDescription()%></textarea>
                                <div class="btn__editCourse">
                                    <button class="submit__style" type="submit" name="action" value="EditDescription">Save changes</button>
                                </div>
                            </form>
                            <%} else {%> 
                            <form action="MainController" method="POST">
                                <input type="hidden" name="courseId" value="<%= courseId%>">
                                <input type="hidden" name="topicId" value="<%=topicModel.getTopicId()%>"/>
                                <input type="hidden" name="TopicToEditDescription" value="<%=topicModel.getTopicId()%>"/>
                                <textarea id="" name="txtDescriptionToEdit" rows="25" cols="80" placeholder="Input your content here"></textarea>
                                <div class="btn__editCourse">
                                    <button class="submit__style" type="submit" name="action" value="EditDescription">Save changes</button>
                                </div>
                            </form>
                            <%}%>
                            <br>
                            <%
                                QuizDTO quizDTO = null;
                                QuizBUS quizBUS = null;
                                quizBUS = new QuizBUS();
                                quizDTO = quizBUS.getByTopic(topicId);
                                if (quizDTO != null) {
                            %>
                            <form action="MainController" method="POST">
                                <h3>Bài tập</h3>
                                <ul>
                                    <h4>Input your question</h4>
                                    <li class="lesson_question" id="question" style="list-style: none;width: 100%;">
                                        <input type="hidden" name="courseId" value="<%= courseId%>">
                                        <input type="hidden" name="topicId" value="<%=topicModel.getTopicId()%>"/>
                                        <input type="hidden" name="TopicToEditQuiz" value="<%=topicModel.getTopicId()%>"/>
                                        <textarea id="" name="txtQuizToEdit" rows="5" cols="80" placeholder="Input Your Question Here"><%=quizDTO.getContent()%></textarea>
                                    </li>
                                    <div class="btn__editCourse">
                                        <button class="submit__style" type="submit" name="action" value="EditQuiz">Save changes</button>
                                    </div>
                                </ul>
                            </form>
                            <%} else {%>
                            <form action="MainController" method="POST">
                                <h3>Bài tập</h3>
                                <ul>
                                    <h4>Input your question</h4>
                                    <li class="lesson_question" id="question" style="list-style: none;width: 100%;">
                                        <input type="hidden" name="courseId" value="<%= courseId%>">
                                        <input type="hidden" name="topicId" value="<%=topicModel.getTopicId()%>"/>
                                        <input type="hidden" name="TopicToAddQuiz" value="<%=topicModel.getTopicId()%>"/>
                                        <textarea id="" name="txtQuizToAdd" rows="5" cols="80" placeholder="Input Your Question Here" required></textarea>
                                    </li>
                                    <div class="btn__editCourse">
                                        <button class="submit__style" type="submit" name="action" value="AddQuizToTopic">Save changes</button>
                                    </div>
                                </ul>
                            </form>
                            <%}%>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="resizer" id="dragMe" style="z-index:50;" init="1">
                    <button class="button-resize">
                        <i class="fas fa-right-left arrow-resize"></i>
                    </button>
                </div>
                <div class="container__right">
                    <div class="right-header">
                        <div class="reset-menu">
                            <a class="reset-button" id="reset">
                                <i class="fa-solid fa-rotate"></i>
                                <span>Reset</span>
                            </a>
                        </div>
                    </div>
                    <div class="answer">
                        <div class="answer-input">
                            <div class="answer-list">
                                <ul>
                                    <%
                                        ArrayList<AnswerDTO> answerList = null;
                                        AnswerBUS answerBUS = null;
                                        answerBUS = new AnswerBUS();
                                        if (quizDTO != null) {
                                            answerList = answerBUS.getByQuiz(quizDTO.getQuizId());
                                        } else {
                                            answerList = null;
                                        }
                                        if (answerList != null) {
                                            for (AnswerDTO answerDTO : answerList) {
                                                String status = answerDTO.getStatus();
                                                if (status.trim().equalsIgnoreCase("Active") == true) {
                                    %>
                                    <li class="answer-select" id="answer-select">
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="courseId" value="<%= courseId%>">
                                            <input type="hidden" name="topicId" value="<%=topicModel.getTopicId()%>"/>
                                            <input type="hidden" name="quizToEditOrDeleteAnswer" value="<%=quizDTO.getQuizId()%>"/>
                                            <input type="hidden" name="answerId" value="<%=answerDTO.getAnswerId()%>"/>
                                            <div class="answer-content">
                                                <textarea class="answer-content__input" id="" name="txtAnswerToEditOrDelete" rows="3" style="width: 600px;" required><%=answerDTO.getContent()%></textarea>
                                            </div>
                                            <div class="btn__editCourse">
                                                <div>
                                                    <%if (answerDTO.isCorrect() == true) {%>
                                                    <input type="radio" id="answerTrue" name="answerIsCorrect" value="true" checked="checked">TRUE</input>
                                                    <input type="radio" id="answerFalse" name="answerIsCorrect" value="false">FALSE</input>
                                                    <%} else {%>
                                                    <input type="radio" id="answerTrue" name="answerIsCorrect" value="true" >TRUE</input>
                                                    <input type="radio" id="answerFalse" name="answerIsCorrect" value="false" checked="checked">FALSE</input>
                                                    <%}%>
                                                </div>
                                                <div class="btn__editCourse">
                                                    <button type="submit" name="action" value="EditAnswer">Save change</button>
                                                </div>
                                                <div class="btn__editCourse">
                                                    <button type="submit" name="action" value="DeleteAnswer">Delete</button>  
                                                </div>
                                            </div>
                                        </form>
                                    </li>
                                    <%}%>
                                    <% }%>
                                    <li class="answer-select answer__select__new" id="answer-select">
                                        <form action="MainController"  method="POST">
                                            <input type="hidden" name="courseId" value="<%= courseId%>">
                                            <input type="hidden" name="topicId" value="<%=topicModel.getTopicId()%>"/>
                                            <input type="hidden" name="quizToAddAnswer" value="<%=quizDTO.getQuizId()%>"/>
                                            <h4>Add new answer option</h4>
                                            <div class="answer-content">
                                                <textarea class="answer-content__input" id="" name="txtAnswerToAdd" rows="3" style="width: 600px;" placeholder="Input Your Answer Here" required></textarea>
                                            </div>
                                            <div class="btn__editCourse">
                                                <input type="radio" id="answerTrue" name="answerIsCorrect" value="true" required>TRUE</input>
                                                <input type="radio" id="answerFalse" name="answerIsCorrect" value="false">FALSE</input>
                                                <button type="submit" name="action" value="AddAnswerToQuiz">Add option</button>
                                            </div>
                                        </form>
                                    </li>
                                    <%} else {
                                        if (quizDTO != null) {%>
                                    <li class="answer-select answer__select__new" id="answer-select">
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="courseId" value="<%= courseId%>">
                                            <input type="hidden" name="topicId" value="<%=topicModel.getTopicId()%>"/>
                                            <input type="hidden" name="quizToAddAnswer" value="<%=quizDTO.getQuizId()%>"/>
                                            <h4>Add new answer option</h4>
                                            <div class="answer-content">
                                                <textarea class="answer-content__input" id="" name="txtAnswerToAdd" rows="3" style="width: 600px;" placeholder="Input Your Answer Here" required></textarea>
                                            </div>
                                            <div class="btn__editCourse">
                                                <input type="radio" id="answerTrue" name="answerIsCorrect" value="true" required>TRUE</input>
                                                <input type="radio" id="answerFalse" name="answerIsCorrect" value="false">FALSE</input>
                                                <button type="submit" name="action" value="AddAnswerToQuiz">Add option</button>
                                            </div>
                                        </form>
                                    </li>
                                    <%}
                                        }%>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <!--phần dưới này ô nhắm xử lí đc thi để ko đc thì xóa cho khỏe nha-->
                    <div class="right-footer">
                        <div class="submit-menu">
                            <a class="previous-button" id="prevbtn">
                                <!--dung jsp redirect den trang hien tai-->
                                <i class="fa-solid fa-arrow-left"></i>
                                <span>Previous</span>
                            </a>
                            <a class="next-button" id="nextbtn">
                                <span>Next</span>
                                <i class="fa-solid fa-arrow-right"></i>
                            </a>
                            <a class="submit-button" id="submitbtn" input type="submit" value="Submit">
                                <i class="fa-solid fa-floppy-disk"></i>
                                <span>Submit</span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </body>

</html>