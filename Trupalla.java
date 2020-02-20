package Dignidad;
public class Trupalla extends Carro{
	//ATRIBUTOS
	String nombre_conductor;
	int nivel_armadura;
	//CONSTRUCTOR
	public Trupalla(int cant_ocupantes, String fecha_ingreso,String nombre_conductor,int nivel_armadura) {
		super(cant_ocupantes, fecha_ingreso);
		// TODO Auto-generated constructor stub
		this.nombre_conductor = nombre_conductor;
		this.nivel_armadura = nivel_armadura;
	}
	//METODOS
	public void imprimir() {
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return	"Trupalla"+super.toString()+ " nombre_conductor=" + nombre_conductor + ", nivel_armadura=" + nivel_armadura ;
	}
	//SETTER GETTER
	public String getNombre_conductor() {
		return nombre_conductor;
	}
	public void setNombre_conductor(String nombre_conductor) {
		this.nombre_conductor = nombre_conductor;
	}
	public int getNivel_armadura() {
		return nivel_armadura;
	}
	public void setNivel_armadura(int nivel_armadura) {
		this.nivel_armadura = nivel_armadura;
	}
}