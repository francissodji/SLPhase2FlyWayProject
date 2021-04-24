package com.beans;

import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;


@Entity
@Table(name="Flight")
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="idFlight")
	private int idFlight;
	
	@Column(name="numFlight")
	private String numFlight;
	
	@Column(name="dateFligth")
	private java.sql.Timestamp dateFligth;
	
	@Column(name="totPassengFligth")
	private int totPassengFligth;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idAirliner", foreignKey=@ForeignKey(name="airliner_id_foreign"))
	private Airliner airliner;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idSource", foreignKey=@ForeignKey(name="source_id_foreign"))
	private Source source;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idDestination", foreignKey=@ForeignKey(name="destination_id_foreign"))
	private Destination destination;
	
	
	@ManyToMany(targetEntity= Ticket.class, cascade= { CascadeType.ALL})
	@JoinTable(name="Autorize",joinColumns = { @JoinColumn(name = "idFlight") }, 
			inverseJoinColumns = { @JoinColumn(name = "idTicket") })
	private Set<Ticket> ticket;
	
	
	@ManyToMany(targetEntity= Ticket.class, cascade= { CascadeType.ALL})
	@JoinTable(name="Contain",joinColumns = { @JoinColumn(name = "idFlight") }, 
			inverseJoinColumns = { @JoinColumn(name = "idPerson") })
	private Set<Person> person;
	
	
	public Flight() {}

	
	


	public Flight(String numFlight, Timestamp dateFligth, int totPassengFligth) {
		
		this.numFlight = numFlight;
		this.dateFligth = dateFligth;
		this.totPassengFligth = totPassengFligth;
	}



	public String getNumFlight() {
		return numFlight;
	}



	public void setNumFlight(String numFlight) {
		this.numFlight = numFlight;
	}



	public java.sql.Timestamp getDateFligth() {
		return dateFligth;
	}



	public void setDateFligth(java.sql.Timestamp dateFligth) {
		this.dateFligth = dateFligth;
	}



	public int getTotPassengFligth() {
		return totPassengFligth;
	}


	public void setTotPassengFligth(int totPassengFligth) {
		this.totPassengFligth = totPassengFligth;
	}

	

	public Airliner getAirliner() {
		return airliner;
	}


	public void setAirliner(Airliner airliner) {
		this.airliner = airliner;
	}



	public Source getSource() {
		return source;
	}


	public void setSource(Source source) {
		this.source = source;
	}



	public Destination getDestination() {
		return destination;
	}


	public void setDestination(Destination destination) {
		this.destination = destination;
	}



	public Set<Ticket> getTicket() {
		return ticket;
	}


	public void setTicket(Set<Ticket> ticket) {
		this.ticket = ticket;
	}



	public Set<Person> getPerson() {
		return person;
	}


	public void setPerson(Set<Person> person) {
		this.person = person;
	}



	@Override
	public String toString() {
		return "Flight [numFlight=" + numFlight + ", dateFligth=" + dateFligth + ", totPassengFligth="
				+ totPassengFligth + ", airliner=" + airliner + ", source=" + source + ", destination=" + destination
				+ ", ticket=" + ticket + ", person=" + person + "]";
	}
	
	

}
