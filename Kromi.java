package Dignidad;
public class Kromi extends Carro{
	//ATRIBUTOS
	int ano_fabricacion = 0;
	String marca = "";
	//CONSTRUCTOR
	public Kromi(int cant_ocupantes, String fecha_ingreso, int ano_fabricacion, String marca) {
		super(cant_ocupantes, fecha_ingreso);
		this.ano_fabricacion = ano_fabricacion;
		this.marca = marca;
	}
	//METODOS
	public void imprimir() {
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return	"Kromi"+super.toString()+ " [ano_fabricacion=" + ano_fabricacion + ", marca=" + marca ;
	}
	//SETTER GETTER
	public int getAno_fabricacion() {
		return ano_fabricacion;
	}
	public void setAno_fabricacion(int ano_fabricacion) {
		this.ano_fabricacion = ano_fabricacion;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
