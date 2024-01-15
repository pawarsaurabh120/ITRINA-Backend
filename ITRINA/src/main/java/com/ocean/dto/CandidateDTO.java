package com.ocean.dto;

import lombok.Data;

@Data
public class CandidateDTO {
	private int employeeId;
	private String employeeName;
	private String employeeEmail;
	private int contactNo;
	private String globalGrade;
	private String localGrade;
	private String location;
	private String type;
}
