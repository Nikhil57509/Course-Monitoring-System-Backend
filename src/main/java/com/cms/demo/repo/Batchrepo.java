package com.cms.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.demo.courses.Batch;
import com.cms.demo.model.BatchModel;
@Repository
public interface Batchrepo extends JpaRepository<BatchModel, Long> {

	Optional<BatchModel> findById(Long id);
    // Additional query methods can be defined here if needed

	
	
}
