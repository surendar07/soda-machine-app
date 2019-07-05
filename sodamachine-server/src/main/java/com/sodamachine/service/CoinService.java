package com.sodamachine.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.sodamachine.entity.CoinHistory;
import com.sodamachine.entity.CoinInventory;
import com.sodamachine.entity.Coin_Type;
import com.sodamachine.repo.CoinHistoryRepository;
import com.sodamachine.repo.CoinInventoryRepository;
import com.sodamachine.repo.CoinRepository;

/**
 * @author suren
 *
 */
@Service
public class CoinService implements ICoinService {

	@Autowired
	private CoinRepository coinRepository;
	@Autowired
	private CoinHistoryRepository coinHistoryRepository;
	@Autowired
	private CoinInventoryRepository coinInventoryRepository;

	
	@Override
	public List<Coin_Type> findByFaceValue(int faceValue) throws Exception{
		return coinRepository.findByFaceValue(faceValue) ;
	}

	@Override
	public void insertCoinHistory(CoinHistory coinHistory) throws Exception{
		coinHistoryRepository.save(coinHistory);
	}

	@Override
	public void updateCoinInventory(CoinInventory coinInventory) throws Exception {
		coinInventoryRepository.save(coinInventory);
	}

	@Override
	public CoinInventory findOneByCoin(Coin_Type coin) throws Exception{
		return null; //coinInventoryRepository.findOneByCoin(coin);
	}
	
	@Override
	public CoinInventory findCoinInventory() throws Exception{
		List<Coin_Type> coinTypes=coinRepository.findByFaceValue(25);
		CoinInventory coinInventory= coinInventoryRepository.findByCoin(coinTypes.get(0));
		return coinInventory;
	}

}
