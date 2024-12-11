package com.cerenklvz.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cerenklvz.entity.Project;

import java.util.List;

@Repository
class ProjectDaoImpl  implements  ProjectDao{

    private final SessionFactory sessionFactory;

    @Autowired
    public ProjectDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    @Override
    public List<Project> getProjects() {
        Session session = sessionFactory.getCurrentSession();
        Query<Project> query;
        query = session.createQuery("from Project", Project.class);
        return query.getResultList();
        
    }

    @Override
    public void saveOrUpdate(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(project);
    }

    @Override
    public Project getProject(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Project.class,id);
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Project c where c.Id =:id");
        query.setParameter("id",id);
        query.executeUpdate();
    }
}
