package com.pms.Backend.payload;

public class aprDto {
	long id;
	long studentid;	
	String studentname;
	String title;	
	String description;	
	String aod;
	String githublink;
	long facultyid;
	String facultyname;
	public long getFacultyid() {
		return facultyid;
	}
	public void setFacultyid(long facultyid) {
		this.facultyid = facultyid;
	}
	public String getFacultyname() {
		return facultyname;
	}
	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}
	boolean submitted;
	public aprDto() {
		super();
	}
	public aprDto(long id, long studentid, String studentname, String title, String description, String aod,
			String githublink, long facultyid, String facultyname, boolean submitted) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.studentname = studentname;
		this.title = title;
		this.description = description;
		this.aod = aod;
		this.githublink = githublink;
		this.facultyid = facultyid;
		this.facultyname = facultyname;
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
}
