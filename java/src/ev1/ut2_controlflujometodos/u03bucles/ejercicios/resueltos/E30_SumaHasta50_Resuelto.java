package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un do-while para sumar 1, 2, 3... hasta que la suma supere 50. Muestra Suma final: con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El cuerpo suma primero y la condicion se mira despues. El bucle sigue mientras la suma sea menor o igual que 50.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E30_SumaHasta50_Resuelto {
    public static void main(String[] args) {
        int suma = 0;
        int i = 1;
        do {
            suma += i;
            i++;
        } while (suma <= 50);
        System.out.println("Suma final: " + suma);
    }
}
