package ev3.ut6_pooavanzadaestructuras.u01herenciapolimorfismo.practicas.madridiesventurarodriguezgestionempresarial;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Validacion y formato de DNI/NIF espanol.
 *
 * <p>Enunciado: {@code madrid-iesventurarodriguez-gestion-empresarial.md}.
 * Solucion de referencia en {@code ClaseDNI_RESUELTO.java}.</p>
 *
 * @author Paula Diaz (codigo original)
 * @author Agustin. A. Marquez. Pina (adaptacion al repo)
 * @since 03/06/2026
 */
public class ClaseDNI_SIN_RESOLVER {

	private final int numeroDNI;
	private static final String DIGITOS_DE_CONTROL = "TRWAGMYFPDXBNJZSQVHLCKE";

	public ClaseDNI_SIN_RESOLVER(int numeroDNI) {
		this.numeroDNI = numeroDNI;
	}

	@Override
	public String toString() {
		return "Numero DNI= " + numeroDNI + ", LETRA= " + calcularLetraNIF(numeroDNI);
	}

	private static char calcularLetraNIF(int dni) {
		// TODO: calcular la letra de control del NIF con DIGITOS_DE_CONTROL
		return 'T';
	}

	public static boolean validarNIF(String numeroNIF) {
		// TODO: comprobar formato 8 digitos + letra y que la letra sea correcta
		return false;
	}

	public static String aniadirCerosHasta9CharsDNI(String dni) {
		// TODO: rellenar con ceros a la izquierda hasta 9 caracteres y validar formato
		if (dni == null) {
			throw new InputMismatchException("El Dni no puede ser nulo");
		}
		return dni;
	}

	public static String pedirDniHastaRecibirUnoValido() {
		// TODO: pedir DNI por teclado hasta que validarNIF devuelva true
		Scanner scanner = new Scanner(System.in);
		System.out.print("Introduce un DNI: ");
		return scanner.nextLine().toUpperCase();
	}

	public int getNumeroDNI() {
		return numeroDNI;
	}

	public String getNumeroNIF() {
		return String.valueOf(getNumeroDNI()) + calcularLetraNIF(numeroDNI);
	}
}
