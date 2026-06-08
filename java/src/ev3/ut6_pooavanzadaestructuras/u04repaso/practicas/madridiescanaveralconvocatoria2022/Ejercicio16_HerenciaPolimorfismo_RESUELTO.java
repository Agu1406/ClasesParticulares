package ev3.ut6_pooavanzadaestructuras.u04repaso.practicas.madridiescanaveralconvocatoria2022;

/**
 * Ejercicio 16: Dado el siguiente fragmento de codigo, indicar cual es correcta - RESUELTO
 * 
 * RESPUESTA: No compilara por la linea p.pasarCurso();
 * 
 * Explicacion:
 * - p es una referencia de tipo Persona
 * - Aunque apunta a un objeto Alumno, solo puede acceder a metodos definidos en Persona
 * - pasarCurso() esta definido solo en Alumno, no en Persona
 * - El compilador no permite llamar a metodos que no estan en el tipo de la referencia
 * - Para llamar a pasarCurso(), necesitarias hacer un casting: ((Alumno)p).pasarCurso()
 * 
 * @author Agustin. A. Marquez. Pina
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
        
        // ERROR DE COMPILACION: p.pasarCurso();
        // La referencia p es de tipo Persona, y pasarCurso() no esta en Persona
        
        // SOLUCION: Hacer casting
        if (p instanceof Alumno) {
            ((Alumno) p).pasarCurso();
        }
        
        System.out.print(p.darEdad());  // Si se corrige, imprime: 16
    }
}
