package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class WorkoutPlan {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;//(primary key)
	private String workout_name;
	private String exercise_type;
	private String intensity;
	private int frequency;
	@Override
	public String toString() {
		return "WorkoutPlan [id=" + id + ", workout_name=" + workout_name + ", exercise_type=" + exercise_type
				+ ", intensity=" + intensity + ", frequency=" + frequency + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getWorkout_name() {
		return workout_name;
	}
	public void setWorkout_name(String workout_name) {
		this.workout_name = workout_name;
	}
	public String getExercise_type() {
		return exercise_type;
	}
	public void setExercise_type(String exercise_type) {
		this.exercise_type = exercise_type;
	}
	public String getIntensity() {
		return intensity;
	}
	public void setIntensity(String intensity) {
		this.intensity = intensity;
	}
	public int getFrequency() {
		return frequency;
	}
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}
}
