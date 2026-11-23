package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * <p><b>OBJETIVO:</b> copiar un array pequeno dentro de uno mas grande a partir
 * de una posicion de inicio, sin salirse y dejando el resto del destino intacto.</p>
 *
 * <p>Practica en {@code E31_ArrayInsertarEnDestino}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U06_InsertarArrayEnOtro {

    public static void main(String[] args) {
        int[] destino = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] origen = {7, 8, 9};
        int inicio = 2;
        int indice;

        /*
         * destino (antes) => [0][0][0][0][0][0][0][0]
         * origen          => [7][8][9]
         * inicio = 2
         *
         * destino (despues) => [0][0][7][8][9][0][0][0]
         *
         * En el destino, la casilla inicio + i recibe origen[i].
         * El resto no se toca.
         */
        if (inicio >= 0 && inicio + origen.length <= destino.length) {
            for (indice = 0; indice < origen.length; indice++) {
                destino[inicio + indice] = origen[indice];
            }
        } else {
            System.out.println("No cabe: no se escribe nada.");
        }

        System.out.print("Destino: ");
        for (indice = 0; indice < destino.length; indice++) {
            System.out.print(destino[indice] + " ");
        }
        System.out.println();
    }
}
