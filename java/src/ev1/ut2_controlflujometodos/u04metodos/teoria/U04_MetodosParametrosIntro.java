package ev1.ut2_controlflujometodos.u04metodos.teoria;

/**
 * Teoria: parametros de metodos en Java.
 *
 * <p><b>Objetivo:</b> pasar datos a un metodo para que trabaje con informacion distinta en cada llamada.</p>
 *
 * <p>Los <b>parametros</b> son variables locales que reciben valores al invocar el metodo.
 * En la declaracion se indica el tipo y el nombre; en la llamada se envian los valores (argumentos).</p>
 *
 * <pre>{@code
 * public static double calcularMedia(double notaUno, double notaDos, double notaTres) {
 *     return (notaUno + notaDos + notaTres) / 3.0;
 * }
 *
 * // Llamada: los argumentos 7.0, 8.5 y 6.0 se copian a los parametros
 * double media = calcularMedia(7.0, 8.5, 6.0);
 * }</pre>
 *
 * <p><b>Paso por valor:</b> en Java los tipos primitivos ({@code int}, {@code double}, {@code boolean}…)
 * se copian al metodo. Si cambias el parametro dentro del metodo, la variable original en {@code main}
 * no se modifica.</p>
 *
 * <p><b>Orden de los parametros:</b> deben coincidir en tipo y posicion al llamar al metodo.
 * {@code saludar("Ana", 20)} solo es valido si el metodo espera {@code (String, int)} en ese orden.</p>
 *
 * <p><b>Parametros vs variables locales:</b> declara al inicio del metodo las variables que necesites;
 * los parametros ya llegan definidos con los valores de la llamada.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U04_MetodosParametrosIntro {

    public static double calcularMedia(double notaUno, double notaDos, double notaTres) {
        double suma;
        double media;
        suma = notaUno + notaDos + notaTres;
        media = suma / 3.0;
        return media;
    }

    public static void mostrarFicha(String nombre, int edad) {
        System.out.println("Nombre: " + nombre + ", edad: " + edad);
    }

    public static void demostrarPasoPorValor(int numero) {
        numero = numero + 10;
        System.out.println("Dentro del metodo: " + numero);
    }

    public static void main(String[] args) {
        int valorOriginal;
        double media;
        valorOriginal = 5;
        media = calcularMedia(7.0, 8.5, 6.0);
        System.out.println("Media: " + media);
        mostrarFicha("Carlos", 19);
        System.out.println("Antes de llamar: " + valorOriginal);
        demostrarPasoPorValor(valorOriginal);
        System.out.println("Despues de llamar: " + valorOriginal);
    }
}
