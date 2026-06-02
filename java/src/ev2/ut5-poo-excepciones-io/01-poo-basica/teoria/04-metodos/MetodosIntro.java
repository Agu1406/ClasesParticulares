package general.poobasico;

/**
 * Teoría: métodos de instancia en una clase.
 *
 * <p><b>Objetivo:</b> definir comportamiento dentro de la clase (por ejemplo calcular
 * área) y llamarlo desde el objeto.</p>
 *
 * <pre>{@code
 * class Rectangulo {
 *     double base, altura;
 *     double calcularArea() {
 *         return base * altura;
 *     }
 * }
 * }</pre>
 *
 * <p>Practica en {@code ejercicios/04-metodos/pendientes} y {@code resueltos}
 * (package de ejercicios: {@code general.poobasico.funciones}).</p>
 *
 * @author Agustín. A. Marquez. Piña
 * @since 02/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class MetodosIntro {

    static class Rectangulo {
        double base;
        double altura;

        Rectangulo(double base, double altura) {
            this.base = base;
            this.altura = altura;
        }

        double calcularArea() {
            return base * altura;
        }
    }

    public static void main(String[] args) {
        Rectangulo r = new Rectangulo(4, 5);
        System.out.println("Área: " + r.calcularArea());
    }
}
