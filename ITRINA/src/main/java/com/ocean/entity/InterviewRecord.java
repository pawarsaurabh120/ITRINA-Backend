package com.ocean.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InterviewRecord {
	
	private int noOfMockInterviewSchedule;
	private int noOfMockInterviewAttempt;
	private int noOfMockInterviewCleared;
	private int interviewStrength;
	private int interviewOpportunityArea;
	private int smeFinalRating;
	
}
