package madrid.iescanaveral.ejercicios;

/**
 * Ejercicio 5: ¿Cuál es la salida del siguiente código?
 * 
 * Analiza el comportamiento de los enums en Java y el método toString().
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio5_EnumBasico {
    public enum Mes {
        ENERO(1), FEBRERO(2), MARZO(3), ABRIL(4), MAYO(5), JUNIO(6), 
        JULIO(7), AGOSTO(8), SEPTIEMBRE(9), OCTUBRE(10), NOVIEMBRE(11), DICIEMBRE(12);
        
        private final int numero;
        
        Mes(int numero) {
            this.numero = numero;
        }
    }
    
    public static void main(String[] args) {
        Mes mes1 = Mes.MAYO;
        System.out.println(mes1);
    }
}
