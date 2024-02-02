package com.pms.Backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pms.Backend.model.AcceptedProjectRequests;

public interface acceptedPrRepo extends JpaRepository<AcceptedProjectRequests,Long>{

	AcceptedProjectRequests findByStudentid(long studentid);

	List<AcceptedProjectRequests> findAllByUser_Id(long teacherid);

	
}
