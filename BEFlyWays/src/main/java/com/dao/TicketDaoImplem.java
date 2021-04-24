package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.beans.Ticket;

public class TicketDaoImplem implements TicketDao{

private SessionFactory factory;
	
	
    public TicketDaoImplem() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        factory = meta.getSessionFactoryBuilder().build();
    }
    
    
	@Override
	public Integer addTicket(Ticket ticket) {
		
		Integer idTicket = null;
		try {
			Session session = factory.openSession();
			Transaction trans = session.beginTransaction();
			
			idTicket = (Integer)session.save(ticket);
			
			trans.commit();
			session.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return idTicket;
	}

}
