package com.ocean.entity;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection ="Batch")
public class Batch{
	@MongoId
	private int batchId;
	private String name;
	private int smeEmployeeId;
	private Date startDate;
	private Date endDate;
	private String careerTrack;
	private String subTrack;
	private String familyRole;
	private String role;
	private List<Candidate> candidateList=new ArrayList<>();
 
}
