<%@page import="jkfitness.model.Clients"%>
<%@page import="jkfitness.dbfunctions.GetClients"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>

<head>
<title>JKfitness: The Ultimate Gym</title>
<%@ include file="jsp/headerClient.jsp"%>
</head>

<% Clients CurrentClient = null ;
 String ClientPk = session.getAttribute("CurrentClientPk").toString();
 CurrentClient = GetClients.GetCurrentClientByClientPk(ClientPk, null, true);%>

<body> 
  <div class = "home-content-wrapper">
    <div class="cotainer">
       <div class="row justify-content-center">
         <div class="col-md-11">
             <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
               <div class="carousel-inner">
                 <div class="carousel-item active">
                   <div class=SlideshowText>
                      <h1>Welcome <%=CurrentClient.getName() %> <br>
                      Go to Navbar To Review Your Info</h1>
                   </div>
                 </div>
                 <div class="carousel-item ">
                   <div class=SlideshowText>
                     <h1>Want To Start Personal Training ? <br>
                     Contact Our Personal Trainers And Start</h1>
                   </div>
                 </div>
                     <div class="carousel-item ">
                       <div class=SlideshowText>
                         <h1>Live The Life You Want <br>
                         Build the Body Of your Dreams </h1>
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