package ev3.ut6.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 4: Dado el siguiente codigo, ?es correcto o presenta errores? - RESUELTO
 * 
 * RESPUESTA: No, porque daria una excepcion java.lang.NullPointerException cuando se intenta 
 * acceder a una posicion del array en el bloque de codigo static.
 * 
 * Explicacion:
 * - El bloque static se ejecuta ANTES del constructor
 * - En el bloque static, 'intervalos' es null
 * - Al intentar acceder a intervalos[0], se produce NullPointerException
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio4_BloquesStatic_RESUELTO {
    private static final int MAX_INTERVALOS = 14;
    private static IntervaloResuelto[] intervalos = null;
    
    // SOLUCION: Inicializar el array ANTES del bloque static
    // Opcion 1: Inicializar directamente
    // private static IntervaloResuelto[] intervalos = new IntervaloResuelto[MAX_INTERVALOS];
    
    // Opcion 2: Inicializar en el bloque static ANTES de usarlo
    static {
        // Primero inicializar el array
        intervalos = new IntervaloResuelto[Ejercicio4_BloquesStatic_RESUELTO.MAX_INTERVALOS];
        
        // Ahora si podemos usarlo
        IntervaloResuelto first = new IntervaloResuelto(2, 4);
        intervalos[0] = first;
        IntervaloResuelto aux = null;
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
        for (IntervaloResuelto i : intervalos) {
            sb.append(i + "\n");
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        Ejercicio4_BloquesStatic_RESUELTO ps = new Ejercicio4_BloquesStatic_RESUELTO();
        System.out.println(ps);
    }
}

// Clase IntervaloResuelto
class IntervaloResuelto {
    private int inicio;
    private int fin;
    
    public IntervaloResuelto(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }
    
    public IntervaloResuelto copia() {
        return new IntervaloResuelto(this.inicio, this.fin);
    }
    
    public void desplazar(int cantidad) {
        this.inicio += cantidad;
        this.fin += cantidad;
    }
    
    public String toString() {
        return "[" + inicio + ", " + fin + "]";
    }
}
