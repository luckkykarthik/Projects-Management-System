package com.pms.Backend.payload;
public class UserDto {
	public String id;
	public String name;
	public String gender;
	public String department;
	public String role;
	public String email;
	public String password;
	public long phone;
    public UserDto() {
    }
    public UserDto(String id, String name, String gender, String department, String role, String email, String password,
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
    public String getId() {
        return id;
    }
    public void setId(String id) {
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
    
}
