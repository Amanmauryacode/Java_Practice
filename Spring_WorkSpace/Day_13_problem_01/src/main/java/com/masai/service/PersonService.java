package com.masai.service;

import java.util.List;
import java.util.Map;

import com.masai.model.Person;
import com.masai.model.Skill;

public class PersonService {
	// Hint: Make use of Setter Injection to inject skillMap and personList.

	private Map<Person, Skill> skillMap; // inject 3 entries with valid details 
	private List<Person> personList; // inject List of 5 Person object

	public void setSkillMap(Map<Person, Skill> skillMap) {
		this.skillMap = skillMap;
	}

	public void setPersonList(List<Person> personList) {
		this.personList = personList;
	}

	public void printSkillMap() {
		// print all the person's and their skill details from the skillMap
		
		for(Map.Entry<Person, Skill> set : skillMap.entrySet()) {
			System.out.println(set.getKey()+"\n"+set.getValue());
		}
	}

	public void printPersonList() {
		// sort the List of Person according to the increasing order of the age
		// print all the sorted Person Details
		
		personList.sort((a,b)->a.getAge()-b.getAge());
		personList.forEach(System.out::println);
	}
}
