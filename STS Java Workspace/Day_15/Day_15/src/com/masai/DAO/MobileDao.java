package com.masai.DAO;

import java.util.List;

import com.masai.Bean.Mobile;

public interface MobileDao {
	
	public String AddMobile(Mobile mobile);
	
	public String UpdateMobileDetails(Mobile mobile);
	
	public String deleteMobile(int id);
	
	public List<Mobile> viewAll();
	
}
