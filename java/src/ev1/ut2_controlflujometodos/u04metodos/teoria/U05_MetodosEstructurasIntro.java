package ev1.ut2_controlflujometodos.u04metodos.teoria;

/**
 * Teoria: metodos que usan estructuras de control (if, bucles, switch).
 *
 * <p><b>Objetivo:</b> combinar metodos con condicionales y bucles para resolver problemas mas completos.</p>
 *
 * <p>Dentro de un metodo puedes usar las mismas estructuras que en {@code main}:</p>
 * <ul>
 *   <li><b>if / else</b> - devolver distintos resultados segun una condicion.</li>
 *   <li><b>for / while / do-while</b> - repetir calculos (sumar 1..n, tablas, contadores).</li>
 *   <li><b>switch</b> - elegir un resultado entre varias opciones fijas (dia de la semana, menu).</li>
 * </ul>
 *
 * <p>La ventaja de meter la logica en un metodo es que {@code main} queda limpio: lee datos,
 * llama al metodo adecuado e imprime el resultado.</p>
 *
 * <pre>{@code
 * public static String calificarNota(double nota) {
 *     if (nota >= 5) {
 *         return "Aprobado";
 *     }
 *     return "Suspenso";
 * }
 * }</pre>
 *
 * <p>Equivale a los Ejercicios 7-10 en {@code ejercicios/}.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 03/06/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class U05_MetodosEstructurasIntro {

    public static String calificarNota(double nota) {
        if (nota >= 5) {
            return "Aprobado";
        }
        return "Suspenso";
    }

    public static int sumarDelUnoAlN(int limite) {
        int suma;
        int indice;
        suma = 0;
        for (indice = 1; indice <= limite; indice++) {
            suma += indice;
        }
        return suma;
    }

    public static String nombreDia(int dia) {
        switch (dia) {
            case 1:
                return "Lunes";
            case 2:
                return "Martes";
            case 3:
                return "Miercoles";
            case 4:
                return "Jueves";
            case 5:
                return "Viernes";
            case 6:
                return "Sabado";
            case 7:
                return "Domingo";
            default:
                return "Invalido";
        }
    }

    public static String resumenNumero(int numero) {
        String paridad;
        int suma;
        int indice;
        paridad = (numero % 2 == 0) ? "par" : "impar";
        suma = 0;
        for (indice = 1; indice <= numero; indice++) {
            suma += indice;
        }
        return "Numero " + numero + ", " + paridad + ", suma 1..n = " + suma;
    }

    public static void main(String[] args) {
        System.out.println(calificarNota(6.5));
        System.out.println(calificarNota(4.0));
        System.out.println("Suma 1..10: " + sumarDelUnoAlN(10));
        System.out.println(nombreDia(3));
        System.out.println(resumenNumero(8));
    }
}
