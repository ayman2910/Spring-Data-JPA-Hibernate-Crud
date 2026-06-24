package com.jpaDemo.curdjpa.dao;

import com.jpaDemo.curdjpa.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer theId) {
        return entityManager.find(Student.class, theId);
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:theData",Student.class);
        theQuery.setParameter("theData",theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Student theStudent = entityManager.find(Student.class, id);
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteByLastName(String theLastName) {
        int numRowDeleted= entityManager.createQuery("DELETE FROM Student WHERE lastName=:theData")
                .setParameter("theData",theLastName)
                .executeUpdate();
        return numRowDeleted;
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowDeleted;
    }
}
