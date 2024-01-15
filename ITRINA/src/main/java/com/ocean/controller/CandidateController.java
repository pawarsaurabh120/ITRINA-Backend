package com.ocean.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ocean.entity.Candidate;
import com.ocean.excelfile.ExcelFile;
import com.ocean.repository.CandidateRepository;
import com.ocean.service.CandidateService;

@RestController
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	
	@Autowired
	CandidateRepository candidateRepo;
	
	
	
	
	@PostMapping(value="/candidate/upload/{batchId}",consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> upload(@PathVariable int batchId, @RequestPart("file") MultipartFile readExcelDataFile) throws IOException{
		if(ExcelFile.checkExcelFormat(readExcelDataFile)) {
			String s=candidateService.ExcelDatatoDB(batchId,readExcelDataFile);
			return ResponseEntity.ok(s);
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file");
	}
	
	
	
	@GetMapping("/candidate")
		public List<Candidate> getAllCandidate(){
			return this.candidateService.getAllCandidates();
		}
	
	
	
	
}
