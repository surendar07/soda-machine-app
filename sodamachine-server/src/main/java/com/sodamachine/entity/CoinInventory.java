package com.sodamachine.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * The persistent class for the coin_inventory database table.
 * 
 */
/**
 * @author suren
 *
 */
@Entity
public class CoinInventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	
	private int quantity;

	
	@ManyToOne
	@JoinColumn(name="coin_type")
	private Coin_Type coin;
	
	
	public CoinInventory() {
	}
	
	public CoinInventory(int id,Coin_Type coin,int quantity) {
		this.id=id;
        this.coin = coin;
        this.quantity = quantity;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Coin_Type getCoin() {
		return this.coin;
	}

	public void setCoin(Coin_Type coin) {
		this.coin = coin;
	}

	

}