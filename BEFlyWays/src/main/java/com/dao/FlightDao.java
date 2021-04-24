package com.dao;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.beans.Flight;

public interface FlightDao {

	public Integer addFlight (Flight fligth);
	
	public List<Flight> listOfAllFligth();
	
	public List<Flight> listOfAllFlightPerDate(Timestamp dateFlight);
	
}
