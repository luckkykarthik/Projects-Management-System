package com.pms.Backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.Backend.Exception.nullException;
import com.pms.Backend.payload.aprDto;
import com.pms.Backend.payload.prDto;
import com.pms.Backend.service.PrService;
import com.pms.Backend.service.acceptPrService;

@RestController
@RequestMapping("projectrequest")
public class PRController{
	
	@Autowired
	private PrService Prservice;
	
	@Autowired
	private acceptPrService acPrService;
	
	@PreAuthorize("hasAuthority('student')")
	@PostMapping
	public ResponseEntity<prDto> sendProjectRequest(@RequestBody prDto PrDto) {
		return new ResponseEntity<>(Prservice.createProjectRequest(PrDto),HttpStatus.CREATED);
	}
	
	@PreAuthorize("hasAuthority('teacher')")
	@PostMapping("/accept")
	public ResponseEntity<prDto> acceptProjectRequest(@RequestBody prDto PrDto) {
		return new ResponseEntity<>(acPrService.acceptProjectRequest(PrDto),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/checkaccept/{studentid}")
	public  ResponseEntity<aprDto> checkprojectacception(@PathVariable long studentid) {
		aprDto exists = acPrService.checkUser(studentid);
		if(exists==null) {
			throw new nullException("No data");
		}
		else {
			return ResponseEntity.ok(exists);
		}
	}
	
	@PreAuthorize("hasAuthority('admin')")
	@GetMapping("/{teacherid}")
	public ResponseEntity<List<prDto>> getAnyProjectTeacherRequests(@PathVariable long teacherid) {
		return new ResponseEntity<>(Prservice.getProjectRequest(teacherid),HttpStatus.OK);
	}
	@GetMapping("/check/{studentid}")
	public  ResponseEntity<Boolean> checkprojectdetails(@PathVariable long studentid) {
		boolean exists = Prservice.checkUser(studentid);
        return ResponseEntity.ok(exists);
	}
	@PreAuthorize("hasAuthority('teacher')")
	@GetMapping
	public ResponseEntity<List<prDto>> getProjectTeacherRequests(Authentication authentication) {
	    String username = authentication.getName();
	    List<prDto> gypr = Prservice.getYourProjectRequests(username);

	    if (gypr.isEmpty()) {
	        //throw new NoDataFoundException("No data available");
	    	 return ResponseEntity.noContent().build();
	    }

	    return new ResponseEntity<>(gypr, HttpStatus.OK);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProjectRequest(@PathVariable long id,Authentication authentication){
		String email = authentication.getName();
		Prservice.deleteRequest(email,id);
		return new ResponseEntity<>("Request deleted Successfully",HttpStatus.OK);
	}
	
}