package ev1.ut3_stringsyenvolventes.teoria;

/**
 * Teoria 3.3: introduccion a {@link StringBuilder} para optimizacion de memoria.
 *
 * <p><b>Objetivo:</b> ver que {@code StringBuilder} es <em>mutable</em>: {@code append}
 * modifica el mismo objeto. En bucles con muchas concatenaciones evita crear un
 * {@code String} nuevo en cada paso (a diferencia de {@code +=} con {@code String}).</p>
 *
 * <p>Bloque anterior: {@link U02_MetodosString}. Siguiente: {@link U04_EnvolventesIntro}.
 * Practica: {@code Ejercicio9_StringBuilder} en {@code ejercicios/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/08/2026
 * @see U01_StringInmutabilidad
 * @see U02_MetodosString
 * @see U04_EnvolventesIntro
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_StringBuilderIntro {

    public static void main(String[] args) {
        /*
         * StringBuilder no crea un String nuevo en cada modificacion:
         * usa un buffer mutable y al final se obtiene el texto con toString().
         */
        StringBuilder sb = new StringBuilder();
        sb.append("Hola");
        sb.append(' ');
        sb.append("mundo");
        sb.append('!');
        System.out.println("StringBuilder: " + sb.toString());

        // Contraste: += con String crea objetos intermedios en cada vuelta
        String conMas = "";
        for (int i = 1; i <= 5; i++) {
            conMas += i;
            if (i < 5) {
                conMas += ", ";
            }
        }
        System.out.println("Con += (String): " + conMas);

        // Preferible en bucles: un solo buffer mutable
        StringBuilder enBucle = new StringBuilder();
        enBucle.append("Numeros: ");
        for (int i = 1; i <= 5; i++) {
            enBucle.append(i);
            if (i < 5) {
                enBucle.append(", ");
            }
        }
        System.out.println("Con StringBuilder: " + enBucle);
    }
}
