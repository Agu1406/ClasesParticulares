package ev3.ut9.pf.principios;

/**
 * Teoria: recursion funcional (PDF diapos 37).
 *
 * <p><b>Que es?</b> Resolver un problema describiendo el caso base y el caso recursivo
 * (el problema se reduce a una version mas pequena del mismo problema). En PF puro
 * sustituye muchos bucles while/for.</p>
 *
 * <p><b>Por que se usa?</b> Expresividad sobre estructuras recursivas (arboles, listas
 * enlazadas conceptuales) y definiciones matematicas directas (factorial, fibonacci).</p>
 *
 * <p><b>En Java vs Haskell:</b> Java no garantiza tail-call optimization (TCO). Recursion
 * profunda puede lanzar StackOverflowError; para n grande usa bucle o stream.</p>
 *
 * <p><b>Demo:</b> factorial y suma de array por recursion con indice.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 */
public class RecursionFuncionalIntro {

    public static int factorial(int numero) {
        if (numero <= 1) {
            return 1;
        }
        return numero * factorial(numero - 1);
    }

    public static int sumaLista(int[] numeros, int indice) {
        if (indice >= numeros.length) {
            return 0;
        }
        return numeros[indice] + sumaLista(numeros, indice + 1);
    }

    public static void main(String[] args) {
        System.out.println("factorial(5): " + factorial(5));
        System.out.println("sumaLista: " + sumaLista(new int[] {1, 2, 3, 4}, 0));
    }
}
