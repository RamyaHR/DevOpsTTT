package com.niit.DevOpsShoppingBackend.DaoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;


import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Model.Category;
import com.niit.DevOpsShoppingBackend.Model.Supplier;


@Repository("supplierDao")
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
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.save(supplier);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean updateSupp(Supplier supplier) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		session.update(supplier);
		session.getTransaction().commit();
		return true;
	}

	@Override
	public boolean deleteSupp(String supId) {
		Session session=sessionFactory.openSession();
		session.beginTransaction();
		Supplier sup=(Supplier) session.get(Supplier.class, supId);
		session.delete(sup);
		return true;
	}
	
	@Override
		public Supplier getSupp(String supId) {

		Session session= sessionFactory.openSession();
		Supplier supplier=null;
		try
		{
			session.beginTransaction();
			supplier=session.get(Supplier.class, supId);
			session.getTransaction().commit();
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return supplier;
		}
	
@Override
public List<Supplier> list() {
	Session session= sessionFactory.openSession();
	session.beginTransaction();
	List<Supplier> suplist= session.createQuery("from Supplier").list();
	session.getTransaction().commit();
	return suplist;
	}


}
