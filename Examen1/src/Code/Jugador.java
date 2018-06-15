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
	public int size() {
		return mano.size();
	}
	public String getNombre() {
		return nombre;
	}
	public ArrayList<Carta> getMano(){
		return mano;
	}
	public void dumpCard() {
		mano.remove(0);
	}
}
