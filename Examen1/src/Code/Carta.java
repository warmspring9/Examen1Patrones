package Code;

public class Carta {
	String nombre;
	String palo;
	int valor;
	
	public Carta(String nombre, String palo, int valor) throws Exception {
		if(valor<1 || valor>10) {
			throw new Exception("El valor tiene que estar entre 1 y 10");
		}
		this.nombre = nombre;
		this.palo = palo;
		this.valor = valor;
	}
	public int caca() throws Exception {
		throw new Exception("ds");
	}
}
