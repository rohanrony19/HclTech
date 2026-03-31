package com.example.Bike_rental.repository;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.Bike_rental.model.Renter;

@Repository
public class BikeRepository {
	
	@Autowired
	private  JdbcTemplate jdbcTemplate;
	
	
	
	public void save(Renter renter)
	{

		String sql1="insert into renter(name,address,licence,unique_number,days,rent_date) values(?,?,?,?,?,?)";
		
	jdbcTemplate.update(sql1, renter.getName(),renter.getAddress(),renter.getLicense(),renter.getUniqueNumber(),renter.getDays(),renter.getRentDate());
	}
	
	
	public void updateReturn(String uniqueNumber,double sundayExtra,double lateFee,double total,
	 LocalTime returntime)
{
		String sql="update renter set sunday_extra=?, late_fee=?,total=?,return_time=? where unique_number=?";
				jdbcTemplate.update(sql, sundayExtra,lateFee,total,returntime,uniqueNumber);
	
}
	
	public int getCount()
	{
		String sql="select count(*) from renter";
		return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	
	public void getDailyReport()
	{
		String sql="select * from renter where rent_date=current_date";
		
	
		jdbcTemplate.query(sql, (rs)->{
			
			System.out.println(rs.getInt("id")+"|"+rs.getString("name")+"|"+ rs.getString("unique_number")+"|"+rs.getDouble("total"));
			
			
			
		});
	}

	
	public void getMonthlyReport()
	{
		
		
		String sql1="select * from renter where extract(month from rent_date)=extract(month from current_date)";
		
		
jdbcTemplate.query(sql1, (rs)->{
			
			System.out.println(rs.getInt("id")+"|"+rs.getString("name")+"|"+ rs.getString("unique_number")+"|"+rs.getDouble("total"));
			
			
			
		});
	}
}
	
	

