package com.example.Bike_rental.service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bike_rental.model.Renter;
import com.example.Bike_rental.repository.BikeRepository;

@Service
public class BikeServiceImpl implements BikeService {
	
	@Autowired
	private BikeRepository repo;
	
	Scanner sc =new Scanner(System.in);

	@Override
	public void addRenter() {
		
		System.out.println("Enter Name: ");
		String name=sc.nextLine();
		
		System.out.println("Enter Address: ");
		String address=sc.nextLine();
		
		System.out.println("Enter License: ");
		String license=sc.nextLine();
		
		System.out.println("Enter Days: ");
		int days=sc.nextInt();
		
		sc.nextLine();
		
		//generateId
		

		LocalDate rentDate=LocalDate.now();
		String first3=name.substring(0,3).toUpperCase();
		String dayMonth=rentDate.format(DateTimeFormatter.ofPattern("ddMM"));
		int seq=repo.getCount()+1;
		
		String sequence=String.format("%03d", seq);
		String uniqueId=first3+dayMonth+sequence;
		
		Renter renter=new Renter(name, address, license, uniqueId, days, rentDate, null, 0, 0, 0);
		
			repo.save(renter);	
				
				
				
		System.out.println("Generated ID: "+uniqueId);
		
	}

	@Override
	public void returnBike() {
		
		sc.nextLine();
		
		System.out.println("Enter Unique ID: ");
		String uniqueId=sc.nextLine();
		
		System.out.println("Enter return time (HH:mm):");
		String time=sc.nextLine();
		LocalTime returnTime=LocalTime.parse(time);
		
		
		System.out.println("Enter days");
		int days=sc.nextInt();
		
		double rentAmount=days*500;
		double sundayExtra=0;
		double lateFee=0;
		
		System.out.println("Sunday included? (yes/no)");
		String sunday=sc.next();
		
		if(sunday.equalsIgnoreCase("yes"))
		{
			sundayExtra=100;
		}
		
		if(returnTime.isAfter(LocalTime.of(20, 0)))
		{
			lateFee=120;
		}
		
		double subtotal=rentAmount+sundayExtra+lateFee;
		
		double gst=subtotal*0.05;
		double total=subtotal+gst;
		
		repo.updateReturn(uniqueId, sundayExtra, lateFee, total, returnTime);
		
		System.out.println("\n=========BILL=========");
		System.out.println("Daily rent is 500");
		System.out.println("Days: "+days);
		System.out.println("Sunday Extra: "+ sundayExtra);
		System.out.println("Late Fee: "+lateFee);
		System.out.println("GST"+ gst);
		System.out.println("--------------------------");
		System.out.println("Grand Total: "+ total);
		
		
		
	}

	@Override
	public void dailyReport() {
		System.out.println("\n----Daily Report-----");
		repo.getDailyReport();
		
	}

	@Override
	public void monthlyReport() {
		System.out.println("\n------Monthly Report");
		repo.getMonthlyReport();
		
	}

}
