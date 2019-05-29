package it.polito.tdp.model;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Simulatore {

	//MODELLO LO STATO SISTEMA
	
	//PARAMETRI
	private int numeroClienti = 2000;
	Map<Integer, Tavolo> tavoli;
	
	//OUTPUT
	private int clientiTot;
	private int clientiSI;
	private int clientiNO;
	
	//CODA
	private PriorityQueue<Evento> queue;
	
	//init
	public void init() {
	}
	
	public Simulatore() {
		super();
		this.tavoli = new HashMap<Integer, Tavolo>();
		tavoli.put(1, new Tavolo(1, 10, false));
		tavoli.put(2, new Tavolo(2, 10, false));
		tavoli.put(3, new Tavolo(3, 8, false));
		tavoli.put(4, new Tavolo(4, 8, false));
		tavoli.put(5, new Tavolo(5, 8, false));
		tavoli.put(6, new Tavolo(6, 8, false));
		tavoli.put(7, new Tavolo(7, 6, false));
		tavoli.put(8, new Tavolo(8, 6, false));
		tavoli.put(9, new Tavolo(9, 6, false));
		tavoli.put(10, new Tavolo(10, 6, false));
		tavoli.put(11, new Tavolo(11, 4, false));
		tavoli.put(12, new Tavolo(12, 4, false));
		tavoli.put(13, new Tavolo(13, 4, false));
		tavoli.put(14, new Tavolo(14, 4, false));
		tavoli.put(15, new Tavolo(15, 4, false));
	}

	//run
	public void run() {
		
	}
	
}
