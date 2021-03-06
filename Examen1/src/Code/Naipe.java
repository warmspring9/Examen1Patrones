package Code;

import java.util.ArrayList;
import java.util.Collections;

public class Naipe {
	ArrayList<Carta> baraja;
	
	public Naipe() {
		baraja = new ArrayList<Carta>();
	}
	
	public void llenar() throws Exception {
		String palo ="";
		Carta card = null;
		for(int j=0;j<4;j++) {
			switch (j){
			case 0: palo="Escudo";
			case 1: palo="Flores";
			case 2: palo="Estrellas";
			case 3: palo="Gotas";
			}
			for(int i=1;i<11;i++) {
				switch(i) {
					case 1: card = new Carta("As",palo,1);
					case 2: card = new Carta("Dos",palo,2);
					case 3: card = new Carta("Tres",palo,3);
					case 4: card = new Carta("Cuatro",palo,4);
					case 5: card = new Carta("Cinco",palo,5);
					case 6: card = new Carta("Seis",palo,6);
					case 7: card = new Carta("Siete",palo,7);
					case 8: card = new Carta("Ocho",palo,8);
					case 9: card = new Carta("Nueve",palo,9);
					case 10: card = new Carta("Diez",palo,10);
				}
				baraja.add(card);
			}
			baraja.add(new Carta("Jota",palo,10));
			baraja.add(new Carta("Quina",palo,10));
			baraja.add(new Carta("Ka",palo,10));
		}
	}

	public void shuffle() {
		Collections.shuffle(baraja);
	}
	public int size() {
		return baraja.size();
	}
	public boolean isCompleted() {
		return baraja.size()==52;
	}

	
	public Carta deal() throws Exception {
		if(baraja.size()==0) {
			throw new Exception("No cards to deal");
		}
		return baraja.remove(0);
	}
}
