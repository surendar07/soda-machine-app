package com.sodamachine.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



/**
 * The persistent class for the soda_inventory database table.
 * 
 */
/**
 * @author suren
 *
 */
@Entity
public class SodaInventory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int qty;

	@ManyToOne
	@JoinColumn(name="soda_type")
	private Soda_Type soda;

	public SodaInventory() {
	}
	public SodaInventory(int id,Soda_Type soda,int quantity) {
		this.id=id;
        this.soda = soda;
        this.qty = quantity;
    }
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public Soda_Type getSoda() {
		return this.soda;
	}

	public void setSoda(Soda_Type soda) {
		this.soda = soda;
	}

}