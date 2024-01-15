package com.ocean.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ocean.entity.Batch;
import com.ocean.entity.Candidate;
import com.ocean.entity.InterviewRecord;
import com.ocean.entity.Week1;
import com.ocean.entity.Week2;
import com.ocean.entity.Week3;
import com.ocean.entity.Week4;
import com.ocean.service.IBatchService;

@RestController
@RequestMapping("/batch")
public class BatchController {

	@Autowired
	public IBatchService batchService;

	@PostMapping("/addBatch")
	public ResponseEntity<String> addBatch(@RequestBody Batch batch) {
		try {
			batchService.addBatch(batch);
			return ResponseEntity.ok("Batch details add successfully");
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

//	Method to find all batches for a particular SME 
	@GetMapping("/findBySmeEmployeeId/{smeEmployeeId}")
	public List<Batch> findBySmeEmployeeId(@PathVariable int smeEmployeeId) {
		return batchService.findBySmeEmployeeId(smeEmployeeId);

	}

//	Method for updating Batch details by BatchId
	@PutMapping("/updateBatchDetail/{batchId}/{startDate}/{endDate}")
	public String updateBatchDetail(@PathVariable int batchId, @PathVariable Date startDate,
			@PathVariable Date endDate) {
		return batchService.updateBatchDetail(batchId, startDate, endDate);
	}

	// Method to get Batch
	@GetMapping("/getBatchByBatchId/{batchId}")
	public Batch getBatch(@PathVariable int batchId) {

		return batchService.getBatchByBatchId(batchId);

	}

// Method to get all Batch Details
	@GetMapping("/getAllBatch")
	public List<Batch> getAllBatch() {
		return batchService.getAllBatches();
	}

	// Method to get Batch
	@GetMapping("/getBatchCandidateByBatchId/{batchId}")
	public List<Candidate> getBatchCandidate(@PathVariable int batchId) {
		return batchService.getBatchCandidateByBatchId(batchId);

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////

	// Method for updating week 1 report of candidate

	@PutMapping("/updateWeek1Report/{batchId}/{candidateId}")
	public String updateWeek1Report(@PathVariable int batchId, @PathVariable int candidateId,
			@RequestBody Week1 week1) {
		return batchService.updateWeek1Report(batchId, candidateId, week1);

	}

	// Method for updating week 2 report of candidate

	@PutMapping("/updateWeek2Report/{batchId}/{candidateId}")
	public String updateWeek2Report(@PathVariable int batchId, @PathVariable int candidateId,
			@RequestBody Week2 week2) {
		return batchService.updateWeek2Report(batchId, candidateId, week2);

	}
	// Method for updating week 3 report of candidate

	@PutMapping("/updateWeek3Report/{batchId}/{candidateId}")
	public String updateWeek3Report(@PathVariable int batchId, @PathVariable int candidateId,
			@RequestBody Week3 week3) {
		return batchService.updateWeek3Report(batchId, candidateId, week3);

	} 
	// Method for updating week 4 report of candidate

	@PutMapping("/updateWeek4Report/{batchId}/{candidateId}")
	public String updateWeek4Report(@PathVariable int batchId, @PathVariable int candidateId,
			@RequestBody Week4 week4) {
		return batchService.updateWeek4Report(batchId, candidateId, week4);

	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	//Method for updating Exit Status of candidate 

	@PutMapping("/updateExitStaus/{batchId}/{candidateId}/{exitStatus}")
	public String updateExitStatus(@PathVariable int batchId, @PathVariable int candidateId,
			@PathVariable String exitStatus) {
		return batchService.updateExitStatus(batchId, candidateId, exitStatus);

	}
	
	//Method for updating Interview Detail of candidate 

		@PutMapping("/updateInterviewReport/{batchId}/{candidateId}/{exitStatus}")
		public String updateInterviewReport(@PathVariable int batchId, @PathVariable int candidateId,
				@RequestBody InterviewRecord record) {
			return batchService.updateInterviewReport(batchId, candidateId, record);

		}
}
