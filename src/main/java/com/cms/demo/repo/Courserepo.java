package com.cms.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cms.demo.model.Coursemodel;
@Repository
public interface Courserepo extends JpaRepository<Coursemodel,Integer> {

}
