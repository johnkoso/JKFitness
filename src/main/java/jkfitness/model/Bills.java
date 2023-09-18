package jkfitness.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity  
@Table(name= "BILLS") 

public class Bills {
	
	@Id
	@Column(name = "BILL_PK", unique = true, nullable = false)
	@SequenceGenerator(name = "bills_sq", sequenceName = "BILLS_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bills_sq")
	
	private int BillPk       ;
	
	public int getBillPk() {
		return BillPk;
	}
	public void setBillPk(int billPk) {
		BillPk = billPk;
	}
	
	@Column(name = "DESCR")
	
	private String Descr     ;
	
	public String getDescr() {
		return Descr;
	}
	public void setDescr(String descr) {
		Descr = descr;
	}
	
	@Column(name = "AMOUNT")
	
	private double Amount   ;
	
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	
	@Column(name = "ISSUE_DATE")
	
	private Date IssueDate;
	public Date getIssueDate() {
		return IssueDate;
	}
	public void setIssueDate(Date issueDate) {
		IssueDate = issueDate;
	}
	@Column(name = "EXP_DATE")
	private Date ExpDate;
	public Date getExpDate() {
		return ExpDate;
	}
	public void setExpDate(Date expDate) {
		ExpDate = expDate;
	}	
	
	@Column(name = "CLIENT_PK")
	
	private int ClientPk        ;
	
	public int getClientPk() {
		return ClientPk;
	}
	public void setClientPk(int clientPk) {
		ClientPk = clientPk;
	}
   
   

}