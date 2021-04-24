package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Ticket")
public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="idTicket")
	private int idTicket;
	
	@Column(name="numTicket")
	private String numTicket;
	
	@Column(name="descriptTicket")
	private String descriptTicket;
	
	@Column(name="priceTicket")
	private int priceTicket;
	
	private Ticket() {}

	public Ticket(String numTicket, String descriptTicket, int priceTicket) {
		this.numTicket = numTicket;
		this.descriptTicket = descriptTicket;
		this.priceTicket = priceTicket;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public void setIdTicket(int idTicket) {
		this.idTicket = idTicket;
	}

	public String getNumTicket() {
		return numTicket;
	}

	public void setNumTicket(String numTicket) {
		this.numTicket = numTicket;
	}

	public String getDescriptTicket() {
		return descriptTicket;
	}

	public void setDescriptTicket(String descriptTicket) {
		this.descriptTicket = descriptTicket;
	}

	public int getPriceTicket() {
		return priceTicket;
	}

	public void setPriceTicket(int priceTicket) {
		this.priceTicket = priceTicket;
	}

	@Override
	public String toString() {
		return "Ticket [idTicket=" + idTicket + ", numTicket=" + numTicket + ", descriptTicket=" + descriptTicket
				+ ", priceTicket=" + priceTicket + "]";
	}
	
}
