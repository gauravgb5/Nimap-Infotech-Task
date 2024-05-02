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
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoreController {
	
	@Autowired
	SessionFactory sf;
	
	@GetMapping("categories")
	public List<Categore> multipleCategories() {
		Session ss=sf.openSession();
		Query query=ss.createQuery("from Categore");
		List<Categore> list=query.list();
		for (Categore categore : list) {
			System.out.println(categore.getId()+" "+categore.getName());
		}
		return list;
	}
	
	@PostMapping("categories")
	public Categore insertCategore(@RequestBody Categore categore) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		ss.save(categore);
		tx.commit();
		return categore;
	}
	
	@GetMapping("categories/{id}")
	public Categore getCategore(@PathVariable int id) {
		Session ss=sf.openSession();
		Categore ct=ss.get(Categore.class, id);
		System.out.println(ct);
		return ct;
	}
	
	
	@PutMapping("categories/{id}")
	public Categore updateCategore(@PathVariable int id, @RequestParam("name") String name) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		Categore ct=ss.get(Categore.class, id);
		ct.setName(name);
		ss.update(ct);
		tx.commit();
		return ct;
	}
	
	@DeleteMapping("categories/{id}")
	public Categore deleteCategore(@PathVariable int id) {
		Session ss=sf.openSession();
		Transaction tx=ss.beginTransaction();
		Categore ct=ss.get(Categore.class, id);
		ss.delete(ct);
		tx.commit();
		return ct;
	}
}
