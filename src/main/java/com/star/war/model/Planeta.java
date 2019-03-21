package com.star.war.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planeta {
	@Id
	String id;
	String name;
	String clima;
	String terreno;
	int    qtdAP;
	
	public Planeta(String name, String clima,String terreno, int qtdAP) {
		this.name = name;
		this.clima  = clima;
		this.terreno = terreno;
		this.qtdAP       = qtdAP;
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public int getQtdAP() {
		return qtdAP;
	}

	public void setQtdAP(int qtdAP) {
		this.qtdAP = qtdAP;
	}
	
	@Override
	public String toString() {
		return "Planeta [name=" + name + ", clima=" + clima + ", terreno=" + terreno + ", qtdAP=" + qtdAP + "]";
	}
	
//	public String toString() {
//		return "Person First Name:"+firstName+" Last Name:"+lastName+" age:"+age;
//	}
}
