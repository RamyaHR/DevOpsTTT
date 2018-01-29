package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Model.Supplier;


@Repository
@EnableTransactionManagement
@Transactional
public class SupplierDaoImpl implements SupplierDao {

	@Autowired
	SessionFactory sessionFactory;

	public SupplierDaoImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
		
	}
	@Override
	public boolean insertSupp(Supplier supplier) {
		sessionFactory.getCurrentSession().save(supplier);
		return true;
	}

	@Override
	public boolean updateSupp(Supplier supplier) {
		sessionFactory.getCurrentSession().update(supplier);
		return true;
	}

	@Override
	public boolean deleteSupp(Supplier supplier) {
		sessionFactory.getCurrentSession().delete(supplier);
		return true;
		
	}
	
public Supplier getSupp(String supId) {
		
		String c1="from Supplier where supId='"+supId+"'";
		Query q1=sessionFactory.getCurrentSession().createQuery(c1);
		List<Supplier> list=(List<Supplier>) q1.list();
		if(list==null|| list.isEmpty())
		{
		return null;}
		else {
			return list.get(0);
		}
		}

}
