package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 9: ?Cual es la salida al siguiente programa? - RESUELTO
 * 
 * RESPUESTA: La salida es "Soy la clase hija con valor 0"
 * 
 * Explicacion:
 * - Cuando se crea una instancia de Hija sin parametros, Java busca un constructor sin parametros
 * - Si no existe en Hija, busca en la clase padre (Padre)
 * - Padre tiene un constructor sin parametros que inicializa x = 0
 * - Java llama automaticamente al constructor del padre antes del constructor de la hija
 * - La clase hija no necesita definir constructor explicitamente si el padre tiene constructor sin parametros
 * 
 * @author Agustin. A. Marquez. Pina
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio9_HerenciaConstructores_RESUELTO {
    // Clase Padre
    static class Padre {
        private int x;
        
        public Padre(int x) {
            this.x = x;
        }
        
        public Padre() {
            this.x = 0;  // Constructor sin parametros
        }
    }
    
    // Clase Hija
    static class Hija extends Padre {
        private int h = 0;
        
        // No hay constructor explicito, Java usa el constructor por defecto
        // que llama automaticamente a super() (constructor sin parametros del padre)
        
        public String toString() {
            return "Soy la clase hija con valor " + this.h;
        }
        
        public static void main(String[] args) {
            Hija h = new Hija();
            System.out.println(h);  // Imprime: "Soy la clase hija con valor 0"
        }
    }
}
