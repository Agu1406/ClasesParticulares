package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * <p><b>OBJETIVO:</b> En Programacion en Java busca la primera a, la palabra Java y la z con indexOf, y comprueba contains de Java y de Python.</p>
 *
 * <br>
 *
 * <p><b>SOLUCIÓN:</b> indexOf devuelve la posicion o -1 si no esta. contains devuelve true para Java y false para Python.</p>
 *
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class E06_IndexOfYContains_Resuelto {
    public static void main(String[] args) {
        String texto = "Programacion en Java";
        int posicionA = texto.indexOf('a');
        System.out.println("La primera 'a' esta en la posicion: " + posicionA);
        int posicionJava = texto.indexOf("Java");
        System.out.println("'Java' comienza en la posicion: " + posicionJava);
        int posicionNoEncontrado = texto.indexOf('z');
        System.out.println("Posicion de 'z' (no existe): " + posicionNoEncontrado);
        boolean contieneJava = texto.contains("Java");
        System.out.println("¿Contiene 'Java'? " + contieneJava);
        boolean contienePython = texto.contains("Python");
        System.out.println("¿Contiene 'Python'? " + contienePython);
    }
}
