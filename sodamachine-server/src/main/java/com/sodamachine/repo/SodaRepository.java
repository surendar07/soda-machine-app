package com.sodamachine.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sodamachine.entity.Soda_Type;
/**
 * @author suren
 *
 */
@Repository
public interface SodaRepository extends CrudRepository<Soda_Type, Integer> {
	public List<Soda_Type> findByName(String name);
	
	
}
