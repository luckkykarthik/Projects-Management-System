package com.pms.Backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="users",uniqueConstraints = { @UniqueConstraint(columnNames = {"email"})})
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	@Column(nullable=false)
	public String name;
	@Column(nullable=false)
	public String gender;
	@Column(nullable=false)
	public String department;
	@Column(nullable=false)
	public String role;
	@Column(nullable=false)
	public String email;
	@Column(nullable=false)
	public String password;
	@Column(nullable=false)
	public long phone;
	public Users() {
	}
	public Users(long id, String name, String gender, String department, String role, String email, String password,
			long phone) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.department = department;
		this.role = role;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", gender=" + gender + ", department=" + department + ", role="
				+ role + ", email=" + email + ", password=" + password + ", phone=" + phone + "]";
	}
	
}
