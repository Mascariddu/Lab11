package it.polito.tdp.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

import javax.crypto.IllegalBlockSizeException;

import it.polito.tdp.model.Evento.tipoEvento;
import it.polito.tdp.model.gruppoCliente.statoClienti;

public class Simulatore {

	//MODELLO LO STATO SISTEMA
	Random random = new Random();
	
	//PARAMETRI
	private int numeroClienti = 2000;
	Map<Integer, Tavolo> tavoli;
	LocalDateTime ora = LocalDateTime.now();
	
	//OUTPUT
	private int clientiSI;
	private int clientiNO;
	
	//CODA
	private PriorityQueue<Evento> queue;
	
	//init
	public void init() {
		
		queue = new PriorityQueue<Evento>();
		queue.add(new Evento(ora,new gruppoCliente(),tipoEvento.ARRIVO));
		ora = ora.plusMinutes((long)(random.nextDouble()*10));
		
		for(int i = 1; i < this.numeroClienti; i++) {
			queue.add(new Evento(ora,new gruppoCliente(),tipoEvento.ARRIVO));
			System.out.println(ora);
			ora = ora.plusMinutes((long)(random.nextDouble()*10));
		}
	}

	//run
	public void run() {
		
		clientiNO = 0;
		clientiSI = 0;
		
		Evento evento;
		while((evento=queue.poll()) != null) {
			
			System.out.println(evento.toString());
			switch(evento.getTipo()) {
			
				case ARRIVO:
					
					boolean h = false;
					double prob = Math.random();
					for(int i = tavoli.size(); i > 0; i--) {
						if(h==false) {
						if(!tavoli.get(i).isOccupato()) {
							if(tavoli.get(i).getPosti() >= evento.getClienti().getNum() && tavoli.get(i).getPosti() <= evento.getClienti().getNum()*2) {
								System.out.println("Tavolo assegnato");
								System.out.println(evento.getClienti().getNum()+" in un tavolo da "+tavoli.get(i).getPosti());
								clientiSI += evento.getClienti().getNum();
								tavoli.get(i).setOccupato(true);
								evento.getClienti().setStato(statoClienti.SEDUTI);
								evento.getClienti().setTavolo(tavoli.get(i));
								queue.add(new Evento(evento.getOra().plusMinutes((long)(random.nextDouble()*60+60)),evento.getClienti(),tipoEvento.VIA));
								h = true;
								break;
							}
						}
						} 
						}
				
					if(h==false) {
					if(evento.getClienti().getTolleranza() <= prob) {
						System.out.println("stanno al bancone ");
						System.out.println(evento.getClienti().getNum());
						evento.getClienti().setStato(statoClienti.BANCONE);
						this.clientiSI += evento.getClienti().getNum();
					} else {
						clientiNO += evento.getClienti().getNum();
						System.out.println("se ne vanno i porci ");
						System.out.println(evento.getClienti().getNum());

					}
					}
				
					
				break;
				
				case VIA:
					evento.getClienti().getTavolo().setOccupato(false);
					System.out.println("Finito "+evento.getClienti().getTavolo().getPosti());
					break;
			}
		}
		
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

	public int getClientiSI() {
		return clientiSI;
	}

	public int getClientiNO() {
		return clientiNO;
	}
	
}
