package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * Arrays 1D con valores iniciales, propiedad length y recorrido con for.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U03_ArraysLiteralesYLength {

    public static void main(String[] args) {

        /*
         * Si ya conocemos los datos, podemos declarar y rellenar en una sola linea.
         *
         * Posiciones    => [0][1][2][3]
         * Valores       => [10][20][30][40]
         */
        int[] notas = {10, 20, 30, 40};

        /*
         * length devuelve cuantas posiciones tiene el array (no el ultimo indice).
         * En notas, length es 4 e indices validos: 0, 1, 2, 3.
         */
        System.out.println("El array notas tiene " + notas.length + " elementos.");

        /*
         * Recorrido habitual con for: de 0 hasta length - 1.
         */
        System.out.print("Contenido de notas: ");
        for (int i = 0; i < notas.length; i++) {
            System.out.print(notas[i] + " ");
        }
        System.out.println();
    }
}
