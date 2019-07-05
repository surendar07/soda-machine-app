package com.sodamachine.service;

import java.util.List;

import com.sodamachine.entity.SodaInventory;
import com.sodamachine.entity.SodaPurchaseHistory;
import com.sodamachine.entity.Soda_Type;

/**
 * @author suren
 *
 */
public interface ISodaService {
	public List<Soda_Type> findByName(String name) throws Exception;
		
	public void saveSoda(Soda_Type soda) throws Exception;
	
	public void updateInventory(SodaInventory sodaInventory) throws Exception;
	
	public void insertPurchaseHistoryRepository(SodaPurchaseHistory purchasehistory) throws Exception;
	
	public SodaInventory findOneBySoda(Soda_Type soda) throws Exception;
	
	

}
