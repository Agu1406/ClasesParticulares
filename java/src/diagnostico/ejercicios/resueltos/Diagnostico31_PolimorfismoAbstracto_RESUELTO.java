package diagnostico.ejercicios.resueltos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clases abstractas y areas de figuras
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con figuras geometricas usando clase abstracta.</li>
 * <li>Define Figura abstracta con calcularArea(). Implementa Rectangulo y Circulo.</li>
 * <li>En el main, lee base, altura y radio con Scanner teclado.</li>
 * <li>Crea las figuras, guardalas en una lista de Figura e imprime cada area (polimorfismo).</li>
 * </ul>
 *
 * <p>Diagnostico 31 — EV3 · ut6_pooavanzadaestructuras · RA7.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico31_PolimorfismoAbstracto_RESUELTO {

    abstract static class Figura {
        public abstract double calcularArea();
    }

    static class Rectangulo extends Figura {
        private final double base;
        private final double altura;

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        @Override
        public double calcularArea() {
            return base * altura;
        }
    }

    static class Circulo extends Figura {
        private final double radio;

        public Circulo(double radio) {
            this.radio = radio;
        }

        @Override
        public double calcularArea() {
            return Math.PI * radio * radio;
        }
    }
    public static void main(String[] args) {
        Scanner teclado;
        double base;
        double altura;
        double radio;
        List<Figura> figuras;
        Figura figura;
        teclado = new Scanner(System.in);
        System.out.print("Base del rectangulo: ");
        base = teclado.nextDouble();
        System.out.print("Altura del rectangulo: ");
        altura = teclado.nextDouble();
        System.out.print("Radio del circulo: ");
        radio = teclado.nextDouble();
        figuras = new ArrayList<>();
        figuras.add(new Rectangulo(base, altura));
        figuras.add(new Circulo(radio));
        for (Figura forma : figuras) {
            System.out.println(forma.calcularArea());
        }
        teclado.close();
    }
}
