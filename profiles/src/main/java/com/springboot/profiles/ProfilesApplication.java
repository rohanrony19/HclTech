package com.springboot.profiles;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springboot.profiles.model.Answers;
import com.springboot.profiles.model.Customer;
import com.springboot.profiles.model.Order;
import com.springboot.profiles.model.Passport;
import com.springboot.profiles.model.Person;
import com.springboot.profiles.model.Question;
import com.springboot.profiles.repository.CustomerRepo;
import com.springboot.profiles.repository.PersonRepo;
import com.springboot.profiles.repository.QuestionRepo;

@SpringBootApplication
public class ProfilesApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ProfilesApplication.class, args);
		
	}
	
//	@Bean
//	CommandLineRunner cr(QuestionRepo qr) {
//		return arg->{Question question = new Question();
//		question.setTitle("What is Springboot");
//		question.setDescription("Tell more about technically");
//		 
//		Answers answers1 = new Answers();
//		answers1.setContent("SpringBoot is a production ready framework");
//		
//		Answers answers2 = new Answers();
//		answers2.setContent("SpringBoot provide auto configuration");
//		
//		Answers answers3 = new Answers();
//		answers3.setContent("SpringBoot reduces redundancy");
//		answers1.setQuestion(question);
//		answers2.setQuestion(question);
//		answers3.setQuestion(question);
//		
//		question.setAnswers(List.of(answers1,answers2,answers3));
//		
//		qr.save(question);
//		};
//		
//	}
	
//	@Bean
//	CommandLineRunner clr(CustomerRepo cr) {
//		return arg->{
//			
//			Customer cus1 = new Customer();
//			cus1.setName("Rohan");
//			cus1.setLocation("Chennai");
//			
//			Customer cus2 = new Customer();
//			cus2.setName("Sagar");
//			cus2.setLocation("Hydrabad");
//			
//			Order o1 = new Order();
//			o1.setQuantity(2);
//			o1.setDate(LocalDate.now());
//			o1.setCustomer(cus1);
//			
//			Order o2 = new Order();
//			o2.setQuantity(4);
//			o2.setDate(LocalDate.now());
//			o2.setCustomer(cus1);
//			
//			Order o3 = new Order();
//			o3.setQuantity(6);
//			o3.setDate(LocalDate.now());
//			o3.setCustomer(cus2);
//			
//			cus1.setOrders(List.of(o1,o2));
//			cus2.setOrders(List.of(o3));
//			
//			cr.save(cus1);
//			cr.save(cus2);
//			
//		};
//	}
	
	@Bean
	CommandLineRunner c(PersonRepo pr) {
		return arg->{
			
			Person person = new Person();
			person.setPersonName("Reddy");
			
			Passport passport = new Passport();
			passport.setPassportNumber(14442);
			passport.setIssueDate("19-09-2024");
			
			passport.setPerson(person);
			
			person.setPassport(passport);
			
			pr.save(person);
		};
	}
	
	
}
