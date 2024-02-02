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
public class AcceptedProjectRequests {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	@Column(nullable=false)
	long studentid;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="facultyid")
	Users user;
	
	@Column(nullable=false)
	String studentname;
	@Column(nullable=false)
	String title;	
	@Column(nullable=false)
	String description;
	@Column(nullable=false)
	String aod;
	String githublink;
	boolean submitted;
	public AcceptedProjectRequests() {
		super();
	}
	public AcceptedProjectRequests(long id, long studentid, Users user, String studentname, String title,
			String description, String aod, String githublink, boolean submitted) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.user = user;
		this.studentname = studentname;
		this.title = title;
		this.description = description;
		this.aod = aod;
		this.githublink = githublink;
		this.submitted = submitted;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getStudentid() {
		return studentid;
	}
	public void setStudentid(long studentid) {
		this.studentid = studentid;
	}
	public Users getUser() {
		return user;
	}
	public void setUser(Users user) {
		this.user = user;
	}
	public String getStudentname() {
		return studentname;
	}
	public void setStudentname(String studentname) {
		this.studentname = studentname;
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
	public String getGithublink() {
		return githublink;
	}
	public void setGithublink(String githublink) {
		this.githublink = githublink;
	}
	public boolean isSubmitted() {
		return submitted;
	}
	public void setSubmitted(boolean submitted) {
		this.submitted = submitted;
	}
	@Override
	public String toString() {
		return "AcceptedProjectRequests [id=" + id + ", studentid=" + studentid + ", user=" + user + ", studentname="
				+ studentname + ", title=" + title + ", description=" + description + ", aod=" + aod + ", githublink="
				+ githublink + ", submitted=" + submitted + "]";
	}
	
}
