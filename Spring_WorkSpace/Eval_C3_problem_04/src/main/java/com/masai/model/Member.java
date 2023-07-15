package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;// (primary key)
	private String name;
	private int age;
	private String email;
	private String mobile;
	private String fitness_goal;
	private int current_fitness_level;
	private String medical_conditions;
	@OneToOne
	private int workout_plan_id;// (foreign key)

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFitness_goal() {
		return fitness_goal;
	}

	public void setFitness_goal(String fitness_goal) {
		this.fitness_goal = fitness_goal;
	}

	public int getCurrent_fitness_level() {
		return current_fitness_level;
	}

	public void setCurrent_fitness_level(int current_fitness_level) {
		this.current_fitness_level = current_fitness_level;
	}

	public String getMedical_conditions() {
		return medical_conditions;
	}

	public void setMedical_conditions(String medical_conditions) {
		this.medical_conditions = medical_conditions;
	}

	public int getWorkout_plan_id() {
		return workout_plan_id;
	}

	public void setWorkout_plan_id(int workout_plan_id) {
		this.workout_plan_id = workout_plan_id;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", age=" + age + ", email=" + email + ", mobile=" + mobile
				+ ", fitness_goal=" + fitness_goal + ", current_fitness_level=" + current_fitness_level
				+ ", medical_conditions=" + medical_conditions + ", workout_plan_id=" + workout_plan_id + "]";
	}

}