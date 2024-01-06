package com.leadtechprimelab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtechprimelab.entity.ProjectReason;
import com.leadtechprimelab.repository.ProjectReasonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectReasonService {

    private final ProjectReasonRepository projectReasonRepository;

    @Autowired
    public ProjectReasonService(ProjectReasonRepository projectReasonRepository) {
        this.projectReasonRepository = projectReasonRepository;
    }

    public List<ProjectReason> getAllProjectReasons() {
        return projectReasonRepository.findAll();
    }

    public Optional<ProjectReason> getProjectReasonById(int prid) {
        return projectReasonRepository.findById(prid);
    }

    public ProjectReason saveProjectReason(ProjectReason projectReason) {
        return projectReasonRepository.save(projectReason);
    }

    public void deleteProjectReason(int prid) {
        projectReasonRepository.deleteById(prid);
    }
}
