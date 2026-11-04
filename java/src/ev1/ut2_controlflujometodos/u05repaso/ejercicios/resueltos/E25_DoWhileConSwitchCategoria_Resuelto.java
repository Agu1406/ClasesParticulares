package ev1.ut2_controlflujometodos.u05repaso.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Clasifica productos por categoria numerica con switch.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> El main clasifica productos por categoria numerica con switch.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 29/05/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */

public class E25_DoWhileConSwitchCategoria_Resuelto {
    public static void main(String[] args) {
        int cat = 1;
        do {
            switch (cat) {
                case 1 -> System.out.println("Categoria 1: Alimentacion");
                case 2 -> System.out.println("Categoria 2: Electronica");
                case 3 -> System.out.println("Categoria 3: Hogar");
                default -> System.out.println("Categoria desconocida");
            }
            cat++;
        } while (cat <= 3);
    }
}
