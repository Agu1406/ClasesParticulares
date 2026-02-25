package general.strings.resueltos;

/**
 * Ejercicio 11: Contar caracteres en un string
 * Crea un programa que cuente la cantidad de caracteres en una palabra/string
 * tomando en cuenta los espacios en blanco y sin tomarlos en cuenta
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio11_ContarCaracteres {
    public static void main(String[] args) {
        // Crear un string con espacios
        String texto = "Programación en Java";
        
        System.out.println("Texto: \"" + texto + "\"");
        
        // Contar caracteres TOMANDO EN CUENTA los espacios en blanco
        int caracteresConEspacios = texto.length();
        System.out.println("Caracteres con espacios: " + caracteresConEspacios);
        
        // Contar caracteres SIN TOMAR EN CUENTA los espacios en blanco
        // Forma 1: Usando replace() para eliminar espacios y luego contar
        String textoSinEspacios = texto.replace(" ", "");
        int caracteresSinEspacios = textoSinEspacios.length();
        System.out.println("Caracteres sin espacios: " + caracteresSinEspacios);
        
        // Forma 2: Contar espacios y restarlos del total
        int cantidadEspacios = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == ' ') {
                cantidadEspacios++;
            }
        }
        int caracteresSinEspacios2 = texto.length() - cantidadEspacios;
        System.out.println("Caracteres sin espacios (forma 2): " + caracteresSinEspacios2);
        System.out.println("Cantidad de espacios encontrados: " + cantidadEspacios);
        
        // Forma 3: Contar solo caracteres que NO son espacios
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) != ' ') {
                contador++;
            }
        }
        System.out.println("Caracteres sin espacios (forma 3): " + contador);
        
        // Resumen
        System.out.println("\n--- Resumen ---");
        System.out.println("Total de caracteres (con espacios): " + caracteresConEspacios);
        System.out.println("Total de caracteres (sin espacios): " + caracteresSinEspacios);
        System.out.println("Diferencia (espacios): " + (caracteresConEspacios - caracteresSinEspacios));
    }
}
