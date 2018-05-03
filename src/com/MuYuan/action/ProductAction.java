package com.MuYuan.action;
import com.MuYuan.pojo.*;

import java.util.ArrayList;
import java.util.List;

import com.MuYuan.dao.*;


public class ProductAction {
	ProductDAO pdao=new ProductDAO();
	Product product;
	List<Product>products;
	CategoryDAO cdao=new CategoryDAO();
	Category category;
	List<Category>categorys;
	public Product getProduct(){
		return product;
	}
	public void setProduct(Product product){
		this.product=product;
	}
	public List<Product> getProducts(){
		return products;
	}
	public void setProducts(List<Product> products){
		this.products=products;
	}
	public Category getCategory(){
		return category;
	}
	public void setCategory(Category category){
		this.category=category;
	}
	public List<Category> getCategorys(){
		return categorys;
	}
	public void setCategorys(List<Category> categorys){
		this.categorys=categorys;
	}
	public String add(){
		System.out.println(product.getName());
		System.out.println(product.getCategory().getName());
		pdao.add(product);
		return "list";
	}
	public String edit(){
		categorys=cdao.listCategory();
		product=pdao.get(product.getId());
		return "edit";
	}
	public String delete(){
		pdao.delete(product.getId());
		return "list";
		
	}
	public String list(){
		categorys=cdao.listCategory();
		if(null!=category){
			category=cdao.get(category.getId());
			products=new ArrayList(category.getProducts());
					return "listJsp";
		}
		else{
			products=pdao.listProduct();
			return "listJsp";
		}
		
	}
	public String update(){
		pdao.update(product);
		return "list";
	}
	
	
	

}
