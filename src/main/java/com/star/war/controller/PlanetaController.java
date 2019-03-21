package com.star.war.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.star.war.model.Planeta;
import com.star.war.service.PlanetaService;

@RestController
public class PlanetaController {

	@Autowired
	private PlanetaService personService;
	
	@RequestMapping("/create/")
	public String create(@RequestParam String name, @RequestParam String clima, @RequestParam String terreno, @RequestParam int qtdAP) {
		Planeta p = personService.create(name, clima, terreno, qtdAP);
		return p.toString();
	}
	
	@RequestMapping("/get/")
	public List<Planeta> getPlaneta(@RequestParam String name) {
		return personService.getByName(name);
	}
	@RequestMapping("/getAll")
	public List<Planeta> getAll(){
		return personService.getAll();
	}
	@RequestMapping ("/deleteAll")
	public String deleteAll() {
		personService.deleteAll();
		return "Deleted all records";
	}
	@RequestMapping ("/delete")
	public String delete(@RequestParam String name) {
		personService.delete(name);
		return "Planeta Deletado";
	}
	
}
