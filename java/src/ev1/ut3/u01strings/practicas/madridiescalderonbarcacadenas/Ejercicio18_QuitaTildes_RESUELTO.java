package ev1.ut3.u01strings.practicas.madridiescalderonbarcacadenas;

/**
 * Ejercicio 18: Escribe la funcion quitaTildes que recibe un String y lo devuelve cambiando todas
 * las vocales tildadas presentes en el por la misma sin acentuar. - RESUELTO
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio18_QuitaTildes_RESUELTO {
    public static void main(String[] args) {
        // Pruebas de la funcion quitaTildes
        System.out.println("=== Pruebas de quitaTildes ===");
        
        String texto1 = "Jose Maria";
        String resultado1 = quitaTildes(texto1);
        System.out.println("Texto: \"" + texto1 + "\"");
        System.out.println("Resultado: \"" + resultado1 + "\"");
        System.out.println("Esperado: \"Jose Maria\"");
        System.out.println();
        
        String texto2 = "Programacion";
        String resultado2 = quitaTildes(texto2);
        System.out.println("Texto: \"" + texto2 + "\"");
        System.out.println("Resultado: \"" + resultado2 + "\"");
        System.out.println("Esperado: \"Programacion\"");
        System.out.println();
        
        String texto3 = "aeiou AEIOU";
        String resultado3 = quitaTildes(texto3);
        System.out.println("Texto: \"" + texto3 + "\"");
        System.out.println("Resultado: \"" + resultado3 + "\"");
        System.out.println("Esperado: \"aeiou AEIOU\"");
    }
    
    /**
     * Elimina las tildes de todas las vocales tildadas, reemplazandolas por su equivalente sin acentuar.
     * 
     * @param texto El String del que se quitaran las tildes
     * @return Un nuevo String con las vocales tildadas reemplazadas por su equivalente sin acentuar
     */
    public static String quitaTildes(String texto) {
        if (texto == null) {
            return null;
        }
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            switch (c) {
                case 'a': resultado.append('a'); break;
                case 'e': resultado.append('e'); break;
                case 'i': resultado.append('i'); break;
                case 'o': resultado.append('o'); break;
                case 'u': resultado.append('u'); break;
                case 'A': resultado.append('A'); break;
                case 'E': resultado.append('E'); break;
                case 'I': resultado.append('I'); break;
                case 'O': resultado.append('O'); break;
                case 'U': resultado.append('U'); break;
                default: resultado.append(c); break;
            }
        }
        
        return resultado.toString();
    }
}
