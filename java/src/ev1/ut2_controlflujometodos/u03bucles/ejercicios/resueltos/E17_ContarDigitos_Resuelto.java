package ev1.ut2_controlflujometodos.u03bucles.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Usa un while para contar los digitos de 98765 y muestra Digitos: con el total.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Mientras el numero sea mayor que 0 se divide entre 10 y se suma un digito. Hay 5.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E17_ContarDigitos_Resuelto {
    public static void main(String[] args) {
        int numero = 98765;
        int digitos = 0;
        while (numero > 0) {
            numero /= 10;
            digitos++;
        }
        System.out.println("Digitos: " + digitos);
    }
}
