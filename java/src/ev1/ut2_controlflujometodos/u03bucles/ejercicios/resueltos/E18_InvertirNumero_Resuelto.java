package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un while para invertir el numero 1234 y muestra Invertido: con el resultado.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El resto al dividir entre 10 es el ultimo digito. Se acumula en invertido y se quita del numero. Sale 4321.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E18_InvertirNumero_Resuelto {
    public static void main(String[] args) {
        int numero = 1234;
        int invertido = 0;
        while (numero > 0) {
            int resto = numero % 10;
            invertido = invertido * 10 + resto;
            numero /= 10;
        }
        System.out.println("Invertido: " + invertido);
    }
}
