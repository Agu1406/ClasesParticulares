package ev1.ut2_controlflujometodos.u02condicionales.practicas.madridiesrosachacelcondicionales;

import java.util.Scanner;

/**
 * Prog 3.1 - Estructuras de control condicionales (IES Rosa Chacel, Madrid).
 *
 * <p>Enunciados en la carpeta: {@code madrid-iesrosachacel-condicionales-ejercicios.docx},
 * {@code madrid-iesrosachacel-condicionales-extra.docx} y {@code madrid-iesrosachacel-condicionales-if-oct2025.docx}.</p>
 *
 * <p><b>Objetivo:</b> practicar {@code if}, {@code if-else}, {@code switch} y validaciones con teclado.</p>
 *
 * <p>Implementa y prueba desde {@code main} (usa {@code Scanner teclado} y variables al inicio de cada metodo):</p>
 * <ol>
 *   <li>Ecuacion de 2o grado: pedir a, b, c; mostrar soluciones reales o avisar si no existen.</li>
 *   <li>Area y longitud de circulo a partir del radio ({@code Math.PI}, {@code Math.pow}).</li>
 *   <li>Comparar dos numeros: iguales, mayor, ordenados, multiplo.</li>
 *   <li>Signo de un numero y conteo de cifras de un entero 0..99999.</li>
 *   <li>Nota 0..10 a texto (Insuficiente, Suficiente, Bien, Notable, Sobresaliente).</li>
 *   <li>Validar fechas (30 dias fijos, luego meses reales, luego dia siguiente).</li>
 *   <li>Dias entre dos fechas y nota escrita con palabras (0..10).</li>
 * </ol>
 *
 * <p>Cada ejercicio del Word puede ir en su propio metodo {@code static void ejercicioN(Scanner teclado)}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class EjerciciosCondicionales_SIN_RESOLVER {

    public static void ecuacionSegundoGrado(Scanner teclado) {
        double coeficienteA;
        double coeficienteB;
        double coeficienteC;
        double determinante;
        // TODO: pedir a, b, c; calcular determinante b*b - 4*a*c
        // TODO: si determinante >= 0 mostrar x1 y x2 con (-b +/- sqrt(determinante)) / (2*a)
        // TODO: si no, indicar que no hay soluciones reales
    }

    public static void areaYLongitudCirculo(Scanner teclado) {
        double radio;
        // TODO: pedir radio; mostrar area (PI*r^2) y longitud (2*PI*r)
    }

    public static void compararDosNumeros(Scanner teclado) {
        int primero;
        int segundo;
        // TODO: pedir dos enteros; decir si son iguales, cual es mayor y mostrarlos ordenados
    }

    public static void notaATexto(Scanner teclado) {
        int nota;
        // TODO: pedir nota 0..10 y mostrar calificacion cualitativa
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        System.out.println("=== Condicionales IES Rosa Chacel ===");
        System.out.println("1. Ecuacion 2o grado");
        System.out.println("2. Circulo (area y longitud)");
        System.out.println("3. Comparar dos numeros");
        System.out.println("4. Nota a texto");
        System.out.print("Opcion: ");
        opcion = teclado.nextInt();

        switch (opcion) {
            case 1 -> ecuacionSegundoGrado(teclado);
            case 2 -> areaYLongitudCirculo(teclado);
            case 3 -> compararDosNumeros(teclado);
            case 4 -> notaATexto(teclado);
            default -> System.out.println("Opcion no implementada aun.");
        }

        teclado.close();
    }
}
