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
	@Column(name = "IDAUTORIDADES")
	private Integer id; //Mudar para Long
	
	@Column(name = "username")
	private String username;
	
	@Column(name="authority", nullable = false)
	private String role;
		
	public Role() {
	}
	
	public Role(String username) {
		this.username = username;
		role = "ROLE_user";
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	

}
