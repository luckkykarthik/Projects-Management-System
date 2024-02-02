package com.pms.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.Backend.model.ProjectRequest;

public interface prRepo extends JpaRepository<ProjectRequest,Long>{

	List<ProjectRequest> findAllByUser_Id(long teacherid);
	
	ProjectRequest findByStudentid(long studentid);
}
