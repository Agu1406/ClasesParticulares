package madrid.iescalderonbarca.ejercicios.cadenas;

/**
 * Ejercicio 17: Codifica la función ocultaVocales que recibe un String y lo devuelve cambiando
 * todas las vocales sin acentuar presentes en él por caracteres 'X'. - RESUELTO
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio17_OcultaVocales_RESUELTO {
    public static void main(String[] args) {
        // Pruebas de la función ocultaVocales
        System.out.println("=== Pruebas de ocultaVocales ===");
        
        String texto1 = "Hola mundo";
        String resultado1 = ocultaVocales(texto1);
        System.out.println("Texto: \"" + texto1 + "\"");
        System.out.println("Resultado: \"" + resultado1 + "\"");
        System.out.println("Esperado: \"HXlX mXndX\"");
        System.out.println();
        
        String texto2 = "PROGRAMACIÓN";
        String resultado2 = ocultaVocales(texto2);
        System.out.println("Texto: \"" + texto2 + "\"");
        System.out.println("Resultado: \"" + resultado2 + "\"");
        System.out.println("Esperado: \"PRXGRXMXCXÓN\" (solo vocales sin acentuar)");
        System.out.println();
        
        String texto3 = "xyz";
        String resultado3 = ocultaVocales(texto3);
        System.out.println("Texto: \"" + texto3 + "\"");
        System.out.println("Resultado: \"" + resultado3 + "\"");
        System.out.println("Esperado: \"xyz\" (sin cambios)");
    }
    
    /**
     * Oculta todas las vocales sin acentuar (a, e, i, o, u, A, E, I, O, U) 
     * reemplazándolas por 'X'.
     * 
     * @param texto El String en el que se ocultarán las vocales
     * @return Un nuevo String con las vocales sin acentuar reemplazadas por 'X'
     */
    public static String ocultaVocales(String texto) {
        if (texto == null) {
            return null;
        }
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            // Verificar si es una vocal sin acentuar (mayúscula o minúscula)
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                resultado.append('X');
            } else {
                resultado.append(c);
            }
        }
        
        return resultado.toString();
    }
}
