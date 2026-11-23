package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * <p><b>OBJETIVO:</b> copiar un array en otro independiente (mismo tamano y valores)
 * y entender por que {@code destino = origen} no duplica el array.</p>
 *
 * <p>Practica en {@code E13_ArrayCopiarFusionar}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_CopiarArrays {

    public static void main(String[] args) {
        int[] origen = {10, 20, 30, 40};
        int[] malCopia;
        int[] buenaCopia;
        int indice;

        /*
         * MAL: esto no crea un array nuevo.
         * origen y malCopia apuntan al MISMO sitio en memoria.
         * Si cambias uno, "cambia" el otro.
         *
         * origen     => [10][20][30][40]
         * malCopia   => (misma caja)
         */
        malCopia = origen;
        malCopia[0] = 99;
        System.out.println("Tras malCopia[0]=99, origen[0] vale: " + origen[0]);

        // Restauramos el ejemplo
        origen[0] = 10;

        /*
         * BIEN: creamos un array nuevo del mismo tamano
         * y copiamos posicion a posicion.
         *
         * origen     => [10][20][30][40]
         * buenaCopia => [10][20][30][40]   (otra caja)
         */
        buenaCopia = new int[origen.length];
        for (indice = 0; indice < origen.length; indice++) {
            buenaCopia[indice] = origen[indice];
        }

        buenaCopia[0] = 77;
        System.out.println("buenaCopia[0] = " + buenaCopia[0]
                + " | origen[0] sigue = " + origen[0]);

        /*
         * Fusionar (poner uno detras del otro) es otro paso:
         * el resultado mide origen.length + otro.length.
         * Practica en E13_ArrayCopiarFusionar.
         */
    }
}
