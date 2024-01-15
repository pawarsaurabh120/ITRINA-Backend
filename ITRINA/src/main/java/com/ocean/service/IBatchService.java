package com.ocean.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ocean.entity.Batch;
import com.ocean.entity.Candidate;
import com.ocean.entity.InterviewRecord;
import com.ocean.entity.Week1;
import com.ocean.entity.Week2;
import com.ocean.entity.Week3;
import com.ocean.entity.Week4;

@Service
public interface IBatchService {
    public String addBatch(Batch batch);
    public List<Batch> findBySmeEmployeeId(int smeEmployeeId);
    public String updateBatchDetail(int BatchId,Date startDate,Date endDate);
    public Batch getBatchByBatchId(int batchId);
    public List<Batch> getAllBatches();
    public List<Candidate> getBatchCandidateByBatchId(int batchId);
    public String updateWeek1Report(int batchId,int candidateId,Week1 week1);
    public String updateWeek2Report(int batchId,int candidateId,Week2 week1);
    public String updateWeek3Report(int batchId,int candidateId,Week3 week1);
    public String updateWeek4Report(int batchId,int candidateId,Week4 week1);
    public String updateExitStatus(int batchId,int candidateId,String exitStatus);
    public String updateInterviewReport(int batchId,int candidateId,InterviewRecord record);

}
