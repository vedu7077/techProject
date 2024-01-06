package com.leadtechprimelab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.leadtechprimelab.entity.ProjectCatogory;

import java.io.Serializable;

@Repository
public interface ProjectCatogoryRepository extends JpaRepository<ProjectCatogory, Serializable> {
}
