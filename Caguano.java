package Dignidad;
public class Caguano extends Carro{
	//ATRIBUTOS
	int alcance_tiro;
	String color_confeti;
	//CONSTRUCTOR
	public Caguano(int cant_ocupantes, String fecha_ingreso,int alcance_tiro,String color_confeti) {
		super(cant_ocupantes, fecha_ingreso);
		this.alcance_tiro = alcance_tiro;
		this.color_confeti = color_confeti;
		// TODO Auto-generated constructor stub
	}
	//METODOS
	public void imprimir() {
		System.out.println(toString());
	}
	@Override
	public String toString() {
		return	"Caguano"+super.toString()+ " [Alcance de tiro =" + alcance_tiro + ", Color de confeti =" + color_confeti ;
}
	//SETTER GETTER
	public int getAlcance_tiro() {
		return alcance_tiro;
	}
	public void setAlcance_tiro(int alcance_tiro) {
		this.alcance_tiro = alcance_tiro;
	}
	public String getColor_confeti() {
		return color_confeti;
	}
	public void setColor_confeti(String color_confeti) {
		this.color_confeti = color_confeti;
	}
	
}
