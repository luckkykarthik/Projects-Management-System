package com.pms.Backend.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pms.Backend.Exception.UserNotFoundException;
import com.pms.Backend.model.Users;
import com.pms.Backend.repositories.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	private UserRepo userrepo;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Users user=userrepo.findByEmail(email).orElseThrow(
				() -> new UserNotFoundException(String.format("User with Email: %s not found", email)) 
				);
		Set<String> roles=new HashSet<String>();
		roles.add(user.getRole());
		return new User(user.getEmail(),user.getPassword(),userAuthorities(roles));
	}
	private Collection<? extends GrantedAuthority> userAuthorities(Set<String> roles){
		return roles.stream().map(
				role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
	}
} 
