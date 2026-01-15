package general.strings.resueltos;

/**
 * Ejercicio 9: Usar StringBuilder
 * Crea un StringBuilder y usa los métodos append() para añadir varios strings,
 * luego convierte el resultado a String usando toString()
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio9_StringBuilder {
    public static void main(String[] args) {
        // Crear un StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // Añadir strings usando append()
        sb.append("Hola");
        sb.append(" ");
        sb.append("mundo");
        sb.append("!");
        
        // Convertir a String usando toString()
        String resultado = sb.toString();
        System.out.println("Resultado: " + resultado);
        
        // StringBuilder es más eficiente que concatenar strings con +
        // especialmente cuando se hacen muchas operaciones
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Números: ");
        for (int i = 1; i <= 5; i++) {
            sb2.append(i);
            if (i < 5) {
                sb2.append(", ");
            }
        }
        System.out.println(sb2.toString());
    }
}
