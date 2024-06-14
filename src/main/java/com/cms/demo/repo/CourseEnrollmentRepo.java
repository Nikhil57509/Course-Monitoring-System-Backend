package com.cms.demo.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.cms.demo.model.CourseEnrollmentModel;
import com.cms.demo.model.Studentmodel;

public interface CourseEnrollmentRepo extends JpaRepository<CourseEnrollmentModel, Long> {
    List<CourseEnrollmentModel> findByStudent(Studentmodel student);
}
