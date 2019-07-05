package com.sodamachine.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sodamachine.entity.Coin_Type;

/**
 * @author suren
 *
 */
@Repository
public interface CoinRepository extends CrudRepository<Coin_Type, Integer>{
    public List<Coin_Type> findByFaceValue(int faceValue);
}
