package com.cms.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.demo.model.Facultymodel;
@Repository

public interface Facultyrepo extends JpaRepository<Facultymodel,Integer> {
	
	Facultymodel findByUsername(String username);

}
