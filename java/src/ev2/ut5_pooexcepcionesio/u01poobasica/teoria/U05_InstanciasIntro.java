package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Teoria: instancias independientes.
 *
 * <p><b>Objetivo:</b> comprobar que cada objeto mantiene su propio estado: cambiar
 * un atributo en una instancia no afecta a otra de la misma clase.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_InstanciasIntro {

    static class Contador {
        int valor;

        void incrementar() {
            valor++;
        }
    }

    static class Coche {
        private String marca;
        private String color;
        private int velocidadMax;

        Coche(String marca, String color, int velocidadMax) {
            this.marca = marca;
            this.color = color;
            this.velocidadMax = velocidadMax;
        }

        @Override
        public String toString() {
            return "Coche{" + marca + ", " + color + ", " + velocidadMax + " km/h}";
        }
    }

    public static void main(String[] args) {
        Contador c1 = new Contador();
        Contador c2 = new Contador();
        c1.incrementar();
        c1.incrementar();
        c2.incrementar();
        System.out.println("c1 = " + c1.valor + ", c2 = " + c2.valor);

        Coche coche1 = new Coche("Seat", "Rojo", 180);
        Coche coche2 = new Coche("Ford", "Azul", 200);
        System.out.println(coche1);
        System.out.println(coche2);
    }
}
