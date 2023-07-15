package com.masai.problem4;

import java.io.Serializable;
import java.util.Objects;

public class BallOfOver implements Serializable {
	private int run;
	private char isFairDelivery;
	public BallOfOver(int run, char isFairDelivery) {
		super();
		this.run = run;
		this.isFairDelivery = isFairDelivery;
	}
	public int getRun() {
		return run;
	}
	public void setRun(int run) {
		this.run = run;
	}
	public char getIsFairDelivery() {
		return isFairDelivery;
	}
	public void setIsFairDelivery(char isFairDelivery) {
		this.isFairDelivery = isFairDelivery;
	}
	@Override
	public String toString() {
		return "BallOfOver [run=" + run + ", isFairDelivery=" + isFairDelivery + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(isFairDelivery, run);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BallOfOver other = (BallOfOver) obj;
		return isFairDelivery == other.isFairDelivery && run == other.run;
	}
	
	
}
