package hcl.springboot.springbootproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import hcl.springboot.springbootproject.model.Employee;
import hcl.springboot.springbootproject.model.Product;
import hcl.springboot.springbootproject.repository.EmployeeRepo;
import hcl.springboot.springbootproject.repository.ProductRepo;

@SpringBootApplication
public class SpringbootprojectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootprojectApplication.class, args);
	}
	
	@Bean
	CommandLineRunner rn(ProductRepo pr) {
		return arg->{
//			pr.save(new Product( "Laptop", 60000));
//			pr.save(new Product("Mobile",45000));
			pr.findAll().forEach(System.out::println);
			pr.findByName("Laptop").forEach(System.out::println);
			System.out.println("saved");
		};
		
	}
	
	@Bean
	CommandLineRunner clr(EmployeeRepo emp) {
		return arg->{
//			emp.save(new Employee("Rony",50000));
//			emp.save(new Employee("Shashank", 70000));
			emp.findByName("Rony").forEach(System.out::println);
			System.out.println("save");
		};
	}

}
