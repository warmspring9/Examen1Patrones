package Code;

import java.util.ArrayList;

public class Mesa {
	ArrayList<Jugador> players;
	Repartidor dealer;
	String ComodinPalo;
	String ComodinNombre;
	Naipe Deck;
	
	public Mesa() throws Exception {
		players = new ArrayList<Jugador>();
		dealer = new Repartidor();
		ComodinPalo = getRandomComodinPalo();
		ComodinNombre = getRandomComodinNombre();
		Deck = dealer.getNaipe();
	}
	public void reset() throws Exception {
		players.clear();
		dealer = new Repartidor();
		ComodinPalo = getRandomComodinPalo();
		ComodinNombre = getRandomComodinNombre(); 
		Deck = dealer.getNaipe();
	}
	public String getRandomComodinPalo(){
        int r = (int) (Math.random()*4);
        String name = new String [] {"Escudos","Flores","Estrellas","Gotas"}[r];
        return name;
    }
	public String getRandomComodinNombre(){
        int r = (int) (Math.random()*13);
        String name = new String [] {"Uno","Dos","Tres","Cuatro","Cinco","Seis","Siete","Ocho","Nueve","Diez","Jota","Quina","Ka"}[r];
        return name;
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
				if(suma!=mayor) {
					ganadores.clear();
				}
				mayor = suma;
				ganadores.add(players.get(i));
			}
			if(isHalf21(players.get(i))) {
				ganadores.clear();
				ganadores.add(players.get(i));
				return ganadores;
			}
		}
		return ganadores;
	}
	public boolean isHalf21(Jugador player) {
		int a = player.size();
		for(int i=0;i<a;i++) {
			if(player.getMano().get(i).getValue()==2) {
				for(int j=0;j<a;j++) {
					if(player.getMano().get(j).getValue()==10) {
						return true;
					}
				}
			}
		}
		return false;
	}
	public int sumar(Jugador player) {
		int res=0;
		for(int i=0;i<player.getMano().size();i++) {
			res += player.getMano().get(i).getValue();
			if(player.getMano().get(i).getNombre().equals(ComodinNombre) && player.getMano().get(i).getPalo().equals(ComodinPalo)) {
				return 21;
			}
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
	public void hacerCambio(ArrayList<Jugador> jugadores) throws Exception {
		for(int i=0;i<jugadores.size();i++) {
			int cont = jugadores.get(i).size();
			for(int j=0;j<cont;j++) {
				jugadores.get(i).dumpCard();
				dealer.DarCarta(jugadores.get(i));
			}
		}
	}
	public ArrayList<Jugador> getJugadores(){
		return players;
	}
	/*No game safe*/
	public void addSpecCard(Carta card,int i) {
		players.get(i).addCarta(card);
	}
	public String getComodinPalo() {
		return ComodinPalo;
	}
	public String getComodinNombre() {
		return ComodinNombre;
	}
	public void EmpezarPartidaDeRon() throws Exception {
		for(int i=0;i<players.size();i++) {
			for(int j=0;j<7;j++) {
				dealer.DarCarta(players.get(i));
			}
		}
	}
	public void agarrarCarta(int pos) throws Exception {
		players.get(pos).addCarta(Deck.deal());
		players.get(pos).getMano().remove(0);
	}
	public int size() {
		return Deck.size();
	}
}
