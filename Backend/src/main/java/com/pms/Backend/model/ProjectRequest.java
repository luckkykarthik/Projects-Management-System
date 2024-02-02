package com.pms.Backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ProjectRequest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@Column(nullable=false)
	long studentid;
	@Column(nullable=false)
	String studentname;
	@Column(nullable=false)
	String title;	
	@Column(nullable=false)
	String description;
	@Column(nullable=false)
	String aod;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="faculty_id")
	Users user;
	public ProjectRequest() {
		super();
	}
	public ProjectRequest(long studentid, String name, String title, String description, String aod, Users user) {
		super();
		this.studentid = studentid;
		this.studentname = name;
		this.title = title;
		this.description = description;
		this.aod = aod;
		this.user = user;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	public String getName() {
		return studentname;
	}
	public void setName(String name) {
		this.studentname = name;
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
	public String getAod() {
		return aod;
	}
	public void setAod(String aod) {
		this.aod = aod;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "ProjectRequest [studentid=" + studentid + ", name=" + studentname + ", title=" + title + ", description="
				+ description + ", aod=" + aod + ", user=" + user + "]";
	}
	
}
