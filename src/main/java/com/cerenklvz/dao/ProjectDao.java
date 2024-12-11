package com.cerenklvz.dao;

import java.util.List;

import com.cerenklvz.entity.Project;

public interface ProjectDao {
    List<Project> getProjects();
    void saveOrUpdate(Project project);
    Project getProject(int id);
    void delete(int id);
}
