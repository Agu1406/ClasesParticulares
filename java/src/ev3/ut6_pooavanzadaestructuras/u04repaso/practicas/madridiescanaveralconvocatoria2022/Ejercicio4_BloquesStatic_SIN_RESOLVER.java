package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 4: Dado el siguiente codigo, ?es correcto o presenta errores en tiempo de compilacion o ejecucion?
 * 
 * Analiza el uso de bloques static y la inicializacion de arrays estaticos.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_BloquesStatic_SIN_RESOLVER {
    private static final int MAX_INTERVALOS = 14;
    private static Intervalo[] intervalos = null;
    
    public Ejercicio4_BloquesStatic_SIN_RESOLVER() {
        Ejercicio4_BloquesStatic_SIN_RESOLVER.intervalos = new Intervalo[Ejercicio4_BloquesStatic_SIN_RESOLVER.MAX_INTERVALOS];
    }
    
    static {
        Intervalo first = new Intervalo(2, 4);
        Ejercicio4_BloquesStatic_SIN_RESOLVER.intervalos[0] = first;
        Intervalo aux = null;
        for (int i = 1; i < Ejercicio4_BloquesStatic_SIN_RESOLVER.MAX_INTERVALOS; i++) {
            aux = Ejercicio4_BloquesStatic_SIN_RESOLVER.intervalos[i - 1].copia();
            aux.desplazar(3);
            Ejercicio4_BloquesStatic_SIN_RESOLVER.intervalos[i] = aux;
        }
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Intervalo i : Ejercicio4_BloquesStatic_SIN_RESOLVER.intervalos) {
            sb.append(i + "\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Ejercicio4_BloquesStatic_SIN_RESOLVER ps = new Ejercicio4_BloquesStatic_SIN_RESOLVER();
        System.out.println(ps);
    }
}

// Clase Intervalo (necesaria para el ejercicio)
class Intervalo {
    private int inicio;
    private int fin;
    
    public Intervalo(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public Intervalo copia() {
        return new Intervalo(this.inicio, this.fin);
    }
    
    public void desplazar(int cantidad) {
        this.inicio += cantidad;
        this.fin += cantidad;
    }
    
    public String toString() {
        return "[" + inicio + ", " + fin + "]";
    }
}
