package Code;

import java.util.ArrayList;

public class Jugador {
	ArrayList<Carta> mano;
	String nombre;
	
	public Jugador(String nombre) {
		this.nombre = nombre;
		mano = new ArrayList<Carta>();
	}
	public void addCarta(Carta card) {
		mano.add(card);
	}
}