package jkfitness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
@Entity  
@Table(name= "MEMBERSHIPS") 
public class Memberships {
	@Id
	@Column(name = "MEMBERSHIP_PK", unique = true, nullable = false)
	@SequenceGenerator(name = "memberships_sq", sequenceName = "MEMBERSHIPS_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "memberships_sq")
	
	private int MembershipPk ;
	
	public int getMembershipPk() {
		return MembershipPk;
	}
	public void setMembershipPk(int membershipPk) {
		MembershipPk = membershipPk;
	}
	
	@Column(name = "NAME")
	
	private String Name         ;
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	@Column(name = "DESCR")
	
	private String Descr        ;
	
	public String getDescr() {
		return Descr;
	}
	public void setDescr(String descr) {
		Descr = descr;
	}
	
	@Column(name = "NUM_OF_MONTHS")
	
	private int NumOfMonths;
	
	public int getNumOfMonths() {
		return NumOfMonths;
	}
	public void setNumOfMonths(int numOfMonths) {
		NumOfMonths = numOfMonths;
	}

	@Column(name = "PRICE")
	
	private double Price        ;
	
	public double getPrice() {
		return Price;
	}
	public void setPrice(double price) {
		Price = price;
	}
}
