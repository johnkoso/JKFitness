<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="jkfitness.dbfunctions.GetBills"%>
<%@page import="jkfitness.utility.*"%>
<%@page import="jkfitness.controller.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page  import="jkfitness.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View / Pay Your Bills</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <%@ include file="jsp/headerClient.jsp"%>
</head>
<body>
  <div> <br> </div>
  <div class="cotainer">
    <div class="row justify-content-center">
      <div class="col-md-8">
        <div class="card">
          <div class="card-header">Pay your Membership </div>
            <div class="card-body">
              <div>
                <table class="table table-striped">
                  <thead>
                    <tr>
                      <th scope="col">Bill ID</th>
                      <th scope="col">Bill Issue Date</th>
                      <th scope="col">Bill Expiration Date</th>
                      <th scope="col">Membership Type</th>
                      <th scope="col">Total Amount</th>
                    </tr>
                  </thead>
                <%
                Bills CurrentBill ;
                String ClientPk = session.getAttribute("CurrentClientPk").toString();
                CurrentBill = GetBills.GetBillByClientPk(ClientPk, null, true);
                if (CurrentBill == null)
                {%>
                  <tbody>
                    <tr>
                      <td></td>
                      <td></td>
                      <td colspan="3"> You do not have any unpaid bills</td>
                    </tr>
                  </tbody>
                </table>    
                </div>        
                <%} %>
                <% if (CurrentBill != null)
                {%>
                <tbody>
                  <tr>
                    <th scope="row"><%=CurrentBill.getBillPk() %></th>
                    <td><%=DataUtility.getDateString(CurrentBill.getIssueDate()) %></td>
                    <td><%=DataUtility.getDateString(CurrentBill.getExpDate()) %></td>
                    <td><%=CurrentBill.getDescr() %></td>
                    <td><%=String.valueOf(CurrentBill.getAmount())%> Euro</td>
                  </tr>
                </tbody>
                </table>           
            </div>  
              <form  name="PayForm" action="<%= jkfView.ClientViewBillSrvltUrl %>" method="post">

               <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right"><font color="red"></font></label>
                <div class="col-md-6">
                  <div class="icon-container">
                  <i class="fa fa-cc-visa" style="color:navy;"></i>
                  <i class="fa fa-cc-amex" style="color:blue;"></i>
                  <i class="fa fa-cc-mastercard" style="color:red;"></i>
                  <i class="fa fa-cc-discover" style="color:orange;"></i>
                 </div>
                </div>
            </div>
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Credit Card Number<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"   class="form-control" placeholder="Enter the number of your card Ex. 1111-2222-3333-4444"
                    name="CreditCardNumber" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Name On The Card<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text"   class="form-control" placeholder="Enter the name on your card Ex. GEORGE WASHINGTON "
                    name="NameOnTheCard" value="" >
                    <font  color="red"></font>
                </div>
              </div>
            
              <div class="form-group row">
                <label for="email_address" 
                  class="col-md-4 col-form-label text-md-right">Expiration Date<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="Email"  class="form-control" placeholder="Enter the expiration date of your card Ex. 02/23"
                    name="ExpirationDate" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              
              
              <div class="form-group row">
                <label for="password" 
                  class="col-md-4 col-form-label text-md-right">CVV<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="password" id="email_address"  class="form-control" placeholder="Enter the CVV of your card Ex. 234"
                    name="CVV" value="" >
                    <font  color="red"></font>
                </div>
              </div>
              <div class="form-group row">
                <label for="email" 
                  class="col-md-4 col-form-label text-md-right">Amount<font color="red"></font></label>
                <div class="col-md-6">
                  <input type="text" id="email_address"  class="form-control" placeholder=""
                    name="Amount" value="<%=String.valueOf(CurrentBill.getAmount()) %>" >
                    <font  color="red"></font>
                </div>
              </div>
            
              <div class="col-md-6 offset-md-4">
                <input type="submit" class="btn btn-primary"  name="operation" value="Pay">
                
              </div> 
            </form>          			
          <%  }%>
        </div>
      <%@ include file="jsp/SuccessWarning.jsp"%>
      </div>
    </div>
  </div>
</body>
<%@ include file="jsp/footer.jsp"%>
</html>