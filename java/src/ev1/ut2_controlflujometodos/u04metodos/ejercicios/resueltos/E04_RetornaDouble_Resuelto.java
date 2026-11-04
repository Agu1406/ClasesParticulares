package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo double calcularAreaCirculo, que recibe el radio y devuelve el area. En main usa radio 3 e imprime Area: con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El area es Math.PI * radio * radio. main llama con radio 3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E04_RetornaDouble_Resuelto {
    public static double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }

    public static void main(String[] args) {
        double area = calcularAreaCirculo(3);
        System.out.println("Area: " + area);
    }
}
