package com.beans;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Destination")
public class Destination {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="idDestination")
	private int idDestination;
	
	@Column(name="designDestination")
	private String designDestination;
	
	
	public Destination() {}


	public Destination(String designDestination) {

		this.designDestination = designDestination;
	}


	public int getIdDestination() {
		return idDestination;
	}


	public void setIdDestination(int idDestination) {
		this.idDestination = idDestination;
	}


	public String getDesignDestination() {
		return designDestination;
	}


	public void setDesignDestination(String designDestination) {
		this.designDestination = designDestination;
	}


	@Override
	public String toString() {
		return "Destination [idDestination=" + idDestination + ", designDestination=" + designDestination + "]";
	}
	
}
