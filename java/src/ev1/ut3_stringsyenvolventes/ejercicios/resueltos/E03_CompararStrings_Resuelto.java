package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Compara Hola con Hola y Hola con Adios usando equals. Imprime si son iguales.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> equals compara el contenido. Hola y Hola son iguales; Hola y Adios no. El if confirma el primer caso.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E03_CompararStrings_Resuelto {
    public static void main(String[] args) {
        String texto1 = "Hola";
        String texto2 = "Hola";
        String texto3 = "Adios";
        boolean sonIguales1 = texto1.equals(texto2);
        boolean sonIguales2 = texto1.equals(texto3);
        System.out.println("¿'" + texto1 + "' es igual a '" + texto2 + "'? " + sonIguales1);
        System.out.println("¿'" + texto1 + "' es igual a '" + texto3 + "'? " + sonIguales2);
        if (texto1.equals(texto2)) {
            System.out.println("Los textos son iguales");
        } else {
            System.out.println("Los textos son diferentes");
        }
    }
}
