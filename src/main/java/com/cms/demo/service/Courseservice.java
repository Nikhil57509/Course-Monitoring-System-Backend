package com.cms.demo.service;

import com.cms.demo.courses.CourseDTO;
import com.cms.demo.model.Coursemodel;

import java.util.List;
import java.util.Optional;

public interface Courseservice {
    Coursemodel createCourse(CourseDTO courseDTO);
    
    List<Coursemodel> getAllCourses();
    
    List<Coursemodel> findByName(String name);
}
