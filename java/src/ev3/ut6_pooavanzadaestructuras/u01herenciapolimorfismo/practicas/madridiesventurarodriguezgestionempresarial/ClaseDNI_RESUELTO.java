package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Validacion y formato de DNI/NIF espanol.
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.</p>
 *
 * @author Paula Diaz (codigo original)
 * @author Agustin. A. Marquez. Pina (adaptacion al repo)
 * @since 03/06/2026
 */
public class ClaseDNI_RESUELTO {

	private final int numeroDNI;
	private static final String DIGITOS_DE_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";

	public ClaseDNI_RESUELTO(int numeroDNI) {
		this.numeroDNI = numeroDNI;
	}

	@Override
	public String toString() {
		return "Numero DNI= " + numeroDNI + ", LETRA= " + calcularLetraNIF(numeroDNI);
	}

	private static char calcularLetraNIF(int dni) {
		return DIGITOS_DE_CONTROL.charAt(dni % 23);
	}

	public static boolean validarNIF(String numeroNIF) {
		String nif = numeroNIF.toUpperCase();
		String nifRegex = "[0-9]{8}[A-Z]";
		return nif.matches(nifRegex)
				&& nif.charAt(8) == calcularLetraNIF(Integer.parseInt(nif.substring(0, 8)));
	}

	public static String aniadirCerosHasta9CharsDNI(String dni) {
		if (dni == null) {
			throw new InputMismatchException("El Dni no puede ser nulo");
		}
		if (dni.length() > 9) {
			throw new InputMismatchException("Dni mas largo de 9 caracteres");
		}
		if (Character.isDigit(dni.charAt(dni.length() - 1))) {
			throw new InputMismatchException("El ultimo caracter del DNI no es una letra");
		}
		while (dni.length() < 9) {
			dni = "0" + dni;
		}
		return dni;
	}

	public static String pedirDniHastaRecibirUnoValido() {
		Scanner scanner = new Scanner(System.in);
		String dni = null;
		do {
			try {
				System.out.print("Introduce un DNI: ");
				String dniTemporal = scanner.nextLine().toUpperCase();
				dniTemporal = aniadirCerosHasta9CharsDNI(dniTemporal);
				if (validarNIF(dniTemporal)) {
					dni = dniTemporal;
				} else {
					throw new InputMismatchException("El DNI no es valido");
				}
			} catch (InputMismatchException exc) {
				System.out.println(exc.getMessage());
			}
		} while (dni == null);
		return dni;
	}

	public int getNumeroDNI() {
		return numeroDNI;
	}

	public String getNumeroNIF() {
		return String.valueOf(getNumeroDNI()) + calcularLetraNIF(numeroDNI);
	}
}
