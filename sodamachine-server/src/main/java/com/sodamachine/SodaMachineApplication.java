package com.sodamachine;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.sodamachine.entity.CoinInventory;
import com.sodamachine.entity.Coin_Type;
import com.sodamachine.entity.SodaInventory;
import com.sodamachine.entity.Soda_Type;
import com.sodamachine.repo.CoinInventoryRepository;
import com.sodamachine.repo.CoinRepository;
import com.sodamachine.repo.SodaInventoryRepository;
import com.sodamachine.repo.SodaRepository;

/**
 * @author suren
 *
 */
@SpringBootApplication
public class SodaMachineApplication {

	public static void main(String[] args) {
		SpringApplication.run(SodaMachineApplication.class, args);
	}

	
	@Bean
	CommandLineRunner init(SodaRepository sodaRepository,
						   CoinRepository coinRepository,CoinInventoryRepository coinInventoryRepo,SodaInventoryRepository sodaInventoryRepo) {
		return args -> {	// add soda types to the machine
			Soda_Type cokeSoda=sodaRepository.save(new Soda_Type(1,"Coke", 25));
			Soda_Type spriteSoda=sodaRepository.save(new Soda_Type(2,"Sprite", 25));				

			// Add coin types to the machine
			 Coin_Type coin= coinRepository.save(new Coin_Type(1, 25));
			  
			  //add coin inventory to the machine
			  coinInventoryRepo.save(new CoinInventory(1,coin, 10));
			  
			   //add soda inventory
			  sodaInventoryRepo.save(new SodaInventory(1,cokeSoda, 10));
			  sodaInventoryRepo.save(new SodaInventory(2,spriteSoda, 10));
	};

}
}
