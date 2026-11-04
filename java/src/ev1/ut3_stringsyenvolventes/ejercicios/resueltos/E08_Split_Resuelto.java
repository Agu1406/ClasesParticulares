package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> Divide Java Python C++ JavaScript por espacios y Manzana,Platano,Naranja,Uva por comas. Imprime cada parte.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> split devuelve un array. El primero se recorre con un for clasico y el segundo con un for-each.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E08_Split_Resuelto {
    public static void main(String[] args) {
        String textoConEspacios = "Java Python C++ JavaScript";
        System.out.println("Texto original: " + textoConEspacios);
        String[] palabras = textoConEspacios.split(" ");
        System.out.println("Palabras separadas:");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("  Palabra " + (i + 1) + ": " + palabras[i]);
        }
        String textoConComas = "Manzana,Platano,Naranja,Uva";
        System.out.println("\nTexto con comas: " + textoConComas);
        String[] frutas = textoConComas.split(",");
        System.out.println("Frutas separadas:");
        for (String fruta : frutas) {
            System.out.println("  - " + fruta);
        }
    }
}
