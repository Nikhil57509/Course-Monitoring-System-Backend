package com.cms.demo.service;

import com.cms.demo.model.Facultymodel;
import com.cms.demo.repo.Facultyrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyserviceImpl implements Facultyservice {

    @Autowired
    private Facultyrepo facultyRepo;

    @Override
    public String login(String username, String password) {
        Facultymodel faculty = facultyRepo.findByUsername(username);
        if (faculty != null && faculty.getPassword().equals(password)) {
            return "success";
        } else {
            return "Invalid username or password";
        }
    }

    @Override
    public List<Facultymodel> getAllFaculties() {
        return facultyRepo.findAll();
    }

    @Override
    public Optional<Facultymodel> getFacultyById(Integer id) {
        return facultyRepo.findById(id);
    }

    @Override
    public Facultymodel createFaculty(Facultymodel faculty) {
        return facultyRepo.save(faculty);
    }

    @Override
    public Facultymodel updateFaculty(Integer id, Facultymodel facultyUpdate) {
        Facultymodel existingFaculty = facultyRepo.findById(id).orElseThrow(() -> new RuntimeException("Faculty not found with id: " + id));
        existingFaculty.setName(facultyUpdate.getName());
        existingFaculty.setEmail(facultyUpdate.getEmail());
        // Update other fields as needed
        return facultyRepo.save(existingFaculty);
    }

    @Override
    public void deleteFaculty(Integer id) {
        if (!facultyRepo.existsById(id)) {
            throw new RuntimeException("Faculty not found with id: " + id);
        }
        facultyRepo.deleteById(id);
    }
}
