package madrid.iescanaveral.ejercicios.convocatoria2022;

/**
 * Ejercicio 16: Dado el siguiente fragmento de código, indicar cuál es correcta - RESUELTO
 * 
 * RESPUESTA: No compilará por la línea p.pasarCurso();
 * 
 * Explicación:
 * - p es una referencia de tipo Persona
 * - Aunque apunta a un objeto Alumno, solo puede acceder a métodos definidos en Persona
 * - pasarCurso() está definido solo en Alumno, no en Persona
 * - El compilador no permite llamar a métodos que no están en el tipo de la referencia
 * - Para llamar a pasarCurso(), necesitarías hacer un casting: ((Alumno)p).pasarCurso()
 * 
 * @author Agustín. A. Marquez. Piña
 * @since 14/01/2026
 * @see <a href="mailto:agu1406@outlook.es">agu1406@outlook.es</a>
 * @see <a href="https://github.com/Agu1406/ClasesParticulares">Repositorio GitHub</a>
 * @see <a href="https://www.agustinmarquez.dev">Sitio web</a>
 */
public class Ejercicio16_HerenciaPolimorfismo_RESUELTO {
    // Clase Persona
    static class Persona {
        private int edad;
        
        public Persona(int edad) {
            this.edad = edad;
        }
        
        public void incrementarEdad() {
            this.edad++;
        }
        
        public int darEdad() {
            return this.edad;
        }
    }
    
    // Clase Alumno
    static class Alumno extends Persona {
        private int curso;
        
        public Alumno(int edad) {
            super(edad);
            this.curso = 1;
        }
        
        public void pasarCurso() {
            this.curso++;
            this.incrementarEdad();
        }
    }
    
    public static void main(String[] args) {
        Persona p = new Persona(28);
        System.out.print(p.darEdad() + " - ");  // Imprime: 28 -
        
        p = new Alumno(15);  // p ahora apunta a un Alumno, pero es referencia Persona
        
        // ERROR DE COMPILACIÓN: p.pasarCurso();
        // La referencia p es de tipo Persona, y pasarCurso() no está en Persona
        
        // SOLUCIÓN: Hacer casting
        if (p instanceof Alumno) {
            ((Alumno) p).pasarCurso();
        }
        
        System.out.print(p.darEdad());  // Si se corrige, imprime: 16
    }
}
