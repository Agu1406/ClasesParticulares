package ev2.ut4_colecciones.u01arrays.teoria;

/**
 * <p><b>OBJETIVO:</b> buscar la primera aparicion de un valor y contar cuantas
 * veces aparece en un array (patrones de U2A8).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 18/11/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U11_BuscarYContar {

    public static void main(String[] args) {
        int[] datos = {3, 7, 3, 9, 3, 1};
        int buscado;
        int primera;
        int cuenta;
        int posicion;

        buscado = 3;
        primera = -1;
        cuenta = 0;

        for (posicion = 0; posicion < datos.length; posicion++) {
            if (datos[posicion] == buscado) {
                if (primera < 0) {
                    primera = posicion;
                }
                cuenta++;
            }
        }

        System.out.println("Primera posicion de " + buscado + ": " + primera);
        System.out.println("Cuantas veces: " + cuenta);
    }
}
