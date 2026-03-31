package com.example.Bike_rental;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.Bike_rental.service.BikeService;

@SpringBootApplication
public class BikeRentalApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(BikeRentalApplication.class, args);
	}

	@Autowired
	private BikeService service;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Scanner sc=new Scanner(System.in);
		
		while(true)
		{
			System.out.println("\n==========BIKE RENTAL SYSTEM========");
			System.out.println("1.Add Renter");
			System.out.println("2.Return Bike");
			System.out.println("3.Enter 3 for exit");
			System.out.println("4.get daily report");
			System.out.println("5.get monthly report");
			System.out.println("Enter Choice: ");
			
			int choice=sc.nextInt();
			
			switch(choice)
			{
			
			
			case 1:
				service.addRenter();
				break;
			case 2:
				service.returnBike();
				break;
				
			case 3:
				System.out.println("Exiting application...");
				System.exit(0);
				break;
				
			case 4:
				service.dailyReport();
				break;
				
			case 5:
				service.monthlyReport();
				break;
			default:
				
				System.out.println("Invalid choice");
			
			
			}
		}
	}
	

}
