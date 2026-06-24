package com.jpaDemo.curdjpa.dao;

import com.jpaDemo.curdjpa.Entity.Student;

import java.util.List;

public interface StudentDAO {
     void save(Student theStudent);
     Student findById(Integer theId);
     List<Student> findByLastName(String theLastName);
     void update(Student theStudent);
     void delete(Integer id);
     int deleteByLastName(String theLastName);
     int deleteAll();
}
