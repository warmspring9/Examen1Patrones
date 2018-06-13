package Code.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import Code.Carta;

class Pruebas {
	static Carta card;
	
	@BeforeClass
	public static void init() throws Exception {
	}
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
		assertEquals(true,card.equals(compair));
		compair = new Carta("Jota","Escudos",10);
		assertEquals(true,card.equals(compair));
		compair = new Carta("nueve","Escudos",9);
		assertEquals(false,card.equals(compair));
	}
}