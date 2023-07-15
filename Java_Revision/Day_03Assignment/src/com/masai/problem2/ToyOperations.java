package com.masai.problem2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToyOperations {

    static Map<String,Toy> toys = new TreeMap<>();
    private void isToyNumberValid(String toyNumber) throws InvalidToyNumberException, ToyCompanyNotFoundException{

        Pattern p = Pattern.compile("[A-Z]{3}[0-9]{3}");
        Matcher m = p.matcher(toyNumber);

        if(!m.matches()){
          throw new InvalidToyNumberException("Invalid toy NUmber");
        }

        String s = toyNumber.substring(0,3);

        if(!CompanyNameCode.companyCode.containsKey(s)){
            throw new ToyCompanyNotFoundException("Company not found");
        }

    }


    public boolean addToy(String toyNumber, String toyName, Double price, String category) throws InvalidToyNumberException, ToyCompanyNotFoundException{

        isToyNumberValid(toyNumber);

        Toy toy = new Toy(toyNumber,toyName,price,category);

        if(toys.containsKey(toyNumber)){
            return false;
        }

        toys.put(toyNumber,toy);

        return true;
    }


	public List<String> getToysListToDisplay() {
		List list = new ArrayList<>(toys.values());
		return list;
	}


	public Toy getToyByToyNumber(String string) {
		
		for(Map.Entry<String,Toy> set : toys.entrySet()) {
			if(set.getKey().equals(string))return set.getValue();
		}
		return null;
	}


	public List<String> getToyListSortedByPrice() {
		
		List<Map.Entry<String,Toy>> list = new LinkedList<>(toys.entrySet());
		
		Collections.sort(list,new Comparator<Map.Entry<String,Toy>>(){

			@Override
			public int compare(Entry<String, Toy> o1, Entry<String, Toy> o2) {
				if(o1.getValue().getPrice() >= o2.getValue().getPrice())
				return 1;
				else return -1;
			}
			
		});
		List<String> list2 = new ArrayList<>();
		
		for (Map.Entry<String, Toy> aa : list) {
			list2.add(aa.getValue().toString());
		}
		return list2;
	}


	public List<String> getToyListForGivenPriceRange(double d, double e) {
		// TODO Auto-generated method stub
		return null;
	}
}
