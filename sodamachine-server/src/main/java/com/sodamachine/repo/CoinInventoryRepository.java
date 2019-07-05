package com.sodamachine.repo;

import org.springframework.data.repository.CrudRepository;

import com.sodamachine.entity.CoinInventory;
import com.sodamachine.entity.Coin_Type;

/**
 * @author suren
 *
 */
public interface CoinInventoryRepository extends CrudRepository<CoinInventory, Integer> {
	 public CoinInventory findByCoin(Coin_Type coin);
}
