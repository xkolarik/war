package com.star.war.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.star.war.model.Planeta;
import com.star.war.repository.PlanetaRepository;

@Service
public class PlanetaService {
   
	@Autowired
	private PlanetaRepository personRepository;
	
	//Create operation
	public Planeta create(String name,String clima,String terreno, int qtdAP) {
		return personRepository.save(new Planeta(name, clima,terreno, qtdAP));
	}
	//Retrieve operation
	public List<Planeta> getAll(){
		return personRepository.findAll();
	}
	
	public List<Planeta> getById(int id) {
		return personRepository.findById(id);
	}
	
	public List<Planeta> getByName(String name) {
		return personRepository.findByName(name);
	}
	//Delete operation
	public void deleteAll() {
		personRepository.deleteAll();
	}
	public void delete(String name) {
		List<Planeta> p = personRepository.findByName(name);
		for (int i = 0; i < p.size(); i++) {
			Planeta p1 = p.get(i);
			personRepository.delete(p1);
		}
	}
}
