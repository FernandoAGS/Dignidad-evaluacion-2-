package Dignidad;
public class Carro {
	//ATRIBUTOS
	int cant_ocupantes;
	String fecha_ingreso;
	int x, y;
	//Constructor
	public Carro(int cant_ocupantes,String fecha_ingreso) {
		this.cant_ocupantes = cant_ocupantes;

	}	
	//METODOS
	public void imprimir() {
		System.out.println(toString());
	}
	//METODO ToString
	@Override
	public String toString() {
		return " [cant_ocupantes=" + cant_ocupantes + ", fecha_ingreso=" + fecha_ingreso + ", fila_inicio="
				+ x + ", columna_termino=" + y ;
	}
	// SETTERS GETTERS
	public int getCant_ocupantes() {
		return cant_ocupantes;
	}
	public void setCant_ocupantes(int cant_ocupantes) {
		this.cant_ocupantes = cant_ocupantes;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}	
}
