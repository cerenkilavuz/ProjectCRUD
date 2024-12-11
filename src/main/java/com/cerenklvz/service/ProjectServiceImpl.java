package com.cerenklvz.service;

import com.cerenklvz.dao.ProjectDao;
import com.cerenklvz.entity.Project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDao projectDao;

    @Autowired
    public ProjectServiceImpl(ProjectDao projectDao) {
        this.projectDao = projectDao;
    }


    @Override
    @Transactional
    public List<Project> getProjects() {
        return projectDao.getProjects();
    }

    @Override
    @Transactional
    public void saveOrUpdate(Project project) {
        projectDao.saveOrUpdate(project);
    }

    @Override
    @Transactional
    public Project getProject(int id) {
        return projectDao.getProject(id);
    }

    @Override
    @Transactional
    public void delete(int id) {
        projectDao.delete(id);
    }
}
