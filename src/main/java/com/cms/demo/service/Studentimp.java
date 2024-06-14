package com.cms.demo.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.demo.courses.CourseDTO;
import com.cms.demo.courses.StudentDTO;
import com.cms.demo.model.Studentmodel;
import com.cms.demo.repo.Studentrepo;

@Service
public class Studentimp implements Studentservice {

    @Autowired
    private Studentrepo studentrepo;
    @Autowired
    private CourseDTO cdto;

    @Override
    public Studentmodel createStudent(StudentDTO studentDTO) {
        if (!studentDTO.isPasswordConfirmed()) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        Studentmodel student = new Studentmodel();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setPassword(studentDTO.getPassword());
        student.setQualification(studentDTO.getQualification());
        student.setPassoutYear(studentDTO.getPassoutYear());
        student.setSelectedCourse((cdto.getName()));
        

        return studentrepo.save(student);
    }

	@Override
	public List<Studentmodel> findByStudentName(String name) {
	    // Retrieve students from the repository by name
	    List<Studentmodel> students = studentrepo.findByName(name);
	    if (students.isEmpty()) {
	        throw new NoSuchElementException("No students found with the given name");
	    }
	    // Return the list of students
	    return students;
	}

}
