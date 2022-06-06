package br.com.academic.communication.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "relations_schools")
public class RelationsSchool {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY	)
	@Column(name = "id")
	private Long id; 

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "follower_id")
	private People people;
	
	@OneToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "following_id")
	private School school;
	
	@Column(name="created_at")
	private LocalDateTime createdAt;
	@Column(name="updated_at")
	private LocalDateTime updatedAt;
	
	public RelationsSchool() {
	}

	public RelationsSchool(People people, School school, LocalDateTime createdAt, LocalDateTime updatedAt) {
		this.people = people;
		this.school = school;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public People getPeople() {
		return people;
	}

	public void setPeople(People people) {
		this.people = people;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
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
