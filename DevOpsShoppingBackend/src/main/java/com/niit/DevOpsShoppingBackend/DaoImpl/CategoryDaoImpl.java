package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.niit.DevOpsShoppingBackend.Dao.CategoryDao;
import com.niit.DevOpsShoppingBackend.Model.Category;

@Repository("categoryDao")
@EnableTransactionManagement
@Transactional

public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	SessionFactory sessionFactory;

	public CategoryDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	
	@Override
	public boolean insertCat(Category category) {
		sessionFactory.getCurrentSession().save(category);
		return true;
	}

	@Override
	public boolean updateCat(Category category) {
		sessionFactory.getCurrentSession().update(category);
		return true;
	}

	@Override
	public boolean deleteCat(Category category) {
		sessionFactory.getCurrentSession().delete(category);
		return true;
		
	}

	@Override
	public Category getCat(String catId) {

		String c1="from Category where catId='"+catId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Category> list=(List<Category>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list.get(0);
	}}
	

	@Override
	public List<Category> list() {
		List<Category> category=(List<Category>)sessionFactory.getCurrentSession().createCriteria(Category.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return category;
	}

}
