package com.cerenklvz.service;

import java.util.List;

import com.cerenklvz.entity.Project;

public interface ProjectService {
    List<Project> getProjects();
    void saveOrUpdate(Project project);
    Project getProject(int id);
    void delete(int id);
}
