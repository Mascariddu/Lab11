package it.polito.tdp.model;

public class Tavolo {

	private int id;
	private int posti;
	private boolean occupato;
	
	public Tavolo(int id, int posti, boolean occupato) {
		super();
		this.id = id;
		this.posti = posti;
		this.occupato = occupato;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public boolean isOccupato() {
		return occupato;
	}

	public void setOccupato(boolean occupato) {
		this.occupato = occupato;
	}
	
	
}
