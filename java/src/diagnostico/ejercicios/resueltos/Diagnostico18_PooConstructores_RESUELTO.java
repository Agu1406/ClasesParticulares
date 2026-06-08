package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Constructores por defecto y parametrizado
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con una clase Rectangulo y dos constructores.</li>
 * <li>Constructor por defecto: rectangulo de 1x1. Constructor parametrizado: base y altura.</li>
 * <li>Metodo area() que devuelva base * altura.</li>
 * <li>En el main, lee base y altura con Scanner teclado. Crea ambos rectangulos e imprime sus areas.</li>
 * </ul>
 *
 * <p>Diagnostico 18 — EV2 · ut5_pooexcepcionesio · RA4.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico18_PooConstructores_RESUELTO {

    static class Rectangulo {
        private double base;
        private double altura;

        public Rectangulo() {
            this(1, 1);
        }

        public Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        public double area() {
            return base * altura;
        }
    }
    public static void main(String[] args) {
        Scanner teclado;
        double base;
        double altura;
        Rectangulo defecto;
        Rectangulo personalizado;
        teclado = new Scanner(System.in);
        System.out.print("Base del rectangulo: ");
        base = teclado.nextDouble();
        System.out.print("Altura del rectangulo: ");
        altura = teclado.nextDouble();
        defecto = new Rectangulo();
        personalizado = new Rectangulo(base, altura);
        System.out.println("Area defecto: " + defecto.area());
        System.out.println("Area personalizado: " + personalizado.area());
        teclado.close();
    }
}
