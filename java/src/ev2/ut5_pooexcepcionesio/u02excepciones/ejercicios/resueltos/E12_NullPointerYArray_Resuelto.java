package ev2.ut5_pooexcepcionesio.u02excepciones.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> En un {@code try}, provoca (o simula) un
 * {@code NullPointerException} y un {@code ArrayIndexOutOfBoundsException}
 * en dos bloques separados. Captura cada uno con su {@code catch} concreto e
 * imprime el nombre de la excepcion. Enlace: teoria {@code U02_ExcepcionesConceptos}.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> Un {@code try/catch} por tipo evita mezclar mensajes.
 * {@code NullPointerException} al llamar metodos sobre {@code null};
 * {@code ArrayIndexOutOfBoundsException} al usar un indice fuera de rango.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 06/09/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E12_NullPointerYArray_Resuelto {

    public static void main(String[] args) {
        try {
            String texto = null;
            System.out.println(texto.length());
        } catch (NullPointerException e) {
            System.out.println("Capturado: " + e.getClass().getSimpleName());
        }

        try {
            int[] numeros = {10, 20};
            System.out.println(numeros[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Capturado: " + e.getClass().getSimpleName());
            System.out.println("Mensaje: " + e.getMessage());
        }
    }
}
