package com.sodamachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sodamachine.entity.SodaInventory;
import com.sodamachine.entity.SodaPurchaseHistory;
import com.sodamachine.entity.Soda_Type;
import com.sodamachine.repo.PurchaseHistoryRepository;
import com.sodamachine.repo.SodaInventoryRepository;
import com.sodamachine.repo.SodaRepository;

/**
 * @author suren
 *
 */
@Service
public class SodaService implements ISodaService {
	@Autowired
	SodaRepository sodaRepository;
	
	@Autowired
	SodaInventoryRepository sodaInventoryRepository;
	
	@Autowired
	PurchaseHistoryRepository purchaseHistoryRepository;

	@Override
	public List<Soda_Type> findByName(String name) throws Exception{
		return sodaRepository.findByName(name);
	}
	
	
	@Override
	public void saveSoda(Soda_Type soda) throws Exception{
		sodaRepository.save(soda);
	}

	@Override
	public void updateInventory(SodaInventory sodaInventory) throws Exception{
		sodaInventoryRepository.save(sodaInventory);
	}
	
	@Override
	public void insertPurchaseHistoryRepository(SodaPurchaseHistory purchasehistory) throws Exception{
		purchaseHistoryRepository.save(purchasehistory);
	}

	@Override
	public SodaInventory findOneBySoda(Soda_Type soda) throws Exception{
		return sodaInventoryRepository.findOneBySoda(soda);
	}
	
	
}
