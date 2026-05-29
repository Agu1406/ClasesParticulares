package madrid.iescalderonbarca.ejercicios.resueltos;

/**
 * Ejercicio 19: Codifica la función acortaCadena que recibe un String y devuelve otro en el que
 * deja un carácter por cada tres, o fracción, del String inicial. - RESUELTO
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio19_AcortaCadena_RESUELTO {
    public static void main(String[] args) {
        // Pruebas de la función acortaCadena
        System.out.println("=== Pruebas de acortaCadena ===");
        
        String texto1 = "Hola mundo";
        String resultado1 = acortaCadena(texto1);
        System.out.println("Texto: \"" + texto1 + "\"");
        System.out.println("Resultado: \"" + resultado1 + "\"");
        System.out.println("Esperado: \"Houm\" (posiciones 0, 3, 6, 9)");
        System.out.println();
        
        String texto2 = "Programación";
        String resultado2 = acortaCadena(texto2);
        System.out.println("Texto: \"" + texto2 + "\"");
        System.out.println("Resultado: \"" + resultado2 + "\"");
        System.out.println("Esperado: \"Pgaó\" (posiciones 0, 3, 6, 9)");
        System.out.println();
        
        String texto3 = "Java";
        String resultado3 = acortaCadena(texto3);
        System.out.println("Texto: \"" + texto3 + "\"");
        System.out.println("Resultado: \"" + resultado3 + "\"");
        System.out.println("Esperado: \"Jv\" (posiciones 0, 3)");
        System.out.println();
        
        String texto4 = "AB";
        String resultado4 = acortaCadena(texto4);
        System.out.println("Texto: \"" + texto4 + "\"");
        System.out.println("Resultado: \"" + resultado4 + "\"");
        System.out.println("Esperado: \"A\" (solo posición 0, fracción de 3)");
    }
    
    /**
     * Acorta una cadena dejando un carácter por cada tres del String inicial.
     * Toma los caracteres en las posiciones 0, 3, 6, 9, etc.
     * 
     * @param texto El String a acortar
     * @return Un nuevo String con un carácter por cada tres del original
     */
    public static String acortaCadena(String texto) {
        if (texto == null) {
            return null;
        }
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < texto.length(); i += 3) {
            resultado.append(texto.charAt(i));
        }
        
        return resultado.toString();
    }
}
