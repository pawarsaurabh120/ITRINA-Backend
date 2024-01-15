package com.ocean.entity;

import java.util.Date;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Candidate")
public class Candidate {
    @MongoId
	private int employeeId;
//    private int BatchId;
	private String employeeName;
	private String employeeEmail;
	private int contactNo;
	private String globalGrade;
	private String localGrade;
	private String category;
	private String BU;
	private String location;
	private String practice;
	private String subPractice;
	private String type;
	private String exitStatus;
	private String accountName;
	private String bUContactPerson;
	private Date billableDate;
	private Week1 week1;
	private Week2 week2;
	private Week3 week3;
	private Week4 week4;
	private InterviewRecord records;
	
	
	
	
	
	
	
	
	
	
	
	

}
