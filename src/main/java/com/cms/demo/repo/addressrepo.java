package com.cms.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cms.demo.model.Addressmodel;

public interface addressrepo extends JpaRepository<Addressmodel, Integer> {

}
