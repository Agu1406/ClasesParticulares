package ev1.ut3_stringsyenvolventes.ejercicios.resueltos;

/**
 * Ejercicio 9: Usar StringBuilder
 * Crea un StringBuilder y usa las funciones append() para anadir varios strings,
 * luego convierte el resultado a String usando toString()
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/06/2025
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_StringBuilder {
    public static void main(String[] args) {
        // Crear un StringBuilder
        StringBuilder sb = new StringBuilder();
        
        // Anadir strings usando append()
        sb.append("Hola");
        sb.append(" ");
        sb.append("mundo");
        sb.append("!");
        
        // Convertir a String usando toString()
        String resultado = sb.toString();
        System.out.println("Resultado: " + resultado);
        
        // StringBuilder es mas eficiente que concatenar strings con +
        // especialmente cuando se hacen muchas operaciones
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Numeros: ");
        for (int i = 1; i <= 5; i++) {
            sb2.append(i);
            if (i < 5) {
                sb2.append(", ");
            }
        }
        System.out.println(sb2.toString());
    }
}
