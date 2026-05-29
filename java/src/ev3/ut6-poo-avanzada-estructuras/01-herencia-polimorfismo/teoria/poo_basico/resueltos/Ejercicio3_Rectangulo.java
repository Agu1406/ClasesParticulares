package general.poo_basico.resueltos;

/**
 * Ejercicio 3: Clase Rectangulo (RESUELTO)
 * 
 * Demuestra:
 *  - Atributos privados
 *  - Constructores
 *  - Funciones que calculan propiedades del objeto
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_Rectangulo {

    static class Rectangulo {
        private double base;
        private double altura;

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        public double calcularArea() {
            return base * altura;
        }

        public double calcularPerimetro() {
            return 2 * (base + altura);
        }
    }

    public static void main(String[] args) {
        Rectangulo r1 = new Rectangulo(3, 4);
        Rectangulo r2 = new Rectangulo(5, 2.5);

        System.out.println("Rectángulo 1:");
        System.out.println("Área: " + r1.calcularArea());
        System.out.println("Perímetro: " + r1.calcularPerimetro());

        System.out.println("\nRectángulo 2:");
        System.out.println("Área: " + r2.calcularArea());
        System.out.println("Perímetro: " + r2.calcularPerimetro());
    }
}

