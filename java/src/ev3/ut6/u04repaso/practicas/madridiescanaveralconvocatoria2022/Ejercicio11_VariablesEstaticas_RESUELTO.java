package ev3.ut6.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 11: ?Que ocurrira al compilar y ejecutar el siguiente codigo? - RESUELTO
 * 
 * RESPUESTA: Se mostrara en pantalla 0
 * 
 * Explicacion:
 * - Las variables estaticas de tipo primitivo se inicializan automaticamente con valores por defecto
 * - Para int, el valor por defecto es 0
 * - No es necesario inicializar explicitamente las variables estaticas
 * - El programa compila y ejecuta correctamente, mostrando 0
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio11_VariablesEstaticas_RESUELTO {
    static int variableEstatica;  // Inicializada automaticamente a 0
    
    public static void main(String[] args) {
        System.out.println(variableEstatica);  // Imprime: 0
        
        // Las variables de clase (estaticas) y de instancia se inicializan automaticamente
        // Las variables locales NO se inicializan automaticamente
    }
}
