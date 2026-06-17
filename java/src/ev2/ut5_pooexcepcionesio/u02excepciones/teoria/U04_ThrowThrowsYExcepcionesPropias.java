package ev2.ut5_pooexcepcionesio.u02excepciones.teoria;

/**
 * Teoria: {@code throw}, {@code throws} y excepciones propias.
 *
 * <p><b>Objetivo:</b> lanzar excepciones cuando una regla de negocio no se cumple y
 * declarar metodos que pueden fallar con {@code throws}.</p>
 *
 * <p>Indice: {@link U01_ExcepcionesIntro}. Anterior: {@link U03_TryCatchFinallyIntro}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_ThrowThrowsYExcepcionesPropias {

	public static void main(String[] args) {
		System.out.println("=== THROW, THROWS Y EXCEPCIONES PROPIAS ===\n");

		ejemploThrowUnchecked(150);
		ejemploThrowUnchecked(-5);
		System.out.println();

		ejemploThrowsChecked(25);
		ejemploThrowsChecked(-3);
		System.out.println();

		ejemploDivisionConReglas(150, 3);
		ejemploDivisionConReglas(50, 2);
	}

	private static void ejemploThrowUnchecked(int descuento) {
		System.out.println("1) THROW con excepcion no comprobada (IllegalArgumentException)");
		System.out.println("   Descuento recibido: " + descuento);
		try {
			validarDescuento(descuento);
			System.out.println("   Descuento aceptado.");
		} catch (IllegalArgumentException e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	private static void validarDescuento(int descuento) {
		/*
		 * throw lanza la excepcion en ese punto.
		 * IllegalArgumentException extiende RuntimeException (no hace falta throws).
		 */
		if (descuento < 0 || descuento > 100) {
			throw new IllegalArgumentException("El descuento debe estar entre 0 y 100.");
		}
	}

	private static void ejemploThrowsChecked(int edad) {
		System.out.println("2) THROWS con excepcion comprobada propia");
		System.out.println("   Edad recibida: " + edad);
		try {
			validarEdad(edad);
			System.out.println("   Edad valida.");
		} catch (EdadInvalidaException e) {
			System.out.println("   Error: " + e.getMessage());
		}
	}

	private static void validarEdad(int edad) throws EdadInvalidaException {
		/*
		 * throws en la cabecera AVISA al que llama que el metodo puede lanzar
		 * esa excepcion comprobada. El llamador debe capturarla (try-catch)
		 * o volver a declarar throws.
		 */
		if (edad < 0 || edad > 120) {
			throw new EdadInvalidaException("Edad fuera de rango (0-120).");
		}
	}

	private static void ejemploDivisionConReglas(int dividendo, int divisor) {
		System.out.println("3) VARIAS REGLAS CON throw (como ejercicio 11)");
		System.out.println("   Operacion: " + dividendo + " / " + divisor);
		try {
			double resultado = dividirConReglas(dividendo, divisor);
			System.out.println("   Resultado: " + resultado);
		} catch (IllegalArgumentException e) {
			System.out.println("   Error de validacion: " + e.getMessage());
		} finally {
			System.out.println("   finally: fin del ejemplo.");
		}
	}

	private static double dividirConReglas(int dividendo, int divisor) {
		if (divisor == 0) {
			throw new IllegalArgumentException("El divisor no puede ser cero.");
		}
		if (dividendo <= 0) {
			throw new IllegalArgumentException("El dividendo debe ser positivo.");
		}
		if (dividendo <= 100) {
			throw new IllegalArgumentException("El dividendo debe ser mayor que 100.");
		}
		return (double) dividendo / divisor;
	}

	/*
	 * Excepcion propia COMPROBADA: extiende Exception.
	 * Obliga a tratarla con try-catch o throws.
	 */
	static class EdadInvalidaException extends Exception {

		public EdadInvalidaException(String mensaje) {
			super(mensaje);
		}
	}
}
