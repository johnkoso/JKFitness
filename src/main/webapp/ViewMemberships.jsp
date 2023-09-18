<%@page import="jkfitness.dbfunctions.GetMemberships"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="jkfitness.utility.*"%>
<%@page import="jkfitness.controller.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page  import="jkfitness.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Change your Credentials</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <%@ include file="jsp/header.jsp"%>
</head>
<body>
  <div> <br> </div>
    <div class="cotainer">
      <div class="row justify-content-center">
        <div class="col-md-5">
          <div class="card">
            <div class="card-header">Our Memberships</div>
             <div class="card-body">
               <div>
                 <form action="<%= jkfView.RegisterJspUrl %>" method="post">
                   <%Memberships CurrentMembership = null ;
                   List AllMemberships  = GetMemberships.GetAllMembershipsList(null, true); 
                   Iterator it=AllMemberships.iterator();
                   while(it.hasNext()){
                   CurrentMembership = (Memberships)it.next();%>
                   <div class="col-md-8">
                     <h2><%=CurrentMembership.getName() %></h2>
                     <p><%=CurrentMembership.getDescr()%> for <%=Double.valueOf(CurrentMembership.getPrice())%> Euro per Month</p>
                     <button type="submit" class="btn btn-primary" name="buttonValue" >Choose</button>  
                        
                   </div> <br><br> 
                 <%  }%>
                </form>
              </div> 
             <%@ include file="jsp/SuccessWarning.jsp"%> 
            </div>
	      </div>
        </div>
      </div>
    </div>
</body>
<%@ include file="jsp/footer.jsp"%>
</html>