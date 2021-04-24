package com.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.beans.Flight;
import com.beans.User;

public class FlightDaoImplem implements FlightDao{

	
	private SessionFactory factory;
	
	
    public FlightDaoImplem() {
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
        factory = meta.getSessionFactoryBuilder().build();
    }
    
    
	@Override
	public Integer addFlight(Flight fligth) {
		Integer idFlight = null;
		try {
			Session session = factory.openSession();
			Transaction trans = session.beginTransaction();
			
			idFlight = (Integer)session.save(fligth);
			
			trans.commit();
			session.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return idFlight;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Flight> listOfAllFligth() {
		
		List<Flight> allListOfFlight = null;
		
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		

		String hql = "FROM flight";
		
		TypedQuery<Flight> query = session.createQuery(hql);
		//Query query = session.createQuery(hql);
		
		
		allListOfFlight = query.getResultList();

			
		return allListOfFlight;
	}


	@Override
	public List<Flight> listOfAllFlightPerDate(Timestamp dateFlight) {
		
		
		List<Flight> allListOfFlight = null;
		
		Session session = factory.openSession();
		Transaction trans = session.beginTransaction();
		
		/*
		String hql = "SELECT F.numFlight, F.dateFligth, F.totPassengFligth, F.airliner, F.source, F.destination "
				+ "FROM flight INNER JOIN Ticket.idTicket as T "
				+ "ORDER BY F.dateFligth";
		*/
		String hql = "FROM flight";
		
		TypedQuery<Flight> query = session.createQuery(hql);
		
		//query.setParameter("dateFligth", dateFlight);
		
		allListOfFlight = query.getResultList();
		

		return allListOfFlight;
	}

}
