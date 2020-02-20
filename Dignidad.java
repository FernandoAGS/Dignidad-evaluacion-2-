package Dignidad;

import java.util.Scanner;

public class Dignidad {

	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; 
		Huevo huevi = new Huevo();
		
	
		Tablero tablero;
		
		tablero = new Tablero() ;
		
	
		/* Pruebas Numero 1
		 if( tablero.PuedePonerse( 4, 5, 3 ) == 1 ) {
			tablero.PonerEnTablero( 4, 5, 3 );
		}
		if( tablero.PuedePonerse( 4, 6, 2 ) == 1 ) {
			tablero.PonerEnTablero( 4, 6,2 );
		}
		if( tablero.PuedePonerse( 6, 6, 1 ) == 1 ) {
			tablero.PonerEnTablero( 6, 6,1 );
		}*/
		
		//tablero.DibujarTodoTablero();
		//tablero.MostrarTableroAlJugador();
			        
		while(!salir || Huevo.puntaje==65){
	
	
			//tablero.CrearKromi(1, "2020", 2020, "Huindai");
			
			
			System.out.println("Escribe una de las opciones");
			System.out.println("1. Crear Kromi - 2. Crear Caguano - 3. Crear Trupalla - 4. Tirar Huevo - 5. Ver tablero - 6. Pista 7. Mostrar puntaje 8. Mostrar puntajes 9.salir");

			opcion = sn.nextInt();
		    
			switch(opcion){
				case 1:
					int canti_kromi =0;
			        while(canti_kromi<=2) {
		           System.out.println("Creando Kromis");
		           
		           System.out.println("ingrese  cantidad de ocupantes, fecha de ingreso, año de fabricacion, marca");
		           tablero.CrearKromi(sn.nextInt(),sn.next(),sn.nextInt(),sn.next());
		           canti_kromi++;
		           }
		           break;
				case 2:
					int canti_caguano=0;
					while(canti_caguano<=4) {
					System.out.println("Creando Caguano");
					System.out.println("ingrese  cantidad de ocupantes, fecha de ingreso, alcance de confeti, color confeti");
					tablero.CrearCaguano(sn.nextInt(), sn.next(), sn.nextInt(), sn.next());
					canti_caguano++;
					}
					break;
				case 3:
					int canti_trupalla= 0;
					while(canti_trupalla<=9) {
					System.out.println("Creando Trupalla");
					tablero.CrearTrupalla(sn.nextInt(), sn.next(), sn.next(), sn.nextInt());
					canti_trupalla++;
					}
					break;
				case 4:
					tablero.TirarHuevo(sn.nextInt(), sn.nextInt());
					System.out.println("Tirando Huevo");
					
					break;
				case 5:
					tablero.MostrarTableroAlJugador();
					break;
				case 6:
					tablero.DibujarTodoTablero();
					break;
				case 7:
					System.out.println("Mostrar puntaje!.");
					huevi.muestraPuntaje();
					;
					break;
				case 8:
					System.out.println("Mostrar Huevos lanzados");
					tablero.MuestraHuevos();
					break;
				case 9:
					System.out.println("Cuídense!.");
					tablero.Destruidos();
					huevi.muestraPuntaje();
					salir=true;
					break;
				default:
					System.out.println("Solo números entre 1 y 9");
			}   
			System.out.println("");

		}
		sn.close();
	} // Fin Main
	
	static void limpiar(int lineas)	{
	for (int i=0; i < lineas; i++)
		System.out.println("");
	}
	
	
	
} // Fin Clase Dignidad
