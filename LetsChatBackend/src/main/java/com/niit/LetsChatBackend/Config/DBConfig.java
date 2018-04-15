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
import com.niit.LetsChatBackend.Dao.FriendDao;
import com.niit.LetsChatBackend.Dao.JobDao;
import com.niit.LetsChatBackend.Dao.ProfilePictureDao;
import com.niit.LetsChatBackend.Dao.UserDetailDao;
import com.niit.LetsChatBackend.DaoImpl.BlogDaoImpl;
import com.niit.LetsChatBackend.DaoImpl.ForumDaoImpl;
import com.niit.LetsChatBackend.DaoImpl.FriendDaoImpl;
import com.niit.LetsChatBackend.DaoImpl.JobDaoImpl;
import com.niit.LetsChatBackend.DaoImpl.ProfilePictureDaoImpl;
import com.niit.LetsChatBackend.DaoImpl.UserDetailDaoImpl;
import com.niit.LetsChatBackend.model.ApplyJob;
import com.niit.LetsChatBackend.model.Blog;
import com.niit.LetsChatBackend.model.BlogComment;
import com.niit.LetsChatBackend.model.Forum;
import com.niit.LetsChatBackend.model.ForumComment;
import com.niit.LetsChatBackend.model.Friend;
import com.niit.LetsChatBackend.model.Job;
import com.niit.LetsChatBackend.model.Message;
import com.niit.LetsChatBackend.model.ProfilePicture;
import com.niit.LetsChatBackend.model.UserDetail;

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
		sessionFactoryBuilder.addAnnotatedClass(UserDetail.class);
		sessionFactoryBuilder.addAnnotatedClass(ApplyJob.class);
		sessionFactoryBuilder.addAnnotatedClass(BlogComment.class);
		sessionFactoryBuilder.addAnnotatedClass(ForumComment.class);
		sessionFactoryBuilder.addAnnotatedClass(ProfilePicture.class);
		sessionFactoryBuilder.addAnnotatedClass(Friend.class);
		sessionFactoryBuilder.addAnnotatedClass(Message.class);
				
		SessionFactory sessionFactory= sessionFactoryBuilder.buildSessionFactory();
		System.out.println("----------------SessionFactory-------------");
		return sessionFactory;
		
	}
	
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		return new HibernateTransactionManager(sessionFactory);
	}
	
	@Bean(name="blogDao")
	public BlogDao getBlogDao(SessionFactory sessionFactory)
	{
		System.out.println("Blog Dao object created");
		return new BlogDaoImpl(sessionFactory);
	}
	
	@Bean(name="forumDao")
	public ForumDao getForumDao(SessionFactory sessionFactory)
	{
		System.out.println("Forum Dao object created");
		return new ForumDaoImpl(sessionFactory);
	}
	
	@Bean(name="jobDao")
	public JobDao getJobDao(SessionFactory sessionFactory)
	{
		System.out.println("Job Dao object created");
		return new JobDaoImpl(sessionFactory);
	}
	
	@Bean(name="userDetailDao")
	public UserDetailDao getUserDetailDao(SessionFactory sessionFactory)
	{
		System.out.println("User Dao object created");
		return new UserDetailDaoImpl(sessionFactory);
	}
	
	@Bean(name="profilePictureDao")
	public ProfilePictureDao getProfilePictureDao(SessionFactory sessionFactory)
	{
		System.out.println("ProfilePicture Dao object created");
		return new ProfilePictureDaoImpl(sessionFactory);
	}
	
	@Bean(name="friendDao")
	public FriendDao getFriendDao(SessionFactory sessionFactory)
	{
		System.out.println("Friend Dao object created");
		return new FriendDaoImpl(sessionFactory);
	}
}
