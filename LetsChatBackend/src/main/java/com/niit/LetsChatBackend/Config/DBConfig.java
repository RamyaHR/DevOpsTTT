package com.niit.LetsChatBackend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.niit.LetsChatBackend.Dao.BlogDao;
import com.niit.LetsChatBackend.Dao.ForumDao;
import com.niit.LetsChatBackend.Dao.JobDao;
import com.niit.LetsChatBackend.Dao.UserDao;
import com.niit.LetsChatBackend.DaoImpl.BlogDaoImpl;
import com.niit.LetsChatBackend.DaoImpl.ForumDaoImpl;
import com.niit.LetsChatBackend.DaoImpl.JobDaoImpl;
import com.niit.LetsChatBackend.DaoImpl.UserDaoImpl;
import com.niit.LetsChatBackend.model.Blog;
import com.niit.LetsChatBackend.model.Forum;
import com.niit.LetsChatBackend.model.Job;
import com.niit.LetsChatBackend.model.User;

@Configuration
@ComponentScan("com.niit.*")
@EnableTransactionManagement
public class DBConfig {

	//1.Data Source Object
	@Bean(name="dataSource")
	public DataSource getDataSource()
	{
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("System");
		dataSource.setPassword("password");
		return dataSource;
	}
	
	//2. Create SessionFactory Bean
	
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateProp= new Properties();
		hibernateProp.put("hibernate.hbm2ddl.auto", "update");
		hibernateProp.put("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		LocalSessionFactoryBuilder sessionFactoryBuilder= new LocalSessionFactoryBuilder(getDataSource());
		sessionFactoryBuilder.addProperties(hibernateProp);
		sessionFactoryBuilder.addAnnotatedClass(Blog.class);
		sessionFactoryBuilder.addAnnotatedClass(Forum.class);
		sessionFactoryBuilder.addAnnotatedClass(Job.class);
		sessionFactoryBuilder.addAnnotatedClass(User.class);
		SessionFactory sessionFactory= sessionFactoryBuilder.buildSessionFactory();
		System.out.println("----------------SessionFactory-------------");
		return sessionFactory;
		
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean
	public BlogDao getBlogDao(SessionFactory sessionFactory)
	{
		System.out.println("Blog Dao object created");
		return new BlogDaoImpl(sessionFactory);
	}
	
	@Bean
	public ForumDao getForumDao(SessionFactory sessionFactory)
	{
		System.out.println("Forum Dao object created");
		return new ForumDaoImpl(sessionFactory);
	}
	
	@Bean
	public JobDao getJobDao(SessionFactory sessionFactory)
	{
		System.out.println("Job Dao object created");
		return new JobDaoImpl(sessionFactory);
	}
	
	@Bean
	public UserDao getUserDao(SessionFactory sessionFactory)
	{
		System.out.println("User Dao object created");
		return new UserDaoImpl(sessionFactory);
	}
	
}
