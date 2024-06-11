package com.divya.leave.approval.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.divya.leave.approval.entity.EmployeeLeaveRequest;
import com.divya.leave.approval.repository.EmployeeLeaveRequestRepository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/api")
public class EmployeeLeaveRequestController {
	
	@Autowired
	private EmployeeLeaveRequestRepository employeeLeaveRequestRepository;
	
	@PatchMapping("/updateApproval")
	public void updateHrApproval(@RequestBody Map<String,String> request) {
		log.info("==={}",request);
		log.info("====={}==={}==={}",request.get("eid"),request.get("isHrApproved"),request.get("isManagerApproved"));
		Integer eid=Integer.valueOf(request.get("eid"));
		Boolean isHrApproved= Boolean.valueOf(request.get("isHrApproved"));
		Boolean isManagerApproved= Boolean.valueOf(request.get("isManagerApproved"));
		log.info("====={}===={}==={}",eid,isHrApproved,isManagerApproved);
		EmployeeLeaveRequest leaveRequest=employeeLeaveRequestRepository.findById(eid).get();
		if(isHrApproved) {
			leaveRequest.setIsHrApproved(isHrApproved);	
		}else {
			leaveRequest.setIsManagerApproved(isManagerApproved);
		}
	
		employeeLeaveRequestRepository.save(leaveRequest);
		log.info("===saved success==");
		
	}

}
