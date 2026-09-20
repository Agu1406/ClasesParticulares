package ev1.ut3_stringsyenvolventes.teoria;

import java.util.Scanner;

/**
 * Teoria: clases envolventes ({@link Integer}, {@link Double}, …) y conversion desde {@link String}.
 *
 * <p><b>Objetivo:</b> usar la libreria estandar de Java para convertir texto a numeros
 * ({@code Integer.parseInt}, {@code Double.parseDouble}), limpiar entrada ({@code trim},
 * reemplazo de coma), autoboxing basico y comparacion con {@code equals} frente a {@code ==}.</p>
 *
 * <p>Los tipos envolventes ya se nombraron en UT1; aqui se aplican junto a cadenas.
 * Bloques de String: {@link U01_StringInmutabilidad}, {@link U02_MetodosString},
 * {@link U03_StringBuilderIntro}. Ejercicios 12–13 en {@code ejercicios/pendientes} y
 * {@code ejercicios/resueltos}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/08/2026
 * @see U01_StringInmutabilidad
 * @see U02_MetodosString
 * @see U03_StringBuilderIntro
 * @see ev1.ut1_fundamentosjava.u02tiposvariablesconversion.teoria.U02_DatosAvanzados
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_EnvolventesIntro {

    public static void main(String[] args) {
        String textoEntero = "42";
        String textoDecimal = "3.14";

        int entero = Integer.parseInt(textoEntero);
        double decimal = Double.parseDouble(textoDecimal);

        Integer envolvente = entero;
        Integer otro = Integer.valueOf("42");

        System.out.println("Entero: " + entero);
        System.out.println("Decimal: " + decimal);
        System.out.println("Autoboxing: " + envolvente);
        System.out.println("valueOf: " + otro);
        System.out.println("equals: " + envolvente.equals(otro));
        System.out.println("== (referencias distintas): " + (envolvente == otro));

        // Entrada por teclado: validar/limpiar antes de parsear
        Scanner teclado = new Scanner(System.in);
        System.out.print("Introduce un numero (usa . o ,) --> ");
        String cadena = teclado.nextLine();
        cadena = cadena.replace(',', '.').trim();
        double leido = Double.parseDouble(cadena);
        int parteEntera = (int) leido;
        System.out.println("Double.parseDouble: " + leido);
        System.out.println("Casteo a int: " + parteEntera);
        teclado.close();
    }
}
