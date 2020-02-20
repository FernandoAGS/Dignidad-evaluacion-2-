package Dignidad;
public class Huevo{
	//ATRIBUTOS
	int fila;
	int columna;
	static int puntaje;
	static final int puntaje_total = 57;
	static final int  puntaje_final=65;
	//CONSTRUCTORES
	public Huevo() {}
	public Huevo (int fila,int columna) {
		this.fila = fila;
		this.columna = columna;
	}
	//METODOS
	public void muestraPuntaje() {
		
		if(puntaje==puntaje_total) {
			System.out.println("Felicidades destruiste todos los barcos tu puntaje es: "+puntaje_final);
		}
		else {
			System.out.println(puntaje);
		}
		
	}
	public void MuestraLanzamientos() {
		System.out.println("Fila: "+fila+" Columna :"+columna);
	}
	//SETTER GETTER
	public int getFila() {
		return fila;
	}
	public void setFila(int fila) {
		this.fila = fila;
	}
	public int getColumna() {
		return columna;
	}
	public void setColumna(int columna) {
		this.columna = columna;
	}
	public static int getPuntaje() {
		return puntaje;
	}
	public static void setPuntaje(int puntaje) {
		Huevo.puntaje = puntaje;
	}
	public static int getPuntajeFinal() {
		return puntaje_final;
	}
}
