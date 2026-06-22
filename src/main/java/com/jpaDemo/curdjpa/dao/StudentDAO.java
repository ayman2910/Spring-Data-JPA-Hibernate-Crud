package com.jpaDemo.curdjpa.dao;

import com.jpaDemo.curdjpa.Entity.Student;

import java.util.List;

public interface StudentDAO {
     void save(Student theStudent);
     Student findById(Integer theId);
     List<Student> findByLastName(String theLastName);
}
