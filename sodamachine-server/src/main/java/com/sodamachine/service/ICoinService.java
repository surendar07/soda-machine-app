package com.sodamachine.service;

import java.util.List;

import com.sodamachine.entity.CoinHistory;
import com.sodamachine.entity.CoinInventory;
import com.sodamachine.entity.Coin_Type;

/**
 * @author suren
 *
 */
public interface ICoinService {
   
    public List<Coin_Type> findByFaceValue(int faceValue) throws Exception;
    public void insertCoinHistory(CoinHistory coinHistory) throws Exception;
    public void updateCoinInventory(CoinInventory coinInventory) throws Exception;
    public CoinInventory findOneByCoin(Coin_Type coin) throws Exception;
    public CoinInventory findCoinInventory() throws Exception;
}
