package Dignidad;

import java.util.ArrayList;
import java.util.List;


public class Tablero {
	
	//ATRIBUTOS
	String[ ][ ] aFilaCol = new String[15][15];
	public static List<Huevo> huevon = new ArrayList<Huevo>();
	public static List<Carro> aListaCarros = new ArrayList<Carro>();
	int x = 0;
	int y = 0;
	//CONSTRUCTOR DEL TABLERO
	public Tablero() {

		for (int i = 0; i < 15; ++i) {
			for (int j = 0; j < 15; ++j) {
			    aFilaCol[i][j]= "0";
			}  
		}
	}	
	/**
	 * Muestra en la consola los valores de 0,H o X segun sea el valor que contenga la coordenada
	 * Entre cada coordenada se agregara el tabulado correspondiente, en caso contraro solo 0
	 */
	public void MostrarTableroAlJugador() {
		String linea="";
		
		for (int i = 0; i < 15; ++i) {
			for (int j = 0; j < 15; ++j) {
				if( aFilaCol[i][j]== "0" || aFilaCol[i][j] == "H" || aFilaCol[i][j] == "X" ) {
					linea = linea + aFilaCol[i][j] + "\t";	
				} else {
					linea = linea + "0\t";
				}
				
			} 
			System.out.println( linea );
			linea = "";
		}
	}
	/**
	 * Metodo que imprime todos los valores que esten presentes en la tabla, en caso de no tener se imprimra el 0 correspondiente,
	 * pero al haber vehiculos en esta matriz, estos seran visibles.
	 */
	public void DibujarTodoTablero() {
		String linea="";
		
		for (int i = 0; i < 15; ++i) {
			for (int j = 0; j < 15; ++j) {
				linea = linea + aFilaCol[i][j] + "\t";	
			} 
			System.out.println( linea );
			linea = "";
		}
	}
	/**
	 * Verifica si los espacios que el vehiculo ocupara, ya estan libres  o desocupados.
	 * para esto se hace una distincion entre el largo del vehiculo y la forma en que buscaran los espacios libres de este
	 * enel caso de Kromi se revisara hacia abajo dos espacios y para los caguanos se vera hacia los lados.
	 * Ademas se agrego la restriccion de columna para estos dos vehiculos mencionados para evitar que se escapen del margen
	 * @param fila
	 * @param columna
	 * @param largo
	 * @return
	 */
	public int PuedePonerse( int fila, int columna, int largo ) {
		int fila_real, columna_real, se_puede = 1;
		fila_real = fila -1;
		columna_real = columna -1;
		if(largo==3 && fila_real <= 13) {
			for (int i = fila_real; i < fila_real + largo - 1; ++i) {
				if( aFilaCol[i][columna_real] != "0") {
					se_puede = 0;
				}
			}
			
		}else if (largo == 2 && columna_real <= 14) {
			for (int i = columna_real; i < columna_real+ largo - 1; ++i) {
				if( aFilaCol[fila_real][i] != "0") {
					se_puede = 0;
				}
			}
			
		} else {
			if( aFilaCol[fila_real][columna_real] != "0") {
				se_puede = 0;
			}
		}
		return se_puede;
	}
	/**
	 * Metodo que se encarga de cambiar los valores de la matriz segun el tamaño que tenga
	 * el vehiculo, esta funcion trabajara en conjunto con PuedePonerse
	 * Se ingresan los valores de fila,columna y largo, el largo define el tipo de comparador a utilizar
	 * finalmente se prodece a imprimir los valores segun el tipo
	 * @param fila
	 * @param columna
	 * @param largo
	 */
	public void PonerEnTablero( int fila, int columna, int largo ) {
		int fila_real, columna_real;
		fila_real = fila -1;
		columna_real = columna -1;
		if(largo==3 ) {
			for (int i = fila_real; i < fila_real + largo ; ++i) 
				aFilaCol[i][columna_real] = "K";
				
		}else if (largo == 2) {
			for (int i = columna_real; i < columna_real+ largo ; ++i)
				aFilaCol[fila_real][i] = "C";
				
		} else {
			aFilaCol[fila_real][columna_real] = "T";
		}
	}
	/**
	 *  Se Reciben dos parametros los cuales los ingresamos al constructor de 
	 *  la clase huevo, la cual los utilizara para definir las coordenadas con las cuales proceremos a comparar
	 *  los valores que se encuentren en la matriz.
	 *  Una vez comparados se prodece a cambiar el valor de 0  segun sea la opcion.
	 *  Adicionalmente se prodecera a aumentar el puntaje de la clase huevo, la cual
	 *  es estatica.
	 * @param x
	 * @param y
	 */
	public void TirarHuevo( int x, int y ) {
		Huevo huevito = new Huevo(x, y);
		if( aFilaCol[huevito.fila-1][huevito.columna-1]== "0" ) {
			aFilaCol[huevito.fila-1][huevito.columna-1]= "X";
		} else if(aFilaCol[huevito.fila-1][huevito.columna-1] == "K"){
			aFilaCol[huevito.fila-1][huevito.columna-1]= "H";
			Huevo.puntaje= Huevo.puntaje+3;
		    // Contabilizar el acierto
		}else if(aFilaCol[huevito.fila-1][huevito.columna-1] == "C"){
			aFilaCol[huevito.fila-1][huevito.columna-1]= "H";
			Huevo.puntaje= Huevo.puntaje+2;
		    // Contabilizar el acierto
		}else if(aFilaCol[huevito.fila-1][huevito.columna-1] == "T"){
			aFilaCol[huevito.fila-1][huevito.columna-1]= "H";
			Huevo.puntaje= Huevo.puntaje+1;
		    // Contabilizar el acierto
		}
		huevon.add(huevito);
		
	}
	/**
	 * Funcion que se dedica a mostrar las coordenas de lanzamiento del objeto huevo dentro de la lista huevo
	 */
	public void MuestraHuevos() {
		for(Huevo huevito:huevon) {
			huevito.MuestraLanzamientos();
		}
	}
	/** Metodo encargado de que al momento de que se reciba un impacto independiente del vehiculo ( que tenga mas de una casilla)
	 * se encargara de buscar el valor incial de este objeto, comparando las casillas que lo componen con el valor de H, si
	 * todas las casillas del objeto estan en H se procedera a entregar el bonus correspondiente segun el tipo de objeto.
	 * 
	 */
	public void Destruidos( ) {
		int fila_real, columna_real;
				
		for (Carro miKromi:aListaCarros) {
			fila_real = miKromi.x-1;
			columna_real = miKromi.y-1;
			
    		if (aFilaCol[fila_real][columna_real] == "H" && aFilaCol[fila_real+1][columna_real] == "H" && aFilaCol[fila_real+2][columna_real] =="H") {
    			Huevo.puntaje += 10;
		}
    		
    		}
		for (Carro miCaguano:aListaCarros) {
			fila_real = miCaguano.x-1;
			columna_real = miCaguano.y-1;
			
    		if (aFilaCol[fila_real][columna_real] == "H" && aFilaCol[fila_real][columna_real+1] == "H" ) {
    			Huevo.puntaje += 7;
    		}
    		
    	}
		
	}
	/**Los siguientes metodos se encargan de recibir los valores desde la clase dignidad, la cual entrega los parametros de 
	 * los constructores de cada uno de los objetos.
	 * Una vez ingresados se prodecera a generar un numero aleatorio el cual se convertira en la coordenada
	 * inicial de este objeto, antes de implementar  estas variables se procede con la llamada a los metodos PuedePonerse y PonerEnTablero
	 * si se cumplen las condiciones de PuedePonerse la cual es que su valor debe ser igual a 1. Se procedera a poner en el tablero  la forma del objeto
	 * 
	 * @param cant_ocupantes 
	 * @param fecha_ingreso
	 * @param ano_fabricacion
	 * @param marca
	 */
	public void CrearKromi(int cant_ocupantes, String fecha_ingreso, int ano_fabricacion, String marca) {
		Kromi miKromi = new Kromi( cant_ocupantes, fecha_ingreso, ano_fabricacion, marca );
			int asignada;
			asignada = 0;
			while (asignada== 0){
				miKromi.x = (int)((Math.random()*14)+1);
				miKromi.y = (int)((Math.random()*14)+1);
				// y = GenAleatorio()
				if ((PuedePonerse( miKromi.x, miKromi.y, 3) == 1)) {
					PonerEnTablero(miKromi.x,miKromi.y,3);
					asignada = 1;
				}
			}
				aListaCarros.add(miKromi);	
				miKromi.imprimir();
		
	}
	public void CrearCaguano(int cant_ocupantes, String fecha_ingreso, int alcance_confeti, String color_confeti) {
		Caguano miCaguano = new Caguano( cant_ocupantes, fecha_ingreso, alcance_confeti, color_confeti );
		int  asignada;
			asignada = 0;
			while (asignada== 0){
				miCaguano.x = (int)((Math.random()*14)+1);
				miCaguano.y = (int)((Math.random()*14)+1);
				if (PuedePonerse( miCaguano.x, miCaguano.y, 2) == 1) {
					PonerEnTablero(miCaguano.x,miCaguano.y,2);
					asignada = 1;
				}
			}
			if(aListaCarros.lastIndexOf(miCaguano)<5) {
				aListaCarros.add(miCaguano);
				miCaguano.imprimir();
			}
			else {
				System.out.println("Numero maximo de Caguanos completados");
			}
		
	}
	public void CrearTrupalla(int cant_ocupantes, String fecha_ingreso, String nombre_ocupante, int nivel_armadura) {
		Trupalla miTrupalla = new Trupalla( cant_ocupantes, fecha_ingreso, nombre_ocupante, nivel_armadura );
		int asignada;	
			asignada = 0;
			while (asignada== 0){
				miTrupalla.x = (int)((Math.random()*14)+1);
				miTrupalla.y = (int)((Math.random()*14)+1);
				if (PuedePonerse( miTrupalla.x, miTrupalla.y, 1) == 1) {
					PonerEnTablero(miTrupalla.x,miTrupalla.y,1);
					asignada = 1;
				}
			}
			if(aListaCarros.lastIndexOf(miTrupalla)<10) {
				aListaCarros.add(miTrupalla);
				miTrupalla.imprimir();
			}
			else {
				System.out.println("Numero maximo de Trupallas completados");
			}
	}		
}