package com.grh.entreprise;

import com.grh.entreprise.model.Employee;
import com.grh.entreprise.repo.EmployeeRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.Column;
import java.util.Date;

@SpringBootApplication
public class EntrepriseApplication {

	public static void main(String[] args) {
		SpringApplication.run(EntrepriseApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(EmployeeRepo employeeRepo) {
		return args -> {
			employeeRepo.save(new Employee(1L,"Aminata","daniel@mina.com","dev","999999","https://cdn.pixabay.com/photo/2016/08/08/09/17/avatar-1577909_1280.png","12"));
			employeeRepo.save(new Employee(2L,"mina","daniel@mina.com","dev","999999","google.com","12"));
			employeeRepo.save(new Employee(3L,"lola","daniel@mina.com","dev","999999","google.com","12"));
			employeeRepo.save(new Employee(4L,"Anne","daniel@mina.com","dev","999999","google.com","12"));
			employeeRepo.findAll().forEach(p->{System.out.println(p.getName());});
		};
	}
}
