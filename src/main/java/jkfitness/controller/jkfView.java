package jkfitness.controller;

public interface jkfView {
	
	public String APP_CONTEXT = "/JKFitness" ;
	public String PAGE_FOLDER = "/jsp" ;

	public String LoginJspUrl =  APP_CONTEXT  + "/login.jsp";
	public String HomeJspUrl =  APP_CONTEXT  + "/index.jsp";
	public String RegisterJspUrl =  APP_CONTEXT  + "/register.jsp";
	public String AboutJspUrl =  APP_CONTEXT  + "/about.jsp";
	public String ViewMembershipsJspUrl =  APP_CONTEXT  + "/ViewMemberships.jsp";
	
	public String RegisterSrvltUrl = APP_CONTEXT + "/RegisterSrvlt";
	public String LoginrSrvltUrl = APP_CONTEXT + "/LoginSrvlt";
	
	public String RegisterJspUrlForServlet = "register.jsp";
	public String LoginJspUrlForServlet = "login.jsp";
	 
    public String AdminViewJspUrlForServlet = "AdminView.jsp";
    public String ClientViewJspUrlForServlet = "ClientView.jsp";
    
    public String  ClientViewSrvltUrl= APP_CONTEXT + "/ClientViewSrvlt";
    
    public String ClientViewCredentialsJspUrlForServlet = "ClientViewCredentials.jsp";
    public String ClientViewCredentialsSrvltUrl = APP_CONTEXT + "/ClientViewCredentialsSrvlt";
    
    public String ClientViewMembershipJspUrlForServlet = "ClientViewMembership.jsp";
    public String ClientViewMembershipSrvltUrl = APP_CONTEXT + "/ClientViewMembershipSrvlt";
	
    public String ClientViewBillJspUrlForServlet = "ClientViewBills.jsp";
    public String ClientViewBillSrvltUrl = APP_CONTEXT + "/ClientViewBillSrvlt";
    
    public String AdminViewClientsJspUrlForServlet = "AdminViewClients.jsp";
    public String AdminViewClientsSrvlt = APP_CONTEXT + "/AdminViewClients"; 
    
    public String AdminViewMembershipsJspUrlForServlet = "AdminViewMemberships.jsp";
    public String AdminViewMembershipsSrvltUrl = APP_CONTEXT + "/AdminViewMembershipsSrvlt";
    
}
