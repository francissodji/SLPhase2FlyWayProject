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

public class AirlinerDaoImplem implements AirlinerDao{

	private SessionFactory factory;
	

	
    public AirlinerDaoImplem() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        factory = meta.getSessionFactoryBuilder().build();
    }
    

    
	@Override
	public Integer addAirliner(Airliner airliner) {
		
		Integer idAirliner = null;
		try {
			Session session = factory.openSession();
			Transaction trans = session.beginTransaction();
			
			idAirliner = (Integer)session.save(airliner);
			
			trans.commit();
			session.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return idAirliner;
	}

	@Override
	public void UpdateAirliner(Integer idAirliner, String designAirliner) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Airliner> listAllAirliners() {
		
		List<Airliner> allAirliner = null;
		
		Session session = factory.openSession();
    	Transaction txn = session.beginTransaction();
    	
    	String hql = "FROM Airliner";
    	
    	@SuppressWarnings("unchecked")
		TypedQuery<Airliner> query = session.createQuery(hql);
    	
    	allAirliner = query.getResultList();
    	
    	session.close();
    	
    	return allAirliner;
	}

}
