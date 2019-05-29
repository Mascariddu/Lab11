package it.polito.tdp.model;

public class Model {

	Simulatore simulatore;
	
	public String simula() {
		
		simulatore = new Simulatore();
		
		simulatore.init();
		simulatore.run();
		
		return "Numero clienti totali: "+(simulatore.getClientiSI()+simulatore.getClientiNO())+"\n"+"Numero clienti soddisfatti: "+simulatore.getClientiSI()+"\n"+"Numero clienti insoddisfatti: "+simulatore.getClientiNO();
			
	}
}
