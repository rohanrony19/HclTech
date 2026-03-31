package com.example.Bike_rental.model;

import java.time.LocalDate;

public class Renter {

	private String name;
	private String address;
	private String license;
	private String uniqueNumber;
	private int days;
	private LocalDate rentDate;
	private LocalDate returnTime;
	private double sundayExtra;
	private double lateFee;
	private double total;
	public Renter() {
		
	}
	public Renter( String name, String address, String license, String uniqueNumber, int days,
			LocalDate rentDate, LocalDate returnTime, double sundayExtra, double lateFee, double total) {
		super();
		this.name = name;
		this.address = address;
		this.license = license;
		this.uniqueNumber = uniqueNumber;
		this.days = days;
		this.rentDate = rentDate;
		this.returnTime = returnTime;
		this.sundayExtra = sundayExtra;
		this.lateFee = lateFee;
		this.total = total;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLicense() {
		return license;
	}
	public void setLicense(String license) {
		this.license = license;
	}
	public String getUniqueNumber() {
		return uniqueNumber;
	}
	public void setUniqueNumber(String uniqueNumber) {
		this.uniqueNumber = uniqueNumber;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public LocalDate getRentDate() {
		return rentDate;
	}
	public void setRentDate(LocalDate rentDate) {
		this.rentDate = rentDate;
	}
	public LocalDate getReturnTime() {
		return returnTime;
	}
	public void setReturnTime(LocalDate returnTime) {
		this.returnTime = returnTime;
	}
	public double getSundayExtra() {
		return sundayExtra;
	}
	public void setSundayExtra(double sundayExtra) {
		this.sundayExtra = sundayExtra;
	}
	public double getLateFee() {
		return lateFee;
	}
	public void setLateFee(double lateFee) {
		this.lateFee = lateFee;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
	
	
	
}
