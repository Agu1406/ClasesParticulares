package ev3.ut6.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 3: ?Cual es la salida del siguiente programa?
 * 
 * Analiza el orden de inicializacion de variables y metodos en Java.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio3_InicializacionVariables_SIN_RESOLVER {
    private int i = dameJ();
    private int j = 10;
    
    private int dameJ() {
        return j;
    }
    
    public static void main(String[] args) {
        System.out.println((new Ejercicio3_InicializacionVariables_SIN_RESOLVER()).i);
    }
}
