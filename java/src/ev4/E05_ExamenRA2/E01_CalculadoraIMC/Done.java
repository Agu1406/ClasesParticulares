package ev4.E05_ExamenRA2.E01_CalculadoraIMC;

import java.util.Scanner;

/**
 * Calcula IMC, clasifica y muestra casteo a int.
 *
 * @author Agustin. A. Marquez. Pina
 * @since 24/10/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Done {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Peso (kg) => ");
        double peso = teclado.nextDouble();

        System.out.print("Altura (m) => ");
        double altura = teclado.nextDouble();

        double imc = peso / (altura * altura);

        String categoria;
        if (imc < 18.5) {
            categoria = "Bajo peso";
        } else if (imc < 25) {
            categoria = "Normal";
        } else if (imc < 30) {
            categoria = "Sobrepeso";
        } else {
            categoria = "Obesidad";
        }

        // Casteo: se pierden los decimales
        int imcEntero = (int) imc;

        System.out.println("IMC: " + imc);
        System.out.println("Categoria: " + categoria);
        System.out.println("IMC truncado (int): " + imcEntero);
    }
}
