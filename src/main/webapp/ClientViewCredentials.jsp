<%@page import="jkfitness.utility.*"%>
<%@page import="jkfitness.controller.RegisterSrvlt"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page  import="jkfitness.model.Clients"%>
<%@page  import=" java.util.ArrayList"%>
<%@page  import="jkfitness.controller.*"%>
<%@page  import="jkfitness.dbfunctions.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<title>View / Edit Your Info</title>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <link rel="stylesheet" href="/css/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <%@ include file="jsp/headerClient.jsp"%>
</head>

<body>
  <% String CurrentClientPk = session.getAttribute("CurrentClientPk").toString();
  Clients CurrentClient = GetClients.GetCurrentClientByClientPk(CurrentClientPk, null, true);
  ArrayList CurrentClientList=new ArrayList();
  CurrentClientList.add(CurrentClient);
  Iterator it=CurrentClientList.iterator();
  while(it.hasNext()){
  CurrentClient = (Clients)it.next();
  %>
  <div> <br> </div>
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
          <div class="card">
              <div class="card-header">
              Edit Your Info
              </div>
            <div class="card-body">
			    <form action="<%= jkfView.ClientViewCredentialsSrvltUrl %>" method="post">
                <input type="hidden" name="uri" value="">
                 <input type="hidden" name="ClientPk" value="<%=CurrentClient.getClientPk() %>"> 
                 <input type="hidden" name="OldEmail" value="<%=CurrentClient.getEmail() %>">
                <input type="hidden" name="modifiedBy"
                  value=""> <input type="hidden"
                  name="createdDatetime"
                  value="">
                <input type="hidden" name="modifiedDatetime"
                  value="">
			    
                <div class="form-group row">
                  <label for="email_address" 
                    class="col-md-4 col-form-label text-md-right">First Name<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="text"   class="form-control" placeholder="Enter your First Name"
                      name="Name" value= "<%=CurrentClient.getName() %>">
                      <font  color="red"></font>
                  </div>
                </div>
                
                <div class="form-group row">
                  <label for="email_address" 
                    class="col-md-4 col-form-label text-md-right">Surname<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="text"   class="form-control" placeholder="Enter your Surname"
                      name="Surname" value="<%=CurrentClient.getSurname() %>" >
                      <font  color="red"></font>
                  </div>
                </div>
			    
                <div class="form-group row">
                  <label for="email_address" 
                    class="col-md-4 col-form-label text-md-right">Email<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="text" id="Email"  class="form-control" placeholder="Enter your Email"
                      name="Email" value="<%=CurrentClient.getEmail() %>" >
                      <font  color="red"></font>
                  </div>
                </div>
                
                <div class="form-group row">
                  <label for="password" 
                    class="col-md-4 col-form-label text-md-right">Old Password<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="password" id="email_address"  class="form-control" placeholder="Enter your Old Password"
                      name="OldPassword" value="" >
                      <font  color="red"></font>
                  </div>
                </div>
                
                <div class="form-group row">
                  <label for="password" 
                    class="col-md-4 col-form-label text-md-right">New Password<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="password" id="email_address"  class="form-control" placeholder="Enter your New Password"
                      name="NewPassword" value="" >
                      <font  color="red"></font>
                  </div>
                </div>
			    
                <div class="form-group row">
                  <label for="password" 
                    class="col-md-4 col-form-label text-md-right">Re-Enter New Password<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="password" id="email_address"  class="form-control" placeholder="Re-Enter your New Password"
                      name="retypeNewPassword" value="" >
                      <font  color="red"></font>
                  </div>
                </div>
                
                <div class="form-group row">
                  <label for="email_address" 
                    class="col-md-4 col-form-label text-md-right">Street Address<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="text" id="email_address"  class="form-control" placeholder="Enter your Street Address"
                      name="StreetAddress" value="<%=CurrentClient.getStreetAddress() %>" >
                      <font  color="red"></font>
                  </div>
                </div>
                <div class="form-group row">
                  <label for="email_address" 
                    class="col-md-4 col-form-label text-md-right">Post Code<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="text"  id="email_address" class="form-control" placeholder="Enter your Post Code"
                      name="PostCode" value="<%=CurrentClient.getPostCode() %>" >
                      <font  color="red"></font>
                  </div>
                </div>
                
                <div class="form-group row">
                  <label for="email_address" 
                    class="col-md-4 col-form-label text-md-right">Phone Number<font color="red"></font></label>
                  <div class="col-md-6">
                    <input type="text" id="email_address"  class="form-control" placeholder="Enter your Phone Number"
                      name="PhoneNumber" value="<%=CurrentClient.getPhoneNumber() %>" >
                      <font  color="red"></font>
                  </div>
                </div>
			    
                <div class="col-md-8 offset-md-4">
                  <input type="submit" class="btn btn-primary" name="operation" value="Update Credentials">
                  </div>
                <%} %> 
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