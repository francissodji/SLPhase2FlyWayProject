package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


import com.beans.User;

public class UserDaoImplem implements UserDao {
	

private SessionFactory factory;
    
    
    public UserDaoImplem() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        factory = meta.getSessionFactoryBuilder().build();
    }
    
    


	public Integer addUser(User user) {
		Integer IdUser = null;
		try {
			Session session = factory.openSession();
			Transaction trans = session.beginTransaction();
			
			IdUser = (Integer)session.save(user);
			
			trans.commit();
			session.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return IdUser;
	}


	public void updateUserName(Integer userId, String userName) {
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		//1. fetch the object of specific emoployeeID - select query to be executed
    	User user = session.get(User.class, userId);
    	
    	
    	//2. Modify classes designation
    	user.setUserName(userName);
    	
    	//3. send the object back
    	session.update(user);
		
	}


	public void updateUserPassword(Integer userId, String passWord) {
		
		try {
			Session session = factory.openSession();
			Transaction trans = session.beginTransaction();
			
			//1. fetch the object of specific emoployeeID - select query to be executed
	    	User user = session.get(User.class, userId);
	    	
	    	
	    	//2. Modify classes designation
	    	user.setUserName(passWord);
	    	
	    	//3. send the object back
	    	session.update(user);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public boolean validateAuthentication(String userName, String passPord)
	{
		boolean isCredentialValid = false;
		
		Transaction trans = null;
		try {
			
			Session session = factory.openSession();
			trans = session.beginTransaction();
			

			User aUser = (User)session.createQuery("FROM User U WHERE U.userName = :userName").setParameter("userName", userName).uniqueResult();
			
			
			if(aUser != null && aUser.getPassWord().equals(passPord))
			{
				isCredentialValid = true;
			}
			
			trans.commit();
			session.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
			trans.rollback();
		}
		
		return isCredentialValid;
	}




	@Override
	public Integer getIdUser(String userName) {
		Integer theIdUser = null;
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		User aUser = (User)session.createQuery("FROM User U WHERE U.userName = :userName").setParameter("userName", userName).uniqueResult();
		
		theIdUser = aUser.getIdUser();
		
		trans.commit();
		session.close();
		
		return theIdUser;
	}
}
