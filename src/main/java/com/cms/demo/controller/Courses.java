package com.cms.demo.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cms.demo.courses.Batch;
import com.cms.demo.courses.CourseDTO;
import com.cms.demo.courses.CourseEnrollmentDTO;
import com.cms.demo.courses.StudentDTO;
import com.cms.demo.model.CourseEnrollmentModel;
import com.cms.demo.model.Coursemodel;
import com.cms.demo.model.Facultymodel;
import com.cms.demo.model.Studentmodel;
import com.cms.demo.service.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/inst")
@CrossOrigin("http://localhost:3000")
public class Courses {

    @Autowired
    private Courseservice enrolledCourseService;

    @Autowired
    private Facultyservice facultyService;

    @Autowired
    private Adminservice adminService;

    @Autowired
    private Studentservice studentService;

    @Autowired
    private CourseEnrollmentService courseEnrollmentService;

    @Autowired
    private BatchService batchService;

    // Constructor
    public Courses() {
        // Default constructor
    }

    @GetMapping("/getallcourses")
    public ResponseEntity<List<Coursemodel>> getAllCourses() {
        List<Coursemodel> list = enrolledCourseService.getAllCourses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<String> login(@PathVariable String username, @PathVariable String password) {
        String loginResult = facultyService.login(username, password);
        if ("success".equals(loginResult)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + loginResult);
        }
    }

    @GetMapping("/adminname/{adminname}/{password}")
    public ResponseEntity<String> adminLogin(@PathVariable String adminname, @PathVariable String password) {
        String adminResult = adminService.admin(adminname, password);
        if ("success".equals(adminResult)) {
            return ResponseEntity.ok("Hello Admin, how is your Day?");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + adminResult);
        }
    }

    @GetMapping("/courses/{name}")
    public ResponseEntity<List<Coursemodel>> getCourseByName(@PathVariable String name) {
        List<Coursemodel> courses = enrolledCourseService.findByName(name);
        if (!courses.isEmpty()) {
            return ResponseEntity.ok(courses);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PostMapping("/student/register")
    public ResponseEntity<Studentmodel> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        Studentmodel createdStudent = studentService.createStudent(studentDTO);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PostMapping("/course/create")
    public ResponseEntity<Coursemodel> createCourse(@RequestBody CourseDTO courseDTO) {
        Coursemodel createdCourse = enrolledCourseService.createCourse(courseDTO);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping("/student/{name}")
    public ResponseEntity<List<Studentmodel>> getCoursesByStudentName(@PathVariable String name) {
        List<Studentmodel> students = studentService.findByStudentName(name);
        if (students.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(students, HttpStatus.OK);
        }
    }

    @GetMapping("/enrolled")
    public ResponseEntity<List<Coursemodel>> getEnrolledCourses(@RequestParam Integer studentId) {
        try {
            List<Coursemodel> enrolledCourses = courseEnrollmentService.getEnrollmentsByName(studentId);
            return ResponseEntity.ok(enrolledCourses);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(Collections.emptyList());
        }
    }

    @PostMapping("/enrolled")
    public ResponseEntity<CourseEnrollmentModel> enrollStudent(@RequestBody CourseEnrollmentDTO enrollmentDTO) {
        if (enrollmentDTO.getCourseIds().isEmpty() || enrollmentDTO.getStudentId() == null || enrollmentDTO.getStudentName() == null) {
            return ResponseEntity.badRequest().build();
        }
        CourseEnrollmentModel savedEnrollment = courseEnrollmentService.enrollStudent(enrollmentDTO);
        if (savedEnrollment == null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEnrollment);
    }

    @PostMapping("/batch")
    public ResponseEntity<Batch> createBatch(@RequestBody Batch batchDto) {
        Batch createdBatch = batchService.createBatch(batchDto);
        return new ResponseEntity<>(createdBatch, HttpStatus.CREATED);
    }

    @GetMapping("/batch/{id}")
    public ResponseEntity<Batch> getBatchById(@PathVariable Long id) {
        Batch batchDto = batchService.getBatchById(id);
        return ResponseEntity.ok(batchDto);
    }

    @GetMapping("/batches")
    public ResponseEntity<List<Batch>> getAllBatches() {
        List<Batch> batches = batchService.getAllBatches();
        return ResponseEntity.ok(batches);
    }

    @PutMapping("/batch/{id}")
    public ResponseEntity<Batch> updateBatch(@PathVariable Long id, @RequestBody Batch batchDto) {
        Batch updatedBatch = batchService.updateBatch(id, batchDto);
        return ResponseEntity.ok(updatedBatch);
    }

    @DeleteMapping("/batch/{id}")
    public ResponseEntity<Void> deleteBatch(@PathVariable Long id) {
        batchService.deleteBatch(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/faculty")
    public List<Facultymodel> getAllFaculties() {
        return facultyService.getAllFaculties();
    }

    @GetMapping("/faculty/{id}")
    public ResponseEntity<Facultymodel> getFacultyById(@PathVariable Integer id) {
        Facultymodel faculty = facultyService.getFacultyById(id).orElseThrow(() -> new RuntimeException("Faculty not found with id: " + id));
        return ResponseEntity.ok(faculty);
    }

    @PostMapping("/faculty")
    public ResponseEntity<Facultymodel> createFaculty(@RequestBody Facultymodel facultyDTO) {
        Facultymodel faculty = facultyService.createFaculty(facultyDTO);
        return ResponseEntity.ok(faculty);
    }

    @PutMapping("/faculty/{id}")
    public ResponseEntity<Facultymodel> updateFaculty(@PathVariable Integer id, @RequestBody Facultymodel facultyDTO) {
        Facultymodel updatedFaculty = facultyService.updateFaculty(id, facultyDTO);
        return ResponseEntity.ok(updatedFaculty);
    }

    @DeleteMapping("/faculty/{id}")
    public ResponseEntity<Void> deleteFaculty(@PathVariable Integer id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
