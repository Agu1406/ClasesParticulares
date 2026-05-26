package madrid.iescalderonbarca.ejercicios.resueltos;

/**
 * Ejercicio 18: Escribe la función quitaTildes que recibe un String y lo devuelve cambiando todas
 * las vocales tildadas presentes en él por la misma sin acentuar. - RESUELTO
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio18_QuitaTildes_RESUELTO {
    public static void main(String[] args) {
        // Pruebas de la función quitaTildes
        System.out.println("=== Pruebas de quitaTildes ===");
        
        String texto1 = "José María";
        String resultado1 = quitaTildes(texto1);
        System.out.println("Texto: \"" + texto1 + "\"");
        System.out.println("Resultado: \"" + resultado1 + "\"");
        System.out.println("Esperado: \"Jose Maria\"");
        System.out.println();
        
        String texto2 = "Programación";
        String resultado2 = quitaTildes(texto2);
        System.out.println("Texto: \"" + texto2 + "\"");
        System.out.println("Resultado: \"" + resultado2 + "\"");
        System.out.println("Esperado: \"Programacion\"");
        System.out.println();
        
        String texto3 = "áéíóú ÁÉÍÓÚ";
        String resultado3 = quitaTildes(texto3);
        System.out.println("Texto: \"" + texto3 + "\"");
        System.out.println("Resultado: \"" + resultado3 + "\"");
        System.out.println("Esperado: \"aeiou AEIOU\"");
    }
    
    /**
     * Elimina las tildes de todas las vocales tildadas, reemplazándolas por su equivalente sin acentuar.
     * 
     * @param texto El String del que se quitarán las tildes
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
                case 'á': resultado.append('a'); break;
                case 'é': resultado.append('e'); break;
                case 'í': resultado.append('i'); break;
                case 'ó': resultado.append('o'); break;
                case 'ú': resultado.append('u'); break;
                case 'Á': resultado.append('A'); break;
                case 'É': resultado.append('E'); break;
                case 'Í': resultado.append('I'); break;
                case 'Ó': resultado.append('O'); break;
                case 'Ú': resultado.append('U'); break;
                default: resultado.append(c); break;
            }
        }
        
        return resultado.toString();
    }
}
