package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Con los enteros 8, 15 y 3, muestra el mayor y el menor
 * usando solo el operador ternario.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Primero se comparan dos, y ese resultado se compara con el tercero.
 * Mayor 15, menor 3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 26/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E21_MayorDeTresTernario_Resuelto {
    public static void main(String[] args) {
        int a = 8;
        int b = 15;
        int c = 3;
        int mayor = a > b ? a : b;
        mayor = mayor > c ? mayor : c;
        int menor = a < b ? a : b;
        menor = menor < c ? menor : c;
        System.out.println(mayor);
        System.out.println(menor);
    }
}
