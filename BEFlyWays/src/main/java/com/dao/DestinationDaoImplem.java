package com.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.beans.Destination;
import com.beans.Source;

public class DestinationDaoImplem implements DestinationDao{

	
	private SessionFactory factory;
	
	
    public DestinationDaoImplem() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        factory = meta.getSessionFactoryBuilder().build();
    }
    
    
	@Override
	public Integer addDestination(Destination destination) {
		Integer idDestination = null;
		try {
			Session session = factory.openSession();
			Transaction trans = session.beginTransaction();
			
			idDestination = (Integer)session.save(destination);
			
			trans.commit();
			session.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return idDestination;
	}

	@Override
	public List<Destination> listAllDestinatin() {
		
		List<Destination> allDestination= null;
		
		Session session = factory.openSession();
    	Transaction txn = session.beginTransaction();
    	
    	String hql = "FROM Destination";
    	@SuppressWarnings("unchecked")
		TypedQuery<Destination> query = session.createQuery(hql);
    	
    	allDestination = query.getResultList();
    	session.close();
    	
    	return allDestination;
	}

}
