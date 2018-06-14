package Code;

public class Repartidor {
	Naipe baraja;
	
	public Repartidor() throws Exception {
		baraja = new Naipe();
		baraja.llenar();
		baraja.shuffle();
	}
	public boolean isCompleted() {
		return baraja.isCompleted();
	}
	public int size() {
		return baraja.size();
	}
	public void DarCarta(Jugador player) throws Exception {
		Carta card = baraja.deal();
		player.addCarta(card);
		
	}
	public Naipe getNaipe() {
		return baraja;
	}
}
