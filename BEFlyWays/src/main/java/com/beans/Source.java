package com.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Source")
public class Source {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="idSource")
	private int idSource;
	
	@Column(name="designSource")
	private String designSource;
	
	
	public Source() {}


	public Source(String designSource) {
		
		this.designSource = designSource;
	}


	public int getIdSource() {
		return idSource;
	}


	public void setIdSource(int idSource) {
		this.idSource = idSource;
	}


	public String getDesignSource() {
		return designSource;
	}


	public void setDesignSource(String designSource) {
		this.designSource = designSource;
	}


	@Override
	public String toString() {
		return "Source [idSource=" + idSource + ", designSource=" + designSource + "]";
	}
	
}
