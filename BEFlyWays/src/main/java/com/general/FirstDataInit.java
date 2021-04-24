package com.general;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.beans.*;
import com.dao.*;


public class FirstDataInit {

	public static void main(String[] args) {
		
		//Scanner userScann = new Scanner(System.in);
		
		 StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
	     Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  
	     SessionFactory factory = meta.getSessionFactoryBuilder().build(); 
	     
	     
	     //Class


	     User aUser = new User("ADMIN","PASSWORD");
	     UserDao userDao = new UserDaoImplem();
	     userDao.addUser(aUser);
	     
	     
	     //******************************
	     //Add Airliner

		 
	     Airliner anAirliner1 = new Airliner("AmericanAirline");
	     Airliner anAirliner2 = new Airliner("UnitedAirline");
	     Airliner anAirliner3 = new Airliner("FederalAirline");
	     
	     AirlinerDao airlinerDao = new AirlinerDaoImplem();
	     airlinerDao.addAirliner(anAirliner1);
	     airlinerDao.addAirliner(anAirliner2);
	     airlinerDao.addAirliner(anAirliner3);
	     
	     
	     //Add Source
	     Source source1 = new Source("Texas");
	     Source source2 = new Source("Paris");
	     Source source3 = new Source("NewYork");
	     
	     SourceDao sourceDao = new SourceDaoImplem();
	     sourceDao.addSource(source1);
	     sourceDao.addSource(source2);
	     sourceDao.addSource(source3);
	     

	     
	     //Add Destination
	     Destination destination1 = new Destination("Texas");
	     Destination destination2 = new Destination("Paris");
	     Destination destination3 = new Destination("NewYork");
	     
	     DestinationDao destinationDao = new DestinationDaoImplem();
	     destinationDao.addDestination(destination1);
	     destinationDao.addDestination(destination2);
	     destinationDao.addDestination(destination3);
	     
	     //Add Tichet
	     Ticket ticket1 = new Ticket("VF5-ECO","Economic class",1200);
	     Ticket ticket2 = new Ticket("WLK-FIR","First Class",2000);
	     
	     TicketDao ticketDao = new TicketDaoImplem();
	     ticketDao.addTicket(ticket1);
	     ticketDao.addTicket(ticket2);

	     //AddFlight
	     
	     DateParser dateParser = new DateParser();
	     
	     Timestamp dateTime1 = dateParser.getRealDateTime("04-21-2021 12:30:00");
	     Timestamp dateTime2 = dateParser.getRealDateTime("04-22-2021 10:30:00");
	     Timestamp dateTime3 = dateParser.getRealDateTime("04-23-2021 12:30:00");
	     
	     System.out.print(dateTime1);
	     
	     Flight flight1 = new Flight("ABC-258T",dateTime1,45);
	     Flight flight2 = new Flight("KLM-485H",dateTime1,50);
	     Flight flight3 = new Flight("BMN-125J",dateTime1,52);
	     Flight flight4 = new Flight("HCR-258C",dateTime2,45);
	     Flight flight5 = new Flight("BLC-278T",dateTime2,64);
	     Flight flight6 = new Flight("YKT-788X",dateTime3,52);
	     
	     		//Attach Airliner
	     Airliner aireliner1 = new Airliner();
	     Airliner aireliner2 = new Airliner();
	     Airliner aireliner3 = new Airliner();
	     
	     aireliner1.setDescriptAirliner("AmericanAirline");
	     aireliner2.setDescriptAirliner("UnitedAirline");
	     aireliner3.setDescriptAirliner("FederalAirline");
			
	     flight1.setAirliner(aireliner1);
	     flight2.setAirliner(aireliner1);
	     flight3.setAirliner(aireliner1);

	     flight4.setAirliner(aireliner2);
	     flight5.setAirliner(aireliner2);
	     
	     flight6.setAirliner(aireliner3);
			
  			//Attach Source
	     Source fligSource1 = new Source();
	     Source fligSource2 = new Source();
	     Source fligSource3 = new Source();
		 
	     fligSource1.setDesignSource("Texas");
	     fligSource2.setDesignSource("Paris");
	     fligSource3.setDesignSource("New York");
		 
	     flight1.setSource(fligSource2);
	     flight2.setSource(fligSource1);
	     flight3.setSource(fligSource1);

	     flight4.setSource(fligSource1);
	     flight5.setSource(fligSource3);
	     
	     flight6.setSource(fligSource3);
	     
	     	//Attach Destination
	     Destination fligDestination1 = new Destination();
	     Destination fligDestination2 = new Destination();
	     Destination fligDestination3 = new Destination();
		 
	     fligDestination3.setDesignDestination("Texas");
	     fligDestination2.setDesignDestination("Paris");
	     fligDestination1.setDesignDestination("New York");
		 
	     flight1.setDestination(fligDestination3);
	     flight2.setDestination(fligDestination2);
	     flight3.setDestination(fligDestination1);

	     flight4.setDestination(fligDestination2);
	     flight5.setDestination(fligDestination2);
	     
	     flight6.setDestination(fligDestination3);
	     

	     //add ticket associate with filete
	     Set<Ticket> ticketinFligh1 = new HashSet<>();
	     ticketinFligh1.add(ticket1);
	     ticketinFligh1.add(ticket2);
	     
	     Set<Ticket> ticketinFligh2 = new HashSet<>();
	     ticketinFligh2.add(ticket1);
	     
	     flight1.setTicket(ticketinFligh1);
	     flight2.setTicket(ticketinFligh2);
	     flight3.setTicket(ticketinFligh1);
	     flight4.setTicket(ticketinFligh1);
	     flight5.setTicket(ticketinFligh2);
	     flight6.setTicket(ticketinFligh1);

	     
	     //Save Fligths
	     Session session = factory.openSession();
		 Transaction txn = session.beginTransaction();
		 
	     session.save(flight1);
		 session.save(flight2);
		 session.save(flight3);
		 session.save(flight4);
		 session.save(flight5);
		 session.save(flight6);

	}

}
