package com.jpaDemo.curdjpa;

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
	public CommandLineRunner commandLineRunner(String[]args){
		return runner ->{
			System.out.println("=========================================");
			System.out.println("SUCCESS: The application is actually running.");
			System.out.println("The Database is connected.");
			System.out.println("Ready to execute JPA commands.");
			System.out.println("=========================================");
			System.out.println("Ready for Crud");
			System.out.println("=========================================");
		};
	}
}
