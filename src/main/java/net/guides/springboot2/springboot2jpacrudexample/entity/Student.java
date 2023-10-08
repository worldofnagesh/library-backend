package net.guides.springboot2.springboot2jpacrudexample.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {
	private long id;
	private String fullName;
	private String emailId;
	private String dob;
	private String gender;
	private String state;
	private String password;
	
	public Student() {
	}
	
	public Student(long id, String fullName, String emailId, String dob, String gender, String state, String password) {
		this.id = id;
		this.fullName = fullName;
		this.emailId = emailId;
		this.dob = dob;
		this.gender = gender;
		this.state = state;
		this.password = password;
	}
    @Id
    @Column(unique=true, name = "id", nullable = false)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Column(name = "fullName", nullable = false)
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "emailId", nullable = false)
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
    
	@Column(name = "dob", nullable = false)
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}

	@Column(name = "gender", nullable = false)
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "state", nullable = false)
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "StudentDTO [id=" + id + ", fullName=" + fullName + ", emailId=" + emailId + ", dob=" + dob + ", gender="
				+ gender + ", state=" + state + ", password=" + password + "]";
	}
	
	
	
	
}
