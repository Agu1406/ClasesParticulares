package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacelmarzo2023.resuelto.ejercicio_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code madrid-iesrosachacel-examenes-marzo-2023.pdf}.</p>
 */
public class Operaciones {

	static void main() {
		Operaciones operaciones = new Operaciones();
		Scanner teclado = new Scanner(System.in);

		/*
		 * Creo y lleno la lista de codigos posibles con 10 codigos
		 * ficticios del 100 al 109.
		 */
		List<Integer> codigosPosibles1 = new ArrayList<>();
		for (int codigo = 100; codigo < 110; codigo++) {
			codigosPosibles1.add(codigo);
		}
		// Creo un nuevo concierto usando esos posibles codigos de entrada.
		Concierto concierto1 = new Concierto("Bad Bunny", 100, 150, codigosPosibles1);

		/*
		 * Creo un segundo concierto con otros codigos para probar
		 * conciertoMasExito.
		 */
		List<Integer> codigosPosibles2 = new ArrayList<>();
		for (int codigo = 200; codigo < 205; codigo++) {
			codigosPosibles2.add(codigo);
		}
		Concierto concierto2 = new Concierto("Rosalia", 80, 120, codigosPosibles2);

		try {
			// Pruebo venderEntrada en el primer concierto.
			System.out.println("--- venderEntrada (concierto 1) ---");
			int codigoVendido = operaciones.venderEntrada(concierto1);
			System.out.println("Codigo asignado: " + codigoVendido);

			// Pruebo venderEntrada dos veces en el segundo concierto.
			System.out.println("--- venderEntrada (concierto 2) ---");
			operaciones.venderEntrada(concierto2);
			operaciones.venderEntrada(concierto2);

			// Pruebo ingresosConcierto.
			System.out.println("--- ingresosConcierto ---");
			double ingresos = operaciones.ingresosConcierto(concierto1);
			System.out.println("Total ingresado: " + ingresos);

			// Pruebo conciertoMasExito.
			System.out.println("--- conciertoMasExito ---");
			Concierto[] conciertos = {concierto1, concierto2};
			Concierto masExito = operaciones.conciertoMasExito(conciertos);
			System.out.println("Con mas entradas vendidas: " + masExito.getNombreGrupo());

			// Pruebo comprobarEntrada con el codigo vendido antes.
			System.out.println("--- comprobarEntrada ---");
			operaciones.comprobarEntrada(concierto1, codigoVendido);

			// Pruebo comprobarTipoEntrada.
			System.out.println("--- comprobarTipoEntrada ---");
			System.out.print("NOMBRE COMPRADOR: ");
			String nombre = teclado.nextLine().trim();
			operaciones.comprobarTipoEntrada(nombre, concierto1);
		} catch (ConciertosException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		main();
	}

	public int venderEntrada(Concierto concierto) throws ConciertosException {
		if (concierto.getCodigosPosibles().isEmpty()) {
			throw new ConciertosException("No quedan codigos de entrada disponibles para el concierto");
		}

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

		teclado.nextLine();
		System.out.print("NOMBRE COMPRADOR: ");
		String nombreComprador = teclado.nextLine().trim();

		// Cojo el primer codigo de la lista y lo elimino.
		int codigo = concierto.getCodigosPosibles().remove(0);
		Entrada entrada;

		if (opcion == 2) {
			entrada = new EntradaGeneral(codigo, concierto.getPrecioEntradaGeneral(), nombreComprador);
		} else {
			System.out.print("BUTACA: ");
			String butaca = teclado.nextLine().trim();
			entrada = new EntradaVIP(codigo, concierto.getPrecioEntradaVip(), nombreComprador, butaca);
		}

		concierto.getEntradasVendidas().add(entrada);
		return codigo;
	}

	public double ingresosConcierto(Concierto concierto) {
		double total = 0;
		for (Entrada entrada : concierto.getEntradasVendidas()) {
			double importe = entrada.devolverPrecioEntrada();
			System.out.println(importe);
			total = total + importe;
		}
		return total;
	}

	public Concierto conciertoMasExito(Concierto[] conciertos) {
		Concierto masExito = conciertos[0];
		for (Concierto concierto : conciertos) {
			if (concierto.getEntradasVendidas().size() > masExito.getEntradasVendidas().size()) {
				masExito = concierto;
			}
		}
		return masExito;
	}

	public void comprobarEntrada(Concierto concierto, int codigo) {
		for (Entrada entrada : concierto.getEntradasVendidas()) {
			if (entrada.comprobarEntrada(codigo)) {
				System.out.println(entrada);
			}
		}
	}

	public void comprobarTipoEntrada(String nombre, Concierto concierto) throws ConciertosException {
		for (Entrada entrada : concierto.getEntradasVendidas()) {
			if (entrada instanceof EntradaGeneral general
					&& general.nombreComprador.equalsIgnoreCase(nombre)) {
				System.out.println("General");
				return;
			}
			if (entrada instanceof EntradaVIP vip
					&& vip.nombreComprador.equalsIgnoreCase(nombre)) {
				System.out.println("VIP");
				return;
			}
		}
		throw new ConciertosException("No se ha encontrado ninguna entrada para el comprador " + nombre);
	}
}
