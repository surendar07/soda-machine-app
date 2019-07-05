package com.sodamachine.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * The persistent class for the coin database table.
 * 
 */
/**
 * @author suren
 *
 */
@Entity
public class Coin_Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int faceValue;

	@OneToMany(mappedBy = "coin")
	private List<CoinHistory> coinHistories;

	@OneToMany(mappedBy = "coin")
	private List<CoinInventory> coinInventories;

	public Coin_Type() {
	}

	public Coin_Type(int id, int faceValue) {
		this.id = id;
		this.faceValue = faceValue;

	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getFaceValue() {
		return this.faceValue;
	}

	public void setFaceValue(int faceValue) {
		this.faceValue = faceValue;
	}

	public List<CoinHistory> getCoinHistories() {
		return this.coinHistories;
	}

	public void setCoinHistories(List<CoinHistory> coinHistories) {
		this.coinHistories = coinHistories;
	}

	public List<CoinInventory> getCoinInventories() {
		return this.coinInventories;
	}

	public void setCoinInventories(List<CoinInventory> coinInventories) {
		this.coinInventories = coinInventories;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this) {
			return true;
		}

		if (!(o instanceof Coin_Type)) {
			return false;
		}

		Coin_Type ct = (Coin_Type) o;
		return ct.getId() == getId() && ct.getFaceValue()==faceValue;

	}

	@Override
	public int hashCode() {
		return Objects.hash(id,faceValue);
	}

	@Override
	public String toString() {
		return "Coin{" + "id=" + id + ", faceValue=" + faceValue + "}";
	}
}