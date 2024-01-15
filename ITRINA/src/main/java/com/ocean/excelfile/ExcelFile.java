package com.ocean.excelfile;

import java.io.InputStream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import com.ocean.entity.Candidate;

public class ExcelFile {
	// check that file is excel type or not 
	public static boolean checkExcelFormat(MultipartFile file) {
		String contentType=file.getContentType();
		if(contentType.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")) {
			return true;
		}
		else
		return false;
	}
	
	//convert excel to list of candidates 
	public static List<Candidate> convertExcelToListofCandidate(InputStream is)
	{
		List<Candidate> list=new ArrayList<>();
//		try {
//		XSSFWorkbook workbook = new XSSFWorkbook(is);
//	    XSSFSheet worksheet = workbook.getSheetAt(0);
//		for(int i=1;i<worksheet.getPhysicalNumberOfRows() ;i++) {
//			Candidate candidate = new Candidate();
//	            
//	        XSSFRow row = worksheet.getRow(i);
//	            
//	        candidate.setEmployeeId((int) row.getCell(0).getNumericCellValue());
//	        candidate.setEmployeeName(row.getCell(1).getStringCellValue());
//	        candidate.setEmployeeEmail(row.getCell(2).getStringCellValue());
//	        candidate.setContactNo(row.getCell(3).getStringCellValue());
//	        candidate.setGlobalGrade(row.getCell(4).getStringCellValue());
//	        candidate.setLocalGrade(row.getCell(5).getStringCellValue());
//	        candidate.setLocation(row.getCell(6).getStringCellValue());
//	        candidate.setType(row.getCell(7).getStringCellValue());
//	        
//	        
//	        list.add(candidate);   
//	    }
//		}catch(Exception e) {
//		e.printStackTrace();
//		}
//		return list;

		try {
//			if (is != null) {
			XSSFWorkbook workbook=new XSSFWorkbook(is);
//			XSSFSheet sheet=workbook.getSheet("data");
			XSSFSheet sheet=workbook.getSheetAt(0);
		
			int rowNumber=0;
			Iterator<Row> iterator=sheet.iterator();
			
			while(iterator.hasNext()) {
				Row row=iterator.next();
				if(rowNumber==0) {
					rowNumber++;
					continue;
				}
				Iterator<Cell> cells=row.iterator();
				int cid=0;
				Candidate c=new Candidate();
				while(cells.hasNext()) {
					Cell cell=cells.next();
					switch(cid){
//						case 0:
//							c.setEmployeeId((int)cell.getNumericCellValue() );
//							break;
						case 1:
							c.setEmployeeName(cell.getStringCellValue());
							break;
						case 2:
							c.setEmployeeEmail(cell.getStringCellValue());
							break;
//						case 3:
//							c.setContactNo((int)cell.getNumericCellValue());
//							break;
						case 4:
							c.setGlobalGrade(cell.getStringCellValue());
							break;
//						case 5:
//							c.setLocalGrade(cell.getStringCellValue());
//							break;
//						case 6:
//							c.setLocation(cell.getStringCellValue());
//							break;
//						case 7:
//							c.setType(cell.getStringCellValue());
//							break;
						default:
							break;
						
					}
					cid++;
				}
				list.add(c);
				
//			}
//			workbook.close();
//		}
//			else {
//		        // Handle the case where 'is' is null
//		        System.out.println("Input stream is null");
			}
		}
		catch(Exception e) {
			System.out.print("Hello Exception is here");
			e.printStackTrace();
		}
		return list;
	}

}
