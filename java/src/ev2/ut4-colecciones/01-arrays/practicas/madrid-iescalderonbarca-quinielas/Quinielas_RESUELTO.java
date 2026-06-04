package madrid.iescalderonbarca.ejercicios.quinielas;

import java.util.Scanner;

/**
 * Aplicacion que permite hacer apuestas de futbol al estilo quiniela.
 * Cada jugador podra hacer un maximo de 20 quinielas por jornada.
 * 
 * @author Alumno
 * @version 1.0
 */
public class Quinielas_RESUELTO {
	
	/**
	 * Limite maximo de quinielas que puede realizar un jugador por jornada.
	 * Este limite esta sujeto a las politicas de lucha contra la ludopatia.
	 */
	private static final int LIMITE_QUINIELAS = 20;
	
	/**
	 * Array que almacena todas las quinielas del jugador.
	 * La posicion 0 contiene la quiniela oficial con los resultados de la jornada.
	 */
	private Quiniela[] quinielas;
	
	/**
	 * Indice de la quiniela activa. Por defecto es 0 (quiniela oficial).
	 */
	private int quinielaActiva;
	
	/**
	 * Contador de quinielas jugadas por el usuario (sin contar la oficial).
	 */
	private int quinielasJugadas;
	
	/**
	 * Scanner para leer datos del teclado.
	 */
	private Scanner sc;
	
	/**
	 * Constructor que inicializa la aplicacion.
	 */
	public Quinielas() {
		// El array tiene tamano LIMITE_QUINIELAS + 1 porque incluye la quiniela oficial
		quinielas = new Quiniela[LIMITE_QUINIELAS + 1];
		quinielaActiva = 0; // Por defecto la quiniela oficial
		quinielasJugadas = 0;
		sc = new Scanner(System.in);
		
		// Inicializar la quiniela oficial
		quinielas[0] = new Quiniela();
		inicializarQuinielaOficial();
	}
	
	/**
	 * Inicializa la quiniela oficial con los partidos de la jornada.
	 * En una aplicacion real, estos datos vendrian de una base de datos o archivo.
	 */
	private void inicializarQuinielaOficial() {
		// Partidos de ejemplo para la jornada
		String[] partidosOficiales = {
			"Real Madrid - Barcelona",
			"Atletico Madrid - Sevilla",
			"Valencia - Villarreal",
			"Athletic Bilbao - Real Sociedad",
			"Betis - Osasuna",
			"Espanyol - Getafe",
			"Granada - Elche",
			"Levante - Cadiz",
			"Mallorca - Alaves",
			"Rayo Vallecano - Celta",
			"Real Valladolid - Girona",
			"Almeria - Las Palmas",
			"Tenerife - Zaragoza",
			"Eibar - Mirandes",
			"Oviedo - Lugo"
		};
		
		// Resultados oficiales de ejemplo (en una aplicacion real vendrian de una base de datos)
		char[] resultadosOficiales = {'1', 'X', '2', '1', 'X', '2', '1', 'X', '2', '1', 'X', '2', '1', 'X', '2'};
		
		quinielas[0].copiarPartidos(partidosOficiales);
		quinielas[0].copiarApuestas(resultadosOficiales);
	}
	
	/**
	 * Muestra el menu principal de la aplicacion.
	 */
	private void mostrarMenu() {
		System.out.println("\n==========================================");
		System.out.println("          MENU QUINIELAS");
		System.out.println("==========================================");
		System.out.println("1. Rellenar una quiniela nueva manualmente");
		System.out.println("2. Rellenar una quiniela nueva aleatoriamente");
		System.out.println("3. Seleccionar la quiniela activa");
		System.out.println("4. Comprobar los aciertos de la quiniela");
		System.out.println("5. Mostrar los partidos de la jornada");
		System.out.println("6. Mostrar los partidos y las apuestas");
		System.out.println("7. Salir");
		System.out.println("==========================================");
		System.out.print("Seleccione una opcion: ");
	}
	
	/**
	 * Metodo principal que ejecuta la aplicacion.
	 */
	public void ejecutar() {
		int opcion;
		
		do {
			mostrarMenu();
			opcion = sc.nextInt();
			sc.nextLine(); // Limpiar el buffer
			
			switch (opcion) {
				case 1:
					rellenarQuinielaManual();
					break;
				case 2:
					rellenarQuinielaAleatoria();
					break;
				case 3:
					seleccionarQuinielaActiva();
					break;
				case 4:
					comprobarAciertos();
					break;
				case 5:
					mostrarPartidosJornada();
					break;
				case 6:
					mostrarPartidosyApuestas();
					break;
				case 7:
					System.out.println("\n!Hasta luego!");
					break;
				default:
					System.out.println("\nOpcion no valida. Por favor, seleccione una opcion del 1 al 7.");
			}
		} while (opcion != 7);
	}
	
	/**
	 * Opcion 1: Rellena una quiniela nueva manualmente.
	 */
	private void rellenarQuinielaManual() {
		if (quinielasJugadas >= LIMITE_QUINIELAS) {
			System.out.println("\nHa alcanzado el limite de quinielas permitido por jornada (" + LIMITE_QUINIELAS + ").");
			System.out.println("No se puede rellenar ningun boleto adicional.");
			return;
		}
		
		// Crear nueva quiniela
		quinielasJugadas++;
		quinielas[quinielasJugadas] = new Quiniela();
		
		// Copiar los partidos de la quiniela oficial
		quinielas[quinielasJugadas].copiarPartidos(quinielas[0]);
		
		// Pedir las apuestas al usuario
		System.out.println("\n=== RELLENAR QUINIELA MANUALMENTE ===");
		quinielas[quinielasJugadas].pedirApuestas();
		
		System.out.println("\nBoleto rellenado");
	}
	
	/**
	 * Opcion 2: Rellena una quiniela nueva aleatoriamente.
	 */
	private void rellenarQuinielaAleatoria() {
		if (quinielasJugadas >= LIMITE_QUINIELAS) {
			System.out.println("\nHa alcanzado el limite de quinielas permitido por jornada (" + LIMITE_QUINIELAS + ").");
			System.out.println("No se puede rellenar ningun boleto adicional.");
			return;
		}
		
		// Crear nueva quiniela
		quinielasJugadas++;
		quinielas[quinielasJugadas] = new Quiniela();
		
		// Copiar los partidos de la quiniela oficial
		quinielas[quinielasJugadas].copiarPartidos(quinielas[0]);
		
		// Generar apuestas aleatorias
		quinielas[quinielasJugadas].generarApuestasAleatorias();
		
		System.out.println("\nBoleto rellenado");
	}
	
	/**
	 * Opcion 3: Selecciona la quiniela activa.
	 */
	private void seleccionarQuinielaActiva() {
		if (quinielasJugadas == 0) {
			System.out.println("\nTodavia no se ha rellenado ninguna quiniela.");
			return;
		}
		
		System.out.println("\n=== SELECCIONAR QUINIELA ACTIVA ===");
		System.out.println("Seleccione una quiniela del rango 0 a " + quinielasJugadas + ":");
		System.out.println("(0 = Quiniela oficial)");
		
		int seleccion = sc.nextInt();
		sc.nextLine(); // Limpiar el buffer
		
		if (seleccion >= 0 && seleccion <= quinielasJugadas) {
			quinielaActiva = seleccion;
			if (seleccion == 0) {
				System.out.println("\nQuiniela oficial seleccionada como activa.");
			} else {
				System.out.println("\nQuiniela " + seleccion + " seleccionada como activa.");
			}
		} else {
			quinielaActiva = 0;
			System.out.println("\nOpcion fuera de rango. La quiniela activa es la quiniela oficial.");
		}
	}
	
	/**
	 * Opcion 4: Comprueba los aciertos de la quiniela activa con la oficial.
	 */
	private void comprobarAciertos() {
		if (quinielaActiva == 0) {
			System.out.println("\nLa quiniela activa es la oficial. No se pueden comprobar aciertos.");
			return;
		}
		
		int aciertos = quinielas[quinielaActiva].comprobarApuestas(quinielas[0]);
		System.out.println("\n=== COMPROBAR ACIERTOS ===");
		System.out.println("Numero de aciertos: " + aciertos + " de 15");
	}
	
	/**
	 * Opcion 5: Muestra los partidos de la jornada (de la quiniela oficial).
	 */
	private void mostrarPartidosJornada() {
		System.out.println("\n=== PARTIDOS DE LA JORNADA ===");
		quinielas[0].mostrarPartidos();
		System.out.println();
	}
	
	/**
	 * Opcion 6: Muestra los partidos y las apuestas de la quiniela activa.
	 */
	private void mostrarPartidosyApuestas() {
		System.out.println("\n=== PARTIDOS Y APUESTAS (QUINIELA ACTIVA) ===");
		if (quinielaActiva == 0) {
			System.out.println("Quiniela oficial:");
		} else {
			System.out.println("Quiniela " + quinielaActiva + ":");
		}
		quinielas[quinielaActiva].mostrarPartidosyApuestas();
		System.out.println();
	}
	
	/**
	 * Metodo main que inicia la aplicacion.
	 */
	public static void main(String[] args) {
		Quinielas_RESUELTO app = new Quinielas_RESUELTO();
		app.ejecutar();
	}
}
