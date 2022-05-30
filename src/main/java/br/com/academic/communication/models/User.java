package br.com.academic.communication.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="iduser")
	private Long id;
	
	@Column(name="username", nullable = false, unique = true)
	private String username;
	@Column(name="password", nullable = false)
	private String password;
	@Column(name="enabled", nullable = false)
	private boolean enabled;
	
	public User() {}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.enabled = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
