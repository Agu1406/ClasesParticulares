package ev2.ut4_colecciones.u01arrays.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> escribe {@code insertar(destino, origen, inicio)} que copia
 * todo {@code origen} dentro de {@code destino} desde la posicion {@code inicio}.
 * Si no cabe completo, no escribe nada. Ejemplo: destino
 * {@code [0,0,0,0,0,0,0,0]}, origen {@code [7,8,9]}, inicio {@code 2}
 * → {@code [0,0,7,8,9,0,0,0]}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> si {@code inicio < 0} o {@code inicio + origen.length}
 * supera {@code destino.length}, no hace nada; si cabe, copia con
 * {@code destino[inicio + i] = origen[i]}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 17/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E31_ArrayInsertarEnDestino_Resuelto {

    /**
     * Copia origen dentro de destino desde inicio.
     * Si no cabe entero, no modifica destino.
     *
     * @param destino array grande donde se escribe
     * @param origen  array pequeno a copiar
     * @param inicio  primera posicion del destino que recibe origen[0]
     */
    public static void insertar(int[] destino, int[] origen, int inicio) {
        int indice;

        if (inicio < 0 || inicio + origen.length > destino.length) {
            return;
        }

        for (indice = 0; indice < origen.length; indice++) {
            destino[inicio + indice] = origen[indice];
        }
    }

    /**
     * Muestra los elementos del array separados por espacios.
     *
     * @param array array a mostrar
     */
    public static void mostrar(int[] array) {
        int indice;

        for (indice = 0; indice < array.length; indice++) {
            System.out.print(array[indice] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] destino = {0, 0, 0, 0, 0, 0, 0, 0};
        int[] origen = {7, 8, 9};

        insertar(destino, origen, 2);

        System.out.print("Destino tras insertar: ");
        mostrar(destino);

        // No cabe: no debe cambiar
        insertar(destino, origen, 7);
        System.out.print("Destino si no cabe:    ");
        mostrar(destino);
    }
}
