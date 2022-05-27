package br.com.academic.communication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	@Column(name = "idauthorities")
	private Long id; 
	
	@Column(name = "username")
	private String username;
	
	@Column(name="authority", nullable = false)
	private String role;
		
	public Role() {
		role = "ROLE_user";
	}
	
	public Role(String username) {
		this.username = username;
		role = "ROLE_user";
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	

}
