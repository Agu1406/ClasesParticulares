package ev1.ut3_stringsyenvolventes.teoria;

/**
 * Teoria 3.1: la clase {@link String} en Java y su inmutabilidad.
 *
 * <p><b>Objetivo:</b> entender que un {@code String} no cambia de contenido tras crearse;
 * operaciones como {@code +} o {@code concat} generan <em>nuevos</em> objetos.
 * Distinguir {@code ==} (misma referencia) de {@code equals} (mismo contenido) y el pool
 * de literales de forma breve.</p>
 *
 * <p>Siguiente bloque: {@link U02_MetodosString}. Ejercicios 1–11 (strings), {@code E14_CompareTo}
 * y 12–13 (envolventes) en {@code ejercicios/}. Practica de centro en
 * {@code practicas/madridiescalderonbarcacadenas/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/08/2026
 * @see U02_MetodosString
 * @see U03_StringBuilderIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_StringInmutabilidad {

    public static void main(String[] args) {
        String original = "Hola";
        String referenciaMisma = original;

        // concat / + no modifican original: crean otro String
        String concatenado = original.concat(" mundo");
        String conMas = original + "!";

        System.out.println("original:     " + original);
        System.out.println("concatenado:  " + concatenado);
        System.out.println("con +:        " + conMas);
        System.out.println("original intacto: " + original.equals("Hola"));

        /*
         * += reserva un String nuevo en RAM (p. ej. "Daniel" + " Masso" -> "Daniel Masso")
         * y el recolector puede liberar el literal antiguo cuando ya no hay referencias.
         */
        String nombre1 = "Daniel";
        nombre1 += " Masso";
        System.out.println("tras +=: " + nombre1);

        /*
         * concat() tambien crea un String nuevo; si no se guarda el resultado,
         * el original sigue igual (error tipico en clase).
         */
        String nombre2 = "Agustin";
        nombre2.concat(" Pina");
        System.out.println("concat sin asignar (sigue Agustin): " + nombre2);
        nombre2 = nombre2.concat(" Pina");
        System.out.println("concat asignado: " + nombre2);

        // Literales iguales suelen compartir la misma referencia (string pool)
        String literalA = "Ana";
        String literalB = "Ana";
        String conNew = new String("Ana");

        System.out.println("literalA == literalB: " + (literalA == literalB));
        System.out.println("literalA == conNew:   " + (literalA == conNew));
        System.out.println("literalA.equals(conNew): " + literalA.equals(conNew));

        // == compara referencia; equals compara contenido
        System.out.println("original == referenciaMisma: " + (original == referenciaMisma));
    }
}
