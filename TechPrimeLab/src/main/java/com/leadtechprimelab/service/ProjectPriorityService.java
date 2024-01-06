package com.leadtechprimelab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtechprimelab.entity.ProjectPriority;
import com.leadtechprimelab.repository.ProjectPriorityReposiory;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectPriorityService {

    private final ProjectPriorityReposiory projectPriorityRepository;

    @Autowired
    public ProjectPriorityService(ProjectPriorityReposiory projectPriorityRepository) {
        this.projectPriorityRepository = projectPriorityRepository;
    }

    public List<ProjectPriority> getAllProjectPriorities() {
        return projectPriorityRepository.findAll();
    }

    public Optional<ProjectPriority> getProjectPriorityById(int ppid) {
        return projectPriorityRepository.findById(ppid);
    }

    public ProjectPriority saveProjectPriority(ProjectPriority projectPriority) {
        return projectPriorityRepository.save(projectPriority);
    }

    public void deleteProjectPriority(int ppid) {
        projectPriorityRepository.deleteById(ppid);
    }
}
