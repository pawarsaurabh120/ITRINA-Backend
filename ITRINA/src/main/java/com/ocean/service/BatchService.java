package com.ocean.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.ocean.Exception.InvalidBatchException;
import com.ocean.entity.Batch;
import com.ocean.entity.Candidate;
import com.ocean.entity.InterviewRecord;
import com.ocean.entity.Week1;
import com.ocean.entity.Week2;
import com.ocean.entity.Week3;
import com.ocean.entity.Week4;
import com.ocean.repository.BatchRepository;

@Service
public class BatchService implements IBatchService {

	@Autowired
	public BatchRepository batchRepository;
	private static final Logger log = LoggerFactory.getLogger(BatchService.class);

	@Override
	public String addBatch(Batch batch) {
		batchRepository.save(batch);
		log.info("Batch details add successfully");
		return "Batch details add successfully";

	}

	@Override
	public List<Batch> findBySmeEmployeeId(int smeEmployeeId) {
		return batchRepository.findBySmeEmployeeId(smeEmployeeId);
	}

	@Override
	public String updateBatchDetail(int batchId, Date startDate, Date endDate) throws InvalidBatchException {
		Batch r = batchRepository.findByBatchId(batchId);
		if (r == null) {
			log.info("Batch is not available for updating ");
			throw new InvalidBatchException(batchId + "Not Found ");
		} else {
			r.setStartDate(startDate);
			r.setEndDate(endDate);

			batchRepository.save(r);
			log.info("Successfully Updated Batch Detail");
			return "Successfully Updated Batch Detail";
		}

	}

	@Override
	public Batch getBatchByBatchId(int batchId) {

		return batchRepository.findByBatchId(batchId);
	}

	@Override
	public List<Batch> getAllBatches() {
		return batchRepository.findAll();
	}

	@Override
	public String updateWeek1Report(int batchId, int candidateId, Week1 week1) {
		Batch b = batchRepository.findByBatchId(batchId);
		for (Candidate c : b.getCandidateList()) {
			if (c.getEmployeeId() == candidateId) {
				c.setWeek1(week1);
				batchRepository.save(b);
			}
		}
		return "Week1 detail update successfully";
	}

	@Override
	public String updateWeek2Report(int batchId, int candidateId, Week2 week2) {
		Batch b = batchRepository.findByBatchId(batchId);
		for (Candidate c : b.getCandidateList()) {
			if (c.getEmployeeId() == candidateId) {
				c.setWeek2(week2);
				batchRepository.save(b);
			}
		}
		return "Week2 detail update successfully";
	}

	@Override
	public String updateWeek3Report(int batchId, int candidateId, Week3 week3) {
		Batch b = batchRepository.findByBatchId(batchId);
		for (Candidate c : b.getCandidateList()) {
			if (c.getEmployeeId() == candidateId) {
				c.setWeek3(week3);
				batchRepository.save(b);
			}
		}
		return "Week3 detail update successfully";
	}

	@Override
	public String updateWeek4Report(int batchId, int candidateId, Week4 week4) {
		Batch b = batchRepository.findByBatchId(batchId);
		for (Candidate c : b.getCandidateList()) {
			if (c.getEmployeeId() == candidateId) {
				c.setWeek4(week4);
				batchRepository.save(b);
			}
		}
		return "Week4 detail update successfully";
	}

	@Override
	public List<Candidate> getBatchCandidateByBatchId(int batchId) {
		Batch b = batchRepository.findByBatchId(batchId);
		return b.getCandidateList();
	}

	@Override
	public String updateExitStatus(int batchId, int candidateId, String exitStatus) {
		Batch b = batchRepository.findByBatchId(batchId);
		for (Candidate c : b.getCandidateList()) {
			if (c.getEmployeeId() == candidateId) {
				c.setExitStatus(exitStatus);
				batchRepository.save(b);
			}
		}
		return "Exit Status detail update successfully";
	}

	@Override
	public String updateInterviewReport(int batchId, int candidateId, InterviewRecord record) {
		Batch b = batchRepository.findByBatchId(batchId);
		for (Candidate c : b.getCandidateList()) {
			if (c.getEmployeeId() == candidateId) {
				c.setRecords(record);
				batchRepository.save(b);
			}
		}
		return "Interview detail update successfully";
	}

}
