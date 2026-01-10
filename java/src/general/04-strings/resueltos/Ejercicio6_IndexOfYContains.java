package madrid.iescalderonbarca.d_ejerciciosstrings;

/**
 * Ejercicio 6: Buscar en strings
 * Crea un string y usa indexOf() para encontrar la posición de un carácter o substring,
 * y usa contains() para verificar si contiene un substring específico
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio6_IndexOfYContains {
    public static void main(String[] args) {
        // Crear un string
        String texto = "Programación en Java";
        
        // Buscar la posición de un carácter usando indexOf()
        int posicionA = texto.indexOf('a');
        System.out.println("La primera 'a' está en la posición: " + posicionA);
        
        // Buscar la posición de un substring
        int posicionJava = texto.indexOf("Java");
        System.out.println("'Java' comienza en la posición: " + posicionJava);
        
        // Si no encuentra el carácter/substring, devuelve -1
        int posicionNoEncontrado = texto.indexOf('z');
        System.out.println("Posición de 'z' (no existe): " + posicionNoEncontrado);
        
        // Verificar si contiene un substring usando contains()
        boolean contieneJava = texto.contains("Java");
        System.out.println("¿Contiene 'Java'? " + contieneJava);
        
        boolean contienePython = texto.contains("Python");
        System.out.println("¿Contiene 'Python'? " + contienePython);
    }
}
