package ev2.ut5_pooexcepcionesio.u02excepciones.teoria;

/**
 * Teoria: que es una excepcion y tipos habituales en Java.
 *
 * <p><b>Objetivo:</b> entender que una excepcion es un fallo en tiempo de ejecucion y
 * reconocer las mas usadas en los ejercicios del subtema.</p>
 *
 * <p>Indice: {@link U01_ExcepcionesIntro}. Siguiente: {@link U03_TryCatchFinallyIntro}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U02_ExcepcionesConceptos {

	public static void main(String[] args) {
		System.out.println("=== EXCEPCIONES: CONCEPTOS ===\n");

		/*
		 * Una excepcion aparece cuando algo sale mal al EJECUTAR el programa.
		 * No es un error de compilacion: el .java compila, pero falla al correr.
		 *
		 * Sin try-catch el programa se detiene y muestra el "stack trace".
		 * Con try-catch podemos capturar el fallo y seguir.
		 */
		System.out.println("1) SIN try-catch: el programa se detendria.");
		System.out.println("   (Aqui no lo forzamos para que la demo continue.)\n");

		/*
		 * NumberFormatException: Integer.parseInt("abc") no puede convertir texto a numero.
		 */
		System.out.println("2) NumberFormatException");
		mostrarErrorControlado(() -> Integer.parseInt("abc"));

		/*
		 * ArithmeticException: division entre cero con enteros (10 / 0).
		 */
		System.out.println("3) ArithmeticException");
		mostrarErrorControlado(() -> {
			int x = 10 / 0;
			System.out.println(x);
		});

		/*
		 * NullPointerException: usar un objeto que vale null (texto.length()).
		 */
		System.out.println("4) NullPointerException");
		mostrarErrorControlado(() -> {
			String texto = null;
			System.out.println(texto.length());
		});

		/*
		 * ArrayIndexOutOfBoundsException: indice fuera del array (a[5] con tamano 2).
		 */
		System.out.println("5) ArrayIndexOutOfBoundsException");
		mostrarErrorControlado(() -> {
			int[] numeros = {10, 20};
			System.out.println(numeros[5]);
		});

		System.out.println("\nResumen de tipos habituales en este subtema:");
		System.out.println("  - NumberFormatException  -> parseo incorrecto");
		System.out.println("  - ArithmeticException    -> division entre cero");
		System.out.println("  - NullPointerException   -> objeto null");
		System.out.println("  - ArrayIndexOutOfBoundsException -> indice invalido");
		System.out.println("\nSiguiente paso: U03_TryCatchFinallyIntro");
	}

	private static void mostrarErrorControlado(Runnable operacion) {
		try {
			operacion.run();
			System.out.println("   Operacion correcta.");
		} catch (Exception e) {
			System.out.println("   Capturado: " + e.getClass().getSimpleName());
			System.out.println("   Mensaje: " + e.getMessage());
		}
		System.out.println();
	}
}
