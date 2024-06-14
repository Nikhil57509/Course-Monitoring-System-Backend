package com.cms.demo.service;

import java.util.List;

import com.cms.demo.courses.CourseEnrollmentDTO;
import com.cms.demo.model.CourseEnrollmentModel;
import com.cms.demo.model.Coursemodel;

public interface CourseEnrollmentService {
	

	public CourseEnrollmentModel enrollStudent(CourseEnrollmentDTO enrollment);
	
	
	 List<Coursemodel> getEnrollmentsByName(Integer student);
	

	
}
