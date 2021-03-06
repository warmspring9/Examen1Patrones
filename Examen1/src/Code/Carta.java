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
	public boolean equals(Carta card) {
		return (card.getValue()==valor)?true:false;
	}
	public int getValue() {
		return valor;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPalo() {
		return palo;
	}
}
