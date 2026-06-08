package diagnostico.ejercicios.resueltos;

import java.util.Scanner;

/**
 * Bucles combinados: primos, divisores y menu acumulador
 *
 * <p><b>Instrucciones para el alumno:</b></p>
 * <ul>
 * <li>Crea un programa con tres metodos que usen distintos tipos de bucle.</li>
 * <li>contarPrimosFor(int limite): cuenta primos entre 2 y limite usando for.</li>
 * <li>primerDivisorWhile(int numero): devuelve el primer divisor mayor que 1, o -1 si es primo (usa while).</li>
 * <li>acumularMenuDoWhile(Scanner teclado): suma valores hasta que el usuario escriba 0 (usa do-while).</li>
 * <li>En el main, lee los datos necesarios con Scanner teclado y prueba los tres metodos.</li>
 * </ul>
 *
 * <p>Diagnostico 10 — EV1 · ut2_controlflujometodos · RA3.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 07/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Diagnostico10_BuclesCombinados_RESUELTO {

    public static int contarPrimosFor(int limite) {
        int contador;
        int candidato;
        contador = 0;
        for (candidato = 2; candidato <= limite; candidato++) {
            if (primerDivisorWhile(candidato) == -1) {
                contador++;
            }
        }
        return contador;
    }

    public static int primerDivisorWhile(int numero) {
        int divisor;
        if (numero < 2) {
            return 0;
        }
        divisor = 2;
        while (divisor * divisor <= numero) {
            if (numero % divisor == 0) {
                return divisor;
            }
            divisor++;
        }
        return -1;
    }

    public static int acumularMenuDoWhile(Scanner teclado) {
        int acumulado;
        int valor;
        acumulado = 0;
        do {
            System.out.print("Valor a sumar (0 para terminar): ");
            valor = teclado.nextInt();
            acumulado += valor;
        } while (valor != 0);
        return acumulado;
    }
    public static void main(String[] args) {
        Scanner teclado;
        int limite;
        int numero;
        int primos;
        int divisor;
        int acumulado;
        teclado = new Scanner(System.in);
        System.out.print("Limite para contar primos: ");
        limite = teclado.nextInt();
        System.out.print("Numero para buscar divisor: ");
        numero = teclado.nextInt();
        primos = contarPrimosFor(limite);
        divisor = primerDivisorWhile(numero);
        acumulado = acumularMenuDoWhile(teclado);
        System.out.println("Primos hasta " + limite + ": " + primos);
        System.out.println("Primer divisor de " + numero + ": " + divisor);
        System.out.println("Acumulado menu: " + acumulado);
        teclado.close();
    }
}
