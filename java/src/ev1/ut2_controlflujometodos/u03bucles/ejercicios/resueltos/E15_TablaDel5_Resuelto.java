package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un while para mostrar la tabla de multiplicar del 5, del 1 al 10, con el formato 5 x numero = resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Cada vuelta imprime 5 * numero y luego incrementa numero.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E15_TablaDel5_Resuelto {
    public static void main(String[] args) {
        int numero = 1;
        while (numero <= 10) {
            System.out.println("5 x " + numero + " = " + (5 * numero));
            numero++;
        }
    }
}
