package com.sodamachine.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;


/**
 * The persistent class for the soda database table.
 * 
 */

/**
 * @author suren
 *
 */
@Entity
//@NamedQuery(name="Soda.findAll", query="SELECT s FROM Soda s")
public class Soda_Type implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private int cost;

	private String name;
	
    public int quantity;

	//bi-directional many-to-one association to PurchaseHistory
	@OneToMany(mappedBy="soda")
	private List<SodaPurchaseHistory> purchaseHistories;

	//bi-directional many-to-one association to SodaInventory
	@OneToMany(mappedBy="soda")
	private List<SodaInventory> sodaInventories;

	public Soda_Type() {
	}
	
	public Soda_Type(int id,String name, int cost) {
		this.id=id;
        this.name = name;
        this.cost = cost;
    }

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<SodaPurchaseHistory> getPurchaseHistories() {
		return this.purchaseHistories;
	}

	public void setPurchaseHistories(List<SodaPurchaseHistory> purchaseHistories) {
		this.purchaseHistories = purchaseHistories;
	}



	public List<SodaInventory> getSodaInventories() {
		return this.sodaInventories;
	}

	public void setSodaInventories(List<SodaInventory> sodaInventories) {
		this.sodaInventories = sodaInventories;
	}

	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	  public boolean equals(Object o) {
		  if(o==this) {
			  return true;
		  }
		  
		  if(!(o instanceof Soda_Type)) {
			  return false;  
		  }
		  
		  Soda_Type ct=(Soda_Type) o;
		  return ct.getId()==id && ct.getName().equals(name);
		    
	  }
		
	  @Override
	  public int hashCode() {
		  return Objects.hash(id,name);
	  }
		
	
	 @Override
	    public String toString() {
	        return "Soda{" + "id=" + id + ", name=" + name +"cost"+cost+"}";
	    }
}