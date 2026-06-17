package ev3.ut6_pooavanzadaestructuras.u05examenes.practicas.madridiesrosachacel15abril2024.resuelto.ejercicio_1;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * <p>Enunciado: {@code madrid-iesrosachacel-examenes-15-abril-2024.pdf} (ejercicio 1).</p>
 *
 * <p><b>OBJETIVO:</b> Gestionar apuntes economicos ({@link Factura}, {@link GastoEmpresarial}) en un
 * {@link HashMap}; crear, buscar y totalizar facturas por ejercicio con excepciones propias.</p>
 *
 * <br>
 *
 * <p><b>SOLUCION:</b> El {@code code} concatena anio y serial ({@code anio * 1000 + serial});
 * {@link #crearApunte} captura {@link NumberFormatException} e imprime {@code Operación anulada}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class GestionEconomica {

	private final Map<Integer, ApunteEconomico> apuntes = new HashMap<>();
	private int serial = 1;
	private final int anio = java.time.Year.now().getValue();

	public void crearApunte(String tipo, String importeTexto, String concepto, String dato1, String dato2) {
		try {
			double importe = Double.parseDouble(importeTexto.trim().replace(',', '.'));
			int code = anio * 1000 + serial++;

			if ("factura".equalsIgnoreCase(tipo)) {
				int idFactura = Integer.parseInt(dato1.trim());
				Factura factura = new Factura(code, importe, concepto, idFactura, dato2);
				apuntes.put(code, factura);
			} else if ("gasto".equalsIgnoreCase(tipo)) {
				GastoEmpresarial gasto = new GastoEmpresarial(code, importe, concepto, dato1, dato2);
				apuntes.put(code, gasto);
			} else {
				System.out.println("Operación anulada");
			}
		} catch (NumberFormatException e) {
			System.out.println("Operación anulada");
		}
	}

	public ApunteEconomico buscaApunte(int code) throws ApunteNoEncontradoException {
		ApunteEconomico apunte = apuntes.get(code);
		if (apunte == null) {
			throw new ApunteNoEncontradoException(code);
		}
		return apunte;
	}

	public double importeTotalFacturas(int ejercicio) throws EjercicioNoEncontradoException {
		boolean hayApuntesEnEjercicio = false;
		double total = 0;

		for (ApunteEconomico apunte : apuntes.values()) {
			if (apunte.getEjercicioActual() == ejercicio) {
				hayApuntesEnEjercicio = true;
				if (apunte instanceof Factura factura) {
					total += factura.getImporte();
				}
			}
		}

		if (!hayApuntesEnEjercicio) {
			throw new EjercicioNoEncontradoException(ejercicio);
		}
		return total;
	}

	public static void main(String[] args) {
		GestionEconomica gestion = new GestionEconomica();
		Scanner teclado = new Scanner(System.in);

		System.out.println("--- Crear dos apuntes ---");

		System.out.println("Apunte 1 - TIPO (factura/gasto): ");
		String tipo1 = teclado.nextLine().trim();
		System.out.println("IMPORTE: ");
		String importe1 = teclado.nextLine();
		System.out.println("CONCEPTO: ");
		String concepto1 = teclado.nextLine();
		System.out.println("DATO 1 (idFactura o fecha): ");
		String dato1a = teclado.nextLine();
		System.out.println("DATO 2 (emisor o DNIResponsable): ");
		String dato2a = teclado.nextLine();
		gestion.crearApunte(tipo1, importe1, concepto1, dato1a, dato2a);

		System.out.println("Apunte 2 - TIPO (factura/gasto): ");
		String tipo2 = teclado.nextLine().trim();
		System.out.println("IMPORTE: ");
		String importe2 = teclado.nextLine();
		System.out.println("CONCEPTO: ");
		String concepto2 = teclado.nextLine();
		System.out.println("DATO 1 (idFactura o fecha): ");
		String dato1b = teclado.nextLine();
		System.out.println("DATO 2 (emisor o DNIResponsable): ");
		String dato2b = teclado.nextLine();
		gestion.crearApunte(tipo2, importe2, concepto2, dato1b, dato2b);

		System.out.println("CODE A BUSCAR: ");
		try {
			int codeBusqueda = Integer.parseInt(teclado.nextLine().trim());
			ApunteEconomico apunte = gestion.buscaApunte(codeBusqueda);
			apunte.describe();
		} catch (ApunteNoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Operación anulada");
		}

		System.out.println("EJERCICIO (ANIO) PARA TOTAL FACTURAS: ");
		try {
			int ejercicio = Integer.parseInt(teclado.nextLine().trim());
			double total = gestion.importeTotalFacturas(ejercicio);
			System.out.println("Importe total de facturas: " + total);
		} catch (EjercicioNoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (NumberFormatException e) {
			System.out.println("Operación anulada");
		}
	}
}
