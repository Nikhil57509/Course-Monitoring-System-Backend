package com.cms.demo.service;

import java.util.List;
import java.util.Optional;

import com.cms.demo.model.Facultymodel;

public interface Facultyservice {
    String login(String username, String password);
    List<Facultymodel> getAllFaculties();
    Optional<Facultymodel> getFacultyById(Integer id);
    Facultymodel createFaculty(Facultymodel facultyDTO);
    Facultymodel updateFaculty(Integer id, Facultymodel facultyDTO);
    void deleteFaculty(Integer id);
}
