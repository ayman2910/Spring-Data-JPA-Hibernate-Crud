package com.jpaDemo.curdjpa;

import com.jpaDemo.curdjpa.Entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentDAOImpl implements StudentDAO{
    private EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }
}
