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

import com.beans.Airliner;
import com.beans.Source;

public class SourceDaoImplem implements SourceDao{

	
	private SessionFactory factory;
	
	
    public SourceDaoImplem() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        factory = meta.getSessionFactoryBuilder().build();
    }
    
	@Override
	public Integer addSource(Source source) {
		Integer idSource = null;
		try {
			Session session = factory.openSession();
			Transaction trans = session.beginTransaction();
			
			idSource = (Integer)session.save(source);
			
			trans.commit();
			session.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return idSource;
	}

	@Override
	public List<Source> listOfAllSource() {
		List<Source> allSource= null;
		
		Session session = factory.openSession();
    	Transaction txn = session.beginTransaction();
    	
    	String hql = "FROM Source";
    	TypedQuery<Source> query = session.createQuery(hql);
    	
    	allSource = query.getResultList();
    	session.close();
    	
    	return allSource;
	}

}
