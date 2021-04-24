package com.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Airliner")
public class Airliner {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="idAirliner")
	private int idAirliner;
	
	@Column(name="descriptAirliner")
	private String descriptAirliner;
	
	
	public Airliner() {}


	public Airliner(String descriptAirliner) {

		this.descriptAirliner = descriptAirliner;
	}


	public int getIdAirliner() {
		return idAirliner;
	}


	public void setIdAirliner(int idAirliner) {
		this.idAirliner = idAirliner;
	}


	public String getDescriptAirliner() {
		return descriptAirliner;
	}


	public void setDescriptAirliner(String descriptAirliner) {
		this.descriptAirliner = descriptAirliner;
	}


	@Override
	public String toString() {
		return "Airliner [idAirliner=" + idAirliner + ", descriptAirliner=" + descriptAirliner + "]";
	}
	
	
}
