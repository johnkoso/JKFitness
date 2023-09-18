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
  <title>Choose Your Membership</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <%@ include file="jsp/headerClient.jsp"%>
</head>
<body>
  <div> <br> </div>
    <div class="cotainer">
      <div class="row justify-content-center">
         <div class="col-md-5">
           <div class="card">
             <div class="card-header"> Choose Your Membership</div>
               <div class="card-body">
                   <form action="<%= jkfView.ClientViewMembershipSrvltUrl %>" method="post">
                     <%
                     Memberships CurrentMembership = null ;
                     String ClientPk = session.getAttribute("CurrentClientPk").toString();
                     CurrentMembership = GetMemberships.GetCurrentMembershipbyClientPk(ClientPk, null, true);
                     if (CurrentMembership != null)
                       {%>
                          <div class="col-md-13">
                             <h2>Your Active Membership is:<font color="#E43030"> <%=CurrentMembership.getName() %> </font> </h2><br>
                             <p><%=CurrentMembership.getDescr()%> for <%=Double.valueOf(CurrentMembership.getPrice())%> Euro per Month.</p>
                             <p>If you have any problem feel free to contact us.</p>     
                          </div>   
                         
                     <%} %>
                     <% if (CurrentMembership == null)
                     {
                     List AllMemberships  = GetMemberships.GetAllMembershipsList(null, true); 
                     Iterator it=AllMemberships.iterator();
                     while(it.hasNext())
                        {
                    	 CurrentMembership = (Memberships)it.next();%>
                    	 <div class="col-md-8">
                    	   <h2><%=CurrentMembership.getName() %></h2>
                    	   <p><%=CurrentMembership.getDescr()%> for <%=Double.valueOf(CurrentMembership.getPrice())%> Euro per Month</p>
                    	   <button type="submit" class="btn btn-primary" value="<%=CurrentMembership.getMembershipPk()%>" name="buttonValue" >Choose</button>      
                    	 </div> <br><br> 
                     <%  }%>
                     <%  }%>
                   </form>
                 </div> 
              <%@ include file="jsp/SuccessWarning.jsp"%> 
             </div>
              
           </div>
         </div>
      </div>
</body>
<%@ include file="jsp/footer.jsp"%>
</html>