package Code;

import java.util.ArrayList;

public class Mesa {
	ArrayList<Jugador> players;
	Repartidor dealer;
	
	public Mesa() throws Exception {
		players = new ArrayList<Jugador>();
		dealer = new Repartidor();
	}
	public void agregarJugador(String nombre) throws Exception {
		if(players.size()>=4) {
			throw new Exception("To many players");
		}
		players.add(new Jugador(nombre));
	}
	public void EmpezarAJugar21() throws Exception {
		for(int i=0;i<players.size();i++) {
			for(int j=0;j<2;j++) {
				dealer.DarCarta(players.get(i));
			}
		}
	}
	public ArrayList<Jugador> ganadores() {
		int mayor = 0;
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
		for(int i=0;i<players.size();i++) {
			int suma = sumar(players.get(i));
			if(suma>=mayor) {
				mayor = suma;
				if(suma!=mayor) {
					ganadores.clear();
				}
				ganadores.add(players.get(i));
			} 
		}
		return ganadores;
	}
	public int sumar(Jugador player) {
		int res=0;
		for(int i=0;i<player.getMano().size();i++) {
			res += player.getMano().get(i).getValue();
		}
		return res;
	}
	public ArrayList<Jugador> verificarCambio() {
		ArrayList<Jugador> cambio = new ArrayList<Jugador>();
		for(int i=0;i<players.size();i++) {
			ArrayList<String> cartas = new ArrayList<String>();
			for(int j=0;j<players.get(i).getMano().size();j++) {
				cartas.add(players.get(i).getMano().get(j).getNombre());
			}
			if(cartas.contains("Jota") || cartas.contains("Quina") || cartas.contains("Ka")) {
				if(cartas.contains("Tres")) {
					cambio.add(players.get(i));
				}
			}
		}
		return cambio;
		
	}
}
