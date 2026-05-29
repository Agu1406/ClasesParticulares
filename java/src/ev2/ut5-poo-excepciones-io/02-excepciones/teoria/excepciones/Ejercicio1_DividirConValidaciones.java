package general.excepciones;

/**
 * Práctica Excepciones 1
 * Diseña un programa que divide dos números.
 * 
 * El código tiene que contemplar:
 * - Que el segundo número no sea cero
 * - Que el primer número no sea cero ni menor que cero
 * - Que el primer valor sea mayor que 100
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 26/04/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio1_DividirConValidaciones {

    /**
     * Divide dos números después de validar las reglas del enunciado.
     * 
     * @param primerNumero numerador
     * @param segundoNumero denominador
     * @return resultado de la división
     */
    public static double dividirConReglas(int primerNumero, int segundoNumero) {
        // TODO 1: Si segundoNumero es 0, lanzar IllegalArgumentException.
        // TODO 2: Si primerNumero es <= 0, lanzar IllegalArgumentException.
        // TODO 3: Si primerNumero <= 100, lanzar IllegalArgumentException.
        // TODO 4: Devolver la división en formato decimal.
        return 0;
    }

    public static void main(String[] args) {
        int primerNumero = 150;
        int segundoNumero = 3;

        try {
            // TODO 5: Llamar a dividirConReglas y mostrar el resultado.
        } catch (IllegalArgumentException e) {
            // TODO 6: Mostrar mensaje de error validado.
        } catch (Exception e) {
            // TODO 7: Mostrar mensaje de error genérico.
        } finally {
            // TODO 8: Mostrar mensaje final del programa.
        }
    }
}

