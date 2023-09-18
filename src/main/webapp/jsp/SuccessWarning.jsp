<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="jkfitness.utility.ServletUtility"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/JKFitness/css/style.css"/>
<meta charset="ISO-8859-1">

</head>
<body>
   <% if (!ServletUtility.getSuccessMessage(request).isEmpty())
	 { %>
	  <div class="alert alert-success" role="alert">
      <%=ServletUtility.getSuccessMessage(request) %>
	 </div>
  <% }%>
  <% if(!ServletUtility.getErrorMessage(request).isEmpty())
     { %>
    <div class="alert alert-warning" role="alert">
     <%=ServletUtility.getErrorMessage(request) %>
	</div>
  <% }%>
</body>
</html>
