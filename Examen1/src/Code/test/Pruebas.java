package Code.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Code.Carta;
import Code.Jugador;
import Code.Mesa;
import Code.Naipe;
import Code.Repartidor;

class Pruebas {
	static Carta card;
	
	@Test
	public void pruebaCreacion() throws Exception {
		card = new Carta("Ka","Escudos",10);
	}
	@Test
	public void pruebaExcepcionValorMayor(){
		try {
			card = new Carta("quina","treboles",13);
	        assert false;
	    } catch (Exception e) {
	        assert true;
	    }
	}
	@Test
	public void pruebaExcepcionValorNegativo() {
		try {
			card = new Carta("quina","treboles",0);
	        assert false;
	    } catch (Exception e) {
	        assert true;
	    }
	}
	@Test
	public void pruebaEquals() throws Exception {
		Carta compair = new Carta("Quinta","Estrella",10);
		card = new Carta("Ka","Escudos",10);
		assertTrue(card.equals(compair));
		compair = new Carta("Jota","Escudos",10);
		assertTrue(card.equals(compair));
		compair = new Carta("nueve","Escudos",9);
		assertFalse(card.equals(compair));
	}
	@Test
	public void pruebaNaipe() throws Exception {
		Naipe baraja = new Naipe();
		baraja.llenar();
		assertTrue(baraja.isCompleted());
	}
	@Test
	public void pruebaRepartidor() throws Exception{
		Repartidor shuffler = new Repartidor();
		assertTrue(shuffler.isCompleted());
	}
	@Test
	public void pruebaJugador() throws Exception{
		Jugador player = new Jugador("MiguelElDelTest");
		player.addCarta(new Carta("Quina","Escudos",10));
		player.addCarta(new Carta("Jota","Escudos",10));
		player.addCarta(new Carta("Ka","Escudos",10));
		player.addCarta(new Carta("Diez","Escudos",10));
		player.addCarta(new Carta("Quina","Gotas",10));
		player.addCarta(new Carta("As","Flores",1));
	}
	@Test
	public void pruebaMesa() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juanito");
	}
	@Test
	public void pruebaMesaExcepcion() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Pepito");
		table.agregarJugador("Chanchito");
		table.agregarJugador("Chinito");
		table.agregarJugador("Juanito");
		try {
			table.agregarJugador("Te tienes que caer");
	        assert false;
	    } catch (Exception e) {
	        assert true;
	    }
	}
	@Test
	public void pruebaRepartirCarta() throws Exception {
		Repartidor dealer = new Repartidor();
		Jugador player = new Jugador("Juanito");
		dealer.DarCarta(player);
		assertEquals(1,player.size());
		assertEquals(51,dealer.size());
	}
	@Test
	public void pruebaExcepcionRepartirCarta() throws Exception {
		Repartidor dealer = new Repartidor();
		Jugador player = new Jugador("Juanito"); 
		try {
			for(int i=0;i<53;i++) {
				dealer.DarCarta(player);
			}
	        assert false;
	    } catch (Exception e) {
	        assert true;
	    }
	}
	@Test
	public void pruebaJuego21() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juanito");
		table.agregarJugador("Pepito");
		table.EmpezarAJugar21();		
	}
	@Test
	public void pruebaGanador() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juanito");
		table.agregarJugador("Pepito");
		table.EmpezarAJugar21();
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
		ganadores = table.ganadores();
	}
	
}
