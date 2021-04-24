package com.general;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class FactoryTransactionManager {

	
	StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
    Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
    SessionFactory factory = meta.getSessionFactoryBuilder().build(); 
	
    public SessionFactory getSessionFactory()
    {
    	
    	
        Session sessionUser = factory.openSession();
		Transaction txn = sessionUser.beginTransaction();
		 
    	return factory;
    }
    
}
