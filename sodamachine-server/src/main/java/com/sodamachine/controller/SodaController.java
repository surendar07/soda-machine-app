package com.sodamachine.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sodamachine.entity.SodaInventory;
import com.sodamachine.entity.SodaPurchaseHistory;
import com.sodamachine.entity.Soda_Type;
import com.sodamachine.service.ISodaService;
import com.sodamachine.vo.SodaVO;

@RestController
@RequestMapping(value = "/soda")
@CrossOrigin(origins = "http://localhost:4200")
public class SodaController {

	private static final Logger logger = LoggerFactory.getLogger(SodaController.class);
	@Autowired
	ISodaService sodaService;

	@RequestMapping(value = "/updateSodaPurchaseHistory", method = RequestMethod.POST)
	public ResponseEntity updateSodaPurchaseHistory(@RequestBody SodaVO sodaVO) throws Exception {
		boolean sodaFound = false;
		
		if(sodaVO==null || sodaVO.getName()==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Soda not selected");
		}
		logger.info("updateSodaPurchaseHistory()::"+sodaVO.getName());
		List<Soda_Type> sodaTypes = null;
		if (sodaVO != null && !StringUtils.isEmpty(sodaVO.getName())) {
			sodaTypes = sodaService.findByName(sodaVO.getName());
		}

		if (!CollectionUtils.isEmpty(sodaTypes)) {
			Soda_Type sodaType = sodaTypes.get(0);
            // get soda inventory
			SodaInventory sodaInventory = sodaService.findOneBySoda(sodaType);
			if (sodaInventory != null) {
				sodaInventory.setQty(sodaInventory.getQty() - 1);
				sodaFound = true;
			} else {
				sodaInventory = new SodaInventory();
				sodaInventory.setSoda(sodaType);
				sodaInventory.setQty(0);
			}
             // update sodainventory
			sodaService.updateInventory(sodaInventory);

			if (sodaFound) {
				// insert in to soda purchase history
				SodaPurchaseHistory purchaseHistory = new SodaPurchaseHistory();
				purchaseHistory.setSoda(sodaType);
				purchaseHistory.setDate(new Date());
				sodaService.insertPurchaseHistoryRepository(purchaseHistory);
			}

			if (!sodaFound) {
				return ResponseEntity.status(HttpStatus.OK).body("Sold Out");
			}

		}
		//
	
		return ResponseEntity.status(HttpStatus.OK).body("Soda Dispensed");
	}

	@RequestMapping(value = "/getSodaCount", method = RequestMethod.GET)
	public ResponseEntity getSodaCount(@RequestBody SodaVO sodaVO) throws Exception{
		
		if(sodaVO==null || sodaVO.getName()==null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Soda not selected");
		}
		logger.info("getSodaCount()::"+sodaVO.getName());
		List<Soda_Type> sodaTypes = null;
		SodaInventory sodaInventory = null;
		if (sodaVO != null && !StringUtils.isEmpty(sodaVO.getName())) {
			sodaTypes = sodaService.findByName(sodaVO.getName());
		}

		if (!CollectionUtils.isEmpty(sodaTypes)) {
			Soda_Type sodaType = sodaTypes.get(0);

			sodaInventory = sodaService.findOneBySoda(sodaType);
		}

		if (sodaInventory == null) {
			ResponseEntity.status(HttpStatus.OK).body("No Sodas in the machine");
		}
		return ResponseEntity.status(HttpStatus.OK).body(sodaInventory.getQty());

	}

}
