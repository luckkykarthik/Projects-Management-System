package com.pms.Backend.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pms.Backend.model.Users;

public interface UserRepo extends JpaRepository<Users,Long>{
	
	Optional<Users> findByEmail(String email);
	
	List<Users> findAllByRole(String string);
	
	Users findByName(String faculty);


}
