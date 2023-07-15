package com.masai.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Session {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;// (primary key)
	private String session_duration;
	private int date;
	private int time;
	@Override
	public String toString() {
		return "Session [id=" + id + ", session_duration=" + session_duration + ", date=" + date + ", time=" + time
				+ ", trainer_id=" + trainer_id + ", member_id=" + member_id + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSession_duration() {
		return session_duration;
	}
	public void setSession_duration(String session_duration) {
		this.session_duration = session_duration;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	private int trainer_id;// (foreign key)
	private int member_id;// (foreign key)
}
