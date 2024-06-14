package com.cms.demo.service;

import java.util.List;

import com.cms.demo.courses.StudentDTO;
import com.cms.demo.model.Studentmodel;

public interface Studentservice {
    Studentmodel createStudent(StudentDTO studentDTO);
    List<Studentmodel> findByStudentName(String name);
	
		
}
