package com.ocean.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.ocean.entity.Batch;
import com.ocean.entity.Candidate;
import com.ocean.excelfile.ExcelFile;
import com.ocean.repository.BatchRepository;
import com.ocean.repository.CandidateRepository;

@Service
public class CandidateService {
	
	@Autowired
	CandidateRepository candidateRepo;
	
	@Autowired
	BatchRepository batchRepository;
	
	public String ExcelDatatoDB(int batchId,MultipartFile readExcelDataFile) throws IOException {
	    Batch batch = batchRepository.findByBatchId(batchId);
	    List<Candidate> list = new ArrayList<>();
	    XSSFWorkbook workbook = new XSSFWorkbook(readExcelDataFile.getInputStream());
	    XSSFSheet worksheet = workbook.getSheetAt(0);
	    
	    for(int i=3;i<worksheet.getPhysicalNumberOfRows();i++) {
	        Candidate candidate = new Candidate();
	            
	        XSSFRow row = worksheet.getRow(i);
	            
//	        tempStudent.setEmployeeId((int) row.getCell(0).getNumericCellValue());
//	        tempStudent.setEmployeeName(row.getCell(1).getStringCellValue());
//	        tempStudentList.add(tempStudent);  
	        
	        candidate.setEmployeeId((int) row.getCell(0).getNumericCellValue());
	        candidate.setEmployeeName(row.getCell(1).getStringCellValue());
	        candidate.setEmployeeEmail(row.getCell(2).getStringCellValue());
//	        candidate.setContactNo((int) row.getCell(3).getNumericCellValue());
	        candidate.setGlobalGrade(row.getCell(4).getStringCellValue());
	        candidate.setLocalGrade(row.getCell(5).getStringCellValue());
//	        candidate.setLocation(row.getCell(8).getStringCellValue());
	        candidate.setType(row.getCell(12).getStringCellValue());
//	        if(row.getCell(4)!=null) {
//	        	candidate.setGlobalGrade(row.getCell(4).getStringCellValue());
//	        }
//	        if(row.getCell(5)!=null) {
//	        	candidate.setLocalGrade(row.getCell(5).getStringCellValue());
//	        }
//	        candidate.setLocalGrade(row.getCell(5).getStringCellValue());
//	        if(row.getCell(6)!=null) {
//	        	candidate.setLocation(row.getCell(6).getStringCellValue());
//	        }
//	        if(row.getCell(7)!=null) {
//	        	candidate.setType(row.getCell(7).getStringCellValue());
//	        }
	        
	        list.add(candidate);   
	      
	    }
	    batch.setCandidateList(list);
	    candidateRepo.saveAll(list);
	    batchRepository.save(batch);
	    return "file uploaded and data save in db";
	}
	
	
	
	
	
	
	
//	public void save(MultipartFile file) {
////		try {
////			List<Candidate> lists=ExcelFile.convertExcelToListofProduct(file.getInputStream());
////			this.candidateRepo.saveAll(lists);
////		}catch(Exception e) {
////			e.printStackTrace();
////		}
//		
//		try {
//		    if (file != null && !file.isEmpty()) {
//		        List<Candidate> lists = ExcelFile.convertExcelToListofCandidate(file.getInputStream());
//		        this.candidateRepo.saveAll(lists);
//		    } else {
//		        // Handle the case where 'file' is null
//		        System.out.println("File is null");
//		    }
//		} catch (Exception e) {
//		    e.printStackTrace();
//		}
//	}
	
	
	
	public List<Candidate> getAllCandidates(){
		return this.candidateRepo.findAll();
	}

}
