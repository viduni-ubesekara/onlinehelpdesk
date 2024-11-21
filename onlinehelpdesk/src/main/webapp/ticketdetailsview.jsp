<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ticket Details</title>
<style>
        /* Background Color */
        body {
            background-color: #f4f4f4; /* Change this to your desired background color */
        }
        /* User Profile Card */
        .user {
            padding: 20px;
            margin: 20px auto;
            max-width: 800px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .profile-picture {
            max-width: 200px;
            margin: 0 auto;
            border-radius: 50%;
        }
        .side-section {
            background-color: #f8f9fa;
            padding: 20px;
            border-radius: 5px;
            text-align: center;
        }
    </style>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha384-OSmPvj5/PDq7qR1G5p5Oy5F5QlR0E63fbbh7AIu7in5C5KtOZ9nvlC2xQfa3z9lP" crossorigin="anonymous">

   
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha384-OSmPvj5/PDq7qR1G5p5Oy5F5QlR0E63fbbh7AIu7in5C5KtOZ9nvlC2xQfa3z9lP" crossorigin="anonymous">

    <link rel="apple-touch-icon" href="images/apple-icon01.png">
    <link rel="shortcut icon" type="image/x-icon" href="images/apple-icon01.ico">

    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/templatemo.css">
    <link rel="stylesheet" href="css/custom.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
    <!-- Bootstrap CSS (if not already included) -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <!-- Load fonts style after rendering the layout styles -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
    <link rel="stylesheet" href="css/fontawesome.min.css">
</head>
<body>

<div class="container-fluid">
   <nav class="navbar navbar-expand-lg bg-dark navbar-light d-none d-lg-block" id="templatemo_nav_top">
        <div class="container text-light">
            <div class="w-100 d-flex justify-content-between">
                <div>
                    <i class="fas fa-envelope mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="mailto:info@company.com">armuniversity@support.com</a>
                    <i class="fas fa-phone mx-2"></i>
                    <a class="navbar-sm-brand text-light text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                </div>
                <div>
                	<a class="" href="adminlogin.jsp" style="color: white; font-size: 20px;">Admin Login</a>
                    <a class="text-light" href="https://fb.com/templatemo" target="_blank" rel="sponsored"><i class="fab fa-facebook-f fa-lg fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.instagram.com/" target="_blank"><i class="fab fa-instagram fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://twitter.com/" target="_blank"><i class="fab fa-twitter fa-sm fa-fw me-2"></i></a>
                    <a class="text-light" href="https://www.linkedin.com/" target="_blank"><i class="fab fa-linkedin fa-sm fa-fw"></i></a>
                </div>
            </div>
        </div>
    </nav>
    <!-- Close Top Nav -->

<nav class="navbar navbar-expand-lg navbar-light shadow">
        <div class="container d-flex justify-content-between align-items-center">

            <a class="navbar-brand text-success logo h1 align-self-center" href="home.jsp">
                ARM University
            </a>

            <button class="navbar-toggler border-0" type="button" data-bs-toggle="collapse" data-bs-target="#templatemo_main_nav" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="align-self-center collapse navbar-collapse flex-fill  d-lg-flex justify-content-lg-between" id="templatemo_main_nav">
                <div class="flex-fill">
                    <ul class="nav navbar-nav d-flex justify-content-between mx-lg-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="home.jsp">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.jsp">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ticketraise.jsp">Ticket Raise</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="feedbackinsert.jsp">Feedback Us</a>
                        </li>
                        
                    </ul>
                </div>
                <div class="navbar align-self-center d-flex">
                   
                    
                    <a class="nav-icon position-relative text-decoration-none" href="login.jsp">
    <i class="fa fa-fw fa-user fa-2x text-dark mr-3"></i>
    <span class="position-absolute top-0 left-100 translate-middle badge rounded-pill bg-light text-dark">+99</span>
</a>
                </div>
            </div>

        </div>
    </nav>
    <!-- Close Header -->


</div>


<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div class="user mt-5">
                <h1 class="text-center">Ticket Details</h1>
                <table class="table">
                    <c:forEach var="cus" items="${ticketDetails}">
                    <c:set var="ticketid" value="${cus.ticketid}"/><!-- this line internally call to the get ID method in student class -->
                    <c:set var="name" value="${cus.name}"/>
                    <c:set var="email" value="${cus.email}"/>
                    <c:set var="studentid" value="${cus.studentid}"/>
					<c:set var="faculty" value="${cus.faculty}"/>
					<c:set var="phone" value="${cus.phone}"/>
					<c:set var="inquiry" value="${cus.inquiry}"/>
					<c:set var="subinquiry" value="${cus.subinquiry}"/>					
					<c:set var="subject" value="${cus.subject}"/>
					<c:set var="message" value="${cus.message}"/>

                        <tr>
                            <td>Ticket ID</td>
                            <td>${cus.ticketid}</td>
                        </tr>
                        <tr>
                            <td>Name</td>
                            <td>${cus.name}</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>${cus.email}</td>
                        </tr>
                        <tr>
                            <td>Student Id</td>
                            <td>${cus.studentid}</td>
                        </tr>
                        <tr>
                            <td>Faculty</td>
                            <td>${cus.faculty}</td>
                        </tr>
                        <tr>
                            <td>Contact Number</td>
                            <td>${cus.phone}</td>
                        </tr>
                        
                        <tr>
                            <td>Inquiry Type</td>
                            <td>${cus.inquiry}</td>
                        </tr>
                        <tr>
                            <td>Sub Inquiry </td>
                            <td>${cus.subinquiry}</td>
                        </tr>
                        <tr>
                            <td>Subject</td>
                            <td>${cus.subject}</td>
                        </tr>
                        <tr>
                            <td>message</td>
                            <td>${cus.message}</td>
                        </tr>
                        

                       
                    </c:forEach>
                </table>
                <br>
                <c:url value="ticketraiseupdate.jsp" var="ticketupdate"><!-- navigate to the updatestudent page and show these details -->
				<c:param name="ticketid" value="${ticketid}"/><!-- ID is the variable name of set tag above -->
				<c:param name="name" value="${name}"/>
				<c:param name="email" value="${email}"/>
				<c:param name="studentid" value="${studentid}"/>
				<c:param name="faculty" value="${faculty}"/>
				<c:param name="phone" value="${phone}"/>				
				<c:param name="inquiry" value="${inquiry}"/>
				<c:param name="subinquiry" value="${subinquiry}"/>
				<c:param name="subject" value="${subject}"/>
				<c:param name="message" value="${message}"/>
				
				
				</c:url>
            </div>
        </div>
        <div class="col-md-4">
            <div class="side-section mt-5">
                
                <h3 class="mt-3">Actions</h3>
                
                <a href="${ticketupdate}" class="btn btn-info btn-block">Edit Ticket</a>
                
    <c:url value="ticketdelete.jsp" var="ticketdelete">
				<c:param name="ticketid" value="${ticketid}"/><!-- ID is the variable name of set tag above -->
				<c:param name="name" value="${name}"/>
				<c:param name="email" value="${email}"/>
				<c:param name="studentid" value="${studentid}"/>
				<c:param name="faculty" value="${faculty}"/>
				<c:param name="phone" value="${phone}"/>				
				<c:param name="inquiry" value="${inquiry}"/>
				<c:param name="subinquiry" value="${subinquiry}"/>
				<c:param name="subject" value="${subject}"/>
				<c:param name="message" value="${message}"/>
	</c:url>
               
    				 <a href="${ticketdelete}" name="delete" class="btn btn-danger btn-block">Delete</a>
    				

            </div>
        </div>
    </div>
</div>





<!-- Start Footer -->
<footer class="bg-dark" id="tempaltemo_footer">
    <div class="container">
        <div class="row">

            <div class="col-md-4 pt-2"> <!-- Reduced pt-3 to pt-2 -->
                <h3 class="h3 text-success border-bottom pb-2 border-light logo">ARM University</h3> <!-- Reduced font size -->
                <ul class="list-unstyled text-light footer-link-list">
                    <li>
                        <i class="fas fa-map-marker-alt fa-fw"></i>
                        No.12 ARM University, Colombo 04.
                    </li>
                    <li>
                        <i class="fa fa-phone fa-fw"></i>
                        <a class="text-decoration-none" href="tel:010-020-0340">010-020-0340</a>
                    </li>
                    <li>
                        <i class="fa fa-envelope fa-fw"></i>
                        <a class="text-decoration-none" href="mailto:info@company.com">armuniversity@support.com</a>
                    </li>
                </ul>
            </div>

            <div class="col-md-4 pt-2"> <!-- Reduced pt-3 to pt-2 -->
                <h3 class="h3 text-light border-bottom pb-2 border-light">Ticket Raise</h3> <!-- Reduced font size -->
                <ul class="list-unstyled text-light footer-link-list">
                    <li><a class="text-decoration-none" href="#">Payments</a></li>
                    <li><a class="text-decoration-none" href="#">Modules</a></li>
                    <li><a class="text-decoration-none" href="#">Marks Issue</a></li>
                    <li><a class="text-decoration-none" href="#">Examinations</a></li>
                    <li><a class="text-decoration-none" href="#">FAQ</a></li>
                   
                </ul>
            </div>

            <div class="col-md-4 pt-2"> <!-- Reduced pt-3 to pt-2 -->
                <h3 class="h3 text-light border-bottom pb-2 border-light">Further Info</h3> <!-- Reduced font size -->
                <ul class="list-unstyled text-light footer-link-list">
                    <li><a class="text-decoration-none" href="home.jsp">Home</a></li>
                    <li><a class="text-decoration-none" href="aboutus.jsp">About Us</a></li>
                    <li><a class="text-decoration-none" href="events.jsp">Ticket Raise</a></li>
                    
                    <li><a class="text-decoration-none" href="contact.jsp">Feedback</a></li>
                </ul>
            </div>

        </div>

        <div class="row text-light mb-1"> <!-- Reduced mb-2 to mb-1 -->
            <div class="col-12 mb-2">
                <div class="w-100 my-2 border-top border-light"></div>
            </div>
            <div class="col-auto me-auto">
                <ul class="list-inline text-left footer-icons">
                    <li class="list-inline-item border border-light rounded-circle text-center">
                        <a class="text-light text-decoration-none" target="_blank" href="http://facebook.com/"><i class="fab fa-facebook-f fa-lg fa-fw"></i></a>
                    </li>
                    <li class="list-inline-item border border-light rounded-circle text-center">
                        <a class="text-light text-decoration-none" target="_blank" href="https://www.instagram.com/"><i class="fab fa-instagram fa-lg fa-fw"></i></a>
                    </li>
                    <li class="list-inline-item border border-light rounded-circle text-center">
                        <a class="text-light text-decoration-none" target="_blank" href="https://twitter.com/"><i class="fab fa-twitter fa-lg fa-fw"></i></a>
                    </li>
                    <li class="list-inline-item border border-light rounded-circle text-center">
                        <a class="text-light text-decoration-none" target="_blank" href="https://www.linkedin.com/"><i class="fab fa-linkedin fa-lg fa-fw"></i></a>
                    </li>
                </ul>
            </div>
            <div class="col-auto">
                <label class="sr-only" for="subscribeEmail">Email address</label>
                <div class="input-group mb-1"> <!-- Reduced mb-2 to mb-1 -->
                    <input type="text" class="form-control bg-dark border-light" id="subscribeEmail" placeholder="Email address">
                    <div class="input-group-text btn-success text-light">Subscribe</div>
                </div>
            </div>
        </div>
    </div>

    <div class="w-100 bg-black py-1"> <!-- Reduced py-2 to py-1 -->
        <div class="container">
            <div class="row pt-1"> <!-- Reduced pt-2 to pt-1 -->
                <div class="col-12">
                    <p class="text-left text-light">
                        Copyright &copy; 2021 BlackCode Software Solutions
                        | Designed by <a rel="sponsored" href="https://templatemo.com" target="_blank">BlackCode Software Solutions.</a>
                    </p>
                </div>
            </div>
        </div>
    </div>
</footer>
<!-- End Footer -->

<!-- Start Script -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.11.0.min.js"></script>
    <script src="js/jquery-migrate-1.2.1.min.js"></script>
    <script src="js/bootstrap.bundle.min.js"></script>
    <script src="js/templatemo.js"></script>
    <script src="js/custom.js"></script>
    <!-- End Script -->

</body>
</html>
