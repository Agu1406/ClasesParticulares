package madrid.iescanaveral.ejercicios.resueltos;

/**
 * Ejercicio 9: ¿Cuál es la salida al siguiente programa? - RESUELTO
 * 
 * RESPUESTA: La salida es "Soy la clase hija con valor 0"
 * 
 * Explicación:
 * - Cuando se crea una instancia de Hija sin parámetros, Java busca un constructor sin parámetros
 * - Si no existe en Hija, busca en la clase padre (Padre)
 * - Padre tiene un constructor sin parámetros que inicializa x = 0
 * - Java llama automáticamente al constructor del padre antes del constructor de la hija
 * - La clase hija no necesita definir constructor explícitamente si el padre tiene constructor sin parámetros
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://agu1406.github.io/ClasesParticulares">GitHub Pages</a>
 */
public class Ejercicio9_HerenciaConstructores_RESUELTO {
    // Clase Padre
    static class Padre {
        private int x;
        
        public Padre(int x) {
            this.x = x;
        }
        
        public Padre() {
            this.x = 0;  // Constructor sin parámetros
        }
    }
    
    // Clase Hija
    static class Hija extends Padre {
        private int h = 0;
        
        // No hay constructor explícito, Java usa el constructor por defecto
        // que llama automáticamente a super() (constructor sin parámetros del padre)
        
        public String toString() {
            return "Soy la clase hija con valor " + this.h;
        }
        
        public static void main(String[] args) {
            Hija h = new Hija();
            System.out.println(h);  // Imprime: "Soy la clase hija con valor 0"
        }
    }
}
