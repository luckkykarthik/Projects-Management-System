package com.pms.Backend.userServImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.Backend.Exception.ProjectAlreadyAccepted;
import com.pms.Backend.Exception.UserNotFoundException;
import com.pms.Backend.model.AcceptedProjectRequests;
import com.pms.Backend.model.Users;
import com.pms.Backend.payload.UserDto;
import com.pms.Backend.payload.aprDto;
import com.pms.Backend.payload.prDto;
import com.pms.Backend.repositories.UserRepo;
import com.pms.Backend.repositories.acceptedPrRepo;
import com.pms.Backend.service.PrService;
import com.pms.Backend.service.acceptPrService;

@Service	
public class acceptPrReImp implements acceptPrService{

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    private acceptedPrRepo accRepo;
	
	@Autowired
	private PrService Prservice;
	
	@Override
	public prDto acceptProjectRequest(prDto PrDto) {
		Users user = userRepo.findByName(PrDto.getFaculty());
		boolean p = checkUser(PrDto.getStudentid())!=null;
		System.out.println(p);
	    if (!p) {
			AcceptedProjectRequests pr = new AcceptedProjectRequests();
			pr.setStudentid(PrDto.getStudentid());
		    pr.setStudentname(PrDto.getStudentname());
		    pr.setTitle(PrDto.getTitle());
		    pr.setDescription(PrDto.getDescription());
		    pr.setAod(PrDto.getAod());
			pr.setUser(user);
			//pr.setSubmitted(false);
			AcceptedProjectRequests spr=accRepo.save(pr);
			Prservice.deleteRequestByStudentId(PrDto.getStudentid());
			prDto prd=modelMapper.map(spr,prDto.class);
			prd.setFaculty(PrDto.getFaculty());
			return prd;
	    }
	    else {
	        throw new ProjectAlreadyAccepted("Already Request Accepted");
		 }
	}

//	@Override
//	public boolean checkUser(long studentid) {
//		AcceptedProjectRequests pr= accRepo.findByStudentid(studentid);
//		return pr != null;
//	}
	
	@Override
	public aprDto checkUser(long studentid) {
		AcceptedProjectRequests pr= accRepo.findByStudentid(studentid);
		if(pr!=null) {
			aprDto dto=modelMapper.map(pr, aprDto.class);
			dto.setFacultyname(pr.getUser().getName());
			dto.setFacultyid(pr.getUser().getId());
			return dto;
		}
		return null;
	}

	@Override
	public List<prDto> getAcceptedProjects(String email) {
		Users user =userRepo.findByEmail(email).orElseThrow(
				() -> new UserNotFoundException(String.format("User %s not found", email))
				);
		List<AcceptedProjectRequests> PR = accRepo.findAllByUser_Id(user.getId());
		return PR.stream().map(pr -> {
            prDto prd = modelMapper.map(pr, prDto.class);
            prd.setFaculty(user.getName());
            return prd;
        }).collect(Collectors.toList());
	}

	@Override
	public aprDto updateGithublink(aprDto AprDto) {
		AcceptedProjectRequests apr = accRepo.findById(AprDto.getId()).orElseThrow(
	            () -> new UserNotFoundException(String.format("Project with Id %s not found", AprDto.getId()))
	    );
	    apr.setGithublink(AprDto.getGithublink());
	    apr.setSubmitted(true);
	    AcceptedProjectRequests updatedApr = accRepo.save(apr);
	    aprDto dto = modelMapper.map(updatedApr, aprDto.class);
		return dto;
	}

}
