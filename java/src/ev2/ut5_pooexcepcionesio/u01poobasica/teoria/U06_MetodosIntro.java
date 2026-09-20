package ev2.ut5_pooexcepcionesio.u01poobasica.teoria;

/**
 * Teoria: metodos de instancia en una clase.
 *
 * <p><b>Objetivo:</b> definir comportamiento dentro de la clase (calcular area,
 * {@code toString} con {@code @Override}) y llamarlo desde el objeto.</p>
 *
 * <p>Practica en {@code ejercicios/} (metodos).</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U06_MetodosIntro {

    static class Rectangulo {
        private double base;
        private double altura;

        Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        double calcularArea() {
            return base * altura;
        }

        @Override
        public String toString() {
            return "¡Datos de la figura!\n"
                    + "- Base: " + this.base + "\n"
                    + "- Altura: " + this.altura + "\n"
                    + "- Area: " + this.calcularArea() + "\n";
        }
    }

    public static void main(String[] args) {
        Rectangulo figura1 = new Rectangulo(10, 10);
        Rectangulo figura2 = new Rectangulo(15, 20);

        System.out.println("Area figura 1 --> " + figura1.calcularArea());
        System.out.println("Area figura 2 --> " + figura2.calcularArea());
        System.out.println(figura1);
        System.out.println(figura2);
    }
}
