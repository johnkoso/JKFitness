<%@page import="jkfitness.utility.ServletUtility"%>
<%@page import="jkfitness.controller.RegisterSrvlt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
</head>
<body>
<%@ include file="jsp/header.jsp"%>
  <div> <br> </div>
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-6">
        <div class="card">
          <div class="card-header">Register and Get Started</div>
          <div class="card-body">
            <form action="<%= jkfView.RegisterSrvltUrl %>" method="post">

              <input type="hidden" name="uri" value=""> <input
                type="hidden" name="id" value=""> <input
                type="hidden" name="createdBy" value="">
              <input type="hidden" name="modifiedBy"
                value=""> <input type="hidden"
                name="createdDatetime"
                value="">
              <input type="hidden" name="modifiedDatetime"
                value="">

              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">First Name<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="text"   class="form-control" placeholder="Enter your First Name"
                    name="Name" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Surname<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="text"   class="form-control" placeholder="Enter your Surname"
                    name="Surname" value="" >
                    <font  color="red"></font>
                </div>
              </div>

              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Email<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="text" id="Email"  class="form-control" placeholder="Enter your Email"
                    name="Email" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              
              <div class="form-group row">
                <label for="password" 
                  class="col-md-4 col-form-label text-md-right">Password<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="password" id="email_address"  class="form-control" placeholder="Enter your Password"
                    name="Password" value="" >
                    <font  color="red"></font>
                </div>
              </div>

              <div class="form-group row">
                <label for="password" 
                  class="col-md-4 col-form-label text-md-right">Re-Enter Password<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="password" id="email_address"  class="form-control" placeholder="Re-Enter your Password"
                    name="retypePassword" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Street Address<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter your Street Address"
                    name="StreetAddress" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Post Code<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="text"  id="email_address" class="form-control" placeholder="Enter your Post Code"
                    name="PostCode" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Phone Number<font color="red">*</font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder="Enter your Phone Number"
                    name="PhoneNumber" value="" >
                    <font  color="red"></font>
                </div>
              </div>

              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Register">
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