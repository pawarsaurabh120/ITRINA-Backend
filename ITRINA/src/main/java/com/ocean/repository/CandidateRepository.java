package com.ocean.repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ocean.entity.Candidate;
@Repository
public interface CandidateRepository extends MongoRepository<Candidate, Integer>{

}
