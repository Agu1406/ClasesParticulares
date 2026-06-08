package ev1.ut2_controlflujometodos.u05repaso.teoria;

/**
 * Teoria: acumuladores y contadores dentro de bucles con condicionales.
 *
 * <p><b>Objetivo:</b> no solo imprimir en cada vuelta, sino llevar estadisticas del recorrido.</p>
 *
 * <ul>
 *   <li><b>Contador</b> - variable que aumenta cuando ocurre algo ({@code if (esPar) contadorPares++;}).</li>
 *   <li><b>Acumulador</b> - variable que suma valores ({@code acumulado += indice}).</li>
 *   <li><b>Maximo / minimo</b> - comparar en cada vuelta con if y guardar el mejor valor.</li>
 * </ul>
 *
 * <p>Patron habitual en examen:</p>
 * <pre>{@code
 * int contadorPares = 0;
 * int acumulado = 0;
 * for (indice = 1; indice <= limite; indice++) {
 *     if (indice % 2 == 0) {
 *         contadorPares++;
 *         acumulado += indice;
 *     }
 * }
 * }</pre>
 *
 * <p>Muchos ejercicios de repaso piden implicitamente contar o filtrar; identifica
 * si necesitas una variable extra antes del bucle.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 08/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_AcumuladoresYContadoresIntro {

    public static void main(String[] args) {
        int indice;
        int limite;
        int contadorPares;
        int acumuladoPares;
        int maximo;
        limite = 20;
        contadorPares = 0;
        acumuladoPares = 0;
        maximo = 0;
        for (indice = 1; indice <= limite; indice++) {
            if (indice % 2 == 0) {
                contadorPares++;
                acumuladoPares += indice;
                if (indice > maximo) {
                    maximo = indice;
                }
            }
        }
        System.out.println("Pares encontrados: " + contadorPares);
        System.out.println("Suma de pares: " + acumuladoPares);
        System.out.println("Par maximo: " + maximo);
    }
}
