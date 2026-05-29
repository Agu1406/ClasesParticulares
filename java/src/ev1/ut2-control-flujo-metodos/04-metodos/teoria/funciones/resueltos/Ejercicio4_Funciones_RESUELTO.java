package general.funciones;

/**
 * Ejercicio 4: Función que retorna double
 * Versión resuelta.
 *
 * @author Agustín. A. Marquez. Piña
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_Funciones_RESUELTO {

    public static double calcularAreaCirculo(double radio) {
            return Math.PI * radio * radio;
        }

    public static void main(String[] args) {
        double area = calcularAreaCirculo(3);
                System.out.println("Área: " + area);
    }
}
