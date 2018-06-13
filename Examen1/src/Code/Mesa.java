package Code;

import java.util.ArrayList;

public class Mesa {
	ArrayList<Jugador> players;
	Repartidor dealer;
	
	public Mesa() throws Exception {
		players = new ArrayList<Jugador>();
		dealer = new Repartidor();
	}
	public void addPlayer(String nombre) throws Exception {
		if(players.size()>=4) {
			throw new Exception("To many players");
		}
		players.add(new Jugador(nombre));
	}
}