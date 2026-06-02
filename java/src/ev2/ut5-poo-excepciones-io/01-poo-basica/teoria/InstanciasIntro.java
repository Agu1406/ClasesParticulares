package general.poobasico;

/**
 * Teoría: instancias independientes.
 *
 * <p><b>Objetivo:</b> comprobar que cada objeto mantiene su propio estado: cambiar
 * un atributo en una instancia no afecta a otra de la misma clase.</p>
 *
 * <p>Practica en {@code ejercicios/instancias/pendientes} y {@code resueltos}.</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class InstanciasIntro {

    static class Contador {
        int valor;

        void incrementar() {
            valor++;
        }
    }

    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        c1.incrementar();
        c1.incrementar();
        c2.incrementar();
        System.out.println("c1 = " + c1.valor + ", c2 = " + c2.valor);
    }
}
