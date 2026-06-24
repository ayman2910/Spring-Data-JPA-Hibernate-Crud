package com.jpaDemo.curdjpa;

import com.jpaDemo.curdjpa.Entity.Student;
import com.jpaDemo.curdjpa.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CurdjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurdjpaApplication.class, args);
	}
    @Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteStudentByLastName(studentDAO);
			//deleteAllStudents(studentDAO);

		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		int result = studentDAO.deleteAll();
		System.out.println(result);
	}

	private void deleteStudentByLastName(StudentDAO studentDAO) {
		int result= studentDAO.deleteByLastName("Hossain");
		System.out.println(result);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		for(int id=5;id<7;id++){
			System.out.println("Removing student "+studentDAO.findById(id));
			studentDAO.delete(id);
		}
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 2;
		Student myStudent= studentDAO.findById(studentId);
		myStudent.setLastName("Hossain");
		studentDAO.update(myStudent);
		System.out.println("Updated student " + myStudent);

	}

	private void queryStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findByLastName("Hossain");
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void createStudent(StudentDAO studentDAO){
		System.out.println("Creating temp Students...");
		Student tempStudent3 = new Student("Hossain", "Ayman", "aymanhossain@gmail.com");
		Student tempStudent4 = new Student("Suhaila", "Obdhi", "obobaby@gmail.com");
		Student tempStudent= new Student("John", "Doe", "johndoe@gmail.com");
		Student tempStudent1= new Student("Oliver", "Kahn", "olive@gmail.com");
		Student tempStudent5 = new Student("Tony", "Kroos", "tonokroos@gmail.com");
		Student tempStudent2 = new Student("Manual", "Neuer", "mn1_deutchland@gmail.com");

		System.out.println("Saving temp Student...");
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		studentDAO.save(tempStudent);
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent5);
		System.out.println("Saved Student, ID: "+ tempStudent.getId()+ "\n "+tempStudent1.getId()+
				"\n "+tempStudent2.getId()+ "\n" + tempStudent3.getId() +"\n"+tempStudent4.getId()+
				"\n"+tempStudent4.getId());

	}
	private void readStudent(StudentDAO studentDAO){
		System.out.println("Reading Student...");
		System.out.println(studentDAO.findById(1));
		System.out.println(studentDAO.findById(2));
		System.out.println(studentDAO.findById(3));
		System.out.println(studentDAO.findById(4));
	}
}
