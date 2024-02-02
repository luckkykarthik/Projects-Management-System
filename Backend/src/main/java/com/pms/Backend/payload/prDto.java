package com.pms.Backend.payload;

public class prDto {
	long id;
	long studentid;
	String studentname;
	String title;
	String description;
	String aod;
	String faculty;
	public prDto() {
		super();
	}
	public prDto(long id, long studentid, String studentname, String title, String description, String aod,
			String faculty) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.studentname = studentname;
		this.title = title;
		this.description = description;
		this.aod = aod;
		this.faculty = faculty;
	}
	public long getId() {
		return id;
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
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	@Override
	public String toString(){
		return "prDto [id=" + id + ", studentid=" + studentid + ", studentname=" + studentname + ", title=" + title
				+ ", description=" + description + ", aod=" + aod + ", faculty=" + faculty + "]";
	}
	public String getFaculty() {
		return faculty;
	}
	public void setId(long id) {
		this.id = id;
	}	
}
