package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code madrid-iesrosachacel-examenes-15-abril-2024.pdf} (ejercicio 2).</p>
 *
 * <p><b>OBJETIVO:</b> Gestionar abonados de un gimnasio con {@link Abonado}, {@link AbonadoRegular},
 * {@link AbonadoVIP} y {@link Actividad}; menu con alta, registro, ingresos y listado por dia.</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> El maximo de actividades regulares se configura al inicio; las actividades se
 * leen por teclado en {@link Abonado#registrarActividad()}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		List<Abonado> abonados = new ArrayList<>();

		System.out.print("MAXIMO ACTIVIDADES ABONADO REGULAR: ");
		AbonadoRegular.configurarMaximo(Integer.parseInt(teclado.nextLine().trim()));

		int opcion;
		do {
			mostrarMenu();
			opcion = Integer.parseInt(teclado.nextLine().trim());

			switch (opcion) {
				case 1 -> insertarAbonado(teclado, abonados);
				case 2 -> registrarActividadAbonado(teclado, abonados);
				case 3 -> mostrarDineroRegulares(abonados);
				case 4 -> mostrarAbonadosPorDia(teclado, abonados);
				case 0 -> System.out.println("Saliendo...");
				default -> System.out.println("Opcion no valida");
			}
		} while (opcion != 0);
	}

	private static void mostrarMenu() {
		System.out.println();
		System.out.println("[1] Insertar abonado");
		System.out.println("[2] Registrar actividad");
		System.out.println("[3] Mostrar dinero abonados regulares");
		System.out.println("[4] Listado por dia de la semana");
		System.out.println("[0] Salir");
		System.out.print("OPCION: ");
	}

	private static void insertarAbonado(Scanner teclado, List<Abonado> abonados) {
		System.out.print("TIPO (regular/vip): ");
		String tipo = teclado.nextLine().trim();
		System.out.print("NIF: ");
		String nif = teclado.nextLine().trim();
		System.out.print("NOMBRE: ");
		String nombre = teclado.nextLine().trim();

		if ("regular".equalsIgnoreCase(tipo)) {
			abonados.add(new AbonadoRegular(nif, nombre));
		} else if ("vip".equalsIgnoreCase(tipo)) {
			abonados.add(new AbonadoVIP(nif, nombre));
		} else {
			System.out.println("Tipo de abonado no valido");
		}
	}

	private static void registrarActividadAbonado(Scanner teclado, List<Abonado> abonados) {
		System.out.print("NIF ABONADO: ");
		String nif = teclado.nextLine().trim();
		Abonado abonado = buscarAbonado(abonados, nif);

		if (abonado == null) {
			System.out.println("Abonado no encontrado");
			return;
		}

		if (abonado.registrarActividad()) {
			System.out.println("Actividad registrada");
		} else {
			System.out.println("No se pudo registrar la actividad");
		}
	}

	private static void mostrarDineroRegulares(List<Abonado> abonados) {
		double total = 0;
		for (Abonado abonado : abonados) {
			if (abonado instanceof AbonadoRegular regular) {
				for (Actividad actividad : regular.getActividades()) {
					total += actividad.getCuota();
				}
			}
		}
		System.out.println("Dinero por actividades de abonados regulares: " + total);
	}

	private static void mostrarAbonadosPorDia(Scanner teclado, List<Abonado> abonados) {
		System.out.print("DIA DE LA SEMANA (L/M/X/J/V/S/D): ");
		char dia = teclado.nextLine().trim().charAt(0);

		System.out.println("Abonados normales:");
		for (Abonado abonado : abonados) {
			if (abonado instanceof AbonadoRegular && tieneActividadEnDia(abonado, dia)) {
				System.out.println(abonado.getNombre());
			}
		}

		System.out.println("Abonados VIP:");
		for (Abonado abonado : abonados) {
			if (abonado instanceof AbonadoVIP && tieneActividadEnDia(abonado, dia)) {
				System.out.println(abonado.getNombre());
			}
		}
	}

	private static boolean tieneActividadEnDia(Abonado abonado, char dia) {
		for (Actividad actividad : abonado.getActividades()) {
			if (actividad.tieneDia(dia)) {
				return true;
			}
		}
		return false;
	}

	private static Abonado buscarAbonado(List<Abonado> abonados, String nif) {
		for (Abonado abonado : abonados) {
			if (abonado.getNif().equalsIgnoreCase(nif)) {
				return abonado;
			}
		}
		return null;
	}
}
