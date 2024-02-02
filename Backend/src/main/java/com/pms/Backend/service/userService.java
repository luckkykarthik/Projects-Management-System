package com.pms.Backend.service;

import java.util.List;

import com.pms.Backend.payload.UserDto;

public interface userService {
    public UserDto createUser(UserDto userDto);
    
    public UserDto UpdatePassword(long id,UserDto userDto);
    
    public List<UserDto> getAllUsers();
    
    public List<UserDto> getAllTeachers();
    
    public List<UserDto> getAllStudents();
    
	public UserDto getUserByUsername(String username);
}
