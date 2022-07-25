<%@page import="students.StudentError" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>

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

        <script src="https://kit.fontawesome.com/77d5a89f77.js" crossorigin="anonymous"></script>
        <!--===============================================================================================-->

        <title>Author Register</title>
    </head>

    <body>
        <% StudentError error = (StudentError) request.getAttribute("ERROR");
            if (error == null) {
                error = new StudentError();
            }%>

        <div class="limiter">

            <div class="container-login100" style="background-image: url('images/loginBackground.jpg');">
                <div class="wrap-login100 regis p-l-55 p-r-55 p-t-40 p-b-40" style="width:1000px">
                    <form name="Register" method="POST" action="MainControllerAdmin"
                          class="login100-form validate-form" id="authorRegister" >
                        <input hidden="" name="action" value="RegisterAuthor">
                        <input hidden="" name="controller" value="RegisterAuthor">

                        <span class="login100-form-title p-b-39">
                            Author Register
                        </span>

                        <div class="wrapper" style="display: flex; justify-content: space-between;">
                            <div class="input-wrapper" style="width: 40%">
                                <div class="wrap-input100 validate-input m-b-23">
                                    <span class="label-input100">Email <span style="color: red">*</span></span>
                                    <input value="${param.email}" class="input100" required="" type="text"
                                           name="txtemail" placeholder="Email">
                                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                                </div>
                                <p>
                                    <%= error.getEmail()%>
                                </p>

                                <div class="wrap-input100 validate-input m-b-23">
                                    <span class="label-input100">Password <span
                                            style="color: red">*</span></span>
                                    <input value="${param.password}" class="input100" required=""
                                           type="password" name="txtpassword" placeholder="Password"
                                           >
                                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                                </div>
                                <p>
                                    <%= error.getPassword()%>
                                </p>

                                <div class="wrap-input100 validate-input m-b-23">
                                    <span class="label-input100">Status <span
                                            style="color: red">*</span></span>
                                    <input value="${param.status}" class="input100" required=""
                                           type="text" name="txtstatus" placeholder="Status">
                                    <span class="focus-input100" data-symbol="&#xf190;"></span>
                                </div>



                            </div>
                            <%-- end input wrapper --%>

                            <div class="input-wrapper" style="width: 40%">

                                <div class="wrap-input100 validate-input m-b-23">
                                    <span class="label-input100">First name</span>
                                    <input value="${param.firstName}" class="input100" type="text"
                                           name="txtfirstName" placeholder="First name" maxlength="20">
                                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                                </div>
                                <p>
                                    <%= error.getFirstName()%>
                                </p>

                                <div class="wrap-input100 validate-input m-b-23">
                                    <span class="label-input100">Last name</span>
                                    <input value="${param.lastName}" class="input100" type="text"
                                           name="txtlastName" placeholder="Last name" maxlength="50">
                                    <span class="focus-input100" data-symbol="&#xf206;"></span>
                                </div>
                                <p>
                                    <%= error.getLastName()%>
                                </p>

                                <div class="wrap-input100">
                                    <span class="label-input100">Phone number</span>
                                    <input value="${param.phoneNumber}" class="input100" type="tel"
                                           name="txtphoneNumber" pattern="[0-9]{10}" placeholder="Phone number">
                                    <span class="focus-input100" data-symbol="&phone;"></span>
                                </div>
                                <p>
                                    <%= error.getPhoneNumber()%>
                                </p>
                            </div>
                            <%-- end input wrapper --%>
                        </div>
                        <%-- end wrapper --%>
                        <div class="text-right p-t-20">
                            <div class="container-login100-form-btn">
                                <div class="wrap-login100-form-btn">
                                    <div onclick="submit_form('authorRegister')" class="login100-form-bgbtn"></div>
                                    <button class="login100-form-btn" style="">
                                        Register
                                    </button>
                                </div>
                            </div>
                        </div>





                    </form>
                </div>
            </div>
        </div>

        <script src="js/validate.js"></script>
        <script>
                                        function submit_form(form_id) {
                                            var form = document.getElementById(form_id);
                                            form.submit();
                                        }
        </script>
    </body>
</html>