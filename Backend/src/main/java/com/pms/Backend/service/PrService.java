package com.pms.Backend.service;

import java.util.List;

import com.pms.Backend.payload.prDto;

public interface PrService {

	public prDto createProjectRequest(prDto prDto);

	public List<prDto> getProjectRequest(long teacherid);

	public List<prDto> getYourProjectRequests(String username);
	
	public boolean checkUser(long studentid);
	
	public void deleteRequest(String email,long id);
	
	void deleteRequestByStudentId(long studentId);
	
}
