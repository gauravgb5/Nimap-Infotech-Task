package com.RestApi.Products.and.Categore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {
	
	@Id
	int id;
	String name;
	double price;
	
	@ManyToOne
	@JoinColumn(name="categore_id")
	Categore categore;

	public Products() {
		super();
	}

	public Products(int id, String name, double price, Categore categore) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.categore = categore;
	}

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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Categore getCategore() {
		return categore;
	}

	public void setCategore(Categore categore) {
		this.categore = categore;
	}

	@Override
	public String toString() {
		return "Products [id=" + id + ", name=" + name + ", price=" + price + ", categore=" + categore + "]";
	}
}
