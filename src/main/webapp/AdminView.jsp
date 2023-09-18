<%@page import="jkfitness.model.Clients"%>
<%@page import="jkfitness.dbfunctions.GetClients"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>

<head>
<title>JKfitness: The Ultimate Gym</title>
<%@ include file="jsp/headerAdmin.jsp"%>
</head>
<body> 
  <div class = "home-content-wrapper">
    <div class="cotainer">
       <div class="row justify-content-center">
         <div class="col-md-11">
             <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <div class=SlideshowText>
                      <h1>Welcome Admin <br>
                      This Site is Yours</h1>
                   </div>
                 </div>
                 <div class="carousel-item ">
                   <div class=SlideshowText>
                     <h1>Want To View Clients ? <br>
                     Go to The Navbar</h1>
                   </div>
                 </div>
                     <div class="carousel-item ">
                       <div class=SlideshowText>
                         <h1>Time For A New Membership to Our Gym? <br>
                         Add One Easily! </h1>
                       </div>
                   </div>
               </div> 
              <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
              </a> 
              <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
              </a>
             </div>
         </div>
      </div>
    </div>
  </div>
</body>
<%@ include file="jsp/footer.jsp"%>
</html>