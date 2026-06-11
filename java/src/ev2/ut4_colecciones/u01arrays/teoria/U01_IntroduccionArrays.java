package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * Clase introductoria a los arrays de una dimension.
 *
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U01_IntroduccionArrays {

    public static void main(String[] args) {

        /*
         * Sintaxis para declarar / crear un array primitivo
         * de (en este caso) numeros enteros.
         *
         * Posiciones    => [0][1][2][3][4][5]
         * Valores       => [ ][ ][ ][ ][ ][ ]
         */
        int[] arrayNumerosEnteros = new int[6];

        /*
         * Para introducir datos en un array primitivo tenemos
         * que indicar en que posicion y que valor queremos
         * introducir ahi.
         *
         * Posiciones    => [0][1][2][3][4][5]
         * Valores       => [2][4][6][8][1][3]
         */
        arrayNumerosEnteros[0] = 2;
        arrayNumerosEnteros[1] = 4;
        arrayNumerosEnteros[2] = 6;
        arrayNumerosEnteros[3] = 8;
        arrayNumerosEnteros[4] = 1;
        arrayNumerosEnteros[5] = 3;

        /*
         * Para leer o imprimir los datos el proceso es similar:
         * indico el nombre del array y la posicion del dato.
         */
        System.out.println("En la posicion cero esta el numero: " + arrayNumerosEnteros[0]);

        /*
         * Tambien podemos copiar un valor del array en una variable,
         * indicando el nombre del array y la posicion.
         */
        int copiaValor = arrayNumerosEnteros[1];
        System.out.println("En la posicion uno esta el numero: " + copiaValor);
    }
}
