package madrid.iescanaveral.ejercicios.resueltos;

/**
 * Ejercicio 4: Dado el siguiente código, ¿es correcto o presenta errores? - RESUELTO
 * 
 * RESPUESTA: No, porque daría una excepción java.lang.NullPointerException cuando se intenta 
 * acceder a una posición del array en el bloque de código static.
 * 
 * Explicación:
 * - El bloque static se ejecuta ANTES del constructor
 * - En el bloque static, 'intervalos' es null
 * - Al intentar acceder a intervalos[0], se produce NullPointerException
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio4_BloquesStatic_RESUELTO {
    private static final int MAX_INTERVALOS = 14;
    private static Intervalo[] intervalos = null;
    
    // SOLUCIÓN: Inicializar el array ANTES del bloque static
    // Opción 1: Inicializar directamente
    // private static Intervalo[] intervalos = new Intervalo[MAX_INTERVALOS];
    
    // Opción 2: Inicializar en el bloque static ANTES de usarlo
    static {
        // Primero inicializar el array
        intervalos = new Intervalo[Ejercicio4_BloquesStatic_RESUELTO.MAX_INTERVALOS];
        
        // Ahora sí podemos usarlo
        Intervalo first = new Intervalo(2, 4);
        intervalos[0] = first;
        Intervalo aux = null;
        for (int i = 1; i < Ejercicio4_BloquesStatic_RESUELTO.MAX_INTERVALOS; i++) {
            aux = intervalos[i - 1].copia();
            aux.desplazar(3);
            intervalos[i] = aux;
        }
    }
    
    public Ejercicio4_BloquesStatic_RESUELTO() {
        // El constructor ya no necesita inicializar el array
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Intervalo i : intervalos) {
            sb.append(i + "\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Ejercicio4_BloquesStatic_RESUELTO ps = new Ejercicio4_BloquesStatic_RESUELTO();
        System.out.println(ps);
    }
}

// Clase Intervalo
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
