package com.dao;

import java.util.List;

import com.beans.Source;

public interface SourceDao {

	public Integer addSource(Source source);
	
	public List<Source> listOfAllSource();
}
