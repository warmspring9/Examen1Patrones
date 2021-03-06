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
		table.addSpecCard(new Carta("Quina","Escudo",10), 0);
		table.addSpecCard(new Carta("Jota","Escudo",10), 0);
		table.addSpecCard(new Carta("Quina","Escudo",10), 1);
		table.addSpecCard(new Carta("Ka","Escudo",10), 1);
		table.addSpecCard(new Carta("As","Escudo",1), 1);
		table.addSpecCard(new Carta("Dos","Escudo",2), 1);
		ArrayList<Jugador> ganadores = new ArrayList<Jugador>();
		ganadores = table.ganadores();
		assertEquals("Pepito",ganadores.get(0).getNombre());
	}
	@Test
	public void pruebaCambioMano() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juanito");
		table.agregarJugador("Pepito");
		table.agregarJugador("Juan");
		table.agregarJugador("Pepo");
		table.addSpecCard(new Carta("Quina","Escudo",10), 0);
		table.addSpecCard(new Carta("Tres","Escudo",3), 0);
		ArrayList<Jugador> cambio = table.verificarCambio();
		assertEquals("Juanito",cambio.get(0).getNombre());
	}
	@Test
	public void pruebaUnoyMedio() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juan");
		table.agregarJugador("Pepo");
		table.addSpecCard(new Carta("Quina","Escudo",10), 0);
		table.addSpecCard(new Carta("Dos","Escudo",2), 0);
		table.addSpecCard(new Carta("Quina","Escudo",10), 1);
		table.addSpecCard(new Carta("Jota","Escudo",10), 1);
		assertEquals("Juan",table.ganadores().get(0).getNombre());
	}
	@Test
	public void pruebaComodin() throws Exception {
		Mesa table = new Mesa();
		String palo = table.getComodinPalo();
		String name = table.getComodinNombre();
		table.agregarJugador("Juan");
		table.agregarJugador("Pepo");
		table.addSpecCard(new Carta(name,palo,2), 0);
		table.addSpecCard(new Carta("Dos","Escudo",2), 0);
		table.addSpecCard(new Carta("Quina","Escudo",10), 1);
		table.addSpecCard(new Carta("Jota","Escudo",10), 1);
		assertEquals("Juan",table.ganadores().get(0).getNombre());
	}
	@Test
	public void pruebaRon() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juanito");
		table.agregarJugador("Pepito");
		table.EmpezarPartidaDeRon();		
	}
	@Test
	public void pruebaDeck() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juanito");
		table.EmpezarPartidaDeRon();
		table.agarrarCarta(0);
		assertEquals(7,table.getJugadores().get(0).size());
	}
	@Test
	public void pruebaDeckTirarCarta() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juanito");
		table.EmpezarPartidaDeRon();
		table.agarrarCarta(0);
		assertEquals(7,table.getJugadores().get(0).size());
	}
	@Test
	public void pruebaReset() throws Exception {
		Mesa table = new Mesa();
		table.agregarJugador("Juanito");
		table.agregarJugador("Michael");
		table.agregarJugador("Pepito");
		table.agregarJugador("PersonajeGenerico");
		table.EmpezarPartidaDeRon();
		table.reset();
		assertEquals(0,table.getJugadores().size());
		assertEquals(52,table.size());
	}
}
