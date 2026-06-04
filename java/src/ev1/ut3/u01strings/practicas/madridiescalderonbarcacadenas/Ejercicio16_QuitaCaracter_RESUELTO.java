package ev1.ut3.u01strings.practicas.madridiescalderonbarcacadenas;

/**
 * Ejercicio 16: Realiza la funcion quitaCaracter que recibe dos parametros, un String y un char.
 * Tiene que devolver el String eliminando de el todas las apariciones del segundo parametro
 * en caso de haberlas. - RESUELTO
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio16_QuitaCaracter_RESUELTO {
    public static void main(String[] args) {
        // Pruebas de la funcion quitaCaracter
        System.out.println("=== Pruebas de quitaCaracter ===");
        
        String texto1 = "Hola mundo";
        char caracter1 = 'o';
        String resultado1 = quitaCaracter(texto1, caracter1);
        System.out.println("Texto: \"" + texto1 + "\"");
        System.out.println("Caracter a quitar: '" + caracter1 + "'");
        System.out.println("Resultado: \"" + resultado1 + "\"");
        System.out.println("Esperado: \"Hla mund\"");
        System.out.println();
        
        String texto2 = "programacion";
        char caracter2 = 'a';
        String resultado2 = quitaCaracter(texto2, caracter2);
        System.out.println("Texto: \"" + texto2 + "\"");
        System.out.println("Caracter a quitar: '" + caracter2 + "'");
        System.out.println("Resultado: \"" + resultado2 + "\"");
        System.out.println("Esperado: \"progrmcion\"");
        System.out.println();
        
        String texto3 = "Java";
        char caracter3 = 'x';
        String resultado3 = quitaCaracter(texto3, caracter3);
        System.out.println("Texto: \"" + texto3 + "\"");
        System.out.println("Caracter a quitar: '" + caracter3 + "'");
        System.out.println("Resultado: \"" + resultado3 + "\"");
        System.out.println("Esperado: \"Java\" (sin cambios)");
        System.out.println();
        
        // Pruebas de la funcion quitaCaracterBucle
        System.out.println("=== Pruebas de quitaCaracterBucle ===");
        
        String resultado1Bucle = quitaCaracterBucle(texto1, caracter1);
        System.out.println("Texto: \"" + texto1 + "\"");
        System.out.println("Caracter a quitar: '" + caracter1 + "'");
        System.out.println("Resultado: \"" + resultado1Bucle + "\"");
        System.out.println("Esperado: \"Hla mund\"");
        System.out.println();
        
        String resultado2Bucle = quitaCaracterBucle(texto2, caracter2);
        System.out.println("Texto: \"" + texto2 + "\"");
        System.out.println("Caracter a quitar: '" + caracter2 + "'");
        System.out.println("Resultado: \"" + resultado2Bucle + "\"");
        System.out.println("Esperado: \"progrmcion\"");
        System.out.println();
        
        String resultado3Bucle = quitaCaracterBucle(texto3, caracter3);
        System.out.println("Texto: \"" + texto3 + "\"");
        System.out.println("Caracter a quitar: '" + caracter3 + "'");
        System.out.println("Resultado: \"" + resultado3Bucle + "\"");
        System.out.println("Esperado: \"Java\" (sin cambios)");
    }
    
    /**
     * Elimina todas las apariciones de un caracter de un String.
     * 
     * @param texto El String del que se eliminaran los caracteres
     * @param caracter El caracter a eliminar
     * @return Un nuevo String sin las apariciones del caracter especificado
     */
    public static String quitaCaracter(String texto, char caracter) {
        if (texto == null) {
            return null;
        }
        
        // Usar replace() para reemplazar todas las ocurrencias del caracter por cadena vacia
        return texto.replace(String.valueOf(caracter), "");
    }
    
    /**
     * Elimina todas las apariciones de un caracter de un String usando un bucle.
     * Version alternativa sin StringBuilder, usando concatenacion de Strings.
     * 
     * @param texto El String del que se eliminaran los caracteres
     * @param caracter El caracter a eliminar
     * @return Un nuevo String sin las apariciones del caracter especificado
     */
    public static String quitaCaracterBucle(String texto, char caracter) {
        if (texto == null) {
            return null;
        }
        
        String resultado = "";
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c != caracter) {
                resultado += c;  // Concatenacion de Strings
            }
        }
        
        return resultado;
    }
}
