package com.pms.Backend.service;

import java.util.List;

import com.pms.Backend.payload.UserDto;
import com.pms.Backend.payload.aprDto;
import com.pms.Backend.payload.prDto;

public interface acceptPrService {
	
	public prDto acceptProjectRequest(prDto PrDto);
	
	public aprDto checkUser(long studentid);
	
	public List<prDto> getAcceptedProjects(String username);
	
	public aprDto updateGithublink(aprDto AprDto);

}
