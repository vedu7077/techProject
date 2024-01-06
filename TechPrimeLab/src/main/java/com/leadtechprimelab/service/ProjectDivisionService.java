package com.leadtechprimelab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtechprimelab.entity.ProjectDivision;
import com.leadtechprimelab.repository.ProjectDivisionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectDivisionService {

    private final ProjectDivisionRepository projectDivisionRepository;

    @Autowired
    public ProjectDivisionService(ProjectDivisionRepository projectDivisionRepository) {
        this.projectDivisionRepository = projectDivisionRepository;
    }

    public List<ProjectDivision> getAllProjectDivisions() {
        return projectDivisionRepository.findAll();
    }

    public Optional<ProjectDivision> getProjectDivisionById(int pdivid) {
        return projectDivisionRepository.findById(pdivid);
    }

    public ProjectDivision saveProjectDivision(ProjectDivision projectDivision) {
        return projectDivisionRepository.save(projectDivision);
    }

    public void deleteProjectDivision(int pdivid) {
        projectDivisionRepository.deleteById(pdivid);
    }
}
