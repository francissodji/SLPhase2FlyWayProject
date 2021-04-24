package com.dao;

import java.util.List;

import com.beans.Destination;

public interface DestinationDao {

	public Integer addDestination(Destination destination);
	
	public List<Destination> listAllDestinatin();
}
