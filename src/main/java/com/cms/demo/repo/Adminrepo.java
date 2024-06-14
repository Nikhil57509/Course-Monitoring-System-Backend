package com.cms.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.demo.model.Adminmodel;

@Repository
public interface Adminrepo extends JpaRepository<Adminmodel, Integer> {
    
	
	Adminmodel findByAdminname(String uadminname);
}
