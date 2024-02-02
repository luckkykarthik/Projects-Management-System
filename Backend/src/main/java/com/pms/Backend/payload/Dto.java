package com.pms.Backend.payload;

public class Dto {
	long id;
	long studentid;
	String studentname;
	String title;
	String description;
	String aod;
	public Dto() {
		super();
	}
	public Dto(long id, long studentid, String studentname, String title, String description, String aod) {
		super();
		this.id = id;
		this.studentid = studentid;
		this.studentname = studentname;
		this.title = title;
		this.description = description;
		this.aod = aod;
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
	@Override
	public String toString() {
		return "Dto [id=" + id + ", studentid=" + studentid + ", studentname=" + studentname + ", title=" + title
				+ ", description=" + description + ", aod=" + aod + "]";
	}
	 
}
