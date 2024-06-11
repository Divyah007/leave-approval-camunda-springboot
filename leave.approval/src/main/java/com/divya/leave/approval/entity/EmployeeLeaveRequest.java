package com.divya.leave.approval.entity;

import java.io.Serializable;
import java.util.Date;


import com.divya.leave.approval.enums.EmployeeType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@Entity
@Builder
@AllArgsConstructor
public class EmployeeLeaveRequest implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer eid;
	private String ename;
	@Builder.Default
	 @Enumerated(EnumType.STRING)
	private EmployeeType etype=EmployeeType.Contractor;
	@Builder.Default
	private  Boolean isManagerApproved=false;
	@Builder.Default
	private Boolean isHrApproved=false;
	private Date fromDate;
	private Date toDate;
	private Integer noOfDays;
	
	@Transient
	public Integer getId() {
		return this.eid;
		
	}
	
	

}
