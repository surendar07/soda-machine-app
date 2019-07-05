package com.sodamachine.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * The persistent class for the coin_history database table.
 * 
 */
/**
 * @author suren
 *
 */
@Entity
public class CoinHistory implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date;

	
	private String operation;

	//bi-directional many-to-one association to Coin
	
	@ManyToOne(fetch = FetchType.LAZY, targetEntity = Coin_Type.class)
	@JoinColumn(name = "coin_type", insertable = false, updatable = false)
	private Coin_Type coin;

	
	
	public CoinHistory() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getOperation() {
		return this.operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public Coin_Type getCoin() {
		return this.coin;
	}

	public void setCoin(Coin_Type coin) {
		this.coin = coin;
	}

	

}