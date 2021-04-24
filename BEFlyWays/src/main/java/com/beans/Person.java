package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Person")
public class Person {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="idPerson")
	private int idPerson;
	
	@Column(name="firstNPerson")
	private String firstNPerson;
	
	@Column(name="middleNPerson")
	private String middleNPerson;
	
	@Column(name="lastNPerson")
	private String lastNPerson;
	
	
	public Person() {}


	public Person(String firstNPerson, String middleNPerson, String lastNPerson) {
		this.firstNPerson = firstNPerson;
		this.middleNPerson = middleNPerson;
		this.lastNPerson = lastNPerson;
	}


	public int getIdPerson() {
		return idPerson;
	}


	public void setIdPerson(int idPerson) {
		this.idPerson = idPerson;
	}


	public String getFirstNPerson() {
		return firstNPerson;
	}


	public void setFirstNPerson(String firstNPerson) {
		this.firstNPerson = firstNPerson;
	}


	public String getMiddleNPerson() {
		return middleNPerson;
	}


	public void setMiddleNPerson(String middleNPerson) {
		this.middleNPerson = middleNPerson;
	}


	public String getLastNPerson() {
		return lastNPerson;
	}


	public void setLastNPerson(String lastNPerson) {
		this.lastNPerson = lastNPerson;
	}


	@Override
	public String toString() {
		return "Person [idPerson=" + idPerson + ", firstNPerson=" + firstNPerson + ", middleNPerson=" + middleNPerson
				+ ", lastNPerson=" + lastNPerson + "]";
	}
	
}
