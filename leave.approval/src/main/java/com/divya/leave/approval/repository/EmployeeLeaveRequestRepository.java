package com.divya.leave.approval.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.divya.leave.approval.entity.EmployeeLeaveRequest;

@RepositoryRestResource(collectionResourceRel = "EmployeeLeaveRequest", path = "employees-leave-request")
public interface EmployeeLeaveRequestRepository extends JpaRepository<EmployeeLeaveRequest,Integer>{

}
