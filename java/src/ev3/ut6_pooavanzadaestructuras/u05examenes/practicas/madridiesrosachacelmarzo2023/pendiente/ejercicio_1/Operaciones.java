package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelmarzo2023.pendiente.ejercicio_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code madrid-iesrosachacel-examenes-marzo-2023.pdf}.</p>
 */
public class Operaciones {

	static void main() {
		/*
		 * Creo y lleno la lista de codigos posibles con 10 codigos
		 * ficticios del 100 al 109.
		 */
		List<Integer> codigosPosibles = new ArrayList<>();
		for (int codigo = 100; codigo < 110; codigo++) {
			codigosPosibles.add(codigo);
		}
		// Creo un nuevo concierto usando esos posibles codigos de entrada.
		Concierto concierto = new Concierto("Bad Bunny", 100, 150, codigosPosibles);

		// TODO: crear otro concierto y probar los cinco metodos del PDF
		throw new UnsupportedOperationException();
	}

	public int venderEntrada(Concierto concierto) throws ConciertosException {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		boolean opcionValida = false;
		do {
			System.out.println("¿Que entrada deseas comprar? Elige una opción: \n" +
					"[1] Entrada VIP. \n" +
					"[2] Entrada General. \n" +
					"Introduce una opción: ");
			opcion = teclado.nextInt();

			if (opcion == 1) {
				opcionValida = true;
			} else if (opcion == 2) {
				opcionValida = true;
			} else {
				System.out.println("¡Error! Introduce una opción valida.");
			}
		} while (!opcionValida);

		// TODO: completar la venta y devolver el codigo asignado
		throw new UnsupportedOperationException();
	}

	public double ingresosConcierto(Concierto concierto) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public Concierto conciertoMasExito(Concierto[] conciertos) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void comprobarEntrada(Concierto concierto, int codigo) {
		// TODO
		throw new UnsupportedOperationException();
	}

	public void comprobarTipoEntrada(String nombre, Concierto concierto) throws ConciertosException {
		// TODO
		throw new UnsupportedOperationException();
	}
}
