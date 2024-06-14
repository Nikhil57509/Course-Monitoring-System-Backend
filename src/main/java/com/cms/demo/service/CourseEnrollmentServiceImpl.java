package com.cms.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.demo.courses.CourseEnrollmentDTO;
import com.cms.demo.model.CourseEnrollmentModel;
import com.cms.demo.model.Coursemodel;
import com.cms.demo.model.Studentmodel;
import com.cms.demo.repo.CourseEnrollmentRepo;
import com.cms.demo.repo.Courserepo;
import com.cms.demo.repo.Studentrepo;

@Service
public class CourseEnrollmentServiceImpl implements CourseEnrollmentService {

    @Autowired
    private CourseEnrollmentRepo repository;
    
    @Autowired
    private Courserepo courseRepository;

    @Autowired
    private Studentrepo studentRepo;

    @Override
    public List<Coursemodel> getEnrollmentsByName(Integer studentId) {
        // Fetch the student by ID
        Studentmodel student = studentRepo.findById(studentId).orElseThrow(() -> new RuntimeException("There is no student with this ID"));

        // Fetch enrollments for the student
        List<CourseEnrollmentModel> enrollments = repository.findByStudent(student);

        // Extract courses from the enrollments
        List<Coursemodel> courses = new ArrayList<>();
        for (CourseEnrollmentModel enrollment : enrollments) {
            courses.add(enrollment.getCourse());
        }

        return courses;
    }

    @Override
    public CourseEnrollmentModel enrollStudent(CourseEnrollmentDTO enrollmentDTO) {
        Studentmodel student = studentRepo.findById(Integer.parseInt(enrollmentDTO.getStudentId().toString()))
                .orElseThrow(() -> new RuntimeException("There is no student with this ID " + enrollmentDTO.getStudentId()));
        
        List<CourseEnrollmentModel> enrollments = new ArrayList<>();
        for (Long id : enrollmentDTO.getCourseIds()) {
            Coursemodel course = courseRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("There is no course with this ID " + id));
            
            CourseEnrollmentModel enrollment = new CourseEnrollmentModel();
            enrollment.setStudent(student);
            enrollment.setCourse(course);
            enrollments.add(enrollment);
        }

        repository.saveAll(enrollments);
        return enrollments.isEmpty() ? null : enrollments.get(0); // Return the first enrollment as an example
    }
}
