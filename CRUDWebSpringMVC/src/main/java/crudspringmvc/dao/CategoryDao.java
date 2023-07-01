package crudspringmvc.dao;

import java.util.List;

import crudspringmvc.entities.Category;

public interface CategoryDao {
 public List<Category> getAll();
 public boolean create(Category category);
 public Category find(Integer  categoryId);
 public boolean delete(Integer  categoryId);
 public boolean update(Category category);
 
}
