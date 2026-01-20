package madrid.iescalderonbarca.ejercicios;

import java.util.Random;
import java.util.Scanner;

/**
 *<h2>Clase que genera y procesa apuestas deportivas en el cl?sico formato "1X2"</h2>
 *@author ?ngel AMR 
 *@version 1-2021
 *@since 1-1-2021
 */
public class Quiniela {
	
	//Atributos
	
	/**
	 * Atributo constante NUMERO_PARTIDOS que establece el total de encuentros que conforman la quiniela.
	 * Su valor se queda en 15 y se usa como referencia para dimensionar las estructuras utilizadas.
	 */
	private final int NUMERO_PARTIDOS = 15;
	
	/**
	 * Atributo partido array de String que almacena los encuentros de la quiniela. 
	 * Dimensionado a NUMERO_PARTIDOS. Ejemplo: "Betis-Osasuna"
	 */
	private String [] partido; 
	
	/**
	 * Atributo apuesta array de char que almacena los pron?sticos para los encuentros de la quiniela. 
	 * Dimensionado a NUMERO_PARTIDOS. Ejemplo: '1', o 'X' o '2'
	 */
	private char [] apuesta; 
	
	
	//Constructores
	
	/** 
	 * Constructor vac?o que solo crea los atributos sin darles valor
	 */
	public Quiniela() {
		
		partido = new String [NUMERO_PARTIDOS];
		apuesta = new char [NUMERO_PARTIDOS];
	}
	

	/** 
	 * Constructor con dos atributos inicializados al valor de sus par?metros
	 * @param partido Array de String con los partidos de la quiniela
	 * @param apuesta Array de char con las apuestas para los partidos de la quiniela
	 */
	public Quiniela(String[] partido, char[] apuesta) {
		
		this.partido = partido;
		this.apuesta = apuesta;
	}
	
	
	//M?todos
	
	/**
	 * M?todo que establece los partidos de acuerdo al valor del par?metro suministrado.
	 * @param partido Array de String con los partidos de la quiniela
	 */
	public void setPartido(String[] partido) {
		this.partido = partido;
	}

	/**
	 * M?todo que establece las apuestas de acuerdo al valor del par?metro suministrado.
	 * @param apuesta Array de char con las apuestas de la quiniela
	 */
	public void setApuesta(char[] apuesta) {
		this.apuesta = apuesta;
	}

	/**
	 * M?todo que devuelve los partidos de la quiniela.
	 * @return partido Array de String con los partidos de la quiniela
	 */
	public String[] getPartido() {
		return partido;
	}

	/**
	 * M?todo que devuelve las apuestas de la quiniela.
	 * @return apuesta Array de char con las apuestas de la quiniela
	 */
	public char[] getApuesta() {
		return apuesta;
	}
	
	 
	/**
	 * M?todo que pide los emparejamientos uno a uno por teclado para asignar valor a los partidos.
	 */
	public void pedirPartidos() {
		Scanner sc = new Scanner(System.in);
		String enfrentamiento="";
		for(int pos = 0; pos < partido.length; pos++) {
			System.out.print("\nEscriba el partido a disputar en la posici?n " + pos+ " : ");
			enfrentamiento = sc.nextLine();
			partido[pos] = enfrentamiento;
		}
		//sc.close(); //Si lo cierro aqu? salta una excepci?n la siguiente vez que pida algo por teclado
	}

	/**
	 * M?todo que muestra los partidos por pantalla.
	 */
	public void mostrarPartidos() {
		for(int pos = 0; pos < partido.length; pos++) {
			System.out.print("\nPartido " + (pos + 1) + " : " + partido[pos]);
		}
	}
	
	
	/**
	 * M?todo que muestra los partidos uno a uno por pantalla y pide las apuestas por teclado para asignarles valor.
	 */
	public void pedirApuestas() {
		Scanner sc = new Scanner(System.in);
		char pronostico;
		boolean apuestaValida = false;
		//int pronostico;
		//String opcionUsuario = "";
		for(int pos = 0; pos < partido.length; pos++) {
			do {
				apuestaValida = false;
				System.out.print("\nEscriba su pron?stico para el partido " + partido[pos] +" : ");
				
				pronostico = sc.next().charAt(0);
				if (pronostico == '1' || pronostico == 'X' || pronostico == 'x' || pronostico == '2') {
					apuestaValida = true;				
					System.out.println("\nRecibido partido " + partido[pos]);
					if (pronostico == '1' || pronostico == '2') {
						apuesta[pos] = pronostico;
					}
					else apuesta[pos]= 'X'; 
				}
				else 
					System.out.println("\nError, las ?nicas apuestas posibles son 1 X 2, por favor, int?ntelo de nuevo ");
			} while (!apuestaValida);
			
		}
		//sc.close();
	}
	
		
	/**
	 * M?todo que muestra por pantalla los partidos uno a uno con la apuesta realizada en cada uno.
	 */
	public void mostrarPartidosyApuestas() {
		System.out.println();
		for(int pos = 0; pos < partido.length; pos++) {
			System.out.println(pos + 1  + ". " + this.partido[pos] + " : " + this.apuesta[pos]);
		}
		
	}
	
	
	
	/**
	 * M?todo que genera una apuesta aleatoria para cada partido.
	 */
	public void generarApuestasAleatorias() {
		Random rnd = new Random();
		int apAle = 0;
		for(int i = 0; i < partido.length; i++) {
			apAle = (int)(rnd.nextDouble() * 3 + 1);
			switch (apAle) {
				case 1: 
					apuesta[i] = '1';
					break;
				case 2: 
					apuesta[i] = '2';
					break;
				case 3: 
					apuesta[i] = 'X';
					break;
			}
		}
	}
	
	
	//
	/**
	 * M?todo que compara la apuesta realizada en cada uno de los partidos de la quiniela que se pasa por par?metro con las apuestas de la quiniela que recibe el mensaje y devuelve el n?mero de aciertos.
	 * @param quiniela Es la quiniela cuyos aciertos se desea comprobar
	 * @return Un valor entero que representa el n?mero de aciertos
	 */
	public int comprobarApuestas(Quiniela quiniela) {
		int numAciertos = 0;	
		for(int pos = 0; pos <this.partido.length; pos++) {
			if (this.apuesta[pos] == quiniela.apuesta[pos])	
				numAciertos++;
			}
		return(numAciertos);			
	}
	
	
	/**
	 * M?todo que copia los partidos del par?metro al objeto que recibe el mensaje
	 * @param quiniela
	 */
	public void copiarPartidos(Quiniela quiniela) {
		
		for(int pos = 0; pos < partido.length; pos++) {
			this.partido[pos] = quiniela.partido[pos];
		}
	}
	
	
	/**
	 * M?todo que recibe un array de String por par?metro y lo copia para los partidos del objeto que recibe el mensaje.
	 * Si el par?metro tiene una longitud distinta del atributo no realiza la copia y muestra un mensaje por pantalla indicando este hecho.
	 * @param partidosExternos
	 */
	public void copiarPartidos(String [] partidosExternos) {
		if (partidosExternos.length == this.partido.length ) {
			for(int pos = 0; pos < partido.length; pos++) {
				this.partido[pos] = partidosExternos[pos];
			}
		}
		else
			System.out.print("Copia no realizada, n?mero de partidos distinto");
	}
	
	
	/**
	 * M?todo que recibe una quiniela por par?metro y copia las apuestas del par?metro al objeto que recibe el mensaje.
	 * @param quiniela
	 */
	public void copiarApuestas(Quiniela quiniela) {
		
		for(int pos = 0; pos < apuesta.length; pos++) {
			this.apuesta[pos] = quiniela.apuesta[pos];
		}
	}
	
	
	
	/**
	 * M?todo que recibe unas apuestas por par?metro y las copia al atributo del objeto que recibe el mensaje.
	 * Si el par?metro tiene una longitud distinta del atributo no realiza la copia y muestra un mensaje por pantalla indicando este hecho.
	 * @param apuestasExternas
	 */
	public void copiarApuestas(char [] apuestasExternas) {
		if (apuestasExternas.length == this.apuesta.length ) {
			for(int pos = 0; pos < apuesta.length; pos++) {
				this.apuesta[pos] = apuestasExternas[pos];
			}
		}
		else
			System.out.print("Copia no realizada, n?mero de apuestas distinto");
	}
	
//*************************************	
	public static void main(String[] args) {
	
		// C�digo para probar los m�todos de la clase
		
	} // Del main
	
} // De la clase Quiniela