package com.niit.DevOpsShoppingBackendTestCases;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.DevOpsShoppingBackend.Model.User;

public class UserTest1 {

	public static void main(String args[])
	{
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext();
			ctx.scan("com.niit.*");
			ctx.refresh();
			
//			User user= (User)ctx.getBean(user);
			
	}
}
