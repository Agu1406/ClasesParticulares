package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 5: ?Cual es la salida del siguiente codigo? - RESUELTO
 * 
 * RESPUESTA: MAYO
 * 
 * Explicacion:
 * - Cuando se imprime un enum con System.out.println(), se llama automaticamente a toString()
 * - El metodo toString() de Enum devuelve el nombre de la constante (MAYO en este caso)
 * - El campo 'numero' no se muestra a menos que se sobrescriba toString()
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio5_EnumBasico_RESUELTO {
    public enum Mes {
        ENERO(1), FEBRERO(2), MARZO(3), ABRIL(4), MAYO(5), JUNIO(6), 
        JULIO(7), AGOSTO(8), SEPTIEMBRE(9), OCTUBRE(10), NOVIEMBRE(11), DICIEMBRE(12);
        
        private final int numero;
        
        Mes(int numero) {
            this.numero = numero;
        }
        
        // Si queremos mostrar el numero, podemos sobrescribir toString()
        // @Override
        // public String toString() {
        //     return name() + "(" + numero + ")";
        // }
    }
    
    public static void main(String[] args) {
        Mes mes1 = Mes.MAYO;
        System.out.println(mes1);  // Imprime: MAYO
        
        // Para acceder al numero:
        // System.out.println(mes1.numero);  // Imprime: 5
    }
}
