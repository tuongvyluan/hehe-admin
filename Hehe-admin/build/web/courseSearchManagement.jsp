<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Admin</title>
        <!-- Favicon icon -->
        <link rel="icon" type="image/png" sizes="16x16" href="images/favicon.png">
        <!-- Pignose Calender -->
        <link href="./plugins/pg-calendar/css/pignose.calendar.min.css" rel="stylesheet">
        <!-- Chartist -->
        <link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
        <link rel="stylesheet" href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
        <!-- Custom Stylesheet -->
        <link href="css/style_admin.css" rel="stylesheet">
        <script src="https://kit.fontawesome.com/77d5a89f77.js" crossorigin="anonymous"></script>

    </head>

    <body>

        <!--*******************
            Preloader start
        ********************-->
        <div id="preloader">
            <div class="loader">
                <svg class="circular" viewBox="25 25 50 50">
                <circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3" stroke-miterlimit="10" />
                </svg>
            </div>
        </div>
        <!--*******************
            Preloader end
        ********************-->


        <!--**********************************
            Main wrapper start
        ***********************************-->
        <div id="main-wrapper">

            <!--**********************************
                Nav header start
            ***********************************-->
            <div class="nav-header">
                <div class="brand-logo">
                    <a href="admin.jsp">

                        <span class="logo-compact"><img src="./images/logowhite-removebg-preview.png" alt=""></span>
                        <span class="brand-title">
                            <img
                                src="images/logowhite-removebg-preview.png"
                                alt=""
                                class="img-fluid"
                                height="10rem"
                                />
                        </span>
                    </a>
                </div>
            </div>
            <!--**********************************
                Nav header end
            ***********************************-->

            <!--**********************************
                Header start
            ***********************************-->
            <div class="header">    
                <div class="header-content clearfix">

                    <div class="nav-control">
                        <div class="hamburger">
                            <span class="toggle-icon"><i class="icon-menu"></i></span>
                        </div>
                    </div>
                    <div class="header-left">

                    </div>
                    <div class="header-right">
                        <ul class="clearfix">
                            <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                    <i class="mdi mdi-email-outline"></i>
                                    <span class="badge badge-pill gradient-1">3</span>
                                </a>
                                <div class="drop-down animated fadeIn dropdown-menu">
                                    <div class="dropdown-content-heading d-flex justify-content-between">
                                        <span class="">3 New Messages</span>  
                                        <a href="javascript:void()" class="d-inline-block">
                                            <span class="badge badge-pill gradient-1">3</span>
                                        </a>
                                    </div>
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li class="notification-unread">
                                                <a href="javascript:void()">
                                                    <img class="float-left mr-3 avatar-img" src="images/avatar/1.jpg" alt="">
                                                    <div class="notification-content">
                                                        <div class="notification-heading">Saiful Islam</div>
                                                        <div class="notification-timestamp">08 Hours ago</div>
                                                        <div class="notification-text">Hi Teddy, Just wanted to let you ...</div>
                                                    </div>
                                                </a>
                                            </li>
                                            <li class="notification-unread">
                                                <a href="javascript:void()">
                                                    <img class="float-left mr-3 avatar-img" src="images/avatar/2.jpg" alt="">
                                                    <div class="notification-content">
                                                        <div class="notification-heading">Adam Smith</div>
                                                        <div class="notification-timestamp">08 Hours ago</div>
                                                        <div class="notification-text">Can you do me a favour?</div>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <img class="float-left mr-3 avatar-img" src="images/avatar/3.jpg" alt="">
                                                    <div class="notification-content">
                                                        <div class="notification-heading">Barak Obama</div>
                                                        <div class="notification-timestamp">08 Hours ago</div>
                                                        <div class="notification-text">Hi Teddy, Just wanted to let you ...</div>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <img class="float-left mr-3 avatar-img" src="images/avatar/4.jpg" alt="">
                                                    <div class="notification-content">
                                                        <div class="notification-heading">Hilari Clinton</div>
                                                        <div class="notification-timestamp">08 Hours ago</div>
                                                        <div class="notification-text">Hello</div>
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>

                                    </div>
                                </div>
                            </li>
                            <li class="icons dropdown"><a href="javascript:void(0)" data-toggle="dropdown">
                                    <i class="mdi mdi-bell-outline"></i>
                                    <span class="badge badge-pill gradient-2">3</span>
                                </a>
                                <div class="drop-down animated fadeIn dropdown-menu dropdown-notfication">
                                    <div class="dropdown-content-heading d-flex justify-content-between">
                                        <span class="">2 New Notifications</span>  
                                        <a href="javascript:void()" class="d-inline-block">
                                            <span class="badge badge-pill gradient-2">5</span>
                                        </a>
                                    </div>
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li>
                                                <a href="javascript:void()">
                                                    <span class="mr-3 avatar-icon bg-success-lighten-2"><i class="icon-present"></i></span>
                                                    <div class="notification-content">
                                                        <h6 class="notification-heading">Events near you</h6>
                                                        <span class="notification-text">Within next 5 days</span> 
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <span class="mr-3 avatar-icon bg-danger-lighten-2"><i class="icon-present"></i></span>
                                                    <div class="notification-content">
                                                        <h6 class="notification-heading">Event Started</h6>
                                                        <span class="notification-text">One hour ago</span> 
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <span class="mr-3 avatar-icon bg-success-lighten-2"><i class="icon-present"></i></span>
                                                    <div class="notification-content">
                                                        <h6 class="notification-heading">Event Ended Successfully</h6>
                                                        <span class="notification-text">One hour ago</span>
                                                    </div>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <span class="mr-3 avatar-icon bg-danger-lighten-2"><i class="icon-present"></i></span>
                                                    <div class="notification-content">
                                                        <h6 class="notification-heading">Events to Join</h6>
                                                        <span class="notification-text">After two days</span> 
                                                    </div>
                                                </a>
                                            </li>
                                        </ul>

                                    </div>
                                </div>
                            </li>
                            <li class="icons dropdown d-none d-md-flex">
                                <a href="javascript:void(0)" class="log-user"  data-toggle="dropdown">
                                    <span>English</span>  <i class="fa fa-angle-down f-s-14" aria-hidden="true"></i>
                                </a>
                                <div class="drop-down dropdown-language animated fadeIn  dropdown-menu">
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li><a href="javascript:void()">English</a></li>
                                            <li><a href="javascript:void()">Dutch</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                            <li class="icons dropdown">
                                <div class="user-img c-pointer position-relative"   data-toggle="dropdown">
                                    <span class="activity active"></span>
                                    <img src="images/hehe.png" height="40" width="40" alt="">
                                </div>
                                <div class="drop-down dropdown-profile animated fadeIn dropdown-menu">
                                    <div class="dropdown-content-body">
                                        <ul>
                                            <li>
                                                <a href="app-profile.html"><i class="icon-user"></i> <span>Profile</span></a>
                                            </li>
                                            <li>
                                                <a href="javascript:void()">
                                                    <i class="icon-envelope-open"></i> <span>Inbox</span> <div class="badge gradient-3 badge-pill gradient-1">3</div>
                                                </a>
                                            </li>

                                            <hr class="my-2">
                                            <li>
                                                <a href="page-lock.html"><i class="icon-lock"></i> <span>Lock Screen</span></a>
                                            </li>
                                            <li><a href="AdminController?action=LogOut"><i class="icon-key"></i> <span>Logout</span></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
            <!--**********************************
                Header end ti-comment-alt
            ***********************************-->

            <!--**********************************
                Sidebar start
            ***********************************-->
            <div class="nk-sidebar">           
                <div class="nk-nav-scroll">
                    <ul class="metismenu" id="menu">
                        <li class="nav-label">Dashboard</li>
                        <li>
                            <a href="admin.jsp" aria-expanded="false" >
                                <i class="icon-home menu-icon"></i><span>Home</span>
                            </a>
                        </li>
                        <li >
                            <form  name="ViewStudent"  action="MainControllerAdmin" method="POST" id="duong" aria-expanded="false" >
                                <input type="hidden" name="action" value="ViewStudent"/>
                                <input type="hidden" name="controller" value="Student"/>
                                <input type="hidden" name="search" value="${requestScope.search}"/>
                                <input type="hidden" name="pageNumber" value="1"/>
                                <input type="hidden" name="rowsOfPage" value="200"/>
                            </form>
                            <a onClick="submit_form('duong')"  aria-expanded="false">
                                <i class="icon-user menu-icon"></i><span class="nav-text">Student management</span>
                            </a>
                        </li>
                        <li>
                            <form  name="ViewAuthor"  action="MainControllerAdmin" method="POST" id="author" aria-expanded="false" >
                                <input type="hidden" name="action" value="ViewAuthor"/>
                                <input type="hidden" name="controller" value="Author"/>
                                <input type="hidden" name="search" value="${requestScope.search}"/>
                                <input type="hidden" name="pageNumber" value="1"/>
                                <input type="hidden" name="rowsOfPage" value="200"/>
                            </form>
                            <a onClick="submit_form('author')" aria-expanded="false">
                                <i class="icon-user menu-icon"></i><span class="nav-text">Author management</span>
                            </a>
                        </li>
                        <li>
                            <form  name="ViewCourse"  action="MainControllerAdmin" method="POST" id="course" aria-expanded="false" >
                                <input type="hidden" name="action" value="ViewCourse"/>
                                <input type="hidden" name="controller" value="Course"/>
                                <input type="hidden" name="search" value="${requestScope.search}"/>
                                <input type="hidden" name="pageNumber" value="1"/>
                                <input type="hidden" name="rowsOfPage" value="200"/>
                            </form>
                            <a onClick="submit_form('course')" aria-expanded="false">
                                <i class="icon-user menu-icon"></i><span class="nav-text">Course management</span>
                            </a>
                        </li>
                        <li>
                            <form  name="ViewCategory"  action="MainControllerAdmin" method="POST" id="category" aria-expanded="false" >
                                <input type="hidden" name="action" value="ViewCategory"/>
                                <input type="hidden" name="controller" value="Category"/>
                                <input type="hidden" name="search" value="${requestScope.search}"/>
                                <input type="hidden" name="pageNumber" value="1"/>
                                <input type="hidden" name="rowsOfPage" value="200"/>
                            </form>
                            <a onClick="submit_form('category')" aria-expanded="false">
                                <i class="icon-user menu-icon"></i><span class="nav-text">Category management</span>
                            </a>
                        </li>
                        <li>
                            <a href="registerAuthor.jsp" aria-expanded="false">
                                <i class="icon-user menu-icon"></i><span class="nav-text">Author register</span>
                            </a>
                        </li>
                        <li>
                            <a href="addCategory.jsp" aria-expanded="false">
                                <i class="icon-user menu-icon"></i><span class="nav-text">Add category</span>
                            </a>
                        </li>

                    </ul>
                </div>
            </div>
            <!--**********************************
                Sidebar end
            ***********************************-->

            <!--**********************************
                Content body start
            ***********************************-->
            <div class="content-body">

                <div class="container-fluid mt-3">
                    <h1>Course management</h1>
                    <form action="CourseControllerAdmin" method="post">
                        <div class="input-group icons">

                            <input type="search" class="form-control" placeholder="Search course" aria-label="Search Dashboard" name="txtSearch">
                            <div class="drop-down animated flipInX d-md-none">


                            </div>
                            <input class="btn btn-primary m-1" type="submit" name="action" value="Search"><br/>
                        </div>
                        <%
                            String login_msg = (String) request.getAttribute("errorNotFound");
                            if (login_msg != null) {
                                out.println("<font color=red size=4px>" + login_msg + "</font>");
                            }
                        %>
                    </form>
                    <h1></h1>

                    <div class="row">
                        <div class="col-lg-12">
                            <div class="row">
                                <div class="col-12">

                                </div>
                            </div>
                        </div>
                    </div>







                    <div class="row">
                        <div class="col-lg-12">
                            <div class="card">
                                <div class="card-body">
                                    <div class="active-member">
                                        <div class="table-responsive">
                                            <table class="table table-xs mb-0">
                                                <thead>
                                                    <tr>
                                                        <th>Id</th>
                                                        <th>Name</th>
                                                        <th>Description</th>
                                                        <th>Status</th>
                                                        <th>Price</th>
                                                        <th>Duration</th>
                                                        <th>Action</th>

                                                    </tr>
                                                </thead>
                                                <tbody>
                                                    <c:forEach var="searchCrs" items="${requestScope.searchCrs}">
                                                        <tr>
                                                            <td><c:out value="${searchCrs.getCourseId()}"></c:out></td>
                                                            <td><c:out value="${searchCrs.getCourseName()}"></c:out></td>
                                                            <td><c:out value="${searchCrs.getDescription()}"></c:out></td>
                                                            <td><c:out value="${searchCrs.getStatus()}"></c:out></td>
                                                            <td><c:out value="${searchCrs.getPrice()}"></c:out></td>
                                                            <td><c:out value="${searchCrs.getDuration()}"></c:out></td>


                                                                <td>
                                                                <c:if test="${searchCrs.getStatus() == 'Active'}">
                                                                    <c:url var="mylink" value="CourseControllerAdmin">
                                                                        <c:param name="id" value="${searchCrs.getCourseId()}"></c:param>
                                                                        <c:param name="status" value="${searchCrs.getStatus()}"></c:param>
                                                                        <c:param name="action" value="updateStatusAccount"></c:param>
                                                                    </c:url>
                                                                    <a class="btn btn-primary" href="${mylink}">Block</a>
                                                                </c:if>
                                                                <c:if test="${searchCrs.getStatus() == 'Inactive'}">
                                                                    <c:url var="mylink" value="CourseControllerAdmin">
                                                                        <c:param name="id" value="${searchCrs.getCourseId()}"></c:param>
                                                                        <c:param name="status" value="${searchCrs.getStatus()}"></c:param>
                                                                        <c:param name="action" value="updateStatusAccount"></c:param>
                                                                    </c:url>
                                                                    <a class="btn btn-primary" href="${mylink}">Un-Block</a>
                                                                </c:if>
                                                            </td>


                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>                        
                        </div>
                    </div>






                </div>
                <!-- #/ container -->
            </div>
            <!--**********************************
                Content body end
            ***********************************-->


            <!--**********************************
                Footer start
            ***********************************-->
            <div class="footer">
                <div class="copyright">
                    <p>Copyright &copy; Designed & Developed by <a href="https://themeforest.net/user/quixlab">Quixlab</a> 2018</p>
                </div>
            </div>
            <!--**********************************
                Footer end
            ***********************************-->
        </div>
        <!--**********************************
            Main wrapper end
        ***********************************-->

        <!--**********************************
            Scripts
        ***********************************-->
        <script src="plugins/common/common.min.js"></script>
        <script src="js/custom.min.js"></script>
        <script src="js/settings.js"></script>
        <script src="js/gleek.js"></script>
        <script src="js/styleSwitcher.js"></script>

        <!-- Chartjs -->
        <script src="./plugins/chart.js/Chart.bundle.min.js"></script>
        <!-- Circle progress -->
        <script src="./plugins/circle-progress/circle-progress.min.js"></script>
        <!-- Datamap -->
        <script src="./plugins/d3v3/index.js"></script>
        <script src="./plugins/topojson/topojson.min.js"></script>
        <script src="./plugins/datamaps/datamaps.world.min.js"></script>
        <!-- Morrisjs -->
        <script src="./plugins/raphael/raphael.min.js"></script>
        <script src="./plugins/morris/morris.min.js"></script>
        <!-- Pignose Calender -->
        <script src="./plugins/moment/moment.min.js"></script>
        <script src="./plugins/pg-calendar/js/pignose.calendar.min.js"></script>
        <!-- ChartistJS -->
        <script src="./plugins/chartist/js/chartist.min.js"></script>
        <script src="./plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>



        <script src="./js/dashboard/dashboard-1.js"></script>
        <script>
                                function submit_form(form_id) {
                                    var form = document.getElementById(form_id);
                                    form.submit();
                                }
        </script>
    </body>

</html>