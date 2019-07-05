package com.sodamachine.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sodamachine.entity.CoinHistory;
import com.sodamachine.entity.CoinInventory;
import com.sodamachine.entity.Coin_Type;
import com.sodamachine.service.ICoinService;
import com.sodamachine.vo.CoinVO;

@RestController
@RequestMapping(value = "/coin")
@CrossOrigin(origins = "http://localhost:4200")
public class CoinController {
	
	private static final Logger logger = LoggerFactory.getLogger(CoinController.class);
	@Autowired
	ICoinService coinService;
	
	@RequestMapping(value = "/coinInventory", method = RequestMethod.GET)
	public ResponseEntity getCoinInventory() throws Exception{
		logger.info("getCoinInventory()::");
		String coinQuantity=null;
		CoinInventory coinInventory=coinService.findCoinInventory();
		logger.info("getCoinInventory()::"+coinInventory.getQuantity());
		if(coinInventory!=null && coinInventory.getQuantity()>=0) {
		coinQuantity=String.valueOf(coinInventory.getQuantity());
		}
		return ResponseEntity.status(HttpStatus.OK).body(coinQuantity);
	}

	
	/**
	 * @param coinVO
	 * @return
	 */
	@RequestMapping(value = "/insertCoin", method = RequestMethod.POST)
	public ResponseEntity insertCoin(@RequestBody CoinVO coinVO) throws Exception{
	
		if(coinVO==null || coinVO.getValue()<=0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coin not inserted");
		}
		logger.info("insertCoin()::"+coinVO.getValue());
		List<Coin_Type> masterCoins = coinService.findByFaceValue(coinVO.getValue());
		if (masterCoins != null && !masterCoins.isEmpty()) {
			Coin_Type newCoin = masterCoins.get(0);
        // create coin history with add
			CoinHistory coinHistory = new CoinHistory();
			coinHistory.setCoin(newCoin);
			coinHistory.setDate(new Date());
			coinHistory.setOperation("ADD");
			coinService.insertCoinHistory(coinHistory);

			// update coin inventory
			CoinInventory coinInventory=coinService.findCoinInventory();
				if (coinInventory == null) {
					coinInventory = new CoinInventory();
					coinInventory.setCoin(newCoin);
					coinInventory.setQuantity(1);
				} else if(coinInventory.getCoin().getFaceValue()==newCoin.getFaceValue()) {
					coinInventory.setQuantity(coinInventory.getQuantity() + 1);
				}
				coinService.updateCoinInventory(coinInventory);

	        	 
	         
		}
		
		return ResponseEntity.status(HttpStatus.OK).body("Coin Inserted");
	}
	
	
	@RequestMapping(value = "/deleteCoin", method = RequestMethod.POST)
	public ResponseEntity deleteCoin(@RequestBody CoinVO coinVO) throws Exception{

		
		if(coinVO==null || coinVO.getValue()<=0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Coin not inserted");
		}
		logger.info("deleteCoin()::"+coinVO.getValue());
		List<Coin_Type> masterCoins = coinService.findByFaceValue(coinVO.getValue());
		if (masterCoins != null && !masterCoins.isEmpty()) {
			Coin_Type newCoin = masterCoins.get(0);
			//create coin history with delete action
			CoinHistory coinHistory = new CoinHistory();
			coinHistory.setCoin(newCoin);
			coinHistory.setDate(new Date());
			coinHistory.setOperation("DELETE");
			coinService.insertCoinHistory(coinHistory);

			
			// update coin inventory
			CoinInventory coinInventory=coinService.findCoinInventory();			
				if(coinInventory!=null)	{
			    coinInventory.setQuantity(coinInventory.getQuantity() - 1);
				coinService.updateCoinInventory(coinInventory); 
	         }
		}

	   
		return ResponseEntity.status(HttpStatus.OK).body("Coin Retrieved");
	}
	
	
	
	

}
