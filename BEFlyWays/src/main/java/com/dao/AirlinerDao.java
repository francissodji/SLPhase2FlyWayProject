package com.dao;

import java.util.List;

import com.beans.Airliner;

public interface AirlinerDao {

	public Integer addAirliner(Airliner airliner);
	
	public void UpdateAirliner(Integer idAireliner, String designation);
	

	public List<Airliner> listAllAirliners();
}
