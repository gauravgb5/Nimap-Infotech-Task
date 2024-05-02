package com.RestApi.Products.and.Categore;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping
public class ProductController {
	
	@Autowired
	SessionFactory sf;
	
	@GetMapping("products")
	public List<Products> multipleProducts(){
		Session ss=sf.openSession();
		Query query=ss.createQuery("from Products");
		List<Products> list=query.list();
		for (Products products : list) {
			System.out.println(products.getId()+" "+products.getName()+" "+products.getPrice());
		}
		return list;
	}
	
	@PostMapping("products")
	public Products insertProducts(@RequestBody Products products) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(products);
		tx.commit();
		return products;
	}
	
	@GetMapping("products/{id}")
	public Products getProduct(@PathVariable int id) {
		Session ss=sf.openSession();
		Products p=ss.get(Products.class, id);
		System.out.println(p);
		return p;
	}
	
	@PutMapping("products/{id}")
	public Products updateProduct(@PathVariable int id, @RequestParam("name") String name) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		Products p=ss.get(Products.class, id);
		p.setName(name);
		ss.update(p);
		tx.commit();
		return p;
	}
	
	@DeleteMapping("products/{id}")
	public Products deleteProduct(@PathVariable int id) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		Products p=ss.get(Products.class, id);
		ss.delete(p);
		tx.commit();
		return p;
	}
}










