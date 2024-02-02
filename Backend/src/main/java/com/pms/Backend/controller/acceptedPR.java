package com.pms.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Backend.payload.UserDto;
import com.pms.Backend.payload.aprDto;
import com.pms.Backend.payload.prDto;
import com.pms.Backend.service.acceptPrService;

@RestController
@RequestMapping("/apr")
public class acceptedPR {

	@Autowired
	private acceptPrService apService;
	
	@GetMapping
	public ResponseEntity<List<prDto>> getAcceptedProjectTeacherRequests(Authentication authentication) {
		String username = authentication.getName();
	    List<prDto> gypr = apService.getAcceptedProjects(username);

	    if (gypr.isEmpty()) {
	        //throw new NoDataFoundException("No data available");
	    	 return ResponseEntity.noContent().build();
	    }

	    return new ResponseEntity<>(gypr, HttpStatus.OK);
	
	}
	
	@PutMapping("/update")
	public ResponseEntity<aprDto> updatePassword(@RequestBody aprDto AprDto){
		return new ResponseEntity<>(apService.updateGithublink(AprDto),HttpStatus.OK);
	}
}
