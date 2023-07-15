package com.masai.usecases;

import java.util.Map;

import com.masai.dao.CarDao;
import com.masai.dao.CarDaoImpl;

public class GetCompanyNameWithModelCount {

	public static void main(String[] args) {
		
		
		CarDao dao = new CarDaoImpl();
		
		Map<String ,Integer> map = dao.getCompanyNameWithModelCount();
		
		for(Map.Entry<String,Integer> set : map.entrySet()) {
			System.out.println(set.getKey() +" --- " + set.getValue() );
		}
	}
}
