package com.ocean.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Week4 {
	@Id
	private int employeeId;
	private int rating;
	private String strengthsFeedback;
	private String opportunityAreasCategory;  
	private String oceanAssessmentCategory;
	private Date oceanAssessmentDate;
	private int oceanScore;
	private String codingAssignment;
	private int externalBenchmark;
	private int quizTotalPointsAvailable;
	private int quizTotalPointsObtained;
	private int englishFirstLevel;

}
