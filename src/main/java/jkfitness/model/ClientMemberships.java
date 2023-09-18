package jkfitness.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity  
@Table(name= "CLIENT_MEMBERSHIPS") 

public class ClientMemberships {
	
	@Id
	@Column(name = "CLIENT_MEMBERSHIP_PK", unique = true, nullable = false)
	@SequenceGenerator(name = "clientmemberships_sq", sequenceName = "CLIENT_MEMBERSHIPS_SQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientmemberships_sq")
	
	private int ClientMembershipPk ;
	
	public int getClientMembershipPk() {
		return ClientMembershipPk;
	}
	public void setClientMembershipPk(int clientMembershipPk) {
		ClientMembershipPk = clientMembershipPk;
	}
	@Column(name = "MEMBERSHIP_PK")
	
	private int MembershipPk         ;
	
	public int getMembershipPk() {
		return MembershipPk;
	}
	public void setMembershipPk(int membershipPk) {
		MembershipPk = membershipPk;
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
