package br.com.academic.communication.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	@Column(name = "id")
	private Long id; 

	
	@Column(name = "username", nullable = false)
	private String username;
	@Column(name="authority", nullable = false)
	private String role;
	@Column(name="created_at")
	private LocalDateTime createdAt;
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	@OneToOne(cascade = CascadeType.ALL)
	private User user;
		
	public Role() {
		role = "user";
	}

	public Role(String username, String role, LocalDateTime createdAt, LocalDateTime updatedAt, User user) {
		super();
		this.username = user.getUsername();
		this.role = "user";
		this.user = user;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}

}
