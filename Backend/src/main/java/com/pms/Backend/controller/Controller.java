package com.pms.Backend.controller;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Backend.SecurityConfig.JwtTokenGenerator;
import com.pms.Backend.payload.JwtAuthResponse;
import com.pms.Backend.payload.UserDto;
import com.pms.Backend.payload.loginDto;
import com.pms.Backend.service.userService;


@RestController
@RequestMapping("")
public class Controller {

	@Autowired
	private userService UserService;
	
	@Autowired
	private JwtTokenGenerator jwtT;
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@PostMapping("/create")
	public ResponseEntity<UserDto> CreateUser(@RequestBody UserDto userdto){
		return new ResponseEntity<>(UserService.createUser(userdto),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/users")
	public ResponseEntity<List<UserDto>> getuser(){
		return new ResponseEntity<>(UserService.getAllUsers(),HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<UserDto> updatePassword(@PathVariable long id,@RequestBody UserDto userdto){
		return new ResponseEntity<>(UserService.UpdatePassword(id,userdto),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/teachers")
	public ResponseEntity<List<UserDto>> getAllTeachers(){
		return new ResponseEntity<>(UserService.getAllTeachers(),HttpStatus.OK);
	}
	
	@PreAuthorize("hasAnyAuthority('admin','teacher')")
	@GetMapping("/students")
	public ResponseEntity<List<UserDto>> getAllStudents(){
		return new ResponseEntity<>(UserService.getAllStudents(),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> loginuser(@RequestBody loginDto logindto){
		try {
			System.out.println(logindto.getEmail());
			System.out.println(logindto.getPassword());
			Authentication authentication=authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(logindto.getEmail(),logindto.getPassword())
					);
			System.out.println(authentication);
			SecurityContextHolder.getContext().setAuthentication(authentication);
			String token=jwtT.generateToken(authentication);
			Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
			Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
			String firstAuthorityName = null;
			if (iterator.hasNext()) {
			    GrantedAuthority firstAuthority = iterator.next();
			    firstAuthorityName = firstAuthority.getAuthority();
			}
			System.out.println(firstAuthorityName);
			JwtAuthResponse response = new JwtAuthResponse(token,firstAuthorityName);
			System.out.println(response);
			return ResponseEntity.ok(response);
//			return new ResponseEntity<>(response,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}
	@GetMapping("/profile")				
	public ResponseEntity<UserDto> getProfile(Authentication authentication){
		String username = authentication.getName();
        UserDto userProfile = UserService.getUserByUsername(username);
        if (userProfile != null) {
            return ResponseEntity.ok(userProfile);
        } else {
            return ResponseEntity.notFound().build();
        }
	}
}
