package madrid.iescanaveral.ejercicios.resueltos;

/**
 * Ejercicio 3: ¿Cuál es la salida del siguiente programa? - RESUELTO
 * 
 * RESPUESTA: No da ningún error de compilación y produce como salida el valor 0.
 * 
 * Explicación:
 * - Cuando se inicializa 'i', se llama a dameJ()
 * - En ese momento, 'j' aún no ha sido inicializada (tiene valor por defecto 0)
 * - Por lo tanto, dameJ() retorna 0
 * - Luego 'j' se inicializa con 10, pero 'i' ya tiene el valor 0
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio3_InicializacionVariables_RESUELTO {
    private int i = dameJ();
    private int j = 10;
    
    private int dameJ() {
        return j;  // j tiene valor 0 (valor por defecto) en este momento
    }
    
    public static void main(String[] args) {
        Ejercicio3_InicializacionVariables_RESUELTO obj = new Ejercicio3_InicializacionVariables_RESUELTO();
        System.out.println(obj.i);  // Imprime 0
        System.out.println(obj.j);  // Imprime 10
    }
}
