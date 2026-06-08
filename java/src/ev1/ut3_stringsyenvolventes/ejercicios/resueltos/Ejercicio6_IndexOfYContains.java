package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * Ejercicio 6: Buscar en strings
 * Crea un string y usa indexOf() para encontrar la posicion de un caracter o substring,
 * y usa contains() para verificar si contiene un substring especifico
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio6_IndexOfYContains {
    public static void main(String[] args) {
        // Crear un string
        String texto = "Programacion en Java";
        
        // Buscar la posicion de un caracter usando indexOf()
        int posicionA = texto.indexOf('a');
        System.out.println("La primera 'a' esta en la posicion: " + posicionA);
        
        // Buscar la posicion de un substring
        int posicionJava = texto.indexOf("Java");
        System.out.println("'Java' comienza en la posicion: " + posicionJava);
        
        // Si no encuentra el caracter/substring, devuelve -1
        int posicionNoEncontrado = texto.indexOf('z');
        System.out.println("Posicion de 'z' (no existe): " + posicionNoEncontrado);
        
        // Verificar si contiene un substring usando contains()
        boolean contieneJava = texto.contains("Java");
        System.out.println("?Contiene 'Java'? " + contieneJava);
        
        boolean contienePython = texto.contains("Python");
        System.out.println("?Contiene 'Python'? " + contienePython);
    }
}
