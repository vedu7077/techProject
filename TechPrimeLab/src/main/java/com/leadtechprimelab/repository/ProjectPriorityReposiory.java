package com.leadtechprimelab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadtechprimelab.entity.ProjectCatogory;
import com.leadtechprimelab.entity.ProjectPriority;

import java.io.Serializable;

@Repository
public interface ProjectPriorityReposiory extends JpaRepository<ProjectPriority, Serializable> {
}
