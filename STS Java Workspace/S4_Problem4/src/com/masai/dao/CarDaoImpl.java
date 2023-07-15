package com.masai.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.masai.model.Car;
import com.masai.model.FullCarDetails;
import com.masai.utility.DBUtil;

public class CarDaoImpl  implements CarDao{

	@Override
	public String addCarDetails(Car car) {
		String msg = "Data not Inserted...";
		
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into car values(?,?,?,?,?)");
			ps.setString(1, car.getCarId());
			ps.setString(2, car.getModelName());
			ps.setInt(3, car.getPrice());
			ps.setInt(4, car.getTotalSeats());
			ps.setString(5, car.getCompanyID());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				msg = "Data Sucessfully inserted...";
			
			
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg;
	}

	@Override
	public List<FullCarDetails> getFullCarDetails() {
		List<FullCarDetails> carList = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select C.car_Id,C.model_name,C.price,C.total_seats,CO.company_name,CO.turnover_in_crores from car C INNER JOIN company CO ON C.company_Id = CO.company_id");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				FullCarDetails car = new FullCarDetails();
				car.setCarId(rs.getString("car_id"));
				car.setModelName(rs.getString("model_name"));
				car.setPrice(rs.getInt("price"));
				car.setTotalSeats(rs.getInt("total_seats"));

				car.setCompanyName(rs.getString("company_name"));
				car.setTurnover_in_crores(rs.getLong("turnover_in_crores"));
				
				carList.add(car);
			}
			
			
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		return carList;
	}

	@Override
	public String updateCarDetailsByCarID(String carID,String modelName,int price,int seats,String companyID) {
		String msg = "Data Not Updated...";
				
		try(Connection con = DBUtil.provideConnection()) {
			PreparedStatement ps = con.prepareStatement("update car set model_name = ? ,price = ? , total_seats = ?, company_id = ? where car_id = ?");
			
			ps.setString(1, modelName);
			ps.setInt(2, price);
			ps.setInt(3, seats);
			ps.setString(4, companyID);
			ps.setString(5, carID);
			
			int x=  ps.executeUpdate();
			if(x>0)
				msg = "Updated Car Details with Car ID "+carID+" Sucessfully..";
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
				
				
		
		return msg;
	}

	@Override
	public String deleteCarByCarId(String carID) {
		String msg = "Data Not Deleted...";
		
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("delete from car where car_id = ?");
			
			ps.setString(1, carID);
			int x = ps.executeUpdate();
			
			if(x>0)
				msg = "Car ID "+carID +" Sucessfully Deleted...";		
			} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		return msg ;
		
	}

	@Override
	public Map<String, Integer> getCompanyNameWithModelCount() {
		Map<String,Integer> map = new HashMap<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement(" select co.company_name,count(co.company_id) from company co INNER JOIN car c ON co.company_id = c.company_id group By c.company_id");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
			
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return map;
	}

}
