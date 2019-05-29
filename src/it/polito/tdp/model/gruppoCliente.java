package it.polito.tdp.model;

import java.time.LocalDateTime;
import java.util.Random;

public class gruppoCliente {

	public enum statoClienti {
		ATTESA,
		SEDUTI,
		BANCONE,
		FINITO
	}
	
	private int num;
	private double tolleranza;
	private statoClienti stato;
	private Tavolo tavolo;
	
	public gruppoCliente() {
		super();
		Random random = new Random();
		this.num = random.nextInt(9)+1;
		this.tolleranza = random.nextDouble()*0.9;
		this.stato = statoClienti.ATTESA;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public double getTolleranza() {
		return tolleranza;
	}

	public void setTolleranza(double tolleranza) {
		this.tolleranza = tolleranza;
	}

	public statoClienti getStato() {
		return stato;
	}

	public void setStato(statoClienti stato) {
		this.stato = stato;
	}

	public Tavolo getTavolo() {
		return tavolo;
	}

	public void setTavolo(Tavolo tavolo) {
		this.tavolo = tavolo;
	}
	
}
