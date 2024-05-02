package com.cms.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cms.demo.model.Facultymodel;
import com.cms.demo.repo.Facultyrepo;



@Service
public class Facultyimp implements Facultyservice {
    @Autowired
    private Facultyrepo facultyrepo;

    @Override
    public String login(String username, String password) {
        Facultymodel faculty = facultyrepo.findByUsername(username);
        if (faculty != null && faculty.getPassword().equals(password)) {
            return "success";
        } else {
            return "Invalid username or password";
        }
    }
}
