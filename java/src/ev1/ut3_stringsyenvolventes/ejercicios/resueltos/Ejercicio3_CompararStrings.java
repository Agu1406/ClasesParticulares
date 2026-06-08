package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * Ejercicio 3: Comparar strings
 * Crea dos strings y comparalos usando la funcion equals() para verificar si son iguales
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_CompararStrings {
    public static void main(String[] args) {
        // Crear dos strings
        String texto1 = "Hola";
        String texto2 = "Hola";
        String texto3 = "Adios";
        
        // Comparar strings usando equals()
        boolean sonIguales1 = texto1.equals(texto2);
        boolean sonIguales2 = texto1.equals(texto3);
        
        // Mostrar resultados
        System.out.println("?'" + texto1 + "' es igual a '" + texto2 + "'? " + sonIguales1);
        System.out.println("?'" + texto1 + "' es igual a '" + texto3 + "'? " + sonIguales2);
        
        // Tambien se puede comparar directamente en el if
        if (texto1.equals(texto2)) {
            System.out.println("Los textos son iguales");
        } else {
            System.out.println("Los textos son diferentes");
        }
    }
}
