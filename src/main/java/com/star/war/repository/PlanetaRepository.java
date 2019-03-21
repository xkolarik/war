package com.star.war.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.star.war.model.Planeta;

@Repository
public interface PlanetaRepository extends MongoRepository<Planeta, String>{
	public List<Planeta> findById(int id);
	public List<Planeta> findByName(String name);
}
