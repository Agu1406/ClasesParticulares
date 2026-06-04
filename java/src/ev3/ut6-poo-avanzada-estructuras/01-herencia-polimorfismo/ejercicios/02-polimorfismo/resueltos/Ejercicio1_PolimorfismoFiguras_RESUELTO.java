package general.poo_polimorfismo;

/**
 * Ejercicio 1: Polimorfismo con figuras (RESUELTO)
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_PolimorfismoFiguras_RESUELTO {

    // Clase base
    static abstract class Figura {
        public abstract double calcularArea();
    }

    static class Circulo extends Figura {
        private double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * radio * radio;
        }
    }

    static class Rectangulo extends Figura {
        private double base;
        private double altura;

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return base * altura;
        }
    }

    public static void main(String[] args) {
        Figura[] figuras = new Figura[3];
        figuras[0] = new Circulo(2.5);
        figuras[1] = new Rectangulo(3, 4);
        figuras[2] = new Circulo(1.0);

        for (Figura f : figuras) {
            System.out.println("Area: " + f.calcularArea());
        }
    }
}