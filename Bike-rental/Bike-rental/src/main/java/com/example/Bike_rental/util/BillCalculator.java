package com.example.Bike_rental.util;

public class BillCalculator {
	
	public static double calculate(int days, boolean sunday, boolean late)
	{
		double total=days*500;
		
		if(sunday)
		{
			total+=100;
		}
		
		if(late)
		{
			total+=100;
		}
		
		double gst=total*0.05;
		
		total+=gst;
		
		total=Math.ceil((total*2)/2.0);
		
		return total;
	}

}
