package com.cms.demo.service;

import com.cms.demo.courses.CourseDTO;
import com.cms.demo.model.Coursemodel;
import com.cms.demo.repo.Courserepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseImpl implements Courseservice {

    @Autowired
    private Courserepo courseRepo;

    @Override
    public Coursemodel createCourse(CourseDTO enrolledcourseDTO) {
        Coursemodel course = new Coursemodel();
        course.setName(enrolledcourseDTO.getName());
        course.setDescription(enrolledcourseDTO.getDescription());
        course.setDuration(enrolledcourseDTO.getDuration());
        course.setStartDate(enrolledcourseDTO.getStartDate());
        course.setEndDate(enrolledcourseDTO.getEndDate());
        course.setSchedule(enrolledcourseDTO.getSchedule());
        course.setStatus(enrolledcourseDTO.getStatus());
        course.setCost(enrolledcourseDTO.getCost());

        return courseRepo.save(course);
    }

    @Override
    public List<Coursemodel> getAllCourses() {
        return courseRepo.findAll();
    }

    @Override
    public List<Coursemodel> findByName(String name) {
        return courseRepo.findByName(name);
    }
}
