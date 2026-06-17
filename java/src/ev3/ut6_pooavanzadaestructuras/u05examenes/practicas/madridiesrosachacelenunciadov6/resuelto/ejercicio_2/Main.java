package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelenunciadov6.resuelto.ejercicio_2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code madrid-iesrosachacel-examenes-enunciado-v6.pdf} (ejercicio 2).</p>
 *
 * <p><b>OBJETIVO:</b> Gestionar una coleccion de particulas: alta, busqueda por rango de masa,
 * eliminacion de la mas cercana a una posicion y consulta de mayor masa.</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> {@link ArrayList} de {@link Particula}; metodos estaticos con bucles
 * {@code for}; la distancia se calcula en {@link Main} con {@code Math.sqrt}.</p>
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
		Scanner teclado = new Scanner(System.in);
		double masaMinima, masaMaxima;

		System.out.print("INTRODUCE LA MASA MINIMA: ");
		masaMinima = teclado.nextDouble();
		System.out.println();

		System.out.print("INTRODUCE LA MASA MAXIMA: ");
		masaMaxima = teclado.nextDouble();
		System.out.println();

		for (Particula particula : listaParticulas) {
			if (particula.getMasa() >= masaMinima && particula.getMasa() <= masaMaxima) {
				System.out.println(particula);
			}
		}
	}

	/**
	 * C.R.U.D (Create, Read, Update, Delete) - Borrar la particula mas cercana a una posicion.
	 *
	 * @param listaParticulas lista de particulas
	 */
	private static void eliminarMasCercanaPosicion(ArrayList<Particula> listaParticulas) {
		if (listaParticulas.isEmpty()) {
			System.out.println("¡Error! No hay particulas en la lista.");
			return;
		}

		Scanner teclado = new Scanner(System.in);
		int posicionX, posicionY;

		System.out.print("INTRODUCE LA POSICION X: ");
		posicionX = teclado.nextInt();
		System.out.println();

		System.out.print("INTRODUCE LA POSICION Y: ");
		posicionY = teclado.nextInt();
		System.out.println();

		Punto objetivo = new Punto(posicionX, posicionY);
		Particula masCercana = listaParticulas.get(0);
		double distanciaMinima = calcularDistancia(masCercana.getPosicion(), objetivo);

		for (Particula particula : listaParticulas) {
			double distancia = calcularDistancia(particula.getPosicion(), objetivo);
			if (distancia < distanciaMinima) {
				distanciaMinima = distancia;
				masCercana = particula;
			}
		}

		listaParticulas.remove(masCercana);
		System.out.println("Particula eliminada: " + masCercana);
	}

	/**
	 * Calcula la distancia entre la posicion de una particula y un punto objetivo.
	 */
	private static double calcularDistancia(Punto posicionParticula, Punto objetivo) {
		int diferenciaX = posicionParticula.getX() - objetivo.getX();
		int diferenciaY = posicionParticula.getY() - objetivo.getY();
		double distancia = Math.sqrt(diferenciaX * diferenciaX + diferenciaY * diferenciaY);
		return distancia;
	}

	/**
	 * C.R.U.D (Create, Read, Update, Delete) - Mostrar la particula con mayor masa.
	 *
	 * @param listaParticulas lista de particulas
	 */
	private static void mostrarParticulaMayorMasa(ArrayList<Particula> listaParticulas) {
		if (listaParticulas.isEmpty()) {
			System.out.println("¡Error! No hay particulas en la lista.");
			return;
		}

		Particula mayor = listaParticulas.get(0);

		for (Particula particula : listaParticulas) {
			if (particula.getMasa() > mayor.getMasa()) {
				mayor = particula;
			}
		}

		System.out.println("Particula con mayor masa: " + mayor);
	}
}
