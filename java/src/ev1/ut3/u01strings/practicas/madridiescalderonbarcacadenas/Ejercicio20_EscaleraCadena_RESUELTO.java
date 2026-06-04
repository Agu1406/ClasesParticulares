package ev1.ut3.u01strings.practicas.madridiescalderonbarcacadenas;

/**
 * Ejercicio 20: Realiza la funcion escaleraCadena que recibe un String y devuelve otro en el que
 * alterna los caracteres del parametro entre mayusculas y minusculas. - RESUELTO
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio20_EscaleraCadena_RESUELTO {
    public static void main(String[] args) {
        // Pruebas de la funcion escaleraCadena
        System.out.println("=== Pruebas de escaleraCadena ===");
        
        String texto1 = "Hola mundo";
        String resultado1 = escaleraCadena(texto1);
        System.out.println("Texto: \"" + texto1 + "\"");
        System.out.println("Resultado: \"" + resultado1 + "\"");
        System.out.println("Esperado: \"HoLa MuNdO\"");
        System.out.println();
        
        String texto2 = "PROGRAMACION";
        String resultado2 = escaleraCadena(texto2);
        System.out.println("Texto: \"" + texto2 + "\"");
        System.out.println("Resultado: \"" + resultado2 + "\"");
        System.out.println("Esperado: \"PrOgRaMaCiOn\"");
        System.out.println();
        
        String texto3 = "java";
        String resultado3 = escaleraCadena(texto3);
        System.out.println("Texto: \"" + texto3 + "\"");
        System.out.println("Resultado: \"" + resultado3 + "\"");
        System.out.println("Esperado: \"JaVa\"");
        System.out.println();
        
        String texto4 = "A";
        String resultado4 = escaleraCadena(texto4);
        System.out.println("Texto: \"" + texto4 + "\"");
        System.out.println("Resultado: \"" + resultado4 + "\"");
        System.out.println("Esperado: \"A\"");
    }
    
    /**
     * Alterna los caracteres de un String entre mayusculas y minusculas.
     * El primer caracter sera mayuscula, el segundo minuscula, el tercero mayuscula, etc.
     * 
     * @param texto El String a transformar
     * @return Un nuevo String con caracteres alternados entre mayusculas y minusculas
     */
    public static String escaleraCadena(String texto) {
        if (texto == null) {
            return null;
        }
        
        if (texto.isEmpty()) {
            return texto;
        }
        
        StringBuilder resultado = new StringBuilder();
        
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            
            // Si la posicion es par (0, 2, 4, ...), convertir a mayuscula
            // Si la posicion es impar (1, 3, 5, ...), convertir a minuscula
            if (i % 2 == 0) {
                // Posicion par: mayuscula
                resultado.append(Character.toUpperCase(c));
            } else {
                // Posicion impar: minuscula
                resultado.append(Character.toLowerCase(c));
            }
        }
        
        return resultado.toString();
    }
}
