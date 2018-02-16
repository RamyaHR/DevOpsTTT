package com.niit.DevOpsShoppingBackend.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DevOpsShoppingBackend.Dao.SupplierDao;
import com.niit.DevOpsShoppingBackend.Model.Supplier;


public class SupplierTest {

private static AnnotationConfigApplicationContext context;
	
	private static SupplierDao supplierDao;

	private static Supplier supplier;
	

	@BeforeClass
	public static void setup()
	{
		Supplier supplier= new Supplier();
	}
	
	@AfterClass
	public static void teardown()
	{
		supplier=null;
	}
	
	@BeforeClass
	public static void init()
	{
		context= new AnnotationConfigApplicationContext();
		context.scan("com.niit.DevOpsShoppingBackend.*");
		context.refresh();
		
		supplierDao=(SupplierDao)context.getBean("supplierDao");
	}
	
	//@Test
    public void testInsertUser()
    {
    	supplier= new Supplier();
    	supplier.setSupId("s101");
    	supplier.setSupName("Madhav");
       
        assertEquals("supplier added successfully", true, supplierDao.insertSupp(supplier));
       
        
        supplier.setSupId("s102");
        supplier.setSupName("Keerthana");
        
        assertEquals("supplier added successfully", true, supplierDao.insertSupp(supplier));
       
        
        supplier.setSupId("s103");
        supplier.setSupName("Grishma");
        
       
        assertEquals("supplier added successfully", true, supplierDao.insertSupp(supplier));
       
    }
	
	@Test
	public void testgetSupp()
	{
		supplier= supplierDao.getSupp("s102");
		 assertEquals("Successfully retrieved the supplier", "Keerthana", supplier.getSupName());
	       
	}
	
	@Test
	public void testupdateUser()
	{
		supplier= supplierDao.getSupp("s103");
		supplier.setSupName("Chandhan");
		 assertEquals("Successfully updated the supplier", "Chandhan", supplier.getSupName());
	       
	}
	
	@Test
	public void testdelete()
	{
		supplier= supplierDao.getSupp("s101");
		
		assertEquals("Successfully deleted the supplier", true, supplierDao.deleteSupp(supplier.getSupId()));
		 	       
	}
	

}
