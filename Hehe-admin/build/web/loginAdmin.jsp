<%-- 
    Document   : loginAdmin
    Created on : 19-Jul-2022, 10:34:12
    Author     : triud
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login admin</title>
        <link rel="stylesheet" href="css/mycss.css" type="text/css"/>
        <!--===============================================================================================-->
        <link rel="icon" type="image/png" href="images/icons/favicon.ico" />
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
        <!--===============================================================================================-->
        <link rel="stylesheet" type="text/css" href="css/util.css">
        <link rel="stylesheet" type="text/css" href="css/main.css">
        <!--===============================================================================================-->
    </head>
    <body>
        <div class="limiter">
            <div class="container-login100" style="background-image: url('images/loginBackground.jpg');">
                <div class="wrap-login100 p-l-55 p-r-55 p-t-40 p-b-40">
                    <form name="Login" method="POST" action="MainControllerAdmin" class="login100-form validate-form">


                        <input hidden="" name="controller" value="Admin"> 
                        <input hidden="" name="action" value="LoginAdmin">
                        <span class="login100-form-title p-b-39">
                            Login
                        </span>

                        <!-- pattern="^([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x22([^\x0d\x22\x5c\x80-\xff]|\x5c[\x00-\x7f])*\x22))*\x40([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d)(\x2e([^\x00-\x20\x22\x28\x29\x2c\x2e\x3a-\x3c\x3e\x40\x5b-\x5d\x7f-\xff]+|\x5b([^\x0d\x5b-\x5d\x80-\xff]|\x5c[\x00-\x7f])*\x5d))*(\.\w{2,})+$"
                        -->
                        <font style="color: red"><%= (request.getAttribute("WARNING") == null) ? "" : (String) request.getAttribute("WARNING")%></font>
                        <div class="wrap-input100 validate-input m-b-23" data-validate="Email is required">
                            <span class="label-input100">Email</span>
                            <input value="${param.email}" id="email" class="input100" type="text" name="email"
                                   placeholder="Type your email"
                                   title="The domain portion of the email address is invalid (the portion after the @).">
                            <span class="focus-input100" data-symbol="&#xf206;"></span>
                        </div>

                        <div class="wrap-input100 validate-input" data-validate="Password is required">
                            <span class="label-input100">Password</span>
                            <input value="${param.password}" id="password" class="input100" type="password"
                                   name="password" placeholder="Type your password">
                            <span class="focus-input100" data-symbol="&#xf190;"></span>
                        </div>

                        <br>
                        <%
<<<<<<< HEAD:Hehe/web/loginAdmin.jsp
                            String login_msg = (String) request.getAttribute("error");
                            if (login_msg != null) {
                                out.println("<font color=red size=4px>" + login_msg + "</font>");
                            }
                        %>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>

=======
                                    String login_msg = (String) request.getAttribute("error");
                                    if (login_msg != null) {
                                        out.println("<font color=red size=4px>" + login_msg + "</font>");
                                    }
                                %>
                        <div class="container-login100-form-btn">
                            <div class="wrap-login100-form-btn">
                                <div class="login100-form-bgbtn"></div>
                                
>>>>>>> 9bd87552392e961f7d9a5c8d31739f2337b15ac4:Hehe-admin/build/web/loginAdmin.jsp
                                <button type="submit" class="login100-form-btn">
                                    Login
                                </button>
                            </div>
                        </div>
<<<<<<< HEAD:Hehe/web/loginAdmin.jsp

                        <div class="txt1 text-center p-t-30 p-b-20">
                            <span>
                                Or Login Using
                            </span>
                        </div>

                        <div class="flex-c-m">
                            <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/Hehe-admin/login-google-admin&response_type=code
                               &client_id=894467286073-gu13he3q90ma2on3nfjigafidbtvpgur.apps.googleusercontent.com&approval_prompt=force" class="login100-social-item bg3">
                                <i class="fa fa-google"></i>
                            </a>
                        </div>
=======
                        
                         <div class="txt1 text-center p-t-30 p-b-20">
              <span>
                Or Login Using
              </span>
            </div>

            <div class="flex-c-m">
              <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8080/Hehe/login-google-admin&response_type=code
                                       &client_id=894467286073-gu13he3q90ma2on3nfjigafidbtvpgur.apps.googleusercontent.com&approval_prompt=force" class="login100-social-item bg3">
                <i class="fa fa-google"></i>
              </a>
            </div>






>>>>>>> 9bd87552392e961f7d9a5c8d31739f2337b15ac4:Hehe-admin/build/web/loginAdmin.jsp
                    </form>
                </div>
            </div>
        </div>
    </body>
<<<<<<< HEAD:Hehe/web/loginAdmin.jsp
</html>
=======
</html>
>>>>>>> 9bd87552392e961f7d9a5c8d31739f2337b15ac4:Hehe-admin/build/web/loginAdmin.jsp
