package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.star.war.controller.PlanetaController;
import com.star.war.model.Planeta;
import com.star.war.service.PlanetaService;


public class PlanetasControllerTests extends StarWarsApplicationTests {

	private MockMvc mockMvc;
	
	@Autowired
	private PlanetaController planetaController;
	
	@Autowired
	private PlanetaService planetaService;

	@Before
	public void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(planetaController).build();
	}

	@Test
	public void testGETPlanetasController() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/get/"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

	@Test
	public void testGETPlanetasControllerAll() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/getAll"))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void testPUTAddPlanetasController() throws Exception {
		String json = "{\"name\" : \"Terra\" , \"clima\": \"Cold\", \"terreno\" : \"Plano\", \"qtdAP\" : \"3\"}";
		Planeta p = (new Planeta("Terra" , "Cold", "Plano", 3));
		planetaService.create(p.getName(), p.getClima(), p.getTerreno(), p.getQtdAP());
		this.mockMvc.perform(MockMvcRequestBuilders.put("/create/").contentType(MediaType.APPLICATION_JSON_UTF8)
				.content(json))
				.andExpect(MockMvcResultMatchers.status().isNoContent());
	}
}
