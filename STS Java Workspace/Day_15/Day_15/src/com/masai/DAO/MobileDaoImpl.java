package com.masai.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.Bean.Mobile;
import com.masai.Util.DBUtil;

public class MobileDaoImpl implements MobileDao{

	@Override
	public String AddMobile(Mobile mobile) {
		
		String message = "Not Added....!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("insert into mobile values(?,?,?,?,?)");
			ps.setInt(1, mobile.getId());
			ps.setString(2, mobile.getModel_no());
			ps.setString(3, mobile.getCompany());
			ps.setInt(4, mobile.getPrice());
			ps.setDate(5, Date.valueOf(mobile.getMFGdate()));
			int row = ps.executeUpdate();
			
			if(row > 0) 
				message = "Mobile Added Successfully";
		} catch (SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
			
		return message;
	}

	@Override
	public String UpdateMobileDetails(Mobile mobile) {
		
		String message = "Not Updated....!";
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE MOBILE SET company=? , price =? , MFGdate=? WHERE id = ?");
			
			ps.setString(1, mobile.getCompany());
			ps.setInt(2, mobile.getPrice());
			ps.setDate(3, Date.valueOf(mobile.getMFGdate()));
			ps.setInt(4, mobile.getId());
			
			int row = ps.executeUpdate();
			
			if(row > 0) 
				message = "Mobile Updated Successfully";
	
			
		} catch (SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
			
		return message;
	}

	@Override
	public String deleteMobile(int id) {
		
		String message = "Not Deleted....!";
		
try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("DELETE FROM MOBILE WHERE id = ?");
			
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if(row > 0) 
				message =  "Mobile Deleted Successfully";
		} catch (SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}

	@Override
	public List<Mobile> viewAll() {
		
		List<Mobile> mobile = new ArrayList<>();
		
		try (Connection conn = DBUtil.provideConnection()){
			
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM MOBILE");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				int r = rs.getInt("id");
				String n = rs.getString("model_no");
				String a = rs.getString("company");
				int m = rs.getInt("price");
				LocalDate d = LocalDate.parse(rs.getString("MFGdate"));
				
				Mobile mob = new Mobile(r,n,a,m,d);
			}
			
		} catch (SQLException e) {
			e.getMessage();
		}
		
		
		return mobile;
	}
	
	
	
}
