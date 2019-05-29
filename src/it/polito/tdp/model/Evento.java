package it.polito.tdp.model;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class Evento implements Comparable<Evento>{

	public enum tipoEvento{
		ARRIVO,
		VIA
	}
	
	private LocalDateTime ora;
	private gruppoCliente clienti;
	private tipoEvento tipo;

	public Evento(LocalDateTime ora, gruppoCliente clienti, tipoEvento tipo) {
		super();
		this.ora = ora;
		this.clienti = clienti;
		this.tipo = tipo;
	}

	@Override
	public int compareTo(Evento arg0) {
		// TODO Auto-generated method stub
		return this.ora.compareTo(arg0.ora);
	}



	public LocalDateTime getOra() {
		return ora;
	}



	public void setOra(LocalDateTime ora) {
		this.ora = ora;
	}



	public gruppoCliente getClienti() {
		return clienti;
	}



	public void setClienti(gruppoCliente clienti) {
		this.clienti = clienti;
	}



	public tipoEvento getTipo() {
		return tipo;
	}



	public void setTipo(tipoEvento tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Evento [ora=" + ora + "tipo=" + tipo + "]";
	}
	
	
}
