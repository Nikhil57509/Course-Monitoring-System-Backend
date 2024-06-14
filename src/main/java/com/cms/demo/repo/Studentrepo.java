package com.cms.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.demo.model.Studentmodel;

public interface Studentrepo extends JpaRepository<Studentmodel, Integer> {
	
	public List<Studentmodel> findByName(String name);
	
	}

	
