package ev2.ut5_pooexcepcionesio.u02excepciones.teoria;

/**
 * Teoria: {@code try}, {@code catch} y {@code finally} en Java.
 *
 * <p><b>Objetivo:</b> capturar errores en tiempo de ejecucion sin detener todo el programa
 * y ejecutar codigo de limpieza con {@code finally}.</p>
 *
 * <p>Indice: {@link U01_ExcepcionesIntro}. Anterior: {@link U02_ExcepcionesConceptos}.
 * Siguiente: {@link U04_ThrowThrowsYExcepcionesPropias}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_TryCatchFinallyIntro {

	public static void main(String[] args) {
		System.out.println("=== TRY - CATCH - FINALLY ===\n");

		ejemploBasico();
		System.out.println();

		ejemploMultiplesCatch("20", "0");
		ejemploMultiplesCatch("hola", "5");
		System.out.println();

		ejemploFinally();
		System.out.println();

		ejemploCatchGenerico();
	}

	private static void ejemploBasico() {
		System.out.println("1) TRY-CATCH BASICO (division entre cero)");
		/*
		 * try     -> codigo que puede fallar
		 * catch   -> que hacer si falla (solo se ejecuta UN catch por fallo)
		 */
		try {
			int resultado = 10 / 0;
			System.out.println("Resultado: " + resultado);
		} catch (ArithmeticException e) {
			System.out.println("Error: no se puede dividir entre cero.");
		}
	}

	private static void ejemploMultiplesCatch(String textoNumero, String textoDivisor) {
		System.out.println("2) VARIOS CATCH con entradas: " + textoNumero + " y " + textoDivisor);
		/*
		 * Puedes poner varios catch. Java entra en el primero que coincida.
		 * Orden recomendado: de mas concreto a mas general.
		 */
		try {
			int numero = Integer.parseInt(textoNumero);
			int divisor = Integer.parseInt(textoDivisor);
			int resultado = numero / divisor;
			System.out.println("Resultado: " + resultado);
		} catch (NumberFormatException e) {
			System.out.println("Error: debes escribir numeros validos.");
		} catch (ArithmeticException e) {
			System.out.println("Error: no se puede dividir entre cero.");
		}
	}

	private static void ejemploFinally() {
		System.out.println("3) FINALLY (siempre se ejecuta)");
		try {
			System.out.println("Dentro del try.");
			int valor = 5 / 0;
			System.out.println(valor);
		} catch (ArithmeticException e) {
			System.out.println("Se capturo: " + e.getClass().getSimpleName());
		} finally {
			/*
			 * finally se ejecuta SIEMPRE: haya excepcion o no.
			 * Sirve para cerrar ficheros, liberar recursos, mensajes de cierre...
			 */
			System.out.println("finally: bloque de limpieza.");
		}
	}

	private static void ejemploCatchGenerico() {
		System.out.println("4) CATCH GENERICO (Exception)");
		try {
			Integer.parseInt("xyz");
		} catch (Exception e) {
			/*
			 * Exception es la clase base de muchas excepciones.
			 * Captura cualquier fallo que sea Exception o subclase.
			 * En ejercicios 1-4 suele usarse un solo catch(Exception e).
			 */
			System.out.println("Error controlado: " + e.getClass().getSimpleName());
		}
	}
}
