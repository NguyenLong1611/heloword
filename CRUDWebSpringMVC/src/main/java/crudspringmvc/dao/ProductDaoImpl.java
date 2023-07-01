package crudspringmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import crudspringmvc.entities.Product;
@Repository
public class ProductDaoImpl implements ProductDao {
   @Autowired
   private SessionFactory sessionFactory;
	@Override
	public List<Product> getAll() {
		Session session = sessionFactory.openSession();
		try {
			List list = session.createQuery("from Product").list();
			return list;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public boolean create(Product product) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(product);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.getTransaction().rollback();
		} 
		finally {
			session.close();
		}
		
		return false;
	}

	@Override
	public Product find(Integer productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer productId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

}
