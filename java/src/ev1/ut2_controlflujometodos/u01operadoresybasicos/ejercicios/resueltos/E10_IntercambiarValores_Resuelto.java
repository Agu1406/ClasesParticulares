package ev1.ut2_controlflujometodos.u01operadoresybasicos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea dos enteros con valores distintos, muestra ambos,
 * intercámbialos con una variable auxiliar y vuelve a mostrarlos.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Se guarda {@code a} en {@code auxiliar} antes de pisarlo.
 * Con 7 y 3, después del cambio quedan 3 y 7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E10_IntercambiarValores_Resuelto {
    public static void main(String[] args) {
        int a = 7;
        int b = 3;
        System.out.println(a + " " + b);
        int auxiliar = a;
        a = b;
        b = auxiliar;
        System.out.println(a + " " + b);
    }
}
