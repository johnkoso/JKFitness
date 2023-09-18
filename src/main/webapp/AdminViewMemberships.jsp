<%@page import="jkfitness.dbfunctions.GetMemberships"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="jkfitness.utility.*"%>
<%@page import="jkfitness.controller.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page  import="jkfitness.model.*"%>
<!DOCTYPE html>
<html>
<head>
<title>View / Add Membership</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <%@ include file="jsp/headerAdmin.jsp"%>
</head>
<body>
<div> <br> </div>
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">JKFitness Memberships</div>
            <div class="card-body">
              <div class=AllMemberships>
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">ID</th>
                      <th scope="col">Name</th>
                      <th scope="col">Description</th>
                      <th scope="col">Price</th>
                    </tr>
                  </thead>
                  <%
                  Memberships CurrentMembership = new Memberships();
                  List AllMemberships  = GetMemberships.GetAllMembershipsList(null, true); 
                  if (AllMemberships == null)
                  {%>
                  <%} %>
                  <% if (AllMemberships != null)
                  {
                  Iterator it=AllMemberships.iterator();
                  while(it.hasNext()){
                  CurrentMembership = (Memberships)it.next();%>
                  <tbody>
                    <tr>
                      <th scope="row"><%=CurrentMembership.getMembershipPk() %></th>
                      <td><%=CurrentMembership.getName() %></td>
                      <td><%=CurrentMembership.getDescr() %></td>
                      <td><%=CurrentMembership.getPrice() %></td>
                    </tr> 
                  <%  }%>
                  </tbody>
                </table>           
              <%  }%>
              </div>       
          </div>
        </div>
      </div>
    </div>
  </div>
  <br>
  <div class="cotainer">
     <div class="row justify-content-center">
       <div class="col-md-8">
         <div class="card">
           <div class="card-body">
            <form  name="AddMemebership" action="<%= jkfView.AdminViewMembershipsSrvltUrl %>" method="post">
             <div class="form-group row">
               <label for="email_address" 
                 class="col-md-4 col-form-label text-md-right">Membership Name<font color="red"></font></label>
               <div class="col-md-6">
                 <input type="text"   class="form-control" placeholder="Enter Membership Name"
                   name="MembershipName" value="" >
                   <font  color="red"></font>
               </div>
             </div>
             
             <div class="form-group row">
               <label for="email_address" 
                 class="col-md-4 col-form-label text-md-right">Membership Description<font color="red"></font></label>
               <div class="col-md-6">
                 <input type="text"  class="form-control" placeholder="Enter Membership Description"
                   name="MembershipDescr" value="" >
                   <font  color="red"></font>
               </div>
             </div>
           
             <div class="form-group row">
               <label for="email_address" 
                 class="col-md-4 col-form-label text-md-right">Number Of Months<font color="red"></font></label>
               <div class="col-md-6">
                 <input type="text"   class="form-control" placeholder="Enter Number Of Months"
                   name="MembershipNumOfMonths" value="" >
                   <font  color="red"></font>
               </div>
             </div>
             
             <div class="form-group row">
               <label for="password" 
                 class="col-md-4 col-form-label text-md-right">Price<font color="red"></font></label>
               <div class="col-md-6">
                 <input type="Text"  class="form-control" placeholder="Enter Price"
                   name="MembershipPrice" value="" >
                   <font  color="red"></font>
               </div>
             </div>
           
             <div class="col-md-6 offset-md-4">
               <input type="submit" class="btn btn-primary"  name="operation" value="Add Membership">
             </div>
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