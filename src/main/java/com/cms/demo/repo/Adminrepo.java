package com.cms.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.demo.model.Adminmodel;
import com.cms.demo.model.Facultymodel;
@Repository
public interface Adminrepo extends JpaRepository<Adminmodel,Integer> {
	 

	

	Adminmodel findbyadmin(String adminname);
}
