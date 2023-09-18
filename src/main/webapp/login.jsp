<%@page import="jkfitness.utility.ServletUtility"%>
<%@page import="jkfitness.controller.RegisterSrvlt"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
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
      <div class="col-md-4">
        <div class="card">
          <div class="card-header">Login </div>
            <div class="card-body">
	         <form action="<%= jkfView.LoginrSrvltUrl %>" method="post">
	
	              <div class="form-group row">
	                <label for="email_address" 
	                  class="col-md-4 col-form-label text-md-right">Email<font color="red">*</font></label>
	                <div class="col-md-6">
	                  <input type="text" id="login"  class="form-control" placeholder="Enter Email"
	                    name="Email" value="" >
	                    <font  color="red"></font>
	                </div>
	              </div>
	              <div class="form-group row">
	                <label for="password"
	                  class="col-md-4 col-form-label text-md-right">Password<font color="red">*</font></label>
	                <div class="col-md-6">
	                  <input type="password" id="password" class="form-control" placeholder="Enter Password"
	                    name="Password" value="" >
	                    <font color="red"> </font>
	                </div>
	              </div>
             <div class="form-group row">
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary" name="operation" value="Login"></div>
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
