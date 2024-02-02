package com.pms.Backend.userServImp;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pms.Backend.Exception.APIException;
import com.pms.Backend.Exception.RequestAlreadyExists;
import com.pms.Backend.Exception.UserNotFoundException;
import com.pms.Backend.model.ProjectRequest;
import com.pms.Backend.model.Users;
import com.pms.Backend.payload.prDto;
import com.pms.Backend.repositories.UserRepo;
import com.pms.Backend.repositories.prRepo;
import com.pms.Backend.service.PrService;

@Service
public class PrRequestImp implements PrService{
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    private UserRepo userRepo;
	
	
	@Autowired
    private prRepo PrRepo;
	
	@Override
	public prDto createProjectRequest(prDto PrDto){
		Users user = userRepo.findByName(PrDto.getFaculty());
//		System.out.println(user);
	    boolean p = checkUser(PrDto.getStudentid());
	    if (!p) {
	        ProjectRequest pr = new ProjectRequest();
			pr.setStudentid(PrDto.getStudentid());
		    pr.setStudentname(PrDto.getStudentname());
		    pr.setTitle(PrDto.getTitle());
		    pr.setDescription(PrDto.getDescription());
		    pr.setAod(PrDto.getAod());
			pr.setUser(user);
			ProjectRequest spr=PrRepo.save(pr);
			prDto prd=modelMapper.map(spr,prDto.class);
			prd.setFaculty(PrDto.getFaculty());
			return prd;
		}
	    else {
	        throw new RequestAlreadyExists("Already Requests Exists");
		 }
	}
	
	@Override
	public List<prDto> getProjectRequest(long teacherid) {
		Users user =userRepo.findById(teacherid).orElseThrow(
				() -> new UserNotFoundException(String.format("User Id %s not found", teacherid))
				);
		List<ProjectRequest> PR = PrRepo.findAllByUser_Id(teacherid);
        return PR.stream().map(pr -> {
            prDto prd = modelMapper.map(pr, prDto.class);
            prd.setFaculty(user.getName());
            return prd;
        }).collect(Collectors.toList());
		
	}

	@Override
	public List<prDto> getYourProjectRequests(String email) {
		Users user =userRepo.findByEmail(email).orElseThrow(
				() -> new UserNotFoundException(String.format("User %s not found", email))
				);
		List<ProjectRequest> PR = PrRepo.findAllByUser_Id(user.getId());
		return PR.stream().map(pr -> {
            prDto prd = modelMapper.map(pr, prDto.class);
            prd.setFaculty(user.getName());
            return prd;
        }).collect(Collectors.toList());
	}

	@Override
	public boolean checkUser(long studentid) {
		ProjectRequest pr= PrRepo.findByStudentid(studentid);
		return pr != null;
	}

	@Override
	public void deleteRequest(String email, long projectid) {
		Users user =userRepo.findByEmail(email).get();
		long  teacherid=user.getId();
		ProjectRequest pr=PrRepo.findById(projectid).orElseThrow(
				() -> new UserNotFoundException(String.format("project Request with  Id %d not found", projectid))
				);
		if(teacherid!=pr.getUser().getId()) {
			throw new APIException(String.format("Project Request Id %d not belongs to teacher Id %s", projectid,teacherid));
		}
		PrRepo.deleteById(projectid);
	}

	@Override
	public void deleteRequestByStudentId(long studentId) {
		ProjectRequest pr = PrRepo.findByStudentid(studentId);
        if (pr != null) {
            PrRepo.deleteById(pr.getId());
        } else {
            throw new UserNotFoundException("Project Request not found for the given student ID");
        }
		
	}

}
