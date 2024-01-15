package com.ocean.repository;

import java.util.List;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ocean.entity.Batch;

@Repository
public interface BatchRepository extends MongoRepository<Batch, Integer> {
	public List<Batch> findBySmeEmployeeId(int id);

	public Batch findByBatchId(int batchId);

//	public void updateWeek1ForCandidate(int batchId, int employeeId, Week1 updatedWeek1);
//	{
//    Query query = new Query(Criteria.where("batchId").is(batchId).and("candidateList.employeeId").is(employeeId));
//    Update update = new Update().set("candidateList.$.week1", updatedWeek1);
//    mongoTemplate.updateFirst(query, update, Batch.class);
//}
	
}
