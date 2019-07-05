package com.sodamachine.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sodamachine.entity.SodaPurchaseHistory;
/**
 * @author suren
 *
 */
@Repository
public interface PurchaseHistoryRepository extends CrudRepository<SodaPurchaseHistory, Integer> {

}
