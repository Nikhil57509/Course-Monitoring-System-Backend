package com.cms.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cms.demo.courses.Course;
import com.cms.demo.courses.Faculty;
import com.cms.demo.service.Adminservice;
import com.cms.demo.service.Courseservice;
import com.cms.demo.service.Facultyservice;

@RestController
@RequestMapping("/inst")
public class Courses {

    @Autowired
    private Courseservice courseservice;

    @GetMapping("/getallcourses")
    public ResponseEntity<List<Course>> getallcourses() {
        List<Course> list = courseservice.getallcourses();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }
    @Autowired
    private Facultyservice facultyservice;
    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<String> login(@PathVariable String username, @PathVariable String password) {
        String loginResult = facultyservice.login(username, password);
        if (loginResult.equals("success")) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + loginResult);
        }
    }
    @Autowired
    private Adminservice adminservice;
    @GetMapping("/admin/{username}/{password}")
    public ResponseEntity<String> admin(@PathVariable String adminname,@PathVariable String password)
    {
    	String adminresult=adminservice.admin(adminname, password);
    	if (adminresult.equals("success")) {
            return ResponseEntity.ok("Hello Admin,how is your Day?");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed: " + adminresult);
        }
    }

}
