package com.tailoringmanagementsystem.projects;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.tailoringmanagementsystem")

@EntityScan(basePackages = "com.tailoringmanagementsystem.Entity")

@EnableJpaRepositories(basePackages = "com.tailoringmanagementsystem.Repo")
public class ProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectsApplication.class, args);
		 System.out.println(
            "Tailoring Makeup Management System Started Successfully"
        );
	}

}
