package com.sodamachine.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sodamachine.entity.SodaInventory;
import com.sodamachine.entity.Soda_Type;
/**
 * @author suren
 *
 */
@Repository
public interface SodaInventoryRepository extends CrudRepository<SodaInventory, Integer> {

	 public SodaInventory findOneBySoda(Soda_Type soda);
}
