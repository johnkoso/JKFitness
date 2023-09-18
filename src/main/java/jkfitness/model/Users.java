package jkfitness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
 
 
@Entity  
@Table(name= "USERS") 
public class Users {
	
	public Users(){
 
	}
	public Users(String wUserPk, String wUsername,String wPassword,String wAdminInd,String wClientPk){
		
		this.UserPk   = Integer.valueOf(wUserPk )  ;
		this.Username = wUsername ;
		this.Password = wPassword ;
		this.AdminInd = wAdminInd ;
		this.ClientPk = Integer.valueOf(wClientPk) ;
		 
	}
	@Id
	@Column(name = "USER_PK", unique = true, nullable = false)
	@SequenceGenerator(name = "users_sq", sequenceName = "USERS_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sq")
	private int UserPk;
	public int getUserPk() {
		return UserPk;
	}
 
	public void setUserPk(int wUserPk) {
		this.UserPk = wUserPk;
	}
 
	@Column(name = "USERNAME")
	private String Username;
	public String getUsername() {
		return Username;
	}
 
	public void setUsername(String wUsername) {
		this.Username = wUsername;
	}
 
	@Column(name = "PASSWORD")
	private String Password;
	public String getPassword() {
		return Password;
	}
 
	public void setPassword(String wPassword) {
		this.Password = wPassword;
	}
 
	@Column(name = "ADMIN_IND")
	private String AdminInd;
	public String getAdminInd() {
		return AdminInd;
	}
 
	public void setAdminInd(String wAdminInd) {
		this.AdminInd = wAdminInd;
	}
	@Column(name = "CLIENT_PK")
	private int ClientPk;
	public int getClientPk() {
		return ClientPk;
	}
 
	public void setClientPk(int wClientPk) {
		this.ClientPk = wClientPk;
	}
}