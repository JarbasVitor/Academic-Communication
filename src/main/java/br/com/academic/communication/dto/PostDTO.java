package br.com.academic.communication.dto;

import java.time.LocalDateTime;
import java.util.List;

import br.com.academic.communication.models.People;
import br.com.academic.communication.models.Post;
import br.com.academic.communication.models.School;

public class PostDTO {

	private String title;
	private String description;
	
	private LocalDateTime createdAt;
	
	private String name;
	private String lastName;
	private String profession;
	
	private String school;

	public PostDTO() {
	}

	public PostDTO(String title, String description, LocalDateTime createdAt, String name, String lastName,
			String profession, String school) {
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.name = name;
		this.lastName = lastName;
		this.profession = profession;
		this.school = school;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Override
	public String toString() {
		return "PostDTO [title=" + title + ", description=" + description + ", createdAt=" + createdAt + ", name="
				+ name + ", lastName=" + lastName + ", profession=" + profession + ", school=" + school + "]";
	}



	public void toPostDTO(Post tempPost, People people, School school) {
		this.name = people.getName();
		this.lastName = people.getLast_name();
		this.profession = people.getProfession();
		
		this.school = school.getSchool();
		
		this.title = tempPost.getTitle();
		this.description = tempPost.getDescription();
		this.createdAt = tempPost.getCreatedAt();
	
	}
	
	
	public void FormatDate(LocalDateTime localdatetime) {
		
	}
		
	
}
