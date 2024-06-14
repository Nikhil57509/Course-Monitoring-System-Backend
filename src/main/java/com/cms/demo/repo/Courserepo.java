package com.cms.demo.repo;

import com.cms.demo.model.CourseEnrollmentModel;
import com.cms.demo.model.Coursemodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface Courserepo extends JpaRepository<Coursemodel, Long> {
   

	
	List<Coursemodel> findByName(String name);

	List<Coursemodel> findById(Integer studentId);
    
}
