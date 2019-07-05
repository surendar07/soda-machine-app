package com.sodamachine.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sodamachine.entity.CoinHistory;

/**
 * @author suren
 *
 */
@Repository
public interface CoinHistoryRepository extends CrudRepository<CoinHistory, Integer> {

}
