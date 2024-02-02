package com.pms.Backend.userServImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.pms.Backend.Exception.UserNotFoundException;
import com.pms.Backend.Exception.emailAlreadyExists;
import com.pms.Backend.model.Users;
import com.pms.Backend.payload.UserDto;
import com.pms.Backend.repositories.UserRepo;
import com.pms.Backend.service.userService;;

@Service
public class userServIm implements userService{

    @Autowired
    private UserRepo userRepo;
    
    @Autowired
	private ModelMapper modelMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDto createUser(UserDto userDto) {
    	try {
    		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
            Users user=modelMapper.map(userDto,Users.class);
            Users saveduser=userRepo.save(user);
            return modelMapper.map(saveduser,UserDto.class);
    	}
    	catch(Exception e) {
    		throw new emailAlreadyExists("Email already Exists");
    	}
    }

	@Override
	public UserDto UpdatePassword(long id, UserDto userDto) {
	    Users user = userRepo.findById(id).orElseThrow(
	            () -> new UserNotFoundException(String.format("User Id %s not found", id))
	    );
	    userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
	    user.setPassword(userDto.getPassword());
	    Users updatedUser = userRepo.save(user);
	    UserDto dto = modelMapper.map(updatedUser, UserDto.class);
	    return dto;
	}
	
	
	@Override
	public List<UserDto> getAllUsers() {
		List<Users> users=userRepo.findAll();
		return users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllTeachers() {
		List<Users> users=userRepo.findAllByRole("teacher");
		return users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<UserDto> getAllStudents() {
		List<Users> users=userRepo.findAllByRole("student");
		return users.stream().map(user -> modelMapper.map(user,UserDto.class)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUserByUsername(String email) {
		Users user =userRepo.findByEmail(email).orElseThrow(
				() -> new UserNotFoundException(String.format("User %s not found", email))
				);
		return modelMapper.map(user,UserDto.class);
	}




}
