package com.leadtechprimelab.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leadtechprimelab.entity.ProjectLocation;
import com.leadtechprimelab.repository.ProjectLocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectLocationService {

    private final ProjectLocationRepository projectLocationRepository;

    @Autowired
    public ProjectLocationService(ProjectLocationRepository projectLocationRepository) {
        this.projectLocationRepository = projectLocationRepository;
    }

    public List<ProjectLocation> getAllProjectLocations() {
        return projectLocationRepository.findAll();
    }

    public Optional<ProjectLocation> getProjectLocationById(int plid) {
        return projectLocationRepository.findById(plid);
    }

    public ProjectLocation saveProjectLocation(ProjectLocation projectLocation) {
        return projectLocationRepository.save(projectLocation);
    }

    public void deleteProjectLocation(int plid) {
        projectLocationRepository.deleteById(plid);
    }
}
