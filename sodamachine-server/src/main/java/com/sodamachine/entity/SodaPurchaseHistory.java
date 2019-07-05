package com.sodamachine.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the purchase_history database table.
 * 
 */
/**
 * @author suren
 *
 */
@Entity
public class SodaPurchaseHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private Date date;

	//bi-directional many-to-one association to Soda
	@ManyToOne
	@JoinColumn(name="soda_type")
	private Soda_Type soda;

	public SodaPurchaseHistory() {
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

	public Soda_Type getSoda() {
		return this.soda;
	}

	public void setSoda(Soda_Type soda) {
		this.soda = soda;
	}

}