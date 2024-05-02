package com.RestApi.Products.and.Categore;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categore {
	
	@Id
	int id;
	String name;
	
	@OneToMany(mappedBy = "categore", cascade = CascadeType.ALL)
	List<Products> products;

	public Categore() {
		super();
	}

	public Categore(int id, String name, List<Products> products) {
		super();
		this.id = id;
		this.name = name;
		this.products = products;
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

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Categore [id=" + id + ", name=" + name + ", products=" + products + "]";
	}
}
