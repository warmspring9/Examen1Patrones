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
}
