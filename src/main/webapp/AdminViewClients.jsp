<%@page import="jkfitness.dbfunctions.GetClients"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
 <%@page import="jkfitness.utility.*"%>
<%@page import="jkfitness.controller.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page  import="jkfitness.model.*"%>
<!DOCTYPE html>
<html>
<head>
<title>View All Clients</title>
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
          <div class="card-header">
          JKFitness Clients
          </div>
          <div class="card-body">
            <form action="<%= jkfView.AdminViewClientsSrvlt %>" method="post">
              <div class AllClients>
                <table class="table table-striped">
                <thead>
                <tr>
                  <th scope="col">ID</th>
                  <th scope="col">Name</th>
                  <th scope="col">Surname</th>
                  <th scope="col">Email</th>
                  <th scope="col">Phone</th>
                  <th scope="col">Street Address</th>
                  <th scope="col">Post Code</th>
                  <th scope="col">Options</th>
                </tr>
                </thead>
                <%
                Clients CurrentClient = new Clients();
                List AllClientsList = GetClients.GetAllClientsList(null, true);
                if (AllClientsList == null)
                {%>
                <%} %>
                <% if (AllClientsList != null)
                {
                Iterator it=AllClientsList.iterator();
                while(it.hasNext()){
                CurrentClient = (Clients)it.next();%>
                <tbody>
                <tr>
                  <th scope="row"><%=CurrentClient.getClientPk() %></th>
                  <td><%=CurrentClient.getName() %></td>
                  <td><%=CurrentClient.getSurname() %></td>
                  <td><%=CurrentClient.getEmail() %></td>
                  <td><%=CurrentClient.getPhoneNumber()%></td>
                  <td><%=CurrentClient.getStreetAddress() %></td>
                  <td><%=CurrentClient.getPostCode()%></td>
                  <td><button type="submit" class="btn btn-primary btn-remove"
                   name="buttonValue" value="<%=CurrentClient.getClientPk()%>">Remove</button> </td>
                </tr>
                <%  }%>
                </tbody>
                </table>           
              </div>       
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