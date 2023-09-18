package jkfitness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 
@Entity  
@Table(name= "CLIENTS") 
public class Clients {

	public Clients(){
 
	}

	@Id
	@Column(name = "CLIENT_PK", unique = true, nullable = false)
	@SequenceGenerator(name = "clients_sq", sequenceName = "CLIENTS_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clients_sq")
	
	private int    ClientPk     ;
	
	
	public int getClientPk() {
		return ClientPk;
	}
 
	public void setClientPk(int wClientPk) {
		this.ClientPk = wClientPk;
	}
 
	@Column(name = "NAME")
	
	private String Name         ; 
	
	public String getName() {
		return Name;
	}
	public void setName(String wName) {
		this.Name = wName;
	}
 
	@Column(name = "SURNAME")
	
	private String Surname      ; 
	
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String wSurname) {
		this.Surname = wSurname;
	}
	
	@Column(name = "STREET_ADDRESS")
	
	private String StreetAddress;
	
	public String getStreetAddress() {
		return StreetAddress;
	}
	public void setStreetAddress(String wStreetAddress) {
		this.StreetAddress = wStreetAddress;
	}
    
   @Column(name = "POST_CODE")
   
    private String PostCode     ;
   
    public String getPostCode() {
		return PostCode;
	}
	public void setPostCode(String wPostCode) {
		this.PostCode = wPostCode;
	}	
	
	@Column(name = "EMAIL")
	
	private String Email        ; 
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String wEmail) {
		this.Email = wEmail;
	}	
	
	@Column(name = "PHONE_NUMBER")
	
	private String PhoneNumber  ;
	
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String wPhoneNumber) {
		this.PhoneNumber = wPhoneNumber;
	}	
}