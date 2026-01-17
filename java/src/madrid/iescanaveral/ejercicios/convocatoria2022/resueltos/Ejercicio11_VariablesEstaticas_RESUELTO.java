package madrid.iescanaveral.ejercicios.convocatoria2022.resueltos;

/**
 * Ejercicio 11: ¿Qué ocurrirá al compilar y ejecutar el siguiente código? - RESUELTO
 * 
 * RESPUESTA: Se mostrará en pantalla 0
 * 
 * Explicación:
 * - Las variables estáticas de tipo primitivo se inicializan automáticamente con valores por defecto
 * - Para int, el valor por defecto es 0
 * - No es necesario inicializar explícitamente las variables estáticas
 * - El programa compila y ejecuta correctamente, mostrando 0
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio11_VariablesEstaticas_RESUELTO {
    static int variableEstatica;  // Inicializada automáticamente a 0
    
    public static void main(String[] args) {
        System.out.println(variableEstatica);  // Imprime: 0
        
        // Las variables de clase (estáticas) y de instancia se inicializan automáticamente
        // Las variables locales NO se inicializan automáticamente
    }
}
