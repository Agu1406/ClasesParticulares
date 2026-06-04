package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 9: ?Cual es la salida al siguiente programa?
 * 
 * Analiza el comportamiento de la herencia y los constructores en Java.
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_HerenciaConstructores {
    // Clase Padre
    static class Padre {
        private int x;
        
        public Padre(int x) {
            this.x = x;
        }
        
        public Padre() {
            this.x = 0;
        }
    }
    
    // Clase Hija
    static class Hija extends Padre {
        private int h = 0;
        
        public String toString() {
            return "Soy la clase hija con valor " + this.h;
        }
        
        public static void main(String[] args) {
            Hija h = new Hija();
            System.out.println(h);
        }
    }
}
