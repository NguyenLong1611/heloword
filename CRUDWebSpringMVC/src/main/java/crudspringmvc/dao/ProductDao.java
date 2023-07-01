package crudspringmvc.dao;

import java.util.List;

import crudspringmvc.entities.Product;

public interface ProductDao {
	public List<Product> getAll();
	 public boolean create(Product product);
	 public Product find(Integer  productId);
	 public boolean delete(Integer  productId);
	 public boolean update(Product product);
	 
}
