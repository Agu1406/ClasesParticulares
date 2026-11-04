package ev1.ut2_controlflujometodos.u04metodos.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Crea el metodo int sumar, con dos int, que devuelva la suma. En main suma 7 y 5 e imprime Suma: con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> sumar devuelve a + b. main guarda el resultado de sumar(7, 5) y lo imprime.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E03_RetornaInt_Resuelto {
    public static int sumar(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int resultado = sumar(7, 5);
        System.out.println("Suma: " + resultado);
    }
}
