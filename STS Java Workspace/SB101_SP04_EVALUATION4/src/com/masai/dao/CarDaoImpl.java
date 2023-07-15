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

public class CarDaoImpl implements CarDao {

	@Override
	public String addCar(Car car) {
		String msg = "Data Not Inserted... ";
		
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("insert into car values(?,?,?,?,?)");
			ps.setString(1, car.getCarId());
			ps.setString(2, car.getModelName());
			ps.setInt(3, car.getPrice());
			ps.setInt(4, car.getTotalSeats());
			ps.setString(5, car.getCompanyId());
			
			int x = ps.executeUpdate();
			
			if(x>0)
				msg = "Data Sucessfully Inserted...";
				
			
		} catch (SQLException e) {
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public List<FullCarDetails> getFullCarDetails() {
		List<FullCarDetails> carList = new ArrayList<>();
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select * from car c INNER JOIN company co ON c.company_id = co.company_id");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				FullCarDetails car = new FullCarDetails();
				
				car.setCarId(rs.getString("car_id"));
				car.setModelName(rs.getString("model_name"));
				car.setPrice(rs.getInt("price"));
				car.setTotalSeats(rs.getInt("total_seats"));
				car.setCompanyName(rs.getString("company_name"));
				car.setTurnover(rs.getInt("turnover_in_crores"));
				
				carList.add(car);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return carList;
	}

	@Override
	public String updateCarDetailsWithCarId(Car car) {
		String msg = "Data Not Updated...";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("update car set  model_name =?, price=?, total_seats=?, company_id=? where car_id = ?");
			
			ps.setString(1, car.getModelName());
			ps.setInt(2, car.getPrice());
			ps.setInt(3, car.getTotalSeats());
			ps.setString(4, car.getCompanyId());
			ps.setString(5, car.getCarId());
			
			int x = ps.executeUpdate();
			if(x>0)
				msg = "Data Sucessfully Updated...";
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
		
		
		return msg;
	}

	@Override
	public String deleteCarDetailsUsingCarId(String id) {
		String msg = "Data Not Deleted...";
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("delete from car where car_id = ?");
			ps.setString(1, id);
			int x = ps.executeUpdate();
			
			if(x>0) {
				msg = "Car "+id+" Data Sucessfully Deleted";
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			msg = e.getMessage();
		}
		
		
		
		return msg;
		
	}

	@Override
	public Map<String, Integer> getCompanyNameWithModelCount() {
		Map<String, Integer> map = new HashMap<>();
		
		
		try(Connection con = DBUtil.provideConnection()) {
			
			PreparedStatement ps = con.prepareStatement("select co.company_name,COUNT(c.company_id) from company co LEFT JOIN car c ON co.company_id = c.company_id GROUP BY co.company_name");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				map.put(rs.getString(1), rs.getInt(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return map;
	}

}
