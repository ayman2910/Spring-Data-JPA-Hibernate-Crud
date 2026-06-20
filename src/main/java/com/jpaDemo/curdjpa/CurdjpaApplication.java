package com.jpaDemo.curdjpa;

import com.jpaDemo.curdjpa.Entity.Student;
import com.jpaDemo.curdjpa.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CurdjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdjpaApplication.class, args);
	}
    @Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
		};
	}
	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating temp Student...");
		Student tempStudent= new Student("Hossain", "Ayman", "aymanhossain@gmail.com");
		System.out.println("Saving temp Student...");
		studentDAO.save(tempStudent);
		System.out.println("Saved Student, ID: "+tempStudent.getId());

	}
}
