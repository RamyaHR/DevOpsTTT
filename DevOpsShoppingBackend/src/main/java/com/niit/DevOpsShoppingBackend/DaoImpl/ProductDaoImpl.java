package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DevOpsShoppingBackend.Dao.ProductDao;
import com.niit.DevOpsShoppingBackend.Model.Product;

@Repository("productDao")
@EnableTransactionManagement
@Transactional
public class ProductDaoImpl implements ProductDao{

	@Autowired
	SessionFactory sessionFactory;

	public ProductDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	
	@Override
	public boolean insertProd(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	@Override
	public boolean updateProd(Product product) {
		sessionFactory.getCurrentSession().update(product);
		return true;
	}

	@Override
	public boolean deleteProd(Product product) {
		sessionFactory.getCurrentSession().save(product);
		return true;
	}

	@Override
	public Product getProd(String prodId) {
		String c1="from Product where prodId='"+prodId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Product> list=(List<Product>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list.get(0);
		}
	}

	@Override
	public List<Product> list() {
		List<Product> product=(List<Product>)sessionFactory.getCurrentSession().createCriteria(Product.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return product;
	}

}
