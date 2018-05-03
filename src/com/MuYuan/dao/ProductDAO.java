package com.MuYuan.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.MuYuan.pojo.*;

public class ProductDAO {
	public void add(Product p) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.save(p);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

	public Product get(int id) {
		Product result = null;
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		result = (Product) s.get(Product.class, id);
		s.close();
		sf.close();
		return result;

	}

	public void delete(int id) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		Product p = (Product) s.get(Product.class, id);
		s.delete(p);
		s.getTransaction().commit();
		s.close();
		sf.close();
	}

	public void update(Product p) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		s.beginTransaction();
		s.update(p);
		s.getTransaction().commit();
		s.close();
		sf.close();

	}

	public List<Product> listProduct() {
		List<Product> result = new ArrayList();
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session s = sf.openSession();
		Query q = s.createQuery("from Product p");
		result = q.list();
		s.close();
		sf.close();
		return result;
	}

	public static void main(String[] args) {
		Product p = new Product();
		p.setName("name1");
		p.setPrice(123);
		new ProductDAO().add(p);

	}

}
