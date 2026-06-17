package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.pendiente.ejercicio_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code madrid-iesrosachacel-examenes-enunciado-v6.pdf} (ejercicio 2).</p>
 *
 * <p><b>OBJETIVO:</b> Completar la aplicacion de particulas: alta, busqueda por rango de masa,
 * eliminacion de la mas cercana a una posicion y consulta de mayor masa.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main {

	public static void main(String[] args) {
		ArrayList<Particula> listaParticulas = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);
		int opcion;

		do {
			imprimirMenu();
			opcion = teclado.nextInt();

			switch (opcion) {
				case 1:
					anadirParticula(listaParticulas);
					break;
				case 2:
					buscarPorRangoMasa(listaParticulas);
					break;
				case 3:
					eliminarMasCercanaPosicion(listaParticulas);
					break;
				case 4:
					mostrarParticulaMayorMasa(listaParticulas);
					break;
				case 5:
					System.out.println("¡Hasta luego! Fin del programa.");
					break;
				default:
					System.out.println("¡Error! Opcion no valida.");
					break;
			}

		} while (opcion != 5);
	}

	static void imprimirMenu() {
		System.out.println("¡Menu de opciones! \n" +
				"[1]. Añadir particula. \n" +
				"[2]. Buscar particula por rango de masa. \n" +
				"[3]. Eliminar particula mas cercana a una posicion. \n" +
				"[4]. Mostrar la particula con mayor masa. \n" +
				"[5]. Salir \n" +
				"\n" +
				"INTRODUCE UNA OPCION: ");
	}

	/**
	 * C.R.U.D (Create, Read, Update, Delete) - Crear una particula.
	 *
	 * @param listaParticulas lista de particulas
	 */
	private static void anadirParticula(ArrayList<Particula> listaParticulas) {
		Scanner teclado = new Scanner(System.in);
		int cargaElectrica, posicionX, posicionY;
		double masa;

		System.out.print("INTRODUCE LA CARGA ELECTRICA: ");
		cargaElectrica = teclado.nextInt();
		System.out.println();

		System.out.print("INTRODUCE LA MASA: ");
		masa = teclado.nextDouble();
		System.out.println();

		System.out.print("INTRODUCE LA POSICION X: ");
		posicionX = teclado.nextInt();
		System.out.println();

		System.out.print("INTRODUCE LA POSICION Y: ");
		posicionY = teclado.nextInt();
		System.out.println();

		Punto objetoPunto = new Punto(posicionX, posicionY);
		Particula particula = new Particula(cargaElectrica, masa, objetoPunto);

		listaParticulas.add(particula);
	}

	/**
	 * C.R.U.D (Create, Read, Update, Delete) - Leer particulas por rango de masa.
	 *
	 * @param listaParticulas lista de particulas
	 */
	private static void buscarPorRangoMasa(ArrayList<Particula> listaParticulas) {
		// TODO
		throw new UnsupportedOperationException();
	}

	/**
	 * C.R.U.D (Create, Read, Update, Delete) - Borrar la particula mas cercana a una posicion.
	 *
	 * @param listaParticulas lista de particulas
	 */
	private static void eliminarMasCercanaPosicion(ArrayList<Particula> listaParticulas) {
		// TODO: pedir posicion X/Y, recorrer la lista y calcular distancia en Main
		//       (diferenciaX, diferenciaY y Math.sqrt); eliminar la mas cercana
		throw new UnsupportedOperationException();
	}

	/**
	 * C.R.U.D (Create, Read, Update, Delete) - Mostrar la particula con mayor masa.
	 *
	 * @param listaParticulas lista de particulas
	 */
	private static void mostrarParticulaMayorMasa(ArrayList<Particula> listaParticulas) {
		// TODO
		throw new UnsupportedOperationException();
	}
}
