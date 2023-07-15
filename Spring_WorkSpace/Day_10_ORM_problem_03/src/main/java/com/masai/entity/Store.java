package com.masai.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Store {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "store_ID")
	private int store_id;
	private String store_name;
	private String location;

	@ManyToMany
	@JoinTable(name ="Store_Buyer",
			joinColumns = @JoinColumn(name = "store_ID"),
			inverseJoinColumns = @JoinColumn(name = "buyer_id")
			)
	private List<Buyer> buyerList = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "seller_ID")
	private Seller seller;

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public List<Buyer> getBuyerList() {
		return buyerList;
	}

	public void setBuyerList(List<Buyer> buyerList) {
		this.buyerList = buyerList;
	}

	@Override
	public String toString() {
		return "Store [store_id=" + store_id + ", store_name=" + store_name + ", location=" + location + "]";
	}

	
}
